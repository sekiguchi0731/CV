import java.awt.*;

public class WhiteEdge {

    public static MyImage execute(MyImage input, MyImage image01, int k) {
        int width = input.width;
        int height = input.height;
        MyImage output = new MyImage(width, height);
        // ずらし後クロマキー画像
        MyImage image02 = new MyImage(width, height);
        image02 = Zurashi(image01, k);

        String path = "./images/forPKB/paper.jpg";
        MyImage image1 = JpegFileReader.read(path);
        Size.execute(image1);
        Size.execute(input);
        

        for (int i = 0; i < height;i++) {
            for (int j = 0;j < width;j++) {
                Color color;
                if (image02.getColor(j, i).getRed() > 1) { // 大きいクロマキーが黒でないなら
                    if (image01.getColor(j, i).getRed() > 1) { // 小さいクロマキーも黒でないなら
                        color = input.getColor(j, i);
                    } else { // 小さいほうは黒でないなら新聞
                        color = image1.getColor(j, i);
                    }

                } else {color = Color.BLACK;}
                output.setColor(j, i, color);            
            }
        }

        // output = image02;
        return output;
    }

    static MyImage Zurashi( MyImage image01, int k) {
        int width = image01.width;
        int height = image01.height;
        MyImage output = new MyImage(width, height);
        MyImage[] images = new MyImage[4];

        // 左ずらし
        images[0] = Cut.execute(image01, width - k, height, k - 1, 0);
        images[0] = AddWhite.excecute(images[0], width, height, 0, 0);
        // 右ずらし
        images[1] = AddWhite.excecute(image01, width + k, height, k - 1, 0);
        images[1] = Cut.execute(images[1], width, height, 0, 0);
        // 上ずらし
        images[2] = Cut.execute(image01, width, height - k, 0, k - 1);
        images[2] = AddWhite.excecute(images[2], width, height, 0, 0);
        // 下ずらし
        images[3] = AddWhite.excecute(image01, width, height + k, 0, k - 1);
        images[3] = Cut.execute(images[3], width, height, 0, 0);
        // Size.execute(images[0]);
        System.err.println("a");
        Size.execute(images[1]);
        

        output = Or.execute(images, 4);

        JpegFileWriter.write("./images/forPKB/j2.jpg", output);

        return output;
    }
}
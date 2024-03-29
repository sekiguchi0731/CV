import java.awt.*;


public class TilingX {

    // 画像の大きさとfileの置き場所、縦に配置するfile数、横に配置するfile数をもらって正方形にして、並べる
	static MyImage execute(int height, int width, String basePath, int n, int m) { 

        // 読み込み用画像メモリ
        MyImage[] images = new MyImage[n*m];
        // 正方形の大きさ
        // width, height, n, mは調整する必要あり
        int dwidth = width / m;
        // 書き込み用
		MyImage output = new MyImage(width, height);

        // for文を使って画像を読み込む
        for (int i = 1; i <= n*m; i++) {
            String filename = basePath + i + ".jpg";
            images[i - 1] = JpegFileReader.read(filename);
            System.err.println("name:"+ (i-1));
            int w = images[i-1].width;
            int h = images[i-1].height;
            int sml = (w >= h) ? h : w;

            // 正方形
            images[i - 1] = ScaleEX.execute(images[i-1], (double)dwidth/sml, (double)dwidth/sml);
            images[i - 1] = Cut.execute(images[i-1], dwidth, dwidth, 0, 0);
        }

        System.err.println("a" + dwidth);
        System.err.println("a" + width);
        System.err.println("b" + 101/dwidth);

        for (int i = 0;i < height; i++) {
            for (int j = 0;j < width;j++) {

                Color color = images[j/dwidth + (i/dwidth)* (width / dwidth)].getColor(j % dwidth, i % dwidth);
                output.setColor(j, i, color);
            }
        }

		return output;

	}

}

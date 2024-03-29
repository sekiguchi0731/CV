import java.awt.*;

public class And {

    public static MyImage execute(MyImage[] images, int n) {
        int width, height;
        // 小さい方を採用
        width = images[0].width;
        height = images[0].height;

        MyImage output = new MyImage(width, height);

        for (int i = 0;i < height;i++) {
            for (int j = 0;j < width;j++) {
                Color[] colors = new Color[n];
                double r = 1, g = 1, b = 1;
                for (int ii = 0;ii < n;ii++) {
                    colors[ii] = images[ii].getColor(j, i);
                    r = r*colors[ii].getRed();
                    g = g*colors[ii].getGreen();
                    b = b*colors[ii].getBlue();
                }
                try {
                    int r2 = (int)Math.pow(r, 1.0/n);
                    int g2 = (int)Math.pow(g, 1.0/n);
                    int b2 = (int)Math.pow(b, 1.0/n);
                    Color color = new Color(r2 , g2, b2);
                    // Color color = color1*color2;
                    output.setColor(j, i, color);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println("r:"+r);
                }
                
            }
        }

        return output;
    }
}
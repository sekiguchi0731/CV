import java.awt.*;

public class Or {

    public static MyImage execute(MyImage[] images, int n) {
        int width, height;
        // 小さい方を採用
        width = images[0].width;
        height = images[0].height;

        MyImage output = new MyImage(width, height);
        
        for (int i = 0;i < height;i++) {
            for (int j = 0;j < width;j++) {

                Color[] colors = new Color[n];
                int r = 0, g = 0, b = 0;
                for (int ii = 0;ii < n;ii++) {
                    colors[ii] = images[ii].getColor(j, i);
                    if (colors[ii].getRed() > 254) {
                        r = 255;
                        g = 255;
                        b = 255;
                    } else {
                        r = r + colors[ii].getRed()/n;
                        g = g + colors[ii].getGreen()/n;
                        b = b + colors[ii].getBlue()/n;
                    }
                }
                try {
                    Color color = new Color(r, g, b);
                    output.setColor(j, i, color);
                } catch (Exception e) {
                    System.err.println("r:"+r);
                }  
            }
        }

        return output;
    }
}
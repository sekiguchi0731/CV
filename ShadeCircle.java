import java.awt.*;

public class ShadeCircle {

    public static MyImage excecute(MyImage input, int orix, int oriy, int radius, int ANGLE) {
        int width = input.width;
        int height = input.height;
        MyImage output = new MyImage(width, height);
        
        // 画像処理系はy軸反転より、ANGLEも-ANGLE
        double theta = Math.toRadians(-ANGLE);
       
        double alpha = 0.975;

        // 比例定数
        double a = 255.0/Math.log10(radius*radius+1.0);

        System.err.println(a);
        for (int i = 0;i < height;i++) {
            for (int j = 0;j < width;j++) {
                int dx = Math.abs(orix - j);
                int dy = Math.abs(oriy - i);
                // 円内なら
                if(dx*dx + dy*dy <= radius*radius) {
                    // 円の中心に近いほど黒い
                    // int rgb = 255*(dx*dx + dy*dy)/radius/radius;
                    // double r = a*(dx*dx+dy*dy)*(dx*dx+dy*dy);
                    // int rgb  = (int)(a*(dx*dx+dy*dy)*(dx*dx+dy*dy));
                    double rgb = a*Math.log10((dx*dx+dy*dy+1.0));
                    // double drgb = (255.0 - rgb)/255.0;
                    double drgb = rgb/255.0;
                    Color color0 = input.getColor(j, i);
                    int r = color0.getRed();
                    int g = color0.getGreen();
                    int b = color0.getBlue();
                    Color color = new Color((int)(r*drgb*alpha), (int)(g*drgb*alpha), (int)(b*drgb*alpha));
                    int jj = roteX(width, theta, j, i);
                    output.setColor(jj, i, color);
                    
                } else {
                    // 円外なら白
                    Color color = input.getColor(j, i);
                    output.setColor(j, i, color);
                }
            }
        }

        return output;

    }

    // tan(theta)分回転
    static int roteX (int width, double theta, int x, int y) {
        int xx = 0;

        xx = x + y*(int)Math.tan(theta);

        // 枠外なら修正
        if(xx < 0) xx = 0;
        if(xx > width) xx = width;

        return xx;
    }
}
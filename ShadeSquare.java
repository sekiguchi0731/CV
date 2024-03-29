import java.awt.*;

public class ShadeSquare {

    // 入力画像、初期座標、影の大きさ、傾き
    public static MyImage excecute(MyImage input, int orix, int oriy, int ww, int hh, int ANGLE) {
        int width = input.width;
        int height = input.height;
        MyImage output = new MyImage(width, height);

        // 中心
        int n = orix+ww/2;
        int m = oriy+hh/2;
        // 一番長い辺
        int l = Math.abs(orix-n)*Math.abs(orix-n)+Math.abs(oriy-m)*Math.abs(oriy-m);
        
        // 画像処理系はy軸反転より、ANGLEも-ANGLE
        double theta = Math.toRadians(-ANGLE);
       
        double alpha = 0.99;

        // 比例定数
        double a = 255.0/Math.log10(l+1.0);

        boolean[][] isColor = new boolean[width][height];

        System.err.println(a);
        for (int i = 0;i < height;i++) {
            for (int j = 0;j < width;j++) {

                int jj = roteX(width, theta, j, i);
                
                // 四角形内なら
                if((orix < j)&&(j < (orix+ww))&&(oriy < i)&&(i<oriy+hh)) {
                    // 円の中心に近いほど黒い
                    int dx = Math.abs(n - j);
                    int dy = Math.abs(m - i);
                  
                    double rgb = a*Math.log10((dx*dx+dy*dy+1.0));
                    
                    double drgb = rgb/255.0;
                    Color color0 = input.getColor(jj, i);
                    int r = color0.getRed();
                    int g = color0.getGreen();
                    int b = color0.getBlue();
                    try {
                        Color color = new Color((int)(r*drgb*alpha), (int)(g*drgb*alpha), (int)(b*drgb*alpha));
                        isColor[jj][i] = true;
                        output.setColor(jj, i, color);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.err.println(r*drgb*alpha);
                        System.err.println(dx*dx+dy*dy);
                        System.err.println("x:"+j+"y:"+i);
                    }

                    if(!isColor[j][i]) {
                        Color color = input.getColor(j, i);
                        output.setColor(j, i, color);
                    }
                    
                } else {
                    // 円外ならそのまま
                    Color color = input.getColor(j, i);
                    output.setColor(j, i, color);
                }
            }
        }
        System.err.println(n);
        System.err.println(l);
        return output;

    }

    // tan(theta)分回転
    static int roteX (int width, double theta, int x, int y) {
        int xx = 0;

        if (x == width - 1) xx = x;

        xx = (int)(x + y*Math.tan(theta));

        // 枠外なら修正
        if(xx < 0) xx = 0;
        if(xx >= width) xx = width - 1;

        return xx;
    }
}
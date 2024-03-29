import java.awt.*;
import java.lang.Math;

public class Rotation {
	static double SCALEX = 1.0, SCALEY = 1.0;
	static int ANGLE =  30;
    // 画像処理系はy軸反転より、ANGLEも-ANGLE
    static double theta = Math.toRadians(-ANGLE);
    static double theta_r = Math.toRadians(ANGLE);
	

	static MyImage execute(MyImage input) {
		int width1, height1, i, j;
        int width3, height3;
        // (0,0),(width, 0), (0, height), (width, height)
        Tuple LeBt = new Tuple();
        Tuple RiBt = new Tuple();
        Tuple nRiBt = new Tuple();
        Tuple LeTp = new Tuple();
        Tuple nLeTp = new Tuple();
        Tuple RiTp = new Tuple();

		width1 = input.width;
		height1 = input.height;
        LeBt.x = 0; LeBt.y = 0;
        RiBt.x = width1; RiBt.y = 0;
        LeTp.x = 0; LeTp.y = height1;
        RiTp.x = width1; RiTp.y = height1;

        nRiBt.x = (int)(roteX(RiBt.x, RiBt.y, theta));
        nRiBt.y = (int)(roteY(RiBt.x, RiBt.y, theta));
        nLeTp.x = (int)(roteX(LeTp.x, LeTp.y, theta));
        nLeTp.y = (int)(roteY(LeTp.x, LeTp.y, theta));
        ANGLE = ANGLE % 180;
        if(0 <= ANGLE && ANGLE <= 45 || ANGLE >=135 && ANGLE <= 180) { // 縦横そのまま
            width3 = (int)LeBt.norm(nRiBt);
            height3 = (int)LeBt.norm(nLeTp);
            System.out.println("1,3"+ ANGLE);
        } else { // 縦横入れ替え
            width3 = (int)LeBt.norm(nLeTp);
            height3 = (int)LeBt.norm(nRiBt);
            System.out.println("2,4");
        }
        
		MyImage output = new MyImage(width3, height3);
        // System.out.println(width1+":"+width3);
        // System.out.println(height1+":"+height3);
        System.out.println(nRiBt.y);
        System.out.println(ANGLE);
	
        int x1=0, y1=0;
        for(i = 0; i < height3;i++) {
            for(j = 0;j < width3;j++) {
                // x1, y1;

                // 変換後の座標が返される
                // not 汎用
                x1 = roteX(j+nRiBt.x, i+nLeTp.y, theta_r);
                y1 = roteY(j+nRiBt.x, i+nLeTp.y, theta_r);
                // if(x1<=0|| y1<=0) {
                //     System.out.println(x1+ ":"+ y1);
                // }

                calcRGB(input, output, x1, y1, j, i);

            }
        }	

		return output;

	}

    static int roteX(int orix, int oriy, double theta) {
        int edx = 0;

        edx = (int)(orix * Math.cos(theta)) - (int)(oriy * Math.sin(theta));

        return edx;
    }

    static int roteY(int orix, int oriy, double theta) {
        int edy = 0;

        edy = (int)(orix * Math.sin(theta)) + (int)(oriy * Math.cos(theta));
        // System.out.println(edy);

        return edy;
    }

	
	static double calcX(int x2, int y2, int width1, int height1) {
		double x = 0.0;

        // 行を逆数倍する
		x = x2 / SCALEX;

		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	static double calcY(int x2, int y2, int width1, int height1) {
		double y = 0.0;

        // 列を逆数倍
		y = y2 / SCALEY;

		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}



    // x1:変換後, x2:outputの指定する場所
	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

        // 変換後の行は整数とは限らない
        // 最も近いintに変換
		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}

}

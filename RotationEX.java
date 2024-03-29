import java.awt.*;
import java.lang.Math;


public class RotationEX {
    static double SCALEX = 1.0, SCALEY = 1.0;

	static Result execute(MyImage input, int ANGLE) {
        // 画像処理系はy軸反転より、ANGLEも-ANGLE
        double theta = Math.toRadians(-ANGLE);
        double theta_r = Math.toRadians(ANGLE);
		int width1, height1, i, j;
        int width3, height3, maxX, minX, maxY, minY;
        // (0,0),(width, 0), (0, height), (width, height)
        Tuple LeBt = new Tuple();
        Tuple RiBt = new Tuple();
        Tuple nRiBt = new Tuple();
        Tuple LeTp = new Tuple();
        Tuple nLeBt = new Tuple();
        Tuple RiTp = new Tuple();
        Tuple nRiTp = new Tuple();

		width1 = input.width;
		height1 = input.height;
        LeBt.x = 0; LeBt.y = height1;
        RiBt.x = width1; RiBt.y = height1;
        LeTp.x = 0; LeTp.y = 0;
        RiTp.x = width1; RiTp.y = 0;

        nRiBt.x = (int)(roteX(RiBt.x, RiBt.y, theta));
        nRiBt.y = (int)(roteY(RiBt.x, RiBt.y, theta));
        nRiTp.x = (int)(roteX(RiTp.x, RiTp.y, theta));
        nRiTp.y = (int)(roteY(RiTp.x, RiTp.y, theta));
        nLeBt.x = (int)(roteX(LeBt.x, LeBt.y, theta));
        nLeBt.y = (int)(roteY(LeBt.x, LeBt.y, theta));

        // 周期性
        ANGLE = ANGLE % 360;

        // (一番大きいX/Y座標)-(一番小さいX/Y座標)
        maxX = Math.max(nRiBt.x, Math.max(nRiTp.x, Math.max(nLeBt.x, 0)));
        maxY =  Math.max(nRiBt.y, Math.max(nRiTp.y, Math.max(nLeBt.y, 0)));
        minX = Math.min(nRiBt.x, Math.min(nRiTp.x, Math.min(nLeBt.x, 0)));
        minY = Math.min(nRiBt.y, Math.min(nRiTp.y, Math.min(nLeBt.y, 0)));

        width3 = maxX - minX;
        height3 = maxY - minY;
        
		MyImage output = new MyImage(width3, height3);
	
        int x1=0, y1=0, k=0;
        int[] d = new int[4];
        for(i = 0; i < height3;i++) {
            for(j = 0;j < width3;j++) {
                // x1, y1;

                // 変換後の座標が返される
                x1 = roteX(j+minX, i+minY, theta_r);
                y1 = roteY(j+minX, i+minY, theta_r);
                if(i==0&&j==0 || i==height3-1&&j==width3-1) {
                    d[k] = x1;  d[k+1] = y1;
                    k += 2;
                    System.err.println(x1+"+"+y1);
                }

                calcRGB(input, output, x1, y1, j, i);

            }
        }	

		return new Result(output, minX, minY, maxX, maxY, d);

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
        Color color;
        // 変換後の行は整数とは限らない
        // 最も近いintに変換
		int xx = (int)(x1 + 0.5);
		int yy = (int)(y1 + 0.5);

        if (xx < 0 || xx >= input.width || yy < 0 || yy >= input.height) {
            color = Color.BLACK;
        } else {
             color = input.getColor(xx, yy);
        }

		output.setColor(x2, y2, color);
	
	}

}

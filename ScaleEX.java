import java.awt.*;

public class ScaleEX{

	static MyImage execute(MyImage input, double SCALEX, double SCALEY) {
		int width1, height1, width2, height2, i, j;
		
		width1 = input.width;
		height1 = input.height;
		width2 = (int)(input.width * SCALEX);
		height2 = (int)(input.height * SCALEY);
		System.err.println(width2);
		System.err.println(height2);
		MyImage output = new MyImage(width2, height2);
	
		
		for(i = 0; i < height2; i++) { // i：拡大後のパレットの画素行(x座標)
			for(j = 0; j < width2; j++) { // j：画素列
				double x1, y1, r, g, b;
				
				// 拡大後の画素(x,y)における、元の画素で対応する位置
				x1 = calcX(j, i, width1, height1, SCALEX);
				y1 = calcY(j, i, width1, height1, SCALEY);

				calcRGB(input, output, x1, y1, j, i);

			}
		}

		return output;

	}

	
	static double calcX(int x2, int y2, int width1, int height1, double SCALEX) {
		double x = 0.0;

		// 拡大後の画素行を1/n倍(つまり、元の画素行)
		x = x2 / SCALEX;

		// 計算後の値が(1/n倍した値)元の画素行からはみ出ていたら
		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	static double calcY(int x2, int y2, int width1, int height1, double SCALEY) {
		double y = 0.0;

		y = y2 / SCALEY;

		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		// 整数とは限らないので、最も近い整数に近似
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

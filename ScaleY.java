import java.awt.*;

public class ScaleY {
	static double SCALE;

	static MyImage execute(MyImage input1, MyImage input2) {
		int width1, height1, width2, height2, width3, height3, i, j;
        MyImage BigIpt, SmlIpt;
		
		width1 = input1.width;
		height1 = input1.height;
        width2 = input2.width;
        height2 = input2.height;

        BigIpt = (width1 > width2) ? input1: input2;
        SmlIpt = (width1 < width2) ? input1: input2;
        // int SCALEX  = (width1  > width2)  ? width1/width2  : width2wi;
		SCALE = (double)((double)BigIpt.width / (double)SmlIpt.width);
		width3 = (int)(SmlIpt.width * SCALE);
		height3 = (int)(SmlIpt.height * SCALE);
		
        MyImage output = Scaling(width3, height3, SmlIpt.width, SmlIpt.height, SmlIpt);

        return output;
	}
    
    // 拡大後のwidth, height, 拡大前のwidth, height, 元画像を受け取り拡大後の画像を返す
    static MyImage Scaling(int width, int height, int width1, int height1, MyImage input) {
        int i, j;
        MyImage output = new MyImage(width, height);
	
		
		for(i = 0; i < height; i++) { // i：拡大後のパレットの画素行(x座標)
			for(j = 0; j < width; j++) { // j：画素列
				double x1, y1, r, g, b;
				
				// 拡大後の画素(x,y)における、元の画素で対応する位置
				x1 = calcX(j, i, width1, height1);
				y1 = calcY(j, i, width1, height1);

				calcRGB(input, output, x1, y1, j, i);

			}
		}

		return output;
    }

	
	static double calcX(int x2, int y2, int width1, int height1) {
		double x = 0.0;

		// 拡大後の画素行を1/n倍(つまり、元の画素行)
		x = x2 / SCALE;

		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	static double calcY(int x2, int y2, int width1, int height1) {
		double y = 0.0;

		y = y2 / SCALE;

		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	static void calcRGB(MyImage input1, MyImage output, double x1, double y1, int x2, int y2) {

		// 整数とは限らないので、最も近い整数に近似
		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input1.width) xx = input1.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input1.height) yy = input1.height - 1;

		Color color = input1.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}

}

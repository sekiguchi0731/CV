import java.awt.Color;

public class CelareX {

	public static MyImage execute(MyImage input, int radius) {
        int width, height;
        width = input.width;
        height = input.height;

		MyImage output = new MyImage(width, height);
        double centerX = (double)width/2.0;
        double centerY = (double)height/2.0;
        double D = Math.sqrt(centerX*centerX+centerY*centerY) - radius;
        System.err.println(D);

        double radius2 = radius*radius;

		// i：上下方向の画素, j：左右方向の画素
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
                double dx, dy, dxy;

                dx = Math.abs(j - centerX);
                dy = Math.abs(i - centerY);

                if((dxy = dx*dx + dy*dy) < radius2) {
                    output.setColor(j, i, input.getColor(j, i));
                } else {
                    Color color1 = input.getColor(j, i);

                    int r = color1.getRed();
                    int g = color1.getGreen();
                    int b = color1.getBlue();

                    // (double)r/255 とキャストしないとうまくいかない
                    int r2 = makeCol(r, dxy, D, radius);
                    int g2 = makeCol(g, dxy, D, radius);
                    int b2 = makeCol(b, dxy, D, radius);
                    
                    Color color2 = new Color(r2, g2, b2);
                    output.setColor(j, i, color2);
                }

			}
		}
		
		return output;
	}

    static int makeCol(int col, double dxy, double D, double radius) {
        double diff = (double)col;
        int afcl;

        afcl = col - (int)(diff*((Math.sqrt(dxy)-radius)/D));
        if (afcl < 0){System.err.println(col); System.err.println(diff*((Math.sqrt(dxy)-radius)/D));}

        return afcl;
    }
}


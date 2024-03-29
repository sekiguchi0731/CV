import java.awt.Color;

public class Celare {

	public static MyImage execute(MyImage input, int radius) {
        int width, height;
        width = input.width;
        height = input.height;
        radius = radius*radius;

		MyImage output = new MyImage(width, height);
        double centerX = (double)width/2.0;
        double centerY = (double)height/2.0;
	
		// i：上下方向の画素, j：左右方向の画素
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
                double dx, dy, dxy;

                dx = Math.abs(j - centerX);
                dy = Math.abs(i - centerY);

                if((dxy = dx*dx + dy*dy) < radius) {
                    output.setColor(j, i, input.getColor(j, i));
                } else {
                    Color color1 = input.getColor(j, i);
                    double alpha = 3 - (Math.sqrt(dxy) - Math.sqrt(radius))/100;

                    if(alpha > 1) alpha = 1.0;
                    int r = color1.getRed();
                    int g = color1.getGreen();
                    int b = color1.getBlue();

                    // (double)r/255 とキャストしないとうまくいかない
                    int r2 = (int)(255.0*Math.pow((double)r/255, 1.0/alpha));
                    int g2 = (int)(255.0*Math.pow((double)g/255, 1.0/alpha));
                    int b2 = (int)(255.0*Math.pow((double)b/255, 1.0/alpha));
                    
                    Color color2 = new Color(r2, g2, b2);
                    output.setColor(j, i, color2);
                }

			}
		}
		
		return output;
	}

}


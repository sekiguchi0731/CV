
import java.awt.Color;

public class GammaCorrection {

	public static MyImage execute(MyImage input, double gR, double gG, double gB) {

		MyImage output = new MyImage(input.width, input.height);
	
		// i：上下方向の画素, j：左右方向の画素
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);

				int r = color1.getRed();
				int g = color1.getGreen();
				int b = color1.getBlue();

                // (double)r/255 とキャストしないとうまくいかない
                int r2 = (int)(255.0*Math.pow((double)r/255, 1.0/gR));
                int g2 = (int)(255.0*Math.pow((double)g/255, 1.0/gG));
                int b2 = (int)(255.0*Math.pow((double)b/255, 1.0/gB));
                
				Color color2 = new Color(r2, g2, b2);

				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

}


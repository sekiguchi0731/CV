
import java.awt.Color;


public class Gray {

	public static MyImage execute(MyImage input, int limx) {

		MyImage output = new MyImage(input.width, input.height);
	
		// i：上下方向の画素, j：左右方向の画素
		for(int i = 0; i < input.height; i++) {
            for (int j = 0;j < limx;j++) {
                Color color = input.getColor(j, i);
                output.setColor(j, i, color);
            }
			for(int j = limx; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);
                Color color2;

				int r = color1.getRed();
				int g = color1.getGreen();
				int b = color1.getBlue();

				int rgb = (r+g+b)/3;
				color2 = new Color(rgb, rgb, rgb);
				
				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

}


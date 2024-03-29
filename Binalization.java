
import java.awt.Color;


public class Binalization {

	public static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
	
		// i：上下方向の画素, j：左右方向の画素
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);
                Color color2;

				int r = color1.getRed();
				int g = color1.getGreen();
				int b = color1.getBlue();
                if(r+g+b >= 180) {color2 = new Color(255, 255, 255);}
                else {color2 = new Color(0, 0, 0);}
				
				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

}


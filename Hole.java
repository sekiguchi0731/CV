import java.awt.*;


public class Hole {

	static Tuple execute(MyImage input) { 

        int width = input.width;
        int height = input.height;

        Tuple result = new Tuple();

        boolean isResult = false;

		for(int i = 3; i < height - 30; i++) {
			for(int j = 3; j < width - 30; j++) {
                Color color = input.getColor(j, i);
                Color color2 = input.getColor(j + 10, i);
                Color color3 = input.getColor(j + 30, i + 30);
                Color color4 = input.getColor(j - 3, i - 3);

                float r = color.getRed();
                float g = color.getGreen();
                float b = color.getBlue();

                float r2 = color2.getRed();
                float g2 = color2.getGreen();
                float b2 = color2.getBlue();

                float r3 = color3.getRed();
                float g3 = color3.getGreen();
                float b3 = color3.getBlue();

                float r4 = color4.getRed();
                float g4 = color4.getGreen();
                float b4 = color4.getBlue();
				
				if((!isResult)&&(r+g+b <= 2)) {
                    
                    if ((r2 + g2 + b2 + r3 + g3 + b3 <= 2)&& (r4+g4+b4 >= 5)) {
                        System.err.println("hole:"+j+","+i);
                        result.x = j;
                        result.y = i;
                        isResult = true;
                    }
				}
			}
		}

        if (!isResult) {
            result.x = 0;
            result.y = 0;
            System.err.println("none");
        }

		return result;

	}
}

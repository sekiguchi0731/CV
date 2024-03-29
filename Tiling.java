import java.awt.*;


public class Tiling {

	static MyImage execute(MyImage input1, MyImage input2) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width = width1 + width2;
		// int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;
        // int width = (width1  > width2)  ? width1  : width2;
        // int height = height1 + height2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
                int jj = j - width1;
		
				if(i < height1 && j < width1) { // 一枚目の画像内部で
                    Color color1 = input1.getColor(j, i);
                    output.setColor(j, i, color1);
            
                    isProcessed = true;
				} else if (j < width1) {
                    output.setColor(j, i, Color.BLACK);
                    isProcessed = true;
                }
                if(i < height2 && jj < width2) { //2枚目の画像内部で
					if(isProcessed == false) { // 1枚目の色が代入されてない場合
						
						Color color2 = input2.getColor(jj, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

}

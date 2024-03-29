import java.awt.*;


public class AlphaBlending {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

        // input1：itot.png
		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;

        double alpha = 0.25;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;

        int initX = (int)width / 2 - width1 / 2;
        int initY = (int)height / 2 - height1 / 2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
                int ii = initY + i;
                int jj = initX + j;
                int iii = i - initY;
                int jjj = j - initX;
		
				if((initY < i && initX < j) && (iii < height1 && jjj < width1)) {
                    // 画素値がimage1の初期位置内部かつimage1の内部ならば
                    // iii < height1 <=> i < height1 + initY

					Color color0 = input0.getColor(jjj, iii);
					if(color0.getRed() > 0) { // クロマキー処理した色が白でない

                        Color color1 = input1.getColor(jjj, iii);
                        
                        if(i < height2 &&j < width2) { // 黒でないかつimage2の内部
                            Color color2 = input2.getColor(j, i);
                            Color color3 = makeCol(alpha, color1, color2);
                            
                            output.setColor(j, i, color3);
                        } else { // 白でないかつimage2の外部
                            output.setColor(j, i, color1);
                        }
				
						isProcessed = true;
					}
					
				}

				if(i < height2 && j < width2) {
					if(isProcessed == false) {

						Color color2 = input2.getColor(j, i);
                        
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

    static Color makeCol (double alpha, Color color1, Color color2) {
        float r1 = color1.getRed() / 255.0f;
        float g1 = color1.getGreen() / 255.0f;
        float b1 = color1.getBlue() / 255.0f;

        float r2 = color2.getRed() / 255.0f;
        float g2 = color2.getGreen() / 255.0f;
        float b2 = color2.getBlue() / 255.0f;

        float r3 = (float)(alpha * r1 + (1 - alpha) * r2);
        float g3 = (float)(alpha * g1 + (1 - alpha) * g2);
        float b3 = (float)(alpha * b1 + (1 - alpha) * b2);

        // 0から1の範囲の浮動小数点数で指定される場合、Colorクラスのコンストラクタで利用可能
        Color color = new Color(r3, g3, b3);

        return (color);
    }

}

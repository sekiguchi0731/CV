import java.awt.*;


public class AlphaBlendingX {

	static MyImage execute(MyImage input1, MyImage input2, int initX, int initY, double alpha, boolean onImg2, boolean isImg2Big) { 

        int width1, width2, height1, height2;
        // input1：itot.png
        // input1 : pol
        
        if (!isImg2Big) { // img1の方が大きいならば
            // 大きい方がwidth1
            width1 = input1.width;
            width2 = input2.width;
            height1 = input1.height;
            height2 = input2.height;
        } else {
            width1 = input2.width;
            width2 = input1.width;
            height1 = input2.height;
            height2 = input1.height;
        }

	    // 縦横比が逆転するようなものは想定外  
		int width  = width1;
		int height = height1;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
                int ii = initY + i;
                int jj = initX + j;
                int iii = i - initY;
                int jjj = j - initX;
		
                
				if((initY < i && initX < j) && (iii < height2 && jjj < width2)) {
                    // 画素値が初期位置内部かつ小さい方の内部ならば
                    // iii < height1 <=> i < height1 + initY

                    // img2の上に載せたい=img1に黒があるなら
                    Color color0 = (onImg2) ? input1.getColor(jjj, iii):input2.getColor(jjj, iii);
					
					if(color0.getRed() > 0) { // クロマキー処理した色が黒でない
                
                        Color color1;
                        if (onImg2) { // onImg2がtrue=img2が下なら
                            // input1をずらす
                            // color1が優先される
                            color1 = input1.getColor(jjj, iii);

                            if(i < height2 &&j < width2) { // 黒でないかつ小さい方の内部
                
                                Color color2 = input2.getColor(j, i);
                                Color color3 = makeCol(alpha, color1, color2);
                                
                                output.setColor(j, i, color3);
                            } else { // 黒でないかつimage2の外部
                                output.setColor(j, i, color1);
                            }
                        } else { // img1がしたなら
                            color1 = input2.getColor(jjj, iii);
                            if(i < height2 &&j < width2) { // 黒でないかつ小さい方の内部
                
                                Color color2 = input1.getColor(j, i);
                                Color color3 = makeCol(alpha, color1, color2);
                                
                                output.setColor(j, i, color3);
                            } else { // 黒でないかつimage2の外部
                                output.setColor(j, i, color1);
                            }
                        }
					}
					
                    else { // クロマキー処理した色が黒ならば
                        Color color = (onImg2) ? input2.getColor(jjj, iii):input1.getColor(jjj, iii);

                        output.setColor(j, i, color);

                    }
                    isProcessed = true;
				}

				if(i < height1 && j < width1) { // 小さい方の外部ならば
					if(isProcessed == false) { // 小さい方の色が塗ってなければ

						Color color2 = input1.getColor(j, i);
                        
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

    // color1が優先される
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

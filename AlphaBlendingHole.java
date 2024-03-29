import java.awt.*;


public class AlphaBlendingHole {

    // クロマキーで黒いマスクを持っている方が上
    // 小さい方は初期位置に従う
	static MyImage execute(MyImage input1, MyImage input2, MyImage input0, int initX, int initY, int OverImg, int BiggerImg, boolean img0IsBig) { 

        int width1, width2, height1, height2;
        // input1：itot.png
        // input1 : pol
        
        if (BiggerImg == 1) { // img1の方が大きいならば
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

	    // outputは大きい方に合わせる
		int width  = width1;
		int height = height1;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;

                int iii = i - initY;
                int jjj = j - initX;

                // 状態は
                // 優先順位高い順
                // どちらが上か どちらが大きいか
                // 小さいかつ上
		
                // 画素値が初期位置内部かつ小さい方の内部ならば
                // OverImgが黒ならOverImgでない方に従う
                // OverImgが黒でないならOverImgに従う
				if((initY < i && initX < j) && (iii < height2 && jjj < width2)) {
                    // iii < height1 <=> i < height1 + initY

                    // color0には上を覆うimgの色が入る
                    // 
                    Color color0 =  (img0IsBig) ? input0.getColor(j, i) : input0.getColor(jjj, iii);
                    // Color color0 = (OverImg==1) ? input1.getColor(jjj, iii):input2.getColor(jjj, iii);
					
                    // クロマキー処理した色が黒でない
                    // 上が黒でないなら、上の色をおく
                    // 上が小さい方か？大きい方か？で場合分け
					if(color0.getRed() + color0.getGreen() > 5) { 
                        
                        if (OverImg==1) { // input1が上←→input1に黒がある
                            //     // input1が大きい←→大きい方が上なら←→大きい方に黒があるが、今は黒でない
                            //     // ずらさず、そのまま大きい方

                            //     // input2が大きい←→input1が小さい
                            //     // ずらした上(=input1)
                            Color color1 = (BiggerImg==1) ? input1.getColor(j, i) : input1.getColor(jjj, iii);
                            output.setColor(j, i, color1);
                        } else { // input2が上

                            Color color1 = (BiggerImg==1) ? input2.getColor(jjj, iii) : input2.getColor(j, i);
                            output.setColor(j, i, color1);

                        } 
					} else { // クロマキー処理した色が黒ならば
                        if (OverImg==1) { // input1が上
                            Color color1 = (BiggerImg==1) ? input2.getColor(jjj, iii) : input2.getColor(j, i);
                            output.setColor(j, i, color1);
                        } else { // input2が上
                            Color color1 = (BiggerImg==1) ? input1.getColor(j, i) : input1.getColor(jjj, iii);
                            output.setColor(j, i, color1);

                        }
                        
                    }
                    isProcessed = true;
				}

				if(i < height1 && j < width1) { // 小さい方の外部ならば
					if(isProcessed == false) { // 小さい方の色が塗ってなければ

						Color color1 = (BiggerImg==1) ? input1.getColor(j, i):input2.getColor(j, i);
                        
						output.setColor(j, i, color1);
					}
				}
			}
		}

		return output;

	}

}

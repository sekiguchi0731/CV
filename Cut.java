import java.awt.*;

public class Cut {

    // input画像、切り取り後の幅、高さ、初期x座標、y座標を受け取って切り取り画像を返す
	static MyImage execute(MyImage input, int width, int height, int orix, int oriy) {
		int i, j;
        MyImage output = new MyImage(width, height);
		
	
        for (i = 0; i < height; i++) {
            for (j = 0; j< width; j++) {
                try {
                    Color color = input.getColor(j+orix, i+oriy);
                    output.setColor(j, i, color);
                } catch (Exception e) {
                    System.err.println(e);
                    System.err.println("j:"+j);
                    System.err.println("i:"+i);
                    break;
                    // TODO: handle exception
                }
                
            }
        }

        return output;
	}
}

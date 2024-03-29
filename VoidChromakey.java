import java.awt.*;

public class VoidChromakey {

    // クロマキーで黒いマスクを持っている方が上
    // 小さい方は初期位置に従う
	static MyImage execute(MyImage input, Tuple LeTp, Tuple RiBt) { 
        int i, j, width, height;

        width = input.width;
        height = input.height;

        MyImage output = new MyImage(width, height);

        for (i = 0;i < height;i++) {
            for (j = 0;j < width;j++) {
                if ((LeTp.y < i && i < RiBt.y) && (LeTp.x < j && j < RiBt.x)) {
                    output.setColor(j, i, Color.WHITE);
                } else {
                    Color color = input.getColor(j, i);
                    output.setColor(j, i, color);
                }
            }
        }

        return output;
    }
}

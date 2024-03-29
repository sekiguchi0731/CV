import java.awt.*;

public class CircleCut {

    public static MyImage execute(MyImage input, int orix, int oriy, int radius) {
        int width, height;

        width = input.width;
        height = input.height;

        MyImage output = new MyImage(width, height);

        for (int i = 0;i < height;i++) {
            for (int j = 0;j < width;j++) {
                int dx = Math.abs(j - orix);
                int dy = Math.abs(i - oriy);
                // 円内なら
                if (dx*dx + dy*dy <= radius*radius) {
                    Color color = input.getColor(j, i);
                    output.setColor(j, i, color);
                } else {
                    output.setColor(j, i, Color.BLACK);
                }
            }
        }

        return output;
    }
}
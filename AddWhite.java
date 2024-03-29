import java.awt.*;

public class AddWhite {

    public static MyImage excecute(MyImage input, int width, int height, int orix, int oriy) {
        int ww = input.width;
        int hh = input.height;
        MyImage output = new MyImage(width, height);

        for (int i = 0;i < oriy;i++) {
            for (int j = 0;j < orix;j++) {
                output.setColor(j, i, Color.BLACK);
            }
        }
        for (int i = oriy;i < hh + oriy;i++) {
            for (int j = orix;j < ww + orix;j++) {
                Color color = input.getColor(j-orix, i-oriy);
                output.setColor(j, i, color);
            }
        }
        for (int i = oriy + hh;i < height;i++) {
            for (int j = orix;j < ww + orix;j++) {
                output.setColor(j, i, Color.BLACK);
            }
        }

        return output;
    }
}
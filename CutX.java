import java.awt.*;

public class CutX {

    public static int[] execute(MyImage input) {
        int width, height;
        // 黒が終わる左端、右端、上端、下端
        int[] data = new int[4];

        width = input.width;
        height = input.height;

        // 縦の中点
        int n = height/2;
        // 横の中点
        int m = width/2;

        // ど真ん中左端から見ていって、黒が終わる座標
        for (int j = 0;j < width;j++) {
            Color color = input.getColor(j, n);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            if((r+g+b) > 30) { // 黒でなかったら一つ左の座標を格納
                // アンチエイリアシングによる効果のため一つ左ではなくそのままの座標を格納
                data[0] = j;
                break;
            }
        }
        // ど真ん中右端から見ていって、黒が終わる座標
        for (int j = width - 1;j >= 0;j--) {
            Color color = input.getColor(j, n);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            // if((r+g+b) != 0) { // 黒でなかったら一つ右の座標を格納
            if((r+g+b) > 30) { // 黒でなかったら一つ右の座標を格納
                data[1] = j;
                break;
            }
        }
        // ど真ん中上端から見ていって、黒が終わる座標
        for (int i = 0;i < height;i++) {
            Color color = input.getColor(m, i);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            // if((r+g+b) != 0) { // 黒でなかったら一つ上の座標を格納
            if((r+g+b) > 30) { // 黒でなかったら一つ上の座標を格納
                data[2] = i;
                break;
            }
        }
        // ど真ん中下端から見ていって、黒が終わる座標
        for (int i = height - 1;i >= 0;i--) {
            Color color = input.getColor(m, i);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            // if((r+g+b) != 0) { // 黒でなかったら一つ前の座標を格納
            if((r+g+b) > 30) { // 黒でなかったら一つ前の座標を格納
                data[3] = i;
                break;
            }
        }

        for(int i = 0;i < 4;i++) {
            System.err.println(data[i]);
        }

        return data;
    }
}
import java.awt.*;

public class Mosaic {

    public static MyImage execute(MyImage input, int ksize) {
        // カーネルサイズが偶数なら奇数にする
        if (ksize % 2 == 0) {ksize++;}

        int width, height;

        width = input.width;
        height = input.height;

        // モザイク画像用を生成
        MyImage output = new MyImage(width, height);

        // 画像をラスタスキャン（カーネルサイズ単位で移動）
        for (int y = ksize / 2; y < height + ksize / 2; y += ksize)
            for (int x = ksize / 2; x < width + ksize / 2; x += ksize) {
                // 平均計算用変数の初期化
                double sumr=0, sumg=0, sumb=0;
                // double[] sum = new double[3];
                int count = 0;

                // カーネル範囲をスキャン
                for (int dy = -ksize / 2; dy <= ksize / 2; dy++)
                    for (int dx = -ksize / 2; dx <= ksize / 2; dx++) {
                        // 画像内である場合のみ集計
                        if (x + dx < width && y + dy < height) {
                            Color color = input.getColor(x+dx, y+dy);
                            int r = color.getRed();
                            int g = color.getGreen();
                            int b = color.getBlue();
                            // int[] rgb = input.getRGB(x + dx, y + dy);
                            sumr += r; sumg += g; sumb += b;
                            count++;
                        }
                    }

                // 合計値を計算
                int meanr, meang, meanb;
                meanr = (int) Math.rint(sumr / count);
                meang = (int) Math.rint(sumg / count);
                meanb = (int) Math.rint(sumb / count);

                // カーネル範囲を再スキャン
                for (int dy = -ksize / 2; dy <= ksize / 2; dy++)
                    for (int dx = -ksize / 2; dx <= ksize / 2; dx++) {
                        // 画像内である場合のみ平均値をセット
                        if (x + dx < width && y + dy < height) {
                            Color color = new Color(meanr, meang, meanb);
                            output.setColor(x + dx, y + dy, color);
                        }
                    }
            }
        return output;
    }  
}

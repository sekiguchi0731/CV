import java.awt.Color;

public class Noise {
	public static MyImage execute(MyImage input, double noiserate) {
		// 変数宣言
		int width, height;
        width = input.width;
        height = input.height;

        MyImage output = new MyImage(width, height);

		double rate;

		for (int i = 0; i < height;i++ ) {
			for (int j = 0; j < width;j++) {
				// 乱数を発生
				rate = Math.random() * 100.0;

				// ノイズ色を決定
				if ( noiserate > rate ) {
                    output.setColor(j, i, Color.BLACK);
				} else {
					// ノイズでない白色を設定
                    Color color = input.getColor(j, i);
                    output.setColor(j, i, color);
				}
			}
        }
        return output;
	}
}
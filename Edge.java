import java.awt.*;
import java.math.*;

public class Edge {
    public static MyImage execute(MyImage input, int gap) {
        int width, height;

        width = input.width;
        height = input.height;

        MyImage output = new MyImage(width, height);

        for (int i = 0;i < height;i++) {
            for (int j = 0;j < width;j++) {
                // 端っこでないなら
                if(((width - 1) != j)&&((height - 1) != i)) {
                    Color color1 = input.getColor(j, i);
                    Color color2 = input.getColor(j + 1, i);
                    Color color3 = input.getColor(j, i + 1);
                    int drgb1 = bigGap(color1, color2);
                    int drgb2 = bigGap(color1, color3);

                    // 右側or下側との色差が閾値より大きいなら黒
                    if (drgb1 > gap || drgb2 > gap) {
                        output.setColor(j, i, Color.BLACK);
                    } else { // 以下なら白
                        output.setColor(j, i, Color.WHITE);
                    }
                    
                } else {
                    // 端っこなら白
                    output.setColor(j, i, Color.WHITE);
                }
            }
        }

       

        return output;
    }

    static int bigGap (Color color1, Color color2) {
        int r, g, b, r2, g2, b2;
        int dr, dg, db, biggap;

        r = color1.getRed();
        g = color1.getGreen();
        b = color1.getBlue();

        r2 = color2.getRed();
        g2 = color2.getGreen();
        b2 = color2.getBlue();

        dr = Math.abs(r - r2);
        dg = Math.abs(g - g2);
        db = Math.abs(b - b2);

        biggap = Math.max(dr, Math.max(dg, db));

        return biggap;
    }
	// public static void main( String[] args ) {
	// 	// 結果格納フラグ
	// 	boolean result;
	// 	// 差の閾値
	// 	int gap;
	// 	// ファイル名
	// 	String inname, outname;
	// 	// 画像格納クラス
	// 	BufferedImage img = null;
	// 	BufferedImage newimg = null;

	// 	// 入力した引数が３つ以上かを調べる
	// 	if ( 3 > args.length ) {
	// 		// 入力した引数が３つ未満の場合、使用方法を表示する
	// 		System.out.println( "Edge01 [入力JPEG名] [出力PNG名] [差の閾値]" );
	// 		return;
	// 	}

	// 	// 入力JPEG名をinnameに代入（拡張子".jpg"省略なし）
	// 	inname  = args[ 0 ];
	// 	// 出力PNG名をoutnameに代入（拡張子".png"省略なし）
	// 	outname = args[ 1 ];

	// 	// 引数を変換し、差の閾(しきい)値に代入
	// 	try {
	// 		gap = Integer.valueOf( args[ 2 ] );
	// 		if ( 1 > gap) {
	// 			System.out.println( "差の閾値に１以上を指定してください" );
	// 			return;
	// 		}
	// 	}
	// 	catch( NumberFormatException ne )
	// 	{
	// 		System.out.println( "引数が不正です" );
	// 		return;
	// 	}

	// 	// 入力画像の読み込み
	// 	try {
	// 		// inname(入力JPEG)を読み込んでimgにセット
	// 		img = ImageIO.read( new File( inname ) );
	// 	} catch (Exception e) {
	// 		// inname(入力JPEG)の読み込みに失敗したときの処理
	// 		 e.printStackTrace();
	// 		return;
	// 	}

	// 	// 画像の色の持ち方をチェック
	// 	if ( BufferedImage.TYPE_3BYTE_BGR != img.getType() )
	// 	{
	// 		System.out.println( "対応していないカラーモデルです！("
	// 								 + inname +")" );
	// 		return;
	// 	}

	// 	// 変数を宣言
	// 	int x, y;		// ピクセル座標
	// 	int width, height;	// 画像サイズ
	// 	int color;		// 色
	// 	int newcolor;		// 境界色
	// 	int r, g, b;		// (x,y)の色
	// 	int r_r, g_r, b_r;	// (x,y)の右(x+1,y)の色
	// 	int r_d, g_d, b_d;	// (x,y)の下(x,y+1)の色
	// 	int r_a, g_a, b_a;	// 境界判定した色（黒or白）

	// 	// 画像サイズの取得
	// 	width = img.getWidth();
	// 	height= img.getHeight();

	// 	// 新しい画像を作成
	// 	// ２４ビットカラーの画像を作成
	// 	try {
	// 		newimg = new BufferedImage( width, height,
	// 					 BufferedImage.TYPE_INT_RGB );
	// 	} catch ( Exception e ) {
	// 		// 画像作成に失敗したときの処理
	// 		e.printStackTrace();
	// 		return;
	// 	}

	// 	// エッジ(境界)抽出
	// 	for ( y = 0; y < height; ++ y ) {
	// 		for ( x = 0; x < width; ++ x ) {
	// 			// 境界色の初期値は白色
	// 			r_a = 255;
	// 			g_a = 255;
	// 			b_a = 255;

	// 			if ( ( ( width - 1 ) != x ) && ( ( height - 1 ) != y ) ) {
	// 				// (x,y)の色を取得し、rgbに分解
	// 				color = img.getRGB( x, y );
	// 				r = ( color >> 16 ) & 0xff;
	// 				g = ( color >> 8 ) & 0xff;
	// 				b = color & 0xff;

	// 				// (x+1,y)の色を取得し、rgbに分解
	// 				color = img.getRGB( x + 1, y );
	// 				r_r = ( color >> 16 ) & 0xff;
	// 				g_r = ( color >> 8 ) & 0xff;
	// 				b_r = color & 0xff;

	// 				// 右側の色との差が閾値より大きければ黒色
	// 				if ( ( gap < Math.abs( r - r_r ) )
	// 					 || ( gap < Math.abs( g - g_r ) )
	// 					 	|| ( gap < Math.abs( b - b_r ) ) ) {
	// 					// 黒色に決定
	// 					r_a = 0;
	// 					g_a = 0;
	// 					b_a = 0;
	// 				}
	// 				else {
	// 					// (x,y+1)の色を取得し、rgbに分解
	// 					color = img.getRGB( x, y + 1 );
	// 					r_d = ( color >> 16 ) & 0xff;
	// 					g_d = ( color >> 8 ) & 0xff;
	// 					b_d = color & 0xff;

	// 					// 下側の色との差が閾値より大きければ黒色
	// 					if ( ( gap < Math.abs( r - r_d ) )
	// 						 || ( gap < Math.abs( g - g_d ) )
	// 						 	|| ( gap < Math.abs( b - b_d ) ) ) {
	// 						// 黒色に決定
	// 						r_a = 0;
	// 						g_a = 0;
	// 						b_a = 0;
	// 					}
	// 				}
	// 			}

	// 			// r,g,bの色を合成
	// 			newcolor = ( r_a << 16 ) + ( g_a << 8 ) + b_a;

	// 			// 合成した色を(x,y)に設定
	// 			newimg.setRGB( x, y, newcolor );
	// 		}
	// 	}

	// 	try {
	// 		// newimgをoutname(出力PNG)に保存
	// 		result = ImageIO.write( newimg, "PNG", new File( outname ) );
	// 	} catch ( Exception e ) {
	// 		// outname(出力JPEG)の保存に失敗したときの処理
	// 		e.printStackTrace();
	// 		return;
	// 	}

	// 	// 正常に終了
	// 	System.out.println( "正常に終了しました" );
	// }
}
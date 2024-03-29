import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


// コアの座標と色を格納するクラス
class CoreColor {
	public int x, y;
	public int color;
}


public class StainedGlass {
	public static void main( String[] args ) {
		boolean result;	// 結果格納フラグ
		int     corenum;	// コアの数	

		// ファイル名
		String inname, outname;
		// 画像格納クラス
		BufferedImage img = null;

		// 入力した引数が3つ以上かを調べる
		if ( 3 > args.length ) {
			// 入力した引数が３つ未満の場合、使用方法を表示する
			System.out.println(
				 "StainedGlass [入力JPEG名]  [出力JPEG名] [コアの数]" );
			return;
		}

		// 入力JPEG名をinnameに代入（拡張子".jpg"省略なし）
		inname  = args[ 0 ];
		// 出力JPEG名をoutnameに代入（拡張子".jpg"省略なし）
		outname = args[ 1 ];

		// 引数を変換し、コア数に代入
		try {
			corenum = Integer.valueOf( args[ 2 ] );
			if ( 2 > corenum ) {
				System.out.println( "コア数に２以上を指定してください" );
				return;
			}
		}
		catch( NumberFormatException ne )
		{
			System.out.println( "引数が不正です" );
			return;
		}

		// JPEGの読み込み
		try {
			// inname(入力JPEG)を読み込んでimgにセット
			img = ImageIO.read( new File( inname ) );
		} catch (Exception e) {
			// inname(入力JPEG)の読み込みに失敗したときの処理
			 e.printStackTrace();
			return;
		}

		// 画像の色の持ち方をチェック
		if ( BufferedImage.TYPE_3BYTE_BGR != img.getType() )
		{
			System.out.println( "対応していないカラーモデルです！("
									 + inname +")" );
			return;
		}

		// ステンドグラス画像の作成
		int x, y;
		int width, height;

		// 画像サイズの取得
		width = img.getWidth();
		height= img.getHeight();

		// コアを乱数で決める
		CoreColor core[] = new CoreColor[ corenum ];		
		for ( int i = 0; i < corenum; ++ i ) {
			// 乱数を発生し、適当に座標を求める
			core[ i ] = new CoreColor();
			core[ i ].x = (int)( Math.random() * (double)width );
			core[ i ].y = (int)( Math.random() * (double)height );
			core[ i ].color = img.getRGB( core[ i ].x, core[ i ].y );
		}

	
		// 全ての画素の座標(x,y)から最も近いコアを求め
		//　　　　　　　　　　 そのコアの色を(x,y)に置く
		for ( y = 0; y < height; ++ y ) {
			for ( x = 0; x < width; ++ x ) {
				int minl = 10000000;
				int newcolor = 0;

				// 一番近いコアを求める
				for ( int i = 0; i < corenum; ++ i ) {
					// 距離の２乗を計算
					int dx = core[ i ].x - x;
					int dy = core[ i ].y - y;
					int l  = dx * dx + dy * dy;

					if ( l < minl ) {
						minl = l;
						newcolor = core[ i ].color;
					}
				}
				img.setRGB( x, y, newcolor );
			}
		}

		try {
			// imgをoutname(出力JPEG)に保存
			result = ImageIO.write( img, "jpeg", new File( outname ) );
		} catch ( Exception e ) {
			// outname(出力JPEG)の保存に失敗したときの処理
			e.printStackTrace();
			return;
		}

		// 正常に終了
		System.out.println( "正常に終了しました" );
	}
}
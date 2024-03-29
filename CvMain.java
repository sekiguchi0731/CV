public class CvMain {


	static void imageProcessing1() {

		String file = "./images/forDoc/wwc-ganma.jpeg";
		String file2 = "./images/forDoc/wwc-celare2.jpg";
		MyImage image1, image2;
		image1 = JpegFileReader.read(file);
		image2 = CelareX.execute(image1, 100);
		JpegFileWriter.write(file2, image2);
		// String filename1 = "./images/wf2.jpg";
		// String filename3 = "./images/ffl3.jpg";

		// MyImage image0, image1, image2, image3;

		// // String basePath = "./images/forTile/";

		// // MyImage[] images = new MyImage[2];

		// // for (int i = 1; i <= 2; i++) {
        // //     String filename = basePath + i + ".jpg";
		// // 	// System.err.println(filename);
        // //     images[i - 1] = JpegFileReader.read(filename);
		// // 	int w = images[i-1].width;
        // //     int h = images[i-1].height;
        // //     int sml = (w >= h) ? h : w;
        // //     // 正方形
		// // 	System.err.println(100.0/sml);
        // //     images[i - 1] = ScaleEX.execute(images[i-1], 100.0/sml, 100.0/sml);
        // //     images[i - 1] = Cut.execute(images[i-1], 100, 100, 0, 0);
        // // }
	
		// image1 = JpegFileReader.read(filename1);
		// // image2 = JpegFileReader.read(filename1);

		// {	
		// 	KMeans kmeans = new KMeans();
		// 	kmeans.clustering(image1, 6);
		// 	image0 = Chromakey.execute(image1, kmeans, 3);
		// 	int[] d = CutX.execute(image0);
		// 	int ww = d[1] - d[0] + 1;
		// 	int hh = d[3] - d[2] + 1;
		// 	image2 = Cut.execute(image1, ww, hh, d[2], d[0]);
		// 	System.err.println("ww"+ww);
		// 	System.err.println("hh"+hh);
		// 	System.err.println("左"+d[0]);
		// 	System.err.println("上"+d[2]);
		// 	Size.execute(image2);
		// 	// image2 = Edge.execute(image1, 10);
		// 	// image2 = Binalization.execute(image2);
		// 	// image3 = VirtualStudio.execute(image2, image1, image2);
		// 	// height, width, basePath, たてにおく数！！, 横に置く数！！
		// 	// image2 = TilingX.execute(800, 1200, basePath, 8, 12);
		// 	// Hole.execute(image1);
		// 	// image2 = Cut.execute(image1, 1280, 800, 0, 0);
		// 	// image2 = Mosaic.execute(image1, 5);
		// 	//image2 = Binalization.execute(image1);
		// 	// image2 = GammaCorrection.execute(image2, 1.8, 1.0, 0.8);
		// 	// image2 = SpaceFiltering.execute(image1);	
		// 	//image2 = Scale.execute(image1);
		// 	// image2 = RotationX.execute(image1);
		// 	// image2 = Scale.execute(image2);
		// 	// image2 = CelareX.execute(image1, 300);
		// }

		// // for (int i = 0; i < 2;i++) {
		// // 	String fi = basePath + i + ".jpeg";
		// // 	JpegFileWriter.write(fi, images[i]);
		// // }

		// JpegFileWriter.write("./images/forPKB/j.jpg", output);
		

	}


	static void imageProcessing2() {

		// String filename1 = "./images/wall-cut.jpeg";
		// String filename2 = "./images/wwc-cheki.jpg";
		// String filename3 = "./images/wwc-kari.jpeg";
		String filename1 = "./images/wwc-kari.jpeg";
		String filename2 = "./images/wd+os.jpg";
		String filename3 = "./images/wall+wd+os.jpeg";

		MyImage image1, image2, image3, image0;

		Tuple LeTp = new Tuple(), RiBt = new Tuple();
		LeTp.x = 10; LeTp.y = 10;
		RiBt.x = 200; RiBt.y = 300;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		System.err.println("img1");
		Size.execute(image1);
		System.err.println("img2");
		Size.execute(image2);
		image3 = AlphaBlendingHole.execute(image1, image2, image2, 100, 0, 2, 1, false);
		// image2 = ScaleEX.execute(image2, 0.5, 0.5);
		
		// image2 = StainedGlass.execute(image2, 100);
		
		// KMeans kmeans = new KMeans();
		// kmeans.clustering(image2, 6);
		// image0 = Chromakey.execute(image2, kmeans, 3);
		// // image0 = VoidChromakey.execute(image0, LeTp, RiBt);
		// Size.execute(image0);
		// Size.execute(image1);

		// int[] d = CutX.execute(image0);
		// int ww = d[1] - d[0] + 1;
		// int hh = d[3] - d[2] + 1;
		// image2 = Cut.execute(image2, ww, hh, d[2], d[0]);
		// image0 = Cut.execute(image0, ww, hh, d[2], d[0]);
		// image1 = Cut.execute(image1, image2.width, image2.height, 0, 0);
		// image2 = GammaCorrection.execute(image2, 0.8, 0.8, 0.8);
	

		// // image2 = RotationX.execute(image2);
		// // image0 = RotationX.execute(image0);

		

		// // // image1 = Rotation.execute(image0);
		// // // // image3 = VirtualStudio.execute(image1, image2, image0); 
		// // image3 = AlphaBlendingX.execute(image1, image2, init.x, init.y, 1.0, false); 	
		// // Size.execute(image0);

		// image3 = AlphaBlendingHole.execute(image1, image2, image0, 0, 0, 2, 1, false); 	
		// // // // image3 = Tiling.execute(image1, image2); 	

		JpegFileWriter.write(filename3, image3);

	}

	static void PolProcess() {
		String filename1 = "./images/forCheki/pol-frame.png";
		String filename2 = "./images/forCheki/vn.jpg";
		String filename3 = "./images/chekis/vn.jpg";

		MyImage image0, image1, image2, image3;

		Tuple init;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		// 画像の大きさ調整
		// image2 = ScaleEX.execute(image2, 1.5, 1.5);
		// 画像の切り取り
		image2 = Cut.execute(image2, 650, 700, 70, 400);
		// セピア風加工
		image2 = GammaCorrection.execute(image2, 1.8, 1.0, 0.8);
		// 手ブレ加工
		image2 = SpaceFiltering.execute(image2);
		// ケラレ加工
		image2 = CelareX.execute(image2, 180);
		// ポラロイド素材の大きさ合わせ
		image1 = ScaleEX.execute(image1,0.3, 0.3);
		// 穴の初期位置の取得
		init = Hole.execute(image1);
		// 重ね合わせ準備(クロマキー処理)
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 6);
		// クロマキー画像
		image0 = Chromakey.execute(image1, kmeans, 0);
		// 重ね合わせ
		image3 = AlphaBlendingHole.execute(image1, image2, image0, init.x-1, init.y-1, 1, 1, true); 	

		JpegFileWriter.write(filename3, image3);
	}

	static void MosaicProcess() {
		String filename1 = "./images/forTile/Tiled.jpeg";

		String filename2 = "./images/forTile/MAMA.jpeg";
		String filename3 = "./images/forTile/Tiled-alpha.jpeg";

		MyImage image1, image2, image3;

		String basePath = "./images/forTile/";
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		// height, width, basePath, たてにおく数！！, 横に置く数！！
		// image1 = TilingX.execute(800, 1200, basePath, 8, 12);
		// 大きさ合わせ
		image2 = ScaleEX.execute(image2, 1200.0/image2.width, 800.0/image2.height);

		image3 = AlphaBlending.execute(image1, image2, image2);

		JpegFileWriter.write(filename3, image3);
	}
	
	static void MakeWinProcess() {
		String filename1 = "./images/os2.jpg";
		String filename2 = "./images/wf.jpg";
		String filename3 = "./images/ff-kari.jpeg";

		MyImage image1, image2, image3, image0;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		image1 = ScaleEX.execute(image1, 846.0/815, 846.0/815);

		
		KMeans kmeans = new KMeans();
		kmeans.clustering(image2, 6);
		image0 = Chromakey.execute(image2, kmeans, 3);
		Size.execute(image0);
		Size.execute(image1);

		int[] d = CutX.execute(image0);
		int ww = d[1] - d[0] + 1;
		int hh = d[3] - d[2] + 1;
		image2 = Cut.execute(image2, ww, hh, d[2], d[0]);
		image0 = Cut.execute(image0, ww, hh, d[2], d[0]);
		image1 = Cut.execute(image1, image2.width, image2.height, 0, 0);
		image2 = GammaCorrection.execute(image2, 0.8, 0.8, 0.8);
	

		image3 = AlphaBlendingHole.execute(image1, image2, image0, 0, 0, 2, 1, true);

		JpegFileWriter.write(filename3, image3);

	}

	static  MyImage PutOnChekis(MyImage input, MyImage cheki, int x, int y, boolean Rote) {
		MyImage output = new MyImage(input.width, input.height);
		int[] d = new int[4];
		// 回るなら
		// int ANGLE = (Rote) ? 30 : 0;

		d = CutX.execute(cheki);
		int ww = d[1] - d[0] + 1;
		int hh = d[3] - d[2] + 1;
		cheki = Cut.execute(cheki, ww, hh, d[2], d[0]);
		if(Rote) cheki = RotationX.execute(cheki, 10);
		cheki = ScaleEX.execute(cheki, 0.17, 0.17);

		output = ShadeSquare.excecute(input, x-10, y+10, cheki.width+10, cheki.height+10, 0);

		output = AlphaBlendingHole.execute(output, cheki, cheki, x, y, 2, 1, false);

		return output;
	}

	static void MakeWallItems() {
		// 鏡と鏡に映る人物の重ね合わせ
		String filename1 = "./images/forItems/mg-mr.jpg";
		String filename2 = "./images/forItems/mr.jpg";
		String filename3 = "./images/chekis/wwc-cheki.jpg";
		String filename4 = "./images/forWall/wall-cut.jpg";
		String filename5 = "./images/chekis/wwc-cheki3.jpg";
		String filename6 = "./images/forWall/mg+mr+wall+w.jpg";
		String filename8 = "./images/chekis/at.jpg";
		String filename9 = "./images/chekis/hw.jpg";
		String filename10 = "./images/chekis/jis.jpg";
		String filename11 = "./images/chekis/jn.jpg";
		String filename12 = "./images/chekis/mg.jpg";
		String filename13 = "./images/chekis/vn.jpg";
		String filename14 = "./images/forWall/plant.jpg";
		String filename15 = "./images/forWall/plantkari.jpg";

		MyImage image1, image2, image0, image3, image4, image5, image02, image6, image7;
		MyImage image8, image9, image10, image11, image12, image13;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image6 = JpegFileReader.read(filename3);
		image7 = JpegFileReader.read(filename5);
		image8 = JpegFileReader.read(filename8);
		image9 = JpegFileReader.read(filename9);
		image10 = JpegFileReader.read(filename10);
		image11 = JpegFileReader.read(filename11);
		image12 = JpegFileReader.read(filename12);
		image13 = JpegFileReader.read(filename13);
		// サイズ確認
		Size.execute(image1);
		Size.execute(image2);

		// クロマキー処理
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 10);
		image0 = Chromakey.execute(image1, kmeans, 7);

		// image1 = CircleCut.execute(image1, image1.height/2, image1.width/2, 700);
		image0 = CircleCut.execute(image0, image1.height/2, image1.width/2, 700);

		image1 = ScaleEX.execute(image1, 0.32, 0.32);
		image0 = ScaleEX.execute(image0, 0.32, 0.32);
		
		// 重ね合わせ
		image3 = AlphaBlendingHole.execute(image1, image2, image0, 53, 145, 1, 2, false);

		// cheki, mirror selfie mingyuをさらに壁に貼る
		// // カット済み壁画像
		image4 = JpegFileReader.read(filename4);
		// チェキ画像貼り付け
		image4 = PutOnChekis(image4, image6, 150, 300, true);
		image4 = PutOnChekis(image4, image7, 700, 300, false);
		image4 = PutOnChekis(image4, image8, 200, 100, false);
		image4 = PutOnChekis(image4, image9, 650, 100, false);
		image4 = PutOnChekis(image4, image10, 650, 500, false);
		image4 = PutOnChekis(image4, image11, 200, 500, false);
		image4 = PutOnChekis(image4, image12, 440, 560, false);
		image4 = PutOnChekis(image4, image13, 440, 30, false);

		// mingyu+mirrorを円形カット
		image02 = CircleCut.execute(image3, image3.width/2+4, image3.height/2, 243);
		// 大きさ調整
		image02 = ScaleEX.execute(image02, 0.7, 0.7);
		// 円形の影
		image4 = ShadeCircle.excecute(image4, 430, 400, 180, 30);
		// 重ね合わせ
		image5 = AlphaBlendingHole.execute(image4, image02, image02, 300, 100, 2, 1, false);

		JpegFileWriter.write(filename6, image5);
	}
	
	static void MakeWallItems2() {
		String filename1 = "./images/forWall/mg+mr+wall+w.jpg";
		String filename2 = "./images/forWall/wd+os.jpg";
		String filename3 = "./images/forWall/wall+mr+wd.jpg";
		String filename4 = "./images/forWall/plant.jpg";
		String filename5 = "./images/forWall/plantkari.jpg";

		MyImage image1, image2, image3, image4, image0;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image4 = JpegFileReader.read(filename4);

		
		image1 = ShadeSquare.excecute(image1, 900, -100, 500, 900, 5);

		image4 = ScaleEX.execute(image4, 2.1, 2.1);


		// // 観葉植物のクロマキー処理
		KMeans kmeans = new KMeans();
		kmeans.clustering(image4, 3);
		image0 = Chromakey.execute(image4, kmeans, 2);
		// 観葉植物ぼやけ
		image4 = SpaceFiltering.execute(image4);

		image3 = AlphaBlendingHole.execute(image1, image4, image0, -720, 0, 2, 1, false);

		image3 = AlphaBlendingHole.execute(image3, image2, image2, 950, -130, 2, 1, false);

		JpegFileWriter.write(filename3, image3);
	}
	
	static void BookGround() {
		String filename1 = "./images/forBook/BkN.jpg";
		String filename2 = "./images/forBook/Bk-e.jpg";
		String filename3 = "./images/forBook/Bk-e2.jpg";
		String filepath = "./images/forBook/forCh/";
		String filename4 = "./images/forBook/Bk-addW.jpg";
		String filename5 = "./images/forSky/moon.jpg";
		String filename6 = "./images/forBook/Bk-moon.jpg";
		String filename7 = "./images/forBook/Bk-e3.jpg";
		MyImage image1, image2, image3, image4, image5, image6, image7, image8;
		MyImage[] images, images2;
		Tuple LeTp = new Tuple();
		Tuple RiBt = new Tuple();

		image1 = JpegFileReader.read(filename1);
		image7 = JpegFileReader.read(filename5);

		image2 = Cut.execute(image1, image1.width, image1.height-150, 0, 0);
		image3 = Cut.execute(image2, image1.width, image1.height/2+10, 0, 0);
		// image7 = ScaleEX.execute(image7, 0.8, 0.8);
		// image7 = Cut.execute(image7, 1440, 0, 100, 0);


		// // 本のクロマキー処理
		images = CheckKmeans(10, filepath, image3);

		// クロマキー処理する場所の
		image4 = images[7];
		LeTp.x = image4.width/2;
		LeTp.y = image4.height/2 + 15;
		RiBt.x = image4.width - 300;
		RiBt.y = image4.height;
		image4 = VoidChromakey.execute(image4, LeTp, RiBt);
		LeTp.y = LeTp.y + 90;
		RiBt.x = RiBt.x + 300;
		image4 = VoidChromakey.execute(image4, LeTp, RiBt);
		LeTp.x = image4.width/2 + 15;
		LeTp.y = image4.height/2 - 5;
		RiBt.x = image4.width/2 + 350;
		image4 = VoidChromakey.execute(image4, LeTp, RiBt);
		LeTp.x = image4.width/2 + 150;
		LeTp.y = image4.height/2 - 25;
		RiBt.x = image4.width/2 + 330;
		image4 = VoidChromakey.execute(image4, LeTp, RiBt);
		LeTp.x = LeTp.x + 30;
		LeTp.y = LeTp.y + 120;
		RiBt.x = RiBt.x + 200;
		images[6] = VoidChromakey.execute(images[6], LeTp, RiBt);
		LeTp.x = LeTp.x + 20;
		LeTp.y = LeTp.y - 23;
		RiBt.x = RiBt.x - 120;
		images[6] = VoidChromakey.execute(images[6], LeTp, RiBt);
		LeTp.x = LeTp.x - 110;
		LeTp.y = LeTp.y - 100;
		images[9] = VoidChromakey.execute(images[9], LeTp, RiBt);
		LeTp.x = LeTp.x + 300;
		LeTp.y = LeTp.y + 110;
		RiBt.x = RiBt.x + 50;
		images[9] = VoidChromakey.execute(images[9], LeTp, RiBt);
		LeTp.x = LeTp.x - 150;
		LeTp.y = LeTp.y - 50;
		RiBt.x = RiBt.x - 143;
		images[6] = VoidChromakey.execute(images[6], LeTp, RiBt);

		// 除去したい部分を持つ画像群
		images2 = new MyImage[3];
		images2[0] = image4;
		images2[1] = images[6];
		images2[2] = images[9];
		// 除去したい部分のAND部分を持つ画像
		image5 = And.execute(images2, 3);
		// 画像の大きさを揃える
		image5 = AddWhite.excecute(image5, image1.width, image1.height, 0, 0);
		image5 = JpegFileReader.read(filename4);
		image5 = Binalization.execute(image5);

		Size.execute(image1);
		Size.execute(image7);
		// 画像の大きさを揃える
		image7 = Cut.execute(image7, image1.width, image1.height-99, 100,250);
		image8 = AlphaBlendingHole.execute(image7, image1, image5, 0, 0, 2, 1, false);

		JpegFileWriter.write(filename7, images[6]);
		// JpegFileWriter.write(filename4, image5);
		JpegFileWriter.write(filename6, image8);
		// JpegFileWriter.write(filename3, image02);


	}

	static void BookGround2() {
		String filename1 = "./images/forSky/hiru.jpg";
		String filename2 = "./images/forSky/moon.jpg";
		String filename3 = "./images/forBook/BkN.jpg";
		String filename4 = "./images/forBook/Bk-addW.jpg";
		String filepath1 = "./images/forBook/forNoon/n";
		String filepath2 = "./images/forBook/forMoon/m";
		MyImage image1, image2, image3, image04, image5;
		Result result;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);
		image04 = JpegFileReader.read(filename4);
		image04 = Binalization.execute(image04);
		// result = RotationEX.execute(image1, 20);
		// // image2 = result.output;
		// image1 = ScaleEX.execute(result.output, 1.2, 1.2);
		image2 = Cut.execute(image2, image3.width, image3.height-99, 100,250);
		
		image5 = AlphaBlendingHole.execute(image2, image3, image04, 0, 0, 2, 1, false);

		JpegFileWriter.write(filepath2+2+".jpg", image5);
	}

	static void PKB() {
		String filename1 = "./images/forPKB/pkb.png";
		String filename2 = "./images/forPKB/pkb2.jpg";
		String filename3 = "./images/forPKB/j2.jpg";
		String filename4 = "./images/forPKB/pkb3.jpg";
		MyImage image1, image2, image0, image3, image4, image01;

		image1 = JpegFileReader.read(filename1);
		image3 = JpegFileReader.read(filename3);

		// クロマキー処理
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 10);
		image0 = Chromakey.execute(image1, kmeans, 0);
		image1 = Gray.execute(image1, image1.width/2);
		image2 = WhiteEdge.execute(image1, image0, 15);
		image2 = MosaicX.execute(image2, image1.width/2,9 );

		// 説明書用
		image4 = AlphaBlendingHole.execute(image3, image1, image0, 0, 0, 2, 1, false);

		// JpegFileWriter.write(filename2, image2);
		JpegFileWriter.write(filename4, image2);


	}
	public static MyImage[] CheckKmeans(int n, String filepath, MyImage input) {
		MyImage[] images = new MyImage[n];
		KMeans kmeans = new KMeans();
		kmeans.clustering(input, n);

		for(int i = 0;i < n;i++) {
			images[i] = Chromakey.execute(input, kmeans, i);
			JpegFileWriter.write(filepath+i+".jpg", images[i]);
		}

		return images;
	}

	static void PKBbg() {
		String filename1 = "./images/forPKB/pkb2.jpg";
		String filename2 = "./images/forPKB/pkb3.jpg";
		String filepath2 = "./images/forBook/forNM/";
		String filename3 = "./images/forBook/BK-noon2.jpg";
		String filepath4 = "./images/forGif/";
		MyImage image1, image2, image3, image4;
		image1 = JpegFileReader.read(filename1);
		image3 = JpegFileReader.read(filename2);
		for(int i = 0;i < 6;i++) {
			image2 = JpegFileReader.read(filepath2+i+".jpg");
			

			Size.execute(image2);
			// サイズ調整
			image2 = Cut.execute(image2, 1280, 750, 90, 0);
			Size.execute(image2);
			// 重ね合わせ
			// // サイズ調整
			image2 = ScaleEX.execute(image2, 2, 2);
			if (i < 3) {
				image4 = AlphaBlendingHole.execute(image2, image1, image1, 920, 5, 2, 1, false);
			} else {
				image4 = AlphaBlendingHole.execute(image2, image3, image3, 920, 5, 2, 1, false);
			}
			
			image4 = Noise.execute(image4, 40*(3-Math.ceil(Math.abs(i-2.5))));

			JpegFileWriter.write(filepath4+i+".jpg", image4);
		}
		System.err.println((int)Math.abs(2-2.5));
	}

	static void MakeGif() {
		int N = 6;
		try {
			String[] filenames = new String[N];
			String filepath = "./images/forGif/";
			String outputname = "./images/forGif/PKB.gif";
	
			for (int i = 0;i < N;i++) {
				filenames[i] = filepath+i+".jpg";
			}
	
			GifSequenceWriter.excecute(filenames, outputname);
		} catch (Exception e) {
			// 例外が発生した場合の処理
			// GifSequensceWriterがexceptionをthrowしているため必要
			e.printStackTrace();
			
		}
	}
	
	public static void main(String args[]) {

		imageProcessing1();
		// imageProcessing2();
		// PolProcess();
		// MosaicProcess();

		// MakeWallItems();
		// MakeWallItems2();

		// BookGround2();
		// PKB();
		// PKBbg();
		// MakeGif();
	}
}

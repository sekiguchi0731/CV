public class MosaicX {
    public static MyImage execute(MyImage input, int limx, int ksize) {
        int width = input.width;
        int height = input.height;
        MyImage output = new MyImage(width, height);
        MyImage input1 = Cut.execute(input, width-limx, height, 0, 0);
        MyImage input2 = Cut.execute(input, width-limx, height, limx, 0);
        JpegFileWriter.write("./images/000.jpg", input2);
        input2 = Mosaic.execute(input2, ksize);

        output = Tiling.execute(input1, input2);

        return output;
    }
}
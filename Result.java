public class Result {
    MyImage output;
    int minX;
    int minY;
    int maxX;
    int maxY;
    int[] d;
    
    Result(MyImage output, int minX, int minY, int maxX, int maxY, int[] d) {
        this.output = output;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.d = d;
    }
    
}
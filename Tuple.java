import java.awt.*;
import java.lang.Math;

public class Tuple {
    int x, y;

    double norm(Tuple v1) {
        int x_d = v1.x - x;
        int y_d = v1.y - y;
        return(Math.sqrt(x_d*x_d + y_d*y_d));
    }

    void print() {
        System.out.println("x:" + x + "y:"+y);
    }
}
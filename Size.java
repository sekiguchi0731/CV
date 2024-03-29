import java.awt.*;

public class Size {
    
	static void execute(MyImage input) {
        Tuple tup = new Tuple();

        tup.x = input.width;
        tup.y = input.height;

        tup.print();
    }

}

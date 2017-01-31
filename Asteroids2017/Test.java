
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Test extends GraphicsProgram
{

    public void run()
    {
        GVectorPolygon test = new GVectorPolygon(500,500);
        test.addVertex(2,1);
        test.addVertex(50,30);
        test.addVertex(0,200);
        test.rotate(40);
        test.increaseVelocity(20);
        add(test);
        while (true){
            test.updatePosition();
            pause(20);}
    }


}


import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Test extends GraphicsProgram
{

	public void run()
	{ /*
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
	}*/

		GVectorPolygon poly = new GVectorPolygon(getWidth(),getHeight());
		poly.addVertex(0,0);
		poly.addVertex(40,10);
		poly.addVertex(12,50);
		poly.addVertex(2,32);
		poly.addVertex(-20,36);
		poly.recenter();
		poly.setLocation(100,200);
		add(poly);

		poly.rotate(73);
		poly.increaseVelocity(2);

		while (true){
			poly.updatePosition();
			pause(10);
		}
	}

}

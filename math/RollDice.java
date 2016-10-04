
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RollDice extends GraphicsProgram
{

	private int face=1;

	public void run()
	{
	//	face = (int) (Math.random()*6+1);

		GRect square = new GRect (50,50,400,400);

		if (face==1){
			GOval circle = new GOval(square.getX()+square.getWidth()/2-50, square.getY()+square.getHeight()/2-50,100,100);
			circle.setFilled(true);
			add(circle);
		}

		if (face==2){
			
		}

	add(square);
	}


}

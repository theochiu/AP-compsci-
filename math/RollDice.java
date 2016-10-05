
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RollDice extends GraphicsProgram
{

	private int face=2;

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
			GOval circle = new GOval(square.getX()+20, square.getY()+20, 100,100);
			GOval circle1 = new GOval(square.getX()+20+square.getWidth()/2, square.getY()+20+square.getHeight()/2,100,100);
			circle.setFilled(true);
			add(circle);
			circle1.setFilled(true);
			add(circle1);
		}

		if (face==3){
			GOval circle = new GOval(square.getX()+square.getWidth()/2-50, square.getY()+square.getHeight()/2-50,100,100);
			circle.setFilled(true);
			add(circle);
		}

		if (face==4){
			GOval circle = new GOval(square.getX()+square.getWidth()/2-50, square.getY()+square.getHeight()/2-50,100,100);
			circle.setFilled(true);
			add(circle);
		}

		if (face==5){
			GOval circle = new GOval(square.getX()+square.getWidth()/2-50, square.getY()+square.getHeight()/2-50,100,100);
			circle.setFilled(true);
			add(circle);
		}

		if (face==6){
			GOval circle = new GOval(square.getX()+square.getWidth()/2-50, square.getY()+square.getHeight()/2-50,100,100);
			circle.setFilled(true);
			add(circle);
		}

	add(square);
	}


}

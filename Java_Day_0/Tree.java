
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Tree extends GraphicsProgram
{

	public void run()
	{
		GRect trunk = new GRect(50,50,20,100);
		trunk.setColor(Color.yellow);
		trunk.setFilled(true);
		add(trunk);

		GOval leaves = new GOval(40,15,40,40);
		leaves.setColor(Color.green);
		leaves.setFilled(true);
		add(leaves);

		GLabel text = new GLabel("This is a tree", 20 , 180);
		text.setColor(Color.red);
		text.setFont("Palatino-Bold-24");
		add(text);
	}


}


import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RandomHW extends GraphicsProgram
{

	public void run()
	{
		int bottles = (int) (Math.random()*500+1);
		String message =""; 

		while (bottles>0){
			int newbottles=(bottles-1);
			message += ("\n"+bottles+" bottles of beer on the wall "+bottles+" bottles of beer,\n"
				+"Take one down, pass it around, "+newbottles +" bottles of beer on the wall\n\n");
			bottles= newbottles;
		}

		GLabel label = new GLabel (message,100,100);
		label.setFont("*-bold-12");
		add(label);
	}

}


import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram
{
	GLabel label;	
	public void run()
	{
		label = new GLabel("x=0,y=0",20,30);
		add(label);
		addMouseListeners();
	}

	public void mouseMoved(MouseEvent event){
		int x = event.getX();
		int y = event.getY();
		label.setLabel("x="+x +" , y = "+y);
		label.setLocation(x+10,y+10);
	}

}

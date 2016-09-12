
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SpotLight extends GraphicsProgram
{

	GOval light;	
	public void run()
	{
		light = new GOval (300,300, 60,60);
		light.setFilled(true);
		light.setColor(Color.yellow);
		add(light);
		addMouseListeners();
	}
	public void mouseMoved(MouseEvent event){
		int x = event.getX();
		int y = event.getY();
		light.setLocation(x-30,y-30);

	}

}

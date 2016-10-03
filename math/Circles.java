
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
public class Circles extends GraphicsProgram{

	public void run(){
		int numCirlces = (int) (Math.random()*900+100);
		for(int i=0; i<numCirlces;i++){
			double x = Math.random()*getWidth();
			double y = Math.random()*getHeight();
			double diam = 60;
			GOval circle = new GOval(x,y,diam,diam);
			Color color = new Color((int)Math.random()*256,(int)Math.random()*256,(int)Math.random()*256);
			circle.setColor(color);
			add(circle);
			pause(65);
		}
	}
}
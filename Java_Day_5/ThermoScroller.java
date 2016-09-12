
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ThermoScroller extends GraphicsProgram
{
	private static final double BUTTON_SIZE = 60; 
	private static final double FROM_SIDE = 100; 
	private static final double WINDOW_WIDTH = 754; 
	private static final double WINDOW_HEIGHT = 492;

	GRect blueBox;
	GRect redBox;
	GLabel tempLabel;
	Thermostat therm;

	
	public void run()
	{
		initVariables();
		addMouseListeners();
		// animaion loop
		while (true){ 
			tempLabel.move(1,0);
			pause(10);
			if(tempLabel.getX()>WINDOW_WIDTH){
				tempLabel.setLocation(0,tempLabel.getY());
			}
		}
	}

	public void mouseMoved(MouseEvent event){
		
	}



	public void initVariables(){
		blueBox = new GRect (FROM_SIDE , FROM_SIDE , BUTTON_SIZE, BUTTON_SIZE);
		blueBox.setColor(Color.blue);
		blueBox.setFilled(true);
		add(blueBox);

		redBox = new GRect(WINDOW_WIDTH- FROM_SIDE - BUTTON_SIZE , FROM_SIDE , BUTTON_SIZE, BUTTON_SIZE);
		redBox.setColor(Color.red);
		redBox.setFilled(true);
		add(redBox);

		therm = new Thermostat(0,100);
		tempLabel = new GLabel("Temperature = " + therm.getValue() , 0,WINDOW_HEIGHT- FROM_SIDE);
		tempLabel.setFont("Times-Plain-24");
		add(tempLabel);
	}
}

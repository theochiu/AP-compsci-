
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PyramidC extends GraphicsProgram
{
	private static int BRICK_HEIGHT = 12;
	private static int BRICK_WIDTH = 30;
	private static int GAP = 4;
	private static int NUM_ROWS = 10;
	private static int START_X = 50;
	private static int START_Y = 60;

	public void run(){

		for (int r=0; r<NUM_ROWS; r++){

			int missingBricks = NUM_ROWS-r;
			int shift = missingBricks * (BRICK_WIDTH+GAP)/2;

			for (int c=0; c<r; c++){
				GRect brick = new GRect(shift+START_X + c*(BRICK_WIDTH+GAP) , START_Y + r*(BRICK_HEIGHT+GAP) , BRICK_WIDTH,BRICK_HEIGHT);
				brick.setFilled(true);
				add(brick);
			}
		}
	}
}

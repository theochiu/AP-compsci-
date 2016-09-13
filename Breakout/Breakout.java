
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram 
{

// add in sounds!
	AudioClip bounceClip = MediaTools.load.AudioClip("bounce.au");

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board in pixels (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

 /** Global variables declared here.  You should feel free to add others as needed. */
	private GRect paddle;
	private GOval ball;
	private double dx;
	private double dy;
	
/** Runs the Breakout program. */
	public void run() {
		initGame();
		addMouseListeners();
	}

	public void initGame(){
		for (int r=0; r<NBRICK_ROWS; r++){
			for (int c=0; c<NBRICK_ROWS; c++){
				GRect brick = new GRect (r*(BRICK_SEP + BRICK_WIDTH) , BRICK_Y_OFFSET+ c*(BRICK_HEIGHT + BRICK_SEP) , BRICK_WIDTH , BRICK_HEIGHT ); 

				if (c<=1){
					brick.setColor(Color.red);
				}
				if ((c>1)&&(c<=3)){
					brick.setColor(Color.orange);
				}

				if ((c>3)&&(c<=5)){
					brick.setColor(Color.yellow);
				}

				if ((c>5)&&(c<=7)){
					brick.setColor(Color.green);
				}

				if ((c>7)&&(c<=9)){
					brick.setColor(Color.cyan);
				}
				brick.setFilled(true);
				add (brick);
			}

			paddle = new GRect ( WIDTH/2, HEIGHT- PADDLE_Y_OFFSET , PADDLE_WIDTH, PADDLE_HEIGHT)
		}
	}
	public void mouseMoved(MouseEvent event){
		int x = event.getX();
		int y = event.getY();
		//paddle.setLocation(x-30,y-30);
	}
}


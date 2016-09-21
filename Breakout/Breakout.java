// Theodore Chiu, 2016, All Rights Reserved

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram 
{

// add in sounds!
	AudioClip bounceClip;

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
	private int lives; 
	private GLabel scoreboard;
	private int numBricks;

	private boolean testing = false;
	private GLabel testlabel; 

	
/** Runs the Breakout program. */
	public void run() {
		lives=5;
		if (testing==true){
			lives = -lives; 
			testlabel = new GLabel("testing=true" , WIDTH/2, 10);
			add(testlabel);
		}
		numBricks = 0;
		initGame();
		addMouseListeners();

		while ((lives!=0)&&(!won())){
			while (updateBall()){
				updateBall();
				collisionCheck(); 
				pause(5);
				System.out.println(numBricks + " , "+ won());
				if (won()){break;}
			}

			if (won()){break;}

			lives--;
			scoreboard.setLabel("Lives remaining: " + lives);
			removeAll();
			pause(1000);
			numBricks=0;
			initGame();
		}

		removeAll();

		if (won()){
			GLabel winner = new GLabel("You Win", WIDTH/2, HEIGHT/2);
			winner.setFont("*-bold-32");
			add(winner);
		}	

		while (!won()){
			GLabel loser = new GLabel ("You Lose", WIDTH/2, HEIGHT/2);
			loser.setFont("*-bold-32");
			add(loser);
			pause(800);			// TO-DO get the flashing animation to work. 
			remove(loser);
		}
	}

	// check for winning
	public boolean won(){
		boolean yes;
		if (numBricks==0){
			yes=true;
		} else {
			yes=false;
		}
		return yes;
	}
 
	public void initGame(){
		bounceClip = MediaTools.loadAudioClip("bounce.au");
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
				numBricks++;
			}   
		}

		if (testing==true){
			paddle = new GRect ( WIDTH/2+.5*PADDLE_WIDTH, HEIGHT- PADDLE_Y_OFFSET -PADDLE_HEIGHT , WIDTH, PADDLE_HEIGHT);
			paddle.setFilled(true);
			add(paddle);
		}

		if (testing==false){
			paddle = new GRect ( WIDTH/2+.5*PADDLE_WIDTH, HEIGHT- PADDLE_Y_OFFSET -PADDLE_HEIGHT , PADDLE_WIDTH, PADDLE_HEIGHT);
			paddle.setFilled(true);
			add(paddle);
		}

		ball = new GOval (WIDTH/2 - BALL_RADIUS , HEIGHT/2 - BALL_RADIUS, 2*BALL_RADIUS, 2*BALL_RADIUS);
		ball.setFilled(true);
		add(ball);

		dx = 1+Math.random()*2;
		if (Math.random()>.5){
			dx = -dx;
		}

		dy = 3.0;

		scoreboard = new GLabel("Lives remaining: " + lives, 5,10);
		add(scoreboard);
	}

	public void mouseMoved(MouseEvent event){
		int x = event.getX();
		int y = event.getY();
		if ((x>= (PADDLE_WIDTH/2))&&(x<=WIDTH - PADDLE_WIDTH/2)){  
			paddle.setLocation(x- PADDLE_WIDTH/2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}

	public boolean updateBall(){
		ball.move(dx, dy);
		pause(5);
		boolean dead =true ; 

		if (ball.getX()<=0){
			dx = -dx;  
			bounceClip.play(); 
			dead = true;
		}         
		else if (ball.getX()>WIDTH - BALL_RADIUS*2){
			dx = -dx;   
			bounceClip.play(); 
			dead = true; 
		}
		else if (ball.getY()<=0){
			dy = -dy;
			bounceClip.play(); 
			dead = true; 
		}
		else if (ball.getY()>=HEIGHT - BALL_RADIUS*2){
			dead = false;
			bounceClip.play(); 
		}

		return dead; 
	}

	public void collisionCheck(){
		double x = ball.getX();
		double y = ball.getY();
		int r = BALL_RADIUS;

		GObject obj = getElementAt(x,y); 				// top left
		GObject obj1 = getElementAt(x,y+2*r);			// bottom left
		GObject obj2 = getElementAt(x+2*r,y);			// top right
		GObject obj3 = getElementAt(x+2*r, y+2*r);		// bottom right

		if (((obj == paddle)||(obj1==paddle)||(obj2==paddle)||(obj3==paddle))&&(dy>0)){
			dy = -dy;
			bounceClip.play();
		}

		else if((obj!=paddle)&&(obj!=null)&&(obj!=scoreboard)&&(obj!=testlabel)){
			dy=-dy;
			remove(obj);
			numBricks--;
			bounceClip.play();
		}

		else if((obj1!=paddle)&&(obj1!=null)&&(obj1!=scoreboard)&&(obj1!=testlabel)){
			dy=-dy;
			remove(obj1);
			numBricks--;
			bounceClip.play(); 
		}

		else if((obj2!=paddle)&&(obj2!=null)&&(obj2!=scoreboard)&&(obj2!=testlabel)){
			dy=-dy;
			remove(obj2);
			numBricks--;
			bounceClip.play(); 
		}

		else if((obj3!=paddle)&&(obj3!=null)&&(obj3!=scoreboard)&&(obj3!=testlabel)){
			dy=-dy;
			remove(obj3);
			numBricks--;
			bounceClip.play(); 
		}
	}
}


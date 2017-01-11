
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ConnectFourGraphicsProgram extends GraphicsProgram
{
	private static final int PIECE_DIAM = 100;
	private static final int NUM_COLS = 7;
	private static final int NUM_ROWS = 6;
	public static final int APPLICATION_WIDTH = NUM_COLS * PIECE_DIAM;
	public static final int APPLICATION_HEIGHT = NUM_ROWS * PIECE_DIAM;

	/** Dimensions of game board in pixels (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;


	private ConnectFourGame game;
	private boolean gameIsBeingPlayed;
	private Color currentDrawingColor;

	
	public void run()
	{
		currentDrawingColor = Color.RED;
		
		game = new ConnectFourGame(NUM_ROWS, NUM_COLS);
		gameIsBeingPlayed = true;
		addMouseListeners();
		while (game.getWinner()==0)
		{
		}
		gameIsBeingPlayed = false;
		
		// add code here in version 0.4

		String team;
		if (currentDrawingColor==Color.RED)
			team = "BLACK";
		else
			team = "RED";
		GLabel winner = new GLabel(team + " Wins!!!", WIDTH/2, HEIGHT/2);
		winner.setFont("*-bold-42");
		winner.setColor(Color.GREEN);
		add(winner);
	}

	public void mouseClicked(MouseEvent e) 
	{ 
		if (!gameIsBeingPlayed) return;

		int x = e.getX();
		int col = x/PIECE_DIAM;
		int row = game.dropChecker(col);
		if (row!=-1){
			drawChecker(col, row);
			if (currentDrawingColor==Color.RED)
				currentDrawingColor = Color.BLACK;
			else
				currentDrawingColor = Color.RED;
		}
	
	}
	
	public void drawChecker(int col, int row)
	{
		// complete this in version 0.3

		GOval checker = new GOval((col)*PIECE_DIAM, (row)*PIECE_DIAM, PIECE_DIAM, PIECE_DIAM);
		checker.setColor(currentDrawingColor);
		checker.setFilled(true);
		add(checker);
	}


}

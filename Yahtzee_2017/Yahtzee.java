
import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants 
{
 
/* Private instance variables */
    private int numPlayers;
    private String[] playerNames;
    private YahtzeeDisplay display;
    private int[][] scores;
    private boolean[][] filled;
    
    public void run() 
    {
        /* You may need to change some of this */
        IODialog dialog = getDialog();
        numPlayers = dialog.readInt("Enter number of players");
        playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playerNames[i] = dialog.readLine("Enter name for player " + (i+1));
        }
        display = new YahtzeeDisplay(getGCanvas(), playerNames);
        scores = new int[numPlayers][N_CATEGORIES+1];
        filled = new boolean[numPlayers][N_CATEGORIES+1];
        playGame();
    }

    private void playGame() 
    {
        // here's where you'll need to begin
    }

   // you'll probably have lots of methods here.
   // (I had fifteen!)
    
    /* Java main method to ensure that this program starts correctly */
    public static void main(String[] args) 
    {
        new Yahtzee().start(args);
    }

}

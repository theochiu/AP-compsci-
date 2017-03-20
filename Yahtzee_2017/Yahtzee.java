
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
	
	public void run(){
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

	/*
	private void playGame() 
	{
		// here's where you'll need to begin

	}
	*/

   // you'll probably have lots of methods here.
   // (I had fifteen!)
	
	/* Java main method to ensure that this program starts correctly */
	public static void main(String[] args){
		new Yahtzee().start(args);
	}

	private void playGame(){
		for (int i = 0; i<numPlayers*N_SCORING_CATEGORIES; i++){
			int currentPlayerNum = i % numPlayers;
			handleOneTurn(currentPlayerNum);
		}

		int winner = getWinner();
		display.printMessage(playerNames[winner] + " is the winner!");
	}

	private void handleOneTurn(int playerNum){
		display.printMessage(playerNames[playerNum] + "'s turn. Click \"Roll Dice\" to roll the dice.");
		display.waitForPlayerToClickRoll(playerNum+1);

		int[] dice = getDice();
		display.displayDice(dice);

		for (int i = 0; i<2; i++){
			display.printMessage("Select the dice you wish to re-roll and click the \"Roll Again\" button.");
			display.waitForPlayerToSelectDice();
			dice = getSomeDice(dice);
			display.displayDice(dice);
		}

		display.printMessage("Select a category for this roll.");
		int category = display.waitForPlayerToSelectCategory();
		while (filled[playerNum][category] == true) {
			display.printMessage("Select an unused category.");
			category = display.waitForPlayerToSelectCategory();
		}

		int points = getPoints(dice, category);
		display.updateScorecard(category, playerNum+1, points);
		filled[playerNum][category] = true;
		scores[playerNum][category] = points;
}

	private int getPoints(int[] dice, int category){

	}

	private int[] getDice(){
		int[] nums = new int[N_DICE];
		for (int i =0; i<nums.length; i++)
		{
			nums[i] = (int)(Math.random()*6+1);
		}
		return nums;
	}

	private int[] getSomeDice(int[] nums){
		for (int i =0; i<nums.length; i++)
		{
			if (display.isDieSelected(i))
				nums[i] = (int)(Math.random()*6+1);
		}
		return nums;
	}

	public int[] getFrequencies(int[] dice){
		int[] freqs = new int[7];
		for (int i = 0; i<dice.length; i++)
		{
			freqs[dice[i]]++;
		}
		return freqs;
	}

	private int getWinner()
	{
		return 0; //FINISH THIS! THIS IS NOT CORRECT!
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
	}

}


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
	private boolean upperBonus=false;
	
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
		if(winner==-1){
			display.printMessage("There was a tie");
		}else
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

		/** handles upper score */
		int upperScore=0;
		for(int i=1; i<7; i++){
			upperScore+=scores[playerNum][i];
		}
		display.updateScorecard(7,playerNum+1,upperScore);

		/** handlrd lower score*/
		int lowerScore=0;
		for(int i=9; i<=15; i++){
			lowerScore+=scores[playerNum][i];
		}
		display.updateScorecard(16,playerNum+1,lowerScore);

		/** handles upper bonus */
		if(!upperBonus && upperScore>=63){
			display.updateScorecard(8,playerNum+1,35);
			scores[playerNum][8]=35;
			upperBonus=true;
		}

		/** handles total score */
		int total = 0;
		for(int a : scores[playerNum])
			total+=a;
		display.updateScorecard(17,playerNum+1,total);
			

	//  System.out.println(category);
}

	private int getPoints(int[] dice, int category){
		// all uppers follow the same scoring algorithm

		if(category>=1&&category<=6){
			return category*getFrequencies(dice)[category];
		}

		/** three of a kind */
		else if(category==9){
			for(int i=1; i<getFrequencies(dice).length;i++){
				if(getFrequencies(dice)[i]>=3){
					int total=0;
					for(int j=0; j<getFrequencies(dice).length;j++){
						total+=j*getFrequencies(dice)[j];
					}
					return total;
				}
			}
			return 0;
		}

		/** four of a kind */
		else if(category==10){
			for(int i=1; i<getFrequencies(dice).length;i++){
				if(getFrequencies(dice)[i]>=4){
					int total=0;
					for(int j=0; j<getFrequencies(dice).length;j++){
						total+=j*getFrequencies(dice)[j];
					}
					return total;
				}
			}
			return 0;
		}

		/** full house */
		else if(category==11){
			boolean triple,pair;
			triple=false;
			pair=false;
			for(int i=1;i<getFrequencies(dice).length;i++){
				if(getFrequencies(dice)[i]==3){
					triple=true;
				}
				else if(getFrequencies(dice)[i]==2){
					pair=true;
				}
			}
			if(pair && triple){
				return 25;
			}else{
				return 0;
			}
		}

		/** small straight*/
		else if(category==12){
			for(int i=1;i<getFrequencies(dice).length-2;i++){
				if(getFrequencies(dice)[i]!=0 && getFrequencies(dice)[i+1]!=0 && getFrequencies(dice)[i+2]!=0){
					return 30;
				}
			}
			return 0;
		}

		/** large straight */
		else if(category==13){
			for(int i=1;i<getFrequencies(dice).length-4;i++){
				if(getFrequencies(dice)[i]!=0 && getFrequencies(dice)[i+1]!=0 && getFrequencies(dice)[i+2]!=0
					&& getFrequencies(dice)[i+3]!=0 && getFrequencies(dice)[i+4]!=0){
					return 40;
				}
			}
			return 0;
		}

		/** Yahtzee */
		else if(category==14){
			for(int i : getFrequencies(dice)){
				if(i==5)
					return 50;
			}
			return 0;
		}

		/** change*/
		else if(category==15){
			int total=0;
			for(int j=1; j<getFrequencies(dice).length;j++){
				total+=j*getFrequencies(dice)[j];
			}
			return total;
		}

		else return 0;
	}

	/** Rolls all the dice */
	private int[] getDice(){
		int[] nums = new int[N_DICE];
		for (int i =0; i<nums.length; i++)
		{
			nums[i] = (int)(Math.random()*6+1);
		}
		return nums;
	}


	/** Re-rolls some of the dice */
	private int[] getSomeDice(int[] nums){
		for (int i =0; i<nums.length; i++)
		{
			if (display.isDieSelected(i))
				nums[i] = (int)(Math.random()*6+1);
		}
		return nums;
	}

	private int[] getFrequencies(int[] dice){
		int[] freqs = new int[7];
		for (int i = 0; i<dice.length; i++)
		{
			freqs[dice[i]]++;
		}
		return freqs;
	}

	private int getWinner()
	{
		int winner=0;
		int winscore=0;

		// cycles through every player
		for(int i=0;i<scores.length;i++){
			int total = 0;
			for(int a : scores[i]){
				total+=a;
			}
			if (total>winscore){
				winscore=total;
				winner=i;
			}
			else if(total==winscore){
				return -1;
			}
		}
		return winner;
	}

}
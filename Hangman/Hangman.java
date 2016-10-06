public class Hangman
{
	private String actualAnswer;
	private String lettersGuessed;
	private int guessesLeft;
	
	public Hangman()
	{
		actualAnswer = RandomPhraseGenerator.getRandomPhrase();
		guessesLeft = 7;
		lettersGuessed = "";
	}
	
	public String getActualAnswer()
	{
		return lettersGuessed;
	}
	
	public String getLettersGuessed() 
	{
		return lettersGuessed;
	}
	
	public int getGuessesLeft()
	{
		return guessesLeft;
	}
	
	public boolean makeGuess(String guess)
	{
		if (actualAnswer.indexOf(guess)==-1){
			guessesLeft--;
			return false;
			lettersGuessed+=guess;
		} else {
			return true;
		}
	}
	
	private boolean isLetter(String letter) 
	{return Character.isLetter(letter.charAt(0));}
	
	public String getPhraseSoFar()
	{
		String temp = "";

		// complete this
		
		return temp;
	}
	
}

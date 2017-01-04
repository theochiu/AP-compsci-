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
		return actualAnswer;
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
		lettersGuessed += guess;
		guess = guess.substring(0,1).toUpperCase();
		if (actualAnswer.indexOf(guess)==-1){
			guessesLeft--;
			return false;
		} else {
			return true;
		}
	}
	
	private boolean isLetter(String letter) 
	{return Character.isLetter(letter.charAt(0));}
	
	public String getPhraseSoFar()
	{
		String temp = "";

		for (int i=0; i<actualAnswer.length(); i++){
			String spot = actualAnswer.substring(i,i+1);
			if (isLetter(spot)==false){
				temp += spot; 
			} else {
				if(lettersGuessed.indexOf(spot)>-1){
					temp += spot;
				} else {
					temp += "-";
				}
			}
		}

		// complete this
		
		return temp;
	}
	
}

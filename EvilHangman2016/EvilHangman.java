import java.util.ArrayList;

public class EvilHangman extends Hangman
{
	private String lettersGuessed;
	private int guessesLeft;
	private WordFamily possibleAnswerFamily;

	public EvilHangman()
	{
		lettersGuessed = "";
		guessesLeft = 7;

		int length = (int) (Math.random()*8) +3;
		String pattern = "";

		for (int i=0; i<length; i++)
			pattern +="-"
		possibleAnswerFamily = new WordFamily(pattern);
		ArrayList<String> words = WordDictionary.getAllWordsOfLength(length);
		for (String word : words)
			possibleAnswerFamily.addWordToFamily(word);
	   
		// finish this in task #1
	}

	public String getPhraseSoFar()
	{
		return possibleAnswerFamily.getPatter();	
	}
	
	public String getActualAnswer()
	{
		return possibleAnswerFamily.getRandomWordFromFamily();
	}
	
	public String getLettersGuessed()
	{
		return lettersGuessed;
	}
	
	public int getGuessesLeft()
	{
		return guessesLeft;
	}
	
	private String getPatternFromWord(String word)
	{
		
	}
	
	private int findFamilyWithPattern(ArrayList<WordFamily> families, String pattern)
	{
		// finish this in task #4
	}
	
	public boolean makeGuess(String guess)
	{
		guess = guess.toUpperCase();
	   
		// finish this in task #5
	}

}

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

		for (int i=0; i<length; i++){
			pattern +="-";
		}
		possibleAnswerFamily = new WordFamily(pattern);
		ArrayList<String> words = WordDictionary.getAllWordsOfLength(length);
		for (String word : words){
			possibleAnswerFamily.addWordToFamily(word);
		}
	   
	}

	public String getPhraseSoFar()
	{
		return possibleAnswerFamily.getPattern();	
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
		String result = "";
		for (int i=0; i<word.length(); i++){
			if (lettersGuessed.indexOf(word.substring(i,i+1))!=-1){
				result += word.substring(i,i+1);
			} else {
				result += "-";
			}
		}
		return result;
	}
	
	private int findFamilyWithPattern(ArrayList<WordFamily> families, String pattern)
	{
		for (int i=0; i<families.size(); i++){
			if (families.get(i).getPattern().equals(pattern)){
				return i;
			}
		}
		return -1; 
	}
	
	public boolean makeGuess(String guess)
	{
		guess = guess.toUpperCase();
		lettersGuessed += guess;
		ArrayList<WordFamily> possibleFamilies = new ArrayList<WordFamily>();

		for (String word : possibleAnswerFamily.getAllWords()){
			if (findFamilyWithPattern(possibleFamilies , getPatternFromWord(word))==-1){
				WordFamily fam = new WordFamily(getPatternFromWord(word));
				possibleFamilies.add(fam);
			} else {
				possibleFamilies.get(findFamilyWithPattern(possibleFamilies , getPatternFromWord(word))).addWordToFamily(word);
			}
		}

		int champ = 0;

		for (WordFamily fam : possibleFamilies){
			if (fam.getNumWordsInFamily()>champ){
				champ = fam.getNumWordsInFamily();
				possibleAnswerFamily = fam; 
			}
		}

	/*
		for (int i=0; i<possibleFamilies.size(); i++){
			if (possibleFamilies.get(i).getNumWordsInFamily()>champ){
				champ = possibleFamilies.get(i).getNumWordsInFamily();
				possibleAnswerFamily = possibleFamilies.get(i);
			}
		}
	*/
		guessesLeft--;
		return (possibleAnswerFamily.getPattern().indexOf(guess)!=-1);
		





		// finish this in task #5
	}

}

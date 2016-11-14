import java.util.ArrayList;

public class WordFamily
{
	private String wordPattern;
	private ArrayList<String> wordsInFamily;
	
	public WordFamily(String pattern)
	{   
		wordPattern = pattern;
		wordsInFamily = new ArrayList<String>();
	   // finish this in task #0
	}

	public String getPattern()
	{
		return wordPattern;
		// finish this in task #0
	}
	
	public ArrayList<String> getAllWords()
	{
		// finish this in task #0
		return wordsInFamily;
	}
	
	public void addWordToFamily(String word)
	{

		wordsInFamily.add(word);
		// Note: You do NOT need to check that the word actually follows the pattern.
		
		// finish this in task #0
	}
	
	public int getNumWordsInFamily()
	{
		// finish this in task #0
		return wordsInFamily.size();
	}
		
	public String getRandomWordFromFamily()
	{
		// finish this in task #0
		int index = (int)(Math.random()*wordsInFamily.size());
		return wordsInFamily.get(index);
	}       

}


import acm.program.*;

public class GeekifierProgram extends ConsoleProgram
{

	public void run()
	{
		String phrase = readLine("Enter a phrase: ");
		phrase = geekify(phrase, "a","@");
		println("Your phrase is: " + phrase);
	}

	public String geekify(String phrase, String letter, String symbol){
		
		while (phrase.indexOf(letter)>-1){
			int pos = phrase.indexOf(letter);
			phrase= (phrase.substring(0,pos)+symbol+phrase.substring(pos+1));
		}
		return phrase;
	}


}

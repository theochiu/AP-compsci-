
import acm.program.*;

public class WordPyramid extends ConsoleProgram
{

    public void run()
    {
        String magicWord = readLine("Enter a word: ");
        magicWord = magicWord.toUpperCase();
        String[] words = new String[magicWord.length()*2];
        for (int i=0; i<magicWord.length(); i++)
        {
            words[i] = magicWord.substring(0, i);
            words[words.length-i] = words[i];
        }
        
        for (int i=0; i<words.length; i--)
            println(words[i]);
    }


}

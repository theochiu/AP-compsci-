import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public final class RandomPhraseGenerator
{
    
    public static String getRandomPhrase()
    {
        String temp;
        try
        {
            Scanner f = new Scanner(new File("phrases.txt"));
        ArrayList<String> phrases = new ArrayList<String>();
        while (f.hasNextLine())
        {
             phrases.add(f.nextLine());  
        }
        f.close();
        return phrases.get((int)(Math.random()*phrases.size()));
        }
        catch (Exception ex) {System.err.println("Error: No such file  - phrases.txt");}
        return "";
    }
}

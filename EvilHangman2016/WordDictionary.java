import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public final class WordDictionary
{
     
    public static ArrayList<String> getAllWordsOfLength(int length)
    {
        String temp;
        try
        {
            Scanner f = new Scanner(new File("w"+length+".txt"));
        ArrayList<String> phrases = new ArrayList<String>();
        while (f.hasNextLine())
        {
             phrases.add(f.nextLine().toUpperCase());  
        }
        f.close();
        return phrases;
        }
        catch (Exception ex) {System.err.println("Error: No such file w"+length+".txt");}
        return new ArrayList<String>();
    }
}

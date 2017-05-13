import java.io.*;
import java.util.*;
import acm.program.*;

public class PrintFiveLetterWords extends ConsoleProgram
{

	public void run()
	{

		try{
			File wordFile = new File("words.txt");
			Scanner wordScanner = new Scanner(wordFile);
			while(wordScanner.hasNextLine()){
				String line = wordScanner.nextLine();
				if(line.length()==5)
					println(line);
			}
		}

		catch(Exception e){
			println("error: " +e);
		}
	}


}

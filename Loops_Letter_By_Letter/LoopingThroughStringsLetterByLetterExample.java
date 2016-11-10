
import acm.program.*;

public class LoopingThroughStringsLetterByLetterExample extends ConsoleProgram
{

	public void run()
	{
		println("Enter a phrase.  Enter nothing to quit.");
		String phrase = readLine("--->");
		while (phrase.length()>0)
		{
			println("   There are " + countA(phrase) + " a's.");

			if (containsSpace(phrase))
				println("   This has a space.");
			else
				println("   This does not have a space.");

			if (sameXY(phrase))
				println("   There are the same number of x's and y's.");
			else
				println("   There are not the same number of x's and y's.");

			if (containsJK(phrase))
				println("   This has both a J and a K.");
			else
				println("   This does not have both a J and a K.");

			phrase = readLine("--->");
		}
		println("Good bye");
	}

	private int countA(String str)
	{
		return 0;  // just to get it to compile
	}

	private boolean containsSpace(String str)
	{
		for (int i=0; i<str.length(); i++)
			if (str.substring(i,i+1).equals(""))
				return true;
		return false;
	}

	private boolean sameXY(String str)
	{
		int xcounter=0;
		int ycounter=0;
		for (int i =0; i<str.length();i++){
			if (str.substring(i,i+1).equals("x"))
				xcounter++;
			else if (str.substring(i,i+1).equals("y"))
				ycounter++;
		}
		return (xcounter==ycounter);
	}

	private boolean containsJK(String str)
	{
		boolean foundj = false;
		boolean foundk = false;
		for (int i=0; i<str.length(); i++){
			if (str.substring(i,i+1).equals("j"))
				foundj=true;
			if (str.substring(i,i+1).equals("k"))
				foundk=true;
		}
		return foundj&&foundk;
	}

}

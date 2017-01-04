
import acm.program.*;

public class MiddleName extends ConsoleProgram
{

	public void run()
	{
		String bigname = readLine("Enter your full name: ");
		String middlename =  substring((bigname.indexOf(" ")+1) , substring((bigname.indexOf(" ")+1)).indexOf(" "));

	//	String middlename = bigname.indexOf(" ")
		println(middlename);
	}


}

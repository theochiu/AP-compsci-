
import acm.program.*;

public class BoringHymn extends ConsoleProgram
{
	String message="";
	
	public void run()
	{

		message += "Closing Hymn: \"Take the Word of God With You\" \n";
		message += "by Christopher Walker\n\n";
		verse("word");
		verse("peace");
		verse("joy");
		verse("hope");

		println(message);


	}

	public void verse(String arg){
		message += ("Take the " + arg + " of God with you as you go.\n");
		message += ("Take the seeds of God's " + arg + " and make them grow. \n \n");

		//chorus 
		message += ("Go in peace to serve the world, in peace to serve the world,\n");
		message += ("Take the love of God, the love of God with you as you go. \n");

	}


}

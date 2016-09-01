
import acm.program.*;

public class Ponies extends ConsoleProgram
{

	public void run()
	{
		println("Welcome to the pony leg calculator!");
		int numPonies = readInt("How many ponies?"); 
		int numLegs = numPonies * 4;
		println("You have " + numPonies + " ponies,");
		println("and you have "+ numLegs + " legs");		
	}


}

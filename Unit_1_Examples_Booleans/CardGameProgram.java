
import acm.program.*;

public class CardGameProgram extends ConsoleProgram
{

	public void run()
	{
		for (int i=0; i<5; i++){
			int num = (int) (Math.random()*52);
			Card cardy = new Card(num/13,num%13);
			println(cardy.toString());
		}
	}


}

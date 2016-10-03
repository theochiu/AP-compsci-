
import acm.program.*;

public class ChangeMaker extends ConsoleProgram
{

	public void run()
	{
		double cost1 = readDouble("Enter cost: ");
		double paid1 = readDouble("Enter paid: ");
	//	double change1 = paid - cost;

		long cost = (long)cost1;
		long paid = (long)paid1;
		long change = paid-cost;


		int changeInCents = (int) (change*100);
		int dollars = changeInCents/100;
		changeInCents%=100;

		int quarters = changeInCents/25;
		changeInCents%=25;

		int dimes = changeInCents/10;
		changeInCents%=10;

		int nickels = changeInCents/5;
		changeInCents%=5;

		int pennys = changeInCents/1;
		
		String message = "Your change is ";
		message += dollars+" dollars ";
		message += quarters+" quarters ";
		message += dimes + " dimes ";
		message += nickels + " nickels ";
		message += pennys + " pennys ";
		println(message);

	}


}

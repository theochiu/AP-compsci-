
import acm.program.*;

public class LeapYear extends ConsoleProgram
{

	public void run()
	{
		while (true)
		{
			int yr = readInt("Enter a year: ");
			if (isLeapYear(yr))
				println("That's a leap year!!!");
			else
				println("That's not a leap year!!!!");
		}
	}

	public boolean isLeapYear(int year){

		return year%400==0 || (year%100!=0 && )

		/*if(year%400==0)
			return true; 
		else if (year%100==0)
			return false;
		else 
			return year%4==0;*/
	}

}

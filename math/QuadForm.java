
import acm.program.*;

public class QuadForm extends ConsoleProgram
{

	public void run()
	{
		double a = readDouble("Enter a: ");
		double b = readDouble("Enter b: ");
		double c = readDouble("Enter c: ");

		double x1 = (-b* + Math.sqrt(Math.pow(b,2)-4*a*c)/(2*a));
		double x2 = (-b* - Math.sqrt(Math.pow(b,2)-4*a*c)/(2*a));

		if (x1==(Math.sqrt(-2))){
			println ("No real solution");
		} else{

		println("The solutions are "+x1+" and "+x2);
	}
	}
}

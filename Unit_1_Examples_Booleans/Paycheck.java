

public class Paycheck
{
	private double hoursWorked;
	private double hourlyRate;

	public Paycheck(double hours, double rate)
	{
		hoursWorked = hours;
		hourlyRate = rate;
	}

	public double getAmount()
	{
		if (hoursWorked<=40)
			double basepay = hoursWorked*hourlyRate;
		else 
			double basepay = (hoursWorked -40) * hourlyRate *1.5 + 40*hourlyRate;

		basepay
	}

}

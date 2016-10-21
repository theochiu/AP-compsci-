

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
	    double basepay;
		if (hoursWorked<=40)
			 basepay = hoursWorked*hourlyRate;
		else 
			 basepay = (hoursWorked -40) * hourlyRate *1.5 + 40*hourlyRate;

		double netpay = 0;

		if (basepay<200)
			netpay = basepay*(1-.11);
		else if ( basepay <400)
			netpay = basepay*(1-.15);
		else if (basepay<600)
			netpay = basepay*(1-.18);
		else 
			netpay = basepay*(1-.24);

		netpay -=14;

		if (netpay<=0)
			return 0;
		else 
			return netpay;
	}

}

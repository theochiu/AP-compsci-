

public class CollegeCounselor extends Employee implements Advisor
{

	public CollegeCounselor(String name)
	{
		super(name,40000);
	}

	public void doWork(double hours){
		System.out.println(getName()+" wrote "+ 4./3*hours+" letters of recommendation.");
	}

	public void giveAdvice(Student stud){
		System.out.println("Hey "+stud.getName()+", you should do better on your SAT's");
	}


}

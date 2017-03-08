

public class Teacher extends Employee{

	public Teacher(String name){
		super(name, 30000);

	}

	public void doWork(double hours){
		System.out.println(getName()+" graded "+3*hours+" papers.");
	}


}

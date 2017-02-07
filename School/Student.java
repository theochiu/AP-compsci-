

public class Student extends Person{

	public Student(String name){
		super(name);
	}

	public void doWork(double hours){
		System.out.println(getName()+"completed "+2*hours+" homework assignments.");
	}


}

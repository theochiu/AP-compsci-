

public abstract class Employee extends Person{
	private double salary;

	public Employee(String name, double salary){
		super(name);
		this.salary = salary;
	}

	public double getSalary(){
		return salary;
	}
	
}

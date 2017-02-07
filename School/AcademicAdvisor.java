

public class AcademicAdvisor extends Teacher implements Advisor{

	public AcademicAdvisor(String name){
		super(name);
	}

	public void giveAdvice(Student stud){
		System.out.println("Yo "+stud.getName()+" you should study harder.");
	}


}

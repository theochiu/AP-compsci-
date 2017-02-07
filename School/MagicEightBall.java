

public class MagicEightBall implements Advisor{

	public MagicEightBall(){

	}

	public void giveAdvice(Student stud){
		System.out.println("Dear " +stud.getName()+", you should ask again.");
	}


}

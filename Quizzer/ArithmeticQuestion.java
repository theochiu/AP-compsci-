

public class ArithmeticQuestion implements Question{

	private int num1;
	private int num2;

	public ArithmeticQuestion(){
		num1 = (int) (Math.random()*90)+10;
		num2 = (int) (Math.random()*90+10);
	}

	public String getQuestion(){
		return "What is " + num1 + "+" + num2 + " ?";
	}

	public String getAnswer(){
		return " "+ (num1+num2);
	}

	public boolean isCorrect(String answer){
		return answer.equals(getAnswer());
	}

}

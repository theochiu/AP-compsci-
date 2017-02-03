import java.util.*;
import acm.program.*;

public class Quiz extends ConsoleProgram{

	public void run(){
		ArrayList<Question> questions = new ArrayList<Question>();
		for(int i=0; i<10;i++){
			Question q;
			if(Math.random()<0.5){
				q = new ArithmeticQuestion();
			} else {
				q = new FavoriteQuestion();
			}
			questions.add(q);
		}
		int numCorrect=0;
		for (int i=0; i<questions.size(); i++){
			println(questions.get(i).getQuestion());
			String response = readLine("Your response? ");
			if (questions.get(i).isCorrect(response)){
				println("Correct!");
				numCorrect++;
			} else{
				println("Incorrect!");
				println("The correct answer was "+questions.get(i).getAnswer());
			}
		}
		println("Your score was" + numCorrect + "/"+questions.size()+".");
	}


}

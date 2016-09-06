/* Copyright 2016, Theodore Chiu, All rights reserved. */
import acm.program.*;

public class StudentRunner extends ConsoleProgram
{

	public void run()
	{
		Student stud = new Student("Theo");
		stud.takeQuiz(8);

		String message="";
		
		message += stud.getName();
		message += " got a ";
		stud.takeQuiz(10);
		stud.takeQuiz(30);
		message+=(stud.quizAverage());
		message+=" in Kmo's class!";
		println(message);
	}


}

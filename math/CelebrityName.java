/* Copyright 2016, Theodore Chiu, All rights reserved. */

import acm.program.*;

public class CelebrityName extends ConsoleProgram
{

	public void run()
	{
		String target = readLine("Enter celebrity name: ");
		String last2 = target.substring(target.indexOf(" ")-2,target.indexOf(" "));
		String first2 = target.substring(target.indexOf(" ") + 1 , 3+ target.indexOf(" ") );

		for (int i=0;i<100;i++){
			println();
		}

		println("clue: " + last2+" "+first2);

		String guess = readLine("Enter your guess: ");
		if (guess.equals(target)){
			println("Correct");
		} else {
			println("Incorrect");
		}
	}


}

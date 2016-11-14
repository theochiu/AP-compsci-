
import acm.program.*;

public class HangmanProgram extends ConsoleProgram
{

    public void run()
    {
        Hangman man = new EvilHangman();
        println("Welcome to Hangman!");
        
        boolean keepGoing = true;
        while (keepGoing == true)
        {
            println("Phrase so far = " + man.getPhraseSoFar());
            String guess = readLine("Enter a letter: ");
            if (man.makeGuess(guess) == true)
            {
                println("Correct!");
            }
            else
            {
               println("Wrong!"); 
               println("You now have " + man.getGuessesLeft() + " guesses left.");
            }
            println("Letters guessed = " + man.getLettersGuessed());
            if (man.getGuessesLeft() == 0)
                keepGoing = false;
            if (man.getPhraseSoFar().equals(man.getActualAnswer()))
                keepGoing = false;
        }
        
        if (man.getGuessesLeft() == 0)
        {
             println("You lost!");
             println("The actual answer was: " + man.getActualAnswer());
        }
        else
            println("You win!");
        
    }


}

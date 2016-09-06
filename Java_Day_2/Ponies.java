
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        String name;
        name = readLine("What is your name? ");
        println("Hello " + name + "!!!!!!");
        
        int ponies;
        ponies = readInt("How many ponies? ");
        println("You have " + ponies + " ponies.");
        int legs;
        legs =  ponies * 4;
        println("There are " + legs + " total legs!");
        
    }


}

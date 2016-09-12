
import acm.program.*;

public class HappyBirthday extends ConsoleProgram
{

    public void run()
    {
        sing("Jack");
        sing("Queen Elizabeth");
        sing("Eazy-E");
    }

    public void sing(String name)
    {
        println("Happy birthday to you");
        println("Happy birthday to you");
        println("Happy birthday dear " + name);
        println("Happy birthday to you");
        println();
    }

}

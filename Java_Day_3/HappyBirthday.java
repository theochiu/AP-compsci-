
import acm.program.*;

public class HappyBirthday extends ConsoleProgram
{

    public void run(){
        happy("Jack");
        happy("Queen Elizabeth I");
        happy("Eazy-E");
    }
    
    public void happy(String who){
        println("Happy Birthday to you");
        println("Happy Birthday to you");
        println("Happy birhtday to " + who);
        println("Happy birthday to you\n");
    }

}

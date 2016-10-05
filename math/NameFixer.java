
import acm.program.*;

public class NameFixer extends ConsoleProgram
{

    public void run()
    {
        String name = readLine("Enter your name: ");
        int space = name.indexOf(" ");
        String first = name.substring(0,space);
        String last = name.substring(1+space);
        println(last+" "+first);
    }


}


import acm.program.*;

public class DieHard extends ConsoleProgram
{

    public void run()
    {
        WaterPuzzle puzz = new WaterPuzzle();
        
        puzz.fill("A");
        puzz.pourFromAtoB();
        puzz.empty("B");
        puzz.pourFromAtoB();
        puzz.fill("A");
        puzz.pourFromAtoB();
        
        println(puzz.getAmount("A"));
    }


}

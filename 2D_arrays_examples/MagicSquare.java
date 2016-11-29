
import acm.program.*;

public class MagicSquare extends ConsoleProgram
{

    public void run()
    {
        int size = 3;
        int[][] square = getRandomSquare(size);
        while (!isMagicSquare(square))
            square = getRandomSquare(size);
    }


}

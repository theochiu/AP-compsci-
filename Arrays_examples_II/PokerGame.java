
import acm.program.*;
import java.util.ArrayList;

public class PokerGame extends ConsoleProgram
{

    public void run()
    {
        ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
        for (int i=0; i<52 ; i++)
        {
            PlayingCard card = new PlayingCard(i%13, i/13);
            int index = (int)(Math.random()*deck.size());
            deck.add(index, card);
        }
        for (int i=0; i<5; i++)
        {
            println(deck.remove(0).getDescription());
        }
        println();
        for (int i=0; i<5; i++)
        {
            println(deck.remove(0).getDescription());
        }
    }


}

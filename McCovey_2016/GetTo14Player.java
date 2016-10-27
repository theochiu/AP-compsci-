

public class GetTo14Player implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >= 44)
            return false;
        return (turnScore < 14);
    }
}



public class theoplayer implements McCoveyPlayer
{

    public boolean rollAgain(int myScore, int yourScore, int turnScore)
    {
        if (myScore + turnScore >=44)
            return false;


    //  if (myScore-turnScore >= 6)
    //      return true;


        if (myScore+turnScore>=34)
            return true;
        


        if ((44-yourScore <= 17) && (turnScore<30))
            return true;
        

    

        

        return (turnScore<14);
    }
}



    //  if (turnScore<21)
    //      return true;
    //  if ((int) (Math.random()*2)==0)
	//		return turnScore<22;
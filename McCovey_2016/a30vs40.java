

public class a30vs40 implements McCoveyPlayer{
 
	public boolean rollAgain(int myScore, int yourScore, int turnScore)
	{
		if (myScore + turnScore >=44)
			return false;
		if (44 - myScore+turnScore <= 39)
			return true;
		if ((44-yourScore <= 17) && (turnScore<30))
			return true;

		return (turnScore<14);
	}
}



	//	if (turnScore<21)
	//		return true;
	//	if ((int) (Math.random()*2)==0)
	//		return turnScore<22;

    //  if (turnScore<21)
    //      return true;
    //  if ((int) (Math.random()*2)==0)
	//		return turnScore<22;
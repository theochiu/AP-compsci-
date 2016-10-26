

public class a30vs40 implements McCoveyPlayer
{

	public boolean rollAgain(int myScore, int yourScore, int turnScore)
	{
		if (myScore + turnScore >=44)
			return false;
		if ((44-yourScore <= 16) && (turnScore<30))
			return true;

		return (turnScore<14);
	}
}


public class Card
{
	private int mySuit;  // 0 through 3
	private int myRank; // 0 through 12
	
	public Card(int initialSuit, int initialRank)
	{
		mySuit = initialSuit;
		myRank = initialRank;
	}
	
	public String getSuit()
	{
		if (mySuit==0)
			return "spades";
		else if (mySuit==1)
			return "hearts";
		else if (mySuit==2)
			return "diamonds";
		else
			return "clubs";
	}
	
	public String getRank()
	{
		if (myRank==0)
			return "ace";
		else if (myRank==10)
			return "jack";
		else if (myRank==11)
			return "queen";
		else if (myRank==12)
			return "king";
		else 
			return String.valueOf(1+myRank);
	}
	
	public String toString()
	{
		return getRank()+" of "+getSuit();
	}
	


}


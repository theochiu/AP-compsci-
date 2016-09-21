

public class VotingMachine{

	private int numYes;
	private int numNo;


	public VotingMachine(){
		numYes=0;
		numNo=0;
	}

	public void voteYes(){
		numYes++;
	}
	
	public void voteNo(){
		numNo--;
	}
	
	public void rigElection(double rigFactor){
		int stolenVotes = (int)(numNo*rigFactor);
		numYes+=stolenVotes;
		numNo-=stolenVotes;
	}

	public double getYesPercent(){
		return (100.0* numYes/(numYes+numNo));
	}

	public double getNoPercent(){
		return 100.0 - getYesPercent();
	}

	public String getWinner(){
		if (numYes==numNo){
			return ("tie");
		}

		else if (numYes>numNo){
			return ("yes");
		}else{
			return ("no");
		}
	}

}

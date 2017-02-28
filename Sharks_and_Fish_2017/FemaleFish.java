import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class FemaleFish extends Fish
{
	// constants
	private final static int GESTATIONPERIOD = 5;
	private final static int MAXBABIES = 4;
	
	// private instance variables
	private int numBabies;
	private int turnsPregnant;
	
	public FemaleFish()
	{
		super();  // needed to call Fish constructor, which initializes age
		setColor(Color.PINK);
	}

	public void giveBirth(){
		ArrayList<Location> possibleLocations = getMoveLocations();
		Grid<Actor> gr = getGrid();
		if (possibleLocations.size()>=numBabies){
			for(int i=0;i<numBabies;i++){
				if(Math.random()>0.5){
					FemaleFish babyFish = new FemaleFish();
					babyFish.putSelfInGrid(gr,possibleLocations.get(0));
					possibleLocations.remove(0);
				}else{
					MaleFish babyMaleFish = new MaleFish();
					babyMaleFish.putSelfInGrid(gr,possibleLocations.get(0));
					possibleLocations.remove(0);
				}
			}
		}
	}
	
	// finish this up
}

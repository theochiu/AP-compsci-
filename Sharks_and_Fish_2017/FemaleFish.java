import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.*;

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

	private void giveBirth(){
		ArrayList<Location> possibleLocations = getMoveLocations();
		Grid<Actor> gr = getGrid();
		if (possibleLocations.size()>= numBabies){
			for (int i=0; i<numBabies; i++){
				if (Math.random() >0.5){
					FemaleFish babyFish = new FemaleFish();
					babyFish.putSelfInGrid(gr, possibleLocations.get(0));
					possibleLocations.remove(0);
				}
				else{
					MaleFish babyMaleFish = new MaleFish();
					babyMaleFish.putSelfInGrid(gr, possibleLocations.get(0));
					possibleLocations.remove(0);
				}
			}
			numBabies = 0;
			turnsPregnant = 0;
			setColor(Color.PINK);
		}else{
			int reps = possibleLocations.size();
			for (int i =0; i<reps; i++){
				if (Math.random() >0.5){
					FemaleFish babyFish = new FemaleFish();
					babyFish.putSelfInGrid(gr, possibleLocations.get(0));
					possibleLocations.remove(0);
				}else{
					MaleFish babyMaleFish = new MaleFish();
					babyMaleFish.putSelfInGrid(gr, possibleLocations.get(0));
					possibleLocations.remove(0);
				}
			}
			numBabies = numBabies-reps;

		}
	}

	public ArrayList<Actor> getActors(){
		ArrayList<Actor> actors = super.getActors();
		ArrayList<Actor> fish = new ArrayList<Actor>();
		for (Actor a : actors)
			if (a instanceof Fish)
				fish.add(a);
		return fish;
	}

	public void processActors(ArrayList<Actor> actors){
		for(Actor f : actors){
		    Fish fish = (Fish)(f);
			if(f instanceof MaleFish && fish.getAge()>=BREEDAGE && getAge()>=BREEDAGE && numBabies==0){
				numBabies = (int) (Math.random()*MAXBABIES);
				setColor(Color.red);
				turnsPregnant=1;
			}
		}
	}

	public void act(){
		if(turnsPregnant>=GESTATIONPERIOD){
			giveBirth();
			return;
		}
		else if(turnsPregnant>0)
			turnsPregnant++;
		super.act();
	}
	
	// finish this up
}



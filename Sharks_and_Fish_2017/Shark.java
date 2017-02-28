
import info.gridworld.actor.Critter;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.grid.*;

public class Shark extends Critter
{
	// constants
	private static final int MUSTEAT = 8;

	// private instance variables
	private int turnsSinceEaten;
	
	public Shark()
	{
		setColor(Color.black);
	}

	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> result = new ArrayList<Location>();
		Grid<Actor> gr = getGrid();
		Location currentLoc = getLocation();
		int currentDir = getDirection();
		int[] possibleDirs = {Location.HALF_LEFT, Location.HALF_RIGHT, Location.AHEAD};
		for(int dir : possibleDirs){
			Location possibleLoc = currentLoc.getAdjacentLocation(currentDir+dir);
			if (gr.isValid(possibleLoc)&&gr.get(possibleLoc)==null){
				result.add(possibleLoc);
			}
		}
		return result;
	}

	public void makeMove(Location loc){
		Location current = getLocation();
		int dir1= current.getDirectionToward(loc);
		setDirection(dir1);
		if (loc.equals(getLocation())){
			int dir = Location.HALF_LEFT;
			if(Math.random()<0.5)
				dir = Location.HALF_RIGHT;
			setDirection(getDirection()+dir);
		} else {
			super.makeMove(loc);
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

	public void act(){
		if(turnsSinceEaten==MUSTEAT)
			removeSelfFromGrid();
		else if(getActors().size()>0){
			processActors(getActors());
			turnsSinceEaten=0;
		}else{
			ArrayList<Location> moveLocs = getMoveLocations();
			Location loc = selectMoveLocation(moveLocs);
			makeMove(loc);
			turnsSinceEaten++;
		}
	}

	public void processActors(ArrayList<Actor> actors){
		int whichOne = (int)(Math.random()*actors.size());
		actors.get(whichOne).removeSelfFromGrid();
		actors.remove(whichOne);
		turnsSinceEaten=0;
	}

	
	// finish this up

}

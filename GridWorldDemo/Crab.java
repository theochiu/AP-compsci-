
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.*;
import java.util.ArrayList;

public class Crab extends Critter{

	public Crab(){
		setColor(Color.red);
	}

	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> result = new ArrayList<Location>();
		Grid<Actor> gr = getGrid();
		Location currentLoc = getLocation();
		int currentDir = getDirection();
		int[] possibleDirs = {Location.LEFT, Location.RIGHT};
		for(int dir : possibleDirs){
			Location possibleLoc = currentLoc.getAdjacentLocation(currentDir+dir);
			if (gr.isValid(possibleLoc)&&gr.get(possibleLoc)==null){
				result.add(possibleLoc);
			}
		}
		return result;
	}

	public void makeMove(Location loc){
		if (loc.equals(getLocation())){
			int dir = Location.LEFT;
			if(Math.random()<0.5)
				dir = Location.RIGHT;
			setDirection(getDirection()+dir);
		} else {
			super.makeMove(loc);
		}
	}

	public ArrayList<Actor> getActors(){
		ArrayList<Acto> result = new ArrayList<Actor>();
		Grid<Actor> gr = getGrid();
		Location current = getLocation();
		int currentDir = getDirection();
		int[] possibleDirs = {Location.FRONT, Location.HALF_LEFT, Location.HALF_RIGHT};
		for (int dir: possibleDirs){
			Location possibleLoc = currentLoc.getAdjacentLocation(current);
			if(gr.isValid(possibleLoc) && gr.get(possibleLoc)!=null){
				resuult.add(gr.get(possibleLoc));
			}
		}
		return result;
	}



}


import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.*;
import java.util.ArrayList;

public class Chameleon extends Critter 
{

	public void processActors(ArrayList<Actor> actors){
		if (actors.size()==0)
			return;
		int index = (int) Math.random()*actors.size();
		actor a = actors.get(index);
		setColor(a.getColor());
	}

}


import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.*;
import java.util.ArrayList;

public class RockEater extends Critter
{

	public RockEater()
	{
		setColor(Color.gray);
	}

	public void procesActors(ArrayList<Actor> actors){
		for (Actor a : actors){
			if (a instanceof Rock)
				a.removeSelfFromGrid();
		}
	}


}

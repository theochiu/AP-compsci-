
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class Runner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		world.add(new Bug());
		world.add(new Critter());
		world.add(new LeftBug());
		world.add(new RockEater());
		for (int i=0; i<4; i++){
			world.add(new Rock());
		}
		world.add(new Chameleon());
		world.show();

	}
}

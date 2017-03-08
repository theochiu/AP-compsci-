
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.*;

public class LeftBug extends Bug
{

	public LeftBug()
	{
		setColor(Color.pink);
	}

	public void turn(){
		setDirection(getDirection() - Location.HALF_RIGHT);
	}


}

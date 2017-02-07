import acm.graphics.*;
import java.awt.Color;

public class Asteroid extends GVectorPolygon
{
	private double rotation;

	public Asteroid(int width, int height)
	{
		super(width,height);
		rotation = Math.random();
		addVertex(0,0);
		addVertex(20,0);
		addVertex(55,55);
		addVertex(0,37);
		recenter();
		setColor(Color.white);
	}

	// override the updatePosition

	public void updatePosition(){
		rotate(rotation);
		super.updatePosition();
	}
}

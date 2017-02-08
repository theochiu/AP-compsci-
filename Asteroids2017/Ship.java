import java.awt.Color;

public class Ship extends GVectorPolygon
{

	public Ship(int w, int h)
	{
		// write this in version 0.4 
		super(w,h);
		addVertex(0, 0);
		addVertex(7, 2);
		addVertex(0, 4);
		addVertex(-2, 2);
		recenter();
		scale(4, 4);
		setColor(Color.WHITE); 
	}

	// you'll add a method here in version 0.5.1

}

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

	public Bullet makeBullet() {

		Bullet b = new Bullet((int)getBoundingRectangle().getWidth(), (int)getBoundingRectangle().getHeight());
		b.rotate(getTheta());
		b.setLocation(getX(), getY());
		for (int i = 0; i < 15; ++i) {
			b.increaseVelocity(3);
		}
		return b;
	}

	// you'll add a method here in version 0.5.1

}

import java.awt.Color;

public class Bullet extends GVectorPolygon
{
	private int numTurns;
	
	private static final int MAXTURNS=150;
	
	public Bullet(int w, int h) {
		super(w, h);
		addVertex(0, 0);
		addVertex(0, 2);
		addVertex(2, 2);
		addVertex(2, 0);
		setColor(Color.WHITE);
		numTurns = 0;
	}

	public boolean stillMoving() {
		return numTurns < 150;
	}

	public void updatePosition() {
		numTurns++;
		super.updatePosition();
	}
}
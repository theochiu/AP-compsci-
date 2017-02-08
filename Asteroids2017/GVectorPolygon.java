import acm.graphics.*;

public class GVectorPolygon extends GPolygon
{
	private double vx=0;
	private double vy=0;
	private double theta;
	private double maxX, maxY; // dimensions of the "window" to enable "wrapping around"

	private static final double MAXVELOCITY = 3;

	public GVectorPolygon(int width, int height)
	{
	   // to be written in version 0.1
	   maxY = height;
	   maxX = width;
	   theta =0;
	   
	}

	public void increaseVelocity(double numPixels)
	{
		double thetaInRadians = theta*Math.PI/180;
		vx += numPixels*Math.cos(thetaInRadians);
		vy -= numPixels*Math.sin(thetaInRadians);
		double v = Math.sqrt(vx*vx + vy*vy);
		if (v>MAXVELOCITY){
			vx *= MAXVELOCITY/v;
			vy *= MAXVELOCITY/v;
		}
	}

	public void updatePosition() {
		move(vx, vy);
		if (getX() < 0.0)
			setLocation(maxX, getY());
		else if (getX() > maxX) 
			setLocation(0.0, getY());
		
		if (getY() < 0.0) 
			setLocation(getX(), maxY);
		else if (getY() > maxY) 
			setLocation(getX(), 0.0);
		
	}

	public void rotate(double angle)
	{
		// to be written in version 0.1 
		super.rotate(angle);
		theta+=angle;
	}

	public double getTheta()
	{
		return theta;
	}

	public double getVelocityX()
	{
		return vx;
	}

	public double getVelocityY()
	{
		return vy;
	}

	public GRectangle getBoundingRectangle()
	{
		return new GRectangle(0,0,maxX, maxY);
	}
}

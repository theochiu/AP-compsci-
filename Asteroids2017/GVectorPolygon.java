import acm.graphics.*;

public class GVectorPolygon extends GPolygon
{
    private double vx, vy;
    private double theta;
    private double maxX, maxY; // dimensions of the "window" to enable "wrapping around"

    private static final double MAXVELOCITY = 3;

    public GVectorPolygon(int width, int height)
    {
       // to be written in version 0.1
       maxY = width;
       maxX = height;
       theta =0;
       
    }

    public void increaseVelocity(double numPixels)
    {
       // to be written in version 0.1
       double magnitude = Math.sqrt(Math.pow(vx,2)+Math.pow(vy,2));
       magnitude+=numPixels;
       double rad = (theta*Math.PI)/180;
       if (magnitude>MAXVELOCITY)
           magnitude=MAXVELOCITY;
       vx += magnitude*(Math.cos(rad));
       vy -= magnitude*(Math.sin(rad));
    }

    public void updatePosition()
    {
        // to be written in version 0.1
        move(vx,vy);
        if(getX()>maxX)
            setLocation(0,getY());
        else if (getX()<0)
            setLocation(maxX,getY());
        if (getY()>maxY)
            setLocation(getX(),0);
        else if (getY()<0)
            setLocation(getX(),maxY);
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

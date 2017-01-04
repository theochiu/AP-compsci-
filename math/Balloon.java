

public class Balloon
{
	private static final double MAXVOLUME = 10000;
	private double radius;
	private boolean popped;

	public Balloon(){
		radius = 0;
		popped = false;
	}

	public void inflate(double ccAdded){
		double volume = getVolume() + ccAdded;

		if ((volume < MAXVOLUME)&&(popped==false)){
			radius = Math.pow((3*volume)/(4*Math.PI),1.0/3);
		} else {
			popped = true;
			radius = 0; 
		}
	}

	public double getRadius(){
		return radius;
	}

	public double getSurfaceArea(){
		return 4*Math.PI*Math.pow(radius,2);
	}

	public double getVolume(){
		return 4./3*Math.PI*Math.pow(radius,3);
	}


}

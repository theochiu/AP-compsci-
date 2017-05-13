

public class Dog
{

	private String name;
	private int idNum;

	private static String sound="woof";
	private static int nextAvailableIDnum=100;

	public Dog(String name){
		this.name=name;
		idNum = nextAvailableIDnum;
		nextAvailableIDnum++;
	}


}

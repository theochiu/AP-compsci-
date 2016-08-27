
import stanford.karel.*;

public class HurricaneDamage2 extends Karel
{

	public void run()
	{
		while (frontIsClear()){
			while(!beepersPresent()){
				move();
			}
			pickBeeper();
			buildHouse();
		}
	}

	public void buildHouse(){
		taround();
		move();
		turnRight();
		for (int i=0;i<3;i++){
			putBeeper();
			move();
		}
		turnRight();
		move();
		turnLeft();
		move();
		taround();
		for (int i=0;i<3;i++){
			putBeeper();
			move();
		}
		turnLeft(); move(); turnLeft(); taround();
		for (int i=0;i<3;i++){
			putBeeper();
			move();
		}
	}

	public void turnRight(){
		for (int i=0;i<3;i++){
			turnLeft();
		}
	}

	public void taround(){
		for (int i=0;i<2;i++){
			turnLeft();
		}
	}

	/* IGNORE THE CODE BELOW.  (Don't delete it, but we
	 * had to include it to get Karel to play nicely with
	 * BlueJ.  You don't need to understand what it means
	 * at all.  */
	public static void launchKarelEnvironment()
	{
		String[] args = new String[1];
		String name = new SecurityManager() {
			public String className() 
				{return this.getClassContext()[1].getCanonicalName();}
			}.className();
		args[0] = "code=" + name;         
		Karel.main(args);
	}
}

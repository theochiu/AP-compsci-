// Theodore Chiu
import stanford.karel.*;

public class MidpointFinder extends Karel
{

	public void layoutRows(){
		while (!frontIsBlocked()){
			move();
			putBeeper();
		} // remove last beeper
		pickBeeper();
		turnLeft();
		turnLeft();
		move();
	}

	public void run()
	{
		layoutRows();
		while (beepersPresent()){
			bounceAround();
		}
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
	}

	public void bounceAround(){
		while (beepersPresent()){
			move();
		}
		turnLeft();
		turnLeft();
		move();
		pickBeeper();
		move();

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

// Copyright 2016, Theodore Chiu, All rights reserved.

import stanford.karel.*;

public class SpringTime extends Karel
{

	public void run(){
		for (int i=0; i<5;i++){
			while (frontIsClear()){
				move();
			}
			turnLeft();
			while (rightIsBlocked()){
				move();
			}
			petal();
			while (frontIsClear()){
				move();
			}
			turnLeft();
			
		}
	}

	public void petal(){
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		putBeeper();
		move(); 
		putBeeper();
		turnRight();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
	}

	public void turnRight(){
		for (int i=0; i<3; i++){
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

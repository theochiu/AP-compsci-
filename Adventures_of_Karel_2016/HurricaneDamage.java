
import stanford.karel.*;

public class HurricaneDamage extends Karel
{

    public void turnRight(){
        turnLeft(); turnLeft(); turnLeft();
    }
    public void upRight(){
        turnLeft(); move(); turnLeft();turnLeft();turnLeft(); move();
    }
    public void downLeft(){
        move(); turnLeft();turnLeft();turnLeft(); move();turnLeft();
    }
    public void backwards(){
        turnLeft();turnLeft();
    }

    public void buildhouse(){
        //build house and move on //pickup beeper first
        // the below builds the house and makes a door
        pickBeeper();
        backwards(); move();putBeeper();
        turnRight(); move(); putBeeper();
        turnRight(); move(); putBeeper();
        move(); putBeeper(); 
        turnRight(); move(); putBeeper(); 
        turnLeft(); 
        if (frontIsClear()==true){
            move();
        }
    }

    public void run(){
        while (frontIsClear()==true){
            if (beepersPresent()==false){
                while (beepersPresent()==false){
                    move();
                }
            }
            if (beepersPresent()==true){
                buildhouse();
            }        
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


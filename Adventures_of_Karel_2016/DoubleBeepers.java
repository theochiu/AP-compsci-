
import stanford.karel.*;

public class DoubleBeepers extends Karel
{

    public void run()
    {
        move();
        doublePile();
        moveBackwards();
    }

    public void moveBackwards(){
        turnLeft(); turnLeft();
        move();
        turnLeft();turnLeft();
    }

    public void doublePile(){
        createDoublePile();
        movePileBack();
    }

    public void createDoublePile(){
        while (beepersPresent()){
            puttwo();
        }
    }

    public void puttwo(){
        move();
        putBeeper();
        putBeeper();
        moveBackwards();
    }

    public void movePileBack(){
        move();
        while (beepersPresent()){
            pickBeeper();
            moveBackwards();
            putBeeper();
            move();
        }
        moveBackwards();
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

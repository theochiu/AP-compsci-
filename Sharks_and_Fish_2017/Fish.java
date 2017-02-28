import info.gridworld.actor.Critter;

public class Fish extends Critter
{
    // constants (note that this are "protected", so they are
    // available in subclasses of Fish)
    protected final static int BREEDAGE = 5;
    protected final static int OLDAGE = 15;
    protected final static double PROBOFDYING = 0.20;

    // private instance variales
    private int age;
        
    public Fish()
    {
       age=0;
    }

    public void act(){
        age++;
        if(age>OLDAGE){
            if(Math.random()<PROBOFDYING)
                removeSelfFromGrid();
        }
        super.act();
    }
    
    // finish this up
    
}

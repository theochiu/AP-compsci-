
public class Bird implements Flier
{
    private String mySpecies;
    
    public Bird(String species)
    {
        mySpecies = species;
    }

    public void fly()
    {
        System.out.println("This " + mySpecies + " is using its wings to fly.  Whee!");
    }
    

}

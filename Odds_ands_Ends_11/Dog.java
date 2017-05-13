

public class Dog
{
    // private INSTANCE variables
    private String name;
    private int tagNumber;
    
    // private STATIC (BORG) variables
    private static String sound = "woof";
    private static int nextAvailableTagNumber = 100;

    public Dog(String initialName)
    {
        name = initialName;
        tagNumber = Dog.nextAvailableTagNumber;
        Dog.nextAvailableTagNumber++;
    }
    
    public String getName()
    {
        return name;
    }
    
    public static String getSound()
    {
        return Dog.sound;
    }
    
    public static boolean isHappyToSeeYou()
    {
        return true;
    }

    public int getTagNumber(){
        return tagNumber;
    }

}

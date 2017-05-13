import java.util.*;

public class DogPound
{

    public static void main(String[] args)
    {
    	String[] posname = {"Fido", "Bud" , "Butch" , "Fluffy", "Champ","Fifi"};
    	ArrayList<Dog> dogs = new ArrayList<Dog>();

    	for(int i=0; i<101; i++){
    		String name = posname[(int)(Math.random()*posname.length)];
    		Dog d = new Dog(name);
    		dogs.add(d);
    	}

    	for(Dog dog : dogs){
    		System.out.println(dog.getName()+" " +dog.getTagNumber()+" "+ Dog.getSound());
    	}
    }


}

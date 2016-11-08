
import acm.program.*;
import java.util.ArrayList;

public class PartnerPicker extends ConsoleProgram
{

	public void run()
	{
		ArrayList<String> students = new ArrayList<String>();
		students.add("CJ");
		students.add("RJ");
		students.add("Theo");
		students.add("Emma");
		students.add("Desai");
		students.add("Enright");
		students.add("Haire");
		students.add("Luca");
		students.add("Emily");
		students.add("Connor");
		students.add("Will");
		students.add("Graham");
		//students.add("Fred");
		students.add("Molumphy");
		students.add("Sabrina");
		students.add("Peterson");
		students.add("Izzy");
		students.add("Grace");
		students.add("Brett");
		students.add("Burlinson");     
		students.add("Jetta");   
		students.add("Max");    
		students.add("Ethan");  
		students.add("Alex");  
		students.add("Trey");
		students.add("Gabi");
		students.add("James");     
		students.add("Kylee");   
		students.add("Leahy");    
		students.add("Evan");  
		students.add("Eliza");  
		students.add("Pleasants");
		students.add("Josh");  
		students.add("Robbie");

		while (students.size()>2){
			int index = (int) (Math.random()*students.size());
			String studentOne = students.remove(index);
			//students.remove(index);
			index = (int) (Math.random()*students.size());
			String studentTwo = students.remove(index);
			//students.remove(index);
			println(studentOne + " and " + studentTwo);

		}

		if (students.size()==1)
			println(students.get(0) + " has no partner.");

	}
}
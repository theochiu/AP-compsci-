
import acm.program.*;

public class ArrayOfStudents extends ConsoleProgram
{

	public void run()
	{
		String[] students = new String[33];
		initializeStudents(students);
		
		for (int i=0; i<students.length; i++) {
			if (students[i].indexOf("e") != -1)
				println(students[i]);
		}

		int counter = 0 ; 
		for (int i=0; i<students.length; i++){
			if (students[i].substring(0,1).equals("D"))
				counter++;
		}

		String champion = students[0];
		for (int i=0; i<students.length; i++){
			if (students[i].length() > champion.length())
				champion = students[i];
		}
		println("The longest name is " + champion);

	}

	
	public void initializeStudents(String[] students)
	{
		students[0] = "C.J. Box";
		students[1] = "R.J. Brockett";
		students[2] = "Theo Chiu";
		students[3] = "Emma Connors";
		students[4] = "David Desai";
		students[5] = "Jackson Enright";
		students[6] = "Zack Haire";
		students[7] = "Luca Herden";
		students[8] = "Emily Howard";
		students[9] = "Connor Johnston";
		students[10] = "Will Long";
		students[11] = "Graham MacFarquhar";
		students[12] = "Jack Molumphy";
		students[13] = "Sabrina Nunn";
		students[14] = "David Peterson";
		students[15] = "Izzy Rhyu";
		students[16] = "Grace Zdeblick";
		students[17] = "Brett Anstrom";
		students[18] = "Jack Burlinson";
		students[19] = "Jetta Chu";
		students[20] = "Max Comoll";
		students[21] = "Ethan Feiber";
		students[22] = "Alex Harper";
		students[23] = "Trey Holterman";
		students[24] = "Gabi Irwin";
		students[25] = "James Kirkham";
		students[26] = "Kylee Kryzanich";
		students[27] = "Jack Leahy";
		students[28] = "Evan Nichols";
		students[29] = "Eliza Patterson";
		students[30] = "Jack Pleasants";
		students[31] = "Jack Suzuki";
		students[32] = "Robert Thompson";
	}
}

import acm.program.*;
import java.util.ArrayList;

public class ArrayListPractice extends ConsoleProgram
{
	public void run()
	{
		ArrayList<Integer> list = randomArrayList(10);

		printArrayList(list);

		println("*** #0 ***");

		println("Smallest value = " + findMinimum(list));

		println("*** #1 ***");

		printArrayList(twiceArrayList(list));

		println("*** #2 ***");

		printArray(insert(list, 99, 3));

		println("*** #3 ***");

		boolean[] b = evenBoolArrayList(list);
		for (int k=0; k < b.length; k++)
		{
			if (b[k]) 
				print("T");
			else
				print("F");
			print(" ");       
		}
		println();

		println("*** #4 ***");

		println("20  is at position " + findInArrayList(list, 20));
		println("21  is at position " + findInArrayList(list, 21)); 
		println("22  is at position " + findInArrayList(list, 22));       

		println("*** #5 ***");

		// next line is for me to check comment out later - able
		//printArrayList(list);
		printArray(reverseArrayList(list));

		println("*** #6 ***");

		printArrayList(shuffle(list));

		println("*** #7 ***");

		printArrayList(removeMoreThan(list,50));

		println("*** #8 ***");

		printArray(doubleArrayList(list));

		println("*** #9 ***");

		printArrayList(appendArrayList(list));

		println("*** #10 ***");

		println("Most common roll is " + mostCommonRoll());

	}

	public ArrayList<Integer> randomArrayList(int size)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i=0; i < size; i++)
			temp.add((int)(Math.random()*100));
		return temp;
	}

	public void printArray(int[] a)
	{
		for(int i=0; i < a.length; i++)
			print(a[i]+"\t");
		println();
	}

	public void printArrayList(ArrayList<Integer> a)
	{
		for(int i=0; i < a.size(); i++)
			print(a.get(i)+"\t");
		println();
	}

	// #0 - returns the smallest element in the array
	public int findMinimum(ArrayList<Integer> a)
	{

		//return 0; // remove this when you write the method

		int champ=a.get(1);
		for(int i=1;i<a.size();i++){
			if (a.get(i)<champ)
				champ=a.get(i);
		}
		return champ;
	}

	// #1 - multiplies every array element by two, and returns a new list
	//      do not modify a itself!
	public ArrayList<Integer> twiceArrayList(ArrayList<Integer> a)
	{

		ArrayList<Integer> b=new ArrayList<Integer>();
		for(int num : a){
			b.add(num*2);
		}
		return b;

		//return null; // remove this when you write the method
	}

	// #2 - returns a built-in array of ints, similar to a
	//      but with the value val inserted at position pos in the array, shoving other elements to the right
	//      do not modify a itself!
	public int[] insert(ArrayList<Integer> a, int val, int pos)
	{
		int[] result = new int[a.size()+1];
		for (int i=0; i<pos; i++)
			result[i] = a.get(i);

		result[pos] = val;

		for(int i=pos; i<a.size();i++)
			result[i+1] = a.get(i);
		
		return result;
		

	}

	// #3 - returns a array of booleans.  if the k-th element of a is even, then the k-th element
	// of the array returned should be true.  if the k-th element of a is odd, then the k-th 
	// element of the array returned should be false
	public boolean[] evenBoolArrayList(ArrayList<Integer> a)
	{
		
		boolean[] result = new boolean[a.size()];
		for (int num : a){
			if (num%2==0)
				result[a.indexOf(num)] = true;
			else 
				result[a.indexOf(num)] = true;

		}
		return result;


		//return null; // remove this when you write the method
	}

	// #4 - returns the position (index) of the first occurence of whatToFind in the array.  
	// if whatToFind isn't in the array, return -1
	public int findInArrayList(ArrayList<Integer> a, int whatToFind)
	{
		
		for (int i=0; i<a.size(); i++){
			if (a.get(i)==whatToFind)
				return i;
		}
		return -1;

	   //return a.indexOf(whatToFind);

		//return -999;  // remove this when you write the method
	}

	// #5 - returns a built-in array in reversed order
	public int[] reverseArrayList(ArrayList<Integer> a)
	{
		int[] result = new int[a.size()];
		for (int i = a.size()-1; i>=0; i--){
			result[a.size()-1-i] = a.get(i);
		}
		return result;


		//return null; // remove this when you write the method
	}

	// #6 - randomly shuffle, rearranging the order of the items.  You can use Math.random.
	//      you should return a copy of the ArrayList randomly shuffled
	//      do not modify a itself!
	public ArrayList<Integer> shuffle(ArrayList<Integer> a)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();

	//	System.out.println("shuffle has been called");
		for (int num : a){
			int r = (int) (Math.random()*(a.size()));
			while (r>result.size())
				r = (int) (Math.random()*(a.size()));
				System.out.println(r);
			result.add(r , num);

			//result.add(5,num);
		}
		System.out.println("Hello Test!");

		return result; 



		//return null; // remove this when you write the method
	}

	// #7 - removes all elements larger than maxVal and returns a (probably smaller) array
	public ArrayList<Integer> removeMoreThan(ArrayList<Integer> a, int maxVal)
	{
		for ()



		//return null; // remove this when you write the method
	}

	// #8 - returns a built-in array twice as long, with double the elements 
	//  that is {1 4 6 3} becomes {1 1 4 4 6 6 3 3}
	public int[] doubleArrayList(ArrayList<Integer> a)
	{
		return null; // remove this when you write the method
	}

	// #9 - returns an ArrayList twice as long, with an additional copy attached to the end 
	//  that is {1 4 6 3} becomes {1 4 6 3 1 4 6 3}
	public ArrayList<Integer> appendArrayList(ArrayList<Integer> a)
	{
		return null; // remove this when you write the method
	}

	//#10 - rolls a "dice" a million times and returns the most common roll
	// hint: use a temporary array that is six long to keep track of the number of 
	// times you roll each number
	public int mostCommonRoll()
	{
		//remove the line below
		return 0;
	}

	//don't touch the lines below
	public static int[] removeThisPlaceHolder = {};
	public static boolean[] removeThisAlso = {};

}

import java.util.*;
import acm.program.*;

public class MagicSquare extends ConsoleProgram
{

	public void run()
	{
		setFont("*-*-36");
		int size = 4;
		int[][] square = getRandomSquare(size);
		while (!isMagicSquare(square))
			square = getRandomSquare(size);
		printSquare(square);
	}

	public void printSquare(int[][] square){
		for (int r=0; r<square.length; r++){
			for (int c=0; c<square[0].length;c++){
				print(square[r][c] + " ");
			}
			println();
		}
	}

	public int[][] getRandomSquare(int size){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i=1; i<=size*size; i++)
			nums.add(i);
		int[][] temp = new int[size][size];
		for (int r=0; r<size; r++){
			for (int c=0; c<temp[0].length;c++){
				int index = (int) (Math.random()*nums.size());
				temp[r][c] = nums.remove(index);
			}
		}
		return temp;
	}

	public boolean isMagicSquare(int[][] square){
		int magicSum=0;
		for (int c=0; c<square[0].length; c++)
			magicSum+=square[0][c];

		for (int r=1; r<square.length; r++){
			int sum=0;
			for (int c=0; c<square[0].length; c++)
				sum += square[r][c]	;
			if (sum!=magicSum)
				return false;
		}

		for (int c=1; c<square.length; c++){
			int sum=0;
			for (int r=0; r<square[0].length; r++)
				sum += square[r][c]	;
			if (sum!=magicSum)
				return false;
		}
		int sum =0;
		for(int r=0; r<square.length; r++)
			sum += square[r][r];
		if(sum!=magicSum)
			return false;

		sum = 0;
		for(int r=0; r<square.length; r++)
			sum += square[r][square.length-1-r];
		if(sum!=magicSum)
			return false;




		return true;
	}



}

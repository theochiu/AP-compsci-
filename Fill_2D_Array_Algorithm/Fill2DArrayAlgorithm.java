
public class Fill2DArrayAlgorithm
{
	public int[][] getGridOfNumbersUsingCounterStartingAtOne(int rows, int cols)
	{
		// question #0

		int counter =1 ; 
		int[][] grid = new int[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){
				grid[r][c] = counter;
				counter ++; 
			}
		}

		return grid; 
	}

	public int[][] getGridOfNumbersUsingCounter(int rows, int cols)
	{
		// question #1

		int counter = 0 ; 
		int[][] grid = new int[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){
				grid[r][c] = counter;
				counter ++; 
			}
		}

		return grid; 

	}

	public int[][] getGridOfNumbersUsingMath(int rows, int cols)
	{
		// question #2

		int[][] grid = new int[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){
				grid[r][c] = cols *r + c ;
			}
		}

		return grid; 

	}

	public int[][] getGridOfNumbersUsingMathColumnMajorOrder(int rows, int cols)
	{
		// question #3

		int[][] grid = new int[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){
				grid[c][r] = cols *r + c ;
			}
		}

		return grid; 
	}

	public String[][] getGridOfWordsUsingMath (int rows, int cols, String[] words)
	{
		// question #4

		String [][] grid = new String[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){
				grid[r][c] = words[cols *r + c] ;
			}
		}

		return grid;
	}

	public String[][] getGridOfWordsUsingMathIfPresent (int rows, int cols, String[] words)
	{
		// question #5

		String [][] grid = new String[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){

				if (words.length <cols *r +c){
					grid[r][c] = words[cols *r + c] ;
				} else {
					grid [r][c] = "";
				}
			}
		}

		return grid;
	}

	public String[][] getGridOfWordsColumnMajorUsingMathIfPresent (int rows, int cols, String[] words)
	{
		// question #6

		String [][] grid = new String[rows][cols];

		for (int r = 0; r<rows; r++){
			for (int c=0; c<cols; c++){

				if (words.length<cols *r +c){
					grid[c][r] = words[cols *r + c] ;
				} else {
					grid [c][r] = "";
				}
			}
		}

		return grid;
	}
	
	
	// your solution to question #7 should be in the other class
}

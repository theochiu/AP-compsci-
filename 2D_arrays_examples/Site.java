import java.util.ArrayList;

public class Site
{
	private Archaeologist[][] quadrants;

	public Site(ArrayList<Archaeologist> people, int rows, int cols)
	{
		// to be written in part (a)

		quadrants = new Archaeologist[rows][cols];
		
		int i = 0;
		for (int r=0; r<quadrants.length; r++){
			for (int c=0; c<quadrants[0].length; c++){
				if (i<people.size){
					quadrants[r][c] = people.get(i);
					i++;
				}
			}
		}
	}
	
	public int clearSomeQuadrants(String affiliation)
	{
		int counter = 0;
		for (int r=0; r<quadrants.length; r++){
			for(int c=0; c<quadrants[0].length;c++){
				if (quadrants[r][c]).getAffiliation().equals(affiliation){
					counter++;
					quadrants[r][c] = null;
				}
			}
		}
		return counter; 
	}
	
	public void printSiteInfo()
	{
		for (int r=0; r<quadrants.length; r++)
		{
			for (int c=0; c<quadrants[0].length; c++)
			{
				if (quadrants[r][c]!=null)
					System.out.print(quadrants[r][c].getIdNum() + " ");
				else
					System.out.print("-----" + " ");
			}
			System.out.println();
		}
	}
	
	


}

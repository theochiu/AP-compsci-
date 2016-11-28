import java.util.ArrayList;

public class Site
{
    private Archaeologist[][] quadrants;

    public Site(ArrayList<Archaeologist> people, int rows, int cols)
    {
        // to be written in part (a)
    }
    
    public int clearSomeQuadrants(String affiliation)
    {
        // to be written in part (b)
        return 0; // just to get it to compile
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

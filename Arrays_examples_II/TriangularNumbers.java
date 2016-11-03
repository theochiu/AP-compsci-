
import acm.program.*;

public class TriangularNumbers extends ConsoleProgram
{

    public void run()
    {
        int whichNum = readInt("Which triangular number do you want to know? ");
        int[] nums = new int[whichNum+1];
        nums[0] = 0;
        for (int i=1; i<nums.length; i++)
        {
            
            nums[i] = nums[i-1] + i;
        }
        println(nums[nums.length-1]);
    }


}

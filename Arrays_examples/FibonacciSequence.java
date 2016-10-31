
import acm.program.*;

public class FibonacciSequence extends ConsoleProgram
{

	public void run()
	{
		int[] nums = new int[40];
		nums[0] = 0;
		nums[1] = 1;
		for (int i=2;i<nums.length; i++){
			nums[i] = nums[i-1] + nums[i-1];
		}
		println("Your fibonacci number is " + nums[nums.length-1]);
	}

	public int fibonacci(int index){
		if (index==0)
			return 0;
		if (index == 1)
			return 1;
		return fibonacci(index-1) + fibonacci(index-2);
	}

}

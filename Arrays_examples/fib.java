

import java.util.Scanner;
public class fib{

	public static void main(String[] args){
		Scanner num = new Scanner(System.in);
		int index = num.nextInt();
		System.out.println(fibonacci(index));
		num.close();
	}


	public static int fibonacci(int index){
		if (index==0){
			System.out.println("Base case (0)");
			return 0;
		}

		if (index == 1){
			System.out.println("Base case (1)");
			return 1;
		}
		System.out.println("Computing fibonacci ("+index+")");
		return fibonacci(index-1) + fibonacci(index-2);
	}
}

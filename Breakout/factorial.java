
// Copyright Theodore Chiu 2016, All Rights Reserved
// Recursion sample

import java.util.*;
public class factorial {

	public static void main(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial (n));
	}

	public static int factorial(int n) {
		if (n==1){
			return 1;
		} else {
			return (n * factorial (n-1));
		}
	}
}
public class randomtest{
	public static void main(String[] args){
		int[] array = new int[2];
		for (int i=0;i<10000000;i++){
			int num = (int) (Math.random()*2);
		//	System.out.println(num);
			if (num==1)
				array[1]+=1;
			if (num==0)
				array[0]+=1;
		}

		System.out.println("number of 0's: " + array[0]);
		System.out.println("number of 1's: " + array[1]);

	}
}
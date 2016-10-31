

public class fib{


	public int main(int index){
		if (index==0)
			return 0;
		if (index == 1)
			return 1;
		return main(index-1) + main(index-2);
	}
}

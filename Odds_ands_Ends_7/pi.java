import java.util.*;

public class pi{

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.);
		list.add(50.);
		list.add(-5.);
		list.add(-90.);

		for(double a : list){
			if(a<0)
				a=3.14;
		}

		System.out.println("\n\nResults are: ");
		for(double b : list)
			System.out.print(b+" ");
	}



}

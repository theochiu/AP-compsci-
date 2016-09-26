public class WaterPuzzle{

	private int a;
	private int b;

	public WaterPuzzle(){
		a = 0;
		b = 0;
	}

	public void fill(String whichJug){
		if (whichJug=="A"){
			a=5;
		} else {
			b = 3;
		}
	}

	public void empty(String whichJug){
	
		if (whichJug=="a"){
			a=5;
		} else {
			b = 3;
		}
	
	}

	public void pourFromAtoB(){
		int emptyB = 3 -b;
		if(a < emptyB){
			b = a+b;
			a=0;
		} else {
			b=3;
			a=a-emptyB;
		}
	}

	public void pourFromBtoA(){
		int emptyA = 5-a;
		if(b < emptyA){
			a=a+b;
		} else {
			a=5;
			b=b-emptyA;
		}
	}

	public int getAmount(String whichJug){
		if (whichJug=="A"){
			return a;
		}else {
			return b;
		}
	}
}
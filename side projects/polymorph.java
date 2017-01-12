public class polymorph{

	private static final boolean bool = true;
	public static void main(){
		if (functionA()){
			int ans = functionA();
			System.out.println(ans);
		}
	}

	public static boolean functionA(){
		return bool;
	}

	public static int functionA(){
		return 5;
	}
}
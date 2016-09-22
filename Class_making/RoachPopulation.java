public class RoachPopulation{

	private int population;
//	private String patriarch;


	public RoachPopulation(int initialPopulation){
		population=initialPopulation;
	}

	public void breed(){
		population=2*population;
	}

	public void spray(){
		population = population/10;
	}

	public int getNumRoaches(){
		return population;
	}

}
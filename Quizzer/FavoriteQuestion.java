

public class FavoriteQuestion implements Question{

	private String thing;
	
	public FavoriteQuestion(){
		String[] things = {"color", "movie", "book" , "food" ,"song" , "TV show"};
		int index = (int) (Math.random()*things.length);
		thing = things[index];
	}

	public String getQuestion(){
		return "What is your favorite " + thing + "?";
	}

	public String getAnswer(){
		return "Um, whatever you want!";
	}

	public boolean isCorrect(String response){
		return true;
	}


}

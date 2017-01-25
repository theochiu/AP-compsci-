
public interface Question{
	String getQuestion();
	String getAnswer();
	boolean isCorrect(String response);

	/*
	What goes in an interface?
	Just a list of method signatures.

	What does not go in an interface?
	No actual code inside {}'s
	No private instance variables.
	No constructor. 
	No public methods. 

	*/
}

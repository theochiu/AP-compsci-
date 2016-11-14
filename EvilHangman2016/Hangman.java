

public class Hangman
{
    private String actualAnswer;
    private String lettersGuessed;
    private int guessesLeft;
    
    public Hangman()
    {
        actualAnswer = RandomPhraseGenerator.getRandomPhrase();
        guessesLeft = 7;
        lettersGuessed = "";
    }
    
    /** helper method that determines whether or not a String is a letter of the alphabet
     * @param letter a String with length of one, which may or may not be a letter
     * @return true if it is a letter, false otherwise
     */ 
    private boolean isLetter(String letter) {return Character.isLetter(letter.charAt(0));}
    
    /** @return the phrase so far, with blanks for unguessed letters (eg, "HE__O WOR_D")
     */
    public String getPhraseSoFar()
    {
        String temp = "";
        for (int i=0; i<actualAnswer.length(); i++)
        {
            String letter = actualAnswer.substring(i, i+1);
            if (isLetter(letter))
            {
                if (lettersGuessed.indexOf(letter) < 0)
                    temp += "_";
                else
                    temp += letter;
            }
            else
            {
                temp += letter;
            }
        }
        
        return temp;
    }
    
    /** @return the answer correct answer to this game of hangman
     */
    public String getActualAnswer()
    {
         return actualAnswer;          
    }
    
    public String getLettersGuessed() 
    {
        return lettersGuessed;
    }
    
    public int getGuessesLeft()
    {
        return guessesLeft;   
    }
    
    /** This method is called when the player makes a guess.  The guess is added to the list of guessed letters.
     * If it is a bad guess, then the player loses a guess (eg, has one fewer guess remaining).
     * @param guess the letter that is guessed
     * @return true if it is a good guess, false otherwise
     */
    public boolean makeGuess(String guess)
    {
       if (lettersGuessed.indexOf(guess) < 0)
       {
            lettersGuessed += guess;    
            if (actualAnswer.indexOf(guess)<0)
            {
                guessesLeft--;
                return false;
            }
            return true;
       }
       return true; 
    }
    
    public boolean allGuessed() {return getPhraseSoFar().indexOf("_")<0;}
}
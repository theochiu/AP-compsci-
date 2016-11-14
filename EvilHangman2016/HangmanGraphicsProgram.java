
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class HangmanGraphicsProgram extends GraphicsProgram
{
/** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 500;
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
    
    private static final int PHRASE_Y_OFFSET = 100;
    private static final int GUESSED_LETTERS_X_OFFSET = 50;
    private static final int GUESSED_LETTERS_Y_OFFSET = 300;
     
    private GLabel phraseLabel;
    private GLabel lettersGuessedLabel;
    private Hangman hangman;

    public void run()
    { 
        hangman = new EvilHangman();
        phraseLabel = new GLabel(hangman.getPhraseSoFar());
        int fontSize = 64;
        phraseLabel.setFont("Monospaced-plain-100");
        while(phraseLabel.getWidth()>WIDTH)
        {
            fontSize--;
            phraseLabel.setFont("*-*-"+fontSize);
        }
        phraseLabel.setLocation((WIDTH-phraseLabel.getWidth())/2, PHRASE_Y_OFFSET);
        add(phraseLabel);
        lettersGuessedLabel = new GLabel("Letters guessed: ", GUESSED_LETTERS_X_OFFSET, GUESSED_LETTERS_Y_OFFSET);
        lettersGuessedLabel.setFont("Sansserif-Plain-18");
        lettersGuessedLabel.setColor(Color.red);
        drawGallows();
        add(lettersGuessedLabel);
        addKeyListeners();
        while ((hangman.getGuessesLeft()>0) && !hangman.getPhraseSoFar().equals(hangman.getActualAnswer()))
        {
            lettersGuessedLabel.setColor(Color.RED);
            fontSize=64;
        }
        if (hangman.getGuessesLeft()>0)
        {
            lettersGuessedLabel.setLabel("You win!");
        }
        else
        {
            lettersGuessedLabel.setLabel("You lose!");
            //phraseLabel.setLabel(hangman.getActualAnswer());
        }
    }
    
    
    public void keyPressed(KeyEvent e)
    {
        String guess = KeyEvent.getKeyText(e.getKeyCode());  
        boolean goodGuess = hangman.makeGuess(guess);
        lettersGuessedLabel.setLabel("Letters guessed: " + hangman.getLettersGuessed());
        phraseLabel.setLabel(hangman.getPhraseSoFar());
        if (goodGuess == false)
        {
            drawTheMan(hangman.getGuessesLeft());
        }
    }

    public void drawTheMan(int num)
    {

        if (num == 6) {drawHead();}
        else if (num == 5) {drawBody();}
        else if (num == 4) {drawLeftArm();}
        else if (num == 3) {drawRightArm();}
        else if (num == 2) {drawLeftLeg();}
        else if (num == 1) {drawRightLeg();}
        else {drawFace();             phraseLabel.setLabel(hangman.getActualAnswer());}
    }
    
    public void drawHead()
    {
        GOval head = new GOval(400, 200, 100, 100);
        add(head);
    }
    
    public void drawBody()
    {
        GLine body = new GLine(450, 300, 450, 400);
        add(body);
    }
    
    public void drawLeftArm()
    {
        GLine arm = new GLine(450, 340, 360, 320);
        add(arm);
    }
    
    public void drawRightArm()
    {
        GLine arm = new GLine(450, 340, 540, 320);
        add(arm);
        
    }
    
    public void drawLeftLeg()
    {
       GLine leg = new GLine(450, 400, 410, 470);
       add(leg);
        
    }
    
    public void drawRightLeg()
    {
       GLine leg = new GLine(450, 400, 490, 470);
       add(leg);       
    }

    public void drawFace()
    {
       GImage face = new GImage("face.jpg", 400, 180);
       face.scale(0.30, 0.30);
       add(face);
        
    }
    public void drawGallows()
    {
        GLine base = new GLine(300, 480, 700, 480);
        add(base); 
        GLine pole = new GLine(600, 480, 600, 150);
        add(pole);
        GLine top = new GLine(600, 150, 450, 150);
        add(top);
        GLine hook = new GLine(450, 150, 450, 200);
        add(hook);
    }
    
}


import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class ConsonantGame extends GraphicsProgram
{
    private ArrayList<GLabel> labels;
    private RandomWordGenerator generator;
    private int turns;

    public void run()
    {
        labels = new ArrayList<GLabel>();
        generator = new RandomWordGenerator();
        turns = 0;
        // fill up labels with 25 random labels here
        addKeyListeners();
        // play the game and tell me how many turns it took
        // to win here
        
    }

    public void keyPressed(KeyEvent event)
    {
        String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();  
        // handle one key press here
    }

    public GLabel getRandomLabel()
    {
        /* Return a GLabel, with a random word, random
           location, random color, and random font size.
           It should be added 
        */
       
       String word=generator.getRandomWord();
       GLabel label = new GLabel(word, (int)( Math.random()*getWidth()),
                                (int) (Math.random()*getHeight()));
      Color randomColor = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
      label.setColor(randomColor);
      int size= (int) (Math.random()*36)+24;
      label.setFont("*-*-"+size);
      return label;
    }

}

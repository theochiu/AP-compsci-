
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList; // !!!

public class FallingCirclesII extends GraphicsProgram
{
    private static final int NUMCIRCLES = 15;
    private static final int DIAM = 50;
    private static final double DY = 0.2;

    private ArrayList<GOval> circles; //!!!
    
    public void run()
    {
       circles = new ArrayList<GOval>(); //!!!
       for (int i=0; i<NUMCIRCLES;i++) //!!!
       {
           GOval tempCircle = getRandomCircle();
           circles.add(tempCircle); //!!!
       }
       
       addMouseListeners();
       while (true)
       {
           pause(10);
           for (int i=0; i<circles.size();i++) //!!!
           {
                circles.get(i).move(0, DY);
                if (circles.get(i).getY()>getHeight())
                {
                    circles.remove(i); //!!!
                    i--;
                }
           }
       }
    }

    public GOval getRandomCircle()
    {
           int x = (int)(Math.random()*getWidth());
           int y = (int)(Math.random()*getHeight());
           Color c = new Color ((int)(Math.random()*256), 
                                (int)(Math.random()*256),
                                (int)(Math.random()*256));
           GOval circle = new GOval(x,y,DIAM,DIAM);
           circle.setColor(c);
           circle.setFilled(true);
           add(circle);
           return circle;
    }
    
    public void mouseClicked(MouseEvent event)
    {
        GOval clickedCircle = getRandomCircle();
        clickedCircle.setLocation(event.getX(), event.getY());
        circles.add(clickedCircle); // !!!
    }

}

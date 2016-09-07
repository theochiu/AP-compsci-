
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class StarWars extends GraphicsProgram
{

    public void run()
    {
        GRect laser = new GRect(200, 280, 90, 6);
        laser.setFilled(true);
        laser.setColor(Color.yellow);
        add(laser);        
        
        GImage deathstar = new GImage("deathstar.jpeg", 100, 150);
        deathstar.scale(1.5, 1.5);
        add(deathstar);
        
        waitForClick();
        
        for (int i=0; i<100000; i++)
        {
            laser.move(1, 0);
            pause(3);
        }
    }


}

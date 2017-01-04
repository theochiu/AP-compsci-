import javax.swing.JFrame;

/**
   This program runs the GameOfLifeFrame.
*/
public class GameOfLifeRunner
{
   public static void main(String[] args)
   {
      JFrame appFrame = new GameOfLifeFrame();
      appFrame.setTitle("The Game of Life");
      appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      appFrame.show();
   }
}

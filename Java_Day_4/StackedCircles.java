
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class StackedCircles extends GraphicsProgram
{
	private static final int DIAM = 25;
	private static final int NUMROWS = 12;
	private static final int NUMCOLS = 18;

	public void run()
	{
		for (int i = 0; i<NUMROWS;i++){
			for (int j=0; j<NUMCOLS; j++){
				GOval circle = new GOval (j*DIAM, i*DIAM, DIAM,DIAM);
				add(circle);
			}
		}
	}
}

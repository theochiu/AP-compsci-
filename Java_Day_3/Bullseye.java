
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Bullseye extends GraphicsProgram
{
	private static final int NUMRINGS = 10;
	private static final int RINGWIDTH = 20;
	private static final int INITIALX = 260;
	private static final int INITIALY = 210;

	public void run()
	{
		for (int i=0;i<NUMRINGS;i++){
			int ringNumber = NUMRINGS - i;
			GOval ring = new GOval(INITIALX - ringNumber*RINGWIDTH , INITIALY - ringNumber*RINGWIDTH , ringNumber*RINGWIDTH, ringNumber*RINGWIDTH);
			add(ring);
		}

	}

}


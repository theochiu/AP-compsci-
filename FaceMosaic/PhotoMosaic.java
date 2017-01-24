
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PhotoMosaic extends GraphicsProgram
{
	public static final int NUMPHOTOS = 450;
	public static final int NUMROWS = 18;
	public static final int NUMCOLS = NUMPHOTOS/NUMROWS;
	public static final int FACEWIDTH = 32;
	public static final int FACEHEIGHT = 21;

	public void run()
	{
		GImage[] faces = FacePhotoHelper.getAllPhotos();
		GImage[][] grid = new GImage[NUMROWS][NUMCOLS];
		fillGridWithImages(grid, faces);
		addGridToFeltBoard(grid);

		pause(5000);
		flipHorizontally(grid);
		removeAll();
		addGridToFeltBoard(grid);
		
		pause(5000);
		checkerboardOfLeahs(grid);
		removeAll();
		addGridToFeltBoard(grid);
	}

	public void fillGridWithImages(GImage[][] grid, GImage[] faces)
	{
		// to be written in part (a)
		int counter = 0;
		for (int r=0; r<grid.length; r++){
			for (int c=0; c<grid[r].length; c++){
				grid[r][c] = faces[counter++];
			}
		}

		/*
		for(int i=0; i<faces.length; i++){
			grid[i/NUMCOLS][i%NUMCOLS] = faces[i];
		}
		*/
	}

	public void addGridToFeltBoard(GImage[][] grid)
	{
		setSize(FACEWIDTH*grid[0].length, FACEHEIGHT*grid.length);
		for (int r=0; r<grid.length; r++)
			for (int c=0; c<grid[0].length; c++)
				add(grid[r][c], c*FACEWIDTH, r*FACEHEIGHT);
	}

	public void flipHorizontally(GImage[][] grid)
	{
		// to be written in part (b)
		for (int r=0; r<grid.length; r++){
			for (int c=0; c<grid[0].length/2;c++){
				GImage temp = grid[r][c];
				grid[r][c] = grid[r][NUMCOLS-1-c];
				grid[r][NUMCOLS-1-c] = temp; 
			}
		}
	}
	
	public void checkerboardOfLeahs(GImage[][] grid)
	{
		// to be written in part (c)
		for (int r=0; r<grid.length; r++){
			for (int c=0; c<grid[r].length; c++){
				if ((r+c)%2==0)
					grid[r][c] = new GImage("images/leah.jpg");
			}
		}
	}

}

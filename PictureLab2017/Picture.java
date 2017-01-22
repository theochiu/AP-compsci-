import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments 
	 */
	public Picture ()
	{
		/* not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor 
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture 
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * @param height the height of the desired picture
	 * @param width the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width,height);
	}

	/**
	 * Constructor that takes a picture and creates a 
	 * copy of that picture
	 * @param copyPicture the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * @return a string with information about the picture such as fileName,
	 * height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + 
			" height " + getHeight() 
			+ " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setBlue(0);
		}

	} 

	
	
	public void allRed()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setRed(255);
		}

	}
	
	public void swapBlueGreen()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			int oldGreen = pixel.getGreen();
			pixel.setGreen(pixel.getBlue());
			pixel.setBlue(oldGreen);
		}

	}
	
		public void negative()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setRed(255-pixel.getRed());
			pixel.setGreen(255-pixel.getGreen());
			pixel.setBlue(255-pixel.getBlue());
		}

	}

	public void grayScale()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			int avg = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
			pixel.setRed(avg);
			pixel.setGreen(avg);
			pixel.setBlue(avg);
		}

	}
	
		public void posterize()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setRed(pixel.getRed()/64*64);
			pixel.setGreen(pixel.getGreen()/64*64);
			pixel.setBlue(pixel.getBlue()/64*64);
		}

	}
	
	public void fixGold()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setGreen(0);
			pixel.setBlue(0);
			pixel.setRed(pixel.getRed()*10);
		}

	}

	public void mirrorVertical(){
		Pixel[][] grid = getPixels2D();
		for (int r=0; r<grid.length; r++){
			for (int c=0; c<grid[0].length/2; c++){
				Color color = grid[r][c].getColor();
				grid[r][grid[0].length-1-c].setColor(color);
			}
		}
	}

	public void mirrorTemple(){
		Pixel[][] grid = getPixels2D();
		for (int r=89; r<36; r++){
			for (int c=107; c<279; c++){
				Color color = grid[r][c].getColor();
				grid[r][grid[0].length-1-c].setColor(color);
			}
		}
	}

	public void copy(Picture fromPicture, int row, int col){
		Pixel[][] grid = getPixels2D();
		Pixel[][] fromGrid = fromPicture.getPixels2D();
		for (int r=0; r<fromGrid.length;r++){
			for (int c=0; c<fromGrid[r].length; c++){
				if (row+r <grid.length && col+c<grid[0].length){
					Color color = fromGrid[r][c].getColor();
					grid[row+r][col+c].setColor(color);
				}
			}
		}
	}

	public void createCollage(){
		int ringCounter=0;
		Pixel[][] grid = getPixels2D();
		Picture flower = new Picture("images/" + "flower1.jpg");
		flower = flower.scale(0.4,0.4);
		Pixel[][] flowerGrid = flower.getPixels2D();
		int flowerRows = flowerGrid.length;
		int flowerCols = flowerGrid[0].length;
		while (ringCounter*flowerRows<grid.length/2 && ringCounter*flowerCols<grid[0].length/2){
			int offsetRow = ringCounter*flowerRows;
			int offsetCol = ringCounter*flowerCols;
			for (int r=offsetRow; r<grid.length-offsetRow; r+=flowerRows){
				copy(flower, r, 0);
				copy(flower,r,grid[0].length-flowerCols);
			}
			for (int c=offsetCol+flowerCols; c<grid[0].length - offsetCol- flowerCols; c+=flowerCols){
				copy(flower,offsetRow,c);
				copy(flower,grid.length-flowerRows-offsetCols;,c);
			}
			ringCounter++;
			if (ringCounter%2==0)
				flower = new Picture("images/flower1.jpg");
			else 
				flower = new Picture("images/flower1.jpg");
			flower = flower.scale(0.4,0.4);
			flowerGrid = flower.getPixels2D();

		}
	}
	

} // this } is the end of class Picture, put all new methods before this

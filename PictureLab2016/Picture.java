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

	public void posterize(){
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels){
			pixel.setRed(pixel.getRed()/64*64+32);
			pixel.setBlue(pixel.getBlue()/64*64+32);
			pixel.setGreen(pixel.getGreen()/64*64+32);

		}
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

	public void maxGreen()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setGreen(255);
		}

	}

	public void greyscale(){
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels) {
			int a = (pixel.getBlue() + pixel.getRed() + pixel.getGreen())/3;
			pixel.setGreen(a);
			pixel.setRed(a);
			pixel.setBlue(a);
		}
	}

	public void negative(){
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels){
			pixel.setRed(255-pixel.getRed());
			pixel.setBlue(255-pixel.getBlue());
			pixel.getRed(255-pixel.getGreen());

		}
	}
	
	public void solveGold()
	{
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels)
		{
			pixel.setBlue(0);
			pixel.setGreen(0);
			pixel.setRed(pixel.getRed()*10);
		}
	}

	public void solveCopper(){
		Pixel[] pixels = getPixels();

		for (Pixel pixel : pixels){
			pixel.setBlue(0);
			pixel.setRed(0);
			pixel.setGreen(pixel.getGreen()*10);
		}
	}

	/* Main method for testing - each class in Java can have a main 
	 * method 
	 */
	public static void main(String[] args) 
	{
		Picture beach = new Picture("images/" + "gold.png");
		beach.explore();
		//beach.zeroBlue();
		//beach.greyscale();
		//beach.posterize();
		//beach.explore();
		//beach.maxGreen();
		beach.solveGold();

		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this

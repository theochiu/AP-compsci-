import acm.graphics.*;
import java.awt.Color;
import acm.program.*;


public class TopologicalMap
{
	// private instance variables
	private double[][] mapData;
	private boolean valid;
	private double totalDistance;

	public double getTotalDistance(){
		return totalDistance;
	}

	public TopologicalMap(String filename, int rows, int cols)
	{
		// you'll do this in task #1
		totalDistance = 0;
		mapData = new double[rows][cols];
		double[] imported = FileHelper.readDataFromFile(filename, rows*cols);
		if(imported.length>0){
			for(int i=0; i<imported.length;i++){
				mapData[i/cols][i%cols] = imported[i];
			}
			valid = true;
		}else{
			valid=false;
			mapData[0][0] = 0;
		}

	}

	public boolean isValid() {return valid;}
	
	private double findMinimum()
	{
		// you'll do this in task #3
		//return 0; // just to get it to compile

		double champ = (double)(Integer.MAX_VALUE);
		for(int r=0; r<mapData.length; r++){
			for(int c=0; c<mapData[r].length;c++){
				double val = mapData[r][c];
				if(val<champ){
					champ=val;
				}
			}
		}
		return champ;
	}

	private double findMaximum()
	{
		// you'll do this in task #3
		//return 0; // just to get it to compile

		double champ = (double)(Integer.MIN_VALUE);
		for(int r=0; r<mapData.length; r++){
			for(int c=0; c<mapData[r].length;c++){
				double val = mapData[r][c];
				if(val>champ){
					champ=val;
				}
			}
		}
		return champ;

	}

	public void drawMap(GraphicsProgram graphics)
	{

		double min = this.findMinimum();
		double max = this.findMaximum();

		for(int r=0; r<mapData.length;r++){
			for(int c=0; c<mapData[r].length;c++){
				int num = (int) ((mapData[r][c]-min)/((max-min)*1.)*255.);
			//	System.out.println(num);
				GRect pix = new GRect(c,r,1,1);
				Color x = new Color(num,num,num);
				pix.setColor(x);
				graphics.add(pix);
			}
		}

		// you'll do this in task #4
	}

	public double drawLowestElevPath(GraphicsProgram graphics, int startRow, Color drawColor)
	{
		// you'll do this in task #5 
		//return 0; // just to get it to compile
		int row = startRow;
		double totalchange=0;
		for(int c=0; c<mapData[row].length-1; c++){

			// draw pixel
			GRect pix = new GRect(c,row,1,1);
			pix.setColor(drawColor);
			graphics.add(pix);


			// choose where to move on to
			double up, down, straight;
			if(row-1>=0){
				up = Math.abs(mapData[row][c] -  mapData[row-1][c+1]);
			}else{
				up=Integer.MAX_VALUE;
			}

			if(row+1<mapData.length){
				down = Math.abs(mapData[row][c] - mapData[row+1][c+1]);
			}else{
				down = Integer.MAX_VALUE;
			}

			straight = Math.abs(mapData[row][c] - mapData[row][c+1]);

			if(down<straight&&down<up&&row+1<mapData.length){
				row++;
				totalchange+=down;
				totalDistance+=Math.pow(2,.5);
			}
			else if(up<down&&up<straight&&row-1>=0){
				row--;
				totalchange+=up;
				totalDistance+=Math.pow(2,.5);
			}
			else if(down<straight&&down<up&&row+1<mapData.length){
				row++;
				totalchange+=down;
				totalDistance+=Math.pow(2,.5);
			}
			else if(straight<down&&straight<up){
				totalchange+=straight;
				totalDistance++;
			}
			else if(straight==down||straight==up){
				totalchange+=straight;
				totalDistance++;
			}
			else if(up==down){
				double rand = Math.random();
				if(rand>.5){
					if(row+1<mapData.length){
						row--;
						totalchange+=up;
						totalDistance+=Math.pow(2,.5);
					}
				}else{
					if(row-1>=0){
						totalchange+=down;
						row++;
						totalDistance+=Math.pow(2,.5);
					}
				}
			}
		}
		return totalchange;
	}

	public int getIndexOfLowestElevPath(GraphicsProgram graphics)
	{
		// you'll do this in task #6 
		//return 0; // just to get it to compile

		double champ=drawLowestElevPath(graphics, 0, Color.RED);
		int ind=0;
		for(int i=1;i<mapData.length;i++){
			double x = drawLowestElevPath(graphics,i,Color.RED);
			if(x<champ){
				champ=x;
				ind=i;
			}
		}
		drawLowestElevPath(graphics,ind,Color.GREEN);
		return ind; 
	}
	
}


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

				for (int i=0;i<25;i++) {
					GLabel randomLabel = getRandomLabel();
					labels.add(randomLabel);
				}

				addKeyListeners();

				while (labels.size()>0)
					pause(10);

				GLabel message = new GLabel("You won! It took you " + turns+ "turns", 50,100);
				add(message);
				// play the game and tell me how many turns it took
				// to win here
				
		}

		public void keyPressed(KeyEvent event)
		{
				String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();  
				// handle one key press here

				String vowels = "AEIOU";
				if (vowels.indexOf(letter)!=-1)
					return;
				for (int i=0; i<labels.size();i++) {
					if (labels.get(i).getLabel().indexOf(letter)!=-1) {
						remove(labels.get(i));
						labels.remove(i);
					}
				}
				turns ++;
				if (turns%3==0) {
					for (int i=0;i<5;i++) {
						GLabel randomLabel = getRandomLabel();
						labels.add(randomLabel);
					}
				}

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

			while (label.getWidth()+label.getX()>getWidth()){
				label.setLocation((int)(Math.random()*getWidth()),label.getX());
			}

			while (label.getHeight()+label.getY()>getHeight()){
				label.setLocation((int)(Math.random()*getHeight()),label.getY());
			}


			add(label);

			return label;
		}

}

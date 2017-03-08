
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip;
import acm.util.MediaTools;

public class AsteroidsGame extends GraphicsProgram
{
	private ArrayList<Asteroid> asteroids;
	private boolean playing;
	private GLabel notificationLabel, scoreLabel;
	// uncomment out the lines below in version 0.4.1 and 0.5.2
	private Ship ship;
	private ArrayList<Bullet> bullets;
	private int level;
	private int ships;
	private int score;
	private AudioClip thrustClip, fireClip, bigBangClip, mediumBangClip, smallBangClip;
	
	public void init()
	{
		thrustClip = MediaTools.loadAudioClip("thrust.wav");   
		fireClip = MediaTools.loadAudioClip("fire.wav");   
		bigBangClip = MediaTools.loadAudioClip("bangLarge.wav");   
		mediumBangClip = MediaTools.loadAudioClip("bangMedium.wav");   
		smallBangClip = MediaTools.loadAudioClip("bangSmall.wav");   

		level = 0;
		ships = 999999999;
		score = 0;
		
		setBackground(Color.BLACK);
		
		notificationLabel = new GLabel("(i) = thrust, (j) = rotate left, (k) = rotate right, (space) = fire. Click mouse to continue");
		notificationLabel.setColor(Color.WHITE);
		notificationLabel.setFont("Courier-Plain-12");
		notificationLabel.setLocation((getWidth()-notificationLabel.getWidth())/2, getHeight()/2-40);
		add(notificationLabel);
		
		scoreLabel = new GLabel("Score:"+score);
		scoreLabel.setColor(Color.WHITE);
		scoreLabel.setFont("Courier-Plain-10");
		scoreLabel.setLocation(16, 16);
		add(scoreLabel);

		ship = new Ship(getWidth(),getHeight());
		ship.setLocation((getWidth() / 2),(getHeight() / 2));
		add(ship);

		addKeyListeners();
		addMouseListeners();
		
		asteroids = new ArrayList<Asteroid>();
		makeAsteroids();

		bullets = new ArrayList<Bullet>();

		
	}
	
	private void makeAsteroids()
	{
		// code for version 0.3.1 goes here
		for (int i=0; i<3+level; i++){
			Asteroid a = new Asteroid(getWidth(), getHeight());
			
			a.setLocation(Math.random() * getWidth(), Math.random() * getHeight());
			// use magnitude nad distance formula 
			while (Math.pow(ship.getX() - a.getX(), 2) + Math.pow(ship.getX() - a.getX(), 2) < 10000) {
				a.setLocation(Math.random() * getWidth(), Math.random() * getHeight());
			}

			a.rotate((int)(Math.random()*360));
			a.increaseVelocity(1);
			asteroids.add(a);
			add(a);
		}
	}
	
	public void run()
	{

		while (true)
		{
			pause(10);
			if (playing){
				ship.updatePosition();
				if (checkForCollisions(ship)!=null){
					shipCollided();
				}
			}


			for (int j=0; j<bullets.size();j++){//if still moving

				if (bullets.get(j).stillMoving()){
					bullets.get(j).updatePosition();
				}

				else{
					remove(bullets.get(j));
					bullets.remove(j);
				}
			}

			for (int i=0; i<asteroids.size();i++){
				asteroids.get(i).updatePosition();
			}

			for (int i=0;i<bullets.size();i++){
				Asteroid x = checkForCollisions(bullets.get(i));
				if (x!=null){
					shotAsteroid(x);
					remove(bullets.get(i));
					bullets.remove(i);
					i--;
				}
			}

			if (asteroids.size() == 0){
				level++;
				makeAsteroids();
			}
		} 
	}
		
	private Asteroid checkForCollisions(GVectorPolygon obj)
	{
		for (Asteroid a:asteroids)
			if (a.getBounds().intersects(obj.getBounds())) {
			   return a;
			}

		return null;       
	}

	public void keyPressed(KeyEvent e) {

		if (!playing){return;}

		if (e.getKeyCode() == KeyEvent.VK_J) {
			ship.rotate(15.0);
		} 

		else if (e.getKeyCode() == KeyEvent.VK_L) {
			ship.rotate(-15.0);
		} 

		else if (e.getKeyCode() == KeyEvent.VK_I) {
			ship.increaseVelocity(.5);
		}

		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Bullet bullet = ship.makeBullet();
			add(bullet);
			bullets.add(bullet);
		}
	}


	private void shipCollided() {
		ships--;
		String message;
		if (ships == 0)
			message="Game Over." ;
		else if (ships == 1)
			message ="Click mouse to continue. One ship remaining." ;
		else 
			message ="Click mouse to continue. Two ships remaining.";

		playing = false;
		notificationLabel.setLabel(message);
		notificationLabel.setLocation((getWidth() - notificationLabel.getWidth()) / 2.0, (getHeight() / 2 - 40));
		add(notificationLabel);
		remove(ship);
		ship = new Ship(getWidth(), getHeight());
		ship.setLocation((getWidth() / 2), (getHeight() / 2));
		ship.rotate(90.0);
		add(ship);
	}

	 private void shotAsteroid(Asteroid a) {

		remove(a);
		asteroids.remove(a);

		score += 10;
		scoreLabel.setLabel("Score:" + score);

		double randomAngle = Math.random() * 360.0;



		
		if (a instanceof SmallAsteroid){}
		else if (a instanceof MediumAsteroid) {
			for (int i = 0; i < 3; ++i) {
				SmallAsteroid b = new SmallAsteroid(getWidth(), getHeight());
				b.setLocation(a.getX(), a.getY());
				b.rotate((randomAngle + (double)(i * 120)) % 360.0);
				b.increaseVelocity(1);
				asteroids.add(b);
				add(b);
			}
			
		} else {
			for (int i = 0; i < 3; ++i) {
				MediumAsteroid b = new MediumAsteroid(getWidth(), getHeight());
				b.setLocation(a.getX(), a.getY());
				b.rotate((randomAngle + (double)(i * 120)) % 360.0);
				b.increaseVelocity(1);
				asteroids.add(b);
				add(b);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (playing) {
			return;
		}

		if (ships == 0) {
			return;
		}
		remove(notificationLabel);
		playing = true;
	}
	
}

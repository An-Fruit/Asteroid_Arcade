import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;

public class AsteroidGame extends JPanel implements KeyListener, Runnable{
	Ship ship;
	HashSet<Prop> Asteroids;
	Queue<Prop> AsteroidsQ;
	Queue<Prop> RemoveAsteroidsQ;
	ArrayList<Bullet> projectiles;
	Queue<Bullet> RemoveBulletQ;
	boolean up, left, right, shoot;
	int hp;
	int invincibilityFrames;
	boolean invincible;
	public AsteroidGame() {
		// instantiates instance variables
		Asteroids = new HashSet<>();
		for (int i = 0;i<10;i++) {
			int x = (int)(Math.random()*1000);
			int y = (int)(Math.random()*1000);
			Asteroids.add(new bigAsteroid(x,y,2,1));
		}
		AsteroidsQ = new LinkedList<>();
		ship = new Ship(500,500);
		RemoveBulletQ = new LinkedList<>();
		RemoveAsteroidsQ = new LinkedList<>();
		projectiles = new ArrayList<>();
		up = false; left = false; right= false; shoot = false;
		hp = 5;
		invincibilityFrames = 3000;
		invincible  = false;
		
		// sets up JPanel properties
		setSize(1000,1000);
		addKeyListener(this);
		setFocusable(true);
		
		new Thread(this).start();
	}
	
	public void paintComponent(Graphics g) {
	
		g.setColor(Color.BLACK);
		g.fillPolygon(new Polygon(new int[] {0,1000,1000,0}, new int[] {0,0,1000,1000}, 4));
		
		g.setColor(Color.WHITE);
		g.drawString("HP: " + hp, 50, 50);
		g.setColor(Color.black);
		
		// runs Ship
		ship.paintComponent(g);
		ship.move();
		ship.rotateShip();
		ship.Inbounds();
		if (shoot) {
			double[] temp = ship.getMoveVec();
			System.out.println("dog");
			if (left && up) {
				if (ship.countDown()) {
					projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
				}
				ship.accelMove(0.75);
				ship.accelRotate(-0.4);
			}
			else if (left) {
				if (ship.countDown()) {
					projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
				}
				ship.accelRotate(-0.4);
			}
			else if (right && up) {
				if (ship.countDown()) {
					projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
				}
				ship.accelRotate(0.4);
				ship.accelMove(0.75);
			}
			else if (right) {
				if (ship.countDown()) {
					projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
				}
				ship.accelRotate(0.4);
				
			}
			else if (up) {
				if (ship.countDown()) {
					projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
				}
				ship.accelMove(0.75);
			}
			else {
				if (ship.countDown()) {
					projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
				}
			}
		}
		else if ( left || up || right) {
			
			if (left && up) {
				ship.accelMove(0.75);
				ship.accelRotate(-0.4);
			}
			else if (left) {
				ship.accelRotate(-0.4);

			}
			else if (right && up) {
				ship.accelRotate(0.4);
				ship.accelMove(0.75);
			}
			else if (right) {
				ship.accelRotate(0.4);
			}
			else if (up) {
				ship.accelMove(0.75);
			}
		}
		// Is responsible for running all the Asteroids
		for (Prop p: Asteroids) {
			p.paintComponent(g);
			p.Inbounds();
			if (p.bBox.contains(ship.center.x, ship.center.y) && !invincible) {
				hp--;
				invincible = true;
			}
			if (p.hit) {
				if (p instanceof bigAsteroid) {
					((bigAsteroid) p).collapse(AsteroidsQ);
					RemoveAsteroidsQ.add(p);
				}
				else if (p instanceof medAsteroid) {
					((medAsteroid) p).collapse(AsteroidsQ);
					RemoveAsteroidsQ.add(p);
				}
				else {
					RemoveAsteroidsQ.add(p);
				}
 			}
		}
		while(!AsteroidsQ.isEmpty()) {
			Asteroids.add(AsteroidsQ.poll());
		}
		while(!RemoveAsteroidsQ.isEmpty()) {
			Asteroids.remove(RemoveAsteroidsQ.poll());
		}
		
		// Is responsible for simulating bullets
		for(Bullet b : projectiles) {
			b.paintComponent(g);
			for (Prop p:Asteroids) {
				if (p.bBox.contains(b.center.x, b.center.y)) {
					p.hit = true;
					b.hit = true;
				}
			}
			if(b.hit || b.center.x > 1000 || b.center.x < 0 || b.center.y > 1000 || b.center.x < 0) RemoveBulletQ.add(b);
		}
		
		while(!RemoveBulletQ.isEmpty()) {
			projectiles.remove(RemoveBulletQ.poll());
		}
		if (Asteroids.isEmpty()) {
			for (int i = 0;i<10;i++) {
				int x = (int)(Math.random()*1000);
				int y = (int)(Math.random()*1000);
				Asteroids.add(new bigAsteroid(x,y,2,1));
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//left arrow
		if(arg0.getKeyCode() == 37) {
			left = true;
		}
		//right arrow
		else if(arg0.getKeyCode() == 39) {
			right = true;
		}
		//up arrow
		else if(arg0.getKeyCode() == 38) {
			up = true;
		}
		//spacebar
		else if(arg0.getKeyCode() == 32 ) {
			shoot  = true;
		}
		System.out.println(arg0.getKeyCode() + " "); //+ projectiles);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 37) {
			left = false;
		}
		else if (arg0.getKeyCode() == 39){
			right = false;
		}
		else if (arg0.getKeyCode() == 38) {
			up = false;
		}
		else if(arg0.getKeyCode() == 32 ) { 
			shoot = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				ship.decayAngle();
				ship.decayVel();
				if (invincible) {
					invincibilityFrames-=10;
					if (invincibilityFrames<=0) {
						invincible = false;
						invincibilityFrames = 3000;
					}
				}
				if (hp<=0) {
					break;
				}
				Thread.sleep(10);
				repaint();
			}
			
		}
		catch( Exception e )
		{
			System.out.println("error:");
		}
	}
}
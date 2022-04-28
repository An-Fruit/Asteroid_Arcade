import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
	public AsteroidGame() {
		// instantiates instance variables
		Asteroids = new HashSet<>();
		Asteroids.add(new bigAsteroid(100,0,10,5));
		AsteroidsQ = new LinkedList<>();
		ship = new Ship(500,500);
		RemoveAsteroidsQ = new LinkedList<>();
		projectiles = new ArrayList<>();
		// sets up JPanel properties
		addKeyListener(this);
		setFocusable(true);
		new Thread(this).start();
	}
	public void paintComponent(Graphics g) {
	
		g.setColor(Color.BLACK);
		g.fillPolygon(new Polygon(new int[] {0,1000,1000,0}, new int[] {0,0,1000,1000}, 4));
		ship.paintComponent(g);
		
		// Is responsible for running all the Asteroids
		for (Prop p: Asteroids) {
			p.paintComponent(g);
		}
		while(!AsteroidsQ.isEmpty()) {
			Asteroids.add(AsteroidsQ.poll());
		}
		while(!RemoveAsteroidsQ.isEmpty()) {
			Asteroids.remove(RemoveAsteroidsQ.poll());
		}
		
		for(Bullet b : projectiles) {
			b.paintComponent(g);
			b.move();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//left arrow
		if(arg0.getKeyCode() == 37) {
			ship.rotateShip(-7.0);
		}
		//right arrow
		else if(arg0.getKeyCode() == 39) {
			ship.rotateShip(7.0);
		}
		//up arrow
		else if(arg0.getKeyCode() == 38) {
			ship.move();
		}
		//spacebar
		else if(arg0.getKeyCode() == 32) {
			double[] temp = ship.getMoveVec();
			projectiles.add(new Bullet((int)ship.center.x, (int)ship.center.y, temp[0], temp[1]));
		}
		System.out.println(arg0.getKeyCode() + " " + projectiles);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
import java.awt.Color;
import java.awt.Graphics;
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
	public AsteroidGame() {
		// instantiates instance variables
		Asteroids = new HashSet<>();
		Asteroids.add(new bigAsteroid(100,0,2,1));
		AsteroidsQ = new LinkedList<>();
		ship = new Ship(500,500);
		Asteroids.add(ship);
		RemoveAsteroidsQ = new LinkedList<>();
		
		// sets up JPanel properties
		setSize(1000,1000);
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
			p.Inbounds();
		}
		while(!AsteroidsQ.isEmpty()) {
			Asteroids.add(AsteroidsQ.poll());
		}
		while(!RemoveAsteroidsQ.isEmpty()) {
			Asteroids.remove(RemoveAsteroidsQ.poll());
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 37) {
			ship.rotateShip(-15.0);
		}
		else if(arg0.getKeyCode() == 39) {
			ship.rotateShip(15.0);
		}
		else if(arg0.getKeyCode() == 38) {
			ship.move();
		}
		System.out.println(arg0.getKeyCode());
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

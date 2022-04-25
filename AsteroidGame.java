import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class AsteroidGame extends JPanel implements KeyListener, Runnable{
	Ship ship;
	public AsteroidGame() {
		ship = new Ship(500,500);
		addKeyListener(this);
		setFocusable(true);
		new Thread(this).start();
	}
	public void paintComponent(Graphics g) {
	
		g.setColor(Color.BLACK);
		g.fillPolygon(new Polygon(new int[] {0,1000,1000,0}, new int[] {0,0,1000,1000}, 4));
		g.setColor(new Color(255,100,255));
		//ship.rotateShip();
		ship.paintComponent(g);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 37) {
			ship.rotateShip(-7.0);
		}
		else if(arg0.getKeyCode() == 39) {
			ship.rotateShip(7.0);
		}
		else if(arg0.getKeyCode() == 38)
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
				Thread.sleep(50);
				repaint();
			}
			
		}
		catch( Exception e )
		{
			System.out.println("error:");
		}
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class smallAsteroid extends Prop{

	Polygon[] smallAsts;
	public smallAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		smallAsts = new Polygon[2];
		smallAsts[0] = new Polygon(new int[] {(int)center.x+12, (int)center.x+28, (int)center.x+33, (int)center.x+24, (int)center.x+14, }, new int[] {(int)center.y+11, (int)center.y+2, (int)center.y+14, (int)center.y+23, (int)center.y+13, }, 5);
		smallAsts[1] = new Polygon(new int[] {(int)center.x+20, (int)center.x+20, (int)center.x+39, (int)center.x+52, (int)center.x+32, (int)center.x+23,  }, new int[] {(int)center.y+15, (int)center.y+18, (int)center.y+5, (int)center.y+21, (int)center.y+29, (int)center.y+22,  }, 6);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = smallAsts[(int)Math.random()*2];
	}
	
	public void paintComponent(Graphics window) {
		window.setColor(Color.white);
		window.drawPolygon(bBox);
		move();
	}
	
}

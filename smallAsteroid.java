import java.awt.Graphics;
import java.awt.Polygon;

public class smallAsteroid extends Prop{

	Polygon[] smallAsts;
	public smallAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		smallAsts = new Polygon[2];
		smallAsts[0] = new Polygon(new int[] {x+12, x+28, x+33, x+24, x+14, }, new int[] {y+11, y+2, y+14, y+23, y+13, }, 5);
		smallAsts[1] = new Polygon(new int[] {x+20, x+20, x+39, x+52, x+32, x+23,  }, new int[] {y+15, y+18, y+5, y+21, y+29, y+22,  }, 6);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = smallAsts[(int)Math.random()*2];
	}
	
	public void paintComponent(Graphics window) {
		for (Polygon p: smallAsts)  {
			window.drawPolygon(p);
		}
			
	}
	
}

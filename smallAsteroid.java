import java.awt.Graphics;
import java.awt.Polygon;

public class smallAsteroid extends Prop{

	Polygon[] smallAsts;
	public smallAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		smallAsts = new Polygon[2];
		smallAsts[0] = new Polygon(new int[] {center.x+12, center.x+28, center.x+33, center.x+24, center.x+14, }, new int[] {center.y+11, center.y+2, center.y+14, center.y+23, center.y+13, }, 5);
		smallAsts[1] = new Polygon(new int[] {center.x+20, center.x+20, center.x+39, center.x+52, center.x+32, center.x+23,  }, new int[] {center.y+15, center.y+18, center.y+5, center.y+21, center.y+29, center.y+22,  }, 6);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = smallAsts[(int)Math.random()*2];
	}
	
}

import java.awt.Graphics;
import java.awt.Polygon;

public class medAsteroid extends Prop {
	
	Polygon[] medAsts;
	public medAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		medAsts = new Polygon[3];
		medAsts[0] = new Polygon(new int[] {center.x+0, center.x+11, center.x+36, center.x+41, center.x+21, center.x+5, }, new int[] {center.y+16, center.y+8, center.y+7, center.y+27, center.y+36, center.y+21, }, 6);
		medAsts[1] = new Polygon(new int[] {center.x+5, center.x+39, center.x+48, center.x+33, center.x+14, center.x+5, }, new int[] {center.y+28, center.y+16, center.y+36, center.y+49, center.y+46, center.y+32, }, 6);
		medAsts[2] = new Polygon(new int[] {center.x+0, center.x+40, center.x+54, center.x+34, center.x+14, center.x+2,  }, new int[] {center.y+51, center.y+32, center.y+52, center.y+71, center.y+66, center.y+52, }, 6);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = medAsts[(int)Math.random()*3];
	}
	

}

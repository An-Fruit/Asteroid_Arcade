import java.awt.Graphics;
import java.awt.Polygon;

public class medAsteroid extends Prop {
	
	Polygon[] medAsts;
	public medAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		medAsts = new Polygon[3];
		medAsts[0] = new Polygon(new int[] {0, 11, 36, 41, 21, 5, }, new int[] {16, 8, 7, 27, 36, 21, }, 6);
		medAsts[1] = new Polygon(new int[] {5, 39, 48, 33, 14, 5, }, new int[] {28, 16, 36, 49, 46, 32, }, 6);
		medAsts[2] = new Polygon(new int[] {0, 40, 54, 34, 14, 2,  }, new int[] {51, 32, 52, 71, 66, 52, }, 6);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = medAsts[(int)Math.random()*3];
	}
	

}


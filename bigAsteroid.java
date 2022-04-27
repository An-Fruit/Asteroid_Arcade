import java.awt.Graphics;
import java.awt.Polygon;

public class bigAsteroid extends Prop{

	Polygon[] bigAsts;
	public bigAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		bigAsts = new Polygon[4];
		bigAsts[0] = new Polygon(new int[] {x+43, x+0, x+46, x+62, x+49, x+69, x+63, x+44}, new int[] {y+37, y+86, y+117, y+97, y+77, y+75, y+57, y+39}, 8);
		bigAsts[1] = new Polygon(new int[] {x+40, x+12, x+28, x+72, x+69, x+97, x+57, x+44, x+44}, new int[] {y+19, y+55, y+79, y+86, y+66, y+58, y+36, y+20, y+20, }, 9);
		bigAsts[2] = new Polygon(new int[] {x+0, x+15, x+53, x+68, x+42, x+26, x+0 }, new int[] {y+63, y+12, y+13, y+43, y+69, y+58, y+65, }, 7);
		bigAsts[3] = new Polygon(new int[] {x+0, x+37, x+82, x+90, x+42, x+34, x+16, x+2, }, new int[] {y+51, y+27, y+36, y+59, y+107, y+77, y+74, y+54,}, 8);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = bigAsts[(int)Math.random()*4];
	}
	

}
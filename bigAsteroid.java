import java.awt.Graphics;
import java.awt.Polygon;

public class bigAsteroid extends Prop{

	Polygon[] bigAsts;
	public bigAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		bigAsts = new Polygon[4];
		bigAsts[0] = new Polygon(new int[] {center.x+43, center.x+0, center.x+46, center.x+62, center.x+49, center.x+69, center.x+63, center.x+44}, new int[] {center.y+37, center.y+86, center.y+117, center.y+97, center.y+77, center.y+75, center.y+57, center.y+39}, 8);
		bigAsts[1] = new Polygon(new int[] {center.x+40, center.x+12, center.x+28, center.x+72, center.x+69, center.x+97, center.x+57, center.x+44, center.x+44}, new int[] {center.y+19, center.y+55, center.y+79, center.y+86, center.y+66, center.y+58, center.y+36, center.y+20, center.y+20, }, 9);
		bigAsts[2] = new Polygon(new int[] {center.x+0, center.x+15, center.x+53, center.x+68, center.x+42, center.x+26, center.x+0 }, new int[] {center.y+63, center.y+12, center.y+13, center.y+43, center.y+69, center.y+58, center.y+65, }, 7);
		bigAsts[3] = new Polygon(new int[] {center.x+0, center.x+37, center.x+82, center.x+90, center.x+42, center.x+34, center.x+16, center.x+2, }, new int[] {center.y+51, center.y+27, center.y+36, center.y+59, center.y+107, center.y+77, center.y+74, center.y+54,}, 8);
		changeAsteroid();
	}
	
	public void changeAsteroid() {
		
		this.bBox = bigAsts[(int)Math.random()*4];
	}
	

}

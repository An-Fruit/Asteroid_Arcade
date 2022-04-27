import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.HashSet;
import java.util.Queue;

public class bigAsteroid extends Prop{

	Polygon[] bigAsts;
	public bigAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		bigAsts = new Polygon[4];
		bigAsts[0] = new Polygon(new int[] {(int)center.x+43, (int)center.x+0, (int)center.x+46, (int)center.x+62, (int)center.x+49, (int)center.x+69, (int)center.x+63, (int)center.x+44}, new int[] {(int)center.y+37, (int)center.y+86, (int)center.y+117, (int)center.y+97, (int)center.y+77, (int)center.y+75, (int)center.y+57, (int)center.y+39}, 8);
		bigAsts[1] = new Polygon(new int[] {(int)center.x+40, (int)center.x+12, (int)center.x+28, (int)center.x+72, (int)center.x+69, (int)center.x+97, (int)center.x+57, (int)center.x+44, (int)center.x+44}, new int[] {(int)center.y+19, (int)center.y+55, (int)center.y+79, (int)center.y+86, (int)center.y+66, (int)center.y+58, (int)center.y+36, (int)center.y+20, (int)center.y+20, }, 9);
		bigAsts[2] = new Polygon(new int[] {(int)center.x+0, (int)center.x+15, (int)center.x+53, (int)center.x+68, (int)center.x+42, (int)center.x+26, (int)center.x+0 }, new int[] {(int)center.y+63, (int)center.y+12, (int)center.y+13, (int)center.y+43, (int)center.y+69, (int)center.y+58, (int)center.y+65, }, 7);
		bigAsts[3] = new Polygon(new int[] {(int)center.x+0, (int)center.x+37, (int)center.x+82, (int)center.x+90, (int)center.x+42, (int)center.x+34, (int)center.x+16, (int)center.x+2, }, new int[] {(int)center.y+51, (int)center.y+27, (int)center.y+36, (int)center.y+59, (int)center.y+107, (int)center.y+77, (int)center.y+74, (int)center.y+54,}, 8);
		changeAsteroid();
	}
	
	public void collapse(Queue<Prop> A) {
		int angle=0;
		if (xVel <0) {
			angle = (int)Math.toDegrees(Math.atan(yVel/xVel))+180;
		}
		else if (xVel>=0) {
			angle = (int)Math.toDegrees(Math.atan(yVel/xVel));
		}
		int newVelx = (int)(Math.cos(Math.toRadians(angle+60))*2);
		int newVely = (int)(Math.sin(Math.toRadians(angle+60))*2);
		
		int newVelx1 = (int)(Math.cos(Math.toRadians(angle-60))*2);
		int newVely1 = (int)(Math.sin(Math.toRadians(angle-60))*2);
		
		
		medAsteroid split1 = new medAsteroid((int)center.x, (int)center.y, newVelx, newVely);
		medAsteroid split2 = new medAsteroid((int)center.x, (int)center.y, newVelx1, newVely1);
		A.offer(split1);
		A.offer(split2);
	}
	
	public void changeAsteroid() {
		
		this.bBox = bigAsts[(int)Math.random()*4];
	}
	
	public void paintComponent(Graphics window) {
		window.setColor(Color.white);
		window.drawPolygon(bBox);
		move();
	}
	

}
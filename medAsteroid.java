import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.HashSet;
import java.util.Queue;

public class medAsteroid extends Prop {
	
	Polygon[] medAsts;
	public medAsteroid(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel, new Polygon());
		medAsts = new Polygon[3];
		medAsts[0] = new Polygon(new int[] {(int)center.x+0, (int)center.x+11, (int)center.x+36, (int)center.x+41, (int)center.x+21, (int)center.x+5, }, new int[] {(int)center.y+16, (int)center.y+8, (int)center.y+7, (int)center.y+27, (int)center.y+36, (int)center.y+21, }, 6);
		medAsts[1] = new Polygon(new int[] {(int)center.x+5, (int)center.x+39, (int)center.x+48, (int)center.x+33, (int)center.x+14, (int)center.x+5, }, new int[] {(int)center.y+28, (int)center.y+16, (int)center.y+36, (int)center.y+49, (int)center.y+46, (int)center.y+32, }, 6);
		medAsts[2] = new Polygon(new int[] {(int)center.x+0, (int)center.x+40, (int)center.x+54, (int)center.x+34, (int)center.x+14, (int)center.x+2,  }, new int[] {(int)center.y+51, (int)center.y+32, (int)center.y+52, (int)center.y+71, (int)center.y+66, (int)center.y+52, }, 6);
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
		int newVelx = (int)(Math.cos(Math.toRadians(angle+60))*5);
		int newVely = (int)(Math.sin(Math.toRadians(angle+60))*5);
		
		int newVelx1 = (int)(Math.cos(Math.toRadians(angle-60))*5);
		int newVely1 = (int)(Math.sin(Math.toRadians(angle-60))*5);
		
		
		smallAsteroid split1 = new smallAsteroid((int)center.x, (int)center.y, newVelx, newVely);
		smallAsteroid split2 = new smallAsteroid((int)center.x, (int)center.y, newVelx1, newVely1);
		A.offer(split1);
		A.offer(split2);
	}
	
	public void changeAsteroid() {
		
		this.bBox = medAsts[(int)(Math.random()*3)];
	}
	
	public void paintComponent(Graphics window) {
		window.setColor(Color.white);
		window.drawPolygon(bBox);
		move();
	}
	

}

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Prop extends JPanel{

	int xVel, yVel, xLoc, yLoc;
	boolean hit;
	Polygon bBox;
	
	public Prop(int x, int y, int xVel, int yVel, Polygon r) {
		xLoc = x;
		yLoc = y;
		this.xVel = xVel;
		this.yVel = yVel;
		hit = false;
		bBox = r;
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawPolygon(bBox);
	}
	
	
	public boolean gotHit() {
		return hit;
	}
}

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Prop extends JPanel{

	int xVel, yVel;
	Point center;
	boolean hit;
	Polygon bBox;
	
	public Prop(int x, int y, int xVel, int yVel, Polygon r) {
		center = new Point(x, y);
		this.xVel = xVel;
		this.yVel = yVel;
		hit = false;
		bBox = r;
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawPolygon(bBox);
	}
	
	public Point getCenter() {
		return center;
	}
	
	public boolean gotHit() {
		return hit;
	}
	
	public void setPoly(Polygon p) {
		bBox = p;
	}
	
	public Polygon getPoly() {
		return bBox;
	}
}

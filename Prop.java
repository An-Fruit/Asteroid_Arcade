import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Prop extends JPanel{

	double xVel;
	double yVel;
	Point center;
	boolean hit;
	Polygon bBox;
	
	public Prop(int x, int y, double xVel, double yVel, Polygon r) {
		center = new Point(x, y);
		this.xVel = xVel;
		this.yVel = yVel;
		hit = false;
		bBox = r;
	}
	
	public void Inbounds() {
		if (center.x>1000) {
			center.x -= 1000;
			bBox.translate(-1000, 0);
		}
		else if( center.x<0) {
			center.x += 1000;
			bBox.translate(1000, 0);
		}
		
		if (center.y>=1000) {
			center.y -= 1000;
			bBox.translate(0,-1000);
		}
		else if( center.y<=0) {
			center.y += 1000;
			bBox.translate(0, 1000);
		}
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
	public void move() {
		center.x += xVel;
		center.y += yVel;
		bBox.translate((int)xVel,  (int)yVel);
	}
}

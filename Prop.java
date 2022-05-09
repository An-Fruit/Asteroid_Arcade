import java.awt.Color;
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
	
	public void Inbounds(int w, int h) {
		if (center.x>w) {
			center.x -= w;
			bBox.translate(-w, 0);
		}
		else if( center.x<0) {
			center.x += w;
			bBox.translate(w, 0);
		}
		
		if (center.y>=h) {
			center.y -= h;
			bBox.translate(0,-h);
		}
		else if( center.y<=0) {
			center.y += h;
			bBox.translate(0, h);
		}
	}
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
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

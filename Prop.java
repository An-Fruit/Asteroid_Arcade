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
	public String toString() {
		String s = "X Velocity: "  + xVel + " Y Velociity: " + yVel + " X Location: " + center.x + " Y Location: " + center.y;
		return s;
	}
}

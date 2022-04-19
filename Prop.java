import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Prop extends JPanel{

	int xVel, yVel;
	boolean hit;
	Rectangle bBox;
	
	public Prop(int x, int y, Rectangle r) {
		xVel = x;
		yVel = y;
		hit = false;
		bBox = r;
	}
	
	public void paintComponent(Graphics g) {
	}
}

import java.awt.Graphics;
import java.awt.Polygon;

public class Bullet extends Prop{

	public Bullet(int x, int y, double temp, double temp2) {
		super(x, y, temp, temp2, new Polygon(new int[] {x - 1, x + 1, x + 1, x - 1}, new int[] {y + 1, y + 1, y - 1, y - 1}, 4));
		
		// TODO Auto-generated constructor stub
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
		move();
	}

}
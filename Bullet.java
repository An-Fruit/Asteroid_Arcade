import java.awt.Polygon;

public class Bullet extends Prop{

	public Bullet(int x, int y, double temp, double temp2) {
		super(x, y, temp, temp2, new Polygon(new int[] {x - 2, x + 2, x + 2, x - 2}, new int[] {y + 2, y + 2, y - 2, y - 2}, 4));
		
		// TODO Auto-generated constructor stub
	}

}

import java.awt.Graphics;

import javax.swing.JPanel;

public class prop extends JPanel{

	int xvel, yvel;
	boolean hit;
	
	public prop(int x, int y) {
		xvel = x;
		yvel = y;
		hit = false;
	}
	
	public void paintComponent(Graphics g) {
		
	}
}

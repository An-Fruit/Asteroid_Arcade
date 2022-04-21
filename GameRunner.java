import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class GameRunner {
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
	public static void main( String args[] )
	{		
		JFrame window = new JFrame("Game Runner");
		AstroidGame game = new AstroidGame();
		
		window.setVisible(true);
		window.add(BorderLayout.NORTH, game);
		window.setSize(WIDTH,HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

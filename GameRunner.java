import java.awt.Color;

import javax.swing.JFrame;

public class GameRunner extends JFrame{
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	
	public GameRunner() {
		super("Game Runner");

		setSize(WIDTH,HEIGHT);
			
        AsteroidGame game = new AsteroidGame();
       
		add(game);
		
		setVisible(true);	
		
		setBackground(Color.BLUE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception{
		new GameRunner();
	}
}

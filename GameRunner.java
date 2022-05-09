import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameRunner extends JFrame{
	
	
	
	public GameRunner() {
		super("Game Runner");
		
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
			
        AsteroidGame game = new AsteroidGame((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
       
		add(game);
		
		setVisible(true);	
		
		setBackground(Color.BLACK);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception{
		new GameRunner();
	}
}

import javax.swing.JFrame;

public class GameRunner {
	
	public static void main(String[] args) throws Exception{
		
		JFrame window = new JFrame("Board Game Runner");
		AsteroidGame game = new AsteroidGame();
			
       
		window.add(game);
		window.setVisible(true);
		window.setSize(1000,1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

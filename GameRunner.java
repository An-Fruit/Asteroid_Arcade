import javax.swing.JFrame;

public class GameRunner extends JFrame{
	
	
	public GameRunner() {
		super("Game Runner");

		setSize(WIDTH,HEIGHT);
			
        AsteroidGame game = new AsteroidGame();
       
		add(game);
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) throws Exception{
		new GameRunner();
	}
}

import javax.swing.JFrame;

public class Game2048 {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 600;
	GamePanel GP;
	
	public static void main(String[] args) {
		Game2048 LI = new Game2048();
		LI.setup();
	}
	Game2048() {
		frame = new JFrame();
		GP = new GamePanel();
		frame.addKeyListener(GP);
	}
	
	void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(GP);
	}
}

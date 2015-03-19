import javax.swing.JFrame;


public class Snowman extends JFrame {


	public Snowman () {
		super("Snowman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SnowmanPanel sp = new SnowmanPanel();
		
		getContentPane().add(sp);
		pack();
		setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Snowman();

	}

}

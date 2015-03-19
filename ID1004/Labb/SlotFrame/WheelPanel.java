import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class implements the graphical display of three symbol wheels
 * (actually strips) which can be animated to roll into a designated
 * position. The symbols are loaded from ten external files which are
 * expected to be 80x80 pixels each, and different graphically.
 * 
 * @author fki@kth.se
 *
 */
public class WheelPanel extends JPanel {

	/**
	 * Contains the symbol images as read from their files.
	 */
	private BufferedImage [] symbols = null;
		
	/**
	 * The array of filenames for the symbols on each wheel. The symbols
	 * will be displayed on the payline of the wheel just as the indexes
	 * to the array symbolFileNames. All wheels looks the same.
	 */
	private String [] symbolFileNames = {
			"symPlum.png",
			"symOrange.png",
			"symCherry.png",
			"symAtSign.png",
			"symBell.png",
			"symGrapes.png",
			"sym7.png",
			"symLemon.png",
			"symMellon.png",
			"sym3BAR.png"
	};
	
	/**
	 * The reelstrip image holds the composite image of the wheel symbols,
	 * with suitable leading and trailing duplication to make the strip
	 * look circular on display.
	 */
	private BufferedImage reelstrip = null;
	
	/**
	 * The wheelY array contains the y coordinate of each reelstrip image.
	 * It is used to communicate the position of the image between method
	 * animate() and method paintComponent().
	 */
	private int [] wheelY = new int[3];
	
	/**
	 * Our wheel model information as expected by interface SlotControl.
	 * We have three wheels with ten symbols each.
	 */
	private int [][] wheelModelInformation = 
		{
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9}
		};
	
	/**
	 * Returns our wheel model, three wheels with ten unique symbols each.
	 * @return This implementation's wheel model.
	 */
	public int [][] getWheelModel() {
		return wheelModelInformation;
	}

	/**
	 * Creates a new WheelPanel of the provided size. Since we are set
	 * within a JLayeredPanel we must explicitly set our position and size
	 * using setBounds(). The actual size is decided by another component
	 * in the same JLayeredPanel so we just declare our size to be match
	 * that.
	 * @param size The size of this WheelPanel.
	 */
	public WheelPanel (Dimension size) {
		// Declare our position and size.
		setBounds(0, 0, size.width, size.height);

		// Declare an array of images of the same length as the symbol
		// file names.
		symbols = new BufferedImage[symbolFileNames.length];
		// Load the symbol file images into the symbols array.
		try {
			for (int i = 0; i < symbolFileNames.length; i++) {
				symbols[i] = ImageIO.read(new File(symbolFileNames[i]));
			}
		}
		catch (IOException iox) {
			iox.printStackTrace();
		}
		
		// Create the reelstrip image, making it high enough to hold 16
		// symbols images (ten symbols, plus three before and three after)
		reelstrip = new BufferedImage(80, 16 * 80, BufferedImage.TYPE_INT_ARGB);
		
		// Get a Graphics context from the reelstrip image so we can paint
		// the symbols in it.
		Graphics g = reelstrip.getGraphics();
		
		// Paint the symbols into the reelstrip image, creating the following
		// sequence: [7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2] from
		// top to bottom.
		// The reason for this is that when symbol 0 is to be displayed it must
		// be centered under the payline in the vertical middle of this component.
		// We then need symbols 7, 8, 9 to show above it. Similarly, when showing
		// symbol 9, we want symbols 0, 1, and 2 to show below it.
		for (int i = 0; i < 16; i++) {
			g.drawImage(symbols[(i+7)%10], 0, i * 80, null);
		}
		
		// Draw a gray border along the edges of the strip
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, reelstrip.getWidth()-1, reelstrip.getHeight());
	}
	
	/**
	 * Computes and returns the y coordinate for the requested symbol.
	 * The calculation starts at the current y position of the payLine
	 * which is updated by paintComponent(). We then subtract (move up)
	 * by n+3 symbols (the 3 is for the leading three symbols 7,8,9),
	 * multiply by 80 (the height of a symbol image) and finally 40
	 * (half the height of a symbol image) to center it vertically.
	 * 
	 * @param n The symbol to display on the payline
	 * @return The y coordinate for the reelstrip.
	 */
	private int getYForSymbol(int n) {
		return payLineY - ((n + 3) * 80 + 40);
	}
	
	/**
	 * This method animates the three wheels to spinning, then stops
	 * them on the symbols designated in the provided array. Index 0 is the
	 * leftmost wheel, and they are stopped from left to right.
	 * 
	 * Important: this method must be called on a user thread.
	 * 
	 * @param wheelSymbol The stop positions for the weels.
	 */
	public void animate(int [] wheelSymbol) {
		// Randomize the initial positions of the reelstrips to give the 
		// wheels a visual 'kick'
		for (int i = 0; i < 3; i++) {
			wheelY[i] = -((int) (Math.random() * 800));
		}
		
		// The increment array is how many pixels to shift each wheel
		// downward on each animation frame. These are selected to be
		// prime and different to avoid wheels from appearing synchronized.
		int [] increment = {37,41,43};
		
		// The number of spin frames for each wheel. The actual delay time
		// is found by ms = nofframes * framedelay. Thus the animation will spin
		// all wheels for 20*50 = 1000 ms, two wheels for 6*50=300ms and
		// the last wheel for 6*50=300ms.
		// It would of course be trivial to specify the desired times instead
		// and compute nofframes = ms/framedelay.
		int [] spinAnims = {20, 6, 6};
		
		// For all three wheels w...
		for (int w = 0; w < 3; w++) {
			// For the desired number of animations frames...
			for (int i = 0; i < spinAnims[w]; i++) {
				// For each spinning wheel j...
				for (int j = w; j < 3; j++) {
					wheelY[j] += increment[j]; 	// add increment to y
					if (0 < wheelY[j]) {		// adjust for wraparound
						wheelY[j] -= 10*80;
					}
				}
				repaint();	// ask for a screen update
				// Wait so we can see the updated frame
				try {
					Thread.currentThread().sleep(50); // 20 fps
				}
				catch (InterruptedException irx) {}
			}
			// This reelstrip has stopped and is assigned its position
			wheelY[w] = getYForSymbol(wheelSymbol[w]);
		}
		// All stop, request a screen update for the last reelstrip
		repaint();
	}
	
	/**
	 * The variable payLineY keeps track of the vertical position of
	 * the payline in this component.
	 */
	private volatile int payLineY = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension size = getSize();
		payLineY = size.height / 2;

		Graphics2D g2 = (Graphics2D) g;
		int quarterWidth = size.width / 4;
		int x = quarterWidth - 40;
		int y = wheelY[0];
		g2.drawImage(reelstrip, null, x, y);
		x += quarterWidth;
		y = wheelY[1];
		g2.drawImage(reelstrip, null, x, y);
		x += quarterWidth;
		y = wheelY[2];
		g2.drawImage(reelstrip, null, x, y);
		
	}
}

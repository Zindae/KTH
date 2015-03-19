import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The BlingPanel has the decorative purpose to provide a semi-transparent
 * image or a red border and a dark horizontal payline. The animated symbol
 * wheels of the slot machine are shown through (behind) this image.
 * 
 * @author fki@kth.se
 *
 */
public class BlingPanel extends JPanel {
	
	private boolean fallBackMode = false;

	/**
	 * The image as read from file.
	 */
	private BufferedImage glassPanel = null;
	
	/**
	 * Our internal version of the image, filtered to alpha.
	 */
	private BufferedImage bi = null;
	
	/**
	 * Rescale operator.
	 */
	private RescaleOp rop = null;

	/**
	 * Creates a new BlingPanel using the compile-time filename
	 * for the image.
	 */
	public BlingPanel (boolean fallBackMode) {
		
		this.fallBackMode = fallBackMode;

		// Read the image from file.
		try {
			glassPanel = ImageIO.read(new File("glassframe.jpg"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		// Find out how wide and high the image is.
		int w = glassPanel.getWidth(null);
		int h = glassPanel.getHeight(null);

		// Set the position and bounds of this component to match the
		// size of the image. This is vital, because we are held inside
		// a JLayeredPane and it has no default layout.
		setBounds(0, 0, w, h);
		
		// Create an internal image of the proper type.
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		
		// Set up scaling and offset parameters.
		float[] scales = {1f, 1f, 1f, 0.5f};
		float[] offsets = new float [4];
		
		// Create a rescale operator from the parameters.
		rop = new RescaleOp(scales, offsets, null);
		
		// Get a graphics object from the internal image so we can paint
		// in it.
		Graphics g = bi.getGraphics();
		
		// Draw our file image into the internal image.
		// (I am not sure why this is necessary, but it may be a way to
		//  guarantee that we get the image into a format which we know
		//  can be drawn by paintComponent() below.)
		g.drawImage(glassPanel,  0, 0, null);
		
		// Set this component to be semi-transparent.
		setOpaque(false);
	}
	
	private static final int borderWidth = 10;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension size = getSize();
		if (fallBackMode) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, size.width, borderWidth);
			g.fillRect(0, 0, borderWidth, size.height);
			g.fillRect(0, size.height-borderWidth, size.width, borderWidth);
			g.fillRect(size.width-borderWidth, 0, borderWidth, size.height);
			g.setColor(Color.BLACK);
			int midY = size.height / 2;
			g.fillRect(0, midY - 6, size.width, 3);
			g.fillRect(0, midY + 3, size.width, 3);
		}
		else {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(bi, rop, 0, 0);
		}
	}
}


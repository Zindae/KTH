import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SnowmanPanel extends JPanel {
	
	protected int mid = 150;
	protected int top = 50;
	
	public SnowmanPanel () {
		setPreferredSize(new Dimension (300, 200));
		setBackground (Color.cyan);		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension size = getSize();
		
		// GROUND
		g.setColor(Color.blue);
		g.fillRect(0, 175, size.width, size.height - 175);
		//g.fillRect(0, 175, 300, 25);
		
		// SUN
		g.setColor(Color.yellow);
		g.fillOval (-40, -40, 80, 80);
		
		// SNOWMAN
		g.setColor(Color.white);
		g.fillOval(mid-20,  top,  40,  40); // HEAD
		g.fillOval(mid-35, top+35, 70,  50); // UPPER TORSO
		g.fillOval(mid-50, top+80, 100, 60); // LOWER TORSO
		
		// EYES
		g.setColor(Color.black);
		g.fillOval(mid-10, top+10, 5, 5); // LEFT EYE
		g.fillOval(mid+5, top+10, 5, 5); // RIGHT EYE
		
		// MOUTH
		g.drawArc(mid-10, top+20, 20,  10, 190, 160);
		
		// ARMS
		g.drawLine(mid-25, top+60, mid-50, top+40); // LEFT ARM
		g.drawLine(mid+25, top+60, mid+55,  top+60); // RIGHT ARM
		
		// HAT
		g.drawLine(mid-20, top+5, mid+20, top+5); // BRIM
		g.fillRect(mid-15, top-20, 30, 25); // TOP OF HAT
	}
}

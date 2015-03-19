import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Shape {

	public void draw (Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.BLACK);
	    g.drawRect(x, y, width, height);
	}
}
	
    
    

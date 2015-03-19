import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	
	public void draw (Graphics g, int x, int y, int height, int width ){
		g.setColor(Color.BLUE);
		g.drawLine(x,y+height,x+width/2,y);
		g.drawLine(x+width/2,y,x+width,y+height);
		g.drawLine(x+width,y+height,x,y+height);
		
	}
	
}

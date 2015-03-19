
public class Up22 
{
	public static void main (String[]args)
	{
	class Point
	{
	private double    x;
	private double    y;
	
	public Point (double x, double y)
	{
    this.x = x;
	this.y = y;
	}
	
	public double distant (Point p)
	{
	        return Math.sqrt (Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }
   
 }
}

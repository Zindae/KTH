//LABB 2. PROGRAM 1: LAB1_Raknare.java. KLASS2: Punkt.java

public class Punkt 
{
	private double x;
	private double y;
	//privata instansvariablar som bara används i denna klass

		public Punkt()
		{
		x = 0;
		y = 0;
		//konstruktorer som ger förvalda värden för punkterna = 0 (origo)
	    }
		
		public Punkt(double a, double b)
		{
			x = a;
			y = b;
		//sätter punkterna som a och b
		}
		
		public double avstand()
		{
			double d = Math.sqrt(x * x + y * y);
			return d;
		//instansmetod som räknar avstånd mellan punkterna med pytagoras sats
		}
		
		public double avstand(Punkt p)
		{
			double d = Math.sqrt((p.x - x) * (p.x - x) 
					           + (p.y - y) * (p.y - y));
			return d;
		//räknar avståndet till punkten p
		}
		
		public String toString()
		{
			String s = "(" + x + ","+ y + ")";
			
			return s;
		//visar punkterna 
		}
}


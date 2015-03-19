
public class Up5 
{
	public static void main (String[] args)

	{
    double[]  v = produce ();
    
	System.out.println (java.util.Arrays.toString (v));
	}
	
	public static double[] produce ()
	{
		
    double[]  u = new double[7]; //en vektor med längden 7 bildas 
    
	for (int i = 0; i < u.length; i++)
	        u[i] = Math.sin (i * Math.PI / 6); //utför ekvationen för varje index tom 7
	
	return u;
	
	}
} 

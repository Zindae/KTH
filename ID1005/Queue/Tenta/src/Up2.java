
public class Up2
{
	public static void main (String [] args)
	{
	
	int[]      u = {1, 4, 5, 7, 10, 16, 25};
	int[][]    v = new int[u.length][];
	
	int    len = 1;
	
	for (int i = 0; i < u.length; i++) //varje g�ng denna for-loop k�rs k�rs n�sta for-loop, och motsvarande den efter
	    v[i] = new int[len++]; 
	
	 for (int i = 0; i < v.length; i++)
		
	   for (int j = 0; j < v[i].length; j++)
	       v[i][j] = u[i] + j;
	
	for (int[] w : v) //s�tter v�rdet v till w 
	{
	    for (int n : w) 
	       System.out.print (n + " ");
	    System.out.println ();
	}

  }
}

public class Up3 
{
    public static void main (String[] args)
	{
		
    int    k = 10;
    int[]  v = {10, 3, 8, 15, 2};
 	
    change (k, v);
	
    System.out.println (k);
	   
	System.out.println (java.util.Arrays.toString (v)); //komverterar vektor till str�ng
	}
	
	public static void change (int k, int[] u) //en NY variabel k, inte samma som f�rut
	{
	    k++;
	//u= new int[u.length]; //n�r denna kod anv�nds kommer det inte att bilda en slumpm�ssig vektor
	for (int i = 0; i < u.length; i++)
	        u[i] = (int) (10 * Math.random ()) + 1; //genererar slumpnummer som s�tts in p� index 'i', i u.
	}
}


public class Up15
{
	public static void main (String[] args)
	{
		
	StringBuilder [] v = new StringBuilder[4];
	
	v[0].append (25);
	v[1].append (2.5);
	v[2].append ('f');
	v[3].append ("fg");
	
	String    u = java.util.Arrays.toString (v);
	System.out.println (u);
	
	//Felet �r att det f�rs�kt anv�ndas en referens som inte pekar till n�gonting
	//programmet kommer f�rl�nga str�ngen, '252.5ffg' kommer bli nya str�gen
	
	}
}
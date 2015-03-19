import java.lang.*;

public class Up14 
{
	public static void main (String[] args)
	{
		
	StringBuilder    s = produce ();
	s.insert (1, 'e');
	System.out.println (s);
	}
	
	public static double StringBuilder produce ()
	{
	
	StringBuilder    sb = new StringBuilder ("a");
	sb.insert (0, "b");
	sb.append ("cd");
	return sb;
	
	//programmet kommer skriva in 'abcde' i strängen
	}
}


public class Up16 
{
	public static void main (String[] args)
	{
	String    s = "30 10 40 70 50";
	// s = "30 10 40 7f 50";
	
	String[]    tokens = s.split ("\\s"); 
	
	java.util.Arrays.sort (tokens); //sorterar tokens
	
	System.out.println (java.util.Arrays.toString (tokens));
	
	int    sum = 0;
	
	for (String t : tokens) //sätter tokens till strängen t
		
	   sum += Integer.parseInt (t);  //summan blir t
	System.out.println (sum);
	
	//programmet sorterar strängen efter storleksordning 
	
	}
}

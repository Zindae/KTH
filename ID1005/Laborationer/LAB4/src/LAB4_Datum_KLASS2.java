//klass 2 i LAB4_Datum

import java.util.*;

public class LAB4_Datum_KLASS2
{
	Scanner read = new Scanner(System.in);
	
	private int �r;
	private int m�nad;
	private int dag;
		
	public LAB4_Datum_KLASS2(int y, int m, int d) //konstruktor
	{
		�r = y;
		m�nad = m;
		dag = d;
		
		System.out.println("---------------------RESULTAT--------------------------------\n");	
		
		System.out.printf("Ditt f�delsedatum �r: %s! \n", this);
		//'this' anv�nder metoden toString, eftersom this beh�ver en str�ng 
	}
	

	public String toString() //inbyggd i java, anv�nds till 'this'
	{
				
		return String.format("%d/%d/%d", �r, m�nad, dag);
		//dessa v�rden retuneras 
	}
}

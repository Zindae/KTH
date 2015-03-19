//klass 2 i LAB4_Datum

import java.util.*;

public class LAB4_Datum_KLASS2
{
	Scanner read = new Scanner(System.in);
	
	private int år;
	private int månad;
	private int dag;
		
	public LAB4_Datum_KLASS2(int y, int m, int d) //konstruktor
	{
		år = y;
		månad = m;
		dag = d;
		
		System.out.println("---------------------RESULTAT--------------------------------\n");	
		
		System.out.printf("Ditt födelsedatum är: %s! \n", this);
		//'this' använder metoden toString, eftersom this behöver en sträng 
	}
	

	public String toString() //inbyggd i java, används till 'this'
	{
				
		return String.format("%d/%d/%d", år, månad, dag);
		//dessa värden retuneras 
	}
}

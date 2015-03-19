/*LABB 4. PROGRAM 4: LAB4_Personer_MAIN
 *
 *  Innefattar:
 *
 *   -  Flera objekt och konstruktorer med referenser till andra objekt
 *   -  Arv och klasser inuti klasser (nestlade klasse)
 *     
 * I detta program demonstreras olika klasser som printar information om olika personer */


public class LAB4_Personer_MAIN 
{
	public static void main (String[] args)
	{
		System.out.println("PROGRAM: Personer");
		
		//alla klasser ärver information från LAB4_Personer_JOBB, men skickas till klasserna FRITID och FAMILJ
		LAB4_Personer_FRITID hank = new LAB4_Personer_FRITID();
		LAB4_Personer_FRITID pelle = new LAB4_Personer_FRITID();
		
		LAB4_Personer_FAMILJ josef = new LAB4_Personer_FAMILJ();
		LAB4_Personer_FAMILJ jenny = new LAB4_Personer_FAMILJ();
		//använder personerna i olika klasser och metoder
		
		System.out.println("------------------------Person 1---------------------------------");
		pelle.name = "Pelle";
		pelle.Jobb1();
		pelle.fritid1();
		
		System.out.println("------------------------Person 2---------------------------------");
		hank.name = "Hank";
		hank.Jobb2();
		hank.fritid2();
		
		System.out.println("------------------------Person 3---------------------------------");
		jenny.name = "Jenny";
		jenny.familj2();
		jenny.Jobb3();
		
		System.out.println("------------------------Person 4---------------------------------");
		josef.name = "Josef";
		josef.familj1();
		josef.Jobb4();
		
	
	
	}
	
}

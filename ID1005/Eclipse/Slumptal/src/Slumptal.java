import java.util.Arrays;
import java.util.Random;
import java.util.Scanner; //Kan ta scanner från en ström, fil, konsolen 
public class Slumptal {

	private final int MIN_ANTAL_TAL = 10; //Int variabel MIN_ANTAL_TAL
	private final int MAX_ANTAL_TAL = 100; //INT variabel MAX_ANTAL_TAL
		
	private int [ ] talen = new int [MAX_ANTAL_TAL]; //Ny array med med tillhörande int
	private int antalTal = 0; // Inga tal imatade, Ny variabel antaltal
	
	private void antalTal (Scanner scan) { //Läser av inmatning
			System.out.println("Mata önskat slumptal som önskas mellan " + MIN_ANTAL_TAL + "-" + MAX_ANTAL_TAL);
			
			while ((antalTal < MAX_ANTAL_TAL) || (antalTal > MIN_ANTAL_TAL)) { // tills antalet är mindre än MAX_ANTAL

				System.out.print("");
				antalTal = scan.nextInt();  //Läsa av nästa imatning
				scan.nextLine(); //Läser av nästa rad
			
				 if ( (antalTal > MAX_ANTAL_TAL) || antalTal < MIN_ANTAL_TAL) {
				
					 System.out.print("Fel mata in talet igen ");
				
				 }
				
				else {
						return;
				
				}
			} 
	}	
	
	

	
	public void kör()  {
		antalTal(new Scanner(System.in)); //Tilldela utan en variabel, Går även att köras
		//Scanner scan = new Scanner(System.in);
		//mataInTal(scan);
		
		
		double [] randomNumbers = new double[antalTal];
		
		Random rnd = new Random();
		
		for (int i = 0; i < antalTal; i++) {
			randomNumbers[i] = rnd.nextDouble();
		}	
		
		Arrays.sort(randomNumbers);
		
		for(double f : randomNumbers) {
			System.out.println(f); //skriver ut formateringen
		}
		
		
		
	//System.out.println(());
		
		//System.out.println(antalTal());
		
	}			

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Slumptal start = new Slumptal();
		start.kör();

	}

}

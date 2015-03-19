import java.util.Arrays;
import java.util.Scanner; //Kan ta scanner från en ström, fil, konsolen 
public class Statisstik {

	private final int MIN_ANTAL_TAL = 3; //Int variabel MIN_ANTAL_TAL
	private final int MAX_ANTAL_TAL = 10; //INT variabel MAX_ANTAL_TAL
		
	private int [ ] talen = new int [MAX_ANTAL_TAL]; //Ny array med med tillhörande int
	private int antalTal = 0; // Inga tal imatade, Ny variabel antaltal
	
	private void mataInTal (Scanner scan) { //Läser av inmatning
			System.out.print("Mata in mellan ");
			System.out.print(MIN_ANTAL_TAL);
			System.out.print(" - ");
			System.out.print(MAX_ANTAL_TAL);
			System.out.print(" tal, avsluta med -1");
			System.out.println();
			
			while (antalTal < MAX_ANTAL_TAL) { // tills antalet är mindre än MAX_ANTAL
				System.out.print("Nästa tal> ");
				int talet = scan.nextInt();  //Läsa av nästa imatning
				scan.nextLine(); //Läser av nästa rad
				
				if (talet == - 1) {
					if (antalTal < MIN_ANTAL_TAL) { //inte tillräckligt många tal
						System.out.print ("Mata in minst ");
						System.out.print(MIN_ANTAL_TAL);
						System.out.println();
					}
				
					else {
						return;
					}
				}
				else {
					talen [antalTal] = talet; 
					antalTal += 1; //går tillbaka till while-loopen och kör den igen.
				}
			}	
	}
	
	public int minVärdet () {
		int rtr = talen [0]; //initiera till första elementet
		for (int i = 1; i < antalTal; i += 1) {
			if (talen[i] < rtr ) { // Undersök om lägre värde 
				rtr = talen[i];
			}
		}
		return rtr; //Returnera minvärdet
		
	}
	public int maxVärdet () {
		int rtr = talen [0]; //initiera till första elementet
		for (int i = 1; i < antalTal; i += 1) {
			if (rtr < talen[i]) { // Vår kandidat är mindre är det vi inspeketerar och byter ut den.
				rtr = talen[i];
			}
		}
		return rtr; //Returnera maxvärdet 
	}
	
	public void skrivUt() {
		for (int i = 0; i < antalTal; i += 1) { //Lokal variabel
			System.out.print(talen[i]);
			System.out.print(", "); //Komma & blanksteg
		}
			System.out.println();
	}
	
	public void kör()  {
		//Scanner scan = new Scanner(System.in);
		//mataInTal(scan);
		
		mataInTal(new Scanner(System.in)); //Tilldela utan en variabel, Går även att köras
		skrivUt();
		System.out.print("Minvärdet:  ");
		System.out.println(minVärdet());
		System.out.print("Maxvärdet: ");
		System.out.println(maxVärdet());
		System.out.print("Medelvärdet: ");
		System.out.println(medelVärdet());
		System.out.print("Medianvärdet: ");
		System.out.println(medianVärdet());
		
	}			
	// Talen ska vara ordnande
	// Median udda antal: mittersta talet
	// Median jämt antal: medelvärdet av de två i mitten
	
	public double medianVärdet() {
		int [] kopia = Arrays.copyOf(talen, antalTal); // Variabel med namnet kopia, Refernse
		Arrays.sort(kopia); // Sortera stegande ordning 
		if ((antalTal % 2) == 1) { //Udda antal // Modulousoperatorn , Resten av heltalsdivsion
			int i = antalTal / 2; // Mittersta elementet
			return kopia[i];
		}
		
		else { // jämt antal
			int i = antalTal / 2;
			double a = kopia[i - 1]; //två mittersta tal, "i" minus det tal innan
			double b = kopia [i]; 
			return (a + b) / 2.0d; //d = double konstant. 
			
		}
		
	}
	public double medelVärdet() {
		double summa = 0;
		for (int i = 0; i < antalTal; i += 1) {
			summa  = summa + talen[i];
			// summa += talen[i]; //Kan vara bättre, med komplexa 
		}
		return summa / (double) antalTal; //En division för heltal & flyttal
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Statisstik stat = new Statisstik();
		stat.kör();

	}

}

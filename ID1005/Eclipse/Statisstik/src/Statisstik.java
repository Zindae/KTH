import java.util.Arrays;
import java.util.Scanner; //Kan ta scanner fr�n en str�m, fil, konsolen 
public class Statisstik {

	private final int MIN_ANTAL_TAL = 3; //Int variabel MIN_ANTAL_TAL
	private final int MAX_ANTAL_TAL = 10; //INT variabel MAX_ANTAL_TAL
		
	private int [ ] talen = new int [MAX_ANTAL_TAL]; //Ny array med med tillh�rande int
	private int antalTal = 0; // Inga tal imatade, Ny variabel antaltal
	
	private void mataInTal (Scanner scan) { //L�ser av inmatning
			System.out.print("Mata in mellan ");
			System.out.print(MIN_ANTAL_TAL);
			System.out.print(" - ");
			System.out.print(MAX_ANTAL_TAL);
			System.out.print(" tal, avsluta med -1");
			System.out.println();
			
			while (antalTal < MAX_ANTAL_TAL) { // tills antalet �r mindre �n MAX_ANTAL
				System.out.print("N�sta tal> ");
				int talet = scan.nextInt();  //L�sa av n�sta imatning
				scan.nextLine(); //L�ser av n�sta rad
				
				if (talet == - 1) {
					if (antalTal < MIN_ANTAL_TAL) { //inte tillr�ckligt m�nga tal
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
					antalTal += 1; //g�r tillbaka till while-loopen och k�r den igen.
				}
			}	
	}
	
	public int minV�rdet () {
		int rtr = talen [0]; //initiera till f�rsta elementet
		for (int i = 1; i < antalTal; i += 1) {
			if (talen[i] < rtr ) { // Unders�k om l�gre v�rde 
				rtr = talen[i];
			}
		}
		return rtr; //Returnera minv�rdet
		
	}
	public int maxV�rdet () {
		int rtr = talen [0]; //initiera till f�rsta elementet
		for (int i = 1; i < antalTal; i += 1) {
			if (rtr < talen[i]) { // V�r kandidat �r mindre �r det vi inspeketerar och byter ut den.
				rtr = talen[i];
			}
		}
		return rtr; //Returnera maxv�rdet 
	}
	
	public void skrivUt() {
		for (int i = 0; i < antalTal; i += 1) { //Lokal variabel
			System.out.print(talen[i]);
			System.out.print(", "); //Komma & blanksteg
		}
			System.out.println();
	}
	
	public void k�r()  {
		//Scanner scan = new Scanner(System.in);
		//mataInTal(scan);
		
		mataInTal(new Scanner(System.in)); //Tilldela utan en variabel, G�r �ven att k�ras
		skrivUt();
		System.out.print("Minv�rdet:  ");
		System.out.println(minV�rdet());
		System.out.print("Maxv�rdet: ");
		System.out.println(maxV�rdet());
		System.out.print("Medelv�rdet: ");
		System.out.println(medelV�rdet());
		System.out.print("Medianv�rdet: ");
		System.out.println(medianV�rdet());
		
	}			
	// Talen ska vara ordnande
	// Median udda antal: mittersta talet
	// Median j�mt antal: medelv�rdet av de tv� i mitten
	
	public double medianV�rdet() {
		int [] kopia = Arrays.copyOf(talen, antalTal); // Variabel med namnet kopia, Refernse
		Arrays.sort(kopia); // Sortera stegande ordning 
		if ((antalTal % 2) == 1) { //Udda antal // Modulousoperatorn , Resten av heltalsdivsion
			int i = antalTal / 2; // Mittersta elementet
			return kopia[i];
		}
		
		else { // j�mt antal
			int i = antalTal / 2;
			double a = kopia[i - 1]; //tv� mittersta tal, "i" minus det tal innan
			double b = kopia [i]; 
			return (a + b) / 2.0d; //d = double konstant. 
			
		}
		
	}
	public double medelV�rdet() {
		double summa = 0;
		for (int i = 0; i < antalTal; i += 1) {
			summa  = summa + talen[i];
			// summa += talen[i]; //Kan vara b�ttre, med komplexa 
		}
		return summa / (double) antalTal; //En division f�r heltal & flyttal
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Statisstik stat = new Statisstik();
		stat.k�r();

	}

}

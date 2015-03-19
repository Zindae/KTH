import java.util.Scanner;


public class GissaTalet_labb {
	/**
	 * Max antal gissningar som vi till�ter spelaren.
	 * Om antal gissningar �r >= log2(N) s� g�r det alltid att vinna
	 * s� l�nge hemligheten dras ur 0 -- N-1.
	 * Till exempel, log2(100) = 6.64 dvs 7 gissningar.
	 * Men eftersom man kan gissa fel s f�r man n�gra extra.
	 */
	private final int MAX_ANTAL_GISSNINGAR = 10;
	
	/**
	 * Inneh�ller det hemliga tal som spelaren ska gissa sig till.
	 */
	private int hemligheten = 0;
	
	/**
	 * Det antal gissningar som spelaren har gjort i en omg�ng.
	 */
	private int antalGissningar = 0;
	
	/**
	 * Spelarens gissningar i en omg�ng.
	 */
	private int [] gissat = new int [MAX_ANTAL_GISSNINGAR];
	
	/**
	 * Nollst�ller spelet inf�r en ny omg�ng.
	 */
	private void nollst�ll() {
		antalGissningar = 0;
		hemligheten = (int) (Math.random() * 100d);
		System.out.println("Jag t�nker p� ett tal ...");
	}
	
	/**
	 * Ber spelaren om n�sta gissning, lagrar den i arrayen gissat och
	 * r�knar upp antalGissningar med ett.
	 * @param scan Den Scanner som gissningen ska l�sas fr�n.
	 * @return Det gissade talet.
	 */
	private int h�mtaGissning(Scanner scan) {
		System.out.print("Gissa: ");
		int g = scan.nextInt();
		scan.nextLine();
		
		gissat[antalGissningar] = g;
		antalGissningar += 1;
		return g;
	}
	
	/**
	 * J�mf�r en gissning med hemligheten och ger spelaren information
	 * om gissningen var korrekt, f�r l�g eller f�r h�g.
	 * @param g Gissningen som ska kontrolleras.
	 * @return true om gissningen st�mmer med hemligheten, false annars.
	 */
	private boolean j�mf�rGissning(int g) {
		if (g == hemligheten) {
			System.out.println("Korrekt!");
			return true;
		}
		else if (g < hemligheten) {
			System.out.println("F�r l�gt");
		}
		else {
			System.out.println("F�r h�gt");
		}
		return false;
	}
	
	/**
	 * Returnerar hur m�nga gissningar spelaren har kvar i den p�g�ende omg�ngen.
	 * @return Antal gissningar kvar
	 */
	private int antalGissningarKvar() {
		return MAX_ANTAL_GISSNINGAR - antalGissningar;
	}
	
	/**
	 * Skriver ut de gissningar som spelaren har gjort i omg�ngen.
	 */
	private void visaGissningar() {
		System.out.print("Du gissade p� ");
		for (int i = 0; i < antalGissningar; i++) {
			System.out.print(gissat[i]);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("Hemligheten var " + hemligheten);
	}
	
	/**
	 * Fr�gar om spelaren vill spela igen. Svar som b�rjar med j eller J r�knas som jakande,
	 * svar som b�rjar med n eller N r�knas som nekande. Det finns inget default.
	 * @param scan Den Scanner som svaret ska l�sas fr�n.
	 * @return true om spelaren vill spela igen, false om inte.
	 */
	private boolean spelaIgen(Scanner scan) {
		while (true) {
			System.out.print("Spela igen (J/N)?");
			String answer = scan.nextLine().trim().toUpperCase(); //Returnerar 
			if (answer.startsWith("J")) {
				return true;
			}
			else if (answer.startsWith("N")) {
				return false;
			}
		}
	}
	
	/**
	 * Nollst�ller spelet och spelar en omg�ng.
	 * @param scan Den Scanner som spelarens gissningar ska h�mtas fr�n.
	 */
	private void spelaEnOmg�ng (Scanner scan) {
		nollst�ll();
		while (0 < antalGissningarKvar()) {
			if (j�mf�rGissning(h�mtaGissning(scan))) {
				break;
			}
		}
		visaGissningar();
	}
	
	/**
	 * Spelar spelet s� l�nge spelaren vill forts�tta med en omg�ng till.
	 */
	public void k�r() {
		System.out.println("V�lkommen till spelet Gissa Talet!");
		Scanner scan = new Scanner(System.in);
		do {
			spelaEnOmg�ng(scan);
		} while (spelaIgen(scan));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GissaTalet_labb().k�r();
	}

}

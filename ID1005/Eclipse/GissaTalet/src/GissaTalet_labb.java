import java.util.Scanner;


public class GissaTalet_labb {
	/**
	 * Max antal gissningar som vi tillåter spelaren.
	 * Om antal gissningar är >= log2(N) så går det alltid att vinna
	 * så länge hemligheten dras ur 0 -- N-1.
	 * Till exempel, log2(100) = 6.64 dvs 7 gissningar.
	 * Men eftersom man kan gissa fel s får man nÂgra extra.
	 */
	private final int MAX_ANTAL_GISSNINGAR = 10;
	
	/**
	 * InnehÂller det hemliga tal som spelaren ska gissa sig till.
	 */
	private int hemligheten = 0;
	
	/**
	 * Det antal gissningar som spelaren har gjort i en omgång.
	 */
	private int antalGissningar = 0;
	
	/**
	 * Spelarens gissningar i en omgång.
	 */
	private int [] gissat = new int [MAX_ANTAL_GISSNINGAR];
	
	/**
	 * Nollställer spelet inför en ny omgång.
	 */
	private void nollställ() {
		antalGissningar = 0;
		hemligheten = (int) (Math.random() * 100d);
		System.out.println("Jag tänker pÂ ett tal ...");
	}
	
	/**
	 * Ber spelaren om nästa gissning, lagrar den i arrayen gissat och
	 * räknar upp antalGissningar med ett.
	 * @param scan Den Scanner som gissningen ska läsas från.
	 * @return Det gissade talet.
	 */
	private int hämtaGissning(Scanner scan) {
		System.out.print("Gissa: ");
		int g = scan.nextInt();
		scan.nextLine();
		
		gissat[antalGissningar] = g;
		antalGissningar += 1;
		return g;
	}
	
	/**
	 * Jämför en gissning med hemligheten och ger spelaren information
	 * om gissningen var korrekt, för låg eller för hög.
	 * @param g Gissningen som ska kontrolleras.
	 * @return true om gissningen stämmer med hemligheten, false annars.
	 */
	private boolean jämförGissning(int g) {
		if (g == hemligheten) {
			System.out.println("Korrekt!");
			return true;
		}
		else if (g < hemligheten) {
			System.out.println("För lågt");
		}
		else {
			System.out.println("För högt");
		}
		return false;
	}
	
	/**
	 * Returnerar hur många gissningar spelaren har kvar i den pågående omgången.
	 * @return Antal gissningar kvar
	 */
	private int antalGissningarKvar() {
		return MAX_ANTAL_GISSNINGAR - antalGissningar;
	}
	
	/**
	 * Skriver ut de gissningar som spelaren har gjort i omgången.
	 */
	private void visaGissningar() {
		System.out.print("Du gissade på ");
		for (int i = 0; i < antalGissningar; i++) {
			System.out.print(gissat[i]);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("Hemligheten var " + hemligheten);
	}
	
	/**
	 * Frågar om spelaren vill spela igen. Svar som börjar med j eller J räknas som jakande,
	 * svar som börjar med n eller N räknas som nekande. Det finns inget default.
	 * @param scan Den Scanner som svaret ska läsas från.
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
	 * Nollställer spelet och spelar en omgång.
	 * @param scan Den Scanner som spelarens gissningar ska hämtas frÂn.
	 */
	private void spelaEnOmgång (Scanner scan) {
		nollställ();
		while (0 < antalGissningarKvar()) {
			if (jämförGissning(hämtaGissning(scan))) {
				break;
			}
		}
		visaGissningar();
	}
	
	/**
	 * Spelar spelet så länge spelaren vill fortsätta med en omgång till.
	 */
	public void kör() {
		System.out.println("Välkommen till spelet Gissa Talet!");
		Scanner scan = new Scanner(System.in);
		do {
			spelaEnOmgång(scan);
		} while (spelaIgen(scan));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GissaTalet_labb().kör();
	}

}

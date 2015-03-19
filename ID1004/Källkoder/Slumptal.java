import java.util.Arrays;
import java.util.Scanner;

public class Slumptal {
	private final int MIN_ANTAL = 10;
	private final int MAX_ANTAL = 100;
	
	private int antalSlumptal = 0;
	private double [] slumptal = null;
	
	/**
	 * Kontrollerar om parametern är ett giltigt antal slumptal.
	 * @param n Antalet som skall provas
	 * @return true om antalet är giltigt, false annars.
	 */
	private boolean giltigtAntal(int n) {
		return (MIN_ANTAL <= n && n <= MAX_ANTAL);
	}
	
	/**
	 * Frågar användaren hur många slumptal som skall genereras. Ett giltigt antal
	 * lagras i instansen.
	 * 
	 * @param scan Den Scanner som ska användas för inmatning.
	 */
	private void frågaAntal(Scanner scan) {
		
		while (!giltigtAntal(antalSlumptal)) {
			System.out.println("Hur många slumptal önskas? ");
			antalSlumptal = scan.nextInt();
			scan.nextLine();
			if (!giltigtAntal(antalSlumptal)) {
				System.out.println("Ange ett antal mellan " + MIN_ANTAL + " och " + MAX_ANTAL);
			}
		}
	}
	
	/**
	 * Laddar variabeln slumptal med en array av slumptal. Längden bestäms
	 * av variabeln antalSlumptal som sätts av metoden frågaAntal.
	 */
	private void draSlumptal() {
		slumptal = new double [antalSlumptal];
		for (int i = 0; i < antalSlumptal; i++) {
			slumptal[i] = Math.random();
		}
	}
	
	/**
	 * Sorterar instansens slumptal i stigande ordingsföljd.
	 */
	private void sortera() {
		Arrays.sort(slumptal);
	}
	
	/**
	 * Skriver ut instansens slumptal på System.out, en rad per tal.
	 */
	private void skrivUt() {
		for (double e : slumptal) {
			System.out.println(e);
		}
	}
	
	/**
	 * Frågar användaren efter ett giltigt antal slumptal, laddar slumptalen i instansen,
	 * sorterar dem och skriver ut dem.
	 */
	public void kör() {
		frågaAntal(new Scanner(System.in));
		draSlumptal();
		sortera();
		skrivUt();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Slumptal().kör(); // Skapa en instans av Slumptal och anropa metoden kör.
	}

}

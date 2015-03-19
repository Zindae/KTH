import java.util.Arrays;
import java.util.Scanner;

public class Slumptal {
	private final int MIN_ANTAL = 10;
	private final int MAX_ANTAL = 100;
	
	private int antalSlumptal = 0;
	private double [] slumptal = null;
	
	/**
	 * Kontrollerar om parametern �r ett giltigt antal slumptal.
	 * @param n Antalet som skall provas
	 * @return true om antalet �r giltigt, false annars.
	 */
	private boolean giltigtAntal(int n) {
		return (MIN_ANTAL <= n && n <= MAX_ANTAL);
	}
	
	/**
	 * Fr�gar anv�ndaren hur m�nga slumptal som skall genereras. Ett giltigt antal
	 * lagras i instansen.
	 * 
	 * @param scan Den Scanner som ska anv�ndas f�r inmatning.
	 */
	private void fr�gaAntal(Scanner scan) {
		
		while (!giltigtAntal(antalSlumptal)) {
			System.out.println("Hur m�nga slumptal �nskas? ");
			antalSlumptal = scan.nextInt();
			scan.nextLine();
			if (!giltigtAntal(antalSlumptal)) {
				System.out.println("Ange ett antal mellan " + MIN_ANTAL + " och " + MAX_ANTAL);
			}
		}
	}
	
	/**
	 * Laddar variabeln slumptal med en array av slumptal. L�ngden best�ms
	 * av variabeln antalSlumptal som s�tts av metoden fr�gaAntal.
	 */
	private void draSlumptal() {
		slumptal = new double [antalSlumptal];
		for (int i = 0; i < antalSlumptal; i++) {
			slumptal[i] = Math.random();
		}
	}
	
	/**
	 * Sorterar instansens slumptal i stigande ordingsf�ljd.
	 */
	private void sortera() {
		Arrays.sort(slumptal);
	}
	
	/**
	 * Skriver ut instansens slumptal p� System.out, en rad per tal.
	 */
	private void skrivUt() {
		for (double e : slumptal) {
			System.out.println(e);
		}
	}
	
	/**
	 * Fr�gar anv�ndaren efter ett giltigt antal slumptal, laddar slumptalen i instansen,
	 * sorterar dem och skriver ut dem.
	 */
	public void k�r() {
		fr�gaAntal(new Scanner(System.in));
		draSlumptal();
		sortera();
		skrivUt();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Slumptal().k�r(); // Skapa en instans av Slumptal och anropa metoden k�r.
	}

}

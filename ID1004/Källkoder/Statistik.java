import java.util.Arrays;
import java.util.Scanner;
public class Statistik {
	
	private final int MIN_ANTAL_TAL = 3;
	private final int MAX_ANTAL_TAL = 10;
	
	private int [] talen = new int[MAX_ANTAL_TAL];
	private int antalTal = 0;
	
	private void mataInTal (Scanner scan) {
		System.out.print("Mata in ");
		System.out.print(MIN_ANTAL_TAL);
		System.out.print(" - ");
		System.out.print(MAX_ANTAL_TAL);
		System.out.print(" tal, avsluta med -1");
		System.out.println();
		
		while (antalTal < MAX_ANTAL_TAL) {
			System.out.print("Nästa tal> ");
			int talet = scan.nextInt();
			scan.nextLine();
			
			if (talet == -1) {
				if (antalTal < MIN_ANTAL_TAL) {
					System.out.print("Mata in minst ");
					System.out.print(MIN_ANTAL_TAL);
					System.out.println();
				}
				else {
					return;
				}
			}
			else {
				talen[antalTal] = talet;
				antalTal += 1;
			}
		}
	}
	
	public int minVärdet() {
		int rtr = talen[0]; // Initiera till första elementet
		for (int i = 1; i < antalTal; i += 1) {
			if (talen[i] < rtr) { // Undersök om lägre
				rtr = talen[i];
			}
		}
		return rtr; // Returnera minsta
	}
	
	public int maxVärdet() {
		int rtr = talen[0];
		for (int i = 1; i < antalTal; i += 1) {
			if (rtr < talen[i]) {
				rtr = talen[i];
			}
		}
		return rtr;
	}
	
	public void skrivUt() {
		for (int i = 0; i < antalTal; i += 1) {
			System.out.print(talen[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
	
	public void kör() {
		
		mataInTal(new Scanner(System.in));
		skrivUt();
		System.out.print("Minvärdet: ");
		System.out.println(minVärdet());
		System.out.print("Maxvärdet: ");
		System.out.println(maxVärdet());
		System.out.print("Medelvärdet: ");
		System.out.println(medelVärdet());
		System.out.print("Medianvärdet: ");
		System.out.println(medianVärdet());
		
	}
	
	// Talen ska vara ordnade
	// Median udda antal: mittersta talet
	// Median jämnt antal: medelvärdet av de två i mitten
	public double medianVärdet() {
		
		int [] kopia = Arrays.copyOf(talen, antalTal);
		Arrays.sort(kopia);
		
		if ((antalTal % 2) == 1) { // udda antal
			int i = antalTal / 2;
			return kopia[i];
		}
		else { // jämnt antal
			int i = antalTal / 2;
			double a = kopia[i - 1];
			double b = kopia[i];
			return (a + b) / 2.0d;
		}
	}
	
	public double medelVärdet() {
		double summa = 0;
		for (int i = 0; i < antalTal; i += 1) {
			summa = summa + talen[i];
		}
		return summa / (double) antalTal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statistik stat = new Statistik();
		stat.kör();
	}

}

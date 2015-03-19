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
			System.out.print("N�sta tal> ");
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
	
	public int minV�rdet() {
		int rtr = talen[0]; // Initiera till f�rsta elementet
		for (int i = 1; i < antalTal; i += 1) {
			if (talen[i] < rtr) { // Unders�k om l�gre
				rtr = talen[i];
			}
		}
		return rtr; // Returnera minsta
	}
	
	public int maxV�rdet() {
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
	
	public void k�r() {
		
		mataInTal(new Scanner(System.in));
		skrivUt();
		System.out.print("Minv�rdet: ");
		System.out.println(minV�rdet());
		System.out.print("Maxv�rdet: ");
		System.out.println(maxV�rdet());
		System.out.print("Medelv�rdet: ");
		System.out.println(medelV�rdet());
		System.out.print("Medianv�rdet: ");
		System.out.println(medianV�rdet());
		
	}
	
	// Talen ska vara ordnade
	// Median udda antal: mittersta talet
	// Median j�mnt antal: medelv�rdet av de tv� i mitten
	public double medianV�rdet() {
		
		int [] kopia = Arrays.copyOf(talen, antalTal);
		Arrays.sort(kopia);
		
		if ((antalTal % 2) == 1) { // udda antal
			int i = antalTal / 2;
			return kopia[i];
		}
		else { // j�mnt antal
			int i = antalTal / 2;
			double a = kopia[i - 1];
			double b = kopia[i];
			return (a + b) / 2.0d;
		}
	}
	
	public double medelV�rdet() {
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
		stat.k�r();
	}

}

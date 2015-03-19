import java.util.Arrays;
import java.util.Scanner;

public class FyraTal {
	private final int MAX_ANTAL = 4;
	private int [] talen = new int [MAX_ANTAL];
	
	/**
	 * Läser in fyra tal och lagrar dem i instansen.
	 * @param scan Den scanner som talen ska läsas från.
	 */
	private void lŠsInTal (Scanner scan) {
		System.out.println("Mata in " + MAX_ANTAL + " tal");
		for (int i = 0; i < MAX_ANTAL; i++) {
			System.out.print("Tal " + (i + 1) + ": ");
			talen[i] = scan.nextInt();
			scan.nextLine();
		}
	}
	
	/**
	 * Returnerar de lagrade talens summa.
	 * @return Summan av talen.
	 */
	private int summa() {
		int sum = 0;
		for (int e : talen) {
			sum += e;
		}
		return sum;
	}
	
	/**
	 * Skriver ut summan av talen.
	 */
	private void skrivSumma() {
		System.out.println ("Summa: " + summa());
	}
	
	/**
	 * Returnerar de lagrade talens medelvärde
	 * @return Medelvärdet av talen
	 */
	private double medelvŠrde() {
		return ((double) summa()) / (double) MAX_ANTAL;
	}
	
	/**
	 * Skriver ut talens medelvärde.
	 */
	private void skrivMedelvŠrde() {
		System.out.println("MedelvŠrde: " + medelvŠrde());
	}
	
	/**
	 * Returnerar de lagrade talens produkt.
	 * @return Produkten av talen.
	 */
	private long produkt() {
		long p = 1;
		for (int e : talen) {
			p *= e;
		}
		return p;
	}
	
	/**
	 * Skriver ut talens produkt.
	 */
	private void skrivProdukt() {
		System.out.println("Produkt: " + produkt());
	}
	
	/**
	 * Skriver ut det minsta och högsta av de lagrade talen.
	 */
	private void skrivMinOchMax() {
		Arrays.sort(talen);
		System.out.println("Minsta talet: " + talen[0]);
		System.out.println("Hšgsta talet: " + talen[MAX_ANTAL - 1]);
	}
	
	/**
	 * Läser in fyra tal, skriver ut deras summa, medelvärde, produkt samt minsta och högsta tal.
	 */
	public void kšr() {
		lŠsInTal (new Scanner(System.in));
		skrivSumma();
		skrivMedelvŠrde();
		skrivProdukt();
		skrivMinOchMax();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FyraTal fyra = new FyraTal();
		fyra.kšr();
	}

}

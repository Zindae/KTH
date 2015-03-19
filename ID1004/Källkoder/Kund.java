/**
 * Klassen Kund representerar en kund i simuleringen av v�xlingskontoret.
 * En kund har ett �rende som tar en viss tid, och en ankomsttid till
 * kontoret. Dessa tider best�ms och registreras i konstruktorn.
 * @author fki
 *
 */
public class Kund {
	/**
	 * Den minsta tiden ett kund�rende tar.
	 */
	public static long minimiTid = 10;
	/**
	 * Den maximala tiden ett kund�rende tar.
	 */
	public static long maximiTid = 20;
	
	/**
	 * Den slumpm�ssigt dragna �rendetiden f�r denna kund.
	 */
	public final long �rendetid;
	/**
	 * N�r kunden anl�nde till v�xlingskontoret.
	 */
	public long ankomsttid;
	
	public Kund (long anl�nde) {
		ankomsttid = anl�nde;
		�rendetid = minimiTid + (int) (Math.random() * (1 + maximiTid - minimiTid));
	}
}

/**
 * Klassen Kund representerar en kund i simuleringen av växlingskontoret.
 * En kund har ett ärende som tar en viss tid, och en ankomsttid till
 * kontoret. Dessa tider bestäms och registreras i konstruktorn.
 * @author fki
 *
 */
public class Kund {
	/**
	 * Den minsta tiden ett kundärende tar.
	 */
	public static long minimiTid = 10;
	/**
	 * Den maximala tiden ett kundärende tar.
	 */
	public static long maximiTid = 20;
	
	/**
	 * Den slumpmässigt dragna ärendetiden för denna kund.
	 */
	public final long ärendetid;
	/**
	 * När kunden anlände till växlingskontoret.
	 */
	public long ankomsttid;
	
	public Kund (long anlände) {
		ankomsttid = anlände;
		ärendetid = minimiTid + (int) (Math.random() * (1 + maximiTid - minimiTid));
	}
}

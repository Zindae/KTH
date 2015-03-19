/**
 * Klass Kassa representerar en kassa i simuleringen av ett v�xlingskontor. 
 * En kassa blir tilldelad en kund av klass Simulering. Kassan fr�gar kunden
 * hur l�ng tid �rendet kommer att ta, och schemal�gger en h�ndelse med sig
 * sj�lv som mottagare n�r kunden �r klar i kassan. N�r h�ndelsen rapporteras
 * anm�ler sig kassan som ledig till klass Simulering.
 * @author fki
 *
 */
public class Kassa implements H�ndelsehanterare {
	/**
	 * Variabeln skapadeKassor �r statisk f�r att kunna r�kna hur m�nga
	 * kassor som skapats och d�rmed ge varje kassa ett eget idnummer.
	 */
	private static int skapadeKassor = 0;

	/**
	 * Denna kassas idnummer.
	 */
	private int kassaNr;
	
	/**
	 * Referens till den instans av klass Simulering som driver simuleringen.
	 */
	private Simulering sim;
	
	/**
	 * Skapa en ny kassa.
	 * @param sim Den instans av klass Simulering som driver simuleringen.
	 */
	public Kassa(Simulering sim){
		this.sim = sim;
		kassaNr = ++skapadeKassor;
	}
	
	/**
	 * Denna metod anropas av klass Simulering kassan �r ledig och har blivit
	 * vald f�r att ta emot n�sta kund. Kassan registrerar hur l�nge kunden
	 * har v�ntat och schemal�gger d�refter en h�ndelse som inneb�r att
	 * kunden �r klar med sitt �rende.
	 * @param n�staKund Den kund som ska tas emot.
	 */
	public void taEmotKund(Kund n�staKund){
		sim.noteraV�ntetid(n�staKund);
		sim.simtext("kassa " + kassaNr + " tar emot en ny kund");
		sim.schemal�gg(
				new SimH�ndelse(sim.getSimklocka() + n�staKund.�rendetid,
						this,
						null));
	}
	
	/**
	 * I interface H�ndelsehanterare. Den enda typ av h�ndelse som Kassan
	 * f�rv�ntar sig �r att kunden �r klar och kassan kan bli ledig.
	 */
	public void h�ndelse(SimH�ndelse h) {
		sim.simtext("kassa " + kassaNr + " blir ledig");
		sim.ledigKassa(this);
	}
}

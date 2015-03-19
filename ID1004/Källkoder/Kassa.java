/**
 * Klass Kassa representerar en kassa i simuleringen av ett växlingskontor. 
 * En kassa blir tilldelad en kund av klass Simulering. Kassan frågar kunden
 * hur lång tid ärendet kommer att ta, och schemalägger en händelse med sig
 * själv som mottagare när kunden är klar i kassan. När händelsen rapporteras
 * anmäler sig kassan som ledig till klass Simulering.
 * @author fki
 *
 */
public class Kassa implements Händelsehanterare {
	/**
	 * Variabeln skapadeKassor är statisk för att kunna räkna hur många
	 * kassor som skapats och därmed ge varje kassa ett eget idnummer.
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
	 * Denna metod anropas av klass Simulering kassan är ledig och har blivit
	 * vald för att ta emot nästa kund. Kassan registrerar hur länge kunden
	 * har väntat och schemalägger därefter en händelse som innebär att
	 * kunden är klar med sitt ärende.
	 * @param nästaKund Den kund som ska tas emot.
	 */
	public void taEmotKund(Kund nästaKund){
		sim.noteraVäntetid(nästaKund);
		sim.simtext("kassa " + kassaNr + " tar emot en ny kund");
		sim.schemalägg(
				new SimHändelse(sim.getSimklocka() + nästaKund.ärendetid,
						this,
						null));
	}
	
	/**
	 * I interface Händelsehanterare. Den enda typ av händelse som Kassan
	 * förväntar sig är att kunden är klar och kassan kan bli ledig.
	 */
	public void händelse(SimHändelse h) {
		sim.simtext("kassa " + kassaNr + " blir ledig");
		sim.ledigKassa(this);
	}
}

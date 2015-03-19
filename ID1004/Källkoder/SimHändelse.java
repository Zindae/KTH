/**
 * Denna klass representerar en h�ndelse i simuleringen. En h�ndelse intr�ffar
 * vid en viss tidpunkt i den simulerade tiden. H�ndelser kan levereras till
 * objekt som implementerar interface H�ndelsehanterare.
 * @author fki
 *
 */
public class SimH�ndelse implements Comparable<SimH�ndelse> {
	/**
	 * N�r denna h�ndelse skall intr�ffa enligt klockan i simuleringen.
	 */
	private long tidpunkt;
	
	/**
	 * Det objekt som h�ndelsen skall rapporteras till.
	 */
	private H�ndelsehanterare mottagare;
	
	/**
	 * Ett frivilligt objekt som mottagaren kan anv�nda f�r att s�rskilja
	 * olika h�ndelser fr�n varandra.
	 */
	private Object meddelande;
	
	public int compareTo(SimH�ndelse that) {
		return (int) (Math.signum(this.tidpunkt - that.getTidpunkt()));
	}
	
	/**
	 * Returnerar denna h�ndelses tidpunkt enligt den simulerade klockan.
	 * @return Tidpunkten f�r denna h�ndelse.
	 */
	public long getTidpunkt() {
		return tidpunkt;
	}
	
	/**
	 * Skapar en ny h�ndelse.
	 * @param tidpunkt N�r h�ndelsen skall intr�ffa enligt den simulerade klockan.
	 * @param mottagare Det objekt som skall informeras om h�ndelsen.
	 * @param meddelande null, eller en referens till ett objekt som kan anv�ndas
	 * f�r att kommunicera fr�n avs�ndare till mottagare.
	 */
	public SimH�ndelse (long tidpunkt, H�ndelsehanterare mottagare, Object meddelande){
		this.tidpunkt = tidpunkt;
		this.mottagare = mottagare;
		this.meddelande = meddelande;
	}
	
	/**
	 * Returnerar denna h�ndelses mottagare.
	 * @return Det objekt som h�ndelsen skall rapporteras till.
	 */
	public H�ndelsehanterare getMottagare () {
		return mottagare;
	}
	
	/**
	 * Returnerar denna h�ndelses meddelande.
	 * @return null, eller ett objekt som avs�ndaren bifogat meddelandet.
	 */
	public Object getMeddelande() {
		return meddelande;
	}
}

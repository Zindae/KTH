/**
 * Denna klass representerar en händelse i simuleringen. En händelse inträffar
 * vid en viss tidpunkt i den simulerade tiden. Händelser kan levereras till
 * objekt som implementerar interface Händelsehanterare.
 * @author fki
 *
 */
public class SimHändelse implements Comparable<SimHändelse> {
	/**
	 * När denna händelse skall inträffa enligt klockan i simuleringen.
	 */
	private long tidpunkt;
	
	/**
	 * Det objekt som händelsen skall rapporteras till.
	 */
	private Händelsehanterare mottagare;
	
	/**
	 * Ett frivilligt objekt som mottagaren kan använda för att särskilja
	 * olika händelser från varandra.
	 */
	private Object meddelande;
	
	public int compareTo(SimHändelse that) {
		return (int) (Math.signum(this.tidpunkt - that.getTidpunkt()));
	}
	
	/**
	 * Returnerar denna händelses tidpunkt enligt den simulerade klockan.
	 * @return Tidpunkten för denna händelse.
	 */
	public long getTidpunkt() {
		return tidpunkt;
	}
	
	/**
	 * Skapar en ny händelse.
	 * @param tidpunkt När händelsen skall inträffa enligt den simulerade klockan.
	 * @param mottagare Det objekt som skall informeras om händelsen.
	 * @param meddelande null, eller en referens till ett objekt som kan användas
	 * för att kommunicera från avsändare till mottagare.
	 */
	public SimHändelse (long tidpunkt, Händelsehanterare mottagare, Object meddelande){
		this.tidpunkt = tidpunkt;
		this.mottagare = mottagare;
		this.meddelande = meddelande;
	}
	
	/**
	 * Returnerar denna händelses mottagare.
	 * @return Det objekt som händelsen skall rapporteras till.
	 */
	public Händelsehanterare getMottagare () {
		return mottagare;
	}
	
	/**
	 * Returnerar denna händelses meddelande.
	 * @return null, eller ett objekt som avsändaren bifogat meddelandet.
	 */
	public Object getMeddelande() {
		return meddelande;
	}
}

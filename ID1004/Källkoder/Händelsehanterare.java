/**
 * Detta interface implementeras av de objekt i simuleringen som vill kunna
 * bli meddelade om schemalagda händelser, t ex att en ny kund anländer
 * eller lämnar en kassa.
 * @author fki
 *
 */
public interface Händelsehanterare {
	/**
	 * Denna metod anropas hos mottagaren av händelsen. Vem som ska ta emot
	 * en händelse bestäms av avsändaren. Händelser levereras när händelsen
	 * med lägst tidpunkt ligger först i händelsekön.
	 * @param h
	 */
	public void händelse(SimHändelse h);
}

/**
 * Detta interface implementeras av de objekt i simuleringen som vill kunna
 * bli meddelade om schemalagda h�ndelser, t ex att en ny kund anl�nder
 * eller l�mnar en kassa.
 * @author fki
 *
 */
public interface H�ndelsehanterare {
	/**
	 * Denna metod anropas hos mottagaren av h�ndelsen. Vem som ska ta emot
	 * en h�ndelse best�ms av avs�ndaren. H�ndelser levereras n�r h�ndelsen
	 * med l�gst tidpunkt ligger f�rst i h�ndelsek�n.
	 * @param h
	 */
	public void h�ndelse(SimH�ndelse h);
}

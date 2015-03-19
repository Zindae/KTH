import java.util.ArrayList;
public class Beh�llare {

	/**
	 * Beh�llarens yttre storlek, dvs hur stor plats den tar i en annan beh�llare
	 */
	protected int storlek;
	
	/**
	 * Kapaciteten hur stor beh�llaren �r inuti. Summan av inneh�llets storlek f�r inte �verskrida kapaciteten.
	 */
	protected int kapacitet;
	
	String etikett;
	
	/**
	 * Beh�llarens inneh�ll, dvs de andra beh�llare som ligger i denna beh�llare.
	 */
	
	ArrayList<Beh�llare> inneh�ll = new ArrayList<Beh�llare>(); //referare till inneh�ll
	
	/**
	 * Skapar en ny beh�llare med de givna parametrarna
	 * @param storlek Beh�llarens storlek p� utsidan
	 * @param kapacitet Beh�llarens storlek p� insidan
	 * @param etikett En kort text som identifierar denna beh�llare
	 * @throws IllegalArgumentExpection Kastas om kapaciteten �verskrider,
	 * storleken vilket betyder att beh�llaren �r st�rre p� insidan �n p� utsidan.
	 */
	public Beh�llare(int storlek, int kapacitet, String etikett) throws IllegalArgumentException
	{
		if (storlek < kapacitet) {//Om storlek �r st�rre �n kapaciteten. Ge felmedellande
			throw new IllegalArgumentException("Storleken �r mindre �n kapaciteten");
		}
		this.etikett = etikett;
		this.storlek = storlek;
		this.kapacitet = kapacitet;
	}
	
	/**
	 * Returnerar denna beh�llares storlek, dvs yttre dimension.
	 * @return beh�llarens storlek.
	 */
	
	public int getSize(){
		return storlek;
	}
	
	/**
	 * L�gg till en beh�llare i denna beh�llare
	 * @param sak Beh�llaren som ska l�ggas till
	 * @return true om till�gget fick plats och gjordes, annars false
	 */
	
	public boolean add (Beh�llare sak){
	
		if ((sak.getSize() + sizeOfContents()) <= kapacitet){
			inneh�ll.add(sak);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Ber�knar storleken p� inneh�llet.
	 * @return
	 */
	protected int sizeOfContents(){
		int sum = 0;
		for (Beh�llare b : inneh�ll){
			sum += b.getSize();
		}
		return sum;
	}
	/**
	 * Returnerar en formaterad str�ng som representerar inneh�llet
	 * i denna beh�llare
	 * @param prefix indentering: s�tts in f�rst p� varje rad
	 * @return En str�ng som beskriver denna beh�llare och dess inneh�ll 
	 */
	
	public String toString(String prefix){ //Alltid kan skriva ut en string metodtext
		StringBuffer sb = new StringBuffer();
		sb.append(prefix); //L�gger till StringBuffer till prefix
		sb.append(etikett); //l�gger till stron
		if (!inneh�ll.isEmpty()){ //Om det inte �r tomt k�r den if-satsen
			sb.append(" inneh�ller: \n");
			for (Beh�llare b : inneh�ll){
				sb.append(b.toString(prefix + "   "));
				}
					}
		else{
			sb.append('\n');
			}
		return sb.toString();
		}
	
		public String toString(){
			return toString(""); //skickar med en tom str�ng
			
		}
		
	}
	

	
	
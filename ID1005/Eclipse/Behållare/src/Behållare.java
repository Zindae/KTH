import java.util.ArrayList;
public class Behållare {

	/**
	 * Behållarens yttre storlek, dvs hur stor plats den tar i en annan behållare
	 */
	protected int storlek;
	
	/**
	 * Kapaciteten hur stor behållaren är inuti. Summan av innehållets storlek får inte överskrida kapaciteten.
	 */
	protected int kapacitet;
	
	String etikett;
	
	/**
	 * Behållarens innehåll, dvs de andra behållare som ligger i denna behållare.
	 */
	
	ArrayList<Behållare> innehåll = new ArrayList<Behållare>(); //referare till innehåll
	
	/**
	 * Skapar en ny behållare med de givna parametrarna
	 * @param storlek Behållarens storlek på utsidan
	 * @param kapacitet Behållarens storlek på insidan
	 * @param etikett En kort text som identifierar denna behållare
	 * @throws IllegalArgumentExpection Kastas om kapaciteten överskrider,
	 * storleken vilket betyder att behållaren är större på insidan än på utsidan.
	 */
	public Behållare(int storlek, int kapacitet, String etikett) throws IllegalArgumentException
	{
		if (storlek < kapacitet) {//Om storlek är större än kapaciteten. Ge felmedellande
			throw new IllegalArgumentException("Storleken är mindre än kapaciteten");
		}
		this.etikett = etikett;
		this.storlek = storlek;
		this.kapacitet = kapacitet;
	}
	
	/**
	 * Returnerar denna behållares storlek, dvs yttre dimension.
	 * @return behållarens storlek.
	 */
	
	public int getSize(){
		return storlek;
	}
	
	/**
	 * Lägg till en behållare i denna behållare
	 * @param sak Behållaren som ska läggas till
	 * @return true om tillägget fick plats och gjordes, annars false
	 */
	
	public boolean add (Behållare sak){
	
		if ((sak.getSize() + sizeOfContents()) <= kapacitet){
			innehåll.add(sak);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Beräknar storleken på innehållet.
	 * @return
	 */
	protected int sizeOfContents(){
		int sum = 0;
		for (Behållare b : innehåll){
			sum += b.getSize();
		}
		return sum;
	}
	/**
	 * Returnerar en formaterad sträng som representerar innehållet
	 * i denna behållare
	 * @param prefix indentering: sätts in först på varje rad
	 * @return En sträng som beskriver denna behållare och dess innehåll 
	 */
	
	public String toString(String prefix){ //Alltid kan skriva ut en string metodtext
		StringBuffer sb = new StringBuffer();
		sb.append(prefix); //Lägger till StringBuffer till prefix
		sb.append(etikett); //lägger till stron
		if (!innehåll.isEmpty()){ //Om det inte är tomt kör den if-satsen
			sb.append(" innehåller: \n");
			for (Behållare b : innehåll){
				sb.append(b.toString(prefix + "   "));
				}
					}
		else{
			sb.append('\n');
			}
		return sb.toString();
		}
	
		public String toString(){
			return toString(""); //skickar med en tom sträng
			
		}
		
	}
	

	
	
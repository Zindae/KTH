
public class Tärning {
	
	private final int antalSidor;
	
	public Tärning (int antalSidor){ //Konstruktor
		this.antalSidor = antalSidor; 
	}
	
	public int kasta(){ //Gör en metod
		return 1+(int)(Math.random() * antalSidor);//Returnerar 1 int * antalSidor
	}
	public String toString(){ //Skriver ut bokstäverna, Strängen
	return "tärning " + antalSidor;
	}

}




public class T�rning {
	
	private final int antalSidor;
	
	public T�rning (int antalSidor){ //Konstruktor
		this.antalSidor = antalSidor; 
	}
	
	public int kasta(){ //G�r en metod
		return 1+(int)(Math.random() * antalSidor);//Returnerar 1 int * antalSidor
	}
	public String toString(){ //Skriver ut bokst�verna, Str�ngen
	return "t�rning " + antalSidor;
	}

}




public class T�rning {
	private final int antalSidor;
	
	public T�rning (int antalSidor){
		this.antalSidor = antalSidor;		
	}
	
	public int kasta() {
		return 1 + (int) (Math.random() * antalSidor);
	}
	
	public String toString() {
		return "t�rning " + antalSidor;
	}
}

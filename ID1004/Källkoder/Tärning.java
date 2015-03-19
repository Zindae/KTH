
public class Tärning {
	private final int antalSidor;
	
	public Tärning (int antalSidor){
		this.antalSidor = antalSidor;		
	}
	
	public int kasta() {
		return 1 + (int) (Math.random() * antalSidor);
	}
	
	public String toString() {
		return "tärning " + antalSidor;
	}
}

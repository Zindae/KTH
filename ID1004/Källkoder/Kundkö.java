import java.util.*;
public class Kundk� implements H�ndelsehanterare {
	
	private int maxAntalKunder;
	
	private Simulering sim;
	
	Queue<Kund> kunder = new LinkedList<Kund>();
	
	public Kundk� (Simulering sim, int maxAntalKunder){
		this.sim = sim;
		this.maxAntalKunder = maxAntalKunder;
	}
	
	public Kund h�mtaKund() {
		return kunder.remove();
	}
	
	public void h�ndelse(SimH�ndelse h){}
	
	public boolean nyKund(Kund kunden) {
		if (kunder.size() < maxAntalKunder) {
			kunder.add(kunden);
			return true;
		}
		return false;
	}
	
	public boolean isEmpty () {
		return kunder.isEmpty();
	}
	
	public int size() {
		return kunder.size();
	}
}

import java.util.*;
public class Kundkö implements Händelsehanterare {
	
	private int maxAntalKunder;
	
	private Simulering sim;
	
	Queue<Kund> kunder = new LinkedList<Kund>();
	
	public Kundkö (Simulering sim, int maxAntalKunder){
		this.sim = sim;
		this.maxAntalKunder = maxAntalKunder;
	}
	
	public Kund hämtaKund() {
		return kunder.remove();
	}
	
	public void händelse(SimHändelse h){}
	
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

import java.util.*;



public class Simtest {
	
	public static void simuleraEnGång(Simulering sim){
		sim.körSimulering();
	}
	
	public static double medelväntetid(Simulering sim){
		return (double) sim.ackumuleradVäntetid / sim.antalVäntetider;
	}
	
	public static void visaResultat(Simulering sim) {
		System.out.printf("Simulerad tid %d timmar, %d min%n", 
				sim.getSimklocka() / 60, sim.getSimklocka() % 60);
		System.out.println("Antal kunder som kom: " + sim.antalKunderSomKom);
		System.out.println("Antal kunder som vände: " + sim.antalKunderSomVände);
		int betjänade = sim.antalKunderSomKom - sim.antalKunderSomVände;
		System.out.println("Antal betjänade kunder: " + betjänade);
		System.out.printf("%s %6.2f%n", "Betjänade per timme: ", (60d * betjänade / sim.getSimklocka()));
		System.out.printf("%s %6.2f minuter%n", "Genomsnittlig väntetid per kund: ", 
				medelväntetid(sim));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulering sim = new Simulering();
		simuleraEnGång(sim);
		visaResultat(sim);
		
		Hashtable<Integer,Integer> stab = new Hashtable<Integer,Integer>();
		for (int i = 0; i < 500; i++){
			sim = new Simulering();
			simuleraEnGång(sim);
			int fq = (int) Math.round(medelväntetid(sim));
			Integer fqI = fq;
			if (stab.containsKey(fqI)) {
				stab.put(fqI, stab.get(fqI) + 1);
			}
			else {
				stab.put(fqI, 1);
			}
		}
		TreeSet<Integer> keySet = new TreeSet<Integer>(stab.keySet());
		
		for (Integer i : keySet) {
			int fq = stab.get(i);
			System.out.printf("%3d : %3d ", i, fq);
			for(int c = 0; c < fq; c++){
				System.out.print("X");
			}
			System.out.println();
		}
		
	}

}

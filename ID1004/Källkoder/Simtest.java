import java.util.*;



public class Simtest {
	
	public static void simuleraEnG�ng(Simulering sim){
		sim.k�rSimulering();
	}
	
	public static double medelv�ntetid(Simulering sim){
		return (double) sim.ackumuleradV�ntetid / sim.antalV�ntetider;
	}
	
	public static void visaResultat(Simulering sim) {
		System.out.printf("Simulerad tid %d timmar, %d min%n", 
				sim.getSimklocka() / 60, sim.getSimklocka() % 60);
		System.out.println("Antal kunder som kom: " + sim.antalKunderSomKom);
		System.out.println("Antal kunder som v�nde: " + sim.antalKunderSomV�nde);
		int betj�nade = sim.antalKunderSomKom - sim.antalKunderSomV�nde;
		System.out.println("Antal betj�nade kunder: " + betj�nade);
		System.out.printf("%s %6.2f%n", "Betj�nade per timme: ", (60d * betj�nade / sim.getSimklocka()));
		System.out.printf("%s %6.2f minuter%n", "Genomsnittlig v�ntetid per kund: ", 
				medelv�ntetid(sim));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulering sim = new Simulering();
		simuleraEnG�ng(sim);
		visaResultat(sim);
		
		Hashtable<Integer,Integer> stab = new Hashtable<Integer,Integer>();
		for (int i = 0; i < 500; i++){
			sim = new Simulering();
			simuleraEnG�ng(sim);
			int fq = (int) Math.round(medelv�ntetid(sim));
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

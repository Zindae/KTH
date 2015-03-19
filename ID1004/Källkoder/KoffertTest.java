
public class KoffertTest {
	public static void main(String args[]){
		// Skapa våra testbehållare
		Behållare vitAsk     = new Behållare (100,   80, "vit ask");
		Behållare blåAsk     = new Behållare (100,   80, "blå ask");
		Behållare grönAsk    = new Behållare (100,   80, "grön ask");
		Behållare ryggsäck   = new Behållare (500,  470, "ryggsäck");
		Behållare skokartong = new Behållare (200,  190, "skokartong");
		Behållare koffert    = new Behållare (1000, 980, "koffert");
		
		// Lägg askarna i ryggsäcken
		ryggsäck.add(vitAsk);
		ryggsäck.add(blåAsk);
		ryggsäck.add(grönAsk);
		// Lägg ryggsäcken i kofferten
		koffert.add(ryggsäck);
		// Lägg skokartongen i kofferten
		koffert.add(skokartong);
		// Skriv ut skokartongens innehåll
		System.out.println(koffert);
	}
}

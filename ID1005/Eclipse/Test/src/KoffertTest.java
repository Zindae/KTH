
public class KoffertTest {
	public static void main(String args[]){
		// Skapa våra testTest
		Test vitAsk     = new Test (100,   80, "vit ask");
		Test blåAsk     = new Test (100,   80, "blå ask");
		Test grönAsk    = new Test (100,   80, "grön ask");
		Test ryggsäck   = new Test (500,  470, "ryggsäck");
		Test skokartong = new Test (200,  190, "skokartong");
		Test koffert    = new Test (1000, 980, "koffert");
		
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

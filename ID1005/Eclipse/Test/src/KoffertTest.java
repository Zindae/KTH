
public class KoffertTest {
	public static void main(String args[]){
		// Skapa v�ra testTest
		Test vitAsk     = new Test (100,   80, "vit ask");
		Test bl�Ask     = new Test (100,   80, "bl� ask");
		Test gr�nAsk    = new Test (100,   80, "gr�n ask");
		Test ryggs�ck   = new Test (500,  470, "ryggs�ck");
		Test skokartong = new Test (200,  190, "skokartong");
		Test koffert    = new Test (1000, 980, "koffert");
		
		// L�gg askarna i ryggs�cken
		ryggs�ck.add(vitAsk);
		ryggs�ck.add(bl�Ask);
		ryggs�ck.add(gr�nAsk);
		// L�gg ryggs�cken i kofferten
		koffert.add(ryggs�ck);
		// L�gg skokartongen i kofferten
		koffert.add(skokartong);
		// Skriv ut skokartongens inneh�ll
		System.out.println(koffert);
	}
}

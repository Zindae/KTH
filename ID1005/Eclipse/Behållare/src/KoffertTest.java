
public class KoffertTest {

	public static void main(String[] args) {
		// Skapa v�ra Beh�llare
		Beh�llare vitAsk = new Beh�llare	 (100, 80, "vit ask");
		Beh�llare bl�Ask = new Beh�llare   	 (100, 80, "bl� ask");
		Beh�llare gr�nAsk = new Beh�llare	 (100, 80, "gr�n ask");
		Beh�llare ryggs�ck = new Beh�llare	 (400, 308, "ryggs�ck");
		Beh�llare skokartong = new Beh�llare (500, 190, "skokartong");
		Beh�llare koffert = new Beh�llare	 (6000, 980, "kofertt");
		
		//L�gg askarna i ryggs�cken
		ryggs�ck.add(vitAsk);
		ryggs�ck.add(bl�Ask);
		ryggs�ck.add(gr�nAsk);
		//L�gg ryggs�cken i kofferten
		koffert.add(ryggs�ck);
		//L�gg skokartongen i kofferten
		koffert.add(skokartong);
		//Skriv ut skokartongens inneh�ll
		System.out.println(koffert);
		

	}

}

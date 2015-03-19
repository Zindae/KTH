import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Klass Simulering skapar och styr simuleringen genom att generera kundkö, kassor
 * och kunder. Det finns även en händelsekö för den tidsdiskreta simuleringen.
 * Klassen ger också tillgång till servicemetoder för andra objekt i simuleringen.
 * @author fki
 *
 */
public class Simulering implements Händelsehanterare {
	
	/**
	 * Händelsekö är en kö av SimHändelse. SimHändelse implementerar interface
	 * Comparable så att SimHändelsens tidpunkt används för att ordna instanserna
	 * i händelsekön så att nästa händelse (lägsta tidpunkt) alltid ligger först
	 * och därmed hämtas först.
	 */
	PriorityQueue<SimHändelse> händelsekö = new PriorityQueue<SimHändelse>();

	/**
	 * allaKassor är en lista över alla kassor som skapats.
	 */
	ArrayList<Kassa> allaKassor = new ArrayList<Kassa>();
	
	/**
	 * ledigaKassor är en lista över de kassor som för tillfället är lediga.
	 */
	ArrayList<Kassa> ledigaKassor = new ArrayList<Kassa>();
	
	/**
	 * Kundkön innehåller kunder som väntar på en ledig kassa.
	 * Kön fylls på när en ny kund anländer och ingen kassa är ledig,
	 * och tappas av när en kassa blir ledig. 
	 */
	Kundkö kundkön = new Kundkö(this, 12);
	
	/**
	 * Den simulerade klockan, i minuter. Klockan flyttas fram när nästa
	 * händelse dras från händelsekön.
	 */
	private long simklocka = 0;
	
	/**
	 * Parameter till simuleringen: antal öppna kassor.
	 */
	int antalKassor = 2;
	/**
	 * Parameter till simuleringen: det antal simulerade minuter som
	 * simuleringen skall pågå.
	 */
	long minuterAttSimulera = 240;

	/**
	 * Parameter till simuleringen: det minsta antalet minuter mellan två
	 * anländande kunder.
	 */	
	int nästaKundOmMinst = 1;
	
	/**
	 * Parameter till simuleringen: det högsta antalet minuter mellan två
	 * anländande kunder.
	 */	
	int nästaKundOmMest = 10;

	/**
	 * Räknare: det antal kunder som vände i dörren eftersom kön var full.
	 */
	int antalKunderSomVände = 0;
	
	/**
	 * Räknare: det antal kunder som kom till kontoret.
	 */
	int antalKunderSomKom = 0;

	/**
	 * Räknare: den ackumulerade tid som alla betjänade kunder fått vänta
	 * i kön.
	 */
	int ackumuleradVäntetid = 0;

	/**
	 * Räknare: antalet ackumulerade väntetider (för medelvärdesberäkning).
	 */
	int antalVäntetider = 0;
	
	/**
	 * Flagga för spårutskriftsmetoden simtext. Sätt till true för att aktivera
	 * spårutskifter.
	 */
	boolean aktiveraSimtext = false;
	
	/**
	 * Returnerar tidpunkten för nästa kunds ankomst till växlingskontoret.
	 * @return
	 */
	protected long nästaKundKommer() {
		return
			simklocka + nästaKundOmMinst + 
			(int) (Math.random() * (1 + nästaKundOmMest - nästaKundOmMinst));
	}
	
	/**
	 * Skapar en ny simulering genom att lägga till kassor, göra dem lediga
	 * och schemalägga första kundens ankomst.	
	 */
	public Simulering() {
		for (int i = 0; i < antalKassor; i++){
			allaKassor.add(new Kassa(this));
		}
		ledigaKassor.addAll(allaKassor);
		schemalägg(new SimHändelse(nästaKundKommer(), this, null));
	}
	
	/**
	 * Servicemetod för spårutskrifter. Den bifogade parametern skrivs ut på
	 * System.out med simklockan, text och newline.
	 * @param txt Spårtexten som skall skrivas ut.
	 */
	public void simtext(String txt){
		if (aktiveraSimtext) {
			System.out.printf("%4d: %s%n", simklocka, txt);
		}
	}
	
	/**
	 * Denna metod anropas via händelsekön när det är dags för nästa kund
	 * att anlända till kontoret.
	 */
	public void händelse(SimHändelse h){
		// Skapa en ny kund och räkna upp räknaren.
		antalKunderSomKom++;
		Kund k = new Kund(simklocka);
		// Se om det finns en ledig kassa
		if (ledigaKassor.isEmpty()) {
			// Ingen ledig kassa, finns det plats i kön?
			if (kundkön.nyKund(k)) {
				simtext("en ny kund ställer sig i kön (" + kundkön.size() + ")");
			}
			else {
				antalKunderSomVände++;
				simtext("en ny kund vänder i dörren");
			}
		}
		else {
			// Ta en ledig kassa och skicka kunden dit.
			Kassa ledigKassa = ledigaKassor.remove(0);
			ledigKassa.taEmotKund(k);
		}
		// Planera när nästa kund kommer.
		schemalägg(new SimHändelse(nästaKundKommer(), this, null));
	}
	
	/**
	 * Lägger till en händelse till händelsekön
	 * @param h Den kommande händelsen.
	 */
	public void schemalägg(SimHändelse h){
		händelsekö.add(h);
	}
	
	/**
	 * Returnerar den klockan i simulerade minuter
	 * @return
	 */
	public long getSimklocka() {
		return simklocka;
	}
	
	/**
	 * Servicemetod för kassor när de blir lediga. Om en kund väntar i kön
	 * tas en kund därifrån till kassan, annars läggs kassan i listan över
	 * lediga kassor.
	 * @param kassa Den lediga kassan.
	 */
	public void ledigKassa(Kassa kassa){
		if (kundkön.isEmpty()) {
			ledigaKassor.add(kassa);
		}
		else {
			kassa.taEmotKund(kundkön.hämtaKund());
		}
	}
	
	/**
	 * Denna metod tar hand om kundens upplevda väntetid och lägger till
	 * observationen i ackumulerad väntetid och antalet observerade
	 * väntertide.
	 * @param k Kunden som är klar.
	 */
	public void noteraVäntetid(Kund k){
		ackumuleradVäntetid += simklocka - k.ankomsttid;
		antalVäntetider++;
	}
	
	/**
	 * Denna metod kör simuleringen genom att dra nästa händelse från
	 * händelsekön. Den simulerade klockan uppdateras med tiden för händelsen.
	 * Därefter skickas händelsen till sin mottagare.
	 * Metoden återvänder om klockan överstiger tidsgränsen för simuleringen,
	 * eller om händelsekön är tom.
	 */
	public void körSimulering() {
		while (!händelsekö.isEmpty()){
			SimHändelse h = händelsekö.remove();
			simklocka = h.getTidpunkt();
			h.getMottagare().händelse(h);
			if (minuterAttSimulera < simklocka) break;
		}
	}
}

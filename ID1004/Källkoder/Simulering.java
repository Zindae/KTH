import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Klass Simulering skapar och styr simuleringen genom att generera kundk�, kassor
 * och kunder. Det finns �ven en h�ndelsek� f�r den tidsdiskreta simuleringen.
 * Klassen ger ocks� tillg�ng till servicemetoder f�r andra objekt i simuleringen.
 * @author fki
 *
 */
public class Simulering implements H�ndelsehanterare {
	
	/**
	 * H�ndelsek� �r en k� av SimH�ndelse. SimH�ndelse implementerar interface
	 * Comparable s� att SimH�ndelsens tidpunkt anv�nds f�r att ordna instanserna
	 * i h�ndelsek�n s� att n�sta h�ndelse (l�gsta tidpunkt) alltid ligger f�rst
	 * och d�rmed h�mtas f�rst.
	 */
	PriorityQueue<SimH�ndelse> h�ndelsek� = new PriorityQueue<SimH�ndelse>();

	/**
	 * allaKassor �r en lista �ver alla kassor som skapats.
	 */
	ArrayList<Kassa> allaKassor = new ArrayList<Kassa>();
	
	/**
	 * ledigaKassor �r en lista �ver de kassor som f�r tillf�llet �r lediga.
	 */
	ArrayList<Kassa> ledigaKassor = new ArrayList<Kassa>();
	
	/**
	 * Kundk�n inneh�ller kunder som v�ntar p� en ledig kassa.
	 * K�n fylls p� n�r en ny kund anl�nder och ingen kassa �r ledig,
	 * och tappas av n�r en kassa blir ledig. 
	 */
	Kundk� kundk�n = new Kundk�(this, 12);
	
	/**
	 * Den simulerade klockan, i minuter. Klockan flyttas fram n�r n�sta
	 * h�ndelse dras fr�n h�ndelsek�n.
	 */
	private long simklocka = 0;
	
	/**
	 * Parameter till simuleringen: antal �ppna kassor.
	 */
	int antalKassor = 2;
	/**
	 * Parameter till simuleringen: det antal simulerade minuter som
	 * simuleringen skall p�g�.
	 */
	long minuterAttSimulera = 240;

	/**
	 * Parameter till simuleringen: det minsta antalet minuter mellan tv�
	 * anl�ndande kunder.
	 */	
	int n�staKundOmMinst = 1;
	
	/**
	 * Parameter till simuleringen: det h�gsta antalet minuter mellan tv�
	 * anl�ndande kunder.
	 */	
	int n�staKundOmMest = 10;

	/**
	 * R�knare: det antal kunder som v�nde i d�rren eftersom k�n var full.
	 */
	int antalKunderSomV�nde = 0;
	
	/**
	 * R�knare: det antal kunder som kom till kontoret.
	 */
	int antalKunderSomKom = 0;

	/**
	 * R�knare: den ackumulerade tid som alla betj�nade kunder f�tt v�nta
	 * i k�n.
	 */
	int ackumuleradV�ntetid = 0;

	/**
	 * R�knare: antalet ackumulerade v�ntetider (f�r medelv�rdesber�kning).
	 */
	int antalV�ntetider = 0;
	
	/**
	 * Flagga f�r sp�rutskriftsmetoden simtext. S�tt till true f�r att aktivera
	 * sp�rutskifter.
	 */
	boolean aktiveraSimtext = false;
	
	/**
	 * Returnerar tidpunkten f�r n�sta kunds ankomst till v�xlingskontoret.
	 * @return
	 */
	protected long n�staKundKommer() {
		return
			simklocka + n�staKundOmMinst + 
			(int) (Math.random() * (1 + n�staKundOmMest - n�staKundOmMinst));
	}
	
	/**
	 * Skapar en ny simulering genom att l�gga till kassor, g�ra dem lediga
	 * och schemal�gga f�rsta kundens ankomst.	
	 */
	public Simulering() {
		for (int i = 0; i < antalKassor; i++){
			allaKassor.add(new Kassa(this));
		}
		ledigaKassor.addAll(allaKassor);
		schemal�gg(new SimH�ndelse(n�staKundKommer(), this, null));
	}
	
	/**
	 * Servicemetod f�r sp�rutskrifter. Den bifogade parametern skrivs ut p�
	 * System.out med simklockan, text och newline.
	 * @param txt Sp�rtexten som skall skrivas ut.
	 */
	public void simtext(String txt){
		if (aktiveraSimtext) {
			System.out.printf("%4d: %s%n", simklocka, txt);
		}
	}
	
	/**
	 * Denna metod anropas via h�ndelsek�n n�r det �r dags f�r n�sta kund
	 * att anl�nda till kontoret.
	 */
	public void h�ndelse(SimH�ndelse h){
		// Skapa en ny kund och r�kna upp r�knaren.
		antalKunderSomKom++;
		Kund k = new Kund(simklocka);
		// Se om det finns en ledig kassa
		if (ledigaKassor.isEmpty()) {
			// Ingen ledig kassa, finns det plats i k�n?
			if (kundk�n.nyKund(k)) {
				simtext("en ny kund st�ller sig i k�n (" + kundk�n.size() + ")");
			}
			else {
				antalKunderSomV�nde++;
				simtext("en ny kund v�nder i d�rren");
			}
		}
		else {
			// Ta en ledig kassa och skicka kunden dit.
			Kassa ledigKassa = ledigaKassor.remove(0);
			ledigKassa.taEmotKund(k);
		}
		// Planera n�r n�sta kund kommer.
		schemal�gg(new SimH�ndelse(n�staKundKommer(), this, null));
	}
	
	/**
	 * L�gger till en h�ndelse till h�ndelsek�n
	 * @param h Den kommande h�ndelsen.
	 */
	public void schemal�gg(SimH�ndelse h){
		h�ndelsek�.add(h);
	}
	
	/**
	 * Returnerar den klockan i simulerade minuter
	 * @return
	 */
	public long getSimklocka() {
		return simklocka;
	}
	
	/**
	 * Servicemetod f�r kassor n�r de blir lediga. Om en kund v�ntar i k�n
	 * tas en kund d�rifr�n till kassan, annars l�ggs kassan i listan �ver
	 * lediga kassor.
	 * @param kassa Den lediga kassan.
	 */
	public void ledigKassa(Kassa kassa){
		if (kundk�n.isEmpty()) {
			ledigaKassor.add(kassa);
		}
		else {
			kassa.taEmotKund(kundk�n.h�mtaKund());
		}
	}
	
	/**
	 * Denna metod tar hand om kundens upplevda v�ntetid och l�gger till
	 * observationen i ackumulerad v�ntetid och antalet observerade
	 * v�ntertide.
	 * @param k Kunden som �r klar.
	 */
	public void noteraV�ntetid(Kund k){
		ackumuleradV�ntetid += simklocka - k.ankomsttid;
		antalV�ntetider++;
	}
	
	/**
	 * Denna metod k�r simuleringen genom att dra n�sta h�ndelse fr�n
	 * h�ndelsek�n. Den simulerade klockan uppdateras med tiden f�r h�ndelsen.
	 * D�refter skickas h�ndelsen till sin mottagare.
	 * Metoden �terv�nder om klockan �verstiger tidsgr�nsen f�r simuleringen,
	 * eller om h�ndelsek�n �r tom.
	 */
	public void k�rSimulering() {
		while (!h�ndelsek�.isEmpty()){
			SimH�ndelse h = h�ndelsek�.remove();
			simklocka = h.getTidpunkt();
			h.getMottagare().h�ndelse(h);
			if (minuterAttSimulera < simklocka) break;
		}
	}
}

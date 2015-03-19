import java.util.*;
public class GissaTalet {

	private static final int MAX_NUMBER = 100; 
	private static final int MIN_NUMBER = 10;
	private static final int MAX_GUESS = 10;
	
	Random slump = new Random();
	
	public int Slumptal() { 
		
		int hemligt = slump.nextInt(100); //Slumpa Tal som max är 100
		return hemligt; //returnera talet
	}
	
	public void Gissningar() { //En array som innehåller spelarens gissningar.
		int [] Gissningar = new int [MAX_GUESS];	
	}
	//private static nollställa() {
		
	//}
	
	public void kör()  {
		Slumptal();
		int hemligt = Slumptal();
		System.out.println("Slumptal:" + hemligt);
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GissaTalet start = new GissaTalet();
		start.kör();
	}

}

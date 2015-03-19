
public class ArgCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  int counter = 0;
			    for (String s : args) { //loop med stringen s och args - Går att användas tll tabeller
			    	
			    	// Skriv kod här för att inkrementera counter med ett.
					counter = counter + 1;
					// Här stoppar du in kod för att skriva ut counters värde.
					System.out.print(counter);
					// Här kod för att skriva ut en avskiljare, t ex " : " .
					System.out.print(" ");
					//Här kod för att skriva ut innehållet i variabeln s.
					System.out.print(s);
					//Här kod för att avsluta raden (newline).
					System.out.println(); //för varje paramter.
					
					System.out.println(++counter + " " + s); //Öka på med ett innan det skriver ut värdet.
					
			
			   
			    }
			}
}

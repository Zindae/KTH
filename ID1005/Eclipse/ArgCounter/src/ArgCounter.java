
public class ArgCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  int counter = 0;
			    for (String s : args) { //loop med stringen s och args - G�r att anv�ndas tll tabeller
			    	
			    	// Skriv kod h�r f�r att inkrementera counter med ett.
					counter = counter + 1;
					// H�r stoppar du in kod f�r att skriva ut counters v�rde.
					System.out.print(counter);
					// H�r kod f�r att skriva ut en avskiljare, t ex " : " .
					System.out.print(" ");
					//H�r kod f�r att skriva ut inneh�llet i variabeln s.
					System.out.print(s);
					//H�r kod f�r att avsluta raden (newline).
					System.out.println(); //f�r varje paramter.
					
					System.out.println(++counter + " " + s); //�ka p� med ett innan det skriver ut v�rdet.
					
			
			   
			    }
			}
}

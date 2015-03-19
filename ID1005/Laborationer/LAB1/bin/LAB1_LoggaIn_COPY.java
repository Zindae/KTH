	/*LABB 1. Metoder och klassbibliotek. PROGRAM 2: LAB1_LoggaIn_COPY.java.
	 *  Innefattar:
	 *
	 *   - Ett program best�ende av flera metoder
	 *   - F�rdelade metoder mellan olika klasser
	 *   - Returtyper i olika metoder
	 *
	 * I detta program ska man logga in genom att skriva r�tt l�senord och anv�ndarnamn*/

    //package gjava.edu;
    import gjava.edu.*;

	import java.util.Scanner; //importerar skannern

	public class LAB1_LoggaIn_COPY {

		public static void main(String[] args)
		{
			Scanner input = new Scanner(System.in);
			Klass_2_COPY Objekt = new Klass_2_COPY(); //Objekt sparar inmatningarna s� att de anv�nds i Klass_2_COPY

			System.out.println("----------------------------LOGGA IN-------------------------------------------\n");

			System.out.println("Skriv anv�ndarnamnet: ");

			String user = input.nextLine(); //sparar inmatningen i str�ngen user

			System.out.println("Skriv l�senordet: ");

			String answer = input.nextLine(); //sparar inmatningen i str�ngen answer

			Objekt.setName(user);
			Objekt.setPass(answer);
			Objekt.svar(); //metoderna setName, setPass och svar anropas fr�n Klass_2_COPY

			System.out.println("\n-------------------------------------------------------------------------------");
		}
	}



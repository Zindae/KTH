	/*LABB 1. Metoder och klassbibliotek. PROGRAM 2: LAB1_LoggaIn_COPY.java.
	 *  Innefattar:
	 *
	 *   - Ett program bestående av flera metoder
	 *   - Fördelade metoder mellan olika klasser
	 *   - Returtyper i olika metoder
	 *
	 * I detta program ska man logga in genom att skriva rätt lösenord och användarnamn*/

    //package gjava.edu;
    import gjava.edu.*;

	import java.util.Scanner; //importerar skannern

	public class LAB1_LoggaIn_COPY {

		public static void main(String[] args)
		{
			Scanner input = new Scanner(System.in);
			Klass_2_COPY Objekt = new Klass_2_COPY(); //Objekt sparar inmatningarna så att de används i Klass_2_COPY

			System.out.println("----------------------------LOGGA IN-------------------------------------------\n");

			System.out.println("Skriv användarnamnet: ");

			String user = input.nextLine(); //sparar inmatningen i strängen user

			System.out.println("Skriv lösenordet: ");

			String answer = input.nextLine(); //sparar inmatningen i strängen answer

			Objekt.setName(user);
			Objekt.setPass(answer);
			Objekt.svar(); //metoderna setName, setPass och svar anropas från Klass_2_COPY

			System.out.println("\n-------------------------------------------------------------------------------");
		}
	}



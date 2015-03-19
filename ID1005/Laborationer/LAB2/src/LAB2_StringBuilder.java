/*LABB 2. PROGRAM 4: LAB1_Stringbuilder.java.
 * 
 *  Innefattar:
 *
 *   - Skapa och använd objekt av olika standardklasser (Scanner, Integer)
 *   
 * 
 * I detta program demonstreras olika strängar som ändras med stringbuilder */

import static java.lang.System.out;

public class LAB2_StringBuilder 
{
	
	public static void main(String[] args)
	{
		java.util.Scanner read = new java.util.Scanner (System.in);
		
		out.println("----------------------------PROGRAM: StringBuilder------------------------------------\n\nSkriv mening ett: ");
		
		String a  = read.nextLine();
						
		StringBuilder s1 = new StringBuilder(a);
		//string a spraras till Stringbuilder s1
		
		out.println("\nMening ett: " + s1 + "\n");
		out.println("Skriv mening två: ");
		
		String b = read.nextLine();
		StringBuilder s2 = new StringBuilder(b);
		//string b spraras till Stringbuilder s2
		
		out.println("\nMening två: " + s2);
		
		s1.append(s2);
		//string s1 utökas med s3
		
		out.println("\nMeningarna sammansatta: \n" + s1);
				
		out.println("\nSkriv mening tre: ");
				
		String c = read.nextLine();
		StringBuilder s3 = new StringBuilder(c);
		//string c spraras till Stringbuilder s3
		
		out.println("\nMening tre: " + s3);
				
		s1.append(s3);
		//string s1 utökas med s3
		
		out.println("\nSlutlig mening: \n" + s1 + "\n");
		
		System.out.println("Vad vill du göra med din mening?\nSKRIV:\n\n" +
				"B: Meningen baklänges\n" +
				"L: Visar längden av meningen\n" +
				"K: Kapaciteten av meningen\n" +
				"C: Bokstaven på ett index\n" +
				"R: Raderar ett index");
		
		String svar = read.nextLine();
		
		System.out.println("\n----------------------------RESULTAT-------------------------------------------\nDu svarade: "+svar);
		
		if(svar.equals("B"))
		{
			out.print("Meningen baklänges: " + s1.reverse()); 
			//reverse kastar om s1 
		}
		if(svar.equals("L"))
		{
			out.print("Meningens längd: " + s1.length()); 
			//length visar längden av s1 
		}
		if(svar.equals("K"))
		{
			out.print("Meningens kapacitet: " + s1.capacity()); 
			//capacity visar kapasiteten av s1 
		}
		if(svar.equals("C"))
		{
			out.print("Vilket index vill du veta? ");
			int index = read.nextInt();
			out.print("Bokstaven på index " + index + " är: " + s1.charAt(index -1));
			//charAt visar elementet på indexet -1 (eftersom vektorn börjar på 0) 
		}
		
		if(svar.equals("R"))
		{
			out.println("Vilket index vill du ta bort? "); 
			int radera = read.nextInt();
			out.println("Du raderar bokstaven på index " + radera + "\n" + "Svar: " + s1.deleteCharAt(radera));
			//deleteChatAt tar bort elemetet på indexet 'radera'
		}
		
			    
							
	}

}

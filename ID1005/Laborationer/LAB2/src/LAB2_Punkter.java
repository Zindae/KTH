/*LABB 2. PROGRAM 3: LAB1_Raknare.java.

 *  Innefattar:
 *
 *   - Skapa och använd objekt av olika standardklasser (String, Scanner, Integer, Double)
 *   -Objekt och vektorer med objekt som parametrar och returtyper i olika metoder
 * 
 * 
 * I detta program demonstreras olika punkter som visas */

import java.util.*;

public class LAB2_Punkter
{

	public static void main(String[] args)
	{
		
		System.out.println("--------------------------PROGRAM: Punkter-------------------------------------\n");
				
		java.util.Scanner read = new java.util.Scanner (System.in);
		
		System.out.println("Skriv den första punkten:");
		
		int a = read.nextInt();
		int b = read.nextInt();
		
		System.out.println("Skriv den andra punkten:");

		int c = read.nextInt();
		int e = read.nextInt();
		
		Punkt  p1 = new Punkt (a,b);
		Punkt  p2 = new Punkt (c,e);
		Punkt  p3 = new Punkt ();
		//definerar tre punkter
				
        double d1 = p1.avstand();
        double d2 = p2.avstand();
        // avståndet till origo räknas i metoden avstand
		
        double d = p1.avstand(p2);
        //avståndet mellan punkterna
		
		System.out.println("Vad vill du göra med dina punkter (" + a + "," + b + ") och (" + c + "," + e + ")?\n\n 1: Avstånd till Origo\n 2: Avstånd mellan punkterna\n 3: Visa punkterna\n");
		
		int svaret = read.nextInt();
						
		System.out.println("----------------------RESULTAT-----------------------------");

		
		if(svaret == 1)
		
		{		
			System.out.println("Avstånd till origo: ");
			System.out.println(d1);
			System.out.println(d2+"\n");
			//printar avståndet till origo
		}
		else
		{
		if(svaret == 2)
		{
			System.out.println("Avståndet mellan punkterna: ");
			System.out.println(d);
		} 
		else
		{
		if(svaret == 3)
		{
			System.out.println("\nPunkterna: ");
			System.out.println(p1);
			System.out.println(p2);
			//metoden toString anropas automatiskt (p1.toString()); behövs ej skrivas ut
		}
		else
		{
			System.out.println("ERROR - Du skrev inga av alternativen!");
		}
		
		}
		
	}
  }
}

		
		
		
		
		
			
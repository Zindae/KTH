/*LABB 2. PROGRAM 1: LAB1_Dice.java.

 *  Innefattar:
 *
 *   - Skapande och användning av objekt av olika standardklasser (Scanner, Integer)
 *    -Vektorer med objekt som parametrar och returtyper
 * 
 * 
 * I detta program demonstreras tärningskast och dess utfall */

import java.util.Random;
import java.util.Scanner;

public class LAB2_Dice 
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		
		Random dice = new Random();
		int frek[] = new int[7]; 
		// 7 element eftersom 0 räknas med i vektorn
		
		System.out.println("-------------------------PROGRAM: Tärningskast-------------------------------------------\n");
        System.out.println("Hur många gånger vill du rulla tärningen? ");
		
		int langd = read.nextInt();
		
		for(int roll = 1; roll < langd+1; roll++)
		{
			++frek[1+dice.nextInt(6)]; 
		// +1 ger 1-6 istället för 0-5. Varje gång ett värd slås adderas 1 till motsvarande index i vektorn frek som sprarar antal värden.
		}
		
		System.out.println("\nTärningen rullas " + langd + " gånger... ");
		System.out.println("----------------------------Resultat-------------------------------------------\n");
		System.out.println("Utfall\tAntal");
		
		for(int antal = 1; antal < frek.length; antal++)
		{
			System.out.println(antal + "\t " + frek[antal]);
		//for-loop som printar ut antal (6) samt värdet för dessa 6.	

		}
		
		
		
		
	}
	
}

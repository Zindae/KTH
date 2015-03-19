/*LABB 2. PROGRAM 1: LAB1_Dice.java.

 *  Innefattar:
 *
 *   - Skapande och anv�ndning av objekt av olika standardklasser (Scanner, Integer)
 *    -Vektorer med objekt som parametrar och returtyper
 * 
 * 
 * I detta program demonstreras t�rningskast och dess utfall */

import java.util.Random;
import java.util.Scanner;

public class LAB2_Dice 
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		
		Random dice = new Random();
		int frek[] = new int[7]; 
		// 7 element eftersom 0 r�knas med i vektorn
		
		System.out.println("-------------------------PROGRAM: T�rningskast-------------------------------------------\n");
        System.out.println("Hur m�nga g�nger vill du rulla t�rningen? ");
		
		int langd = read.nextInt();
		
		for(int roll = 1; roll < langd+1; roll++)
		{
			++frek[1+dice.nextInt(6)]; 
		// +1 ger 1-6 ist�llet f�r 0-5. Varje g�ng ett v�rd sl�s adderas 1 till motsvarande index i vektorn frek som sprarar antal v�rden.
		}
		
		System.out.println("\nT�rningen rullas " + langd + " g�nger... ");
		System.out.println("----------------------------Resultat-------------------------------------------\n");
		System.out.println("Utfall\tAntal");
		
		for(int antal = 1; antal < frek.length; antal++)
		{
			System.out.println(antal + "\t " + frek[antal]);
		//for-loop som printar ut antal (6) samt v�rdet f�r dessa 6.	

		}
		
		
		
		
	}
	
}

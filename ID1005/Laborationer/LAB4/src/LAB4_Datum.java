/*LABB 4. PROGRAM 1: LAB4_Datum.java
 *
 *  Innefattar:
 *
 *   -  Flera objekt och konstruktorer med referenser till andra objekt
 *   -  this, toString
 *    
 * I detta program demonstreras ens f�delsedatum m.h.a toString och olika objekt */

import static java.lang.System.out;

import java.util.*;

public class LAB4_Datum
{
	public static void main (String[] args)
	{
		
		Scanner read = new Scanner(System.in);
	
		System.out.println("---------------------PROGRAM: Datum--------------------------------\n");
		
		System.out.println("Hur gammal �r du?");
		int a = read.nextInt();
		
		System.out.println("Vilken m�nad f�ddes du (m�nadsdatum)?");
		int b = read.nextInt();
			
		System.out.println("Vilket datum i m�naden f�ddes du?");
		int c = read.nextInt();
		
		int �r = 2012 - a;
        			
		LAB4_Datum_KLASS2 objekt = new LAB4_Datum_KLASS2(�r,b,c);
		//anv�nder v�rderna inom parantesen i konstruktorn i KLASS2
		
	}
}
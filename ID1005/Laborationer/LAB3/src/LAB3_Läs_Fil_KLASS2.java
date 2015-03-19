//Klass 2 i LAB3_Läs_Fil_KLASS2

import java.util.*;
import java.io.*;

public class LAB3_Läs_Fil_KLASS2 
{
	private Scanner x;
	private Scanner read = new Scanner (System.in);
	//Scanner 'read' läser från tangentbordet, 'x' läser från fil
	
	public void openFile()
	{
		try
		{
			System.out.println("-----------------------------PROGRAM: Läs Fil----------------------------------\n");
			
			System.out.println("Skriv namnet på filen du vill öppna, avsluta med .txt");
			
			String svar = read.nextLine();
			//Scannern read läser från tangentbordet
			
			x = new Scanner(new File(svar)); 
			//Scannern x läser nu data från textfilen istället för tangentbordet
			
		}
		catch(Exception e) //catch om try inte fungerar
		{
			System.out.println("ERROR - Kunde inte hitta filen");
		}
		
	}
	
	public void readFile()
	{
		System.out.println("\n---------------------------Innehållet i filen----------------------------------");
		
		while(x.hasNext())
		//hasNext är en inbyggd funktion som loopar innehåller och läser hela filen
		{
			String l = x.next();
			//detta är varje sträng i filen 
			
			System.out.print(l + " ");
			//while-loopar igenom strängarna i filen och printar dessa
						
		}
	}
	
	public void closeFile() //stänger filen
	{
		x.close();
	}
		
	
}
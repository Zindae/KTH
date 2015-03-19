//Klass 2 i LAB3_L�s_Fil_KLASS2

import java.util.*;
import java.io.*;

public class LAB3_L�s_Fil_KLASS2 
{
	private Scanner x;
	private Scanner read = new Scanner (System.in);
	//Scanner 'read' l�ser fr�n tangentbordet, 'x' l�ser fr�n fil
	
	public void openFile()
	{
		try
		{
			System.out.println("-----------------------------PROGRAM: L�s Fil----------------------------------\n");
			
			System.out.println("Skriv namnet p� filen du vill �ppna, avsluta med .txt");
			
			String svar = read.nextLine();
			//Scannern read l�ser fr�n tangentbordet
			
			x = new Scanner(new File(svar)); 
			//Scannern x l�ser nu data fr�n textfilen ist�llet f�r tangentbordet
			
		}
		catch(Exception e) //catch om try inte fungerar
		{
			System.out.println("ERROR - Kunde inte hitta filen");
		}
		
	}
	
	public void readFile()
	{
		System.out.println("\n---------------------------Inneh�llet i filen----------------------------------");
		
		while(x.hasNext())
		//hasNext �r en inbyggd funktion som loopar inneh�ller och l�ser hela filen
		{
			String l = x.next();
			//detta �r varje str�ng i filen 
			
			System.out.print(l + " ");
			//while-loopar igenom str�ngarna i filen och printar dessa
						
		}
	}
	
	public void closeFile() //st�nger filen
	{
		x.close();
	}
		
	
}
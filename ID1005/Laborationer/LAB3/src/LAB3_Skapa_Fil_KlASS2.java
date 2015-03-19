//Klass 2 i LAB3_Skapa_Fil

import java.io.*;
import java.lang.*;
import java.util.*;

public class LAB3_Skapa_Fil_KlASS2
{
	java.util.Scanner read = new java.util.Scanner (System.in);
	
	private Formatter x;
	//håller variabeln x i formatter
	
	public void openFile()
	{
		try
		{
			System.out.println("---------------------PROGRAM: Skapa en Fil--------------------------------\n");
			
			System.out.println("Skriv namnet på filen du vill skapa, avsluta med .txt");
			String svar  = read.nextLine();
			
			System.out.println("--------------------------------------------------------------------------");
			
			x = new Formatter(svar);
			System.out.println("\nDu skapade en fil som heter '" + svar + "' på platsen C:/Users/Gabriel/Documents/Programmering/Java/Laborationer/src/LAB3\n");
			//Formatter skapar en fil med detta namn
		}
		
		catch(Exception e) //catch används om try inte fungerar 
		{
			System.out.println("Nått gick fel!");
		}
	
	}
	
	public void  addRecords() //lägger in denna data i filen
	{
		System.out.println("Vad vill du skriva i din fil?");
		String skrift = read.nextLine();
		
		x.format(skrift);
				
		System.out.println("\nRESULTAT: Data lagrad!");
	}
	
	public void closeFile() //stänger filen 
	{
		x.close(); 
		
	}

}

/*LABB 3. PROGRAM 1: LAB3_Skapa_Fil.java.

 *  Innefattar:
 *
 *   -  Standardinmatning och standardutmatning
 *   -  Skapandet av textfil
 * 
 * 
 * I detta program skapas en fil med valfritt namn och innehåll */

public class LAB3_Skapa_Fil 
{

	public static void main(String[] args)
	{
		LAB3_Skapa_Fil_KlASS2 g = new LAB3_Skapa_Fil_KlASS2();
		
		g.openFile();
		g.addRecords();
		g.closeFile();
		//metoderna från klass 2 
			
	}
}

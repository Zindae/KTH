/*LABB 3. PROGRAM 4: LAB3_R�knare_GUI

 *  Innefattar:
 *
 *   -  Standardinmatning och standardutmatning
 *   -  GUI
 *  
 * I detta program demonstreras en r�knare m.h.a GUI */

import javax.swing.JOptionPane; //importerar sakerna som beh�vs till GUI

public class LAB3_R�knare_GUI 
{
	public static void main (String[] args)
	{
		String s1 = JOptionPane.showInputDialog("Skriv nummer ett");
		String s2 = JOptionPane.showInputDialog("Skriv nummer tv�");
		//detta visar f�nster med kommandot och s�tter svaret till string
		
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2); 
		//konverterar str�ngen till int eftersom vi fr�gar efter nummer
		
		String svar1 = JOptionPane.showInputDialog("TRYCK:" +
				" \n A: Addera talen " +
				"\n S: Subtrahera talen \n M: Multiplicera talen " +
				"\n MAX: Hitta det st�rsta talet " +
				"\n MIN: Hitta det minsta talet " +
				"\n R1: Avrunda det f�sta talet" +
				" \n R2: Avrunda det andra talet" +
				" \n L1: Logaritmen av det f�sta talet " +
				"\n L2: Logaritmen av det andra talet " +
				"\n U1: F�rsta talet upph�jt i det andra " +
				"\n U2: Andra talet upph�jt i det f�rsta");
		
		
		if (svar1.equals("A")) //f�rsta argumentet �r noll, andra visar meddelandet i f�nstret, tredje f�nstertiteln, sista att det �r ett meddelandekommando
		{
			JOptionPane.showMessageDialog(null, "Talen adderade �r " + (num1+num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (svar1.equals("S"))
		{
			JOptionPane.showMessageDialog(null, "Talen subtraherade �r " + (num1-num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if (svar1.equals("M"))
		{
			JOptionPane.showMessageDialog(null, "Talen multiplicerade �r " + (num1*num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (svar1.equals("M"))
		{
			JOptionPane.showMessageDialog(null, "Talen multiplicerade �r " + (num1*num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}
		if (svar1.equals("MAX"))
		{
			JOptionPane.showMessageDialog(null, "Maxmimum talet �r " + Math.max(num1, num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

        if (svar1.equals("MIN"))
		{
        	JOptionPane.showMessageDialog(null, "Minimum talet �r " + Math.min(num1, num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
	    }

		if(svar1.equals("R1"))
		{
			JOptionPane.showMessageDialog(null, num1 + " avrundat �r " + Math.round(num1), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("R2"))
		{
			JOptionPane.showMessageDialog(null, num2 + " �r avrundat " + Math.round(num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("L1"))
		{
			JOptionPane.showMessageDialog(null, "log(" + num1 + ") �r " + Math.log(num1), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("L2"))
		{
			JOptionPane.showMessageDialog(null, "log(" + num2 + ") �r " + Math.log(num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("U1"))
		{
			JOptionPane.showMessageDialog(null, num1 + " upph�jt i " + num2 + " �r "  + Math.pow(num1,num2), "Resultat",JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("U2"))
		{
			JOptionPane.showMessageDialog(null, num2 + " upph�jt i " + num1 + " �r "  + Math.pow(num2,num1), "Resultat",JOptionPane.PLAIN_MESSAGE);
		}
	
		//visar upp meddelandet p� sk�rmen
		//f�rsta argumentet �r noll, andra visar svaret, tredje titeln, sista att det �r ett meddelande
	}
}

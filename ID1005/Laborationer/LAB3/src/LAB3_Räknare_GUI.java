/*LABB 3. PROGRAM 4: LAB3_Räknare_GUI

 *  Innefattar:
 *
 *   -  Standardinmatning och standardutmatning
 *   -  GUI
 *  
 * I detta program demonstreras en räknare m.h.a GUI */

import javax.swing.JOptionPane; //importerar sakerna som behövs till GUI

public class LAB3_Räknare_GUI 
{
	public static void main (String[] args)
	{
		String s1 = JOptionPane.showInputDialog("Skriv nummer ett");
		String s2 = JOptionPane.showInputDialog("Skriv nummer två");
		//detta visar fönster med kommandot och sätter svaret till string
		
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2); 
		//konverterar strängen till int eftersom vi frågar efter nummer
		
		String svar1 = JOptionPane.showInputDialog("TRYCK:" +
				" \n A: Addera talen " +
				"\n S: Subtrahera talen \n M: Multiplicera talen " +
				"\n MAX: Hitta det största talet " +
				"\n MIN: Hitta det minsta talet " +
				"\n R1: Avrunda det fösta talet" +
				" \n R2: Avrunda det andra talet" +
				" \n L1: Logaritmen av det fösta talet " +
				"\n L2: Logaritmen av det andra talet " +
				"\n U1: Första talet upphöjt i det andra " +
				"\n U2: Andra talet upphöjt i det första");
		
		
		if (svar1.equals("A")) //första argumentet är noll, andra visar meddelandet i fönstret, tredje fönstertiteln, sista att det är ett meddelandekommando
		{
			JOptionPane.showMessageDialog(null, "Talen adderade är " + (num1+num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (svar1.equals("S"))
		{
			JOptionPane.showMessageDialog(null, "Talen subtraherade är " + (num1-num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if (svar1.equals("M"))
		{
			JOptionPane.showMessageDialog(null, "Talen multiplicerade är " + (num1*num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}
		
		if (svar1.equals("M"))
		{
			JOptionPane.showMessageDialog(null, "Talen multiplicerade är " + (num1*num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}
		if (svar1.equals("MAX"))
		{
			JOptionPane.showMessageDialog(null, "Maxmimum talet är " + Math.max(num1, num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

        if (svar1.equals("MIN"))
		{
        	JOptionPane.showMessageDialog(null, "Minimum talet är " + Math.min(num1, num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
	    }

		if(svar1.equals("R1"))
		{
			JOptionPane.showMessageDialog(null, num1 + " avrundat är " + Math.round(num1), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("R2"))
		{
			JOptionPane.showMessageDialog(null, num2 + " är avrundat " + Math.round(num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("L1"))
		{
			JOptionPane.showMessageDialog(null, "log(" + num1 + ") är " + Math.log(num1), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("L2"))
		{
			JOptionPane.showMessageDialog(null, "log(" + num2 + ") är " + Math.log(num2), "Resultat", JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("U1"))
		{
			JOptionPane.showMessageDialog(null, num1 + " upphöjt i " + num2 + " är "  + Math.pow(num1,num2), "Resultat",JOptionPane.PLAIN_MESSAGE);
		}

		if(svar1.equals("U2"))
		{
			JOptionPane.showMessageDialog(null, num2 + " upphöjt i " + num1 + " är "  + Math.pow(num2,num1), "Resultat",JOptionPane.PLAIN_MESSAGE);
		}
	
		//visar upp meddelandet på skärmen
		//första argumentet är noll, andra visar svaret, tredje titeln, sista att det är ett meddelande
	}
}

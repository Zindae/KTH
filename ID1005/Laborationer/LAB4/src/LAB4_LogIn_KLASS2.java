import javax.swing.JOptionPane;

public class LAB4_LogIn_KLASS2
{
	private String fpass;
	private String fname; //private str�ngar eftersom dessabara anv�nds i denna klass

	public LAB4_LogIn_KLASS2(String user, String pass) //konstruktor 
	{
		fname = user;
		fpass = pass;
		
		svar(); //anropar metoden svar
	}

	public void svar() //metoden svar skriver ut resultatet beroende p� inmatningar
	{

		if (fpass.equals("Vilen") && fname.equals("Gabriel"))
		{
			JOptionPane.showMessageDialog(null, "V�lkommen " + fname + "! :)\nDitt l�senord �r: " + fpass, "Grattis!", JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Du skrev fel username (" + fname + ") eller l�senord (" + fpass + ") \nVar god f�rs�k igen.", "FEL", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
	
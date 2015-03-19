import javax.swing.JOptionPane;

public class LAB4_LogIn_KLASS2
{
	private String fpass;
	private String fname; //private strängar eftersom dessabara används i denna klass

	public LAB4_LogIn_KLASS2(String user, String pass) //konstruktor 
	{
		fname = user;
		fpass = pass;
		
		svar(); //anropar metoden svar
	}

	public void svar() //metoden svar skriver ut resultatet beroende på inmatningar
	{

		if (fpass.equals("Vilen") && fname.equals("Gabriel"))
		{
			JOptionPane.showMessageDialog(null, "Välkommen " + fname + "! :)\nDitt lösenord är: " + fpass, "Grattis!", JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Du skrev fel username (" + fname + ") eller lösenord (" + fpass + ") \nVar god försök igen.", "FEL", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
	
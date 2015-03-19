import java.util.*;
import javax.swing.JOptionPane;

public class LAB4_LogIn
{
	public static void main(String[] args)
	{
		
       	String user = JOptionPane.showInputDialog("Skriv användarnamnet: ");
		String pass = JOptionPane.showInputDialog("Skriv lösenordet: ");

		LAB4_LogIn_KLASS2 answer = new LAB4_LogIn_KLASS2(user, pass);
				
	}
}


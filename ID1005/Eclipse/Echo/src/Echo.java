import java.util.Scanner;

public class Echo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Skriv en liten text");
			
			String msg = scan.nextLine();
			
			System.out.println("Du skrev :" + msg);
			
			
	}

}

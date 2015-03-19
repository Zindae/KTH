import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

/**
 * The countries main launch class.
 */
public class Countries {
	// The countries data are stored here.
	private HashMap<String, Vector<String>> countriesData;
	/**
	 * Default constructor
	 */
	Countries() {
		countriesData = new HashMap<>();
	}
	/**
	 * Adds the data to the table.
	 * 
	 * @param name
	 */
	public void addData(String name) { // The file input stream
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(name);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			// The Buffered Reader.
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			try {
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					String linedata[] = strLine.split(", ");
					Vector<String> data = new Vector<>();
					for (int i = 1; i < linedata.length; i++) {
						data.add(linedata[i]);
					}
					// Add the data from the file to the HashMap
					countriesData.put(linedata[0], data);
				}
			} catch (IOException ex) {
				System.out.println("Error : File Can't read!");
			}
			try {
				// Close the input stream
				in.close();
			} catch (IOException ex) {
				System.out.println("Error : File not Opened!");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error : File not found!");
		}

	}
	/**
	 * Displays the Info of the given country.
	 * 
	 * @param name
	 */
	public void dispalyInfo(String name) { // Displays the data in the HashTable
		try {
			Vector<String> data = countriesData.get(name);
			System.out.println("\nDetails of the Country " + name + " : \n\t");
			for (int i = 0; i < data.size(); i++) {
				System.out.print(data.get(i) + "\t");
			}
			System.out.println("\n");
		} catch (Exception e) {
			System.out.println("Error : Country not found!");
		}
	}
	/**
	 * The Command line Interface Menu.
	 */
	public void Menu() {
		// The input reader for reading user input.
		Scanner in = new Scanner(System.in);

		int exit = -1;
		while (exit == -1) {
			System.out
					.print("\n\n\t\t--- Information About All Countries Of The World --- \n\n");
			System.out
					.print("\n\t1. Add new Data.\n\t2. Get Details of a Country.\n\t3. Exit\n\nWhat do you want : ");
			int choice = 0;
			try {
				choice = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Error : Invalid Input");
				continue;
			}
			if (choice == 1) {
				System.out
						.print("Enter the file name of the Countries details : ");
				String file = in.nextLine();
				this.addData(file);
			} else if (choice == 2) {
				System.out.print("Enter the Country Name : ");
				String name = in.nextLine();
				this.dispalyInfo(name);
			} else {
				exit = 0;
			}

		}
	}
	/**
	 * The Launch method for the application.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		Countries c = new Countries();
		//Display the menu.
		c.Menu();
	}

}

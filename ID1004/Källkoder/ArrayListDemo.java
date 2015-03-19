import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

	/**
	 * Our list with names. The <String> syntax informs the compiler
	 * that we want an ArrayList that will only contain elements of
	 * type String.
	 */
	private ArrayList<String> names = new ArrayList<String>();
	
	/**
	 * Lists all the names in the name list to System.out.
	 */
	private void listNames () {
		if (names.isEmpty()) {
			System.out.println("The list of names is empty");
		}
		else {
			for (String s : names) {
				System.out.println(s);
			}
		}
	}
	
	/**
	 * Adds the supplied name to the name list unless it is already
	 * in the list.
	 * @param name The name to add
	 */
	private void maybeAddName (String name) {
		if (-1 < names.indexOf(name)) {
			System.out.println(name + " already exists");
		}
		else {
			names.add(name);
			System.out.println(name + " added");
		}
	}
	
	/**
	 * Removes the supplied name from the list if it is found.
	 * @param name The name to remove
	 */
	private void removeName (String name) {
		int i = names.indexOf(name);
		if (-1 < i) {
			names.remove(i);
			System.out.println(name + " removed");
		}
		else {
			System.out.println(name + " was not found in the list");
		}
	}
	
	/**
	 * Strings with text to be printed by the help command.
	 */
	private String [] helpText = {
		"Your commands:",
		"list          - prints the names in the list",
		"add <name>    - adds a new name to the list",
		"remove <name> - remove a name from the list",
		"quit          - exits the command interpreter"
	};
	
	/**
	 * Prints a short help text on System.out.
	 */
	private void printHelp () {
		for (String s : helpText) {
			System.out.println(s);
		}
	}
	
	/**
	 * Attempts to retrieve the argument after a command and return that.
	 * @param s The command line.
	 * @param what A text describing what was expected after the command word
	 * @return The text after the command word
	 */
	private String getArgument(String s, String what) {
		String [] sa = s.split("\\s", 2);
		if (1 < sa.length) {
			return sa[1];
		}
		else {
			System.out.println(what + " is expected after command " + s);
			return null;
		}
	}
	
	/**
	 * Reads interactive commands from the user until the 'quit' command
	 * is given.
	 * @param scan The Scanner instance to read from.
	 */
	private void commandLoop (Scanner scan) {
		
		while (true) {
			// Read next command
			System.out.print("CMD> ");
			String s = scan.nextLine().trim();
			if (s.isEmpty()) { // If empty string, try again
				continue;
			}
			
			// Check for a known command
			if (s.equalsIgnoreCase("quit")) {
				System.out.println("Bye");
				return;
			}
			else if (s.equalsIgnoreCase("list")) {
				listNames();
			}
			else if (s.equalsIgnoreCase("help")) {
				printHelp();
			}
			else if (s.toLowerCase().startsWith("add")) {
				String theName = getArgument (s, "A name");
				if (theName != null) {
					maybeAddName(theName);
				}
			}
			else if (s.toLowerCase().startsWith("remove")) {
				String theName = getArgument (s, "A name");
				if (theName != null) {
					removeName(theName);
				}
			}
			else {
				System.out.println("Unknown command: " + s);
			}
		}
	}
	
	/**
	 * Creates a Scanner instance for the command loop and calls 
	 * the command loop.
	 */
	public void doit() {
		commandLoop(new Scanner(System.in));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ArrayListDemo().doit();
	}

}

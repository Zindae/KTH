import java.util.Scanner;

/**
 * Utility class for displaying a message and read an integer from the user
 * 
 * @author Christopher
 * 
 */
public class KeyboardUtil {
	public static int getInt(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextInt();
	}
}

import java.util.Comparator;
import java.util.Scanner;

/**
 * Launch class for assignment 2.
 * 
 */
public class Assignment2 {
	/**
	 * Main Launch method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Sample test runs");
		System.out.println("Elements added : E C A F B D");
		Stopwatch sw = new Stopwatch();
		sw.start();
		// Operations on Unsorted Linked lists.
		UnSortedLinkedList<String> unsortedList = new UnSortedLinkedList<String>();
		// Add info to the list .
		unsortedList.addToEnd("E");
		unsortedList.addToEnd("C");
		unsortedList.addToEnd("A");
		unsortedList.addToEnd("F");
		unsortedList.addToEnd("B");
		unsortedList.addToEnd("D");
		sw.stop();
		// Display contents of the list.
		System.out.println("\nUnsorted Linked List Model:");
		System.out.println("=============================");
		System.out.println("Time to add the elements to the list : "
				+ sw.timeInNanoseconds() + " nanoseconds.");
		for (String grade : unsortedList) {
			System.out.println(grade);
		}
		sw.start();
		// Operations on Sorted Linked lists.
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(
				new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						return arg0.compareTo(arg1);
					}
				});
		// Add info to the list .
		sortedList.add("E");
		sortedList.add("C");
		sortedList.add("A");
		sortedList.add("F");
		sortedList.add("B");
		sortedList.add("D");
		sw.stop();
		System.out.println("\nSorted Linked List Model:");
		System.out.println("===========================");
		System.out.println("Time to add the elements to the list : "
				+ sw.timeInNanoseconds() + " nanoseconds.");

		for (String grade : sortedList) {
			System.out.println(grade);
		}

		sw.start();
		// Operations on Transformation model.
		TransformationModel<String> transformationModel = new TransformationModel<String>(
				unsortedList, new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						return arg0.compareTo(arg1);
					}
				});
		sw.stop();
		// Add info to the list .
		System.out.println("\nSorted List transformation model:");
		System.out.println("=================================");
		System.out.println("Time to add the elements to the list : "
				+ sw.timeInNanoseconds() + " nanoseconds.");
		for (String grade : transformationModel) {
			System.out.println(grade);
		}
		// The scanner for reading the user input.
		Scanner scanner = new Scanner(System.in);
		int count;
		System.out.print("\nEnter the number of words : ");
		count = scanner.nextInt();
		System.out.println("Enter the words");
		unsortedList = new UnSortedLinkedList<String>();
		for (int i = 0; i < count; i++) {
			String word = scanner.next();
			unsortedList.addToEnd(word);
		}
		transformationModel = new TransformationModel<String>(unsortedList,
				new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						return arg0.compareTo(arg1);
					}
				});
		// Sorted list.
		System.out.println("\nSorted words");
		System.out.println("==============");
		for (String grade : transformationModel) {
			System.out.println(grade);
		}

	}
}
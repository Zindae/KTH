import java.util.Scanner;
/**
 * This class stimulates the Printing of documents that are submitted by the
 * computers to the Queue.
 * 
 */
public class PrintingQueue
{

	/**
	 * The main Launch method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{ // The Printers Document Queue.
		Queue<Document> printQueue = new FifoQueue<Document>();
		Scanner scanner = new Scanner(System.in);
		// The commands are displayed here.
		System.out.println("Commands");
		System.out
				.println("1. ADD - Usage ADD [DocumentName.This paramter is Mandatory.] - Desc: adds the given document to print queue");
		System.out
				.println("2. PRINT - Usage ADD [Number of documents to print. This paramter is optional. If its not provided all the documents in the queue are printed.] - Desc: Prints the document from the queue.");
		System.out.println("3. EXIT - Usage Exit -Desc: Exits the system\n\n");
		while (true)
		{ // Loop until the user types exit.
			System.out.print(">");
			String entries = scanner.nextLine();
			String[] entry = entries.trim().split(" ");
			if (entry[0].equalsIgnoreCase("add"))// This command adds a document
													// to the Queue.
			{ // Name of the document.
				String documentName = entry[1];
				printQueue.enqueue(new Document(documentName));
				System.out.println("Document added.");
			}
			if (entry[0].equalsIgnoreCase("print")) // This commands get the
													// Documents from the Queue
													// and prints it.
			{ // The number of documents to be printed from the Queue
				int docCount = printQueue.size();
				if (entry.length == 2)
				{
					docCount = Integer.parseInt(entry[1]);
				}
				int c = 0;
				System.out
						.println("Number of documents in Queue : " + docCount);
				while (c < docCount)
				{
					if (printQueue.isEmpty())
					{ // Number of documents that are to be printed is greater
						// than documents on the Queue.
						System.out.println("\nNo more documents in Queue");
						break;
					}
					System.out.println(printQueue.dequeue().getName());
					c++;
				}
			}
			if (entry[0].equalsIgnoreCase("exit"))
			{ // Exit the application.
				break;
			}
		}
	}
	/**
	 * This class represents a Document
	 * 
	 */
	public static class Document
	{ // The name of the Document.
		private String name;
		/**
		 * Default constructor.
		 * 
		 * @param name
		 */
		public Document(String name)
		{
			super();
			this.name = name;
		}

		/**
		 * @return the name
		 */
		public String getName()
		{
			return name;
		}

	}

}

import java.util.Random;
/**
 * Analyzes Quick sort and Selection sort.
 * 
 */
public class QuickAndSelectionSort
{ // Auto generated numbers start from here.
	public static final int NUMBER_START = 1;
	// Auto generated numbers end here.
	public static final int NUMBER_END = 100;
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args)
	{ // Generates a small array
		int[] smallArray = generateArray(10);
		// Generates a medium array
		int[] mediumArray = generateArray(20);
		// Generates a large array
		int[] largeArray = generateArray(50);
		
		runComparison(smallArray, "Comparison run for small array . Size : "
				+ smallArray.length, true, true);
		runComparison(mediumArray, "Comparison run for medium array . Size : "
				+ mediumArray.length, true, true);
		runComparison(largeArray, "Comparison run for large array . Size : "
				+ largeArray.length, true, true);
	}
	
	/**
	 * Runs a comparison check.
	 * 
	 * @param array
	 * @param desc
	 * @param displayArrayBeforeSort
	 * @param displayArrayAfterSort
	 */
	
	public static void runComparison(int[] array, String desc,
			boolean displayArrayBeforeSort, boolean displayArrayAfterSort)
	{
		System.out
				.println("--------------------------------------------------------------------------\n");
		Stopwatch sw = new Stopwatch();
		System.out.println(desc);
		
		if (displayArrayBeforeSort)
			displayArray(array);
		
		int[] arrayToSort = new int[array.length];
		System.arraycopy(array, 0, arrayToSort, 0, array.length);
		
		sw.start();
		selectionSort(arrayToSort);
		sw.stop();
		
		System.out.println("Time taken for Selection sort : "
				+ sw.timeInNanoseconds() + " nanoseconds");
		if (displayArrayAfterSort)
		{
			System.out.println("Sorted Array : ");
			displayArray(arrayToSort);
		}
		System.arraycopy(array, 0, arrayToSort, 0, array.length);
		
		sw.start();
		System.out.println("*************** Quick Sort ***************:");
		quickSort(arrayToSort);
		sw.stop();
		
		System.out.println("Time taken for Quick sort : "
				+ sw.timeInNanoseconds() + " nanoseconds");
		if (displayArrayAfterSort)
		{
			System.out.println("Sorted Array : ");
			displayArray(arrayToSort);
		}
		System.out
				.println("--------------------------------------------------------------------------\n\n\n");
	}

	/**
	 * Selection sort implementation.
	 * This method sorts an array of comparable objects using the 
	 * "selection sort" algorithm.
	 * 
	 * Find the minimum value in the array then swap it first position. 
	 * In next step leave the first value and find the minimum value within remaining values. 
	 * Then swap it with the value of minimum index position. 
	 * Sort the remaining values by using same steps. 
	 * Selection sort is probably the most intuitive sorting algorithm to invent. 
	 *
	 * [n^2]
	 * 
	 * @param array
	 * @param i The first element
	 * @param j The second element
	 */
	static void selectionSort(int[] array)
	{
		// The selection sort implementation.
		System.out.println("*************** Selection Sort ***************:");
		int tmp = 0;
		
		// Loop over all the elements, except the last one. In each
		// loop, find the smallest value in the list (starting from
		// the index i)
		for (int i = 0; i < array.length - 1; i++)
		{
			// find the index of the smallest value, starting from index j
			for (int j = i + 1; j < array.length; j++)
			{ 
				// Swaps the integers at locations i and j of array values
				if (array[i] > array[j])
				{
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	/**
	 * Implementation of Quick sort. The Quick sort is faster than selection
	 * sort and takes less time [n(log(n)]
	 * 
	 * This method partitions a selection in an array so
	 * that all elements smaller than the pivot (pvo) value are
	 * moved to the left of the pivot value. All elements
	 * larger are moved to the right.
	 * 
	 * @param array
	 */
	static void quickSort(int[] array)
	{
		if (array.length <= 1)
		{
			return;
		}
		// Smaller array set
		int[] smaller;
		// Larger array set
		int[] larger;
		// The pivot point.
		int pvo = array[0];
		
		int small = 0;
		int large = 0;
		
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > pvo)
				large++;
			else
				small++;
		}
		
		smaller = new int[small];
		larger = new int[large];
		small = 0;
		large = 0;

		// Partition into small and large array.
		for (int j = 1; j < array.length; j++)
		{
			if (array[j] > pvo) // Array item Greater than the Pivot point
			{
				larger[large] = array[j];
				large++;
			} else
			{// Array item less than the Pivot point
				smaller[small] = array[j];
				small++;
			}
		}
		
		// Recursively sort the larger and smaller array.
		quickSort(larger);
		quickSort(smaller);
		
		// we have to call the merge method here
		combine(smaller, pvo, larger, array);

	}
	/**
	 * This method is used for Merging two arrays
	 * 
	 * @param smaller
	 * @param pvo
	 * @param larger
	 * @param result
	 */
	public static void combine(int[] smaller, int pvo, int[] larger,
			int[] result)
	{

		int counter = 0;
		
		// Merge Part-1
		for (int i = 0; i < smaller.length; i++)
		{
			result[counter++] = smaller[i];
		}
		result[counter++] = pvo;
	
		// Merge Part-2
		for (int j = 0; j < larger.length; j++)
		{
			result[counter++] = larger[j];
		}
	}

	public static int[] generateArray(int size)
	{
		Random random = new Random();
		int[] result = new int[size];
		for (int i = 0; i < size; i++)
		{
			result[i] = random.nextInt(NUMBER_END - NUMBER_START)
					+ NUMBER_START;
		}
		return result;
	}
	/**
	 * This method is used to display the array.
	 * 
	 * @param array
	 */
	public static void displayArray(int[] array)
	{
		int c = 0;
		for (int d : array)
		{
			System.out.print(d + ", ");
			c++;
			if (c == 10)
			{
				c = 0;
				System.out.println();
			}
		}
	}

}

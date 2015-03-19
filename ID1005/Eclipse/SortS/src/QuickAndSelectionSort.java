import java.util.Random;
/**
 * Analyzes Quick sort and Selection sort.
 * @author home
 *
 */
public class QuickAndSelectionSort
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] smallArray = generateArray(30);
		int[] mediumArray = generateArray(100);
		int[] largeArray = generateArray(50000);
        runComparison(smallArray, "Comaprison run for small array . Size : "+smallArray.length, true);
        runComparison(mediumArray, "Comaprison run for medium array . Size : "+mediumArray.length, false);
        runComparison(largeArray, "Comaprison run for large array . Size : "+largeArray.length, false);
	}
    /**
     * Runs a comparison check.
     * @param array
     * @param desc
     * @param displayArray
     */
	public static void runComparison(int[] array, String desc,
			boolean displayArray)
	{
		System.out
				.println("--------------------------------------------------------------------------\n");
		Stopwatch sw = new Stopwatch();
		System.out.println(desc);
		if (displayArray)
			displayArray(array);
		int[] arrayToSort = new int[array.length];
		System.arraycopy(array, 0, arrayToSort, 0, array.length);
		sw.start();
		selectionSort(arrayToSort);
		sw.stop();
		System.out.println("Time taken for Selection sort : "
				+ sw.timeInNanoseconds() + " nanoseconds");
		if (displayArray){
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
		if (displayArray){
		System.out.println("Sorted Array : ");
		displayArray(arrayToSort);
		}
		System.out
				.println("--------------------------------------------------------------------------\n\n\n");
	}

	// selection sort algorithm
	static void selectionSort(int[] array)
	{
		// here follows the implementation of selection sort
		//
		// --------------------- YOU -----------------------
		System.out.println("*************** Selection Sort ***************:");
		int tmp = 0;
		for (int i = 0; i < array.length - 1; i++)
		{
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[i] > array[j])
				{
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	// quick sort algorithm
	static void quickSort(int[] array)
	{
		// here follows the implementation of quick sort
		//
		// --------------------- YOU -----------------------
		if (array.length <= 1)
		{
			return;
		}
		int[] smaller;
		int[] larger;// = new int[];
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

		for (int j = 1; j < array.length; j++)
		{
			if (array[j] > pvo)
			{
				larger[large] = array[j];
				large++;
			} else
			{
				smaller[small] = array[j];
				small++;
			}
		}
		// array = (quickSort((quickSort(smaller))(quickSort(larger))));
		quickSort(larger);
		quickSort(smaller);
		// we have to call the merge method here
		combine(smaller, pvo, larger, array);

	}
	// merge method
	public static void combine(int[] smaller, int pvo, int[] larger,
			int[] result)
	{

		int counter = 0;

		for (int i = 0; i < smaller.length; i++)
		{
			result[counter++] = smaller[i];
		}
		result[counter++] = pvo;
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
			result[i] = random.nextInt(Integer.MAX_VALUE);
		}
		return result;
	}

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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
/**
 * Sorting Algorithm GUI tool.
 * 
 */
public class SortingAlgorithmComparer extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1578070299512222853L;
	// The Algorithms to be added to the GUI are added here.
	public static List<SortAlgorithm> ALGORITHM = new ArrayList<SortAlgorithm>();
	// Configure the algorithm implementations.
	static
	{
		ALGORITHM.add(new BubbleSort());
		ALGORITHM.add(new SelectionSort());
		ALGORITHM.add(new BidirectionalBubbleSortAlgorithm());
		ALGORITHM.add(new ShakerSortAlgorithm());
		ALGORITHM.add(new QSortAlgorithm());
		ALGORITHM.add(new ShellSortAlgorithm());
		ALGORITHM.add(new HeapSortAlgorithm());
		ALGORITHM.add(new InsertionSortAlgorithm());
		ALGORITHM.add(new FastQSortAlgorithm());
		ALGORITHM.add(new SwapSortAlgorithm());
		ALGORITHM.add(new ExtraStorageMergeSortAlgorithm());
		ALGORITHM.add(new CombSort11Algorithm());
	}
	private JTextField dataSize;
	private JTextArea data;
	// The Array to be sorted.
	int[] array;
	private JPanel algorithmListingPanel;
	private JTextArea report;
	private JTextField endRange;
	private JTextField startRange;

	/**
	 * The launch method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SortingAlgorithmComparer sac = new SortingAlgorithmComparer();
		sac.setVisible(true);
	}
	public SortingAlgorithmComparer()
	{
		setSize(700, 570);
		JPanel northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		algorithmListingPanel = new JPanel();
		int rows = ALGORITHM.size() / 2 + ((ALGORITHM.size() % 2) != 0 ? 1 : 0);
		northPanel.setLayout(new GridLayout(2, 1, 0, 0));
		algorithmListingPanel.setLayout(new GridLayout(rows, 2, 0, 0));
		algorithmListingPanel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Sorting Algorithms",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		northPanel.add(algorithmListingPanel);

		JPanel panel = new JPanel();
		northPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Start Range");
		panel_2.add(lblNewLabel_2);
		
		startRange = new JTextField();
		startRange.setText("1");
		panel_2.add(startRange);
		startRange.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("End Range");
		panel_2.add(lblNewLabel_1);
		
		endRange = new JTextField();
		endRange.setText("1000");
		panel_2.add(endRange);
		endRange.setColumns(10);

		JLabel lblNewLabel = new JLabel("Data Size");
		panel_2.add(lblNewLabel);

		dataSize = new JTextField();
		panel_2.add(dataSize);
		dataSize.setColumns(10);

		JButton btnNewButton = new JButton("Generate Data");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Integer.parseInt(dataSize.getText());
				} catch (Exception ex)
				{
					JOptionPane
							.showMessageDialog(
									null,
									"Invalid value entered into Data size fied. Only numeric fields are accepted.",
									"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try
				{
					Integer.parseInt(startRange.getText());
					Integer.parseInt(endRange.getText());
				} catch (Exception ex)
				{
					JOptionPane
							.showMessageDialog(
									null,
									"Invalid value entered into Data range field. Only numeric fields are accepted.",
									"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				array = generateArray(Integer.parseInt(dataSize.getText()),Integer.parseInt(startRange.getText()),Integer.parseInt(endRange.getText()));
				data.setText(convertArrayToString(array,15));
			}
		});
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);

		data = new JTextArea();
		data.setColumns(40);
		data.setRows(3);
		JScrollPane scrollPane2 = new JScrollPane(data);
		panel_3.add(scrollPane2);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				data.setText("");
				report.setText("");
			}
		});
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Analyze");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (data.getText() == null || data.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null,
							"The Data field is empty", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				readArray();
				generateReport();
			}
		});
		panel_1.add(btnNewButton_1);
		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		report = new JTextArea(10, 40);
		report.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(report);
		centerPanel.add(scrollPane);
		for (SortAlgorithm sa : ALGORITHM)
		{
			algorithmListingPanel.add(new JCheckBox(sa.getAlgorithmName()));
		}
		repaint();
		//revalidate();
	}

	/**
	 * Generates the report.
	 */

	public void generateReport()
	{
		Stopwatch sw = new Stopwatch();
		report.setText("");
		boolean noAlgorithmSelected = true;
		int[] sortedArray=null;
		for (Component comp : algorithmListingPanel.getComponents())
		{
			if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected())
			{
				StringBuilder sb = new StringBuilder();
				noAlgorithmSelected = false;
				SortAlgorithm sa = getSortAlgorithmInstanceByName(((JCheckBox) comp)
						.getText());
				sb.append("\n---------------------------------------------\n");
				sb.append("Running algorithm : " + sa.getAlgorithmName() + "\n");
				int[] copy = new int[array.length];
				//Start the stop watch
				sw.start();
				System.arraycopy(array, 0, copy, 0, array.length);
				//Stop the stop watch.
				sw.stop();
				sa.sort(copy);
				sb.append("Time to sort : " + sw.timeInNanoseconds()
						+ " nanoseconds\n");
				sb.append("Length of data sorted : " + array.length + "\n");
				sb.append("---------------------------------------------\n");
				report.setText(report.getText().concat(sb.toString()));
				sortedArray=copy;
			}
		}
		if (noAlgorithmSelected) //No algorithm selected from the check box so display error message.
		{
				JOptionPane.showMessageDialog(null,
						"Please select atleast one algorithm to be analysed.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
		}else{
			//Add the sorted array to the report.
			report.setText(report.getText().concat("\n---------SORTED ARRAY-----------\n"+convertArrayToString(sortedArray,20))+"\n------------------------------------\n");
		}
	}
	/**
	 * Generates the array with the specified range of data.
	 * @param size
	 * @param startRange
	 * @param endRange
	 * @return
	 */
	public static int[] generateArray(int size, int startRange, int endRange)
	{   //Random number generator.
		Random random = new Random();
		int[] result = new int[size];
		for (int i = 0; i < size; i++)
		{   //Generate the numbers within the given range.
			result[i] = random.nextInt(endRange-startRange)+startRange;
		}
		return result;
	}
    /**
     * Converst array into string for display.
     * @param array
     * @param lineLength
     * @return
     */
	public static String convertArrayToString(int[] array,int lineLength)
	{
		int c = 0;
		StringBuilder builder = new StringBuilder();
		for (int d : array)
		{
			builder.append(d + " ");
			c++;
			if (c == lineLength)
			{
				c = 0;
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	/**
	 * Extracts the data from the data field.
	 */
	public void readArray()
	{
		// Read the string value
		String[] localArray = data.getText().replaceAll("\n", "").split("\\s+");
		array = new int[localArray.length];
		int i = 0;
		for (String str : localArray)
		{
			try
			{
				array[i] = Integer.parseInt(str);
			} catch (Exception ex)
			{  //Inavlid number entered and hence the exception.
				JOptionPane
						.showMessageDialog(
								null,
								"The Data field contains a Non-Numeric field. Only numeric feilds are accepted.",
								"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			i++;
		}
	}

	/**
	 * Gets the Algorithm implementor by name.
	 * 
	 * @param algorithm
	 * @return
	 */
	public SortAlgorithm getSortAlgorithmInstanceByName(String algorithm)
	{
		if (algorithm.equals(BubbleSort.BUBBLE_SORT))
		{
			return new BubbleSort();
		}
		if (algorithm.equals(SelectionSort.SELECTION_SORT))
		{
			return new SelectionSort();
		}
		if (algorithm
				.equals(BidirectionalBubbleSortAlgorithm.BIDIRECTIONAL_BUBBLE_SORT))
		{
			return new BidirectionalBubbleSortAlgorithm();
		}
		if (algorithm.equals(ShakerSortAlgorithm.SHAKER_SORT))
		{
			return new ShakerSortAlgorithm();
		}
		if (algorithm.equals(QSortAlgorithm.QUICK_SORT))
		{
			return new QSortAlgorithm();
		}
		if (algorithm.equals(ShellSortAlgorithm.SHELL_SORT))
		{
			return new ShellSortAlgorithm();
		}
		if (algorithm.equals(HeapSortAlgorithm.HEAP_SORT))
		{
			return new HeapSortAlgorithm();
		}
		if (algorithm.equals(InsertionSortAlgorithm.INSERTION_SORT))
		{
			return new InsertionSortAlgorithm();
		}
		if (algorithm.equals(FastQSortAlgorithm.FAST_QUICK_SORT))
		{
			return new FastQSortAlgorithm();
		}
		if (algorithm.equals(SwapSortAlgorithm.SWAP_SORT))
		{
			return new SwapSortAlgorithm();
		}
		if (algorithm
				.equals(ExtraStorageMergeSortAlgorithm.EXTRA_STORAGE_MERGE_SORT))
		{
			return new ExtraStorageMergeSortAlgorithm();
		}
		if (algorithm.equals(CombSort11Algorithm.COMBO_SORT))
		{
			return new CombSort11Algorithm();
		}
		return null;
	}

	public static class CombSort11Algorithm implements SortAlgorithm
	{
		private static final String COMBO_SORT = "Combo sort";
		final float SHRINKFACTOR = (float) 1.3;

		public void sort(int a[])
		{
			boolean flipped = false;
			int gap, top;
			int i, j;

			gap = a.length;
			do
			{
				gap = (int) ((float) gap / SHRINKFACTOR);
				switch (gap)
				{
					case 0 : /* the smallest gap is 1 - bubble sort */
						gap = 1;
						break;
					case 9 : /* this is what makes this Combsort11 */
					case 10 :
						gap = 11;
						break;
					default :
						break;
				}
				flipped = false;
				top = a.length - gap;
				for (i = 0; i < top; i++)
				{
					j = i + gap;
					if (a[i] > a[j])
					{
						int T = a[i];
						a[i] = a[j];
						a[j] = T;
						flipped = true;
					}
				}
			} while (flipped || (gap > 1));
			/* like the bubble and shell sorts we check for a clean pass */
		}

		@Override
		public String getAlgorithmName()
		{
			return COMBO_SORT;
		}
	}

	public static class ExtraStorageMergeSortAlgorithm implements SortAlgorithm
	{
		private static final String EXTRA_STORAGE_MERGE_SORT = "Extra Storage Merge Sort";

		void sort(int a[], int lo, int hi, int scratch[]) throws Exception
		{
			if (lo >= hi)
			{
				return; /* a[lo] is sorted already */
			}

			int mid = (lo + hi) / 2;
			sort(a, lo, mid, scratch); /* Sort sublist a[lo..mid] */
			sort(a, mid + 1, hi, scratch); /* Sort sublist a[mid+1..hi] */

			int k, t_lo = lo, t_hi = mid + 1;
			for (k = lo; k <= hi; k++)
				/* Merge sorted sublists */
				if ((t_lo <= mid) && ((t_hi > hi) || (a[t_lo] < a[t_hi])))
				{
					scratch[k] = a[t_lo++];
				} else
				{
					scratch[k] = a[t_hi++];
				}

			for (k = lo; k <= hi; k++)
			{
				a[k] = scratch[k]; /* Copy back to a */
			}
		}

		public void sort(int a[])
		{
			int scratch[] = new int[a.length];
			try
			{
				sort(a, 0, a.length - 1, scratch);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return EXTRA_STORAGE_MERGE_SORT;
		}
	}

	public static class SwapSortAlgorithm implements SortAlgorithm
	{
		private static final String SWAP_SORT = "Swap sort";

		public void sort(int a[])
		{
			int max = a[0];

			/*
			 * Originally the SortItem class created arrays without duplicates
			 * and thus every item had a single correct location in the final
			 * sorted array. With duplicates there are many correct final
			 * locations and we cannot just swap an item into the final spot.
			 * 
			 * So fill the array the old way, shuffle it and then continue with
			 * the old algorithm. (This the old is SortItem::scramble()) Even
			 * then this doesn't always work due to floating point limitations.
			 */

			/*
			 * The array a holds values from 0 to max where a.length = max / f.
			 * Here we find max.
			 */
			for (int i = 1; i < a.length; i++)
			{
				if (max < a[i])
				{
					max = a[i];
				}
			}

			/*
			 * Now find f, the scaling factor for drawing the contents of the
			 * array a. The correct value for a[j] is j / f.
			 */
			double f = ((double) a.length - 1.0) / (double) max;

			/*
			 * Fill the array with random numbers from 0..a.length-1
			 */

			for (int i = a.length; --i >= 0;)
			{
				a[i] = (int) (i / f);
			}

			/*
			 * Shuffle the array
			 */
			for (int i = a.length; --i >= 0;)
			{
				int j = (int) (i * Math.random());
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			/*
			 * Now sort the array. Each time through the loop we remove a value,
			 * find it's correct position in the array, and place it there. The
			 * displaced value becomes the next value to place.
			 */
			int T = a[0];
			int S = a[1];
			for (int i = 0; i < a.length; i++)
			{
				S = a[(int) (T * f)];
				/*
				 * If the item we're trying to move is supposed to where the
				 * next item goes we'll get stuck in a fixed point. Pick a new
				 * starting point.
				 */
				if (T == S)
				{
					T = a[(int) (Math.random() * a.length)];
					S = a[(int) (T * f)];
				}
				a[(int) (T * f)] = T;
				T = S;
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return SWAP_SORT;
		}
	}

	public static class BubbleSort implements SortAlgorithm
	{

		private static final String BUBBLE_SORT = "Bubble Sort";

		@Override
		public void sort(int[] a)
		{
			for (int i = a.length; --i >= 0;)
			{
				boolean flipped = false;
				for (int j = 0; j < i; j++)
				{

					if (a[j] > a[j + 1])
					{
						int T = a[j];
						a[j] = a[j + 1];
						a[j + 1] = T;
						flipped = true;
					}

				}
				if (!flipped)
				{
					return;
				}
			}

		}

		@Override
		public String getAlgorithmName()
		{
			return BUBBLE_SORT;
		}

	}
	public static class BidirectionalBubbleSortAlgorithm
			implements
				SortAlgorithm
	{
		private static final String BIDIRECTIONAL_BUBBLE_SORT = "Bidirectional Bubble Sort";

		public void sort(int a[])
		{
			int j;
			int limit = a.length;
			int st = -1;
			while (st < limit)
			{
				boolean flipped = false;
				st++;
				limit--;
				for (j = st; j < limit; j++)
				{
					if (a[j] > a[j + 1])
					{
						int T = a[j];
						a[j] = a[j + 1];
						a[j + 1] = T;
						flipped = true;
					}
				}
				if (!flipped)
				{
					return;
				}
				for (j = limit; --j >= st;)
				{
					if (a[j] > a[j + 1])
					{
						int T = a[j];
						a[j] = a[j + 1];
						a[j + 1] = T;
						flipped = true;
					}
				}
				if (!flipped)
				{
					return;
				}
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return BIDIRECTIONAL_BUBBLE_SORT;
		}
	}

	public static class SelectionSort implements SortAlgorithm
	{
		private static final String SELECTION_SORT = "Selection Sort";

		public void sort(int a[])
		{
			for (int i = 0; i < a.length; i++)
			{
				int min = i;
				int j;

				/*
				 * Find the smallest element in the unsorted list
				 */
				for (j = i + 1; j < a.length; j++)
				{

					if (a[j] < a[min])
					{
						min = j;
					}
				}

				/*
				 * Swap the smallest unsorted element into the end of the sorted
				 * list.
				 */
				int T = a[min];
				a[min] = a[i];
				a[i] = T;
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return SELECTION_SORT;
		}
	}
	public static class FastQSortAlgorithm implements SortAlgorithm
	{
		private static final String FAST_QUICK_SORT = "Fast quick sort";

		/**
		 * This will handle arrays that are already sorted, and arrays with
		 * duplicate keys.<BR>
		 * 
		 * If you think of a one dimensional array as going from the lowest
		 * index on the left to the highest index on the right then the
		 * parameters to this function are lowest index or left and highest
		 * index or right. The first time you call this function it will be with
		 * the parameters 0, a.length - 1.
		 * 
		 * @param a
		 *            an integer array
		 * @param lo0
		 *            left boundary of array partition
		 * @param hi0
		 *            right boundary of array partition
		 */
		private void QuickSort(int a[], int l, int r) throws Exception
		{
			int M = 4;
			int i;
			int j;
			int v;

			if ((r - l) > M)
			{
				i = (r + l) / 2;
				if (a[l] > a[i])
					swap(a, l, i); // Tri-Median Methode!
				if (a[l] > a[r])
					swap(a, l, r);
				if (a[i] > a[r])
					swap(a, i, r);

				j = r - 1;
				swap(a, i, j);
				i = l;
				v = a[j];
				for (;;)
				{
					while (a[++i] < v);
					while (a[--j] > v);
					if (j < i)
						break;
					swap(a, i, j);
				}
				swap(a, i, r - 1);
				QuickSort(a, l, j);
				QuickSort(a, i + 1, r);
			}
		}

		private void swap(int a[], int i, int j)
		{
			int T;
			T = a[i];
			a[i] = a[j];
			a[j] = T;
		}

		private void InsertionSort(int a[], int lo0, int hi0) throws Exception
		{
			int i;
			int j;
			int v;

			for (i = lo0 + 1; i <= hi0; i++)
			{
				v = a[i];
				j = i;
				while ((j > lo0) && (a[j - 1] > v))
				{
					a[j] = a[j - 1];
					j--;
				}
				a[j] = v;
			}
		}

		public void sort(int a[])
		{
			try
			{
				QuickSort(a, 0, a.length - 1);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				InsertionSort(a, 0, a.length - 1);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return FAST_QUICK_SORT;
		}
	}

	public static class InsertionSortAlgorithm implements SortAlgorithm
	{
		private static final String INSERTION_SORT = "Insertion sort";

		public void sort(int a[])
		{
			for (int i = 1; i < a.length; i++)
			{
				int j = i;
				int B = a[i];
				while ((j > 0) && (a[j - 1] > B))
				{
					a[j] = a[j - 1];
					j--;
				}
				a[j] = B;
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return INSERTION_SORT;
		}
	}

	public static class HeapSortAlgorithm implements SortAlgorithm
	{
		private static final String HEAP_SORT = "Heap sort";

		public void sort(int a[])
		{
			int N = a.length;
			for (int k = N / 2; k > 0; k--)
			{
				try
				{
					downheap(a, k, N);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			do
			{
				int T = a[0];
				a[0] = a[N - 1];
				a[N - 1] = T;
				N = N - 1;
				try
				{
					downheap(a, 1, N);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (N > 1);
		}

		public void downheap(int a[], int k, int N) throws Exception
		{
			int T = a[k - 1];
			while (k <= N / 2)
			{
				int j = k + k;
				if ((j < N) && (a[j - 1] < a[j]))
				{
					j++;
				}
				if (T >= a[j - 1])
				{
					break;
				} else
				{
					a[k - 1] = a[j - 1];
					k = j;
				}
			}
			a[k - 1] = T;
		}

		@Override
		public String getAlgorithmName()
		{
			return HEAP_SORT;
		}
	}

	public static class ShellSortAlgorithm implements SortAlgorithm
	{
		private static final String SHELL_SORT = "Shell sort";

		public void sort(int a[])
		{
			int h = 1;
			/*
			 * find the largest h value possible
			 */
			while ((h * 3 + 1) < a.length)
			{
				h = 3 * h + 1;
			}

			/*
			 * while h remains larger than 0
			 */
			while (h > 0)
			{
				/*
				 * for each set of elements (there are h sets)
				 */
				for (int i = h - 1; i < a.length; i++)
				{
					/*
					 * pick the last element in the set
					 */
					int B = a[i];
					int j = i;
					/*
					 * compare the element at B to the one before it in the set
					 * if they are out of order continue this loop, moving
					 * elements "back" to make room for B to be inserted.
					 */
					for (j = i; (j >= h) && (a[j - h] > B); j -= h)
					{

						a[j] = a[j - h];

					}
					/*
					 * insert B into the correct place
					 */
					a[j] = B;

				}
				/*
				 * all sets h-sorted, now decrease set size
				 */
				h = h / 3;
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return SHELL_SORT;
		}
	}

	public static class QSortAlgorithm implements SortAlgorithm
	{
		private static final String QUICK_SORT = "Quick sort";

		void sort(int a[], int lo0, int hi0) throws Exception
		{
			int lo = lo0;
			int hi = hi0;
			if (lo >= hi)
			{
				return;
			} else if (lo == hi - 1)
			{
				/*
				 * sort a two element list by swapping if necessary
				 */
				if (a[lo] > a[hi])
				{
					int T = a[lo];
					a[lo] = a[hi];
					a[hi] = T;
				}
				return;
			}

			/*
			 * Pick a pivot and move it out of the way
			 */
			int pivot = a[(lo + hi) / 2];
			a[(lo + hi) / 2] = a[hi];
			a[hi] = pivot;

			while (lo < hi)
			{
				/*
				 * Search forward from a[lo] until an element is found that is
				 * greater than the pivot or lo >= hi
				 */
				while (a[lo] <= pivot && lo < hi)
				{
					lo++;
				}

				/*
				 * Search backward from a[hi] until element is found that is
				 * less than the pivot, or lo >= hi
				 */
				while (pivot <= a[hi] && lo < hi)
				{
					hi--;
				}

				/*
				 * Swap elements a[lo] and a[hi]
				 */
				if (lo < hi)
				{
					int T = a[lo];
					a[lo] = a[hi];
					a[hi] = T;

				}

			}

			/*
			 * Put the median in the "center" of the list
			 */
			a[hi0] = a[hi];
			a[hi] = pivot;

			/*
			 * Recursive calls, elements a[lo0] to a[lo-1] are less than or
			 * equal to pivot, elements a[hi+1] to a[hi0] are greater than
			 * pivot.
			 */
			sort(a, lo0, lo - 1);
			sort(a, hi + 1, hi0);
		}

		public void sort(int a[])
		{
			try
			{
				sort(a, 0, a.length - 1);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return QUICK_SORT;
		}
	}

	public static class ShakerSortAlgorithm implements SortAlgorithm
	{
		public static final String SHAKER_SORT = "Shaker Sort";

		public void sort(int a[])
		{
			int i = 0;
			int k = a.length - 1;
			while (i < k)
			{
				int min = i;
				int max = i;
				int j;
				for (j = i + 1; j <= k; j++)
				{

					if (a[j] < a[min])
					{
						min = j;
					}
					if (a[j] > a[max])
					{
						max = j;
					}

				}
				int T = a[min];
				a[min] = a[i];
				a[i] = T;

				if (max == i)
				{
					T = a[min];
					a[min] = a[k];
					a[k] = T;
				} else
				{
					T = a[max];
					a[max] = a[k];
					a[k] = T;
				}

				i++;
				k--;
			}
		}

		@Override
		public String getAlgorithmName()
		{
			return SHAKER_SORT;
		}
	}

}

import java.util.Comparator;

/**
 * The transformation model implementation. This class takes in a unsortedList
 * and returns a Sorted List.
 * 
 * @param <T>
 */
public class TransformationModel<T> extends SortedLinkedList<T> {
	/**
	 * 
	 * @param comparator
	 */
	public TransformationModel(Comparator<T> comparator) {
		super(comparator);
	}

	/**
	 * 
	 * @param unsoretdLinkedList
	 * @param comparator
	 */
	public TransformationModel(UnSortedLinkedList<T> unsoretdLinkedList,
			Comparator<T> comparator) {
		super(comparator);
		for (T t : unsoretdLinkedList) {
			add(t);
		}
	}
}

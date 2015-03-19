import java.util.Comparator;

/**
 * The Sorted linked list implementation.
 * 
 * @param <T>
 */
public class SortedLinkedList<T> extends UnSortedLinkedList<T> {
	/**
	 * The comparator to sort the elements as they are added to the linkedlist.
	 */
	private Comparator<T> comparator = null;

	/**
	 * Default constructor.
	 * 
	 * @param comparator
	 */
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
		size = 0;
	}

	/**
	 * Adds a elements to the Sorted list.
	 */
	public SortedLinkedList<T> add(T element) {
		Node<T> node = first;
		while (node != null) {
			if (comparator.compare(element, node.getData()) < 0) {
				break;
			}
			node = node.getNext();
		}
		if (getSize() == 0) {
			first = last = new Node<T>(null, element, null);
		} else if (node == null) {
			Node<T> newNode = new Node<T>(last, element, null);
			last.setNext(newNode);
			last = newNode;
		} else if (node == first) {
			Node<T> newNode = new Node<T>(null, element, first);
			first.setPrev(newNode);
			first = newNode;
		} else {
			Node<T> newNode = new Node<T>(node.getPrev(), element, node);
			node.getPrev().setNext(newNode);
			node.setPrev(newNode);
		}
		size++;
		return this;
	}

	/**
	 * Removes a element from the sorted list.
	 * 
	 * @param targetData
	 * @return
	 */
	public UnSortedLinkedList<T> remove(T targetData) {
		return remove(targetData, comparator);
	}

	/**
	 * @see UnSortedLinkedList#addToEnd(java.lang.Object)
	 */
	@Override
	public UnSortedLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException(
				"This Operation is not supported.");
	}

	/**
	 * @see UnSortedLinkedList#addToFront(java.lang.Object)
	 */
	@Override
	public UnSortedLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException(
				"This Operation is not supported.");
	}

}
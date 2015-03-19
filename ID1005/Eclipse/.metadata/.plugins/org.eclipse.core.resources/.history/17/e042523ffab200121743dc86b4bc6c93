import java.util.Comparator;
import java.util.Iterator;

/**
 * 
 * Display the unsorted list.
 * 
 * @param <T>
 */
public class UnSortedLinkedList<T> extends java.lang.Object implements
		java.lang.Iterable<T> {
	// The size of the list
	public int size;
	// The first element of the List
	protected Node<T> first;
	// The last element of the List
	protected Node<T> last;

	/**
	 * Default Args
	 */
	public UnSortedLinkedList() {
		first = last = null;
	}

	/**
	 * The size of the List
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds data to the end of the list.
	 * 
	 * @param data
	 * @return
	 */
	public UnSortedLinkedList<T> addToEnd(T data) {
		if (getSize() == 0) {
			first = last = new Node<T>(null, data, null);
		} else {
			Node<T> node = new Node<T>(last, data, null);
			last.setNext(node);
			last = node;
		}
		size++;
		return this;
	}

	/**
	 * Adds to the front of the list.
	 * 
	 * @param data
	 * @return
	 */
	public UnSortedLinkedList<T> addToFront(T data) {
		if (getSize() == 0) {
			first = last = new Node<T>(null, data, null);
		} else {
			Node<T> node = new Node<T>(null, data, first);
			first.setPrev(node);
			first = node;
		}
		size++;
		return this;
	}

	public T getFirst() {
		return first.getData();

	}

	public T getLast() {
		return last.getData();

	}

	/**
	 * Retrieves the first element.
	 * 
	 * @return
	 */
	public T retrieveFirstElement() {
		Node<T> removedNode = first;
		removeNode(first);
		size--;
		return removedNode.getData();

	}

	/**
	 * Retrieves the last element.
	 * 
	 * @return
	 */
	public T retrieveLastElement() {
		Node<T> removedNode = last;
		removeNode(last);
		size--;
		return removedNode.getData();
	}

	public Iterator<T> iterator() {
		return new LLIterator();
	}

	public UnSortedLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node<T> node = first;
		while (node != null) {
			if (comparator.compare(targetData, node.getData()) == 0) {
				removeNode(node);
				size--;
			}
			node = node.getNext();
		}
		return this;
	}

	/**
	 * Removes a Node from the list.
	 * 
	 * @param node
	 */
	private void removeNode(Node<T> node) {
		if (getSize() == 1) {
			first = last = null;
		} else if (node == first) {
			first.getNext().setPrev(null);
			first = first.getNext();
		} else if (node == last) {
			last.getPrev().setNext(null);
			last = last.getPrev();
		} else {
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
		}
	}

	/**
	 * A Linked list Iterator.
	 */
	private class LLIterator implements Iterator<T> {
		/**
		 * The current element of the Iterator.
		 */
		Node<T> currentElement;

		/**
		 * Default constructor.
		 */
		public LLIterator() {
			super();
			this.currentElement = first;
		}

		/**
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return currentElement != null;
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		public T next() {
			T data = currentElement.getData();
			currentElement = currentElement.getNext();
			return data;
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			removeNode(currentElement);
		}
	}

	/**
	 * Returns this instance.
	 * 
	 * @return
	 */
	public UnSortedLinkedList<T> getBasicLinkedListInstance() {
		return this;
	}

}
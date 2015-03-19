/**
 * Represents a Node of a Linked list.
 * 
 * @param <E>
 */
public class Node<E> {
	// Data held by the list.
	private E data;
	// The reference to the next item in the list .
	private Node<E> next;
	// The reference to the previous item in the list .
	private Node<E> prev;

	public Node() {
		this(null, null, null);
	}

	public Node(Node<E> prev, E data, Node<E> next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Node<E> getPrev() {
		return prev;
	}

	/**
	 * @param prev
	 *            the prev to set
	 */
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

}
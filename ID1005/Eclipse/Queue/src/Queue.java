import java.util.Iterator;

/**
 * This interface represents a Queue. Element to the Queue are added at the end.
 */
public interface Queue<T> extends Iterable<T>
{
	/**
	 * Removes a item from the Queue
	 * 
	 * @return
	 */
	public abstract T dequeue();
	/**
	 * Adds the item to the Queue.
	 * 
	 * @return
	 */
	public abstract void enqueue(T item);
	/**
	 * Gets the Next element in that Queue that will be removed.
	 * 
	 * @return
	 */
	public abstract T peek();
	/**
	 * Returns the size of the Queue.
	 * 
	 * @return
	 */
	public abstract int size();
	/**
	 * Returns true if the Queue is empty.
	 * 
	 * @return
	 */
	public abstract boolean isEmpty();
	/**
	 * Returns the Iterator for the Queue.
	 */
	public abstract Iterator<T> iterator();

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This is LIFO queue in with operation have the Complexity of O(1)
 * 
 * @param <T>
 */
public class LifoQueueOne<T> implements Queue<T>
{ // The Queue data items are stored here.
	private List<T> store = new ArrayList<T>();
	/**
	 * Default constructor.
	 */
	public LifoQueueOne()
	{
		super();
	}
	/**
	 * Adds the item t to the Queue.
	 */
	@Override
	public void enqueue(T t)
	{
		store.add(t);
	}
	/**
	 * Removes a Item from the Queue.
	 */
	@Override
	public T dequeue()
	{
		return store.remove(store.size() - 1);
	}
	/**
	 * Displays the next element that will be removed from the Queue.
	 */
	@Override
	public T peek()
	{
		return store.get(store.size() - 1);
	}
	/**
	 * Returns the size of the Queue.
	 */
	@Override
	public int size()
	{
		return store.size();
	}
	/**
	 * Returns true if the Queue is empty.
	 */
	@Override
	public boolean isEmpty()
	{
		return store.isEmpty();
	}
	/**
	 * Returns the iterator for the Queue elements.
	 */
	@Override
	public Iterator<T> iterator()
	{ // As the Queue is a LIFO queue. The items has to be iterated in reverse
		// order.
		List<T> arrayList = new ArrayList<T>(store);
		Collections.reverse(arrayList);
		return arrayList.iterator();
	}

}

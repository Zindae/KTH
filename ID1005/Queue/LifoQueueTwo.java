import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This is a LIFO queue where the operations are O(N)
 * 
 * @param <T>
 */
public class LifoQueueTwo<T> implements Queue<T>
{ // The items of the Queue are stored here.
	private List<T> store = new ArrayList<T>();
	/**
	 * Gets the size of the Queue by iteration.
	 * 
	 * @return
	 */
	private int getSizeByIteration()
	{
		int c = 0;
		Iterator<T> itr = store.iterator();
		while (itr.hasNext())
		{   itr.next();
			c++;
		}
		return c;
	}
	/**
	 * Removes a element from the Queue.
	 */
	@Override
	public T dequeue()
	{
		return store.remove(getSizeByIteration() - 1);
	}
	/**
	 * Adds a element to the Queue.
	 */
	@Override
	public void enqueue(T item)
	{
		store.add(getSizeByIteration(), item);
	}
	/**
	 * Displays the next element that will be removed from the Queue.
	 */
	@Override
	public T peek()
	{
		return store.get(getSizeByIteration()-1);
	}
	/**
	 * Returns the Size of the Queue.
	 */
	@Override
	public int size()
	{
		return getSizeByIteration();
	}
	/**
	 * Returns true if the Size is empty.
	 */
	@Override
	public boolean isEmpty()
	{
		return getSizeByIteration() == 0 ? true : false;
	}
	/**
	 * Returns the Iterator for the items of the Queue.
	 */
	@Override
	public Iterator<T> iterator()
	{
		// As the Queue is a LIFO queue. The items has to be iterated in reverse
		// order.
		List<T> arrayList = new ArrayList<T>(store);
		Collections.reverse(arrayList);
		return arrayList.iterator();
	}
}

import java.util.Random;
/**
 * This class is used to test and analyze the two Implementation of LIFO queue.
 * 1) O(1) 2) O(N)
 * 
 */
public class LifoQueuesComparison
{

	/**
	 * The Launch class.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{ // Queue with O(1) time complexity.
		Queue<Integer> queueWithO1Complexity = new LifoQueueOne<Integer>();
		// Queue with O(N) time complexity.
		Queue<Integer> queueWithONComplexity = new LifoQueueTwo<Integer>();
		System.out
				.println("Comparison of Two Queue Implementations. The First Queue has operations Time Complexity of O(1).The Second Queue has operations Time Complexity of O(N).");
		System.out.println("First Queue. Queue with operations of O(1).");
		System.out.println("TESTS");
		testQueues(queueWithO1Complexity);
		System.out.println("ANALYSIS");
		analyseQueue(queueWithO1Complexity, 100);
		analyseQueue(queueWithO1Complexity, 1000000);
		System.out.println("SECOND Queue. Queue with operations of O(N).");
		System.out.println("TESTS");
		testQueues(queueWithONComplexity);
		System.out.println("ANALYSIS");
		analyseQueue(queueWithONComplexity, 100);
		analyseQueue(queueWithONComplexity, 1000000);
	}
	/**
	 * Runs tests for the Queue methods.
	 * 
	 * @param queue
	 */
	public static void testQueues(Queue<Integer> queue)
	{
		// Test enqueue & Peek
		queue.enqueue(1);
		if (queue.peek().equals(1))
		{
			System.out.println("Enqueue and peek method test passed.");
		} else
		{
			System.out.println("Enqueue and peek method test failed.");
		}
		queue.enqueue(2);
		queue.enqueue(3);
		// Test Dequeue
		if (queue.dequeue().equals(3))
		{
			System.out.println("Dequeue method test passed.");
		} else
		{
			System.out.println("Dequeue method test failed.");
		}
		// Test size.
		if (queue.size() == 2)
		{
			System.out.println("size method test passed.");
		} else
		{
			System.out.println("size method test failed.");
		}
	}
    /**
     * Run analysis on the Queue.
     * @param queue
     * @param dataSize
     */
	public static void analyseQueue(Queue<Integer> queue, long dataSize)
	{
		Random random = new Random();
		Stopwatch sw = new Stopwatch();
        // Analyze enqueue operation.
		sw.start();
		for (long i = 0; i < dataSize; i++)
		{
			queue.enqueue(random.nextInt());
		}
		sw.stop();
		System.out.println("Time taken to add " + dataSize
				+ " elements to queue is " + sw.timeInNanoseconds()+" nano seconds.");
		// Analyze size operation.
		sw.start();
		queue.size();
		sw.stop();
		System.out.println("Time taken to compute size is " + sw.timeInNanoseconds()
				+ " nano seconds, for queue with " + dataSize + " elements.");
		sw.start();
		// Analyze dequeue operation.
		queue.dequeue();
		sw.stop();
		System.out.println("Time taken to dequeue is " + sw.timeInNanoseconds()
				+ " nano seconds, for queue with " + dataSize + " elements.");
		// Analyze peek operation.
		sw.start();
		queue.peek();
		sw.stop();
		System.out.println("Time taken to peek is " + sw.timeInNanoseconds()
				+ " nano seconds, for queue with " + dataSize + " elements.");

	}
}

/*************************************************************************
 *  Compilation:  javac Queue.java
 *  Execution:    java Queue < input.txt
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt  
 *
 *  A generic queue, implemented using a linked list.
 *
 *  % java Queue < tobe.txt 
 *  to be or not to be (2 left on queue)
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>FifoQueue</tt> class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the top item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 */
public class FifoQueue<T> implements Queue<T> {
    private int N;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private T item;
        private Node next;
    }

   /**
     * Create an empty queue.
     */
    public FifoQueue() {
        first = null;
        last  = null;
        N = 0;
        assert check();
    }

   /**
     * Is the queue empty?
     */
    @Override
	public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the queue.
     */
    @Override
	public int size() {
        return N;     
    }

   /**
     * Return the item least recently added to the queue.
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    @Override
	public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

   /**
     * Add the item to the queue.
     */
    @Override
	public void enqueue(T item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
        assert check();
    }

   /**
     * Remove and return the item on the queue least recently added.
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    @Override
	public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        T item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        assert check();
        return item;
    }

   /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item + " ");
        return s.toString();
    } 

    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (N == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            // check internal consistency of instance variable N
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
               numberOfNodes++;
            }
            if (numberOfNodes != N) return false;

            // check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
               lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    } 
 

   /**
     * Return an iterator that iterates over the items on the queue in FIFO order.
     */
    
	@Override
	public Iterator<T> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next; 
            return item;
        }
    }

}

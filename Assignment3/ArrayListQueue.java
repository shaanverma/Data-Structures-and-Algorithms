/********************************************************************************
 * LinkedListQueue.java                                                         *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#3 Question#4                                            *
 *                                                                              *
 * This Class is a Array list implementation of a queue using the classes       *
 * defined in java.util.                                                        *
 ********************************************************************************/

//Importing java.util classes
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implements a queue using the java.util LinkedList as the container.
 * @author shaan
 * @param <T>
 */
public class ArrayListQueue<T>{
	ArrayList <T> queue;
	int front;
	
	/**
	 * Constructor creates the empty queue
	 */
	public ArrayListQueue()
	{
		queue = new ArrayList<T>();
		@SuppressWarnings("unused")
		int front = 0;
	}
	
	/**
	 * Adds an element to the rear of the queue.
	 * @param element
	 */
	public void enqueue(T element)
	{
		queue.add(element);
	}
	
	/**
	 * Removes an element from the front of the queue. Throws an exception if the queue is empty.
	 * @return The element removed.
	 */
	public T dequeue()
	{
		if(isEmpty())
			throw new NoSuchElementException("The queue is Empty");
		return queue.remove(front);
	}
	
	/**
	 * Examines the element at the front of the queue. Throws an exception if the queue is empty.
	 * @return The element at the top of the queue.
	 */
	public T first()
	{
		if(isEmpty())
			throw new NoSuchElementException("The queue is Empty");
		return queue.get(front);
	}
	
	/**
	 * Determines if the queue is empty.
	 * @return True or False.
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	/**
	 * Determines the number of elements on the queue.
	 * @return An integer value.
	 */
	public int size()
	{
		return queue.size();
	}
	
	/**
	 * Returns a string representation of the queue.
	 */
	public String toString()
	{
		return queue.toString();
	}
	
	/**
	 * Testing of the ArrayListQueue class
	 * @param args
	 */
	public static void main(String[] args)
	{
		LinkedListQueue<Integer> test = new LinkedListQueue<Integer>();
		System.out.println("QUESTION 4: ArrayListQueue test:\n");
		
		System.out.println("enqueue(1), enqueue(2), enqueue(3), enqueue(4):");
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.enqueue(4);
		System.out.println(test.toString());
		
		System.out.println("\ndequeue(), dequeue():");
		test.dequeue();
		test.dequeue();
		System.out.println(test.toString());
		
		System.out.println("\nfirst():");
		System.out.println(test.first());
		
		System.out.println("\nisEmpty():");
		System.out.println(test.isEmpty());
		
		System.out.println("\nsize():");
		System.out.println(test.size());
		
	}
}

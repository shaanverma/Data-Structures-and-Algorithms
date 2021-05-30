/********************************************************************************
 * LinkedListStack.java                                                         *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#3 Question#1                                            *
 *                                                                              *
 * This Class is a linked list implementation of a stack using the classes      *
 * defined in java.util.                                                        *
 ********************************************************************************/

//Importing java.util classes
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implements a stack using the java.util LinkedList as the container.
 * @author shaan
 * @param <T>
 */
public class LinkedListStack<T>{
	LinkedList <T> stack;
	
	/**
	 * Constructor creates the empty stack
	 */
	public LinkedListStack()
	{
		stack = new LinkedList<T>();
	}
	
	/**
	 * Adds an element to the top of the stack.
	 * @param element
	 */
	public void push(T element)
	{
		stack.add(element);
	}
	
	/**
	 * Removes an element from the top of the stack. Throws an exception if the stack is empty.
	 * @return The element removed.
	 */
	public T pop()
	{
		if(isEmpty())
			throw new NoSuchElementException("The Stack is Empty");
		return stack.removeLast();
	}
	
	/**
	 * Examines the element at the top of the stack. Throws an exception if the stack is empty.
	 * @return The element at the top of the stack.
	 */
	public T peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("The Stack is Empty");
		return stack.peekLast();
	}
	
	/**
	 * Determines if the stack is empty.
	 * @return True or False.
	 */
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	/**
	 * Determines the number of elements on the stack.
	 * @return An integer value.
	 */
	public int size()
	{
		return stack.size();
	}
	
	/**
	 * Returns a string representation of the stack.
	 */
	public String toString()
	{
		return stack.toString();
	}
	
	/**
	 * Testing of the LinkedListStack class
	 * @param args
	 */
	public static void main(String[] args)
	{
		LinkedListStack<Integer> test = new LinkedListStack<Integer>();
		System.out.println("QUESTION 1: LinkedListStack test:\n");
		
		System.out.println("Push(1), push(2), push(3), push(4):");
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		System.out.println(test.toString());
		
		System.out.println("\npop(),pop():");
		test.pop();
		test.pop();
		System.out.println(test.toString());
		
		System.out.println("\npeek():");
		System.out.println(test.peek());
		
		System.out.println("\nisEmpty()");
		System.out.println(test.isEmpty());
		
		System.out.println("\nsize()");
		System.out.println(test.size());
		
	}
}

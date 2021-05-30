/********************************************************************************
 * DropOutStack.java                                                            *   
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#2 Question#2                                            *
 *                                                                              *
 * This class implements a drop-out-stack using links by modifying the given    *
 * LinkedStack code                                                             *
 ********************************************************************************/

public class DropOutStack<T> implements StackADT<T> 
{
	private int capacity;
	private int count;
	@SuppressWarnings("unused")
	private LinearNode<T> bottom;
	private LinearNode<T> top;
	private static final int DEFAULT = 10;
	
	/**
	 * Constructor that sets default capacity for drop out stack
	 * Only if no parameters are chosen
	 */
	public DropOutStack()
	{
		this(DEFAULT);
	}
	
	/**
	 * Constructs an empty drop out stack with a fixed capacity.
	 * Points to top and bottom nodes of the stack.
	 * @param max
	 */
	public DropOutStack(int max)
	{
		capacity = max;
		top = null;
		bottom = null;
		count = 0;
	}
	
	//Places an element on the top of the stack.
	public void push(T element) 
	{
		LinearNode<T> temp = new LinearNode<T>(element);
		
		//Case 1: When the stack is empty, top and bottom point to the same node.
		if(count ==0 )
		{
			bottom = temp;
			temp.setNext(top);
			top = temp;
			count++;
		}
		
		//Case 2: When the stack is full. New node is added bottom node is discarded.
		else if(count == capacity)
		{
			LinearNode<T> holder = null;
			
			for(int i=0;i<count-2;i++)
			{
				holder = top.getNext();
			}
			
			bottom = holder;
			temp.setNext(top);
			top = temp;
		}
		
		//Case 3: Stack is not empty or full. New node/element is added.
		else
		{
			temp.setNext(top);
			top = temp;
			count++;
		}
	}

	
	/**
	 * Removes the top element in the stack and returns it.
	 * Throws EmptyCollectionException if stack is empty
	 */
	public T pop() 
	{
		if (isEmpty())
			throw new EmptyCollectionException("stack");

		T result = top.getElement();
		top = top.getNext();
		count--;
		return result;
	}

	/**
	 * Returns the top element on the stack 
	 */
	public T peek() 
	{
		return top.getElement();
	}

	/**
	 * Determines if the stack is empty.
	 * Returns true if stack is empty. False otherwise.
	 */
	public boolean isEmpty() 
	{
		return(count==0);
	}

	/**
	 * Returns the the number of elements in the stack.
	 */
	public int size() 
	{
		return count;
	}
	
	/**
	 * Returns a vertical string representation of the stack
	 */
	public String toString()
	{
		String temp = "";
		LinearNode<T> holder = top;
		
		for(int i=0;i<count;i++)
		{
		temp = temp + "\n" + holder.getElement();
		holder = holder.getNext();
		}
		
		return temp;
	}
}

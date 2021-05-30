/********************************************************************************
 * CircularArrayDeque.java                                                      *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#2 Question#3                                            *
 *                                                                              *
 * This Class is an array implementation of a deque. It modified the            *
 * CircularArrayQueue class that was provided.                                  *
 ********************************************************************************/

public class CircularArrayDeque<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] deque; 

	/**
	 * Creates an empty deque using the specified capacity.
	 * @param initialCapacity the initial size of the circular array deque
	 */
	@SuppressWarnings("unchecked")
	public CircularArrayDeque(int initialCapacity)
	{
		front = rear = count = 0;
		deque = (T[]) (new Object[initialCapacity]);
	}

	/**
	 * Creates an empty deque using the default capacity.
	 */
	public CircularArrayDeque()
	{
		this(DEFAULT_CAPACITY);
	}    

	/**
	 * Adds the specified element to the rear of this deque, expanding
	 * the capacity of the deque array if necessary.
	 * @param element the element to add to the rear of the deque
	 */
	public void insertRear(T element)
	{
		if (size() == deque.length) 
			expandCapacity();

		deque[rear] = element;
		rear = (rear + 1) % deque.length;
		count++;
	}
	
	/**
	 * Adds the specified element to the front of this deque, expanding
	 * the capacity of the deque array if necessary.
	 * @param element the element to add to the front of the deque
	 */
	public void insertFront(T element)
	{
		if (size() == deque.length) 
			expandCapacity();
		
		if(deque[front] == null)
			deque[front] = element;
		
		else 
		{	
			front = Math.floorMod(front-1,deque.length);
			deque[front] = element;
		}
		
		count++;
	}

	/**
	 * Creates a new array to store the contents of this deque with
	 * twice the capacity of the old one.
	 */
	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		T[] larger = (T[]) (new Object[deque.length * 2]);

		for (int scan = 0; scan < count; scan++)
		{
			larger[scan] = deque[front];
			front = (front + 1) % deque.length;
		}

		front = 0;
		rear = count;
		deque = larger;
	}

	/**
	 * Removes the element at the front of this deque and returns a
	 * reference to it. 
	 * @return the element removed from the front of the deque
	 * @throws EmptyCollectionException  if the deque is empty
	 */
	public T deleteFront() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("deque");

		T result = deque[front];
		deque[front] = null;
		front = (front + 1) % deque.length;

		count--;

		return result;
	}
	
	/**
	 * Removes the element at the rear of this deque and returns a
	 * reference to it. 
	 * @return the element removed from the rear of the deque
	 * @throws EmptyCollectionException  if the deque is empty
	 */
	public T deleteRear() throws EmptyCollectionException
	{
		rear = (rear - 1) % deque.length;
		deque[rear] = null;
		count--;
		
		return null;
	}

	/** 
	 * Returns a reference to the element at the front of this deque.
	 * The element is not removed from the deque.  
	 * @return the first element in the front of the deque
	 * @throws EmptyCollectionException if the deque is empty
	 */
	public T getFront() throws EmptyCollectionException
	{
		if (isEmpty()) throw new EmptyCollectionException("deque");
		return deque[front];
	}
	
	/** 
	 * Returns a reference to the element at the rear of this deque.
	 * The element is not removed from the deque.  
	 * @return the element in the rear of the deque
	 * @throws EmptyCollectionException if the deque is empty
	 */
	public T getRear() throws EmptyCollectionException
	{
		if (isEmpty()) throw new EmptyCollectionException("deque");
		return deque[(rear - 1) % deque.length];
	}

	/**
	 * Returns true if this deque is empty and false otherwise.
	 * @return true if this deque is empty 
	 */
	public boolean isEmpty()
	{
		return (count==0);
	}
	
	/**
	 * Returns true if this deque is full and false otherwise.
	 * @return true if this deque is full
	 */
	public boolean isFull() 
	{
	return (size()==deque.length);	
	}

	/**
	 * Returns the number of elements currently in this deque.
	 * @return the size of the deque
	 */
	public int size()
	{
		return count;
	}

	/**
	 * Returns a string representation of this deque. 
	 * @return the string representation of the deque
	 */
	public String toString()
	{
		String holder = "[ ";

		for(int i=0;i<deque.length;i++)
		{
			holder = holder + deque[i] + " ";
		}
		
		holder = holder + "]";
		return holder;
	}
/*	
	public static void main(String[] args) {
		CircularArrayDeque shaan = new CircularArrayDeque(10);
		
		shaan.insertRear(1);
		shaan.insertRear(2);
		shaan.insertRear(3);
		shaan.insertRear(4);
		shaan.insertRear(5);
		shaan.insertRear(6);
		shaan.insertRear(7);
		shaan.insertRear(8);
		shaan.insertRear(9);
		shaan.insertRear(10);
		shaan.deleteFront();
		shaan.deleteFront();
		shaan.insertFront(11);
		shaan.insertFront(12);
		shaan.insertFront(13);
	
		
		//shaan.insertFront(10);
		//shaan.insertRear(9);
		//shaan.deleteFront();
		//shaan.deleteRear();
		System.out.println(shaan.toString());
		
		//System.out.println(shaan.getFront());
		System.out.println(shaan.size());
		//System.out.println(shaan.isEmpty());
		
		//System.out.println(shaan.size());
		
	}
	*//*	
	public static void main(String[] args) {
	CircularArrayDeque shaan = new CircularArrayDeque(10);
	
	shaan.insertRear(1);
	shaan.insertRear(2);
	shaan.insertRear(3);
	shaan.insertRear(4);
	shaan.insertRear(5);
	shaan.insertRear(6);
	shaan.insertRear(7);
	shaan.insertRear(8);
	shaan.insertRear(9);
	shaan.insertRear(10);
	shaan.deleteFront();
	shaan.deleteFront();
	shaan.insertFront(11);
	shaan.insertFront(12);
	shaan.insertFront(13);

	
	//shaan.insertFront(10);
	//shaan.insertRear(9);
	//shaan.deleteFront();
	//shaan.deleteRear();
	System.out.println(shaan.toString());
	
	//System.out.println(shaan.getFront());
	System.out.println(shaan.size());
	//System.out.println(shaan.isEmpty());
	
	//System.out.println(shaan.size());
	
}
*/
}

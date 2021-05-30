/********************************************************************************
 * ArrayHash.java                                                               *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#5 Question#3                                            *
 *                                                                              *
 * Array based implementation of a hash table. Uses open addressing with double *
 * hashing.                                                                     *
 * @param <T>                                                                   *
 ********************************************************************************/

public class ArrayHash 
{
	private final static double loadFactor = 0.80;
	private final static int initialCapacity = 31;
	private int currentCapacity;
	private HashNode[]hashTable;
	private int count;
	
	
	//Creates a hash table of size initialCapacity and load factor of 0.80.
	private ArrayHash()
	{
		hashTable = new HashNode[initialCapacity];
		currentCapacity = initialCapacity;
		count = 0;
	}
	
	//Creates a hash table of specified capacity and a load factor of 0.80.
	private ArrayHash(int capacity)
	{
		hashTable = new HashNode[capacity];
		currentCapacity = capacity;
		count = 0;
	}
	
	//Returns a string representation of the hash table.
	public String toString()
	{
		String holder = "";
		for(int i=0; i<currentCapacity;i++)
		{
			if(hashTable[i] != null)
			holder = holder + Integer.toString(hashTable[i].getssn()) + ":" + hashTable[i].getName() + "\n";
			
			else
				holder = holder + null + "\n";
			
		}
		return holder;
	}
	
	//Doubles the capacity of the hash table.
	public void doubleCapacity()
	{
		HashNode[] hashTableTemp = new HashNode[currentCapacity*2];
		
		for(int i=0; i<currentCapacity;i++)
		{
			hashTableTemp[i] = hashTable[i];
		}
		
		hashTable = hashTableTemp;
		currentCapacity = currentCapacity*2;
	}
	
	//Adds an element to the hash table.
	public void add(String name, int socialSecurityNumber)
	{
		float calcLoadFactor = ((float)count/currentCapacity);
		
		//Expands the capacity if needed
		if(calcLoadFactor > loadFactor)
			doubleCapacity();
		
		HashNode node = new HashNode(name,socialSecurityNumber);
		
		//Extracting last 4 digits
		int key = node.getssn() % 10000;
		
		//First hash function
		int hashCode = Math.abs(key)%currentCapacity;
		
		//coefficient for second hash function
		int i = 1;
		
		//Places node if spot on hash table is empty
		if(hashTable[hashCode] == null)
		{
			hashTable[hashCode] = node;
		}
	
		//Collision handling using second hash function
		else if (hashTable[hashCode] != null)
		{
			int secondKey = Integer.parseInt((""+node.getssn()).substring(0,3));
			
			//Second hash function
			int secondHashCode = Math.abs(secondKey)%currentCapacity;
			
			//Loop continues until an open spot on the hash table is found, or the index is out of bounds.
			while(true)
			{
				int equation = hashCode + (i*secondHashCode);
			
				if(hashTable[equation] != null)
				{
					i = i*2;
				}
				if(hashTable[equation] == null)
				{
					hashTable[equation] = node;
					break;
				}
				
			}
		}
		count++;
	}
	
	//Test cases of hash table
	public static void main(String[] args)
	{
		
		System.out.println("Test1: Adding people to Hash table in order:\n");
		ArrayHash test = new ArrayHash(5);
		
		test.add("bob", 111990000);
		test.add("shawn", 999990001);
		test.add("Leo", 999990002);
		test.add("Alex", 999990003);
		System.out.println(test.toString());
		
		
		System.out.println("Test2: Expanding capacity test:\n");
		ArrayHash test2 = new ArrayHash(5);
		test2.add("bob", 111990000);
		test2.add("shawn", 999990001);
		test2.add("Leo", 999990002);
		test2.add("Alex", 999990003);
		test2.add("Jane", 999990004);
		test2.add("Christina", 999990005);
		System.out.println(test2.toString());
		
		
		System.out.println("Test3: Collision Testing:\n");
		ArrayHash test3 = new ArrayHash(5);
		test3.add("bob", 111990000);
		test3.add("shawn", 999990001);
		test3.add("Leo", 999990002);
		test3.add("Alex", 999990003);
		test3.add("Jane", 999990004);
		test3.add("Christina", 999990005);
		test3.add("John", 11199006);
		test3.add("Patrick", 111990007);
		test3.add("Madi", 111990008);
		//Collisions
		test3.add("Joe", 111990008);
		test3.add("Alessia", 989990003);
		System.out.println(test3.toString());
	}
	
	
	
		
}

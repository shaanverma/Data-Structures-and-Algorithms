/********************************************************************************
 * Driver.java                                                                  *   
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#2 Questions:1,2,3,4                                     *
 *                                                                              *
 * This class shows tests of ArrayStack.java, DropOutStack.java, and            *
 * CircularArrayDeque.java.                                                     *
 ********************************************************************************/

public class Driver {

	public static void main(String[] args) 
	{
		
		//Testing the ArrayStack class
		System.out.println("###############################################################");
		System.out.println("TESTING OF THE ARRAYSTACK CLASS:\n");
		ArrayStack<Integer> test1 = new ArrayStack<Integer>(2);
		System.out.println("push(1), push(2), push(3), pop()");
		test1.isEmpty();
		test1.push(1); 
		test1.push(2);
		test1.push(3); 
		test1.pop();
		System.out.println("toString():");
		System.out.println(test1.toString());
		System.out.println("\nisEmpty():");
		System.out.println(test1.isEmpty());
		System.out.println("\npeek():");
		System.out.println(test1.peek());
		System.out.println("\nsize():");
		System.out.println(test1.size());
		System.out.println("\npop, pop");
		test1.pop();
		test1.pop();
		System.out.println("\nisEmpty():");
		System.out.println("\n" + test1.isEmpty());
		System.out.println("\nsize():");
		System.out.println(test1.size() + "\n");
		System.out.println("###############################################################");
		
		
		//Testing the DropOutStack class
		System.out.println("TESTING OF THE DROPOUTSTACK CLASS:\n");
		DropOutStack<Integer> test2 = new DropOutStack<Integer>(2);
		System.out.println("push(1), push(2), push(3), pop()");
		test2.isEmpty();
		test2.push(1); 
		test2.push(2);
		test2.push(3); 
		test2.pop();
		System.out.println("toString():");
		System.out.println(test2.toString());
		System.out.println("\nisEmpty():");
		System.out.println(test2.isEmpty());
		System.out.println("\npeek():");
		System.out.println(test2.peek());
		System.out.println("\nsize():");
		System.out.println(test2.size());
		System.out.println("\npop()");
		test2.pop();
		System.out.println("\nisEmpty():");
		System.out.println("\n" + test2.isEmpty());
		System.out.println("\nsize():");
		System.out.println(test2.size() + "\n");
		System.out.println("###############################################################");
		
		
		//Testing the CircularArrayDeque
		System.out.println("TESTING THE CircularArrayDeque CLASS\n");
		CircularArrayDeque<Integer> test3 = new CircularArrayDeque<Integer>(3);
		
		System.out.println("insertRear(1), insertRear(2), insertRear(3), insertRear(4)\n");
		test3.insertRear(1);
		test3.insertRear(2);
		test3.insertRear(3);
		test3.insertRear(4);
		System.out.println("toString:\n");
		System.out.println(test3.toString());
		
		System.out.println("insertFront(5), insertFront(6), insertFront(7)\n");
		test3.insertFront(5);
		test3.insertFront(6);
		test3.insertFront(7);
		System.out.println(test3.toString() + "\n");
		
		System.out.println("deleteFront(), deleteFront(), deleteRear(), deleteRear()\n");
		test3.deleteFront();
		test3.deleteFront();
		test3.deleteRear();
		test3.deleteRear();
		
		System.out.println(test3.toString() + "\n");
		
		System.out.println("getFront:\n");
		System.out.println(test3.getFront() + "\n");
		
		System.out.println("getRear:\n");
		System.out.println(test3.getRear() + "\n");

		System.out.println("isEmpty:\n");
		System.out.println(test3.isEmpty() + "\n");
		
		System.out.println("isFull:\n");
		System.out.println(test3.isFull() + "\n");
		
		System.out.println("size:\n");
		System.out.println(test3.size() + "\n");
		System.out.println("###############################################################");
		
	}

}

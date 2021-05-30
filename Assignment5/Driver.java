/********************************************************************************
 * Driver.java                                                                  *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#5 Question#2                                            *
 *                                                                              *
 *Driver class that tests out Graph.java                                        *
 ********************************************************************************/

/**
 * Test for some Graph.java methods
 * @author shaan
 *
 */
public class Driver {

	public static void main(String[] args) {
		Graph<String> test = new Graph<String>();
		
		
		test.addVertex("A");
		test.addVertex("B");
		test.addVertex("C");
		test.addVertex("D");
		
		test.addEdge("A", "B");
		test.addEdge("B", "C");
		test.addEdge("C", "D");
		test.addEdge("D", "A");
		System.out.println(test.toString());
		
		System.out.println("\ngetIndex():");
		System.out.println(test.getIndex("B"));
		
		System.out.println("\nisConnected():");
		System.out.println(test.isConnected());
		
		System.out.println("\nisEmpty():");
		System.out.println(test.isEmpty());
		
		System.out.println("\nsize():");
		System.out.println(test.size());
		
		System.out.println("\nremoveEdge('C','D'), removeVertex('C'):\n");
		
		test.removeEdge("C", "D");
		test.removeVertex("C");
		
		System.out.println(test.toString());
		
		

	}

}

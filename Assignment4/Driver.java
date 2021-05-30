/********************************************************************************
 * Driver.java                                                                  *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#4 Q1                                                    *
 *                                                                              *
 * Shows tests of the traversals in LinkedBinaryTree.java                       *
 ********************************************************************************/
public class Driver {

	public static void main(String[] args) {
		
		
		//Creating tree nodes
		LinkedBinaryTree<Integer> test8 = new LinkedBinaryTree<Integer>(8);
		LinkedBinaryTree <Integer> test9 = new LinkedBinaryTree<Integer>(9);
		LinkedBinaryTree <Integer>test10 = new LinkedBinaryTree<Integer>(10);
		LinkedBinaryTree <Integer>test11 = new LinkedBinaryTree<Integer>(11);
		LinkedBinaryTree <Integer>test12 = new LinkedBinaryTree<Integer>(12);
		LinkedBinaryTree <Integer>test13 = new LinkedBinaryTree<Integer>(13);
		LinkedBinaryTree <Integer>test14 = new LinkedBinaryTree<Integer>(14);
		LinkedBinaryTree <Integer>test15 = new LinkedBinaryTree<Integer>(15);
		
		//Making Left sub tree
		LinkedBinaryTree<Integer> leftSub1 = new LinkedBinaryTree<Integer>(4,test8,test9);
		LinkedBinaryTree <Integer>leftSub2 = new LinkedBinaryTree<Integer>(5,test10,test11);
		LinkedBinaryTree <Integer>leftSub0 = new LinkedBinaryTree<Integer>(2,leftSub1, leftSub2);
		
		//Making right sub tree
		LinkedBinaryTree <Integer>rightSub1 = new LinkedBinaryTree<Integer>(6,test12,test13);
		LinkedBinaryTree <Integer>rightSub2 = new LinkedBinaryTree<Integer>(7,test14, test15);
		LinkedBinaryTree <Integer>rightSub0 = new LinkedBinaryTree<Integer>(3,rightSub1,rightSub2);
		
		//Combining right and left sub trees
		LinkedBinaryTree <Integer> myTree= new LinkedBinaryTree<Integer>(1,leftSub0,rightSub0);
		
		
		ArrayUnorderedList<Integer>preOrder = new ArrayUnorderedList<Integer>();
		ArrayUnorderedList<Integer>postOrder = new ArrayUnorderedList<Integer>();
		
		myTree.preOrder(myTree.getRootNode(), preOrder);
		myTree.postOrder(myTree.getRootNode(), postOrder);
		
		System.out.println("PreOrder Traversal:");
		System.out.println(preOrder + "\n");
		System.out.println("postOrder Traversal:");
		System.out.println(postOrder + "\n");
		System.out.println("inOrder Traversal:");
		System.out.println(myTree.toString());
	}
}

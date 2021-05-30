/********************************************************************************
 * HeapSort.java                                                                *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#5 Question#1                                            *
 *                                                                              *
 * This class is an implementation of a more efficient heapSort algorithm, that *
 * utilizes the array to be sorted to build the minheap in place.               *
 ********************************************************************************/


public class HeapSort<T>
{
	/**
	 * Sorts the specified array using a minheap
	 *
	 * @param data the data to be added to the heapsort
	 */
	public static void heapSort(int[] data) 
	{
		for(int i=0; i<data.length;i++)
		{
			buildHeap(data, i);
		}
	}
	
	/**
	 * Builds an array into a heap with the smallest element at the root.
	 * @param arr the array to be built into a heap.
	 * @param shift the starting index of the array.
	 */
	private static void buildHeap(int arr[], int shift) 
    { 
		
		//Length of the specific range of array
		int n = arr.length - shift;
		
		//Index of last non-leaf node 
		int start = (n / 2) - 1 + shift;
		
		//Replacing original value of length
		n = n + shift;
		
       //Iterates through non-leaf nodes, swapping for the smallest values. 
        while(start >= shift)
        {
        	
        	//Finding indices of left and right children
            int l = 2 * start + 1 - shift;
            int r = 2 * start + 2 - shift;
        	
        	
	        // If left child is smaller than parent node, swap values. 
	        if (l < n && arr[l] < arr[start])
	        {
	        	
	        	int swap = arr[start];
	        	arr[start] = arr[l];
	        	arr[l] = swap;
	        }
	        	
	  
	        // If right child is smaller than parent node, swap values.
	        if (r < n && arr[r] < arr[start]) 
	        {
	        	int swap = arr[start];
	    		arr[start] = arr[r];
	    		arr[r] = swap; 
	        }
	        
	        start--;	        
        }
    } 

    
    
    /**
     * Test code for modified HeapSort algorithm
     * @param args
     */
    public static void main(String args[]) 
    { 
    
        // Binary Tree Representation of input array:
        //              20
        //           /      \ 
        //         44        5 
        //       /    \    /   \
        //      3      8  1     99
 
    			
    	System.out.println("Original Array: 20 40 5 3 8 1 99");		
        int arr[] = { 20,44, 5, 3, 8,1, 99};
        int n = arr.length;
        heapSort(arr);
        System.out.println("Array representation of HeapSort is:");
        
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
        
    } 
	
	
	
	
	
	
	
	
	
	
	
}
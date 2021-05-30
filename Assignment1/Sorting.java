/*********************************************************************************
 * Sorting.java                                                                  *
 *                                                                               *
 * SHAAN VERMA T00648791                                                         *
 *                                                                               *
 * COMP 2231 ASSIGNMENT#1 Question#2                                             *
 *                                                                               *
 * This class contains static implementations of selection sort, insertion sort, *
 * bubble sort, quick sort and merge sort. And calculates the execution time and *
 * comparisons made for each one. It also has a main method, that tests the      *
 * algorithms with several different lists(commented out).                       *
 *********************************************************************************/

//Imported for test cases
import java.util.Arrays;

public class Sorting 
{
	//Keeps track of the number of comparisons made.
	 static int compCounter;
	
		
	/**
	 * Sorts the specified array of integers using the selection
	 * sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void selectionSort(T[] data)
	{
		//Records the start time of the selection sort algorithm.
		long startTime = System.nanoTime();
		int min;
		
		for (int index = 0; index < data.length - 1; index++)
		{
			min = index;
			for (int scan = index + 1; scan < data.length; scan++)
			{
				if (data[scan].compareTo(data[min]) < 0)
					min = scan;
				
				//Increases the comparison counter by 1.
				compCounter++;
			}
			swap(data, min, index);
		}
		
		//Records the end time of the selection sort algorithm.
		long endTime = System.nanoTime();
		
		//Prints the # of comparisons and calculated execution time.
		System.out.println("SELECTION SORT");
		System.out.println("Number of Comparisions:" + compCounter);
		System.out.println("Execution Time:" + (endTime-startTime) + "ns\n");
		
		//Resets the comparison counter to zero.
		compCounter = 0;
	}
	

	/**
	 * Swaps two elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> 
	void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	/**
	 * Sorts the specified array of objects using an insertion
	 * sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void insertionSort(T[] data)
	{
		//Records the start time of the insertion sort algorithm.
		long startTime = System.nanoTime();
		
		for (int index = 1; index < data.length; index++)
		{
			T key = data[index];
			int position = index;
			// shift larger values to the right 
			while (position > 0 && data[position-1].compareTo(key) > 0)
			{
				//Increases comparison counter by 1.
				compCounter++;
				data[position] = data[position - 1];
				position--;
			}
			
			//Accommodates for the comparison made when the while loop is exited
			compCounter++;

			data[position] = key;
		}
		//Records the end time of the insertion sort algorithm.
		long endTime = System.nanoTime();
		
		//Prints the # of comparisons and calculated execution time.
		System.out.println("INSERTION SORT");
		System.out.println("Number of Comparisions:" + compCounter);
		System.out.println("Execution Time:" + (endTime-startTime) + "ns\n");
		
		//Resets the comparison counter to zero.
		compCounter = 0;
	}

	/**
	 * Sorts the specified array of objects using a bubble sort
	 * algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void bubbleSort(T[] data)
	{
		//Records the start time of the bubble sort algorithm.
		long startTime = System.nanoTime();
		int position, scan;

		for (position =  data.length - 1; position >= 0; position--)
		{
			for (scan = 0; scan <= position - 1; scan++)
			{
				if (data[scan].compareTo(data[scan + 1]) > 0)
					swap(data, scan, scan + 1);
				//Increments comparison counter by 1.
				compCounter++;
			}
		}
		
		//Records the end time of the bubble sort algorithm.
		long endTime = System.nanoTime();
		
		//Prints the # of comparisons and calculated execution time.
		System.out.println("BUBBLE SORT");
		System.out.println("Number of Comparisions:" + compCounter);
		System.out.println("Execution Time:" + (endTime-startTime) + "ns\n");
		
		//Resets the comparison counter to zero.
		compCounter = 0;
	}

	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
	void quickSort(T[] data)
	{	
		//Records the start time of the quick sort algorithm.
		long startTime = System.nanoTime();
		quickSort(data, 0, data.length - 1);
		
		//Records the end time of the quick sort algorithm.
		long endTime = System.nanoTime();
		
		//Prints the # of comparisons and calculated execution time.
		System.out.println("QUICK SORT");
		System.out.println("Number of Comparisions:" + compCounter);
		System.out.println("Execution Time:" + (endTime-startTime) + "ns\n");
		
		//Resets the comparison counter to zero.
		compCounter = 0;
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm. 
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> 
	void quickSort(T[] data, int min, int max)
	{
		
		if (min < max)
		{
			// create partitions
			int indexofpartition = partition(data, min, max);
			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);
			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
			

		}
		
	}

	/**System.out.println("Number of Comparisions:" + count);
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the  range to be sorted
	 */
	private static <T extends Comparable<T>> 
	int partition(T[] data, int min, int max)
	{	
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;

		// use the middle data value as the partition element
		partitionelement = data[middle];
		
		// move it out of the way for now
		swap(data, middle, min);

		left = min;
		right = max;

		while (left < right)
		{

			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0)
			{
				left++;
				
				//Increments comparison counter by 1.
				compCounter++;
			}
			
			//Accommodates for comparison when while loop is exited.
			compCounter++;
			
			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
			{	
				right--;
				
				//Increments comparison counter by 1.
				compCounter++;
			}
			
			//Accommodates for comparison when while loop is exited.
			compCounter++;
			
			// swap the elements
			if (left < right) 
			{
				swap(data, left, right);
			}
		
			
		}
		
		// move the partition element into place
		swap(data, min, right);

		return right;
	}
	
	/**
	 * Sorts the specified array of objects using the merge sort
	 * algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>>
	void mergeSort(T[] data)
	{
		//Records the start time of the merge sort algorithm.
		long startTime = System.nanoTime();
		mergeSort(data, 0, data.length - 1);
		
		//Records the end time of the merge sort algorithm.
		long endTime = System.nanoTime();
		
		//Prints the # of comparisons and calculated execution time.
		System.out.println("MERGE SORT");
		System.out.println("Number of Comparisions:" + compCounter);
		System.out.println("Execution Time:" + (endTime-startTime) + "ns\n");
		
		//Resets the comparison counter to zero.
		compCounter = 0;
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
	 *
	 * @param data the array to be sorted
	 * @param min  the index of the first element 
	 * @param max  the index of the last element
	 */
	private static <T extends Comparable<T>>
	void mergeSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
		}
	}

	/**
	 * Merges two sorted subarrays of the specified array.
	 *
	 * @param data the array to be sorted
	 * @param first the beginning index of the first subarray 
	 * @param mid the ending index fo the first subarray
	 * @param last the ending index of the second subarray
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>>
	void merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[])(new Comparable[data.length]);

		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid + 1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array

		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
			
			//Increments comparison counter by 1.
			compCounter++;
		}

		//  Copy remaining elements from first sub-array, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}

		//  Copy remaining elements from second sub-array, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}

		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
	}

	/*
	public static void main(String[] args) 
	{
		
		// Test arrays
		Integer[] list0 = {};
		Integer[] list1 = {0};
		Integer[] list2 = {-1934,-53,-9949,-354,-2999,-4};
		Integer[] list3 = {1,2,3,4,5,6,7,8,9,10};
		Integer[] list4 = {10,9,-8,7,6,5,4,3,2,1,0};
		Double[] list5 = {4.5,-9.43,2.002,1.034,-3.14};
		
		//Testing list0
		Sorting.selectionSort(Arrays.copyOf(list0,0));
		Sorting.insertionSort(Arrays.copyOf(list0,0));
		Sorting.bubbleSort(Arrays.copyOf(list0,0));
		Sorting.quickSort(Arrays.copyOf(list0,0));
		Sorting.mergeSort(Arrays.copyOf(list0,0));
		
		//Testing list1
		Sorting.selectionSort(Arrays.copyOf(list1,1));
		Sorting.insertionSort(Arrays.copyOf(list1,1));
		Sorting.bubbleSort(Arrays.copyOf(list1,1));
		Sorting.quickSort(Arrays.copyOf(list1,1));
		Sorting.mergeSort(Arrays.copyOf(list1,1));
		
		//Testing list2
		Sorting.selectionSort(Arrays.copyOf(list2,6));
		Sorting.insertionSort(Arrays.copyOf(list2,6));
		Sorting.bubbleSort(Arrays.copyOf(list2,6));
		Sorting.quickSort(Arrays.copyOf(list2,6));
		Sorting.mergeSort(Arrays.copyOf(list2,6));
		
		//Testing list3
		Sorting.selectionSort(Arrays.copyOf(list3,10));
		Sorting.insertionSort(Arrays.copyOf(list3,10));
		Sorting.bubbleSort(Arrays.copyOf(list3,10));
		Sorting.quickSort(Arrays.copyOf(list3,10));
		Sorting.mergeSort(Arrays.copyOf(list3,10));
		
		//Testing list4
		Sorting.selectionSort(Arrays.copyOf(list4,11));
		Sorting.insertionSort(Arrays.copyOf(list4,11));
		Sorting.bubbleSort(Arrays.copyOf(list4,11));
		Sorting.quickSort(Arrays.copyOf(list4,11));
		Sorting.mergeSort(Arrays.copyOf(list4,11));
		
		//Testing list5
		Sorting.selectionSort(Arrays.copyOf(list5,5));
		Sorting.insertionSort(Arrays.copyOf(list5,5));
		Sorting.bubbleSort(Arrays.copyOf(list5,5));
		Sorting.quickSort(Arrays.copyOf(list5,5));
		Sorting.mergeSort(Arrays.copyOf(list5,5));
		
	}
	*/
	
}








/********************************************************************************
 * ShellArray.java                                                              *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#1 Question#1                                            *
 *                                                                              *
 * This class populates an array of random integers specified by the user,      *
 * and implements the shell sort algorithm.                                     *
 ********************************************************************************/


//Importing array and math packages.
import java.lang.Math;
import java.util.Arrays;

public class ShellArray 
{
	//Declaring instance variables and constants.
	private int[] elementArray;
	private int size;
	private static final int MAX = 1000;
	private static final int MIN = 0;

	//Constructor creates and populates an array of random integers based on parameter passed.
	public ShellArray(int arraySize)
	{
		size = arraySize;
		elementArray = new int[arraySize];
			
		for(int i = 0;i<arraySize;i++)
		{
			//Generates a random integer between MAX and MIN.
			int random = (int)(Math.random() * MAX) + MIN;
			elementArray[i] = random;
		}	
	}
	
	//Swaps two elements in the elementArray given their indices.	
	public void swap(int index1, int index2) 
	{
		int holder = elementArray[index1];
		elementArray[index1] = elementArray[index2];
		elementArray[index2] = holder;
	
	}
	
	//Converts and returns elementArray to a string type. 
	public String toString() 
	{
		return Arrays.toString(elementArray);
	}
	
	//Implements the shell sort algorithm from the pseudo code given
	public void shellSort() 
	{
		int gap = size/2;
		
		while(gap>0) 
		{
			boolean swapflag = true;		
			while(swapflag == true) 
			{
				swapflag = false;
				for(int s=0; s<(size-gap);s++) 
				{
					if(elementArray[s] > elementArray[s+gap]) 
					{
						swap(s,s+gap);
						swapflag = true;
					}
				}
			}
			gap = gap/2;	
		}
	}
}

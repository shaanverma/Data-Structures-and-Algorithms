/****************************************************************************************
 * Driver.java                                                                          *
 *                                                                                      *
 * SHAAN VERMA T00648791                                                                *
 *                                                                                      *
 * COMP 2231 ASSIGNMENT#1 Question#1                                                    *
 *                                                                                      *
 * This is a driver class that tests the shellSort method from the ShellArray class.    *
 * It instantiates and sorts several different arrays of different sizes.               *
 ****************************************************************************************/

public class Driver 
{	
	public static void main(String[] args) 
	{
		for(int i=0;i<10;i++) 
		{
			ShellArray test = new ShellArray(i);
			test.shellSort();
			System.out.println(test.toString());
		}
	}
}

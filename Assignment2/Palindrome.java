/********************************************************************************
 * Palindrome.java                                                              *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#2 Question#4                                            *
 *                                                                              *
 * This program uses a stack and a queue to determines if the user's input is   *
 * a palindrome.                                                                *
 ********************************************************************************/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * This class takes a string as a parameter, parses it, and places the individual
 * characters into both a stack and a queue.
 */
public class Palindrome 
{
	//Instance variables defining the data structures to be used.
	private String word;
	private Stack<Character> stack = new Stack<Character>();
	private Queue<Character> queue = new LinkedList<Character>();
	
	//Constructor places the individual characters of the word into both a stack and queue.
	public Palindrome(String element)
	{
		word = element;
		for (int i = 0; i < word.length(); i++)
		{
			char holder = word.charAt(i);
			stack.push(holder);
			queue.offer(holder);
		}
	}

	//Method tests whether a the word is a palindrome by comparing characters in the stack and queue
	//Returns true or false
	public boolean palindromeTest()
	{
		for (int i = 0; i < word.length(); i++)
		{
			if(stack.pop() != queue.remove())
			{
				return false;
			}
		}
		return true;
	}
	
	//Creates a interactive program for the user to input their words to check if they are palindromes.
	public static void main(String[] args) 
	{
		while(true)
		{
			@SuppressWarnings("resource")
			Scanner stringObject = new Scanner(System.in);
			System.out.println("Enter A Word (Type EXIT to leave):");
			String testWord = stringObject.nextLine();
			
			if(testWord.contentEquals("EXIT"))
				System.exit(0);
		    
			Palindrome test = new Palindrome(testWord);
			System.out.println(test.palindromeTest());
		}
	}
}

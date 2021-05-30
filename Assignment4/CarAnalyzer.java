/********************************************************************************
 * CarAnalyzer.java                                                             *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#4 Question#1                                            *
 *                                                                              *
 * This class is an application to a decision tree. It diagnoses car problems   *
 ********************************************************************************/

import java.io.*;

/**
 * CarAnalyzer demonstrates the use of a binary decision tree to 
 * diagnose your car.
 */
public class CarAnalyzer {
	/**
	 *  Asks questions of the user to diagnose a car problem.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Welcome to virtual Garage!");

		DecisionTree expert = new DecisionTree("car.txt");
		expert.evaluate();
	}

}



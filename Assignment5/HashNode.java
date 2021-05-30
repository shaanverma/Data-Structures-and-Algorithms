/********************************************************************************
 * HashNode.java                                                               *
 *                                                                              *
 * SHAAN VERMA T00648791                                                        *
 *                                                                              *
 * COMP 2231 ASSIGNMENT#5 Question#3                                            *
 *                                                                              *
 * This class creates a node that contains a persons name and social security   *
 * number. Used for the ArrayHash class.                                        *                                    *
 *                                                                              *
 * @param <T>                                                                   *
 ********************************************************************************/


/**
 * HashNode.java
 * @author shaan
 *
 */
public class HashNode {
	
	//Instance variables social securtiy number (ssc)
	private int ssn;
	private String name;
	
	/**
	 * Creates an empty HashNode
	 */
	@SuppressWarnings("null")
	HashNode()
	{
		ssn = (Integer) null;
		name = null;
	}
	
	/**
	 * Creates a HashNode containing name and social security number.
	 * @param personName The name of the person.
	 * @param socialSecurityNumber The social security number of a person.
	 */
	HashNode(String personName, int socialSecurityNumber)
	{
		name = personName;
		ssn = socialSecurityNumber;
	}
	
	/**
	 * Gets the social security number.
	 * @return ssn
	 */
	public int getssn()
	{
		return ssn;
	}
	
	/**
	 * Gets the name of the person.
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the social security number.
	 * @param element
	 */
	public void setssc(int element)
	{
		ssn = element;
	}
	
	/**
	 * Sets the name of the person.
	 * @param element
	 */
	public void setName(String element)
	{
		name = element;
	}
	
}

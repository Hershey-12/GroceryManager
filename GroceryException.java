package Grocery;
/*
 * @author: Harshitha Komaravelli
 * @version 12/10/2021
 * 
 * Class Description:
 * Handles the GroceryException when thrown by other classes 
 */
public class GroceryException extends Exception{
	/*
	 * No argument constructor that calls the super class.
	 */
	public GroceryException() {
		super();
	}

	/*
	 * @param message a String that will print
	 * Constructor that will accept a String and calls upon
	 * the super class to print it.
	 */
	public GroceryException(String message) {
		super(message);
	}


}

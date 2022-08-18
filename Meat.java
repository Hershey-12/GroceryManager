package Grocery;
/*
 * @author: Harshitha Komaravelli
 * @version 12/10/2021
 * 
 * Class Description:
 * The Meat class is a child class of GroceryItem, so therefore it 
 * inherits all of GroceryItem's public methods, and can call GroceryItem
 * constructor using super(). Has the private instance variable isGround, a 
 * constructor, and two overridden methods: toString() and comapreTo().
 */
public class Meat extends GroceryItem {
	private boolean isGround;

	/*
	 * @param name
	 * @param quantity
	 * @param price
	 * @param isGround
	 * calls the super constructor to set name, quantity, and price.
	 * calls setIsGround() to set the instance variable isGround.
	 */
	public Meat(String name, int quantity, double price, boolean isGround) {
		super(name, quantity, price);
		setIsGround(isGround);
	}
	
	/*
	 * @param isGround
	 * Sets this.isGround to isGround.
	 */
	public void setIsGround(boolean isGround) {
		this.isGround = isGround;		
	}

	/*
	 * @return this.isGround().
	 */
	public boolean getIsGround() {
		return this.isGround;
	}
	
	@Override
	/*
	 * @return a formatted String.
	 * Formats a String using String.format().
	 * Calls on the super toString() to give it the formatted version 
	 * that has name, quantity and price, adds getIsGrounded and returns it.
	 */
	public String toString() {
		String retVal = String.format("%sGround: %s", super.toString(), this.getIsGround());
		return retVal;
	}
	
	@Override
	/*
	 * @param o
	 * @return integer representing the comparison
	 * calls the super compareTo() to make the comparison
	 * and returns the value returned by the compareTo() in the
	 * super class.
	 */
	public int compareTo(Object o) {
			return super.compareTo(o);
		
	}

}

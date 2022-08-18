package Grocery;
/*
 * @author: Harshitha Komaravelli
 * @version 12/10/2021
 * 
 * Class Description:
 * The Produce class is a child class of GroceryItem, so therefore it 
 * inherits all of GroceryItem's public methods, and can call GroceryItem
 * constructor using super(). Has the private instance variable isOrganic, a 
 * constructor, and two overridden methods: toString() and comapreTo().
 */
public class Produce extends GroceryItem {
	private boolean isOrganic;
	/*
	 * @param name
	 * @param quanity
	 * @param price
	 * @param isOrganic
	 * Constructor that calls the super constructor in GroceryItem, to set name,
	 * quantity and price. Calls setIsOrganic() to set the instance variable
	 * isOrganic.  
	 */
	public Produce(String name, int quantity, double price, boolean isOrganic) {
		super(name, quantity, price);
		setIsOrganic(isOrganic);
	}
	
	/*
	 * @param isOrganic
	 * sets this.isOrganic
	 */
	public void setIsOrganic(boolean isOrganic) {
		this.isOrganic = isOrganic;
	}
	
	/*
	 * @return this.isOrganic
	 */
	public boolean getIsOrganic() {
		return this.isOrganic;
	}
	
	@Override
	/*
	 * @return a formatted String.
	 * Formats a String using String.format().
	 * Calls on the super toString() to give it the formatted version 
	 * that has name, quantity and price, adds getIsOrganic and returns it.
	 */
	public String toString() {
		String retVal = String.format("%sOrganic: %s", super.toString(), this.getIsOrganic());
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

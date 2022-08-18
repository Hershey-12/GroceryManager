package Grocery;
/*
 * @author: Harshitha Komaravelli
 * @version 12/10/2021
 * 
 * Class Description: 
 * The Dairy class is a child class of GroceryItem, so therefore it 
 * inherits all of GroceryItem's public methods, and can call GroceryItem
 * constructor using super(). Has the private instance variable 
 * refreigerationTemperature, a constructor, and two 
 * overridden methods: toString() and comapreTo().
 * 
 */
public class Dairy extends GroceryItem {
	private int refreigerationTemperature;
	/*
	 * @param name
	 * @param quantity
	 * @param price
	 * @param refreigerationTemperature
	 * 
	 * Calls the super constructor in GroceryItem, to set name, quantity and price.
	 * Calls setRefrigerationTemperature() to set the refreigerationTemperature.    
	 */
	public Dairy(String name, int quantity, double price, int refreigerationTemperature) {
		super(name, quantity, price);
		setRefrigerationTemperature(refreigerationTemperature);
	}
	/*
	 * @param temp
	 * sets this.refreigerationTemperature to temp.
	 */
	public void setRefrigerationTemperature(int temp) {
		this.refreigerationTemperature = temp;
	}
	
	/*
	 * @return this.refreigerationTemperature.
	 */
	public int getRefrigerationTemperature() {
		return this.refreigerationTemperature;
	}
	
	@Override
	/*
	 * @return a formatted String.
	 * Formats a String using String.format().
	 * Calls on the super toString() to give it the formatted version 
	 * that has name, quantity and price, adds the temperature and returns it.
	 */
	public String toString() {
		String retVal = String.format("%sTemperature: %s", super.toString(), this.getRefrigerationTemperature());
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

package Grocery;
/*
 * @author: Harshitha Komaravelli
 * @version 12/10/2021
 * 
 * Class Description:
 * An abstract class that implements the Comparable interface.
 * Has the instance variables name, price and quantity. Contains
 * getters and setters for each instance variable and has two overridden 
 * public methods toString() and compareTo(). All public methods are inherited 
 * by subclasses which are: Dairy, Produce, and Meat.
 */
public abstract class  GroceryItem implements Comparable {
	private String name;
	private double price;
	private int quantity;

	/*
	 * @param name
	 * @param quantity
	 * @param price
	 * Constructor to set name quantity and price
	 */
	public GroceryItem(String name, int quantity, double price) {
		setName(name);
		setPrice(price);
		setQuantity(quantity);
	}

	/*
	 * No-arg constructor
	 */
	public GroceryItem() {}

	/*
	 * @param name
	 * Sets the private instance variable name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @return this.name
	 * returns the private instance variable name
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * @param price
	 * sets the private instance variable price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * @return this.price
	 * returns the private instance variable price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/*
	 * @param n
	 * sets the private instance variable quantity
	 */
	public void setQuantity(int n) {
		this.quantity = n;
	}
	
	/*
	 * @return this.quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	@Override
	/*
	 * @return A formated String of the Name, Quantity, and Price in columns
	 * and aligned.
	 */
	public String toString() {
		String retVal = String.format("Name: %-19sQuantity: %-8sPrice: $%5.2f ", 
				this.getName(), this.getQuantity(), this.getPrice());
		return retVal;
	}
	@Override
	/*
	 * @param o
	 * @return an integer representing the comparison
	 * Compares this GroceryItem to the other object using  the String method
	 * compareToIgnoreCase(). 
	 * 
	 */
	public int compareTo(Object o) {
		GroceryItem other = (GroceryItem) o;
		return this.getName().compareToIgnoreCase(other.getName());
	}
}

package Grocery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
 * @author: Harshitha Komaravelli
 * @version 12/10/2021
 * 
 * Class Description:
 * Manages a "Grocery store", loads an initial inventory and processes orders
 * from given files. It subtracts items as they are ordered, and adds existing
 * items into a restockingList after they reach 0. If an item is ordered 
 * that does not exist a message is printed out. GroceyMangaer can also
 * sort the inventory by name or by price. Contains the instance variables
 * inventory, and restockingList. 
 * 
 */
public class GroceryManager{
	private ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>(); 
	private HashSet<String> restockingList = new HashSet<String>();

	/*
	 * @param filename, file containing the inventory formatted correctly
	 * Uses a scanner to read the file line by line. On each line the 
	 * Class type, name, quantity, price, and a "detail" specific to 
	 * that class are included. checkClassAndAdd() is called to
	 * check what class is being created. If the file of filename
	 * cannot be found in the directory a FileNotFoundException is
	 * thrown. 
	 */
	public void loadInventory(String filename) {
		File file = new File(filename);
		try {
			Scanner reader = new Scanner(file);
			reader.nextLine();
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				Scanner lineReader = new Scanner(line);
				String item = lineReader.next();
				String name = lineReader.next();
				int quantity = Integer.parseInt(lineReader.next());
				Double price = Double.parseDouble(lineReader.next());
				String detail = lineReader.next();
				checkClassAndAdd(item, name, quantity, price, detail);
			}
			reader.close();
		}catch(FileNotFoundException e) {
			System.out.println("Cannot find file");
		}

	}

	/*
	 * @param item
	 * @param name
	 * @param quanity
	 * @param price
	 * @param detail 
	 * checkClassAndAdd() uses a series of if statements to check 
	 * what type of GroceryItem to create If the item matches a 
	 * possible class then the name, quantity, price, and detail
	 * are used to create an item of that type and are added to
	 *  the inventory ArrayList.
	 */
	private void checkClassAndAdd(String item, String name, int quantity, double price, String detail) {
		if(item.equals("Produce")) {
			inventory.add(new Produce(name, quantity, price,Boolean.parseBoolean(detail)));
		}else if(item.equals("Meat")) {
			inventory.add(new Meat(name, quantity, price,Boolean.parseBoolean(detail)));
		}else if(item.equals("Dairy")) {
			inventory.add(new Dairy(name, quantity, price,Integer.parseInt(detail)));
		}
	}

	/*
	 * @param order, an ArrayList of orders that are of type GorceryItem.
	 * processOrder() will throw a GroceryException in the case that 
	 * the item does not exist in the inventory. processOrder() uses 
	 * a for loop to iterate through the order ArrayList, and calls  
	 * changeInventory() to change the number of items in the inventory. 
	 */
	public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {
		//	try {
		for(int index = 0; index < order.size(); index ++) {
			GroceryItem orderItem = order.get(index);
			try {
				changeInventory(orderItem);
			}catch(GroceryException e) {
				System.out.println("could not find item in inventory");
			}
		}
	}
	/*
	 * @param orderItem
	 * changeInventory() will throw a GroceryException if the ordered item 
	 * does not exist in the inventory. First the name, and quantity of the 
	 * ordered item are retrieved. If the orderedItem does not exist
	 * a GroceryException s thrown. If the orderedItem is found in inventory
	 * then the quantity of that item is reduced according to the ordered quantity.
	 * If the quantity of the item is already 0 then that item is added to the 
	 * restockingList.If the amount ordered is greater than what is available
	 * the item is added to the restockingList, and a message is printed out.
	 *  
	 */
	private void changeInventory(GroceryItem orderItem) throws GroceryException {
		String orderName = orderItem.getName();
		int orderQuantity = orderItem.getQuantity();
		GroceryItem thisItem = findItemByName(orderName);
		if(thisItem == null) {
			throw new GroceryException(thisItem + " not found ");
		}else {
			int indexOfItem = inventory.indexOf(thisItem);
			int newQuantity = thisItem.getQuantity() - orderQuantity;
			if(indexOfItem >= 0) {

				if(newQuantity < 0) {
					System.out.println("Out of " + thisItem.getName());
					newQuantity = 0;
				}if(newQuantity == 0) {
					restockingList.add(thisItem.getName());
				}
				thisItem.setQuantity(newQuantity);
				inventory.remove(indexOfItem);
				inventory.add(indexOfItem, thisItem);
			}else{
				throw new GroceryException();

			}
		}
	}

	/*
	 * @param name, the String that is being searched for
	 * @return the class of the item with  the target name.
	 * findItemByName() uses a for loop to traverse through
	 * the inventory to find a GroceryItem that has a name 
	 * that matches the name being searched for. If the target
	 * name cannot be found null is returned
	 */
	public GroceryItem findItemByName(String name) {
		for(int index = 0; index < inventory.size(); index++) {
			GroceryItem thisItem = inventory.get(index);
			if(thisItem.getName().equals(name)) {
				return thisItem;
			}
		}
		return null;

	}
	/*
	 * sortInventoryByName() sorts the inventory by name using 
	 * bubbleSort. Using a nested for loop bubble sort is accomplished.
	 * The item at the current inner and one ahead of inner are compared 
	 * using the compareTo methods in their respective GroceryItem 
	 * sub classes. If the comparison returns a value that is greater than 0
	 * meaning the current is "comes after"/ "is greater than" one after inner.
	 * If this is true then the two items need to be switched. This is done
	 * using bubbleSwap();
	 */
	public void sortInventoryByName() {
		for(int outer = 0; outer < inventory.size() - 1 ; outer++) {
			for(int inner = 0; inner < inventory.size() - 1 - outer; inner++) {
				//String name1 = inventory.get(inner).getName();
				//String name2 =inventory.get(inner + 1).getName();
				if(inventory.get(inner).compareTo(inventory.get(inner + 1)) > 0) {
					bubbleSwap(inner);
				}
			}
		}
	}
	
	/*
	 * sortInventoryByPrice() sorts the inventory by the item's 
	 * price using insertion sort. Uses a for loop to iterate 
	 * over inventory. Compares the current item's price 
	 * to the previous item's price. If the current element is 
	 * smaller than its previous compares against the previous
	 * item's previous item's price. The item's price that is greater
	 * than the current item's price is swapped with the current item's 
	 * position.
	 */
	public void sortInventoryByPrice() {
		for(int index = 1; index < inventory.size(); index ++) {
			GroceryItem item1 = inventory.get(index);
			int previousIndex = index -1;
			while((previousIndex > -1) && (item1.getPrice() < inventory.get(previousIndex).getPrice())) {
				inventory.set(previousIndex + 1, inventory.get(previousIndex));
				previousIndex--;
			}
			inventory.set(previousIndex+1, item1);
		}
	}

	/*
	 * @param inner, the current index inside the innermost
	 * for loop in sortByInventory(). Swaps the the current 
	 * item with the next item.s
	 */
	private void bubbleSwap(int inner) {
		GroceryItem temp = inventory.get(inner);
		inventory.set(inner, inventory.get( inner + 1));
		inventory.set(inner + 1, temp);
	}

	/*
	 * displayRestockingList() converts the restockinList, which is 
	 * a HashSet, into an array so that it can be traversed easily 
	 * using a for loop.
	 */
	public void displayRestockingList() {
		Object[] restockingListArray = restockingList.toArray();
		for(int index = 0; index < restockingList.size(); index++) {
			System.out.println(restockingListArray[index] );
		}

	}

	/*
	 * displayInventory() uses a for loop to traverse through
	 * inventory and calls toString() on the current GorceryItem,
	 * which has a overridden toString(), to print out a formatted
	 * String of the information
	 */
	public void displayInventory() {
		for(int index = 0; index < inventory.size(); index++) {
			System.out.println(inventory.get(index).toString());
		}
	}
}

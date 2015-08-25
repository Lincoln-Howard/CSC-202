package assignment1;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Logs transactions of FoodInfo objects in a vending machine.
 * @author Lincoln Howard
 */
@SuppressWarnings("serial")
public class TransactionLog implements Serializable {
	
	private ArrayList <FoodInfo> purchases;
	
	public TransactionLog () {
		purchases = new ArrayList <FoodInfo> ();
	}
	
	public String print () {
		return "";
	}
	
	public void log (FoodInfo entry) {
		purchases.add (entry);
	}
	
	public int inventory (FoodInfo type) {
		int count = 0;
		for (FoodInfo fi : purchases)
			if (fi == type)
				count++;
		return count;
	}
}
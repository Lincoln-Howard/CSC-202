package assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	// the vending machines to use
	public static VendingMachine food, drink;
	// the files to write objects to
	public static String food_file_name = "food.vem";
	public static String drink_file_name = "drink.vem";
	// the object writers and reader
	public static ObjectOutputStream food_writer;
	public static ObjectOutputStream drink_writer;
	public static ObjectInputStream reader;
	// the main method
	public static void main (String [] args) {
		// File I/O if they exist... aka use try catch
		File food_file = new File (food_file_name);
		File drink_file = new File (drink_file_name);
		// error handling
		try {
			reader = new ObjectInputStream (new FileInputStream (food_file));
			food = (VendingMachine) reader.readObject ();
			reader.close ();
			reader = new ObjectInputStream (new FileInputStream (drink_file));
			drink = (VendingMachine) reader.readObject ();
			reader.close ();
		} catch (Exception e) {
			food = new VendingMachine ();
			drink = new VendingMachine ();
		}
		Scanner input = new Scanner (System.in);
		if (args [0].equalsIgnoreCase ("vendor"))
			System.exit (vendor (input));
	}
	// if vendor
	public static int vendor (Scanner input) {
		// print a welcome to the vendor
		System.out.println ("Welcome, vendor! Type 'help' for a list of"
				+ "commands.");
		while (input.hasNextLine ()) {
			String line = input.nextLine ();
			String [] args = line.split (" ");
			switch (args [0].toLowerCase ()) {
			case "list":
			case "ls":
				for (int i = 0; i < food.size (); i++) {
					System.out.println (i + " -- " + food.info (i).name ());
				}
				for (int i = 0; i < drink.size (); i++) {
					System.out.println (i + " -- " + drink.info (i).name ());
				}
				break;
			case "help":
				// print the help guide
				System.out.println ("list: display all items in machines");
				System.out.println ("ls: shorthand for list");
				System.out.println ("add: create a new dispenser");
				System.out.println ("remove: delete an existing dispenser");
				System.out.println ("report <date>: run a report on the"
						+ "specified date");
				System.out.println ("\totherwise the report is run for the"
						+ "current date");
				break;
			case "add":
				// user input for the FoodInfo object
				System.out.println ("What is the name of the item to add?");
				String name = input.nextLine ();
				System.out.println ("How many calories are in the item?");
				String cal = input.nextLine ();
				System.out.println ("How many grams of fat are in the item?");
				String fat = input.nextLine ();
				System.out.println ("How many carb grams are in the item?");
				String carbs = input.nextLine ();
				System.out.println ("How many grams of protein are in the "
						+ "item?");
				String protein = input.nextLine ();
				// get cost
				System.out.println ("How much does the item cost? (Ex: '1.00'"
						+ " or '0.75')");
				String cost = input.nextLine ();
				// create the info object
				FoodInfo info = new FoodInfo (name, cal, fat, carbs, protein);
				// prompt the user to decide whether it is a food or drink
				System.out.println ("Are you creating a food or a drink? Type "
						+ "[f/d] and press enter.");
				String type = input.nextLine ();
				if (type.equalsIgnoreCase ("f")) {
					System.out.println ("adding the food to the vending"
							+ "machine");
					try {
						food.addItem (Double.parseDouble (cost), info);
					} catch (NumberFormatException e) {
						System.out.println ("cost not formatted correctly");
						System.out.println ("canceling addition");
						break;
					}
				} else if (type.equalsIgnoreCase ("d")) {
					System.out.println ("adding the drink to the vending"
							+ " machine");
					try {
						drink.addItem (Double.parseDouble (cost), info);
					} catch (NumberFormatException e) {
						System.out.println ("cost not formatted correctly");
						System.out.println ("canceling addition");
						break;
					}
				} else {
					System.out.println ("not a recognized type");
					System.out.println ("canceling addition");
				}
				break;
			case "remove":
				System.out.println ("remove a food or a drink item? [f/d]");
				switch (input.nextLine ().toLowerCase ()) {
				case "f":
					for (int i = 0; i < food.size (); i++) {
						System.out.println (i + " -- " + food.info (i).name ());
					}
					try {
            food.removeItem (Integer.parseInt (input.nextLine ()));
          } catch (Exception e) {
            System.out.println ("number not correct");
            System.out.println ("canceling removal");
          }
					break;
				case "d":
					for (int i = 0; i < drink.size (); i++) {
						System.out.println (i + " -- " + drink.info (i).name ());
					}
					System.out.println ("type the number of the item to remove");
					try {
					  drink.removeItem (Integer.parseInt (input.nextLine ()));
					} catch (Exception e) {
            System.out.println ("number not correct");
            System.out.println ("canceling removal");
					}
					break;
				default:
					System.out.println ("type not recognized");
				}
				break;
			case "report":
				break;
			case "exit":
				writeToFile ();
				System.out.println ("exiting...");
				input.close ();
				return 0;
			}
		}
		input.close ();
		return 0;
	}
	// writer food and drink machines to file
	public static void writeToFile () {
		try {
			food_writer = new ObjectOutputStream (new FileOutputStream
					(new File (food_file_name)));
			food_writer.writeObject (food);
			food_writer.close ();
			drink_writer = new ObjectOutputStream (new FileOutputStream
					(new File (drink_file_name)));
			drink_writer.writeObject (drink);
			drink_writer.close ();
		} catch (Exception e) {
		}
	}
}
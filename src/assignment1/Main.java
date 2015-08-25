package assignment1;

import java.util.Scanner;

public class Main {
	// the vending machines to use
	public static VendingMachine food, snacks;
	// the main method
	public static void main (String [] args) {
		if (args [0].equalsIgnoreCase ("vendor"))
			System.exit (vendor ());
	}
	// if vendor
	public static int vendor () {
		Scanner input = new Scanner (System.in);
		System.out.println ("Welcome, vendor! Type 'help' for a list of commands.");
		while (input.hasNextLine ()) {
			String line = input.nextLine ();
			String [] args = line.split (" ");
			switch (args [0].toLowerCase ()) {
			case "help":
				break;
			case "add":
				break;
			case "report":
				break;
			case "":
				break;
			}
		}
		input.close ();
		return 0;
	}
}
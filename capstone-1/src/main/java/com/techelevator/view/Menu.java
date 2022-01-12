package com.techelevator.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	private PurchaseLogReader vendingMachineLogReader = new PurchaseLogReader();
	private Inventory inventory = new Inventory(vendingMachineLogReader);
	private VendingMachine vendingMachine = new VendingMachine(inventory);


	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}

		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
				if (!options[i].equals("Sales Report")) {
					int optionNum = i + 1;
					out.println(optionNum + ") " + options[i]);
				}
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public void displayInventory(){
		int i=0;
		for (Map.Entry<String, Integer> item: inventory.InventoryMap().entrySet()) {
			if (item.getValue() > 0)
				System.out.println(item.getKey() + " "  + inventory.vendingMachineCurrentStock().get(item.getKey()).getName()+ " " + item.getValue() + " $" + inventory.vendingMachineCurrentStock().get(item.getKey()).getPrice());
			else System.out.println(item.getKey() + " " + inventory.vendingMachineCurrentStock().get(item.getKey()).getName() + " Sold Out");
		}
		}
	public Object getChoiceFromOptionsPurchaseMenu(Object[] options){
		Object userChoice = null;
		while (userChoice == null){
			displayMenuOptionsPurchaseMenu(options);
			userChoice = getChoiceFromUserInput(options);
			}
		return userChoice;
		}

		private void displayMenuOptionsPurchaseMenu(Object[] options){
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum + ")" + options[i]);
		}
		out.println("Current Balance: " + displayCurrentBalance());
		out.print(System.lineSeparator() + "Please choose an item from the menu >>> ");
		out.flush();
	}
	public void feedMoney() throws IOException {
		System.out.println("Please Insert Money: Accepted in form of $1, $2, $5, $10, and $20 bills");
		try {
			int moneyInserted = in.nextInt();
			in.nextLine();
			if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10 || moneyInserted == 20){
				vendingMachine.feedMoney(moneyInserted);
			}
			else {
				System.out.println("Please insert a valid currency");
			}
		}
		catch (InputMismatchException e){
			System.out.println("Please insert valid amount");
		}
	}
	public String  displayCurrentBalance(){
		return vendingMachine.getBalanceAsString();
	}
	public void selectProduct(){// selects an item
		System.out.println("Select an Item");
		String UserChoice = in.nextLine();
		System.out.println(vendingMachine.purchaseAnItem(UserChoice));

	}

	public void finishTransaction(){ //returns change for a finished transaction
		System.out.println(vendingMachine.Change());
	}
	public void salesReport(){
		vendingMachine.getSalesReport();
	}
}


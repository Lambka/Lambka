package com.techelevator;

import com.techelevator.view.Menu;

import java.io.IOException;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "EXIT";
	private static final String MAIN_MENU_OPTION_SALES_REPORT= "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT};
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION ="Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				menu.displayInventory();
			} if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true){
					String purchaseOptionChoice =(String) menu.getChoiceFromOptionsPurchaseMenu(PURCHASE_MENU_OPTIONS);
					if (purchaseOptionChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) menu.feedMoney();
					if (purchaseOptionChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						menu.displayInventory();
						menu.selectProduct();
					}
					if (purchaseOptionChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
						menu.finishTransaction();
						break;
					}
				}
			}
			if (choice.equals(MAIN_MENU_OPTION_EXIT)) break;
			if (choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				menu.salesReport();
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.
				run();
	}
}

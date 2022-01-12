package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

    private Inventory itemsInMachine;
    private CardReader cardReader;
    private PurchaseLogReader machineReader;
    private Logged loggedInventory;
    private MachineNoises vendingMachineNoises;

    public VendingMachine(Inventory itemsInMachine) {
        this.itemsInMachine = itemsInMachine;
        cardReader = new CardReader();
        loggedInventory = new Logged();
        machineReader = new PurchaseLogReader();
        new Inventory(machineReader);
        vendingMachineNoises = new MachineNoises();

    }

    public String Change() {
        loggedInventory.Event("GIVE CHANGE", getBalanceAsString(), "$0.00");
        String change = cardReader.returnChange(getBalance());
        return change;
    }


    public void subtractMoney(String itemSlot) {
        double moneyRemoved = itemsInMachine.vendingMachineCurrentStock().get(itemSlot).getPriceDouble();
        cardReader.subtractMoney(moneyRemoved);
    }

    public double getBalance() {
        return cardReader.getBalance();
    }

    public String getBalanceAsString() {
        String balance = cardReader.getBalanceAsAString();
        return balance;
    }

    public void feedMoney(double moneyAdded) {
        cardReader.addMoney(moneyAdded);
        String moneyAddedAsString = "$" + moneyAdded;
        loggedInventory.Event("Feed Money: ", moneyAddedAsString, getBalanceAsString());
    }

    public List<String> getInventoryAsString() {
        TreeMap<String, Item> itemMap = machineReader.itemLocations();
        List<String> inventory = new ArrayList<>();
        for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
            String valueOfItem = String.valueOf(itemsInMachine.itemsInStock(entry.getKey()));
            if (valueOfItem.contentEquals("0")) { // determines if item is sold out
                valueOfItem = "Sold Out";
            }
            String formatItemString = String.format(entry.getKey(), entry.getValue().getName(), entry.getValue().getPrice(), valueOfItem);
            inventory.add(formatItemString);
        }
        return inventory;
    }

    public void pullItem(String itemLocation) {
        itemsInMachine.pullItem(itemLocation);
    }

    public String purchaseAnItem(String itemLocation) {
        try {

            if (itemsInMachine.itemsInStock(itemLocation) == 0) {
                return itemsInMachine.vendingMachineCurrentStock().get(itemLocation).getName() + " are Sold Out";
            } else if (getBalance() < itemsInMachine.vendingMachineCurrentStock().get(itemLocation).getPriceDouble()) {
                return "Additional Funds Required";
            } else {
                String originalBalance = getBalanceAsString();
                subtractMoney(itemLocation);
                pullItem(itemLocation);
                String itemPurchased = "Thank you for your purchase of " + itemsInMachine.vendingMachineCurrentStock().get(itemLocation).getName() + "! " + itemsInMachine.vendingMachineCurrentStock().get(itemLocation).makeSound();
                loggedInventory.Event(itemsInMachine.vendingMachineCurrentStock().get(itemLocation).getName() + " " + itemLocation, originalBalance, getBalanceAsString());
                return itemPurchased;
            }
        } catch (NullPointerException e) {
            return "Please make a valid selection";
        }
    }

    public List<String> returnNoises() {
        return vendingMachineNoises.returnMachineNoises();
    }

    public void getSalesReport() {
        for (Map.Entry<String, Integer> item : itemsInMachine.InventoryMap().entrySet()) {
            double totalAmount = 0.00;
            for (String logReport : loggedInventory.getSalesReport()) {
                if (logReport.contains(itemsInMachine.vendingMachineCurrentStock().get(item.getKey()).getName())) {
                    totalAmount = totalAmount + itemsInMachine.vendingMachineCurrentStock().get(item.getKey()).getPriceDouble();
                }

            }System.out.println(itemsInMachine.vendingMachineCurrentStock().get(item.getKey()).getName() + " | " + totalAmount);
        }
    }
}

package com.techelevator.view;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    private PurchaseLogReader purchaseLog;
    private TreeMap<String,Integer> inventoryOnHand = new TreeMap<String, Integer>();

    public Inventory(PurchaseLogReader purchaseLog){ // creates a new vending machine inventory
        this.purchaseLog = purchaseLog;
        vendingMachineInventoryAtInstall();
    }

    public void vendingMachineInventoryAtInstall(){
        for (String [] inventory: purchaseLog.inventoryfromListtoArrayList()) {
            int stockAtStartup = 5;
            inventoryOnHand.put(inventory[0], stockAtStartup); // sets initial inventory to 5
        }
    }
    public Map<String, Integer> InventoryMap(){ //returns a list of the inventory
        return inventoryOnHand;
    }

    public void pullItem(String locationOfItem){ // removes an item from the inventory at the location requested
        inventoryOnHand.put(locationOfItem, inventoryOnHand.get(locationOfItem) - 1);
    }

    public int itemsInStock ( String locationOfItem) { // how many items at the location are on hand
        return inventoryOnHand.get(locationOfItem);
    }

    public Map<String, Item> vendingMachineCurrentStock(){ // returns tree map of all inventory
        return purchaseLog.itemLocations();
    }
}

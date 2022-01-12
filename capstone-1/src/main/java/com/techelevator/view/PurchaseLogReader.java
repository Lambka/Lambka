package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PurchaseLogReader {

    private String fileName = "vendingmachine.csv";
    private File inventoryFile = new File(fileName);

    private List<String> getListOfLines() {  // Goes through the data file for input use
        List<String> listOfFileLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                listOfFileLines.add(scanner.nextLine());
            }
        }
            catch(FileNotFoundException e){
            }
        return listOfFileLines;
    }
    public List<String[]> inventoryfromListtoArrayList(){ // Changes the inventroy from a list to an array list for usage
        List<String []> inventoryArray = new ArrayList<String[]>();
        for(String currentLine : getListOfLines()){
            inventoryArray.add(currentLine.split("\\|"));
        }
        return inventoryArray;
    }

    public TreeMap<String, Item> itemLocations(){
        TreeMap<String, Item> itemSlots = new TreeMap<>(); //generates a tree map for the slot locations for ease of tracking
        for (String thisLine: getListOfLines()){
            String[] inventorySplitUp = thisLine.split("\\|");
            if (inventorySplitUp[3].equals("Drink")){
                Beverages beverages = new Beverages(inventorySplitUp[1], inventorySplitUp[2]);
                itemSlots.put(inventorySplitUp[0], beverages);
            }
            if (inventorySplitUp[3].equals("Candy")){
                Candy candy = new Candy(inventorySplitUp[1], inventorySplitUp[2]);
                itemSlots.put(inventorySplitUp[0], candy);
            }
            if (inventorySplitUp[3].equals("Chip")){
                Chips chips = new Chips(inventorySplitUp[1], inventorySplitUp[2]);
                itemSlots.put(inventorySplitUp[0], chips);
            }
            if (inventorySplitUp[3].equals("Gum")){
                Gum gum = new Gum(inventorySplitUp[1], inventorySplitUp[2]);
                itemSlots.put(inventorySplitUp[0], gum);
            }
        }
        return itemSlots;
    }
}

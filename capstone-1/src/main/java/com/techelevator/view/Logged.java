package com.techelevator.view;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Logged {

    private String file = "log.txt";
    private boolean deleteFile = new File(file).delete();
    private File logFile = new File(file);


    public Logged() {
        createNewFile();
    }

    private void createNewFile() {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
        }
    }

    private String getCurrentTime() {
        String clock = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        return clock;
    }

    public String Event(String event, String balanceBeforeEvent, String balanceAfterEvent) {
        String newlog =getCurrentTime()+ " " + event + " " + balanceBeforeEvent + " " + balanceAfterEvent;

        try (Writer fileWriter = new FileWriter(logFile, true);
             BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(newlog + "\n");
        } catch (IOException e1) {
        }
        return newlog;
    }
    public ArrayList<String> getSalesReport(){
        ArrayList<String> sales =new ArrayList();
        int i = 0;
        try(Scanner scanner = new Scanner(logFile)){
            while(scanner.hasNextLine()){
                sales.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File does not exist");
        }
        return sales;
    }
}
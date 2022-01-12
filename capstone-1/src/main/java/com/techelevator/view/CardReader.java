package com.techelevator.view;

public class CardReader {

    public double balance;

    public CardReader() {
        balance=0.00;
    }
    public void subtractMoney(double amountToSubtract){
        balance = balance - amountToSubtract; //  subtracts amount required
    }
    public String returnChange( double balance){ //returns funds as change only
        int changeReturned = Double.valueOf(balance *100).intValue();

        int returnedQuaters = 0;
        int returnedNickels = 0;
        int returnedDimes = 0;


        while (changeReturned > 0){
            if(changeReturned >= 25){
                returnedQuaters++;
                changeReturned = changeReturned - 25;
            }
            else if (changeReturned >= 10){
                returnedDimes++;
                changeReturned = changeReturned - 10;
            }

            else if (changeReturned >= 5){
                returnedNickels++;
                changeReturned = changeReturned - 5;
            }
        }
        this.balance = 0;
        return "Your change is " + returnedQuaters +" quarters " + returnedDimes + " dimes, and " + returnedNickels + " nickels";
    }

    public String getBalanceAsAString(){ // returns balance as a string for display purposes
        double currentBalance = balance;
        String balanceAsString = "$" + String.format("%.2f", currentBalance);
        return balanceAsString;
    }

    public void addMoney(double amountToAdd) { // adds money to account
        balance= balance + amountToAdd;
    }

    public double getBalance(){return balance;} // returns the balance

    }

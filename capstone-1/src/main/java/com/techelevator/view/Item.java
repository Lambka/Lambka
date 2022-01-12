package com.techelevator.view;

public abstract class Item {

    private String name;

    private String price;

    public Item(String name, String price){
        this.name = name;
        this.price= price;
    }

    public String getPrice() {
        return price;
    }

    public double getPriceDouble(){
        return Double.parseDouble(price);
   }

    public String getName() {
        return name;
    }

    public abstract String makeSound();
}

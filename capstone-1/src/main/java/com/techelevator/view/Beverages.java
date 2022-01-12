package com.techelevator.view;

public class Beverages extends Item{

    public Beverages (String name, String price){
        super(name,price);
    }

    @Override
    public String makeSound() {
        return "Glug Glug, Yum!";
    }
}

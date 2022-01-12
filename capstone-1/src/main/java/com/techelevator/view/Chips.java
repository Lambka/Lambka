package com.techelevator.view;

public class Chips extends Item {

    public Chips(String name, String price){
        super(name, price);
    }

    @Override
    public String makeSound() {
        return "Crunch Crunch, Yum!";
    }
}

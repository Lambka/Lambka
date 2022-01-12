package com.techelevator.view;

public class Gum extends Item{

    public Gum(String name, String price){
        super(name, price);
    }

    @Override
    public String makeSound() {
        return "Chew Chew, Yum!";
    }
}

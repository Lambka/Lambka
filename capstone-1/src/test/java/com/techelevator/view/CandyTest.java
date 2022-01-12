package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

    private Candy testCandy;

    @Before
    public void setupCandy(){
        testCandy = new Candy("Herseys bar", "1.25");
    }

    @Test
    public void returnSoundTest(){
        Assert.assertEquals("Munch Munch, Yum!", testCandy.makeSound());
    }

    @Test
    public void returnPriceAsString(){
        Assert.assertEquals("1.25", testCandy.getPrice());
    }

    @Test
    public void returnPriceAsDouble(){
        Assert.assertEquals(1.25,testCandy.getPriceDouble(),  testCandy.getPriceDouble());
    }

}

package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeveragesTest {

    private Beverages testBeverage;

    @Before
    public void setTestBeverage(){
        testBeverage = new Beverages("Coca-Cola", "1.25");
    }

    @Test
    public void returnSoundTest(){
        Assert.assertEquals("Glug Glug, Yum!", testBeverage.makeSound());
    }

    @Test
    public void returnPriceAsString(){
        Assert.assertEquals("1.25", testBeverage.getPrice());
    }

    @Test
    public void returnPriceAsDouble(){
        Assert.assertEquals(1.25, testBeverage.getPriceDouble(),testBeverage.getPriceDouble());
    }
}

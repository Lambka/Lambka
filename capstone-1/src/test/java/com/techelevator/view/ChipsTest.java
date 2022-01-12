package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {

    private Chips testChips;

    @Before
    public void chipsTestSetup(){
        testChips = new Chips("doritos", "1.75");
    }

    @Test
    public void returnSounds(){
        Assert.assertEquals("Crunch Crunch, Yum!", testChips.makeSound());
    }

    @Test
    public void returnPriceAsAString(){
        Assert.assertEquals("1.75", testChips.getPrice());
    }

    @Test
    public void returnPriceAsDouble(){
        Assert.assertEquals(1.75,testChips.getPriceDouble(), testChips.getPriceDouble());
    }
}

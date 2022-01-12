package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

    private Gum testGum;

    @Before
    public void setTestGum(){
        testGum = new Gum ("Bazooka Joe", ".15");
    }

    @Test
    public void returnSounds(){
        Assert.assertEquals("Chew Chew, Yum!", testGum.makeSound());
    }

    @Test
    public void returnPriceAsAString(){
        Assert.assertEquals(".15", testGum.getPrice());
    }

    @Test
    public void returnPriceAsDouble(){
        Assert.assertEquals(.15, testGum.getPriceDouble(), testGum.getPriceDouble());
    }
}

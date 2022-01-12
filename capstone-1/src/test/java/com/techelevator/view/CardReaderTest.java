package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardReaderTest {

    private CardReader testCardReader;

    @Before
    public void setTestCardReader(){
        testCardReader = new CardReader();
    }
    @Test
    public void addMoney(){
        testCardReader.addMoney(1);
        Assert.assertEquals(1.00, testCardReader.getBalance(), testCardReader.getBalance());
    }
    @Test
    public void check_Balance_As_String(){
        testCardReader.addMoney(1);
        Assert.assertEquals("1.00", testCardReader.getBalanceAsAString());
    }
    @Test
    public void subtract_Money(){
        testCardReader.addMoney(20);
        testCardReader.subtractMoney(12.50);
        Assert.assertEquals(7.50, testCardReader.getBalance(), testCardReader.getBalance());
    }

    @Test
    public void check_Coins_Recieved(){
        testCardReader.addMoney(15);
        testCardReader.subtractMoney(12.50);
        Assert.assertEquals("Your change is 10 quarters 0 dimes, and 0 nickels", testCardReader.returnChange(testCardReader.getBalance()));
    }
    @Test
    public void check_balance_zero_after_Change(){
        testCardReader.addMoney(15);
        testCardReader.subtractMoney(12.50);
        testCardReader.returnChange(testCardReader.getBalance());
        Assert.assertEquals(0, testCardReader.getBalance(), testCardReader.getBalance());
    }
    @Test
    public void initial_balance_is_Zero(){
        Assert.assertEquals(0,testCardReader.balance, testCardReader.getBalance());
    }

}

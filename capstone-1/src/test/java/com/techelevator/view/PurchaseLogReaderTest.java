package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseLogReaderTest {

    private PurchaseLogReader testPurchaseLogReader;

    @Before
    public void setTestPurchaseLogReader() {
        testPurchaseLogReader = new PurchaseLogReader();
    }

    @Test
    public void test_Name_at_D3() {
        Assert.assertEquals("Chiclets", testPurchaseLogReader.itemLocations().get("D3").getName());
    }

    @Test
    public void test_Price_at_C2() {
        Assert.assertEquals(1.50, testPurchaseLogReader.itemLocations().get("C2").getPriceDouble(), testPurchaseLogReader.itemLocations().get("C2").getPriceDouble());
    }

    @Test
    public void test_Name_at_A2() {
        Assert.assertEquals("Stackers", testPurchaseLogReader.itemLocations().get("A2").getName());
    }

    @Test
    public void test_Price_at_A1() {
        Assert.assertEquals("3.05", testPurchaseLogReader.itemLocations().get("A1").getPrice());
    }
}
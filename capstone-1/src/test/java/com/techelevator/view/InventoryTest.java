package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory inventoryTest;

    @Before
    public void set_Inventory_Test(){
        inventoryTest = new Inventory(new PurchaseLogReader());
    }

    @Test
    public void initial_Inventory_Test(){
        Assert.assertEquals(5, inventoryTest.itemsInStock("A1"));
    }

    @Test
    public void pull_Item_From_Inventory(){
        inventoryTest.pullItem("A1");
        Assert.assertEquals(4, inventoryTest.itemsInStock("A1"));
    }

    @Test
    public void name_At_A1(){
        Assert.assertEquals("Potato Crisps", inventoryTest.vendingMachineCurrentStock().get("A1").getName());
    }

    @Test
    public void price_At_A2(){
        Assert.assertEquals("1.45", inventoryTest.vendingMachineCurrentStock().get("A2").getPrice());
    }

    @Test
    public void price_At_B1_As_Double(){
        Assert.assertEquals(1.50, inventoryTest.vendingMachineCurrentStock().get("B2").getPriceDouble(), inventoryTest.vendingMachineCurrentStock().get("B2").getPriceDouble());
    }
}

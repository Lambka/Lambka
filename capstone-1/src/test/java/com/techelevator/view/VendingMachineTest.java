package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    private Inventory vendingMachineInventoryTest;
    private PurchaseLogReader vendingMachinePurchaseLogReaderTest;
    private CardReader vendingMachineCardReaderTest;
    private VendingMachine vendingMachineTest;

    @Before
    public void setup(){
        vendingMachinePurchaseLogReaderTest = new PurchaseLogReader();
        vendingMachineInventoryTest = new Inventory(vendingMachinePurchaseLogReaderTest);
        vendingMachineTest = new VendingMachine(vendingMachineInventoryTest);
        vendingMachineCardReaderTest = new CardReader();
    }

    @Test
    public void check_Name_At_B2_Test(){
        Assert.assertEquals("Cowtales", vendingMachineInventoryTest.vendingMachineCurrentStock().get("B2").getName());
    }
    @Test
    public void check_price_at_B2_test(){
        Assert.assertEquals(1.50, vendingMachineInventoryTest.vendingMachineCurrentStock().get("B2").getPriceDouble(), vendingMachineInventoryTest.vendingMachineCurrentStock().get("B2").getPriceDouble() );
    }
    @Test
    public void check_price_as_String_at_B2_test(){
        Assert.assertEquals("1.50", vendingMachineInventoryTest.vendingMachineCurrentStock().get("B2").getPrice());
    }
    @Test
    public void purchase_item_not_on_map(){
        Assert.assertEquals("Please make a valid selection",vendingMachineTest.purchaseAnItem("A69"));
    }
    @Test
    public void check_balance_after_add_test(){
        vendingMachineTest.feedMoney(5);
        Assert.assertEquals(5.00, vendingMachineTest.getBalance(), vendingMachineTest.getBalance());
    }

    @Test
    public void check_balance_as_String(){
        vendingMachineTest.feedMoney(10);
        Assert.assertEquals("$10.00", vendingMachineTest.getBalanceAsString());
    }
    @Test
    public void check_item_not_on_map(){
        Assert.assertEquals(null, vendingMachineInventoryTest.vendingMachineCurrentStock().get("A69"));
    }
    @Test
    public void check_current_balance_as_String(){
        vendingMachineTest.feedMoney(10);
        vendingMachineTest.subtractMoney("A1");
        Assert.assertEquals("$6.95", vendingMachineTest.getBalanceAsString());
    }
    @Test
    public void sold_out_test(){
        vendingMachineTest.feedMoney(50);
        vendingMachineTest.purchaseAnItem("A1");
        vendingMachineTest.purchaseAnItem("A1");
        vendingMachineTest.purchaseAnItem("A1");
        vendingMachineTest.purchaseAnItem("A1");
        vendingMachineTest.purchaseAnItem("A1");
        Assert.assertEquals("Potato Crisps are Sold Out", vendingMachineTest.purchaseAnItem("A1"));
    }
    @Test
    public void remove_item_from_inventory(){
        vendingMachineTest.pullItem("A1");
        Assert.assertEquals(4, vendingMachineInventoryTest.itemsInStock("A1"));
    }
    @Test
    public void remove_item_from_inventory_directly(){
        vendingMachineInventoryTest.pullItem("A1");
        Assert.assertEquals(4, vendingMachineInventoryTest.itemsInStock("A1"));
    }
    @Test
    public void item_purchase_correct_amount_left(){
        vendingMachineTest.feedMoney(5);
        vendingMachineTest.subtractMoney("A1");
        Assert.assertEquals(1.95, vendingMachineTest.getBalance(), vendingMachineTest.getBalance());
    }

    @Test
    public void purchase_succeeds(){
        vendingMachineTest.feedMoney(10);
        Assert.assertEquals("Thank you for your purchase of Potato Crisps! Crunch Crunch, Yum!", vendingMachineTest.purchaseAnItem("A1"));
    }
}

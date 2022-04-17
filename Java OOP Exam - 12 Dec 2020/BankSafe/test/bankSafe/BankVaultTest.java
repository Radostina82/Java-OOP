package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class BankVaultTest {
    private BankVault bankVault;

    @Before
    public void setUp(){
        this.bankVault = new BankVault();
    }
    @Test
    public void testGetValueCellShouldReturnCell() throws OperationNotSupportedException {
       Map<String , Item> map = new LinkedHashMap<>();
        map.put("A1", null);
        map.put("A2", null);
        map.put("A3", null);
        map.put("A4", null);
        map.put("B1", null);
        map.put("B2", null);
        map.put("B4", null);
        map.put("C1", null);
        map.put("C2", null);
        map.put("B3", null);
        map.put("C3", null);
        map.put("C4", null);
        Assert.assertEquals(map, bankVault.getVaultCells());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNonExistingCellThrow() throws OperationNotSupportedException {
    Item item = new Item("Test", "1");
    this.bankVault.addItem("C25", item);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddTakenCellThrow() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");
        Item item1 = new Item("Test1", "5");
        this.bankVault.addItem("C2", item);
        this.bankVault.addItem("C2", item1);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddExistingItemThrow() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");
        this.bankVault.addItem("C2", item);
        this.bankVault.addItem("C3", item);
    }
    @Test
    public void testShouldAddCell() throws OperationNotSupportedException {
        Item item = new Item("Test", "1");
      String actual =  this.bankVault.addItem("C2", item);
      String expected = "Item:1 saved successfully!";
      Assert.assertEquals(expected, actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingCellThrow(){
        this.bankVault.removeItem("C10", null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItemThrow(){
        this.bankVault.removeItem("C2", new Item("Test", "1"));
    }
    @Test
    public void testRemoveSusses() throws OperationNotSupportedException {
       Item item = new Item("Test", "1");
       bankVault.addItem("C2", item);
        Map<String, Item> vaultCells = this.bankVault.getVaultCells();
        Assert.assertEquals("Test", vaultCells.get("C2").getOwner());
        String actual = this.bankVault.removeItem("C2", item);
        String expected = "Remove item:1 successfully!";
        Assert.assertEquals(expected, actual);
    }

}
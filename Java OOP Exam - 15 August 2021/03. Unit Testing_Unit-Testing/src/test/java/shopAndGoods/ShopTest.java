package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    private Map<String, Goods> shelves;
    @Before
    public void setUp(){
        this.shelves = new LinkedHashMap<>();
    }
    @Test
    public void testShouldAddGoods() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Assert.assertEquals(12, shop.getShelves().size());
        shop.addGoods("Shelves1", new Goods("Test", "1"));
        Assert.assertEquals("1", shop.getShelves().get("Shelves1").getGoodsCode());
        Assert.assertEquals("Test", shop.getShelves().get("Shelves1").getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenNotContainsShelfThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves13", new Goods("Test", "1"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenParamIsNotNullThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves1", new Goods("Test", "1"));
        shop.addGoods("Shelves1", new Goods("Test", "1"));
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsWhenParamThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Test", "1");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsNotContainsShelfsThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();

        shop.removeGoods("Shelves13", new Goods("Test", "1"));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsNotContainsGoodsThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();

        shop.removeGoods("Shelves1", new Goods("Test", "1"));
    }
    @Test
    public void testShouldRemoveGoods() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Test", "1");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Assert.assertEquals(null, shop.getShelves().get("Shelves1"));
       // shop.removeGoods("Shelves1", null);
    }
}
package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;
    private Goods milk;
    private Goods bread;

    @Before
    public void setUp(){
        shop = new Shop();
        milk = new Goods("Milk","111m");
        bread = new Goods("Bread","111b");
    }

    @Test
    public void getAllShelves() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", milk);
        Assert.assertSame(milk,shop.getShelves().get("Shelves1"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void tryToAddGoodsOnUnknownShelve() throws OperationNotSupportedException {
        shop.addGoods("Shelves41", milk);
    }
    @Test (expected = IllegalArgumentException.class)
    public void tryToAddGoodsOnAlreadyTakenShelve() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", milk);
        shop.addGoods("Shelves1", bread);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void tryToAddAlreadyExistingGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", milk);
        shop.addGoods("Shelves2", milk);
    }
    @Test
    public void addGoodsCorrectly() throws OperationNotSupportedException {
        Assert.assertEquals("Goods: 111m is placed successfully!",shop.addGoods("Shelves1",milk));
    }
    @Test
    public void removeGoodsCorrectly() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", milk);
        Assert.assertEquals("Goods: 111m is removed successfully!",shop.removeGoods("Shelves1",milk));
    }
    @Test (expected = IllegalArgumentException.class)
    public void tryToRemoveFromNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", milk);
        shop.removeGoods("Shelves21",milk);
    }
    @Test (expected = IllegalArgumentException.class)
    public void tryToRemoveDifferentGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", milk);
        shop.addGoods("Shelves2",bread);
        shop.removeGoods("Shelves1",bread);
    }
    @Test
    public void shelveValueShouldBeNullWhenWeRemoveGoods() throws OperationNotSupportedException {
        shop.addGoods("Shelves1",milk);
        shop.removeGoods("Shelves1",milk);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

}
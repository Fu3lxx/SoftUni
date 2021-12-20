package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private House house;
    private Cat cat;
    private Cat cat1;

    @Before
    public void setUp(){
        house = new House("house",5);
        cat = new Cat("pussyCat");
        cat1 = new Cat("Ganka");
    }

    @Test (expected = NullPointerException.class)
    public void testCreateHouseWithNullName(){
        House house = new House(null,5);
    }

    @Test (expected = NullPointerException.class)
    public void testCreateHouseWithEmptyName(){
        House house = new House("  ",5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateHouseWithNegativeCapacity(){
        House house = new House("test",-5);
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(5,house.getCapacity());
    }


    @Test
    public void testGetCount(){
        house.addCat(cat);
        Assert.assertEquals(1,house.getCount());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("house",house.getName());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testTryToAddCatWhenHouseIsFull(){
        House house = new House("test",1);
        house.addCat(cat1);
        house.addCat(cat);
    }

    @Test
    public void testCarForSale(){
        house.addCat(cat);
        house.addCat(cat1);
        Assert.assertEquals(cat,house.catForSale("pussyCat"));
        Assert.assertFalse(cat.isHungry());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testTryToSellUnknownCat(){
        house.addCat(cat);
        house.addCat(cat1);
        house.catForSale("unknownCat");
    }
    @Test
    public void removeCatCorrectly(){
        house.addCat(cat);
        house.removeCat("pussyCat");
        Assert.assertEquals(0,house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeCatNotCorrectly(){
        house.addCat(cat);
        house.removeCat("noNameCat");
    }


    @Test
    public void testStatistics(){
        house.addCat(cat);

        String out = house.statistics();
        Assert.assertEquals("The cat pussyCat is in the house house!",out);
    }



}

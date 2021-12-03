package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setUp(){
        aquarium = new Aquarium("test",5);
        fish = new Fish("Nemo");
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("test",aquarium.getName());
    }
    @Test (expected = NullPointerException.class)
    public void testSetInvalidName(){
        Aquarium aquarium = new Aquarium("  ",5);
    }
    @Test (expected = NullPointerException.class)
    public void testSetNullName(){
        Aquarium aquarium = new Aquarium(null,5);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetNegativeCapacity(){
        Aquarium aquarium = new Aquarium("test",-5);
    }
    @Test
    public void testGetCount0(){
        Assert.assertEquals(0,aquarium.getCount());
    }
    @Test
    public void testGetCount1(){
        aquarium.add(fish);
        Assert.assertEquals(1,aquarium.getCount());
    }
    @Test
    public void getCapacity(){
        Assert.assertEquals(5,aquarium.getCapacity());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddingFish(){
        Aquarium aquarium =new Aquarium("test",1);
        Fish fish1 = new Fish("Momo");
        aquarium.add(fish);
        aquarium.add(fish1);
    }
    @Test
    public void testTryToRemoveExistingFish(){
        aquarium.add(fish);
        aquarium.remove(fish.getName());
        Assert.assertEquals(0,aquarium.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testTryToRemoveNonExistingFish(){
        aquarium.add(fish);
        aquarium.remove("momo");
    }
    @Test
    public void testTryToSaleExistingFish(){
        aquarium.add(fish);
        aquarium.sellFish(fish.getName());
        Assert.assertFalse(fish.isAvailable());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testTryToSellNonExistingFish(){
        aquarium.add(fish);
        aquarium.sellFish("momo");
    }
    @Test
    public void testReport(){
        Fish fish1 = new Fish("Momo");
        aquarium.add(fish);
        aquarium.add(fish1);
        String expected = "Fish available at test: Nemo, Momo";
        Assert.assertEquals(expected,aquarium.report());
    }




}


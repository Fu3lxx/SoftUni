package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    private Farm correctFarm;
    private Animal cow;
    private Animal chicken;
    private Animal sheep;

    @Before
    public void setUp(){
        correctFarm = new Farm("test",2);
        cow = new Animal("Cow",100);
        chicken = new Animal("Chicken",120);
        sheep = new Animal("Sheep",80);

    }

    @Test (expected = NullPointerException.class)
    public void testWithNullName(){
        Farm farm = new Farm(null,5);
    }
    @Test (expected = NullPointerException.class)
    public void testWithEmptyName(){
        Farm farm = new Farm("   ",5);
    }
    @Test
    public void testWithCorrectName(){
        Assert.assertEquals("test",correctFarm.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSettingNegativeCapacity(){
        Farm farm = new Farm("test",-5);
    }
    @Test
    public void testSettingCorrectCapacity(){
        Assert.assertEquals(2,correctFarm.getCapacity());
    }
    @Test
    public void testAddingAnimal(){
        correctFarm.add(cow);
        correctFarm.add(chicken);
        Assert.assertEquals(2,correctFarm.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddMoreAnimalsThanCapacity(){
        correctFarm.add(cow);
        correctFarm.add(chicken);
        correctFarm.add(sheep);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testTryToAddSameAnimals(){

        correctFarm.add(chicken);
        correctFarm.add(chicken);
    }
    @Test
    public void testRemovingAnimalCorrectly(){
        correctFarm.add(cow);
        correctFarm.add(chicken);
        boolean removed = correctFarm.remove("Cow");
        Assert.assertTrue(removed);
    }
    @Test
    public void testRemovingNotExistingAnimal(){
        correctFarm.add(cow);
        correctFarm.add(chicken);
        boolean removed = correctFarm.remove("Dog");
        Assert.assertFalse(removed);
    }




}

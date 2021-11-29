package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    private static Player testPlayer;
    private static Gun gun;
    private static Gun gun2;

    @Test (expected = NullPointerException.class)
    public void testCreatePlayerWithNullUsername(){
        testPlayer = new Player(null,10);
    }
    @Test (expected = NullPointerException.class)
    public void testCreatePlayerWithBlankUsername(){
        testPlayer = new Player("  ",10);
    }
    @Test
    public void testCreatePlayerWithCorrectName(){
        testPlayer = new Player("test",10);
        Assert.assertEquals("test",testPlayer.getUsername());
        Assert.assertEquals(10,testPlayer.getHealth());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCreatePlayerWithIncorrectHealth(){
        testPlayer = new Player("test",-5);
    }
    @Test
    public void testTakeDamage(){
        testPlayer = new Player("test",10);
        testPlayer.takeDamage(5);
        Assert.assertEquals(5,testPlayer.getHealth());
    }
    @Test (expected = IllegalStateException.class)
    public void testTakeFatalDamage(){
        testPlayer = new Player("test",10);
        testPlayer.takeDamage(100);
        Assert.assertEquals(0,testPlayer.getHealth());
        testPlayer.takeDamage(5);
    }
    @Test
    public void testAddingGuns(){
        testPlayer = new Player("test",10);
        gun = new Gun("Pistol",10);
        testPlayer.addGun(gun);
        List<Gun> output = testPlayer.getGuns();
        Assert.assertEquals(gun,output.get(0));
    }
    @Test(expected = NullPointerException.class)
    public void testAddNullGun(){
        testPlayer = new Player("test",10);
        testPlayer.addGun(null);
    }
    @Test
    public void testRemoveGun(){
        testPlayer = new Player("test",10);
        gun = new Gun("Pistol",10);
        testPlayer.addGun(gun);
        Assert.assertEquals(1,testPlayer.getGuns().size());
        testPlayer.removeGun(gun);
        Assert.assertEquals(0,testPlayer.getGuns().size());
    }
    @Test
    public void testGetGun(){
        testPlayer = new Player("test",10);
        gun = new Gun("Pistol",10);
        gun2 = new Gun("Rifle",10);
        testPlayer.addGun(gun);
        testPlayer.addGun(gun2);
        Gun rifle = testPlayer.getGun("Rifle");

        Assert.assertEquals(gun2,rifle);

    }



}

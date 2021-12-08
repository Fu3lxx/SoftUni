package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HeroRepositoryTests {
    private HeroRepository repository;
    private Hero hero;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;

    private Hero nullHero;

    @Before
    public void setUp(){
        repository = new HeroRepository();
        hero = new Hero("testHero",10);
        hero1 = new Hero("hero1",2);
        hero2 = new Hero("hero2",3);
        hero3 = new Hero("hero3",25);
        nullHero = null;
    }

    @Test (expected = NullPointerException.class)
    public void testCreateNullHero(){
        repository.create(nullHero);
    }
    @Test
    public void testCreateAccurateHero(){
        String returnStr = repository.create(hero);
        Assert.assertEquals("Successfully added hero testHero with level 10",returnStr);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateAndAddSameHeroes(){
        repository.create(hero);
        repository.create(hero);
    }
    @Test
    public void testGetCount(){
        repository.create(hero);
        repository.create(hero2);
        Assert.assertEquals(2,repository.getCount());
    }
    @Test (expected = NullPointerException.class)
    public void testTryToRemoveWithEmptyName(){
        repository.create(hero);
        repository.remove("  ");
    }
    @Test (expected = NullPointerException.class)
    public void testTryToRemoveWithNullName(){
        repository.create(hero);
        repository.remove(null);
    }
    @Test
    public void testTryToRemoveWithCorrectName(){
        repository.create(hero);
        Assert.assertTrue(repository.remove("testHero"));
    }
    @Test
    public void testGetHeroWithHighestLevel(){
        repository.create(hero);
        repository.create(hero3);
        repository.create(hero1);
        repository.create(hero2);
        Assert.assertSame(hero3,repository.getHeroWithHighestLevel());
    }
    @Test
    public void testGetHero(){
        repository.create(hero);
        repository.create(hero3);
        repository.create(hero1);
        repository.create(hero2);
        Assert.assertSame(hero2,repository.getHero("hero2"));
    }
    @Test
    public void testGetAllHero(){
        repository.create(hero);
        repository.create(hero3);
        List<Hero> heroes= new ArrayList<>(repository.getHeroes());
        List<Hero> collection = new ArrayList<>();
        collection.add(hero);
        collection.add(hero3);
        Assert.assertEquals(collection,heroes);
    }





}

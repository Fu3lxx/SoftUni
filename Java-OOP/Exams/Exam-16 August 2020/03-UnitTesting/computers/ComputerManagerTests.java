package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private Computer computer;
    private Computer computer2;
    private Computer nullComputer;
    private ComputerManager computerManager;


    @Before
    public void setUp(){
        computer = new Computer("Asus","TUF",1500);
        computer2 = new Computer("Asus","Gaming",2000);
        nullComputer = null;
        computerManager = new ComputerManager();

    }

    @Test
    public void testGetComputers(){
        computerManager.addComputer(computer);
        Assert.assertSame(computer, computerManager.getComputers().get(0));
    }
    @Test
    public void testGetCount(){
        computerManager.addComputer(computer);
        Assert.assertEquals(1,computerManager.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void tryToAddTheSameComputer(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }
    @Test
    public void removeComputerCorrectly(){
        computerManager.addComputer(computer);
        Assert.assertSame(computer,computerManager.removeComputer("Asus","TUF"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNoExistingComputer(){
        computerManager.addComputer(computer);
        computerManager.getComputer("Asus","BUF");
    }
    @Test
    public void getComputerByManufacturer(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        List<Computer> asusComputers = new ArrayList<>();
        asusComputers.add(computer);
        asusComputers.add(computer2);
        Assert.assertEquals(asusComputers, computerManager.getComputersByManufacturer("Asus"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testValidator(){
        computerManager.addComputer(nullComputer);
    }
}
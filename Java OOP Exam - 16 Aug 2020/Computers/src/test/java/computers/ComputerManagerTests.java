package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager
    private static final Computer COMPUTER = new Computer("Test", "Test_Model", 100.00);
    private static final Computer COMPUTER_WRONG = new Computer(null, "", 0);

    @Test
    public void testAddComputerSusses(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(COMPUTER);
        List<Computer> computers = computerManager.getComputers();
        Assert.assertEquals(1, computerManager.getCount());
        Assert.assertEquals(COMPUTER.getManufacturer(), computers.get(0).getManufacturer());
        Assert.assertEquals(COMPUTER.getModel(), computers.get(0).getModel());
        Assert.assertEquals(COMPUTER.getPrice(), computers.get(0).getPrice(), 100.00);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testValidateNullValueThrow(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerThrow(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(COMPUTER);
        computerManager.addComputer(COMPUTER
        );
    }
    @Test
    public void testShouldRemoveComputer(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(COMPUTER);
        List<Computer> computers = computerManager.getComputers();
        //"Test", "Test_Model", 100.00
        Computer computer = computerManager.getComputer("Test", "Test_Model");
        Computer removeComp = computerManager.removeComputer("Test", "Test_Model");
        Assert.assertEquals(COMPUTER, removeComp);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerIsNull(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(COMPUTER);
        computerManager.getComputer("Test1", "Test_2");
    }
    @Test
    public void testShouldGetComputersByManufacturer(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(COMPUTER);
        Computer computer = new Computer("Test", "Test_2", 150.00);
        Computer computer1 = new Computer("Test2", "Test_2", 150.00);
        computerManager.addComputer(computer);
        List<Computer> computers = computerManager.getComputersByManufacturer("Test");
        Assert.assertEquals(2, computers.size());
    }

}
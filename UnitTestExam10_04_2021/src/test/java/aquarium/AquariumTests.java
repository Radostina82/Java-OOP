package aquarium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AquariumTests {
    @Test(expected = NullPointerException.class)
    public void testSetNameIsNullThrow() {
        Aquarium aquarium = new Aquarium(null, 10);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameIsEmptyThrow() {
        Aquarium aquarium = new Aquarium(" ", 10);
    }
    @Test
    public void testShouldSetName() {
        Aquarium aquarium = new Aquarium("Test", 10);
        Assert.assertEquals("Test", aquarium.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSeCapacityIsLessThanZeroThrow() {
        Aquarium aquarium = new Aquarium("Test", -10);
    }
    @Test
    public void testShouldSetCapacity() {
        Aquarium aquarium = new Aquarium("Test", 10);
        Assert.assertEquals(10, aquarium.getCapacity());
    }
    @Test
    public void testGetCount(){
        Aquarium aquarium = new Aquarium("Test", 10);
        List<Fish> fish = new ArrayList<>();
        Assert.assertEquals(0, aquarium.getCount());
        aquarium.add(new Fish("Fish"));
        Assert.assertEquals(1, aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFishThrow(){
        Aquarium aquarium = new Aquarium("Test", 1);
        List<Fish> fish = new ArrayList<>();
        aquarium.add(new Fish("Fish"));
        aquarium.add(new Fish("Fish1"));

    }
    @Test
    public void testShouldRemove(){
        Aquarium aquarium = new Aquarium("Test", 10);
        List<Fish> fish = new ArrayList<>();
        aquarium.add(new Fish("Fish"));
        aquarium.add(new Fish("Fish1"));
        aquarium.add(new Fish("Fish2"));

        aquarium.remove("Fish");
        Assert.assertEquals(2, aquarium.getCount() );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrow(){
        Aquarium aquarium = new Aquarium("Test", 10);
        aquarium.remove("Fish");
    }
    @Test
    public void testShouldSellFish(){
        Aquarium aquarium = new Aquarium("Test", 10);
        aquarium.add(new Fish("Fish"));
        aquarium.add(new Fish("Fish1"));
        Fish fish = aquarium.sellFish("Fish");
        Assert.assertEquals("Fish", fish.getName());
        Assert.assertFalse(fish.isAvailable());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrow(){
        Aquarium aquarium = new Aquarium("Test", 10);
        aquarium.sellFish("Fish");
    }
    @Test
    public void testShouldReport(){
        Aquarium aquarium = new Aquarium("Test", 10);
        aquarium.add(new Fish("Fish"));
        Assert.assertEquals("Fish available at Test: Fish", aquarium.report());
    }
}


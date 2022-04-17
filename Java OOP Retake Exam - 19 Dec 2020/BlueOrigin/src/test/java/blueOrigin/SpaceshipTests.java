package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpaceshipTests {
   private Spaceship spaceship;
    private Collection<Astronaut> astronauts;
    @Before
    public void setUp(){
        this.spaceship = new Spaceship("Test", 50);
        this.astronauts = new ArrayList<>();
    }
   @Test
    public void testShouldCreateSpaceship(){
        Spaceship spaceship = new Spaceship("Test", 50);
        Assert.assertEquals("Test",this.spaceship.getName() );
        Assert.assertEquals(50, this.spaceship.getCapacity());
   }
   @Test(expected = NullPointerException.class)
    public void testCreateSpaceshipThrowNonNameThrow(){
        Spaceship spaceship = new Spaceship("", 50);
   }
    @Test(expected = NullPointerException.class)
    public void testCreateSpaceshipThrowNullNameThrow(){
        Spaceship spaceship = new Spaceship(null, 50);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateSpaceshipInvalidCapacityThrow(){
        Spaceship spaceship = new Spaceship("null", -10);
    }
    @Test
    public void testShouldAddAstronaut(){
        Astronaut astronaut = new Astronaut("Test", 10.0);
        Spaceship spaceship = new Spaceship("Test1", 100);
        spaceship.add(astronaut);

        Assert.assertEquals(1, spaceship.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhitEqualSize(){
        Astronaut astronaut = new Astronaut("Test", 10.0);
        Spaceship spaceship = new Spaceship("Test1", 1);
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("1", 5));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautExistAstronaut(){
        Astronaut astronaut = new Astronaut("Test", 10.0);
        Spaceship spaceship = new Spaceship("Test1", 100);
        spaceship.add(astronaut);
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
    @Test
    public void testShouldRemove(){
        Astronaut astronaut = new Astronaut("Test", 10.0);
        Spaceship spaceship = new Spaceship("Test1", 100);
        Astronaut astronaut1 = new Astronaut("Test_1", 10.0);
        Astronaut astronaut2 = new Astronaut("Test_2", 20.0);
        Astronaut astronaut3 = new Astronaut("Test_3", 30.0);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.remove("Test_3");
        Assert.assertEquals(3, spaceship.getCount());
       Assert.assertTrue(spaceship.remove("Test_2"));
    }
    @Test
    public void testRemoveThrow(){
        Astronaut astronaut = new Astronaut("Test", 10.0);
        Spaceship spaceship = new Spaceship("Test1", 100);
        Astronaut astronaut1 = new Astronaut("Test_1", 10.0);
        Astronaut astronaut2 = new Astronaut("Test_2", 20.0);
        Astronaut astronaut3 = new Astronaut("Test_3", 30.0);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        Assert.assertFalse(spaceship.remove("10"));
    }
}

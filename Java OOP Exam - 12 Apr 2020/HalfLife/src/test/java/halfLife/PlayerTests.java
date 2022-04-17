package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
    private static final List<Gun> DATA = Arrays.asList(new Gun("Makarov", 12), new Gun("Remington", 50), new Gun("Glock", 10));
    private List<Gun> guns;

    @Before
    public void setUp() {
        this.guns = DATA;
    }

    @Test
    public void testCreateConstructorSusses() {
        Player player = new Player("test", 15);
        Assert.assertNotNull(player);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateConstructorThrow() {
        Player player = new Player("", 100);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateConstructorNullArg() {
        Player player = new Player(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateConstructorInvalidHealth() {
        Player player = new Player("test", -100);
    }

    @Test
    public void testGetUserName() {
        Player player = new Player("test", 100);
        Assert.assertEquals("test", player.getUsername());
    }

    @Test
    public void testGetHealth() {
        Player player = new Player("test", 100);
        Assert.assertEquals(100, player.getHealth());
    }

    @Test
    public void testAddGunSusses() {
        Player player = new Player("test", 100);
        //new Gun("Makarov", 12), new Gun("Remington", 50),new Gun("Glock", 10)
        player.addGun(new Gun("Makarov", 12));
        List<Gun> guns = player.getGuns();
        Assert.assertEquals(1, guns.size());
        Assert.assertEquals("Makarov", guns.get(0).getName());
    }
    @Test(expected = NullPointerException.class)
    public void testAddGunnThrow(){
        Player player = new Player("test", 100);
        player.addGun(null);
    }
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrow(){
        Player player = new Player("test", 0);
        player.takeDamage(10);
    }
    @Test
    public void testTakeDamageSusses(){
        Player player = new Player("test", 100);
        player.takeDamage(20);
       Assert.assertEquals(80,player.getHealth() );
    }
    @Test
    public void testTakeDamageWhitEqualDamageAndHealth(){
        Player player = new Player("test", 100);
        player.takeDamage(100);
        Assert.assertEquals(0,player.getHealth() );
    }
    @Test
    public void testTakeDamageWhenHealthIsLessThanDamage(){
        Player player = new Player("test", 100);
        player.takeDamage(150);
        Assert.assertEquals(0,player.getHealth() );
    }

    @Test
    public void testRemoveGunSusses(){
        Player player = new Player("test", 100);
    //new Gun("Makarov", 12), new Gun("Remington", 50),new Gun("Glock", 10)
        player.addGun(new Gun("Makarov", 12));
        player.addGun(new Gun("Remington", 50));
       List<Gun> guns = player.getGuns();
       player.removeGun(guns.get(0));
      Assert.assertEquals(1, guns.size());
      Assert.assertEquals("Remington", guns.get(0).getName());
    }
    @Test
    public void testGetGunSusses(){
        Player player = new Player("test", 100);
        //new Gun("Makarov", 12), new Gun("Remington", 50),new Gun("Glock", 10)
        player.addGun(new Gun("Makarov", 12));
        player.addGun(new Gun("Remington", 50));
        List<Gun> guns = player.getGuns();
        Gun gun = player.getGun("Makarov");
     Assert.assertEquals("Makarov", gun.getName());
     Assert.assertEquals(12, gun.getBullets());
    }
}

package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    private List<Gun> guns;
    private Player player;

    @Before
    public void setUp() {
        this.player = new Player("Test", 100);
        this.guns = new ArrayList<>();
    }

    @Test
    public void testShouldCreateConstructor() {
        Player expectedPlayer = new Player("Test", 100);
        List<Gun> expectedGun = new ArrayList<>();
        Assert.assertEquals(expectedPlayer.getUsername(), this.player.getUsername());
        Assert.assertEquals(expectedPlayer.getHealth(), this.player.getHealth());
        Assert.assertEquals(expectedGun.size(), this.guns.size());
    }

    @Test
    public void testShouldSetUser() {
        Player expectedPlayer = new Player("Test", 100);
        Assert.assertEquals(expectedPlayer.getUsername(), this.player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserIsNullThrow() {
        Player expectedPlayer = new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserIsEmptyThrow() {
        Player expectedPlayer = new Player(" ", 100);
    }

    @Test
    public void testShouldSetHealth() {
        Player expectedPlayer = new Player("Test", 100);
        Assert.assertEquals(expectedPlayer.getUsername(), this.player.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthIsLessThanZeroThrow() {
        Player expectedPlayer = new Player("Test", -100);
    }

    @Test
    public void testShouldGetGuns() {
        this.player.addGun(new Gun("Gun", 100));
        this.player.addGun(new Gun("Gun1", 200));
        Player expectedPlayer = new Player("Test", 100);
        expectedPlayer.addGun(new Gun("Gun", 100));
        expectedPlayer.addGun(new Gun("Gun1", 200));
        Assert.assertEquals(expectedPlayer.getGuns().size(), this.player.getGuns().size());
    }

    @Test
    public void testShouldTakeDamage() {
        this.player.takeDamage(50);
        Assert.assertEquals(50, this.player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamagePlayerIsDeadThrow() {
        Player player = new Player("test", 0);
        player.takeDamage(100);
        Player player1 = new Player("test1", -10);
        player.takeDamage(100);
    }

    @Test
    public void testTakeDamageThrow() {
        Player player = new Player("test", 100);
        player.takeDamage(150);
        Assert.assertEquals(0, player.getHealth());

    }
    @Test
    public void testShouldAddGun(){
        Gun gun = new Gun("Gun", 100);
        Gun gun1 = new Gun("Gun1", 100);
        this.player.addGun(gun);
        this.player.addGun(gun1);
        Player expectedPlayer = new Player("Test", 100);
        expectedPlayer.addGun(gun);
        expectedPlayer.addGun(gun1);
        Assert.assertEquals(expectedPlayer.getGuns().size(), this.player.getGuns().size());
        Assert.assertEquals(gun, this.player.getGun("Gun"));
    }
    @Test(expected = NullPointerException.class)
    public void testAddGunTrow(){
        this.player.addGun(null);
    }
    @Test
    public void testShouldRemoveGun(){
        Gun gun = new Gun("Gun", 100);
        Gun gun1 = new Gun("Gun1", 100);
        this.player.addGun(gun);
        this.player.addGun(gun1);
        this.player.removeGun(gun);
        Player expectedPlayer = new Player("Test", 100);
        expectedPlayer.addGun(gun);
        expectedPlayer.addGun(gun1);
        expectedPlayer.removeGun(gun);
        Assert.assertEquals(expectedPlayer.getGuns().size(), this.player.getGuns().size());
        Assert.assertTrue(this.player.removeGun(gun1));
    }
    @Test
    public void testShouldGetGun(){
        Gun gun = new Gun("Gun", 100);
        Gun gun1 = new Gun("Gun1", 100);
        this.player.addGun(gun);
        this.player.addGun(gun1);
        Gun gun2 = this.player.getGun("Gun");
        Assert.assertEquals(gun,gun2 );
    }
}

package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Test", 50);
    }

    @Test
    public void testShouldCreateHero() {
        Assert.assertEquals(0, this.heroRepository.getCount());
        Hero hero = new Hero("Test", 50);
        this.heroRepository.create(hero);
        Hero createdHero = this.heroRepository.getHero("Test");
        Assert.assertEquals(createdHero.getName(), hero.getName());
        Assert.assertEquals(createdHero.getLevel(), hero.getLevel());
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroNullThrow() {
        Hero hero = null;
        this.heroRepository.create(hero);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroDuplicateThrow() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);

    }

    @Test
    public void testShouldGetCount() {
        Hero hero = new Hero("Test", 50);
        this.heroRepository.create(hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test
    public void testShouldRemoveHero() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(new Hero("Test1", 40));
        this.heroRepository.create(new Hero("Test2", 30));
        Assert.assertEquals(3, heroRepository.getCount());
        Assert.assertTrue(this.heroRepository.remove("Test2"));
        Assert.assertEquals(2, heroRepository.getCount());
        Hero heroRemove = this.heroRepository.getHero("Test2");
        Assert.assertNull(heroRemove);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroNullThrow() {
        this.heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroIsEmptyThrow() {
        this.heroRepository.remove("");
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(new Hero("Test1", 40));
        this.heroRepository.create(new Hero("Test2", 30));
        Hero heroWithHighestLevel = this.heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(3, this.heroRepository.getHeroes().size());
        Assert.assertEquals(50, heroWithHighestLevel.getLevel());
        Assert.assertEquals("Test", heroWithHighestLevel.getName());
    }
}

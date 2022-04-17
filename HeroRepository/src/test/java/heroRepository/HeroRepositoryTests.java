package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Desi", 2);
    }

    //create(Hero)

    //1. hero == null
    @Test(expected = NullPointerException.class)
    public void testCreateHeroIsNull () {
        this.heroRepository.create(null);
    }

    //2. duplicate name
    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWithDuplicateName() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }

    //3. successful
    @Test
    public void testCreateSuccessfulHero() {
        //нямаме герои
        Assert.assertEquals(0, this.heroRepository.getCount());
        //добавяме герой
        this.heroRepository.create(this.hero);
        //1 герой
        Assert.assertEquals(1, this.heroRepository.getCount());
        Hero createdHero = this.heroRepository.getHero("Desi");
        //проверка дали сме създали правилно героя
        Assert.assertEquals(createdHero.getName(), this.hero.getName());
        Assert.assertEquals(createdHero.getLevel(), this.hero.getLevel());
    }

    //remove(String name)
    //1. name == null
    @Test(expected = NullPointerException.class)
    public void testRemoveWithNullName() {
        this.heroRepository.remove(null);
    }
    //2. name == empty
    @Test(expected = NullPointerException.class)
    public void testRemoveWithEmptyName() {
        this.heroRepository.remove("");
    }
    //3. successful remove
    @Test
    public void testRemoveSuccessfully() {
        //0 героя
        Assert.assertEquals(0, this.heroRepository.getCount());
        //"Desi" -> 2
        this.heroRepository.create(this.hero);
        //1 герой
        Assert.assertEquals(1, this.heroRepository.getCount());

        //премахваме героя
        this.heroRepository.remove("Desi");

        //проверка дали броя е равен на 0
        Assert.assertEquals(0, this.heroRepository.getCount());
        Hero removedHero = this.heroRepository.getHero("Desi"); //null
        Assert.assertNull(removedHero);

    }

    //getHeroWithHighestLevel
    @Test
    public void testGetHeroWithHighestLevel() {
        //0 героя
        Hero hero1 = new Hero("Zdravko", 3);
        Hero hero2 = new Hero("Valeri", 6);
        Hero hero3 = new Hero("Ivo", 4);
        this.heroRepository.create(hero1);
        //1 герой

        this.heroRepository.create(hero2);
        //2 героя

        this.heroRepository.create(hero3);
        //3 героя
        Assert.assertEquals(3, this.heroRepository.getHeroes().size());
        Hero highestHero = this.heroRepository.getHeroWithHighestLevel(); //hero2

        //сравняваме highestHero == hero2
        Assert.assertEquals(highestHero.getName(), hero2.getName());
        Assert.assertEquals(highestHero.getLevel(), hero2.getLevel());

    }

}

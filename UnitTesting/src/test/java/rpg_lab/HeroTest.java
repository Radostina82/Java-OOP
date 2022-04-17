package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {

    @Test
    public void testHeroGetGainsExperienceWhenTargetDies(){
        //с мокване
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Java", weapon);
        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(100);

      /*  Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

Hero hero = new Hero("Java", weapon);
        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 100;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };*/
        hero.attack(target);
    }

}
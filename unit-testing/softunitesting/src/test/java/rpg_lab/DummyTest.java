package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DummyTest {

    private static final String NAME = "Java";
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;

    private Weapon weapon;

    @Before
    public void setUp() {
        this.weapon = new Axe(10, 10);
    }

    @Test
    public void dummyLosesHealthIfAttack() {
        Dummy dummy = new Dummy(10, DUMMY_XP);
        dummy.takeAttack(9);
        Assert.assertEquals(1, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsAnExceptionIfAttack() {
        Dummy dummy = new Dummy(0, DUMMY_XP);
        dummy.takeAttack(1);
    }

    @Test
    public void deadDummyCanGiveXP() {
        Hero hero = new Hero(NAME, this.weapon);
        Dummy dummy = new Dummy(1, DUMMY_XP);
        hero.attack(dummy);
        Assert.assertEquals(DUMMY_XP, hero.getExperience());
    }

    @Test
    public void aliveDummyCantGiveXP() {
        Hero hero = new Hero(NAME, this.weapon);
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        hero.attack(dummy);
        Assert.assertEquals(0, hero.getExperience());
    }
}

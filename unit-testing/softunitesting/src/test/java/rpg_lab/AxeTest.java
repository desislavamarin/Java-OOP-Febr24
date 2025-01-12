package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;

    private Axe axe;
    private Dummy dummy;

    //Before & After - изпълняват се при всеки тест
    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, 10);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponLosesDurabilityAfterAttack() {
/*        //Arrange - ако не са инициализарани с before
        Axe axe = new Axe(AXE_ATTACK, 10);
        Dummy dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);*/
        //Act - действието, което да работа
        this.axe.attack(this.dummy);
        //Assert - условието, което трябва да е спазено
        int durabilityPointsAfterAttack = axe.getDurabilityPoints();
        Assert.assertEquals("Durability points doesn't match", 9, durabilityPointsAfterAttack);
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {

        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

    }
}

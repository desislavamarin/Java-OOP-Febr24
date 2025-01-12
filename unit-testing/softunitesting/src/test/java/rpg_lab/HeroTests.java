package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {

    private static final int TARGET_XP = 10;
    private static final int WEAPON_ATTACK = 10;
    private static final String HERO_NAME = "Java";

    @Test
    public void heroGainsExperienceAfterAttackIfTargetDies() {
        Target fakeTarget = Mockito.mock(Target.class);

        Mockito.when(fakeTarget.giveExperience()).thenReturn(TARGET_XP);

        Weapon fakeWeapon = Mockito.mock(Weapon.class);

        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeWeapon.getAttackPoints()).thenReturn(WEAPON_ATTACK);

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);

        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}

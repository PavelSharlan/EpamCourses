package test.by.bsu.attack;

import by.bsu.composite.component.Warrior;
import by.bsu.composite.entity.WarriorKind;
import by.bsu.composite.exception.NoAliveWarriorException;
import org.junit.Test;
import org.junit.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static by.bsu.composite.entity.WarriorKind.PALADIN;
import static by.bsu.composite.entity.WarriorKind.SHADOW_SHAMAN;

public class WarriorAttackTest {
    private static final Logger LOGGER = LogManager.getLogger(WarriorAttackTest.class);
    @Test
    public void attack(){
        Warrior paladin = new Warrior(PALADIN);
        Warrior shaman = new Warrior(SHADOW_SHAMAN);
        try {
            paladin.attack(shaman);
        } catch (NoAliveWarriorException e) {
            LOGGER.error("Somebody in test is dead!");
        }
        int shamanHealthPointsActual = shaman.getHealthPoints();
        int shamanHealthPointsExpected = 310;
        Assert.assertEquals(shamanHealthPointsExpected, shamanHealthPointsActual);
    }
}

package by.bsu.composite.main;

import by.bsu.composite.component.Army;
import by.bsu.composite.component.Warrior;
import by.bsu.composite.entity.Race;
import by.bsu.composite.war.ClanWar;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static by.bsu.composite.entity.WarriorKind.*;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Army alliance = new Army(Race.ALLIANCE);
        Army horde = new Army(Race.HORDE);

        Warrior palladin1 = new Warrior(PALADIN);
        Warrior palladin2 = new Warrior(PALADIN);
        Warrior shaman = new Warrior(SHADOW_SHAMAN);
        Warrior rogue = new Warrior(ROGUE);
        Warrior warlock = new Warrior(WARLOCK);

        alliance.add(palladin1);
        alliance.add(palladin2);

        horde.add(shaman);
        horde.add(rogue);
        horde.add(warlock);
        ClanWar.startWar(alliance, horde);
    }
}

package by.bsu.composite.war;

import by.bsu.composite.component.Army;
import by.bsu.composite.component.Component;
import by.bsu.composite.exception.NoAliveWarriorException;
import by.bsu.composite.statistics.WarStatisticsWriter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by 7 on 03.07.2016.
 */
public class ClanWar {
    private static final Logger LOGGER = LogManager.getLogger(ClanWar.class);

    public static void startWar(Army alliance, Army horde){
        try {
            while (alliance.isAlive() || horde.isAlive()) {
                alliance.attack(horde);
                horde.attack(alliance);
                WarStatisticsWriter.write(alliance, horde);
            }
        } catch (NoAliveWarriorException e){
            LOGGER.error("There are no alive warriors in any army!");
        }
        if (!alliance.isAlive()){
            LOGGER.info("Horde won!");
        } else {
            LOGGER.info("Alliance won!");
        }
    }
}

package by.bsu.composite.statistics;

import by.bsu.composite.component.Army;
import by.bsu.composite.component.Component;
import by.bsu.composite.component.Warrior;
import by.bsu.composite.exception.NoAliveWarriorException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

/**
 * Created by 7 on 04.07.2016.
 */
public class WarStatisticsWriter {
    private static final Logger LOGGER = LogManager.getLogger(WarStatisticsWriter.class);

    public static void write(Army alliance, Army horde) throws NoAliveWarriorException {
        ArrayList<Component> allianceAL = alliance.getAL();
        ArrayList<Component> hordeAL = horde.getAL();
        for (int i = 0; i < allianceAL.size(); i++){
            LOGGER.info("ALLIANCE warrior: health points - " + allianceAL.get(i).getHealthPoints());
        }
        for (int i = 0; i < hordeAL.size(); i++){
            LOGGER.info("HORDE warrior: health points - " + hordeAL.get(i).getHealthPoints());
        }
        LOGGER.info("____________");
    }
}

package by.bsu.logistics.main;

import by.bsu.logistics.entity.LogisticBase;
import by.bsu.logistics.entity.Terminal;
import by.bsu.logistics.manager.MessageManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

/**
 * Created by 7 on 04.06.2016.
 */
public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start");
        LogisticBase base = LogisticBase.getInstance();
        base.serve();
    }
}

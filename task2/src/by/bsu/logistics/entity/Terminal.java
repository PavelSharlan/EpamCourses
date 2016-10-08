package by.bsu.logistics.entity;

import by.bsu.logistics.builder.VanFactory;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import by.bsu.logistics.manager.MessageManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by 7 on 02.06.2016.
 */
public class Terminal implements Runnable{
    private final static Logger LOGGER = LogManager.getLogger(Terminal.class);
    private static int number;
    private MessageManager messageManager;
    private int id;

    public Terminal(MessageManager messageManager){
        number++;
        this.id = number;
        this.messageManager = messageManager;
    }

    public void serviceVan(Van van){
        LOGGER.info(messageManager.getProperty(MessageManager.VAN) + " " + van.getId() + " "
                + messageManager.getProperty(MessageManager.SERVICE) + " " + id);
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException", e);
        }
    }

    @Override
    public void run() {
        LogisticBase base = LogisticBase.getInstance();
        VanQueue queue = base.getVanQueue();
        while (!queue.isEmpty()){
            Van van = queue.takeVan();
            serviceVan(van);
        }
    }
}

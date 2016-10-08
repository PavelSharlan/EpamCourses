package by.bsu.logistics.generator;

import by.bsu.logistics.entity.Purpose;
import by.bsu.logistics.manager.MessageManager;

import java.util.Random;

/**
 * Created by 7 on 05.06.2016.
 */
public class RandomGenerator {
    public static int getRandomID(){
        Random random = new Random();
        return (Math.abs(new Random().nextInt(9999)));
    }

    public static Purpose getRandomPurpose(){
        Random random = new Random();
        int k = random.nextInt(2);
        if (k == 0){
            return Purpose.LOAD;
        } else {
            return Purpose.UNLOAD;
        }
    }

    public static boolean getRandomPerishable(){
        Random random = new Random();
        int k = random.nextInt(2);
        return k == 0;
    }

    public static MessageManager getRandomMessageManager(){
        Random random = new Random();
        int k = random.nextInt(2);
        if (k == 0){
            return MessageManager.EN;
        } else {
            return MessageManager.RU;
        }
    }

}

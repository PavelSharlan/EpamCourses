package by.bsu.logistics.builder;

import by.bsu.logistics.entity.Van;
import by.bsu.logistics.generator.RandomGenerator;

/**
 * Created by 7 on 05.06.2016.
 */
public class VanFactory {
    public static Van getRandomVan(){
        return new Van(RandomGenerator.getRandomPerishable(), RandomGenerator.getRandomPurpose(), RandomGenerator.getRandomID());
    }
}

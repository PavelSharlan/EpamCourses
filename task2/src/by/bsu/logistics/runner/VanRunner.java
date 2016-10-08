package by.bsu.logistics.runner;

import by.bsu.logistics.builder.VanFactory;
import by.bsu.logistics.entity.LogisticBase;
import by.bsu.logistics.entity.Van;
import by.bsu.logistics.entity.VanQueue;

/**
 * Created by 7 on 05.06.2016.
 */
public class VanRunner {
    private final static int VANS_COUNT = 50;

    public static void vansRun(){
        LogisticBase base = LogisticBase.getInstance();
        Van van;
        for (int i = 0; i < VANS_COUNT; i++){
            van = VanFactory.getRandomVan();
            base.acceptVan(van);
        }
    }
}

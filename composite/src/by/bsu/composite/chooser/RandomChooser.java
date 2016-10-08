package by.bsu.composite.chooser;

import by.bsu.composite.component.Component;
import by.bsu.composite.exception.NoAliveWarriorException;

import java.util.ArrayList;
import java.util.Random;

public class RandomChooser {
    public static int componentChoose(ArrayList<Component> al) throws NoAliveWarriorException {
        if (al.size() == 0){
            throw new NoAliveWarriorException();
        }
        Random rand = new Random();
        return rand.nextInt(al.size());
    }
}

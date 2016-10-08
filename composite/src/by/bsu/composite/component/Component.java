package by.bsu.composite.component;

import by.bsu.composite.exception.NoAliveWarriorException;

/**
 * Created by 7 on 29.06.2016.
 */
public interface Component {
    void attack(Component c) throws NoAliveWarriorException;
    int getDamage();
    int getHealthPoints() throws NoAliveWarriorException;
    int getArmor();
    void setHealthPoints(int healthPoints);
}

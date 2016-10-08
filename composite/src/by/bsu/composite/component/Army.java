package by.bsu.composite.component;

import by.bsu.composite.chooser.RandomChooser;
import by.bsu.composite.entity.Race;
import by.bsu.composite.exception.NoAliveWarriorException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;

public class Army implements Component {
    private static final Logger LOGGER = LogManager.getLogger(Army.class);

    private ArrayList<Component> warriors;
    private Component cur;
    private Race race;

    public Army(Race race) {
        this.race = race;
        warriors = new ArrayList<Component>();
    }

    public void attack(Component c) throws NoAliveWarriorException {
        Component attacker = warriors.get(RandomChooser.componentChoose(warriors));
        attacker.attack(c);
    }

    public void add(Component c){
        warriors.add(c);
    }

    public void remove(Component c){
        warriors.remove(c);
    }

    public int getDamage(){
        return cur.getDamage();
    }

    public int getArmor(){
        return cur.getArmor();
    }

    public int getHealthPoints() throws NoAliveWarriorException {
        cur = warriors.get(RandomChooser.componentChoose(warriors));
        return cur.getHealthPoints();
    }

    public void setHealthPoints(int healthPoints){
        if (healthPoints <= 0) {
            cur.setHealthPoints(0);
            remove(cur);
        } else {
            cur.setHealthPoints(healthPoints);
        }
    }

    public ArrayList<Component> getAL(){
        return new ArrayList<Component>(warriors);
    }

    public boolean isAlive(){
        return warriors.size() != 0;
    }

    public Race getRace() {
        return race;
    }
}

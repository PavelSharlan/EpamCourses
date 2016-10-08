package by.bsu.composite.component;

import by.bsu.composite.entity.WarriorKind;
import by.bsu.composite.exception.NoAliveWarriorException;

public class Warrior implements Component {
    private int healthPoints;
    private int damage;
    private int armor;
    private WarriorKind kind;

    public Warrior(WarriorKind kind){
        healthPoints = kind.getHealthPoints();
        damage = kind.getDamage();
        armor = kind.getArmor();
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void attack(Component c) throws NoAliveWarriorException {
        c.setHealthPoints(c.getHealthPoints() - getDamage() + getArmor());
    }

    public void setKind(WarriorKind kind) {
        this.kind = kind;
    }

    public WarriorKind getKind() {
        return kind;
    }
}

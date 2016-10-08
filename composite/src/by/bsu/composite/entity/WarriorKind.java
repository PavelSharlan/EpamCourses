package by.bsu.composite.entity;

public enum WarriorKind {
    PALADIN(300, 30, 6),
    ROGUE(250, 20,12),
    SHADOW_SHAMAN(330, 25, 10),
    WARLOCK(350, 15, 10);

    private int damage;
    private int healthPoints;
    private int armor;

    private WarriorKind(int healthPoints ,int damage, int armor){
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getArmor() {
        return armor;
    }
}

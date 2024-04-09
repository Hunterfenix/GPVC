package net.teapot;
/* TO-DO:
 * 	     	Level
 *          Inventory
 *          Item
 */
public class Personaggio {
    public enum Type {
        ELFO,
        GIGANTE,
        NANO,
        DEMONE
    }
    // Constant for not use a constructor in a specific type of
    public static final int DEFAULT_LIFE_POINTS = 100;
    public static final int DEFAULT_MAGIC_DEFENSE = 10;
    public static final int DEFAULT_PHYSICAL_DEFENSE = 10;
    public static final int DEFAULT_MAGIC_ATTACK = 20;
    public static final int DEFAULT_PHYSICAL_ATTACK = 20;
    // Variable
    private String name;
    private Type type;
    private int lifePoints = DEFAULT_LIFE_POINTS;
    private int magicDefense = DEFAULT_MAGIC_DEFENSE;
    private int physicalDefense = DEFAULT_PHYSICAL_DEFENSE;
    private int magicAttack = DEFAULT_MAGIC_ATTACK;
    private int physicalAttack = DEFAULT_PHYSICAL_ATTACK;
    // Damage function
    public void dealDamage(int magicAttack, int physicalAttack) {
        lifePoints -= Math.abs(magicDefense - magicAttack + physicalDefense - physicalAttack);
    }
    // Set & Get for all variable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public int getMagicDefense() {
        return magicDefense;
    }
    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }
    public int getPhysicalDefense() {
        return physicalDefense;
    }
    public void setPhysicalDefense(int physicalDefense) {
        this.physicalDefense = physicalDefense;
    }
    public int getMagicAttack() {
        return magicAttack;
    }
    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }
    public int getPhysicalAttack() {
        return physicalAttack;
    }
    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }
}
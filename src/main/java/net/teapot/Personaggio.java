package net.teapot;

/* TO-DO:
 * 	     	Gestione del LEVELUP
 */
public abstract class Personaggio {

    public enum Type {
        ELFO,
        GIGANTE,
        NANO,
        DEMONE
    }

    // public static final int DEFAULT_LEVEL = 1;
    public static final int DEFAULT_LIFE_POINTS = 100;
    public static final int DEFAULT_MAGIC_DEFENSE = 10;
    public static final int DEFAULT_PHYSICAL_DEFENSE = 10;
    public static final int DEFAULT_MAGIC_ATTACK = 20;
    public static final int DEFAULT_PHYSICAL_ATTACK = 20;

    private String name;
    private Type type;
    // private int level = DEFAULT_LEVEL;
    private int lifePoints = DEFAULT_LIFE_POINTS;
    private int magicDefense = DEFAULT_MAGIC_DEFENSE;
    private int physicalDefense = DEFAULT_PHYSICAL_DEFENSE;
    private int magicAttack = DEFAULT_MAGIC_ATTACK;
    private int physicalAttack = DEFAULT_PHYSICAL_ATTACK;

    public void dealDamage(int magicAttack, int physicalAttack) {
        lifePoints -= magicDefense - magicAttack + physicalDefense - physicalAttack;
    }

    public boolean isAlive() {
        return lifePoints > 0;
    }

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

	/*
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	*/

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
package net.teapot;

public class Ladro extends Personaggio {
    private int standardPhysicalAttack;
    // Constructor for thief
    public Ladro(int lifePoints, int physicalDefense, int physicalAttack, int magicDefense, int magicAttack) {
        setLifePoints(lifePoints);
        setPhysicalDefense(physicalDefense);
        setPhysicalAttack(physicalAttack);
        setMagicDefense(magicDefense);
        setMagicAttack(magicAttack);
    }
    // Special ability
    public void stealth(int pysicalAttackBoost) {

        standardPhysicalAttack = getPhysicalAttack();
        setPhysicalAttack(pysicalAttackBoost);


    }
    public void endStealth() {
        setPhysicalAttack(standardPhysicalAttack);
    }
}
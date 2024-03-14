package net.teapot;

public class Ladro extends Personaggio {
    private int standardPysicalAttack;
    private boolean usedAbilty = false;
    Ladro(int lifePoints, int physicalDefense, int physicalAttack, int magicDefense, int magicAttack) {
        setLifePoints(lifePoints);
        setPhysicalDefense(physicalDefense);
        setPhysicalAttack(physicalAttack);
        setMagicDefense(magicDefense);
        setMagicAttack(magicAttack);
    }

    // Special ability

    public void stealth(int pysicalAttackBoost) {
        if (usedAbilty = false) {
            standardPysicalAttack = getPhysicalAttack();
            setPhyscalAttack(pysicalAttackBoost);
        }

    }
    public void endStealth() {
        usedAbilty = true;
    }
}

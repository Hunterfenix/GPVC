package net.teapot;

public class Mago extends Personaggio{
    private int standardMagicAttack;
    Mago(int lifePoints, int physicalDefense, int physicalAttack, int magicDefense, int magicAttack) {
        setLifePoints(lifePoints);
        setPhysicalDefense(physicalDefense);
        setPhysicalAttack(physicalAttack);
        setMagicDefense(magicDefense);
        setMagicAttack(magicAttack);
    }

    // Special ability

    public void magicWand(int magicAttack) {

    }
    public void endMagicWand() {

    }
}

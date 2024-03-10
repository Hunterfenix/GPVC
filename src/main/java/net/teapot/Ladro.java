package net.teapot;

public class Ladro extends Personaggio {
    Ladro(int lifePoints, int physicalDefense, int physicalAttack, int magicDefense, int magicAttack) {
        setLifePoints(lifePoints);
        setPhysicalDefense(physicalDefense);
        setPhysicalAttack(physicalAttack);
        setMagicDefense(magicDefense);
        setMagicAttack(magicAttack);
    }

    // Special ability

    public void stealth() {

    }
    public void endStealth() {

    }
}

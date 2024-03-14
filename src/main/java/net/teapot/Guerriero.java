package net.teapot;

public class Guerriero extends Personaggio{
    private int standardPhysicalAttack;
    private int standardPhysicalDefense;
    Guerriero(int lifePoints, int physicalDefense, int physicalAttack, int magicDefense, int magicAttack) {
        setLifePoints(lifePoints);
        setPhysicalDefense(physicalDefense);
        setPhysicalAttack(physicalAttack);
        setMagicDefense(magicDefense);
        setMagicAttack(magicAttack);
    }

    // Special ability
    public void callToWar(int physicalDefenseBoost,int physicalAttackBoost) {
        standardPhysicalAttack = getPhysicalAttack();
        standardPhysicalDefense = getPhysicalDefense();
        setPhysicalDefense(physicalDefenseBoost);
        setPhysicalAttack(physicalAttackBoost);
    }
    public void endCallToWar() {

        setPhysicalAttack(standardPhysicalAttack);
        setPhysicalDefense(standardPhysicalDefense);
    }

}

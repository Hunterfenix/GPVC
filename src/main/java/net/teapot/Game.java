package net.teapot;
import javax.sound.midi.SysexMessage;
import java.io.*;
public class Game {
    //
    private boolean abilityWarrior = false;
    private boolean abilityThief = false;
    private boolean abilityMage = false;

    // Constructor
    Game() {
        Guerriero guerriero = new Guerriero(256,90,100,80,4);
        guerriero.setType(Guerriero.Type.GIGANTE);

        Ladro ladro = new Ladro(100,20,60,20,40);
        ladro.setType(Ladro.Type.NANO);

        Mago mago = new Mago(80,20,10,150,200);
        mago.setType(Mago.Type.ELFO);
    }
    public void startGame() {
        // Input method using inputstreamreader & bufferedreader
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);

        // Set of the name for the player
        System.out.println("Iniziamo con il nome dei personaggi!");
        try{
            System.out.println("Il ladro si si chiama: ");
            ladro.setName(data.readLine());
            System.out.println("Il guerriero si chiama: ");
            guerriero.setName(data.readLine());
            System.out.println("Il mago si chiama: ");
            mago.setName(data.readLine())
        }catch (IOException e) {
            System.out.println("");
        }
        // Display the spec of the player
        sayAbbility();

        // Event
        System.out.println("Un guerriero, un ladro e, un mago entrano in una taverna:")
        System.out.println("Dopo qualche sguardo inizia una rissa.");
        System.out.println("Ora devi scegliere chi far combattere e se vuoi usare le lore abilità speciali");
        System.out.println("Dimmi il nome del personaggio attaccante(ladro,mago,guerriero): ");

        data.close();
    }
    // Function for battle
    public void battle(String name) {
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);
        String temp;

        try {
            switch(name) {
                case "mago": // The mage deal damage
                    System.out.println("Dimmi il nome del personaggio difensore (ladro,guerriero)");
                    temp = data.readLine();

                    if(temp == ladro) { // The thief take damage
                        ladro.dealDamage(mago.getMagicAttack, mago.getPysicalAttack);
                    }else if (temp == guerriero) { // The warrior take damage
                        guerriero.dealDamage(mago.getMagicAttack, mago.getPysicalAttack);
                    }else {
                        System.out.println("Hai sbagliato ad inserire i dati")
                    }
                    break;

                case "ladro": // The thief deal damage
                    System.out.println("Dimmi il nome del personaggio difensore (mago,guerriero)");
                    temp = data.readLine();
                    if(temp == "mago") { // The mage take damage
                        mago.dealDamage(ladro.getMagicAttack, ladro.getPysicalAttack);
                    }else if (temp == "guerriero") { // The warrior take damage
                        guerriero.dealDamage(ladro.getMagicAttack, ladro.getPysicalAttack);
                    }else {
                        System.out.println("Hai sbagliato ad inserire i dati")
                    }
                    break;

                case "guerriero": // The warrior deal Damge
                    System.out.println("Dimmi il nome del personaggio difensore (mago,ladro)");
                    temp = data.readLine();
                    // Selection special ability
                    warriorAbb();

                    if(temp == "mago") { // The mage take damage
                        mago.dealDamage(guerriero.getMagicAttack, guerriero.getPysicalAttack);
                        if
                        guerriero.endCallToWar();
                    }else if (temp == "ladro") { // The thief take damage
                        ladro.dealDamage(guerriero.getMagicAttack, guerriero.getPysicalAttack);
                    }else {
                        System.out.println("Hai sbagliato ad inserire i dati");
                    }
                    break;
            }
            data.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void warriorSpAbb() { //
        try {
            System.out.println("Vuoi che il guerriero utilizi la sua abilità speciale?");
            if(data.readLine() == "si" && abilityWarrior != true) {
                guerriero.callToWarr(400,300);
                abilityWarrior = true;
            } else if (abilityWarrior == true) {
                System.out.println("È già stata utilizata quest'abilità per questo personaggio");
            } else {
                continue;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void thiefSpAbb() {
        try {
            System.out.println("Vuoi che il ladro utilizi la sua abilità speciale?");
            if(data.readLine() == "si" && abilityThief != true) {
                mago.magicWand(400,300);
                abilityWarrior = true;
            } else if (abilityWarrior == true) {
                System.out.println("È già stata utilizata quest'abilità per questo personaggio");
            } else {
                continue;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }
    public void sayAbbility() {
        // Thief
        System.out.println("Il ladro " + ladro.getName() + " ha queste statistiche: ");
        System.out.println("Punti vita: " + ladro.getLifePoints);
        System.out.println("Difesa fisica: " + ladro.getPysicalDefense);
        System.out.println("Attacco fisico: " + ladro.getPhysicalAttack);
        System.out.println("Difesa magica: " + ladro.getMagicDefense);
        System.out.println("Attacco magico: " + ladro.getMagicAttack);
        // Mage
        System.out.println("Il mago " + mago.getName() + " ha queste statistiche: ");
        System.out.println("Punti vita: " + mago.getLifePoints);
        System.out.println("Difesa fisica: " + mago.getPysicalDefense);
        System.out.println("Attacco fisico: " + mago.getPhysicalAttack);
        System.out.println("Difesa magica: " + mago.getMagicDefense);
        System.out.println("Attacco magico: " + mago.getMagicAttack);
        // Warrior
        System.out.println("Il guerriero " + guerriero.getName() + " ha queste statistiche: ");
        System.out.println("Punti vita: " + guerriero.getLifePoints);
        System.out.println("Difesa fisica: " + guerriero.getPysicalDefense);
        System.out.println("Attacco fisico: " + guerriero.getPhysicalAttack);
        System.out.println("Difesa magica: " + guerriero.getMagicDefense);
        System.out.println("Attacco magico: " + guerriero.getMagicAttack);
    }
}

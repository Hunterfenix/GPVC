package net.teapot;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;
public class Game {
    // Logging for possible exception
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    // Ability usage check variable
    private boolean abilityWarrior = false;
    private boolean abilityThief = false;
    private boolean abilityMage = false;
    // Create an instance of a class Guerriero
    private Guerriero guerriero;
    // Create an instance of a class Ladro
    private Ladro ladro;
    // Create an instance of a class Mago
    private Mago mago;

    // Constructor
    public Game() {
        // Set basic statistic for warrior
        guerriero = new Guerriero(256,100,100,30,10);
        guerriero.setType(Guerriero.Type.GIGANTE);
        // Set basic statistic for Thief
        ladro = new Ladro(100,20,60,20,40);
        ladro.setType(Ladro.Type.NANO);
        // Set basic statistic for mage
        mago = new Mago(80,20,10,150,200);
        mago.setType(Mago.Type.ELFO);
        startGame();
    }
    public void startGame() {
        // Input method using inputstreamreader & bufferedreader
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);

        // Set of the name for the player
        System.out.println("Iniziamo con il nome dei personaggi!");
        try {
            System.out.println("Il ladro si si chiama: ");
            ladro.setName(data.readLine());
            System.out.println("Il guerriero si chiama: ");
            guerriero.setName(data.readLine());
            System.out.println("Il mago si chiama: ");
            mago.setName(data.readLine());
        } catch (IOException e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
        // Display the spec of the player
        sayAbility();
        // Event
        System.out.println("Un guerriero, un ladro e, un mago entrano in una taverna:");
        System.out.println("Dopo qualche sguardo inizia una rissa.");
        System.out.println("Ora devi scegliere chi far combattere e se vuoi usare le lore abilità speciali");
        while (guerriero.getLifePoints() > 0 && mago.getLifePoints() > 0 && ladro.getLifePoints() > 0) {
            events();
        }
        if (guerriero.getLifePoints() <= 0) {
            System.out.println("Il guerriero si accascia a terra il ladro ed il mago scappano");
        } else if(mago.getLifePoints() <= 0) {
            System.out.println("Il mago si accascia terra il ladro e il guerriero scappano");
        } else if (ladro.getLifePoints() <= 0){
            System.out.println("Il ladro si accascia a terra il mago e il guerriero scappano");
        }
        // Close reader
        try {
            data.close();
            keyboard.close();
        } catch (IOException e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
    }
    // Event trigger
    public void events() {
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);
        // Event
        try {
            System.out.println("Dimmi il nome del personaggio attaccante(ladro,mago,guerriero): ");
            battle(data.readLine());
            sayAbility();
        } catch (IOException e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
    }
    // Function for battle
    public void battle(String name) {
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);
        String temp;
        try {
            switch (name) {
                case "mago": // The mage deal damage
                    mageSpAb();
                    System.out.println("Dimmi il nome del personaggio difensore (ladro,guerriero)");
                    temp = data.readLine();
                    if(temp.equals("ladro")) { // The thief take damage
                        ladro.dealDamage(mago.getMagicAttack(), mago.getPhysicalAttack());
                        mago.endMagicWand();
                    } else if (temp.equals("guerriero")) { // The warrior take damage
                        guerriero.dealDamage(mago.getMagicAttack(), mago.getPhysicalAttack());
                        mago.endMagicWand();
                    } else {
                        System.out.println("Hai sbagliato ad inserire i dati");
                    }
                    break;
                case "ladro": // The thief deal damage
                    thiefSpAb();
                    System.out.println("Dimmi il nome del personaggio difensore (mago,guerriero)");
                    temp = data.readLine();

                    if(temp.equals("mago")) { // The mage take damage
                        mago.dealDamage(ladro.getMagicAttack(), ladro.getPhysicalAttack());
                        ladro.endStealth();
                    } else if (temp.equals("guerriero")) { // The warrior take damage
                        guerriero.dealDamage(ladro.getMagicAttack(), ladro.getPhysicalAttack());
                        ladro.endStealth();
                    } else {
                        System.out.println("Hai sbagliato ad inserire i dati");
                    }
                    break;
                case "guerriero": // The warrior deal Damge
                    warriorSpAb();
                    System.out.println("Dimmi il nome del personaggio difensore (mago,ladro)");
                    temp = data.readLine();

                    if(temp.equals("mago")) { // The mage take damage
                        mago.dealDamage(guerriero.getMagicAttack(), guerriero.getPhysicalAttack());
                        guerriero.endCallToWar();
                    } else if (temp.equals("ladro")) { // The thief take damage
                        ladro.dealDamage(guerriero.getMagicAttack(), guerriero.getPhysicalAttack());
                        guerriero.endCallToWar();
                    } else {
                        System.out.println("Hai sbagliato ad inserire i dati");
                    }
                    break;
            }
        } catch (IOException e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
    }
    public void warriorSpAb() { //
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);

        try {
            System.out.println("Vuoi che il guerriero utilizi la sua abilità speciale?");
            if(data.readLine().equals("si") && !abilityWarrior) {
                guerriero.callToWar(400,300);
                abilityWarrior = true;
            } else if (abilityWarrior) {
                System.out.println("È già stata utilizata quest'abilità per questo personaggio");
            } else {
                System.out.println("Abilità non utilizata");
            }
        } catch (Exception e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
    }
    public void thiefSpAb() {
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);
        try {
            System.out.println("Vuoi che il ladro utilizi la sua abilità speciale?");
            if(data.readLine().equals("si") && !abilityThief) {
                ladro.stealth(400);
                abilityThief = true;
            } else if (abilityThief) {
                System.out.println("È già stata utilizata quest'abilità per questo personaggio");
            } else {
                System.out.println("Abilità non utilizata");
            }
        } catch (Exception e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
    }

    public void mageSpAb() {
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader data = new BufferedReader(keyboard);
        try {
            System.out.println("Vuoi che il mago utilizi la sua abilità speciale?");
            if(data.readLine().equals("si") && !abilityMage) {
                mago.magicWand(400);
                abilityMage = true;
            } else if (abilityMage) {
                System.out.println("È già stata utilizata quest'abilità per questo personaggio");
            } else {
                System.out.println("Abilità non utilizata");
            }
        } catch (Exception e) {
            LOGGER.severe("Si è verificata un'eccezione di tipo IOException: " + e.getMessage());
            LOGGER.severe("Stack trace:");
            e.printStackTrace();
        }
    }
    // Say the ability of the player
    public void sayAbility() {
        // Thief
        System.out.println(ladro.getName() + " Il ladro " + ladro.getType() + " ha queste statistiche: ");
        System.out.println("Punti vita: " + ladro.getLifePoints());
        System.out.println("Difesa fisica: " + ladro.getPhysicalDefense());
        System.out.println("Attacco fisico: " + ladro.getPhysicalAttack());
        System.out.println("Difesa magica: " + ladro.getMagicDefense());
        System.out.println("Attacco magico: " + ladro.getMagicAttack());
        // Mage
        System.out.println(mago.getName() + " Il mago " + mago.getType() + " ha queste statistiche: ");
        System.out.println("Punti vita: " + mago.getLifePoints());
        System.out.println("Difesa fisica: " + mago.getPhysicalDefense());
        System.out.println("Attacco fisico: " + mago.getPhysicalAttack());
        System.out.println("Difesa magica: " + mago.getMagicDefense());
        System.out.println("Attacco magico: " + mago.getMagicAttack());
        // Warrior
        System.out.println(guerriero.getName() + " Il guerriero " + guerriero.getType() + " ha queste statistiche: ");
        System.out.println("Punti vita: " + guerriero.getLifePoints());
        System.out.println("Difesa fisica: " + guerriero.getMagicDefense());
        System.out.println("Attacco fisico: " + guerriero.getPhysicalAttack());
        System.out.println("Difesa magica: " + guerriero.getMagicDefense());
        System.out.println("Attacco magico: " + guerriero.getMagicAttack());
    }
}


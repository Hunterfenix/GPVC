package net.teapot;

public class Game {
    Game() {
        Guerriero giacomo = new Guerriero(256,90,100,80,4);
        giacomo.setType(Personaggio.Type.GIGANTE);
        giacomo.setName("giacomo");
        Ladro umberto = new Ladro(100,20,60,20,40);
        umberto.setType(Personaggio.Type.NANO);
        umberto.setName("umberto");
        System.out.println("Un guerriero, un ladro e, un mago entrano in una taverna:" +
                           "Dopo qualche sguardo inizia una rissa." + "");
    }

}

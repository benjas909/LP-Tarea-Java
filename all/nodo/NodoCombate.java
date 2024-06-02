package all.nodo;

import all.personaje.*;

import java.util.ArrayList;

public class NodoCombate extends Nodo {
    private Personaje stranger; // Enemigo al que se debe enfrentar el jugador.

    /**
     * Realiza el combate informándole al usuario los resultados de cada ataque
     * realizado y determina al ganador
     */
    public void interactuar(Jugador player){
        System.out.printf("Te has encontrado con un %s.\n", this.stranger.getNombre());
        System.out.println("Presiona enter para continuar...");try{        System.in.read();}catch(Exception e){	e.printStackTrace();}
        player.combate(this.stranger);

    }

    public NodoCombate(int ID) {
        super(ID);
        //System.out.println(this.getId() + ": Nodo combate");
        this.stranger = new Personaje();
        //System.out.println(this.stranger.getNombre());
    }
}

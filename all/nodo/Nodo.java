package all.nodo;

import java.util.ArrayList;
import all.personaje.*;

public abstract class Nodo {

    private int id; // Identificador, opcional pero puede ser util para generar el mapa.
    private ArrayList<Nodo> siguientes_nodos; // Lista de nodos a los que se puede avanzar desde el actual.

    public void agregarNodo(Nodo node) {
        siguientes_nodos.add(node);
    } // Agrega un nodo a la lista de siguientes nodos.

    public int getId() {
        return this.id;
    }

    public ArrayList<Nodo> getSiguientes_nodos() {
        return siguientes_nodos;
    }

    public abstract void interactuar(Jugador player);

    public Nodo(int ID) {
        this.id = ID;
        this.siguientes_nodos = new ArrayList<Nodo>();
    }
}

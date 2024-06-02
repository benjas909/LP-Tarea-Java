package all;
import all.GraphGenerator.Edge;
import all.nodo.*;
import all.personaje.Jugador;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;

public class Mapa {

    private int profundidad; // Cantidad de niveles que tiene el mapa, sin contar el inicio y final.
    private NodoInicial nodo_inicial; // Nodo inicial.
    private Nodo nodo_actual; // Nodo actual donde se encuentra el jugador.
    // private ArrayList<Nodo> nodosMapa;

    /**
     * Permite al usuario ver el mapa completo (queda a su criterio si se muestra el
     * mapa completo, se muestra nivel a nivel o de otra forma).
     */
    public void verMapa(SortedSet<Edge> edSet){
        for (Edge e : edSet) {
            System.out.printf("(%d) -> (%d)\n", e.x, e.y);
        }
    }

    /**
     * Le muestra al usuario los nodos a los que puede avanzar, le pide seleccionar
     * uno
     * y hace al jugador interactuar con ese nodo.
     */
    public void avanzar(Map<Integer, Nodo> nodeDict){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> validNodes = new ArrayList<Integer>();
        int choice;
        while(true) {
            System.out.println("Elige uno de los siguientes nodos para avanzar:");
            for (Nodo node : this.nodo_actual.getSiguientes_nodos()) {
                validNodes.add(node.getId());
                System.out.println("->(" + node.getId() + ")");
            }
            choice = in.nextInt();
            if (validNodes.contains(choice)){
                break;
            }
            System.out.println("Ingrese un nodo válido.");
        }
        this.nodo_actual = nodeDict.get(choice);
    }

    public int getProfundidad() {
        return this.profundidad;
    }
    public NodoInicial getNodo_inicial() {
        return this.nodo_inicial;
    }

    public Nodo getNodo_actual() {
        return this.nodo_actual;
    }

    /**
     * Menú para seleccionar las acciones a realizar
     * @param player: jugador que usará el menú
     * @param nodeDict: Diccionario de nodos del mapa
     * @param edSet: Set de arcos del mapa
     */
    public void menu(Jugador player, Map<Integer, Nodo> nodeDict, SortedSet<Edge> edSet) {
        while(true){
            System.out.println("Menu:\n\t1) Ver Items.\n\t2) Ver Stats.\n\t3) Ver Mapa.\n\t4) Avanzar.");
            Scanner in = new Scanner(System.in);
            int selected;
            selected = in.nextInt();
            switch (selected) {
                case 1:
                    player.verItems();
                    break;
                case 2:
                    player.verEstado();
                    break;
                case 3:
                    this.verMapa(edSet);
                    break;

                case 4:
                    this.avanzar(nodeDict);
                    return;
                default:
                    System.out.println("Ingrese una opción válida.");
            }
        }
    }

    public Mapa(int depth, NodoInicial initialNode) {
        this.profundidad = depth;
        this.nodo_inicial = initialNode;
        this.nodo_actual = initialNode;
    }

}

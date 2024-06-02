import java.util.*;

import all.GraphGenerator.*;
import all.nodo.*;
import all.personaje.*;
import all.Mapa;

public class JavaQuest {

    /**
     * Retorna un elemento aleatorio de un array
     * @param array: arreglo de int
     * @return int: indice random en un arreglo
     */
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * Inicializa el mapa
     * @param edges: Set de aristas del mapa
     * @return Map: Diccionario de nodos, su key es el ID de cada nodo
     */
    public static Map<Integer, Nodo> initializeGameMap(SortedSet<Edge> edges) {
        int[] types = {
                1, 1, 1, 2, 3, 3, 3, 3, 3, 3
        };
        NodoInicial inicio = new NodoInicial(0);
        int nodeType;
        Map<Integer, Nodo> dictNodo = new HashMap<>();
        dictNodo.put(0, inicio);

        Nodo currNode = inicio;
        for (Edge e : edges) {
            if (!dictNodo.containsKey(e.x)) {
                nodeType = getRandom(types);
                if (nodeType == 1) {
                    currNode = new NodoEvento(e.x);
                } else if (nodeType == 2) {
                    currNode = new NodoTienda(e.x);
                } else {
                    currNode = new NodoCombate(e.x);
                }
                dictNodo.put(e.x, currNode);
            }
            // System.out.println(currNode.getId());
        }
        currNode = new NodoJefeFinal(currNode.getId() + 1);
        dictNodo.put(currNode.getId(), currNode);

        for (Edge ed : edges) {
            currNode = dictNodo.get(ed.x);
            currNode.agregarNodo(dictNodo.get(ed.y));
        }
        return dictNodo;
    }

    public static void main(String[] args) {
        // System.out.println("Esta es la clase Main de mi tarea.");

        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese un nombre para su personaje: ");
        String nombre = in.nextLine();

        Jugador player = new Jugador(nombre);
        //player.verEstado();

        System.out.println("Profundidad del mapa:");
        int depth = in.nextInt();

        SortedSet<Edge> edges = GraphGenerator.Generar(5);

        Map<Integer, Nodo> dictNodo = initializeGameMap(edges);
        Mapa gameMap = new Mapa(depth, (NodoInicial) dictNodo.get(0));
        // dictNodo.get(0).interactuar(player);

        while (true) {
            gameMap.getNodo_actual().interactuar(player);
            if (player.isDead()) {
                System.out.println("Juego Terminado. Gracias por jugar.");
                return;
            }
            if (gameMap.getNodo_actual() instanceof NodoJefeFinal){
                break;
            }
            gameMap.menu(player, dictNodo, edges);
        }

    }
}

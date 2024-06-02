package all.nodo;

import java.util.ArrayList;
import java.util.Scanner;

import all.Item;
import all.personaje.*;

/**
 * Lista de posibles cosas que podría tener la tienda:
 * - Uniforme de refugio {número random}
 * - Armas
 * - Comida
 * - Armadura
 * Cada una de estas categorías debería ser una lista desde la que se elijan 3 objetos de manera aleatoria
 * para agregar al inventario de la tienda
 * */

public class NodoTienda extends Nodo {
    private Item[] inventario; // Lista de items disponibles para comprar.
    private ArrayList<Item> wearables;
    private ArrayList<Item> weapons;
    private ArrayList<Item> food;

    /**
     * Aplica el item en la posición indicada al jugador
     * 
     * @param pos: posición del item en el inventario de la tienda
     * @param player : jugador al que se le otorga el producto comprado
     * 
     */
    public void comprar(Jugador player, int pos){
        if (player.getDinero() - this.inventario[pos].getPrecio() < 0){
            System.out.println("No tienes suficiente dinero. Presiona 0 para salir.");
            return;
        }
        player.setDinero(player.getDinero() - this.inventario[pos].getPrecio());
        System.out.printf("Has comprado %s\n", this.inventario[pos].getNombre());
        this.inventario[pos].aplicar(player);


    }

    /**
     * Le muestra los items en el inventario de la tienda al usuario y cuanto dinero
     * tiene a su disposición. Le permite comprar tantos items como quiera.
     */
    public void interactuar(Jugador player){
        System.out.println("Te has encontrado con un mercader, quien te ofrece los siguientes productos (Presiona el número del producto para comprar, o presiona cualquier otra tecla para salir).");
        int choice = -1;
        int offset = 1;
        System.out.println("Bottle Caps: " + player.getDinero());

        for (Item item : this.inventario) {
            System.out.printf("%d) %s\n\tPrecio %d\n", offset, item.getNombre(), item.getPrecio());
            offset++;
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            choice = in.nextInt();
            if(choice == 0){
                return;
            }
            comprar(player, choice - 1);
        }
    }

    public NodoTienda(int ID) {
        super(ID);
        //System.out.println(this.getId() + ": Nodo tienda");
        this.inventario = new Item[6];
        Item halfFullNukaCola = new Item("Botella de Nuka Cola a medio tomar.", 30, 10, 0, 0, 0);
        this.inventario[0] = halfFullNukaCola;
        Item NukaColaBottle = new Item("Botella de Nuka Cola.", 50, 15, 0, 0, 0);
        this.inventario[1] = NukaColaBottle;
        Item NukaColaQuantum = new Item("Nuka Cola Quantum.", 75, 20, 20, 0, 0);
        this.inventario[2] = NukaColaQuantum;
        Item rustyPistol = new Item("Pistola oxidada.", 50, 0, 0, 7, 0);
        this.inventario[3]= rustyPistol;
        Item shotgun = new Item("Escopeta.", 80, 0, 0, 14, 0);
        this.inventario[4] = shotgun;
        Item powerArmor = new Item("Power Armor.", 350, 0, 30, 0, 10);
        this.inventario[5] = powerArmor;
    }
}

package all.nodo;

import all.Item;
import all.personaje.*;

import java.util.Scanner;

public class NodoEvento extends Nodo {
    private String descripcion; // Pequeña historia que describe lo que está pasando.
    private String alternativa1; // Opciones que puede tomar el jugador.
    private String alternativa2;
    private Item resultado1; // Recompensas al superar el evento.
    private Item resultado2;

    /**
     * Le muestra al usuario la descripci´on del evento y las alternativas que puede
     * seleccionar (No se muestran expl´ıcitamente las recompensas asociadas a cada
     * alternativa).
     * Cuando el usuario selecciona una alternativa se le aplica la recompensa
     * correspondiente.
     */
    public void interactuar(Jugador player){
        String[] texts = {"Has encontrado a un niño perdido, y te dice que si lo ayudas a volver donde su familia te regalará una pistola, pero si no lo haces, tienes la opción de robarle su botella de Nuka Cola"};
        System.out.printf("%s\n\t1) Ayudar al niño\n\t2) Robarle su botella\n", texts[0]);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1:
                Item pistola = new Item("Pistola", 0, 0, 0, 10, 0);
                pistola.aplicar(player);
                System.out.println("Has devuelto al niño con su familia y te han regalado una pistola.");
                break;
            case 2:
                Item NukaColaQuantum = new Item("Nuka Cola Quantum", 0, 20, 20, 0, 0);
                NukaColaQuantum.aplicar(player);
                System.out.println("Le has robado la botella de Nuka Cola Quantum al niño.");
                break;
            default:
                System.out.println("Has ignorado al niño.");
                break;
        }
    }

    public NodoEvento(int ID) {
        super(ID);
        //System.out.println(this.getId() + ": Nodo evento");
    }
}

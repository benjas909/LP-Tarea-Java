package all.personaje;

import java.util.ArrayList;
import all.Item;

public class Jugador extends Personaje {

    private ArrayList<Item> items_aplicados; // Lista de Items adquiridos por el personaje.

    public void verEstado(){
        super.verEstado();
    } // Muestra los atributos actuales del jugador

    public void verItems(){
        if(items_aplicados.size() == 0){
            System.out.println("Aún no has obtenido items.");
            return;
        }
        for(Item it : this.items_aplicados){
            System.out.printf("%s:\n\tAumento de HP actual: %d\n\tAumento de HP total: %d\n\tAumento de daño: %d\n\tAumento de defensa: %d",it.getNombre(), it.getRecuperar_hp(), it.getAumentar_hp_total(), it.getAumentar_danio(), it.getAumentar_defensa());
        }
    } // Muestra los items adquiridos por el jugador.

    /**
     * Agrega un item a la lista de items del jugador
     * @param item
     */
    public void addItem(Item item) {
        this.items_aplicados.add(item);
    }

    public Jugador(String nombre) {
        super(nombre, 500, 20, 20, 5, 1);
        this.items_aplicados = new ArrayList<Item>();
    }
}

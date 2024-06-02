package all;
import all.personaje.*;

public class Item {
    private String nombre;
    private int precio; // Costo del item en la tienda.
    private int recuperar_hp; // Cantidad de hp que recupera al jugador.
    private int aumentar_hp_total; // Cantidad de hp_total que aumenta al jugador. No afecta a hp_actual.
    private int aumentar_danio; // Canridad de danio que aumenta al jugador.
    private int aumentar_defensa; // Cantidad de defensa que aumenta al jugador.

    // Agrega el item a la lista de items y aplica sus efectos.
    public void aplicar(Jugador person){
        person.setHp_total(person.getHp_total() + this.aumentar_hp_total);
        person.setHp_actual(person.getHp_actual() + this.recuperar_hp);
        person.setDanio(person.getDanio() + this.aumentar_danio);
        person.setDefensa(person.getDefensa() + this.aumentar_defensa);
        person.addItem(this);

    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getRecuperar_hp() {
        return this.recuperar_hp;
    }

    public int getAumentar_hp_total() {
        return this.aumentar_hp_total;
    }

    public int getAumentar_danio() {
        return this.aumentar_danio;
    }

    public int getAumentar_defensa() {
        return this.aumentar_defensa;
    }

    public Item(String name, int price, int hpRest, int totalHPIncrease, int damageInc, int defIncrease){
        this.nombre = name;
        this.precio = price;
        this.recuperar_hp = hpRest;
        this.aumentar_hp_total = totalHPIncrease;
        this.aumentar_danio = damageInc;
        this.aumentar_defensa = damageInc;
    }
}

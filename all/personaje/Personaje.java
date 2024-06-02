package all.personaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Personaje {

    private String nombre; // Nombre del personaje.
    private int dinero; // Cantidad de dinero del personaje, si es un enemigo, representa su loot.
    private int hp_actual; // Puntos de vida actual del personaje, no debe ser mayor a hp_total.
    private int hp_total; // Cantidad máxima de vida que puede tener el personaje.
    private int danio; // Cantidad de vida que le resta a su oponente al combatir (antes de aplicar
                       // defensa).
    private int defensa; // Cantidad de danio evitado por golpe al combatir.

    private ArrayList<String> creatureNames;

    public void combate(Personaje stranger){

        int randint = ThreadLocalRandom.current().nextInt(1, 3);
        if (randint == 1){
            while (true) {

                int damGiven = this.danio - stranger.getDefensa();
                if(damGiven < 0){
                    damGiven = 0;
                }
                stranger.setHp_actual(stranger.getHp_actual() - damGiven);
                System.out.printf("El %s ha recibido %d puntos de daño\n", stranger.getNombre(), this.danio - stranger.getDefensa());
                if(stranger.isDead()) {
                    System.out.printf("Has matado al %s. Has obtenido %d Bottle Caps.\n", stranger.getNombre(), stranger.getDinero());
                    this.setDinero(this.dinero + stranger.getDinero());
                    return;
                }
                int damTaken = stranger.getDanio() - this.defensa;
                if(damTaken < 0){
                    this.hp_actual = 0;
                }
                this.hp_actual -= damTaken;
                System.out.printf("Has recibido %d puntos de daño\n", stranger.getDanio() - this.defensa);

                if(this.isDead()) {
                    System.out.println("Has muerto.");
                    return;
                }
                System.out.println("Presiona enter para continuar...");try{        System.in.read();}catch(Exception e){	e.printStackTrace();}
            }
        } else {
            while (true) {
                int damTaken = stranger.getDanio() - this.defensa;
                if(damTaken < 0){
                    this.hp_actual = 0;
                }
                this.hp_actual -= damTaken;
                System.out.printf("Has recibido %d puntos de daño\n", stranger.getDanio() - this.defensa);

                if(this.isDead()) {
                    System.out.println("Has muerto.");
                    return;
                }
                int damGiven = this.danio - stranger.getDefensa();
                if(damGiven < 0){
                    damGiven = 0;
                }
                stranger.setHp_actual(stranger.getHp_actual() - damGiven);
                System.out.printf("El %s ha recibido %d puntos de daño\n", stranger.getNombre(), this.danio - stranger.getDefensa());
                if(stranger.isDead()) {
                    System.out.printf("Has matado al %s. Has obtenido %d Bottle Caps.\n", stranger.getNombre(), stranger.getDinero());
                    this.setDinero(this.dinero + stranger.getDinero());
                    return;
                }
                System.out.println("Presiona enter para continuar...");try{        System.in.read();}catch(Exception e){	e.printStackTrace();}
            }
        }
    }

    public void verEstado(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Bottle Caps: " + this.dinero);
        System.out.println("HP actual: " + this.hp_actual + "/" + this.hp_total);
        System.out.println("Daño: " + this.danio);
        System.out.println("Defensa: " + this.defensa);
    }

    /**
     * Revisa si el jugado está muerto
     * @return true si el jugador lo está, false si no
     */
    public boolean isDead() {
        return this.hp_actual <= 0;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDanio() {
        return danio;
    }

    public int getDinero() {
        return dinero;
    }

    public int getHp_actual() {
        return hp_actual;
    }

    public int getHp_total() {
        return hp_total;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getCreatureNames() {
        return creatureNames;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public void setDinero(int amount) {
        this.dinero = amount;
    }

    public void setCreatureNames(ArrayList<String> creatureNames) {
        this.creatureNames = creatureNames;
    }

    public void setHp_total(int hp_total) {
        this.hp_total = hp_total;
    }

    public void setHp_actual(int hp_actual) {
        this.hp_actual = hp_actual;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public Personaje(String name, int money, int currHP, int totalHP, int damage, int defense){
        this.nombre = name;
        this.dinero = money;
        this.hp_actual = currHP;
        this.hp_total = totalHP;
        this.danio = damage;
        this.defensa = defense;
    }

    public Personaje() {
        this.creatureNames = new ArrayList<String>(Arrays.asList("Ghoul", "Mirelurk", "Mole Rat", "Rad Roach", "Radscorpion"));
        Random r = new Random();
        this.nombre = this.creatureNames.get(r.nextInt(this.creatureNames.size()));
        this.dinero = ThreadLocalRandom.current().nextInt(50, 150 + 1);
        this.hp_total = ThreadLocalRandom.current().nextInt(5,10);
        this.hp_actual = this.hp_total;
        this.danio = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        this.defensa = ThreadLocalRandom.current().nextInt(1, 3 + 1);


    }
}

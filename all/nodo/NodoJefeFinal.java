package all.nodo;

import all.personaje.*;

public class NodoJefeFinal extends Nodo {
    private Personaje jefe; // Jefe al que se debe enfrentar el jugador.

    /**
     * Realiza el combate informándole al usuario los resultados de cada ataque
     * realizado y determina al ganador
     */
    public void interactuar(Jugador player){
        System.out.println("Has llegado a la guarida de The Master, esta es tu primera y única oportunidad de acabar con él");
        System.out.println("Presiona enter para continuar...");try{        System.in.read();}catch(Exception e){	e.printStackTrace();}
        player.combate(this.jefe);
        if (jefe.isDead()){
            System.out.println("Lo lograste, tu misión ha terminado, puedes volver a tu hogar y descansar... por ahora.");
            return;
        }
    }

    /**
     *
     * @return boolean: true si el boss está muerto, false si no.
     */
    public boolean isBossDead() {
        return this.jefe.getHp_actual() <= 0;
    }

    public NodoJefeFinal(int ID) {
        super(ID);
        this.jefe = new Personaje("The Master", 500, 30, 30, 15, 5);
        //System.out.println(this.getId() + ": Nodo jefe final");
        //System.out.println(this.jefe.getNombre());
    }
}

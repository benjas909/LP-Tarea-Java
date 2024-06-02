package all.nodo;
import all.personaje.*;

public class NodoInicial extends Nodo {

    /**
     * Le muestra al usuario una introducción al juego (Historia e
     * Instrucciones).
     */
    public void interactuar(Jugador player){
        System.out.printf("Tu nombre es %s, estás en lo que parece ser un desierto, pero no lo es, sino que te encuentras en un nuevo mundo destruido por la guerra nuclear, y a lo lejos escuchas una voz en una radio, la cual se hace llamar The Master,desde este momento sabes que tu misión es acabar con este ser.\n", player.getNombre());
        System.out.println("Press enter to continue...");try{        System.in.read();}catch(Exception e){	e.printStackTrace();}


    } //

    public NodoInicial(int ID) {
        super(ID);
        //System.out.println(this.getId() + ": Nodo Inicial");
    }
}

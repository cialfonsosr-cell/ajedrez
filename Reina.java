import java.util.ArrayList;
import java.util.List;

public class Reina  extends Pieza{


     private List<Casilla> movimientosPosibles;


    public Reina(Casilla c, String color) {
        super(c, color, 9,'Q');
         this.movimientosPosibles = new ArrayList<>();
        }   


public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


    }
    



    


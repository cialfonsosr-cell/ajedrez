import java.util.ArrayList;
import java.util.List;

public class Rey  extends Pieza{


     private List<Casilla> movimientosPosibles;


    public Rey(Casilla c, String color) {
        super(c, color, 999, 'K');
         this.movimientosPosibles = new ArrayList<>();
        }   


public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


    }
    



    


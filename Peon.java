import java.util.ArrayList;
import java.util.List;

public class Peon  extends Pieza{


     private List<Casilla> movimientosPosibles;


    public Peon(Casilla c, String color) {
        super(c, color, 1, 'P');
         this.movimientosPosibles = new ArrayList<>();
        }   


public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


    }
    



    


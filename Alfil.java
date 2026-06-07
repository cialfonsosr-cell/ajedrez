import java.util.ArrayList;
import java.util.List;

public class Alfil  extends Pieza{


     private List<Casilla> movimientosPosibles;


    public Alfil(Casilla c, String color) {
        super(c, color, 3, 'A');
         this.movimientosPosibles = new ArrayList<>();
        }   


public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


    }
    



    


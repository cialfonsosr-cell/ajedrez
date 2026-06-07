import java.util.ArrayList;
import java.util.List;

public class Caballo   extends Pieza{


     private List<Casilla> movimientosPosibles;


    public Caballo(Casilla c, String color) {
        super(c, color, 3, 'C');
         this.movimientosPosibles = new ArrayList<>();
        }   


public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


    }
    



    


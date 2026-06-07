import java.util.ArrayList;
import java.util.List;

public class Torre extends Pieza{


    private List<Casilla> movimientosPosibles;
    
    
    public Torre(Casilla c, String color) {
        super(c, color, 5, 'T');

        this.movimientosPosibles = new ArrayList<>();
       
}



public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


}

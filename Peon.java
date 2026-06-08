import java.util.ArrayList;
import java.util.List;

public class Peon  extends Pieza{

    private boolean  primerMovimiento ;
     private List<Casilla> movimientosPosibles;


    public Peon(Casilla c, String color) {
        super(c, color, 1, 'P');
         this.movimientosPosibles = new ArrayList<>();
        primerMovimiento = true;
        }  


public void añadirMovimientoPosible (Casilla c){

    movimientosPosibles.add(c);
    
}


public void gastarPrimerMovimiento (){
    this.primerMovimiento = false;
}

public boolean getPrimerMovimiento (){
    return this.primerMovimiento;
}


    }
    



    


public class Casilla {
    
    private int fila ;
    private int columna; 
    private boolean ocupada;
    private Pieza pieza;
    private String color;
    
public Casilla (int fila, int columna, boolean ocupada, Pieza pieza, String color) {
    this.fila = fila;
    this.columna = columna;
    this.ocupada = ocupada;
    this.pieza = pieza;
    this.color = color;
    
    
}

public boolean estaOcupada() {
    return this.pieza != null;
}

public int posFila (){

    return this.fila;

}

public int posColumna (){

    return this.columna;

}

public Pieza getPieza (){

    return this.pieza;

}

public String getColor (){

    return this.color;

}

public void setPieza ( Pieza p){
    this.pieza = p;
    this.ocupada = true;
}

public void borrarPieza(){
    this.pieza = null;
}





}

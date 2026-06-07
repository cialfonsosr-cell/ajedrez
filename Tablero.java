



public class Tablero {

    private final int numFilas = 8;
    private final int numColumnas = 8;
    private String nombre;

    private Casilla[][] tablero ;



public int transformarDeLetraANumero (char casilla){
    if(casilla == 'A') return 1;
    if(casilla == 'B') return 2;
    if(casilla == 'C') return 3;
    if(casilla == 'D') return 4;
    if(casilla == 'E') return 5;
    if(casilla == 'F') return 6;
    if(casilla == 'G') return 7;
    if(casilla == 'H') return 8;

    return -1;
}

public Tablero (String nombre){

this.nombre = nombre;
this.tablero = new Casilla[numFilas][numColumnas];
}


public boolean casillaOcupadaEnTablero (char fila, int columna){

    int fil = transformarDeLetraANumero(fila);

    
    return this.tablero[fil][columna].estaOcupada();

}

public Pieza piezaDePosicion (char fila, int columna){

    int fil = transformarDeLetraANumero(fila);

    
    return this.tablero[fil][columna].getPieza();

}

public void rellenarTableroInicial (){

    int colorNum = 0;
    for (int i = 0; i < this.numFilas; i++) {
        for (int j = 0; j < this.numColumnas; j++) {
String color;

            if ((i + j) % 2 == 0) {
                    color = "BLANCO";
                } else {
                  color = "NEGRO";
                }
      

        Casilla c = new Casilla(i, j, false, null, color);
        tablero[i][j] = c;

           Pieza p = null; 
            if(i== 1){
              
                p = new Peon(tablero[i][j],"BLANCO");
               
            }
            if(i == numFilas - 2 ){
                  p = new Peon(tablero[i][j],"NEGRO");
            }

           

            if(i == 0){
                if(j == 0 || j == numColumnas -1){
                     p = new Torre(tablero[i][j],"BLANCO");
                }
                if(j == 1 || j == numColumnas -2){
                     p = new Caballo(tablero[i][j],"BLANCO");
                }
                if(j == 2 || j == numColumnas -3){
                     p = new Alfil(tablero[i][j],"BLANCO");
                }
                 if(j == 3 ){
                     p = new Reina(tablero[i][j],"BLANCO");
                }
                if(j == numColumnas-4 ){
                    p = new Rey(tablero[i][j], "BLANCO");
                }

            }

            if(i == numFilas -1){
                if(j == 0 || j == numColumnas -1){
                     p = new Torre(tablero[i][j],"NEGRO");
                }
                if(j == 1 || j == numColumnas -2){
                     p = new Caballo(tablero[i][j],"NEGRO");
                }
                if(j == 2 || j == numColumnas -3){
                     p = new Alfil(tablero[i][j],"NEGRO");
                }
                 if(j == 3 ){
                     p = new Reina(tablero[i][j],"NEGRO");
                }
                if(j == numColumnas-4 ){
                    p = new Rey(tablero[i][j], "NEGRO");
                }

            }


             c.setPieza(p);

           
        }
    }



}


public boolean[][] calcularMovimientosPosiblesTorre (Pieza t){

    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();
 
    //movimiento hacia la derecha
    int i = t.getCasiila().posFila();
    for(int j = t.getCasiila().posColumna() + 1; j< numColumnas ; j++){
        if(casillas[i][j].estaOcupada()){

            if(!casillas[i][j].getPieza().getColor().equals(casillas[i][t.getCasiila().posColumna()].getPieza().getColor())){
                matriz[i][j] = true;
            }

            
            break;
        }
        else{
            matriz[i][j] = true;
        }
    }
    //movimiento hacia la izquierda 
     for(int j = t.getCasiila().posColumna() - 1; j>= 0; j--){
         if(casillas[i][j].estaOcupada()){

            if(!casillas[i][j].getPieza().getColor().equals(casillas[i][t.getCasiila().posColumna()].getPieza().getColor())){
                matriz[i][j] = true;
            }

             break;
        }
        else{
            matriz[i][j] = true;
        }
    }

    // //arriba
    int j = t.getCasiila().posColumna();
    for(int i2 = t.getCasiila().posFila() + 1; i2< numFilas; i2++){
        if(casillas[i2][j].estaOcupada()){

            if(!casillas[i2][j].getPieza().getColor().equals(casillas[i2][t.getCasiila().posColumna()].getPieza().getColor())){
                matriz[i2][j] = true;
            }
                break;
            

        }
        else{
            matriz[i2][j] = true;
        }
    }
    
    //Abajo
    for(int i2 = t.getCasiila().posFila() -1 ; i2 >= 0; i2--){
        if(casillas[i2][j].estaOcupada()){

            if(!casillas[i2][j].getPieza().getColor().equals(casillas[i2][t.getCasiila().posColumna()].getPieza().getColor())){
                matriz[i2][j] = true;
            }

             break;

        }
        else{
            matriz[i2][j] = true;
        }
    }



        
    

return matriz;
}

public Casilla[][] getTablero (){

    return this.tablero;

}


}

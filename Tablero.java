



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
              
                p = new Peon(tablero[i][j],"NEGRO");
               
            }
            if(i == numFilas - 2 ){
                  p = new Peon(tablero[i][j],"BLANCO");
            }

           

            if(i == 0){
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

            if(i == numFilas -1){
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


             c.setPieza(p);

           
        }
    }



}


public boolean[][] calcularMovimientosPosiblesTorre (Pieza t){

    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();

    String colorOriginal = t.getColor();
 
    //movimiento hacia la derecha
    int i = t.getCasiila().posFila();
    for(int j = t.getCasiila().posColumna() + 1; j< numColumnas ; j++){
        if(casillas[i][j].estaOcupada()){

            if(!casillas[i][j].getPieza().getColor().equals(colorOriginal)){
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

            if(!casillas[i][j].getPieza().getColor().equals(colorOriginal)){
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

            if(!casillas[i2][j].getPieza().getColor().equals(colorOriginal)){
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

            if(!casillas[i2][j].getPieza().getColor().equals(colorOriginal)){
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



public boolean[][] calcularMovimientosPosiblesAlfin (Pieza t){


    String colorOriginal = t.getColor();
    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();
 
    //movimiento hacia la Arriba-derecha
    int i = t.getCasiila().posFila() - 1;
    int j = t.getCasiila().posColumna() +1;
    
    while (i>=0 && j < numColumnas){
        if(casillas[i][j].estaOcupada()){

            if(!casillas[i][j].getPieza().getColor().equals(colorOriginal)){
                matriz[i][j] = true;
            }

            break;
            
        }
        else{
            matriz[i][j] = true;
        }
        i--;
        j++;
    }
    
    //movimiento hacia la arriba-izquierda 
    int i2 = t.getCasiila().posFila() - 1;
    int j2 = t.getCasiila().posColumna() - 1;
    
    while (i2>=0 && j2 >= 0){
        if(casillas[i2][j2].estaOcupada()){

            if(!casillas[i2][j2].getPieza().getColor().equals(colorOriginal)){
                matriz[i2][j2] = true;
            }

            break;
            
        }
        else{
            matriz[i2][j2] = true;
        }
        i2--;
        j2--;
    }

    //abajo-derecha
    int i3 = t.getCasiila().posFila() + 1;
    int j3 = t.getCasiila().posColumna() + 1;
    
    while (i3 < numFilas && j3 < numColumnas){
        if(casillas[i3][j3].estaOcupada()){

            if(!casillas[i3][j3].getPieza().getColor().equals(colorOriginal)){
                matriz[i3][j3] = true;
            }

            break;
            
        }
        else{
            matriz[i3][j3] = true;
        }
        i3++;
        j3++;
    }
    //Abajo-izquierda
    int i4 = t.getCasiila().posFila() + 1;
    int j4 = t.getCasiila().posColumna() - 1;
    
    while (i4 < numFilas && j4 >=0){
        if(casillas[i4][j4].estaOcupada()){

            if(!casillas[i4][j4].getPieza().getColor().equals(colorOriginal)){
                matriz[i4][j4] = true;
            }

            break;
            
        }
        else{
            matriz[i4][j4] = true;
        }
        i4++;
        j4--;
    }
    



        
    

return matriz;

}



public boolean[][] calcularMovimientosPosiblesReina (Pieza t){
   

    String colorOriginal = t.getColor();
    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();

     //movimiento hacia la derecha
    int i = t.getCasiila().posFila();
    for(int j = t.getCasiila().posColumna() + 1; j< numColumnas ; j++){
        if(casillas[i][j].estaOcupada()){

            if(!casillas[i][j].getPieza().getColor().equals(colorOriginal)){
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

            if(!casillas[i][j].getPieza().getColor().equals(colorOriginal)){
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

            if(!casillas[i2][j].getPieza().getColor().equals(colorOriginal)){
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

            if(!casillas[i2][j].getPieza().getColor().equals(colorOriginal)){
                matriz[i2][j] = true;
            }

             break;

        }
        else{
            matriz[i2][j] = true;
        }
    }




 


    //movimiento hacia la Arriba-derecha
    int i5 = t.getCasiila().posFila() - 1;
    int j5 = t.getCasiila().posColumna() +1;
    
    while (i5>=0 && j5 < numColumnas){
        if(casillas[i5][j5].estaOcupada()){

            if(!casillas[i5][j5].getPieza().getColor().equals(colorOriginal)){
                matriz[i5][j5] = true;
            }

            break;
            
        }
        else{
            matriz[i5][j5] = true;
        }
        i5--;
        j5++;
    }
    
    //movimiento hacia la arriba-izquierda 
    int i2 = t.getCasiila().posFila() - 1;
    int j2 = t.getCasiila().posColumna() - 1;
    
    while (i2>=0 && j2 >= 0){
        if(casillas[i2][j2].estaOcupada()){

            if(!casillas[i2][j2].getPieza().getColor().equals(colorOriginal)){
                matriz[i2][j2] = true;
            }

            break;
            
        }
        else{
            matriz[i2][j2] = true;
        }
        i2--;
        j2--;
    }

    //abajo-derecha
    int i3 = t.getCasiila().posFila() + 1;
    int j3 = t.getCasiila().posColumna() + 1;
    
    while (i3 < numFilas && j3 < numColumnas){
        if(casillas[i3][j3].estaOcupada()){

            if(!casillas[i3][j3].getPieza().getColor().equals(colorOriginal)){
                matriz[i3][j3] = true;
            }

            break;
            
        }
        else{
            matriz[i3][j3] = true;
        }
        i3++;
        j3++;
    }
    //Abajo-izquierda
    int i4 = t.getCasiila().posFila() + 1;
    int j4 = t.getCasiila().posColumna() - 1;
    
    while (i4 < numFilas && j4 >=0){
        if(casillas[i4][j4].estaOcupada()){

            if(!casillas[i4][j4].getPieza().getColor().equals(colorOriginal)){
                matriz[i4][j4] = true;
            }

            break;
            
        }
        else{
            matriz[i4][j4] = true;
        }
        i4++;
        j4--;
    }
    



        
    

return matriz;

}


public boolean[][] calcularMovimientosPosiblesPeon (Pieza t){
   
    String colorOriginal = t.getColor();
    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();
    Peon p = (Peon)t;


    if(t.getColor().equals("BLANCO")){
    int i = t.getCasiila().posFila();
    int j = t.getCasiila().posColumna();

    if(j > 0 && i> 0){
 if(casillas[i-1][j-1].estaOcupada()){

      if(!casillas[i-1][j-1].getPieza().getColor().equals(colorOriginal)){
            matriz[i-1][j-1] = true;
        }
 }

    }

    if(j<numColumnas-1 && i > 0){
       if( casillas[i-1][j+1].estaOcupada() ){
  if(!casillas[i-1][j+1].getPieza().getColor().equals(colorOriginal)){
            matriz[i-1][j+1] = true;
            
        }
       }
    }

   
    if(i>0){
        if(!casillas[i-1][j].estaOcupada()){
            matriz[i-1][j] = true;
        }
    }
    
    if(p.getPrimerMovimiento()){

       if(!casillas[i-1][j].estaOcupada() && !casillas[i-2][j].estaOcupada()){
            matriz[i-2][j] = true;
            p.gastarPrimerMovimiento();
        }

    }
    }


    else{

    int i = t.getCasiila().posFila();
    int j = t.getCasiila().posColumna();

    if(j > 0 && i < numFilas -1){
    if(casillas[i+1][j-1].estaOcupada()){

      if(!casillas[i+1][j-1].getPieza().getColor().equals(colorOriginal)){
            matriz[i+1][j-1] = true;
        }
 }

    }

    if(j<numColumnas-1 && i < numFilas -1){
       if( casillas[i+1][j+1].estaOcupada() ){
  if(!casillas[i+1][j+1].getPieza().getColor().equals(colorOriginal)){
            matriz[i+1][j+1] = true;
            
        }
       }
    }

   
    if(i<numFilas-1){
        if(!casillas[i+1][j].estaOcupada()){
            matriz[i+1][j] = true;
        }
    }
    
    if(p.getPrimerMovimiento()){

       if(!casillas[i+1][j].estaOcupada() && !casillas[i+2][j].estaOcupada()){
            matriz[i+2][j] = true;
            p.gastarPrimerMovimiento();
        }

    }

    }

return matriz;
}


public boolean[][] calcularMovimientosPosiblesCaballo (Pieza t){
   
    String colorOriginal = t.getColor();
    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();
    Caballo p = (Caballo)t;


    int i = t.getCasiila().posFila();
    int j = t.getCasiila().posColumna();


    //Movimiento arriba
    int iArriba = i-2;
    int jArribaDerecha = j+1;
    int jArribaIzquieda = j-1;
    if(iArriba >= 0){

        if(jArribaDerecha < numColumnas){
            if( casillas[iArriba][jArribaDerecha].estaOcupada() ){
  if(!casillas[iArriba][jArribaDerecha].getPieza().getColor().equals(colorOriginal)){
            matriz[iArriba][jArribaDerecha] = true;
            
        }
       }
       else{
        matriz[iArriba][jArribaDerecha] = true;
       }
        }


    if( jArribaIzquieda >= 0){
        if( casillas[iArriba][jArribaIzquieda].estaOcupada() ){
  if(!casillas[iArriba][jArribaIzquieda].getPieza().getColor().equals(colorOriginal)){
            matriz[iArriba][jArribaIzquieda] = true;
            
        }
       }
       else{
        matriz[iArriba][jArribaIzquieda] = true;
       }
        }
    }


    //Movimiento abajo
    int iAbajo = i+2;
    int jAbajoDerecha = j+1;
    int jAbajoIzquieda = j-1;
    if(iAbajo < numFilas){

        if(jAbajoDerecha < numColumnas){
            if( casillas[iAbajo][jAbajoDerecha].estaOcupada() ){
  if(!casillas[iAbajo][jAbajoDerecha].getPieza().getColor().equals(colorOriginal)){
            matriz[iAbajo][jAbajoDerecha] = true;
            
        }
       }
       else{
        matriz[iAbajo][jAbajoDerecha] = true;
       }
        }


    if( jAbajoIzquieda >= 0){
        if( casillas[iAbajo][jAbajoIzquieda].estaOcupada() ){
  if(!casillas[iAbajo][jAbajoIzquieda].getPieza().getColor().equals(colorOriginal)){
            matriz[iAbajo][jAbajoIzquieda] = true;
            
        }
       }
       else{
        matriz[iAbajo][jArribaIzquieda] = true;
       }
        }
    }

    //Movimiento DErecha
    int jDerecha = j+2;
    int iDerechaArriba = i-1;
    int iDerechaAbajo = i+1;
    if(jDerecha < numColumnas){

        if(iDerechaAbajo < numFilas){
            if( casillas[iDerechaAbajo][jDerecha].estaOcupada() ){
  if(!casillas[iDerechaAbajo][jDerecha].getPieza().getColor().equals(colorOriginal)){
            matriz[iDerechaAbajo][jDerecha] = true;
            
        }
       }
       else{
        matriz[iDerechaAbajo][jDerecha] = true;
       }
        }


    if( iDerechaArriba >= 0){
        if( casillas[iDerechaArriba][jDerecha].estaOcupada() ){
  if(!casillas[iDerechaArriba][jDerecha].getPieza().getColor().equals(colorOriginal)){
            matriz[iDerechaArriba][jDerecha] = true;
            
        }
       }
       else{
        matriz[iDerechaArriba][jDerecha] = true;
       }
        }
    }

//Movimiento Izquierda
    int jIzquierda = j-2;
    int iIzquiedaArriba = i-1;
    int iIzquierdaAbajo = i+1;
    if(jIzquierda >= 0){

        if(iIzquiedaArriba >= 0){
            if( casillas[iIzquiedaArriba][jIzquierda].estaOcupada() ){
  if(!casillas[iIzquiedaArriba][jIzquierda].getPieza().getColor().equals(colorOriginal)){
            matriz[iIzquiedaArriba][jIzquierda] = true;
            
        }
       }
       else{
        matriz[iIzquiedaArriba][jIzquierda] = true;
       }
        }


    if( iIzquierdaAbajo < numFilas){
        if( casillas[iIzquierdaAbajo][jIzquierda].estaOcupada() ){
  if(!casillas[iIzquierdaAbajo][jIzquierda].getPieza().getColor().equals(colorOriginal)){
            matriz[iIzquierdaAbajo][jIzquierda] = true;
            
        }
       }
       else{
        matriz[iIzquierdaAbajo][jIzquierda] = true;
       }
        }
    }


    return matriz;
}


public boolean[][] calcularMovimientosPosiblesRey (Pieza t){
   
    String colorOriginal = t.getColor();
    boolean[][] matriz = new boolean[numFilas][numColumnas];
    Casilla[][] casillas = getTablero();
    Rey p = (Rey)t;

    int i = t.getCasiila().posFila();
    int j = t.getCasiila().posColumna();


    //izquierda


    if(j-1 >= 0){
        if( casillas[i][j-1].estaOcupada() ){
  if(!casillas[i][j-1].getPieza().getColor().equals(colorOriginal)){
            matriz[i][j-1] = true;
            
        }
       }
       else{
        matriz[i][j-1] = true;
       }
    }

    //derecha
    if(j+1 < numColumnas){
        if( casillas[i][j+1].estaOcupada() ){
  if(!casillas[i][j+1].getPieza().getColor().equals(colorOriginal)){
            matriz[i][j+1] = true;
            
        }
       }
       else{
        matriz[i][j+1] = true;
       }
    }

        //ARRIBA
    if(i-1 >= 0){
        if( casillas[i-1][j].estaOcupada() ){
  if(!casillas[i-1][j].getPieza().getColor().equals(colorOriginal)){
            matriz[i-1][j] = true;
            
        }
       }
       else{
        matriz[i-1][j] = true;
       }
    }

    //abajo

     if(i+1 < numFilas){
  if( casillas[i+1][j].estaOcupada() ){
  if(!casillas[i+1][j].getPieza().getColor().equals(colorOriginal)){
            matriz[i+1][j] = true;
            
        }
       }
       else{
        matriz[i+1][j] = true;
       }

     }

     //arriba-izquirda
 if(j-1 >= 0 && i-1 >= 0){
 if( casillas[i-1][j-1].estaOcupada() ){
  if(!casillas[i-1][j-1].getPieza().getColor().equals(colorOriginal)){
            matriz[i-1][j-1] = true;
            
        }
       }
       else{
        matriz[i-1][j-1] = true;
       }


 }


      //arriba-derecha
 if(j+1 < numColumnas && i-1 >= 0){
 if( casillas[i-1][j+1].estaOcupada() ){
  if(!casillas[i-1][j+1].getPieza().getColor().equals(colorOriginal)){
            matriz[i-1][j+1] = true;
            
        }
       }
       else{
        matriz[i-1][j+1] = true;
       }


 }

       //abajo-izquierda
 if(j-1 >= 0 && i+1 < numFilas){
 if( casillas[i+1][j-1].estaOcupada() ){
  if(!casillas[i+1][j-1].getPieza().getColor().equals(colorOriginal)){
            matriz[i+1][j-1] = true;
            
        }
       }
       else{
        matriz[i+1][j-1] = true;
       }


 }


        //abajo-DERECHA
 if(j+1 <numColumnas && i+1 < numFilas){
 if( casillas[i+1][j+1].estaOcupada() ){
  if(!casillas[i+1][j+1].getPieza().getColor().equals(colorOriginal)){
            matriz[i+1][j+1] = true;
            
        }
       }
       else{
        matriz[i+1][j+1] = true;
       }


 }



return matriz;

}

public Casilla[][] getTablero (){

    return this.tablero;

}


}

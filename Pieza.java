public class Pieza {
    

    private Casilla c;
    private String color;
    private Boolean puedeMoverse;
    private int valor;
    private char simbolo;
    
    public Pieza (Casilla c, String color, int valor,  char simbolo){

        this.c = c;
        this.color = color;
        this.puedeMoverse  =false;
        this.valor = valor;
        this.simbolo = simbolo;
    }


    public int getValor(){

        return this.valor;
    }

    public String getColor (){ 

        return this.color;
    }

    public Casilla getCasiila (){
        return this.c;
    }

    public boolean getPuedeMoverse(){
        return this.puedeMoverse;
    }

    public char getSimbolo(){
return this.simbolo;
    }

    public void setCasilla(Casilla c) {
this.c = c;

    }

}



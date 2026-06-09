import javax.swing.SwingUtilities;




//TODO
//añadir los simbolo por un pnj

//movimientos posibles peon terminar
//movimientos posibles caballo
//enpassant
//enroque largo y corto
//evitar mover una pieza que estubiese salvando al rey   
//movimientos posibles del rey



public class main {

    public static void main(String[] args) {
        
        // Tu lógica inicial se mantiene exactamente igual
        Tablero t = new Tablero("tablero1");
        t.rellenarTableroInicial();

        // En lugar de los bucles 'for' con System.out.print, abrimos la ventana
        SwingUtilities.invokeLater(() -> {
            new VentanaTablero(t);
        });

        
    }
}
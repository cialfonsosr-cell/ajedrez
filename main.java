import javax.swing.SwingUtilities;


//añadir los simbolo por un pnj
//poder mover las piezas 
//movimientos posibles 
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
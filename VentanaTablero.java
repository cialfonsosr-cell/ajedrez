import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// CRUCIAL: Añadimos "implements ActionListener" para que la ventana escuche los clics
public class VentanaTablero extends JFrame implements ActionListener {

    private Casilla[][] matriz;
    private int filas;
    private int columnas;
    private Color colorClaro;
    private Color colorOscuro;
    private Tablero t ;
    private   boolean[][] movimientosPosibles ;
    private Pieza mover; 

   
    
    // Aquí guardaremos el botón que se pulsó en el PRIMER clic
    private JButton botonSeleccionado = null;

    public VentanaTablero(Tablero t) {
        this.t = t;
        matriz = t.getTablero();
        filas = matriz.length;
        columnas = matriz[0].length;
        

        matriz[3][3].setPieza(new Reina(matriz[3][3], "NEGRO" ));

        movimientosPosibles = new boolean[filas][columnas];

        // 1. Configuración básica de la ventana
        setTitle("Mi Juego de Tablero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600); 
        setLocationRelativeTo(null); 
        
        colorClaro = new Color(240, 217, 181);  
        colorOscuro = new Color(181, 136, 99);

        // 2. Organización en matriz
        setLayout(new GridLayout(filas, columnas));

        // 3. Creamos los botones por PRIMERA y ÚNICA vez
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JButton botonCasilla = new JButton();
                
                botonCasilla.setFont(new Font("Arial", Font.BOLD, 18));
                botonCasilla.setFocusPainted(false);

                // Texto inicial de la pieza
                if (matriz[i][j].getPieza() == null) {
                    botonCasilla.setText(" ");
                } else {
                    botonCasilla.setText(String.valueOf(matriz[i][j].getPieza().getSimbolo()));

                    if ("BLANCO".equals(matriz[i][j].getPieza().getColor())) {
                  botonCasilla.setForeground(new Color(255, 255, 255)); // Blanco puro
    
                } else {
                      botonCasilla.setForeground(new Color(40, 40, 40)); // Negro/Gris oscuro
                }
                }

                // Color de fondo de la casilla
                // Nota: Si color es un String, lo ideal en Java es usar .equals()
                if ("BLANCO".equals(matriz[i][j].getColor())) {
                    botonCasilla.setBackground(colorClaro);
                } else {
                    botonCasilla.setBackground(colorOscuro);
                }
                
                botonCasilla.setOpaque(true);
                botonCasilla.setBorderPainted(false);

                botonCasilla.putClientProperty("fila", i);
                botonCasilla.putClientProperty("columna", j);

                // ENLACE CLAVE: Le decimos al botón que avise a ESTA clase cuando lo pulsen
                botonCasilla.addActionListener(this);

                // Añadimos el botón visualmente a la ventana
                add(botonCasilla);
            }
        }

        // 4. Hacer la ventana visible (Ya no llamamos a ningún método jugar)
        setVisible(true);
    }

    // Este método se activa SOLO y AUTOMÁTICAMENTE cada vez que tocas cualquier casilla
    @Override
    public void actionPerformed(ActionEvent e) {
        // Averiguamos cuál de todos los botones recibió el clic
        JButton botonPulsado = (JButton) e.getSource();
        
        int f = (int) botonPulsado.getClientProperty("fila");
        int c = (int) botonPulsado.getClientProperty("columna");

        
      
        // ¿Es el primer clic? (No hay nada seleccionado todavía)
        if (botonSeleccionado == null) {
            
               mover = matriz[f][c].getPieza();
              // matriz[f][c].borrarPieza();
            // Validamos que no esté intentando seleccionar una casilla vacía
            if (botonPulsado.getText().equals(" ")) {
               // botonSeleccionado = botonPulsado;
                //botonPulsado.setBorder(BorderFactory.createLineBorder(Color.RED, 3)); // Marcamos 
               //  mostrarMatrizDeMovimientos();
                
            }
            else{
                if(botonPulsado.getText().equals("K")){
                  //  movimientosPosibles = calcularMovimientosPosiblesRey(matriz[f][c]);
                }
                if(botonPulsado.getText().equals("Q")){
                    movimientosPosibles = t.calcularMovimientosPosiblesReina(mover);
                     mostrarMatrizDeMovimientos();
                }
                if(botonPulsado.getText().equals("P")){
                   movimientosPosibles = t.calcularMovimientosPosiblesPeon(mover);
                   mostrarMatrizDeMovimientos();
                }
                if(botonPulsado.getText().equals("T")){
                   
                    movimientosPosibles = t.calcularMovimientosPosiblesTorre(mover);
                    mostrarMatrizDeMovimientos();
                }
                if(botonPulsado.getText().equals("A")){
                   movimientosPosibles = t.calcularMovimientosPosiblesAlfin (mover);
                    mostrarMatrizDeMovimientos();
                }
                if(botonPulsado.getText().equals("C")){
                  //  movimientosPosibles = calcularMovimientosPosiblesCaballo(matriz[f][c]);
                }

                botonSeleccionado = botonPulsado;
                botonPulsado.setBorder(BorderFactory.createLineBorder(Color.RED, 3)); // Marcamos 
            }
            
        } else {
           
            if(movimientosPosibles[f][c]){


            int filaOrigen = (int) botonSeleccionado.getClientProperty("fila");
            int columnaOrigen = (int) botonSeleccionado.getClientProperty("columna");
            
            // Borramos la pieza de su vieja posición
            matriz[filaOrigen][columnaOrigen].borrarPieza();

                mover.setCasilla(matriz[f][c]);
                matriz[f][c].setPieza(mover);
            // Es el segundo clic: Ejecutamos el movimiento visual
            String textoPieza = botonSeleccionado.getText();
            Color colorPieza = botonSeleccionado.getForeground();
            // Movemos el texto al nuevo botón
            botonPulsado.setText(textoPieza);  
            botonPulsado.setForeground(colorPieza);   
            
            // Dejamos el botón de origen vacío
            botonSeleccionado.setText(" ");       
            
            // Quitamos el borde rojo de selección al origen
            botonSeleccionado.setBorder(null); 
            
            // Reseteamos la variable para que el próximo clic vuelva a ser el "primer clic"
         
        }

           botonSeleccionado = null;     
            
            vaciarMatrizMovimientos();
    }
    }


    public void mostrarMatrizDeMovimientos(){

        for(int i = 0; i<movimientosPosibles.length; i++){
            for(int j = 0; j< movimientosPosibles[0].length; j++){
                if(movimientosPosibles[i][j] == false){
                    System.out.print("F ");
                }
                else { 
                    System.out.print("T ");
                }
            }
            System.out.println(" ");
        }


         System.out.println(" ");
            }


            public void vaciarMatrizMovimientos(){
                for(int i = 0; i<movimientosPosibles.length; i++){
            for(int j = 0; j< movimientosPosibles[0].length; j++){
                    movimientosPosibles[i][j] = false;
            }
        }

            }
}
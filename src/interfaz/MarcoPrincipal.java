
package interfaz;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.* ;
import javax.swing.border.LineBorder;

/**
 * Clase que reúne los elementos para diseñar la interfaz gráfica de una 
 * calculadora.
 * 
 * @author Adrián Arjona
 * @version Mayo 2023
 */
public class MarcoPrincipal extends JFrame{
    
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 9: comunicándonos con el usuario. Interfaces.
    */
    
    
    // ---------------- DECLARACIÓN DE VARIABLES ------------------
    
    
    // Display para mostrar los números
    
    JLabel marcoSecundario ;
    
    // Cantidad de botones de la calculadora
    
    int numBotones = 17 ;
    
    // Array de botones para números y operaciones
    
    JButton botones[] = new JButton[numBotones] ;
    
    // Array de strings para las etiquetas de los botones
    
    String textoBotones[]  = {"Resultado", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", ".", "+"} ;
    
    // Array de posiciones en X de cada botón
    
    int xBotones[] = {15, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210} ;
    
    // Array de posiciones en Y de cada botón
    
    int yBotones[] = {90, 155, 155, 155, 155, 220, 220, 220, 220, 285, 285, 285, 285, 350, 350, 350, 350} ;
    
    // Array de índices del array de botones que corresponden a número ( en el orden en el que pintarán)
    
    int numeroBotones[] = {14, 9 , 10, 11, 5, 6, 7, 1, 2, 3} ;
    
    // Array de índices del array de botones que corresponden a operaciones ( en el orden en el que se pintarán)
    
    int[] operacionesBotones = {16, 12, 8, 4} ;
    
    // Alto y ancho de cada botón
    
    int anchoBoton = 50 ;
    int altoBoton = 50 ;
    
    // Para indicar que he terminado de escribir dígitos un número y que voy a añadir el siguiente
    
    boolean nuevoNumero = true ;
    
    // Para indicar si ya he utilizado el punto decimal en ese número (sólo puede haber uno)
    
    boolean puntoDecimal = false ;
    
    // Para almacnar los resultados parciales y totales de las operaciones realizadas
    
    double operando1 = 0 ;
    double operando2 = 0 ;
    
    double resultado = 0 ;
    
    // Para almacenar el string de la operación realizada (+, -, *, /)
    
    String operacion = "" ;
    
    
    // ------------ MÉTODOS -------------------
    
        // ------- CONSTRUCTOR ------

        /**
         * Constructor de la clase MarcoPrincipal
         */
        public MarcoPrincipal(){

            initDisplay() ; // Display de la calculadora
            initBotones(); // Botones de la calculadora
            initPantalla() ; // Opciones del JFrame
            eventosNumeros() ; // Eventos asociados a los botones de núemros de la calculadora
            eventoDecimal() ;// Eventos asociados al botón decimal "." de la calculadora
            eventosOperaciones() ; // Eventos asociados a los botones de operaciones (+, -, *, /) de la calculadora
            eventoResultado() ; // Eventos asociados al botón resultado de la calculadora
            eventoLimpiar() ; // Eventos asociados al botón de limpiar "C" de la calculadora
        }
        
        
        /**
         * Método privado que sirve para iniciar el marco secundadio (JLabel).
         */
        private void initDisplay(){
            
            marcoSecundario = new JLabel("0") ; // Inicio JLabel
            marcoSecundario.setBounds(15, 15, 245, 60) ; // Posición y dimensiones
            marcoSecundario.setOpaque(true) ; // Para poder darle un color de fondo
            marcoSecundario.setBackground(Color.BLACK) ; // Color de fondo
            marcoSecundario.setForeground(Color.GREEN) ; // Color de fuente
            marcoSecundario.setBorder(new LineBorder(Color.DARK_GRAY)) ; // Borde
            marcoSecundario.setFont(new Font("MONOSPACED", PLAIN, 24)) ; // Fuente
            marcoSecundario.setHorizontalAlignment(SwingConstants.RIGHT) ; // Alineamiento horizontal derecha
            add(marcoSecundario) ; // Añado el JLabel al JFrame
        }
        
        
        /**
         * Método privado que inicializa los botones de la interfaz y los añade 
         * al JFrame.
         */
        private void initBotones(){
            
            for (int i = 0; i < numBotones; i++) {
                
                botones[i] = new JButton(textoBotones[i]) ; // Inicializo JButton
                int size = (i == 0) ? 24 : 26 ; // El botón de Resultado tendrá un tamaño de fuente menor que todos los demás
                int ancho = (i == 0) ? 245 : anchoBoton ;  // El botón de Resultado será más ancho que todos los demás
                
                botones[i].setBounds(xBotones[i], yBotones[i], ancho, altoBoton) ; // Posición y dimensiones
                botones[i].setFont(new Font("MONOSPACED", PLAIN, size)) ; // Fuente
                botones[i].setOpaque(true) ; // Para poder darle un color de fondo
                botones[i].setFocusPainted(false) ; // Para que no salga un recuadro azul cuando tenga el foco
                botones[i].setBackground(Color.DARK_GRAY) ; // Color de fondo
                botones[i].setForeground(Color.WHITE) ; // Color de fuente
                botones[i].setBorder(new LineBorder(Color.DARK_GRAY)) ; // Borde
                
                add(botones[i]) ; // Añado el JButton al JFrame
            }
        }
        
        
        /**
         * Método privado que da formato al JFrame
         */
        private void initPantalla(){
            
            setLayout(null) ; // Layout absoluto
            setTitle("Calculadora") ; // Título del JFrame
            setSize(290, 455) ; // Dimensiones del JFrame
            setResizable(false) ; // No redimensionable
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; // Cerrar proceso al cerrar ventana
            getContentPane().setBackground(Color.BLACK) ; // Color de fondo
            setVisible(true) ; // Mostrar JFrame
        }
        
        private void eventosNumeros(){
            
        }
        
         private void eventoDecimal(){
            
        }
         
        private void eventosOperaciones(){
            
        }
        
        private void eventoResultado(){
            
        }
        
        private void eventoLimpiar(){
            
        }
        
        public static void main(String[] args) {
        
            new MarcoPrincipal() ;
    }
}

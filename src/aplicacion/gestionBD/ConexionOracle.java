
package aplicacion.gestionBD;

import java.sql.Connection ;
import java.sql.DriverManager ;

/**
 * Clase que gestiona la conexión con la base de datos de Oracle.
 * 
 * @author Adrián Arjona
 * @version Mayo 2023
 */
public class ConexionOracle {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 10: Mantenimiento de la persistencia de los objetos.
    */
    
    // ------------------ DECLARACIÓN DE VARIABLES ---------------
    
    private Connection conn = null ;
    private String url, user, pass ;
    
    
    // ----------------- MÉTODOS --------------------------
    
    // CONSTRUCTOR

    
    /**
     * Constructor de la clase ConexionOracle. Inicia la conexión al crear el 
     * objeto.
     */
    public ConexionOracle() {
        conectar() ;
    }

    
    // GETTER
        
    /**
     * Método para obtener el estado de la conexión.
     * 
     * @return Estado de la conexión.
     */
    public Connection getConn() {
        return conn;
    }
    
    // MÉTODOS PROPIOS
    
    
    /**
     * Método que conecta con la base de datos de Oracle.
     */
    public void conectar(){
        
        try 
        {
            Class.forName("oracle.jdbc.OracleDriver") ; // Driver BD
            url = "jdbc:oracle:thin:@localhost:1521:XE" ;
            user = "HR" ;
            pass = "HR" ;
            conn = DriverManager.getConnection(url, user, pass) ;
            System.out.println("Conectado.");
        } 
        catch (Exception e) {
            System.out.println("Error, no se pudo conectar.") ;
        }
        
    }
    
    
    /**
     * Método que desconecta de la base de datos de Oracle.
     */
    public void desconectar(){
        try 
        {
            conn.close() ;
            System.out.println("Desconectado.") ;
        } 
        catch (Exception e) {
            System.out.println("Error, no se pudo desconectar.");
        }
    }
    
//    public static void main(String[] args) { // --------------------- MÉTODO MAIN DE PRUEBAS ------------------------
//        
//        ConexionOracle conn = new ConexionOracle();
//        conn.desconectar();
//    }
}


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
    
    private Connection conn = null ;
    private String url, user, pass ;

    public ConexionOracle() {
        conectar() ;
    }

    public Connection getConn() {
        return conn;
    }
    
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


package aplicacion.gestionficheros;

import aplicacion.modelo.CuerpoCeleste;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase dedicada a la gestión de los ficheros: creación, eliminación, etc.
 * 
 * @author Adrián Arjona
 * @version Mayo 2023
 */
public class GestionFicheros {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 10: Mantenimiento de la persistencia de los objetos.
    */
    
    public static File fichero = new File("sistemasolar.dat") ;
    public static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
     
    // -------------- MÉTODOS ---------------------

    
    /**
     * Método que nos abre el fichero de datos para cargar su contenido en el array "cuerposCelestes".
     * Previamente comprueba si el fichero exsite y, si es así, carga su contenido en el ArrayList.
     * Luego cierra el fichero. Si por cualquier motivo no se puede leer el disco (está creado 
     * pero no tiene datos) nos avisa que el fichero está vacío.
     * 
     * @return Devuelve el fichero.
     */
    public static File abrir(){
            
        try
        {
            if (!fichero.exists()) 
            {
                crearArchivo();
            }
            else
            {
                if (fichero.canRead())
                {
                    FileInputStream fis = new FileInputStream(fichero) ;
                    ObjectInputStream ois = new ObjectInputStream(fis) ;
                    cuerposCelestes = (ArrayList<CuerpoCeleste>)ois.readObject() ;
                    ois.close();
                    fis.close();                        
                }
                else
                {
                    System.out.println("\nFICHERO VACÍO.") ;
                }
            }
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("\nError: " + e.getMessage()) ;
        }
        
        return fichero ;
    }
    
    /**
     * Método que nos crea el fichero. Válido para cuando se comprueba que no existe.
     */
    public static void crearArchivo(){
        
        try
        {
            fichero.createNewFile() ;
            System.out.println("\nFichero creado.");
        }
        catch (Exception e){
            System.out.println("\nError: " + e.getMessage());
        }
        
    }
    
    
    /**
     * Método que nos escribe el ArrayList en el fichero de disco. Es la manera 
     * de guardar los datos serializados ya que la clase CuerpoCeleste lo está.
     * 
     *  @return Devuelve el fichero.
     */
    public static File escribirArchivo(){
        
        try
        {
            if (!fichero.exists())
                fichero = new File("sistemasolar.dat");
            FileOutputStream fos = new FileOutputStream(fichero) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(GestionFicheros.cuerposCelestes);
            oos.close();
            fos.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return fichero ;
    }
}

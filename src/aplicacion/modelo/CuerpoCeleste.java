
package aplicacion.modelo;

import aplicacion.excepciones.ExcepcionCuerpoCeleste;
import java.io.Serializable;

/**
 * Clase serializada que define los cuerpos celestes.
 * 
 * @author Adrián Arjona
 * @version 2.0 Mayo 2023
 */
public class CuerpoCeleste implements Serializable{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 10: Mantenimiento de la persistencia de los objetos.
    */
    
    // DECLARACIÓN DE VARIABLES
    
    private short codigoCuerpo ;
    private String nombre ;
    private String tipoObjeto ;
    private int diametro ;

    
    // CONSTRUCTORES
    
    /**
     * Constructor por defecto de la clase CuerpoCeleste.
     */
    public CuerpoCeleste() {
        codigoCuerpo = 0 ;
        nombre = "" ;
        tipoObjeto = "" ;
        diametro = 0 ;
    }
    
    
    /**
     * Constructor con parámetros de la clase CuerpoCeleste.
     * 
     * @param codigoCuerpo Código del cuerpo celeste.
     * @param nombre Nombre del cuerpo celeste.
     * @param tipoObjeto Tipo de objeto.
     * @param diametro Diámetro del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepción del cuerpo celeste.
     */
    public CuerpoCeleste(short codigoCuerpo, String nombre, String tipoObjeto, int diametro) throws ExcepcionCuerpoCeleste{
        
        this.setCodigoCuerpo(codigoCuerpo); // El código tiene que ser de tres dígitos como máximo.
        this.setNombre(nombre); // El nombre puede tener 15 caracteres como máximo
        this.tipoObjeto = tipoObjeto;
        this.setDiametro(diametro); // El diámetro no puede ser superior a 6 dígitos.
    }
    
    
    // GETTERS & SETTERS
    

    /**
     * Método que devuelve el diámetro del cuerpo celeste.
     * 
     * @return Diámetro del cuerpo celeste.
     */
    public int getDiametro() {
        return diametro;
    }

    
    /**
     * Método que modifica y controla el diámetro del cuerpo celeste no sea superior a 6 dígitos.
     * 
     * @param diametro Diámetro del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepción del cuerpo celeste.
     */
    public void setDiametro(int diametro) throws ExcepcionCuerpoCeleste{
        
        if ((diametro >= 0) && (diametro <= 999999) ) 
        {
            this.diametro = diametro;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste("El diámetro no puede tener más de 6 dígitos. No son necesarias decimales.") ;
        }
    }

    
    /**
     * Método que dvuelve el nombre del cuerpo celeste.
     * 
     * @return Nombre del cuerpo celeste.
     */
    public String getNombre() {
        return nombre;
    }

    
    /**
     * Método que modifica y controla que el nombre del cuerpo celeste tenga 15 caracteres como máximo.
     * 
     * @param nombre Nombre del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepción del cuerpo celeste.
     */
    public void setNombre(String nombre) throws ExcepcionCuerpoCeleste{
        
        if (nombre.length() <= 15) 
        {
            this.nombre = nombre;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste("El nombre puede tener un máximo de 15 caracteres.") ;
        }
    }

    
    /**
     * Método que devuelve el tipo de objeto.
     * 
     * @return Devuelve el tipo de objeto.
     */
    public String getTipoObjeto() {
        return tipoObjeto;
    }

    
    /**
     * Método que modifica el tipo de objeto.
     * 
     * @param tipoObjeto El tipo de objeto.
     */
    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    
    /**
     * Método que devuelve el código del cuerpo celeste.
     * 
     * @return Código del cuerpo celeste.
     */
    public short getCodigoCuerpo() {
        return codigoCuerpo;
    }

    
    /**
     * Método que modifica el código del cuerpo celeste y controla que sea de 3 dígitos.
     * 
     * @param codigoCuerpo Código del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepción del cuerpo celeste.
     */
    public void setCodigoCuerpo(short codigoCuerpo) throws ExcepcionCuerpoCeleste{ // CONTROLA QUE EL CÓDIGO SEA DE 3 DÍGITOS
        
        if (codigoCuerpo >= 0 && codigoCuerpo <= 999) 
        {
            this.codigoCuerpo = codigoCuerpo;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste ("El código tiene que ser de tres dígitos como máximo.");
        }
    }

    // MÉTODO TO STRING
    
    /**
     * Método toString de Cuerpo Celeste.
     * 
     * @return Devuelve los valores del cuerpo celeste.
     */
    @Override
    public String toString() {
        return "CÓDIGO = " + codigoCuerpo + "  \tNOMBRE = " + nombre + "    " + " \t\tTIPO = " + tipoObjeto + "  \tDIÁMETRO = " + diametro ;
    }
    
}

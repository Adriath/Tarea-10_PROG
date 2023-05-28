
package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Clase dedicada a métodos que ayuden al desarrollo de la tarea.
 * Ejemplo: un método para leer por pantalla una cadena de caracteres.
 * 
 * @author Adrián Arjona
 * @version tarea 10 // Mayo 2023
 */
public class Utilidades {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 10: Mantenimiento de la persistencia de los objetos.
    */
    
    // ------------------- ENTRADA DE DATOS -----------------------------
    
    // ------- CLASE SCANNER ------------
    
     /**
     * Método que pide al usuario una cadena de caracteres pudiendo personalizar 
     * el mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide la cadena al usuario.
     * @return String mensaje. Devuelve la cadena introducida por el usuario.
     */
    public static String leerString(String msg){
    
        Scanner entrada = new Scanner(System.in) ;
        
        System.out.println(msg);
        String mensaje = entrada.nextLine() ;
        
        return mensaje ;
    }
    
     /**
      * Método que pide al usuario una cadena de caracteres pudiendo personalizar 
      * el mensaje de petición y que limita el número de caracteres.
      * 
      * @param msg Mensaje con el que se pide la cadena al usuario.
      * @param limite Límite de caracteres.
      * @return Devuelve la cadena con longitud igual o inferior a la permitida.
      */
    public static String leerStringConLimiteCaracteres(String msg, int limite){
    
        String mensaje ;
        boolean validador = false ;
        
        Scanner entrada = new Scanner(System.in) ;
        
        do 
        {
            System.out.println(msg);
            mensaje = entrada.nextLine() ;
            
            if (( mensaje.length() <= limite ) && ( mensaje.length() > 0 )) 
                // Si la longitud de la cadena es mayor que 0 y menor que el límite estipulado...
            {
                validador = true ; // ...saldremos del bucle.
            }
            else if (mensaje.length() == 0)
                // Si la longitud es 0, es decir, si la cadena está vacía.
            {
                System.out.println("\nNo puede estar en blanco, se requiere algún valor.");
            }
            else
                // Si se excede el límite de caracteres.
            {
                if (limite == 1) 
                    // Mensaje para el caso en que sea singular.
                {
                    System.out.println("\nNo se permite más de " + limite + " caracter.");
                }
                else
                    // Mensaje para el caso en que sea en plural.
                {
                    System.out.println("\nNo se permiten más de " + limite + " caracteres.");
                }
            }
            
        } while (!validador);
        
        return mensaje ;
    }
    
       
     /**
     * Método que pide al usuario un número entero pudiendo personalizar el 
     * mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @return int entero. Devuelve el número introducido por el usuario.
     */
    public static int leerEntero(String msg){
        
        int entero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
            try 
            {
                entero = Integer.parseInt(mensaje) ;
                validador = true ;
            }
            catch (InputMismatchException e) {
                
                System.out.println("\nNo has introducido un número entero.");
            }
            catch (NumberFormatException e) {
                
                System.out.println("\nNo has introducido un número entero.");
            }
            catch (Exception e) {
                
                System.out.println("\nOcurrió algún error.");
            }
        } while (!validador);

     
        return entero ;
    }
    
       /**
     * Método que pide al usuario un número entero pudiendo personalizar el 
     * mensaje de petición y limitando el número de dígitos.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @param limite int. Indica el número de dígitos permitidos.
     * @return int entero. Devuelve el número introducido por el usuario.
     */
    public static int leerEnteroConLimiteDeDigitos(String msg, int limite){
        
        int entero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
           
            if (mensaje.length() <= limite) // Si la longitud de la cadena es menor o igual que el límite...
            {
                try // ...ejecuta el código.
                {
                    entero = Integer.parseInt(mensaje) ;
                    validador = true ;
                }
                catch (InputMismatchException e) {

                    System.out.println("\nNo has introducido un número entero.");
                }
                catch (NumberFormatException e) {

                    System.out.println("\nNo has introducido un número entero.");
                }
                catch (Exception e) {

                    System.out.println("\nOcurrió algún error.");
                }
            }
            else // Si es mayor al límite muestra un mensaje por pantalla.
            {
                System.out.println("\nEl número debe tener " + limite + " dígito/s como máximo.");
            }
            
        } while (!validador);

     
        return entero ;
    }
    
    
         /**
     * Método que pide al usuario un número entero pudiendo personalizar el 
     * mensaje de petición y limitando el número de dígitos de forma exacta.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @param numDigitos. Indica el número de dígitos exactos permitidos.
     * @return int entero. Devuelve el número introducido por el usuario.
     */
    public static int leerEnteroConDigitosExactos(String msg, int numDigitos){
        
        int entero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
           
            if (mensaje.length() == numDigitos) // Si la longitud de la cadena es igual que el límite...
            {
                try // ...ejecuta el código.
                {
                    entero = Integer.parseInt(mensaje) ;
                    validador = true ;
                }
                catch (InputMismatchException e) {

                    System.out.println("\nNo has introducido un número entero.");
                }
                catch (NumberFormatException e) {

                    System.out.println("\nNo has introducido un número entero.");
                }
                catch (Exception e) {

                    System.out.println("\nOcurrió algún error.");
                }
            }
            else // Si no es igual al número de dígitos deseado muestra un mensaje por pantalla.
            {
                System.out.println("\nEl número debe tener " + numDigitos + " dígito/s exacto/s.");
            }
            
        } while (!validador);

     
        return entero ;
    }
    
    
    /**
     * Método que sirve para leer un caracter pedido al usuario/a.
     * 
     * @param msg Mensaje que se da al usuario/a para pedir el dato.
     * @return Devuelve la letra introducida por consola.
     */
    public static char leerCaracter(String msg){
        
        char caracter = 0;
        String cadena ;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            cadena = entrada.nextLine() ;
            
            if (cadena.length() == 1) 
            {
                caracter = cadena.charAt(0) ;
                validador = true ;
            }
            else
            {
                System.out.println("\nTienes que introducir un único caracter.");
            }
            
        } while (!validador);

     
        return caracter ;
    }
    
    
     /**
     * Método que pide al usuario un número corto pudiendo personalizar el 
     * mensaje de petición.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @return byte. Devuelve el n�mero introducido por el usuario.
     */
    public static byte leerByte(String msg){
        
        byte numero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
            try 
            {
                numero = Byte.parseByte(mensaje) ;
                validador = true ;
            }
            catch (InputMismatchException e) {
                
                System.out.println("\nNo has introducido un número válido.");
            }
            catch (NumberFormatException e) {
                
                System.out.println("\nNo has introducido un número válido.");
            }
            catch (Exception e) {
                
                System.out.println("\nOcurrió algún error.");
            }
        } while (!validador);

     
        return numero ;
    }
    
    /**
     * Método que pide al usuario un número entero corto pudiendo personalizar el 
     * mensaje de petición y limitando el número de dígitos.
     * 
     * @param msg String. Mensaje con el que se pide el número al usuario.
     * @param limite int. Indica el número de dígitos permitidos.
     * @return byte numero. Devuelve el número introducido por el usuario.
     */
    public static byte leerByteConLimiteDeDigitos(String msg, int limite){
        
        byte numero = 0;
        boolean validador = false ;
        Scanner entrada = new Scanner(System.in) ;
        
        do {
            System.out.println(msg);
            String mensaje = entrada.nextLine() ;
           
            if (mensaje.length() <= limite) // Si la longitud de la cadena es menor o igual que el límite...
            {
                try // ...ejecuta el código.
                {
                    numero = Byte.parseByte(mensaje) ;
                    validador = true ;
                }
                catch (InputMismatchException e) {

                    System.out.println("\nNo has introducido un número entero corto.");
                }
                catch (NumberFormatException e) {

                    System.out.println("\nNo has introducido un número entero corto.");
                }
                catch (Exception e) {

                    System.out.println("\nOcurrió algún error.");
                }
            }
            else // Si es mayor al límite muestra un mensaje por pantalla.
            {
                System.out.println("\nEl número debe tener " + limite + " dígito/s como máximo.");
            }
            
        } while (!validador);

     
        return numero ;
    }
   
    
    // ------- CLASE BUFFEREDREADER --------
    
    /**
     * Método que crea un objeto de tipo BufferedReader para leer una cadena de 
     * caracteres.
     * 
     * @param msg. Tipo String. Es el mensaje con el que se pide los datos al usuario/a.
     * @return mensaje. String. Devuelve el mensaje introducido por el/la usuario/a.
     */
    public static String leerStringBuffer(String msg){
    
        String mensaje = "" ;
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
        try
        {
        mensaje = dato.readLine() ;    
        }
        catch(IOException e){
            System.out.println("\nError de entrada de datos.");
        }
        catch(Exception e){
            System.out.println("\nHa ocurrido algún error.");
        }
        
        return mensaje ;
    }
    
    
    
    /**
     * Método que crea un objeto de tipo BufferedReader para leer un número entero
     * introducido por el/la usuario/a.
     * 
     * @param msg. Tipo String. Mensaje con el que se pide el número al usuario/a.
     * @return numero. Int. Devuelve el número introducido por el/la usuario/a.
     */
    public static int leerEnteroBuffer(String msg){
    
        int numero = 0 ;
        boolean validador = false ;
        
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
            do 
            {
                try
                {
                numero = Integer.parseInt(dato.readLine()) ;
                validador = true ;
                }
                catch (NumberFormatException e){
                    System.out.println("\nTienes que introducir un número entero.");
                }
                catch(IOException e){
                    System.out.println("\nError de entrada de datos.");
                }
                catch(Exception e){
                    System.out.println("\nHa ocurrido algún error.");
                }
                
            } while (!validador);
        
        return numero ;
    }
    
    
    
    /**
     * Método que pide un caracter (comunmente una letra) usando internamente 
     * la clase BufferedReader.
     * 
     * @param msg Mensaje al usuario/a.
     * @return Devuelve el caracter tipo char.
     */
    public static char leerCaracterBuffer(String msg){
    
        char letra = 0 ;
        String cadena ;
        boolean validador = false ;
        
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
            do 
            {
               try
               {
                    cadena = dato.readLine() ;
                
                    if (cadena.length() == 1) 
                    {
                        letra = cadena.charAt(0) ;
                        validador = true ;
                    }
                    else
                    {
                        System.out.println("\nTienes que introducir una sola letra:");
                    }
               }
               catch (IOException e){
                   System.out.println("\nEror de entrada de datos.");
               }
               catch (Exception e){
                   System.out.println("\nHa ocurrido algún error.");
               }
                
            } while (!validador);
        
        return letra ;
    }
    
      
    /**
     * Método que crea un objeto de tipo BufferedReader para leer un número corto
     * introducido por el/la usuario/a.
     * 
     * @param msg. Tipo String. Mensaje con el que se pide el número al usuario/a.
     * @return numero. Short. Devuelve el número introducido por el/la usuario/a.
     */
    public static short leerShortBuffer(String msg){
    
        short numero = 0 ;
        boolean validador = false ;
        
        BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
        
        System.out.println(msg);
        
            do 
            {
                try
                {
                numero = Short.parseShort(dato.readLine()) ;
                validador = true ;
                }
                catch (NumberFormatException e){
                    System.out.println("\nTienes que introducir un número no demasiado largo.");
                }
                catch(IOException e){
                    System.out.println("\nError de entrada de datos.");
                }
                catch(Exception e){
                    System.out.println("\nHa ocurrido algún error.");
                }
                
            } while (!validador);
        
        return numero ;
    }    
    
     
    // ------- USANDO INTERFACES GRÁFICAS ---------
    
    
    /**
     * Método que abrevia la manera de mostrar un mensaje por pantalla mediante 
     * interfaz gráfica.
     * 
     * @param msg Mensaje que se muestra al usuario.
     */
    public static void mostrarMensajeGUI(String msg){
        
        JOptionPane.showMessageDialog(null, msg) ;
    }
    
    
    /**
     * Método que pide una cadena a través de un mensaje de diálogo 
     * (interfaz gráfica). Controla que la cadena no esté vacía ni comience por 
     * espacio.
     * 
     * @param msg. Tipo String. Mensaje con el que se pide la cadena al usuario/a.
     * @return numero. String. Devuelve la cadena introducida por el/la usuario/a.
     */
    public static String leerCadenaGUI(String msg){
    
        String entrada = "" ;
        String entradaValida = "" ;
        boolean validador = false ;
        
        do 
        {
            entrada = JOptionPane.showInputDialog(null, msg) ;
            
            if (entrada == null || entrada.startsWith(" ") || entrada.trim().isEmpty()) 
                // Si la cadena está vacía o empieza por espacio
            {
                JOptionPane.showMessageDialog(null, "La cadena no puede estar en blanco o comenzar por un espacio.") ;
            }
            else
            {
                entradaValida = entrada ;
                validador = true ;
            }
            
        } while (!validador);
        
        return entradaValida ;
    }  
    
    
     /**
     * Método que pide un númeroa través de un mensaje de diálogo 
     * (interfaz gráfica).
     * 
     * @param msg. Tipo String. Mensaje con el que se pide el número al usuario/a.
     * @return numero. Int. Devuelve el número introducido por el/la usuario/a.
     */
    public static int leerEnteroGUI(String msg){
    
        int numero = 0 ;
        String entrada = "" ;
        boolean validador = false ;
        
        do 
            {
                entrada = JOptionPane.showInputDialog(null, msg) ;
                
                try
                {
                    numero = Integer.parseInt(entrada) ;
                    validador = true ;
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tienes que introducir un número.") ;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido algún error.") ;
                }
                
            } while (!validador);
        
        return numero ;
    } 
    
    
    /**
     * Método que pide un número corto a través de un mensaje de diálogo 
     * (interfaz gráfica).
     * 
     * @param msg. Tipo String. Mensaje con el que se pide el número al usuario/a.
     * @return numero. Short. Devuelve el número introducido por el/la usuario/a.
     */
    public static short leerShortGUI(String msg){
    
        short numero = 0 ;
        String entrada = "" ;
        boolean validador = false ;
        
        do 
            {
                entrada = JOptionPane.showInputDialog(null, msg) ;
                
                try
                {
                    numero = Short.parseShort(entrada) ;
                    validador = true ;
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tienes que introducir un número no demasiado largo.") ;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido algún error.") ;
                }
                
            } while (!validador);
        
        return numero ;
    }  
    
    
// ---------------------- VALIDACIONES -------------------------
    
    /**
     * Método que valida la respuesta del usuario respecto a si continuar la 
     * ejecución.
     * 
     * @param msj String. Mensaje introducido por el usuario.
     * @return boolean valido. Devuelve si es válida la respuesta (true) o no (false).
     * @throws utilidades.ExcepcionDecisionUsuario
     */
    public static boolean compruebaDecisionUsuario(String msj)throws ExcepcionDecisionUsuario{
        String si = "s" ;
        String no = "n" ;
        boolean valido = false ;
        
        if (msj.equalsIgnoreCase(si) ^ msj.equalsIgnoreCase(no)) // Si el mensaje introducido es igual a "s" o "n" será válido...
        {
           valido = true ;
        }
        else // ...de lo contrario no y saltará la excepción.
        {
            throw new ExcepcionDecisionUsuario("\nTienes que decir sí \"s/S\" o no \"n/N\".") ;
        }
        
        return valido ;
    }
    
    
    
    /**
     * Método que extraerá la decisión del usuario, previamente validada con el método compruebaDecisionUsuario().
     * 
     * @param decision String. Mensaje al usuario/a.
     * @return tipo boolean. Devuelve false si la respuesta es positiva y true si la respuesta es negativa.
     */
    public static boolean distingueEntreSiYNo(String decision){
        
        boolean respuesta = false ;
        
        if (decision.equalsIgnoreCase("s")) // Si la decisión del usuario/a es "s/S"...
        {
            respuesta = false ; // ...respuesta será false.
        }
        else if (decision.equalsIgnoreCase("n")) // Si la decisión del usuario/a es "n/N"...
        {
            respuesta = true ; // ...la respuesta será true.
        }
        
        return respuesta ;
    }
    
    /**
     * Método que unifica los métodos compruebaDecisionUsuario() y distingueEntreSiYNo().Hará una pregunta al usuaria/a según se indique en el parámetro pregunta. 
     * Si la respuesta es válida la almacenará y evaluará.
     * 
     * @param pregunta Tipo String. Es la pregunta que se hace al uusario/a para que decida. Irá siempre seguida de "(s/n)".
     * @return boolean validador. Devuelve la decision del usuario/a según seá sí o no.
     */
    public static boolean secuenciaSalida(String pregunta){
        
        String decision ;
        boolean validador = false ;
        
        do // Ejecuta hasta que la decisión del usuario/a sea válida.
            {                
                decision = Utilidades.leerString("\n" + pregunta + "(s/n)\n") ; // Pregunta al usuario/a si quiere continuar.
            
                try 
                {
                    validador = Utilidades.compruebaDecisionUsuario(decision) ; // Comprueba si la decisión es válida...
                } 
                catch (ExcepcionDecisionUsuario e) {
                    
                    System.out.println(e.getMessage()); // ...y si no lo es capturará la excepción.
                }
                
            } while (!validador); // Sale del bucle si la respuesta es válida.
            
        validador = Utilidades.distingueEntreSiYNo(decision) ; // Dependiendo de la decisión que se haya tomado (sí o no) se seguirá o no la ejecución.
        
        return validador ;
    }
    
    
    // -------------------- OPERACIONES ----------------------
    
    /**
     * Método que calcula un número aleatorio comprendido entre 1 y el número 
     * pasado por parámetro.
     * 
     * @param num. Tipo int. Es el número máximo hasta el que hará el cálculo.
     * @return int numero. Devuelve un número aleatorio entre 1 y el número seleccionado.
     */
    public static int numeroAleatorio(int num){
        
                
        int numero = (int)(Math.random()* num + 1) ;
        
        return numero ;
    }
    
     /**
     * Método que calcula un número aleatorio comprendido entre 1 y el número 
     * pasado por parámetro. Pensado para posiciones de arrays.
     * 
     * @param num. Tipo int. Es el número máximo hasta el que hará el cálculo.
     * @return int numero. Devuelve un número aleatorio entre 1 y el número seleccionado.
     */
    public static int numeroAleatorioDesdeoCero(int num){
        
                
        int numero = (int)(Math.random()* num) ;
        
        return numero ;
    }
    
    
    // ------------------ OTROS -------------------------
    
    /**
     * Color negro.
     */
    public static String negro = "\033[30m" ;
    
    /**
     * Color rojo.
     */
    public static String rojo = "\033[31m" ;
    
    /**
     * Color verde.
     */
    public static String verde = "\033[32m" ;
    
    /**
     * Color amarillo.
     */
    public static String amarillo = "\033[33m" ;
    
    /**
     * Color azul.
     */
    public static String azul = "\033[34m" ;

    /**
     * Color magenta.
     */
    public static String magenta = "\033[35m" ;

    /**
     * Color cyan.
     */
    public static String cyan = "\033[36m" ;

    /**
     * Color blanco.
     */
    public static String blanco = "\033[37m" ;
    
    /**
     * Resetea el color.
     */
    public static String reset = "\u001B[0m" ;

    
    /**
     * Colorea la cadena de texto introducida del color deseado (tiene que estar 
     * registrado en la clase.
     * 
     * @param cadena Cadenad de caracteres que queresmos colorear.
     * @param color Color que queremos aplicar.
     * @return Devuelve la cadena coloreada.
     */
    public static String coloreaCadena(String cadena, String color){
        
        String cadenaColoreada = color + cadena.replaceAll("\n", reset + "\n" + color) + reset ;
        
        return cadenaColoreada ;
    }
    
}

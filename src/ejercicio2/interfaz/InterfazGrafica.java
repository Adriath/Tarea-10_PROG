
package ejercicio2.interfaz;

import ejercicio2.excepciones.ExcepcionCuerpoCeleste;
import ejercicio2.gestionficheros.GestionFicheros;
import ejercicio2.modelo.CuerpoCeleste;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Utilidades;

/**
 * Interfaz gráfica para la aplicación de gestión de los cuerpos celestes.
 * 
 * @author Adrián Arjona
 * @version mayo 2023
 */
public class InterfazGrafica extends javax.swing.JFrame {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 10: Mantenimiento de la persistencia de los objetos.
    */
    

    // ---------------- DECLARACIÓN DE VARIABLES --------------------
    
    /**
     * Mensaje que se muestra en la visor de mensajes de error.
     */
    private String mensajeError = "" ;
    
    /**
     * Fichero en el que se van almacenar los datos.
     */
    private static File fichero = new File("sistemasolar.dat") ;
    
    /**
     * Lista utilizada para gestionar los datos.
     */
    public static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
    
    
    // --------------- DECLARACIÓN DE MÉTODOS -----------------------
    
        // ------- CONSTRUCTOR -----------
    
    /**
     * Creates new form InterfazGrafica
     */
    public InterfazGrafica() {
        initComponents();
        setLocationRelativeTo(null) ;
        
    }
    
    
        // ------- MÉTODOS PERSONALIZADOS DEL ENTORNO GRÁFICO --------

       
    /**
     * Método que resetea (pone en blanco) el visor de mensajes de error.
     */
    private void limpiarMensajeError(){
        
        mensajeError = "" ;
        consolaMensajes.setText(mensajeError) ;
    }
    
    
    
     // ------------- MÉTODOS DE CUERPO CELESTE ---------------------
    
    /**
     * Método privado que añade cuerpos celestes.
     */
    public static void aniadirCuerpoCeleste(){
        
        short codigoCuerpo ;
        String nombre ;
        String tipoObjeto ;
        int diametro ;
        
        boolean validador ;
        
        
        GestionFicheros.fichero = GestionFicheros.abrir();
        
        
        // Pedimos el CÓDIGO
        
        do 
        {
            
            codigoCuerpo = Utilidades.leerShortGUI("Introduce el código (3 dígitos): ") ;
//            codigoCuerpo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste (3 dígitos max.):") ;
            validador = compruebaCodigo(codigoCuerpo) ;
            
            if (!validador) 
            {
                JOptionPane.showInputDialog(null, "Has introducido más de 3 dígitos. Inténtalo de nuevo.") ;
            }
            
        } while (!validador);
        
        validador = false ;
        
        
        
        // Pedimos el NOMBRE
        
        do 
        {
            nombre = Utilidades.leerCadenaGUI("Introduce en el nombre del cuerpo celeste (15 caracteres max.):") ;
//            nombre = Utilidades.leerStringBuffer("\nIntroduce en el nombre del cuerpo celeste (15 caracteres max.):") ;
            validador = compruebaNombre(nombre) ;
            
            if (!validador) 
            {
                JOptionPane.showInputDialog(null, "El nombre no puede tener más de 15 caracteres. Inténtalo de nuevo: ") ;
            }
            
        } while (!validador);
        
        validador = false ;
        
        
        
        // Pedimos el TIPO DE OBJETO
        
        tipoObjeto = Utilidades.leerCadenaGUI("Introduce el tipo de cuerpo celeste:") ;
//        tipoObjeto = Utilidades.leerStringBuffer("\nIntroduce el tipo de cuerpo celeste:") ;



        // Pedimos el DIÁMETRO

        do
        { 
            diametro = Utilidades.leerEnteroGUI("Introduce el diámetro (6 dígitos max.):") ;
            validador = compruebaDiametro(diametro) ;
            
            if (!validador) 
            {
                JOptionPane.showInputDialog(null, "El diámetro no puede tener más de 6 dítigos. Inténtalo de nuevo: ") ;
            }
            
        } while (!validador);
        
        /*
            Hemos terminado de pedir los datos y han sido comprobados. Si son 
            válidos continuamos almacenándolos.
        */
        
        if (GestionFicheros.cuerposCelestes.isEmpty()) // Si el array está vacío...
        {
            GestionFicheros.cuerposCelestes = new ArrayList<CuerpoCeleste>() ; // ... créalo.
        }
        
        try
        {
            GestionFicheros.cuerposCelestes.add(new CuerpoCeleste(codigoCuerpo, nombre, tipoObjeto, diametro)) ;
        }
        catch(ExcepcionCuerpoCeleste e){
            
            System.out.println(e.getMessage());
        }
        
        // Guarda los datos en el fichero
        
        GestionFicheros.fichero = GestionFicheros.escribirArchivo() ;
        
//        System.out.println("\nCuerpo Celeste " + cuerposCelestes.size()+ " añadido");
    }
    
    
    /**
     * Método que nos permite visualizar todos los datos almacenados.
     * Primero comprobamos que el fichero exista.
     * Si existe, lo abrimos y comprobamos que no esté vacío recorriendo todo su contenido.
     * También creará un modelo de tabla para usarlo en la interfaz gráfica.
     * 
     * @return Devuelve el modelo de la tabla.
     */
    public static DefaultTableModel listarCuerpoCeleste(){
        
        GestionFicheros.fichero = GestionFicheros.abrir();

        if (GestionFicheros.cuerposCelestes != null) 
        {
            int contador = 1 ;

            for (CuerpoCeleste objeto: GestionFicheros.cuerposCelestes) 
            {
                System.out.println("Registro nº " + contador + " - "  + objeto.toString());
                contador++ ;
            }
        }
        else
        {
            System.out.println("\nNo existen registros de cuerpos celestes.");
        }
        
        
        // CREACIÓN DEL MODELO PARA LA TABLA
        
          // Creación de los datos de la tabla en un array bidimensional
          
        Object[][] data = new Object[GestionFicheros.cuerposCelestes.size()][5] ;
        
        for (int i = 0; i < GestionFicheros.cuerposCelestes.size(); i++) {
            
            CuerpoCeleste cuerpoCeleste = GestionFicheros.cuerposCelestes.get(i);
            data[i][0] = i + 1 ;
            data[i][1] = cuerpoCeleste.getCodigoCuerpo() ;
            data[i][2] = cuerpoCeleste.getNombre() ;
            data[i][3] = cuerpoCeleste.getTipoObjeto() ;
            data[i][4] = cuerpoCeleste.getDiametro() ;
        }

        // Crear los nombres de las columnas
        String[] columnaNombres = { "Registro", "Código", "Nombre", "Tipo", "Diámetro" } ;

        // Crear el modelo de la tabla con los datos y los nombres de las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel(data, columnaNombres) ;
        
        
        return modeloTabla ;
    }
    
    
    /**
     * Método que nos permite buscar un registro concreto buscándolo por su código.
     * También crea un modelo de tabla para mostrar los datos en la interfaz 
     * gráfica.
     * 
     * @return Devuelve el modelo de la tabla.
     */
    public static DefaultTableModel buscarCuerpoCelestePorCodigo(){
        
        int contador ;
        boolean encontrado = false ;
        
        VentanaSecundaria nuevaVentana ;
        DefaultTableModel modeloTabla = null ;
        
        Object[][] data = new Object[cuerposCelestes.size()][5] ;
        data = new Object[GestionFicheros.cuerposCelestes.size()][5];
        String[] columnaNombres = { "Registro", "Código", "Nombre", "Tipo", "Diámetro" };
        
      
        short codigo = Utilidades.leerShortGUI("Introduce el código del cuerpo celeste que deseas buscar:") ;
        
//            short codigo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste que deseas buscar: ") ;

        GestionFicheros.abrir() ;

        contador = 1 ;

        for (CuerpoCeleste cuerpoCeleste: GestionFicheros.cuerposCelestes) 
        {
            encontrado = true ;
            
//                    System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());

             // Crear los datos de la tabla en un arreglo bidimensional
             
            
            if (cuerpoCeleste.getCodigoCuerpo() == codigo) {
                // Si ha coincidencia creará la fila a añadir

                data[0][0] = contador ;
                data[0][1] = cuerpoCeleste.getCodigoCuerpo() ;
                data[0][2] = cuerpoCeleste.getNombre();
                data[0][3] = cuerpoCeleste.getTipoObjeto();
                data[0][4] = cuerpoCeleste.getDiametro();
                
            }

            contador++ ;
        }

        if (!encontrado) 
            // Si no hay conicidencia lanza un mensaje
        {
            Utilidades.mostrarMensajeGUI("REGISTRO NO ENCONTRADO.") ;
        }
        
        modeloTabla = new DefaultTableModel(data, columnaNombres) ;
       
        return modeloTabla ;
    }
    
    
    
    /**
     * Método que nos permite buscar un registro concreto buscándolo por su tipo.
     * También crea un modelo de la tabla para mostrar los datos por la interfaz 
     * gráfiza.
     * 
     * @return Devuelve el modelo de la tabla.
     */
    public static DefaultTableModel buscarCuerpoCelestePorTipo(){
        
        int contador ;
        boolean encontrado = false ;
        
        VentanaSecundaria nuevaVentana ;
        DefaultTableModel modeloTabla = null ;
        
        Object[][] data = new Object[cuerposCelestes.size()][5] ;
        data = new Object[GestionFicheros.cuerposCelestes.size()][5];
        String[] columnaNombres = { "Registro", "Código", "Nombre", "Tipo", "Diámetro" };
        
      
        String tipo = Utilidades.leerCadenaGUI("Introduce el código del cuerpo celeste que deseas buscar:") ;
        
//            short codigo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste que deseas buscar: ") ;

        GestionFicheros.abrir() ;

        contador = 1 ;

        for (CuerpoCeleste cuerpoCeleste: GestionFicheros.cuerposCelestes) 
        {
            encontrado = true ;
            
//                    System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());

             // Crear los datos de la tabla en un arreglo bidimensional
             
            
            if (cuerpoCeleste.getTipoObjeto().equalsIgnoreCase(tipo)) {

                data[0][0] = contador ;
                data[0][1] = cuerpoCeleste.getCodigoCuerpo() ;
                data[0][2] = cuerpoCeleste.getNombre();
                data[0][3] = cuerpoCeleste.getTipoObjeto();
                data[0][4] = cuerpoCeleste.getDiametro();
                
            }

            contador++ ;
        }

        if (!encontrado) 
        {
            Utilidades.mostrarMensajeGUI("REGISTRO NO ENCONTRADO.") ;
        }
        
        modeloTabla = new DefaultTableModel(data, columnaNombres) ;
       
        return modeloTabla ;
    }
    
    
    /**
     * Método similar al anterior pero que en lugar de limitarse a mostrarnos el 
     * resultado de la búsqueda, nos permite decidir si deseamos elminar el 
     * registro encontrado.
     * 
     * @return Devuelve true si el registro fue encontrado y false si no.
     */
    public static boolean eliminarCuerpoCeleste(){
        
        /*
        Uno de los errores es que elmina una entrada. Poniendo 1 como código, por ejemplo, 
        ha dado un error pero ha borrado la entrada 1 del fichero. Eso no debería ocurrir porque 
        el código no coincide con 1.
        */
        
        int contador ;
        int respuesta ;
        
        String mensaje ;
        
        boolean encontrado ;
        boolean validador = false ;
        boolean borrado = false ;
        
        try
        {
            
            // Pide el código del registro que se quiere eliminar
            
            short codigo = Utilidades.leerShortGUI("Introduce el código del cuerpo celeste que deseas eliminar: ") ;

            GestionFicheros.abrir() ;

            contador = 1 ;

            encontrado = false ;

            for(CuerpoCeleste cuerpoCeleste: GestionFicheros.cuerposCelestes)
            {

                mensaje = "¿Desea eliminar el registro " + contador + "?\n " + GestionFicheros.cuerposCelestes.get(contador - 1).toString() ;

                if (cuerpoCeleste.getCodigoCuerpo() == codigo)
                    // Si hay coincidencia con el código
                {
                    encontrado = true ;
//                        System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());

                    // Secuencia de confirmación. Pide confirmación para borrar el registro
                    
                    respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION) ;

                    if (respuesta == JOptionPane.YES_OPTION)
                        // Si la respuesta es sí lo eliminará
                    {
                        mensaje = "REGISTRO Nº " + contador + " ELIMINADO" ;

                        GestionFicheros.cuerposCelestes.remove((contador - 1)) ;
                        GestionFicheros.escribirArchivo() ;
                        Utilidades.mostrarMensajeGUI(mensaje) ; // Cuadro de diálogo que confirma la elminación
                        
                        borrado = true ;
                    }
                }

            contador++ ;
            }

            if (!encontrado)
                // Si no hay coincidencia
            {   
                VentanaSecundaria.consolaMensajes.setText("REGISTRO NO ENCONTRADO.") ;
            }
          
        }
        catch(ConcurrentModificationException e){
            System.err.println("");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return borrado ;
    }
    
    
    /**
     * Método que nos elimina el fichero de datos del disco.
     */
    public static void eliminarFichero(){
        
        int respuesta ;
        boolean borrado ;
        
        if (GestionFicheros.fichero.exists())
            // Si el fichero existe
        {
            try
            {
                // Mensaje de confirmación para borrar el fichero
                
                respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el fichero completo?", "Confirmación", JOptionPane.YES_NO_OPTION) ;

                if (respuesta == JOptionPane.YES_OPTION)
                    //Si la respuesta es sí...
                {
                    borrado = GestionFicheros.fichero.delete() ; // ... borra el fichero.

                    if (borrado) 
                        // Si ha sido borrado avisa con un mensaje.
                    {
                        Utilidades.mostrarMensajeGUI("FICHERO DE DATOS ELMINADO.") ;
                        GestionFicheros.cuerposCelestes.clear();
                    }
                }
                else
                    // Si la respuesta es no o no se contesta...
                {
                    Utilidades.mostrarMensajeGUI("NO SE HA REALIZADO NINGUNA ACCIÓN."); // ... avisa diciendo que no se hizo nada.
                }
            }
            catch (Exception e){
                System.err.println("\nAlgún error ocurrió: " + e.getMessage());
            }
        }
        
    }
    
    
    // ------------------ COMPROBADORES / VALIDADORES ----------------------
    
     /**
     * Método que comprueba si el código del cuerpo celeste tiene 3 dígitos.
     * 
     * @param codigo Código del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaCodigo(short codigo){
        
        boolean valido = false ;
        
        if (codigo >= 0 && codigo <= 999) // Si el código es positivo y tiene 3 dígitos como máximo será válido
            valido = true ;        
        
        return valido ;
    }
    
    
    /**
     * Método que comprueba si el nombre del cuerpo celeste tiene como máximo 15 caracteres.
     * 
     * @param nombre Nombre del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaNombre(String nombre){
        
        boolean valido = false ;
        
        if (nombre.length() <= 15)
            valido = true ;
        
        return valido ;
    }
    
    
    /**
     * Método que comprueba si el diámetro tiene 6 dígitos como máximo.
     * 
     * @param diametro Diámetro del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaDiametro(int diametro){
        
        boolean valido = false ;
        
        if (diametro >= 0 && diametro <= 999999) // Si el diámetro es positivo y tiene 6 dígitos como máximo será válido
            valido = true ;
        
        return valido ;
    }
    
    
    // --------------- CÓDIGO GENERADO POR NETBEANS ---------------------------
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marcoPrincipal = new javax.swing.JPanel();
        etiquetaMenu = new javax.swing.JLabel();
        Separador = new javax.swing.JSeparator();
        botonAniadirRegistro = new javax.swing.JButton();
        botonListarRegistro = new javax.swing.JButton();
        botonBuscarPorCodigo = new javax.swing.JButton();
        botonEliminarRegistro = new javax.swing.JButton();
        botonEliminarFichero = new javax.swing.JButton();
        consolaMensajes = new javax.swing.JLabel();
        botonBuscarPorTipo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        etiquetaMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        etiquetaMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMenu.setText("MENÚ");

        botonAniadirRegistro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonAniadirRegistro.setText("Añadir registro");
        botonAniadirRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirRegistroActionPerformed(evt);
            }
        });

        botonListarRegistro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonListarRegistro.setText("Listar registros");
        botonListarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarRegistroActionPerformed(evt);
            }
        });

        botonBuscarPorCodigo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonBuscarPorCodigo.setText("Buscar registro por código");
        botonBuscarPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPorCodigoActionPerformed(evt);
            }
        });

        botonEliminarRegistro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonEliminarRegistro.setText("Eliminar registro");
        botonEliminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarRegistroActionPerformed(evt);
            }
        });

        botonEliminarFichero.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonEliminarFichero.setText("Eliminar fichero completo");
        botonEliminarFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarFicheroActionPerformed(evt);
            }
        });

        consolaMensajes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        consolaMensajes.setForeground(new java.awt.Color(204, 0, 0));

        botonBuscarPorTipo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonBuscarPorTipo.setText("Buscar registro por tipo");
        botonBuscarPorTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPorTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout marcoPrincipalLayout = new javax.swing.GroupLayout(marcoPrincipal);
        marcoPrincipal.setLayout(marcoPrincipalLayout);
        marcoPrincipalLayout.setHorizontalGroup(
            marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPrincipalLayout.createSequentialGroup()
                        .addComponent(etiquetaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(376, 376, 376))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPrincipalLayout.createSequentialGroup()
                        .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPrincipalLayout.createSequentialGroup()
                        .addGroup(marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAniadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonListarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminarFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscarPorTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(308, 308, 308))))
            .addGroup(marcoPrincipalLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(consolaMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
        );
        marcoPrincipalLayout.setVerticalGroup(
            marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(etiquetaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAniadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonListarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonBuscarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonBuscarPorTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonEliminarFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consolaMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(marcoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(marcoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAniadirRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirRegistroActionPerformed
        limpiarMensajeError() ;
        aniadirCuerpoCeleste() ;
        
        Utilidades.mostrarMensajeGUI("Cuerpo Celeste " + GestionFicheros.cuerposCelestes.size()+ " añadido") ;
        
    }//GEN-LAST:event_botonAniadirRegistroActionPerformed

    private void botonListarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarRegistroActionPerformed
        limpiarMensajeError() ;
        
        if (!GestionFicheros.fichero.exists()) 
        {
            consolaMensajes.setText("No se puede listar, el fichero no existe.");
        }
        else
        {
            GestionFicheros.abrir() ;
            marcoPrincipal.setVisible(false); ;
            setVisible(false);
            
            VentanaSecundaria nuevaVentana = new VentanaSecundaria(GestionFicheros.cuerposCelestes, listarCuerpoCeleste()) ;
            nuevaVentana.setVisible(true) ;
        }
    }//GEN-LAST:event_botonListarRegistroActionPerformed

    private void botonBuscarPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPorCodigoActionPerformed
        limpiarMensajeError();
        
        DefaultTableModel modeloTabla = new DefaultTableModel() ;
        
        if (!GestionFicheros.fichero.exists()) 
        {
            consolaMensajes.setText("No se puede buscar, el fichero no existe.");
        }
        else
        {
            marcoPrincipal.setVisible(false) ;
            setVisible(false) ;
            
            modeloTabla = buscarCuerpoCelestePorCodigo() ;
            
            VentanaSecundaria nuevaVentana = new VentanaSecundaria(GestionFicheros.cuerposCelestes, modeloTabla) ;
            nuevaVentana.setVisible(true) ;
        }
    }//GEN-LAST:event_botonBuscarPorCodigoActionPerformed

    private void botonEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarRegistroActionPerformed
        
        int respuesta ;
        boolean validador = false ;
        boolean borrado = false ;
        
        limpiarMensajeError() ;
        
        
        if (!GestionFicheros.fichero.exists()) 
        {
            consolaMensajes.setText("No se puede eliminar, el fichero no existe.") ;
        }
        else
        {
            
            marcoPrincipal.setVisible(false); ;
            setVisible(false);
            
            VentanaSecundaria nuevaVentana = new VentanaSecundaria(GestionFicheros.cuerposCelestes, listarCuerpoCeleste()) ;
            nuevaVentana.setVisible(true) ;
            
            do{
            
                borrado = eliminarCuerpoCeleste() ;
                
                if (borrado) 
                {
                    nuevaVentana.dispose() ;
                    botonListarRegistroActionPerformed(evt) ;
                }
                 
                respuesta = JOptionPane.showConfirmDialog(null, "Quieres eliminar otro registro?", "Confirmación", JOptionPane.YES_NO_OPTION) ;
                nuevaVentana.limpiarConsolaMensajes() ;
                
                if (respuesta == JOptionPane.NO_OPTION) 
                {
                    validador = true ;
                }
            
            } while (!validador) ;
        
           
        }
    }//GEN-LAST:event_botonEliminarRegistroActionPerformed

    private void botonEliminarFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarFicheroActionPerformed
        limpiarMensajeError() ;
        
        if (!(GestionFicheros.fichero.exists())) 
        {
            consolaMensajes.setText("EL FICHERO NO EXISTE.") ;
        }
        
        eliminarFichero() ;
    }//GEN-LAST:event_botonEliminarFicheroActionPerformed

    private void botonBuscarPorTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPorTipoActionPerformed
         limpiarMensajeError();
        
        DefaultTableModel modeloTabla = new DefaultTableModel() ;
        
        if (!GestionFicheros.fichero.exists()) 
        {
            consolaMensajes.setText("No se puede buscar, el fichero no existe.");
        }
        else
        {
            marcoPrincipal.setVisible(false) ;
            setVisible(false) ;
            
            modeloTabla = buscarCuerpoCelestePorTipo() ;
            
            VentanaSecundaria nuevaVentana = new VentanaSecundaria(GestionFicheros.cuerposCelestes, modeloTabla) ;
            nuevaVentana.setVisible(true) ;
        }
        
    }//GEN-LAST:event_botonBuscarPorTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separador;
    private javax.swing.JButton botonAniadirRegistro;
    private javax.swing.JButton botonBuscarPorCodigo;
    private javax.swing.JButton botonBuscarPorTipo;
    private javax.swing.JButton botonEliminarFichero;
    private javax.swing.JButton botonEliminarRegistro;
    private javax.swing.JButton botonListarRegistro;
    private javax.swing.JLabel consolaMensajes;
    private javax.swing.JLabel etiquetaMenu;
    private javax.swing.JPanel marcoPrincipal;
    // End of variables declaration//GEN-END:variables
}

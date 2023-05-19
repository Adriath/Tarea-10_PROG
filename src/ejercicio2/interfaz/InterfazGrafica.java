
package ejercicio2.interfaz;

import javax.swing.JOptionPane;

/**
 * Interfaz gráfica para la apliación de gestión de los cuerpos celestes.
 * 
 * @author Adrián Arjona
 * @version mayo 2023
 */
public class InterfazGrafica extends javax.swing.JFrame {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 9: comunicándonos con el usuario. Interfaces.
    */
    

    // ---------------- DECLARACIÓN DE VARIABLES --------------------
    
    /**
     * Mensaje que se muestra en la visor de mensajes de error.
     */
    private String mensajeError = "" ;
    
    
    // --------------- DECLARACIÓN DE MÉTODOS -----------------------
    
        // ------- CONSTRUCTOR -----------
    
    /**
     * Creates new form InterfazGrafica
     */
    public InterfazGrafica() {
        initComponents();
    }
    
    
        // ------- MÉTODOS PERSONALIZADOS --------

    /**
     * Método que resetea (pone en blanco) el visor de mensajes de error.
     */
    private void limpiarMensajeError(){
        
        mensajeError = "" ;
        consolaMensajes.setText(mensajeError) ;
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
        jSeparator1 = new javax.swing.JSeparator();
        botonAniadirRegistro = new javax.swing.JButton();
        botonListarRegistro = new javax.swing.JButton();
        botonBuscarPorCodigo = new javax.swing.JButton();
        botonEliminarRegistro = new javax.swing.JButton();
        botonEliminarFichero = new javax.swing.JButton();
        consolaMensajes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPrincipalLayout.createSequentialGroup()
                        .addGroup(marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAniadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonListarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminarFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAniadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonListarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonBuscarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(botonEliminarFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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
        limpiarMensajeError();
    }//GEN-LAST:event_botonAniadirRegistroActionPerformed

    private void botonListarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarRegistroActionPerformed
        limpiarMensajeError();
    }//GEN-LAST:event_botonListarRegistroActionPerformed

    private void botonBuscarPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPorCodigoActionPerformed
        limpiarMensajeError();
    }//GEN-LAST:event_botonBuscarPorCodigoActionPerformed

    private void botonEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarRegistroActionPerformed
        limpiarMensajeError();
    }//GEN-LAST:event_botonEliminarRegistroActionPerformed

    private void botonEliminarFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarFicheroActionPerformed
        limpiarMensajeError();
    }//GEN-LAST:event_botonEliminarFicheroActionPerformed

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
    private javax.swing.JButton botonAniadirRegistro;
    private javax.swing.JButton botonBuscarPorCodigo;
    private javax.swing.JButton botonEliminarFichero;
    private javax.swing.JButton botonEliminarRegistro;
    private javax.swing.JButton botonListarRegistro;
    private javax.swing.JLabel consolaMensajes;
    private javax.swing.JLabel etiquetaMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel marcoPrincipal;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sequence;

import Logic.Users.User;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class IniciarSesion extends javax.swing.JFrame {

    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UsuarioField = new javax.swing.JTextField();
        ContraField = new javax.swing.JPasswordField();
        BotonIniciarSesion = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioField.setBackground(new java.awt.Color(60, 132, 194));
        UsuarioField.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        UsuarioField.setForeground(new java.awt.Color(255, 255, 255));
        UsuarioField.setBorder(null);
        jPanel1.add(UsuarioField, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 260, 260, 40));

        ContraField.setBackground(new java.awt.Color(60, 132, 194));
        ContraField.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        ContraField.setForeground(new java.awt.Color(255, 255, 255));
        ContraField.setBorder(null);
        jPanel1.add(ContraField, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 391, 260, 40));

        BotonIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonIniciarSesionMouseClicked(evt);
            }
        });
        jPanel1.add(BotonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 210, 50));

        BotonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(BotonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 530, 50, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/IniciarSesion.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonIniciarSesionMouseClicked
        String usuario = UsuarioField.getText();
        String contra = ContraField.getText();
        
        if (usuario.isBlank() || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Username.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (contra.isBlank() || contra.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Contraseña.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean mostrar = Main_Sequence.gestorUsuarios.iniciarSesion(usuario, contra);
        
        if (mostrar) {
            JOptionPane.showMessageDialog(null, "¡Bienvenido(a) a Sequence, " + usuario + "!", "Inicio de Sesión Exitoso", JOptionPane.INFORMATION_MESSAGE, Main_Sequence.gestorUsuarios.getUsuarioLog().getPlayerIcon());
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BotonIniciarSesionMouseClicked

    private void BotonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegresarMouseClicked
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonIniciarSesion;
    private javax.swing.JLabel BotonRegresar;
    private javax.swing.JPasswordField ContraField;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField UsuarioField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

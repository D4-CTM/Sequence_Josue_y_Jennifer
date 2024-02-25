/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sequence;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class RegistroUsuarios extends javax.swing.JFrame {
    private Icon icono1= new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/Icono1.png");
    private Icon icono2= new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/Icono2.png");
    private Icon icono3= new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/Icono3.png");
    private Icon icono4= new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/Icono4.png");
    private Icon iconoSeleccionado;
    
    public RegistroUsuarios() {
        initComponents();
        
        Icono1.setIcon(icono1);
        Icono2.setIcon(icono2);
        Icono3.setIcon(icono3);
        Icono4.setIcon(icono4);
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
        UsernameField = new javax.swing.JTextField();
        NombreCompletoField = new javax.swing.JTextField();
        ConfirmarField = new javax.swing.JPasswordField();
        ContraField = new javax.swing.JPasswordField();
        Icono4 = new javax.swing.JButton();
        Icono3 = new javax.swing.JButton();
        Icono2 = new javax.swing.JButton();
        Icono1 = new javax.swing.JButton();
        BotonRegresar = new javax.swing.JLabel();
        BotonRegistrar = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsernameField.setBackground(new java.awt.Color(60, 132, 194));
        UsernameField.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(255, 255, 255));
        UsernameField.setBorder(null);
        jPanel1.add(UsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 333, 260, 40));

        NombreCompletoField.setBackground(new java.awt.Color(60, 132, 194));
        NombreCompletoField.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        NombreCompletoField.setForeground(new java.awt.Color(255, 255, 255));
        NombreCompletoField.setBorder(null);
        jPanel1.add(NombreCompletoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 333, 260, 40));

        ConfirmarField.setBackground(new java.awt.Color(60, 132, 194));
        ConfirmarField.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        ConfirmarField.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmarField.setBorder(null);
        jPanel1.add(ConfirmarField, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 447, 260, 40));

        ContraField.setBackground(new java.awt.Color(60, 132, 194));
        ContraField.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        ContraField.setForeground(new java.awt.Color(255, 255, 255));
        ContraField.setBorder(null);
        jPanel1.add(ContraField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 447, 260, 40));

        Icono4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Icono4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Icono4ActionPerformed(evt);
            }
        });
        jPanel1.add(Icono4, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 199, 100, 70));

        Icono3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Icono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Icono3ActionPerformed(evt);
            }
        });
        jPanel1.add(Icono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 199, 100, 70));

        Icono2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Icono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Icono2ActionPerformed(evt);
            }
        });
        jPanel1.add(Icono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 199, 100, 70));

        Icono1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Icono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Icono1ActionPerformed(evt);
            }
        });
        jPanel1.add(Icono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 199, 100, 70));

        BotonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(BotonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 530, 50, 50));

        BotonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegistrarMouseClicked(evt);
            }
        });
        jPanel1.add(BotonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 210, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/RegistroUsuarios.png"))); // NOI18N
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

    private void BotonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegresarMouseClicked
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonRegresarMouseClicked

    private void BotonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseClicked
        String nombreCompleto = NombreCompletoField.getText();
        String username = UsernameField.getText();
        String password = ContraField.getText();
        String passwordConfirmar = ConfirmarField.getText();
        
         if (iconoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un ícono.", "Ícono no seleccionado", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nombreCompleto.isBlank() || nombreCompleto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Nombre Completo.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (username.isBlank() || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Username.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (password.isBlank() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Contraseña.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (passwordConfirmar.isBlank() || passwordConfirmar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Confirmar Contraseña.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!passwordConfirmar.equals(password)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no son idénticas. Por favor, verifique e intente nuevamente.", "Validación de Contraseña Fallida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean regresar = Main_Sequence.gestorUsuarios.agregarUsuario(password, username, password, (ImageIcon) iconoSeleccionado);
        
        if (regresar) {
            PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
            pantallaPrincipal.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BotonRegistrarMouseClicked

    private void Icono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Icono1ActionPerformed
        Icono1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        iconoSeleccionado = icono1;
        
        Icono2.setBorder(BorderFactory.createEmptyBorder());
        Icono3.setBorder(BorderFactory.createEmptyBorder());
        Icono4.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_Icono1ActionPerformed

    private void Icono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Icono2ActionPerformed
        Icono2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        iconoSeleccionado = icono2;
        
        Icono1.setBorder(BorderFactory.createEmptyBorder());
        Icono3.setBorder(BorderFactory.createEmptyBorder());
        Icono4.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_Icono2ActionPerformed

    private void Icono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Icono3ActionPerformed
        Icono3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        iconoSeleccionado = icono3;
        
        Icono2.setBorder(BorderFactory.createEmptyBorder());
        Icono1.setBorder(BorderFactory.createEmptyBorder());
        Icono4.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_Icono3ActionPerformed

    private void Icono4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Icono4ActionPerformed
        Icono4.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        iconoSeleccionado = icono4;
        
        Icono2.setBorder(BorderFactory.createEmptyBorder());
        Icono3.setBorder(BorderFactory.createEmptyBorder());
        Icono1.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_Icono4ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonRegistrar;
    private javax.swing.JLabel BotonRegresar;
    private javax.swing.JPasswordField ConfirmarField;
    private javax.swing.JPasswordField ContraField;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Icono1;
    private javax.swing.JButton Icono2;
    private javax.swing.JButton Icono3;
    private javax.swing.JButton Icono4;
    private javax.swing.JTextField NombreCompletoField;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

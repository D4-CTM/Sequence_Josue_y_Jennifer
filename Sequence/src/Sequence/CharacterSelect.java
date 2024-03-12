/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sequence;

import GameBoard.Tablero;
import Logic.Users.Settings;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class CharacterSelect extends javax.swing.JFrame {

    /**
     * Creates new form CharacterSelect
     */
    public CharacterSelect() throws IOException, ClassNotFoundException {
        initComponents();
        
        setLocationRelativeTo(null);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Elementos/GameIcon.png")).getImage());
        
        setConfigurationBox();
    }

    private void setConfigurationBox() throws IOException, ClassNotFoundException{
        File Configuraciones = new File("Configurations");
        ArrayList<String> Ajustes = new ArrayList();
        for (String Configuration : Configuraciones.list()){
            String[] Name = Configuration.split("[.]");
            Ajustes.add(Name[0]);
        }
        if (!Ajustes.isEmpty()){
            SettingsBox.setModel(new javax.swing.DefaultComboBoxModel(Ajustes.toArray()));
        }
        
        SettingsDataBox.setText(DisplaySettings());
    }
    
    private String DisplaySettings() throws IOException, ClassNotFoundException{
        String Added, Data = "";
        Settings Ajustes = Settings.LoadFile(SettingsBox.getSelectedItem().toString());

        Added = Ajustes.getBloquearEspacio();
        if (!Added.equals("GG")){
            Data += Added + ": Bloques espacio\n";
        }

        Added = Ajustes.getCambiarCarta();
        if (!Added.equals("GG")){
            Data += Added + ": Cambiar Carta\n";

        }
        
        Added = Ajustes.getCambiarFichas();
        if (!Added.equals("GG")){
            Data += Added + ": Cambiar Fichas\n";
        }
        
        Added = Ajustes.getElegirCarta();
        if (!Added.equals("GG")){
            Data += Added + ": Elegir cartas\n";
        }
        
        Added = Ajustes.getEliminarCarta();
        if (!Added.equals("GG")){
            Data += Added + ": Eliminar cartas\n";
        }
        
        Added = Ajustes.getEliminarFichas();
        if (!Added.equals("GG")){
            Data += Added + ": Eliminar fichas\n";
        }
        
        Added = Ajustes.getLiberarEspacio();
        if (!Added.equals("GG")){
            Data += Added + ": Liberar espacio\n";
        }
        
        Added = Ajustes.getOcuparEspacio();
        if (!Added.equals("GG")){
            Data += Added + ": Ocupar espacio\n";
        }
        return Data;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Regresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        IniciarPartidaBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SettingsDataBox = new javax.swing.JTextArea();
        SettingsBox = new javax.swing.JComboBox();
        ConfigTXT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sequence");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regresar.setFocusable(false);
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 50, 50));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IniciarPartidaBTN.setText("Iniciar partida");
        IniciarPartidaBTN.setFocusable(false);
        IniciarPartidaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarPartidaBTNActionPerformed(evt);
            }
        });
        jPanel2.add(IniciarPartidaBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, 50));

        SettingsDataBox.setEditable(false);
        SettingsDataBox.setColumns(20);
        SettingsDataBox.setLineWrap(true);
        SettingsDataBox.setRows(5);
        SettingsDataBox.setWrapStyleWord(true);
        SettingsDataBox.setFocusable(false);
        jScrollPane1.setViewportView(SettingsDataBox);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 60, 140, 260));

        SettingsBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(SettingsBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, -1));

        ConfigTXT.setText("Configuracion deseada:");
        jPanel2.add(ConfigTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 170, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarPartidaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarPartidaBTNActionPerformed
        try {
            Main_Sequence.ActualSetting = Settings.LoadFile(SettingsBox.getSelectedItem().toString());
            new Tablero(2).setVisible(true);
            dispose();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }//GEN-LAST:event_IniciarPartidaBTNActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarActionPerformed

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
            java.util.logging.Logger.getLogger(CharacterSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharacterSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharacterSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharacterSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CharacterSelect().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(CharacterSelect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CharacterSelect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfigTXT;
    private javax.swing.JButton IniciarPartidaBTN;
    private javax.swing.JButton Regresar;
    private javax.swing.JComboBox SettingsBox;
    private javax.swing.JTextArea SettingsDataBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

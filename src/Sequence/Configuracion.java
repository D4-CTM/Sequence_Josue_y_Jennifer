/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sequence;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class Configuracion extends javax.swing.JFrame {
    private ImageIcon fichaRoja = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaRoja.png");
    private ImageIcon fichaAzul = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaAzul.png");
    private ImageIcon fichaVerde = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaVerde.png");
    private ImageIcon fichaAmarilla = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaAmarilla.png");
    private ImageIcon fichaRosa = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaRosa.png");
    private ImageIcon fichaGris = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaGris.png");
    private ImageIcon fichaMorada = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaMorada.png");
    private ImageIcon fichaNaranja = new ImageIcon("/Users/jenniferbueso/NetBeansProjects/Sequence/src/Elementos/fichaNaranja.png");
    private ImageIcon fichaSeleccionada;
    private int cantidadJugadores;
    
    public Configuracion() {
        initComponents();
        
        if (Main_Sequence.gestorUsuarios.getConfiguracionUsuario().getCantidadJugadores() != 0) {
            int cantidad = Main_Sequence.gestorUsuarios.getConfiguracionUsuario().getCantidadJugadores();
            System.out.println("Cantidad de jugadores: " + cantidad);
            switch (cantidad) {
                case 2:
                    JugadoresBox.setSelectedIndex(1);
                    break;
                case 3:
                    JugadoresBox.setSelectedIndex(2);
                    break;
                case 4:
                    JugadoresBox.setSelectedIndex(3);
                    break;
                case 6:
                    JugadoresBox.setSelectedIndex(4);
                    break;
                case 8:
                    JugadoresBox.setSelectedIndex(5);
                    break;
            }
        }
        
        ImageIcon fichaColor = Main_Sequence.gestorUsuarios.getConfiguracionUsuario().getColorFicha();
        if (fichaColor != null) {
            String rutaFichaColor = fichaColor.getDescription();

            if (rutaFichaColor.equals(fichaRoja.getDescription())) {
                BotonFichaRoja.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaAzul.getDescription())) {
                BotonFichaAzul.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaVerde.getDescription())) {
                BotonFichaVerde.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaAmarilla.getDescription())) {
                BotonFichaAmarilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaRosa.getDescription())) {
                BotonFichaRoja.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaGris.getDescription())) {
                BotonFichaAzul.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaMorada.getDescription())) {
                BotonFichaVerde.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } else if (rutaFichaColor.equals(fichaNaranja.getDescription())) {
                BotonFichaAmarilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
            } 
        }
        
        
        FotoPerfil.setIcon(Main_Sequence.gestorUsuarios.getUsuarioLog().getPlayerIcon());
        NombreLabel.setText(Main_Sequence.gestorUsuarios.getUsuarioLog().getUsername());
        
        BotonFichaRoja.setIcon(fichaRoja);
        BotonFichaAzul.setIcon(fichaAzul);
        BotonFichaVerde.setIcon(fichaVerde);
        BotonFichaAmarilla.setIcon(fichaAmarilla);
        BotonFichaRosa.setIcon(fichaRosa);
        BotonFichaGris.setIcon(fichaGris);
        BotonFichaMorada.setIcon(fichaMorada);
        BotonFichaNaranja.setIcon(fichaNaranja);
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
        FotoPerfil = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JLabel();
        BotonAplicarCambios = new javax.swing.JLabel();
        JugadoresBox = new javax.swing.JComboBox<>();
        BotonFichaNaranja = new javax.swing.JButton();
        BotonFichaMorada = new javax.swing.JButton();
        BotonFichaGris = new javax.swing.JButton();
        BotonFichaRosa = new javax.swing.JButton();
        BotonFichaAmarilla = new javax.swing.JButton();
        BotonFichaAzul = new javax.swing.JButton();
        BotonFichaVerde = new javax.swing.JButton();
        BotonFichaRoja = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoPartidaArea = new javax.swing.JTextArea();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(FotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 131, 100, 70));

        NombreLabel.setFont(new java.awt.Font("Avenir Next Condensed", 1, 24)); // NOI18N
        NombreLabel.setForeground(new java.awt.Color(0, 0, 0));
        NombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(NombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 300, 30));

        BotonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(BotonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 50, 50));

        BotonAplicarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonAplicarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAplicarCambiosMouseClicked(evt);
            }
        });
        jPanel1.add(BotonAplicarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 190, 50));

        JugadoresBox.setBackground(new java.awt.Color(255, 255, 255));
        JugadoresBox.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        JugadoresBox.setForeground(new java.awt.Color(0, 0, 0));
        JugadoresBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "2", "3", "4", "6", "8" }));
        JugadoresBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugadoresBoxActionPerformed(evt);
            }
        });
        jPanel1.add(JugadoresBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 287, 120, 40));

        BotonFichaNaranja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaNaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaNaranjaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 414, 112, 100));

        BotonFichaMorada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaMorada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaMoradaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 414, 112, 100));

        BotonFichaGris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaGrisActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 414, 112, 100));

        BotonFichaRosa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaRosaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 414, 112, 100));

        BotonFichaAmarilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaAmarilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaAmarillaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaAmarilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 296, 112, 100));

        BotonFichaAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaAzulActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 296, 112, 100));

        BotonFichaVerde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaVerdeActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 296, 112, 100));

        BotonFichaRoja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaRoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaRojaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaRoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 296, 112, 100));

        jScrollPane1.setBorder(null);

        InfoPartidaArea.setEditable(false);
        InfoPartidaArea.setBackground(new java.awt.Color(60, 132, 194));
        InfoPartidaArea.setColumns(20);
        InfoPartidaArea.setFont(new java.awt.Font("Avenir Next Condensed", 1, 20)); // NOI18N
        InfoPartidaArea.setForeground(new java.awt.Color(255, 255, 255));
        InfoPartidaArea.setLineWrap(true);
        InfoPartidaArea.setRows(5);
        jScrollPane1.setViewportView(InfoPartidaArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 411, 240, 100));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Configuracion.png"))); // NOI18N
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
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonRegresarMouseClicked

    private void BotonAplicarCambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAplicarCambiosMouseClicked
        if (cantidadJugadores == 0) {
            JOptionPane.showMessageDialog(null, "Completa el campo de Cantidad de Jugadores.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (fichaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un Color de Ficha", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Main_Sequence.gestorUsuarios.getConfiguracionUsuario().setCantidadJugadores(cantidadJugadores);
        Main_Sequence.gestorUsuarios.getConfiguracionUsuario().setColorFicha((ImageIcon) fichaSeleccionada);
        
        Main_Sequence.gestorUsuarios.getConfiguracionUsuario().saveToFile();
        JOptionPane.showMessageDialog(null, "Se han aplicado los cambios en la configuración de su partida correctamente.", "ConfiguraciÃ³n Aplicada", JOptionPane.INFORMATION_MESSAGE);

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonAplicarCambiosMouseClicked

    private void BotonFichaRojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaRojaActionPerformed
        BotonFichaRoja.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaRoja;
        
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaRojaActionPerformed

    private void BotonFichaVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaVerdeActionPerformed
        BotonFichaVerde.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaVerde;
        
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaVerdeActionPerformed

    private void JugadoresBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugadoresBoxActionPerformed
        String cantidad = JugadoresBox.getSelectedItem().toString();
        
        if (cantidad.equals(" ")) {
            InfoPartidaArea.setText("");
            cantidadJugadores = 0;
        } else if (cantidad.equals("2")) {
            InfoPartidaArea.setText("Equipos: 2 \nSe repartirán 7 fichas por jugador.");
            cantidadJugadores = 2;
        } else if (cantidad.equals("3")) {
            InfoPartidaArea.setText("Equipos: 3 \nSe repartirán 6 fichas por jugador.");
            cantidadJugadores = 3;
        } else if (cantidad.equals("4")) {
            InfoPartidaArea.setText("Equipos: 2 \nSe repartirán 7 fichas por jugador.");
            cantidadJugadores = 4;
        } else if (cantidad.equals("6")) {
            InfoPartidaArea.setText("Equipos: 3 \nSe repartirán 5 fichas por jugador.");
            cantidadJugadores = 6;
        } else if (cantidad.equals("8")) {
            InfoPartidaArea.setText("Equipos: 2 \nSe repartirán 6 fichas por jugador.");
            cantidadJugadores = 8;
        }
    }//GEN-LAST:event_JugadoresBoxActionPerformed

    private void BotonFichaAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaAzulActionPerformed
        BotonFichaAzul.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaAzul;
        
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaAzulActionPerformed

    private void BotonFichaAmarillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaAmarillaActionPerformed
        BotonFichaAmarilla.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaAmarilla;
        
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaAmarillaActionPerformed

    private void BotonFichaRosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaRosaActionPerformed
        BotonFichaRosa.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaRosa;
        
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaRosaActionPerformed

    private void BotonFichaGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaGrisActionPerformed
        BotonFichaGris.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaGris;
        
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaGrisActionPerformed

    private void BotonFichaMoradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaMoradaActionPerformed
        BotonFichaMorada.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaMorada;
        
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaNaranja.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaMoradaActionPerformed

    private void BotonFichaNaranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaNaranjaActionPerformed
        BotonFichaNaranja.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = fichaNaranja;
        
        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaNaranjaActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonAplicarCambios;
    private javax.swing.JButton BotonFichaAmarilla;
    private javax.swing.JButton BotonFichaAzul;
    private javax.swing.JButton BotonFichaGris;
    private javax.swing.JButton BotonFichaMorada;
    private javax.swing.JButton BotonFichaNaranja;
    private javax.swing.JButton BotonFichaRoja;
    private javax.swing.JButton BotonFichaRosa;
    private javax.swing.JButton BotonFichaVerde;
    private javax.swing.JLabel BotonRegresar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel FotoPerfil;
    private javax.swing.JTextArea InfoPartidaArea;
    private javax.swing.JComboBox<String> JugadoresBox;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
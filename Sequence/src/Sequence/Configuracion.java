/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sequence;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class Configuracion extends javax.swing.JFrame {

    private final File fichaRoja = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens1.png");
    private final File fichaAzul = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens2.png");
    private final File fichaVerde = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens3.png");
    private final File fichaAmarilla = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens4.png");
    private final File fichaRosa = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens5.png");
    private final File fichaGris = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens6.png");
    private final File fichaMorada = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens7.png");
    private final File fichaNaranja = new File(Main_Sequence.ActualSetting.getCardsUrl() + "Tokens8.png");
    private String fichaSeleccionada;
    private int cantidadJugadores;
    private int CantidadCartas;

    public Configuracion() {
        initComponents();

        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Elementos/GameIcon.png")).getImage());

        FotoPerfil.setIcon(Main_Sequence.gestorUsuarios.getUserLog().getPlayerIcon());
        NombreLabel.setText(Main_Sequence.gestorUsuarios.getUserLog().getUsername());

        BotonFichaRoja.setIcon(new ImageIcon(ScaledImage(fichaRoja.getAbsolutePath(), BotonFichaRoja.getWidth(), BotonFichaRoja.getHeight()).getImage()));
        BotonFichaAzul.setIcon(new ImageIcon(ScaledImage(fichaAzul.getAbsolutePath(), BotonFichaAzul.getWidth(), BotonFichaAzul.getHeight()).getImage()));
        BotonFichaVerde.setIcon(new ImageIcon(ScaledImage(fichaVerde.getAbsolutePath(), BotonFichaVerde.getWidth(), BotonFichaVerde.getHeight()).getImage()));
        BotonFichaAmarilla.setIcon(new ImageIcon(ScaledImage(fichaAmarilla.getAbsolutePath(), BotonFichaAmarilla.getWidth(), BotonFichaAmarilla.getHeight()).getImage()));
        BotonFichaRosa.setIcon(new ImageIcon(ScaledImage(fichaRosa.getAbsolutePath(), BotonFichaRosa.getWidth(), BotonFichaRosa.getHeight()).getImage()));
        BotonFichaGris.setIcon(new ImageIcon(ScaledImage(fichaGris.getAbsolutePath(), BotonFichaGris.getWidth(), BotonFichaGris.getHeight()).getImage()));
        BotonFichaMorada.setIcon(new ImageIcon(ScaledImage(fichaMorada.getAbsolutePath(), BotonFichaMorada.getWidth(), BotonFichaMorada.getHeight()).getImage()));
        BotonFichaNaranja.setIcon(new ImageIcon(ScaledImage(fichaNaranja.getAbsolutePath(), BotonFichaNaranja.getWidth(), BotonFichaNaranja.getHeight()).getImage()));
        
        switch (Main_Sequence.gestorUsuarios.getUserLog().getFicha()){
            case "Tokens1.png" -> BotonFichaRoja.doClick();
            case "Tokens2.png" -> BotonFichaAzul.doClick();
            case "Tokens3.png" -> BotonFichaVerde.doClick();
            case "Tokens4.png" -> BotonFichaAmarilla.doClick();
            case "Tokens5.png" -> BotonFichaRosa.doClick();
            case "Tokens6.png" -> BotonFichaGris.doClick();
            case "Tokens7.png" -> BotonFichaMorada.doClick();
            default -> BotonFichaNaranja.doClick();
        }
        
        JugadoresBox.setSelectedItem(String.valueOf(Main_Sequence.ActualSetting.getPlayersCant()));
    }

    private ImageIcon ScaledImage(String Url, int Width, int Height) {
        ImageIcon neoIcon = new ImageIcon(Url);
        Image scaledCard = neoIcon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        neoIcon = new ImageIcon(scaledCard);
        return neoIcon;
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
        setTitle("Sequence");
        setResizable(false);

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

        BotonFichaNaranja.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaNaranja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaNaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaNaranjaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 414, 112, 100));

        BotonFichaMorada.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaMorada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaMorada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaMoradaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 414, 112, 100));

        BotonFichaGris.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaGris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaGrisActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaGris, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 414, 112, 100));

        BotonFichaRosa.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaRosa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaRosaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 414, 112, 100));

        BotonFichaAmarilla.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaAmarilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaAmarilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaAmarillaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaAmarilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 296, 112, 100));

        BotonFichaAzul.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaAzulActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 296, 112, 100));

        BotonFichaVerde.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaVerde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaVerdeActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 296, 112, 100));

        BotonFichaRoja.setBackground(new java.awt.Color(255, 255, 255));
        BotonFichaRoja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFichaRoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFichaRojaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonFichaRoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 296, 112, 100));

        jScrollPane1.setBorder(null);

        InfoPartidaArea.setBackground(new java.awt.Color(60, 132, 194));
        InfoPartidaArea.setColumns(20);
        InfoPartidaArea.setFont(new java.awt.Font("Avenir Next Condensed", 1, 20)); // NOI18N
        InfoPartidaArea.setForeground(new java.awt.Color(255, 255, 255));
        InfoPartidaArea.setLineWrap(true);
        InfoPartidaArea.setRows(5);
        InfoPartidaArea.setWrapStyleWord(true);
        InfoPartidaArea.setAutoscrolls(false);
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
        try {
            if (cantidadJugadores == 0) {
                JOptionPane.showMessageDialog(null, "Completa el campo de Cantidad de Jugadores.", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (fichaSeleccionada == null) {
                JOptionPane.showMessageDialog(null, "Selecciona un Color de Ficha", "Campo Incompleto", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Main_Sequence.gestorUsuarios.getUserLog().setficha(fichaSeleccionada);
            Main_Sequence.gestorUsuarios.getUserLog().SaveData(Main_Sequence.gestorUsuarios.getUserLog().getUsername());
            
            Main_Sequence.ActualSetting.setCardsCants(CantidadCartas);
            Main_Sequence.ActualSetting.setPlayerCant(cantidadJugadores);
            Main_Sequence.ActualSetting.SaveData(Main_Sequence.ActualSetting.getName());
            
            JOptionPane.showMessageDialog(null, "Se han aplicado los cambios en la configuración de su partida correctamente.", "ConfiguraciÃ³n Aplicada", JOptionPane.INFORMATION_MESSAGE);

            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonAplicarCambiosMouseClicked

    private void BotonFichaRojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaRojaActionPerformed
        BotonFichaRoja.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = "Tokens1.png";

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
        fichaSeleccionada = "Tokens3.png";

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

        switch (cantidad) {
            case "2" -> {
                InfoPartidaArea.setText("Equipos: 2 \nSe repartirán 7 cartas por jugador.");
                cantidadJugadores = 2;
                CantidadCartas = 7;
            }
            case "3" -> {
                InfoPartidaArea.setText("Equipos: 3 \nSe repartirán 6 cartas por jugador.");
                cantidadJugadores = 3;
                CantidadCartas = 6;
            }
            case "4" -> {
                InfoPartidaArea.setText("Equipos: 2 \nSe repartirán 7 cartas por jugador.");
                cantidadJugadores = 4;
                CantidadCartas = 7;
            }
            case "6" -> {
                InfoPartidaArea.setText("Equipos: 3 \nSe repartirán 5 cartas por jugador.");
                cantidadJugadores = 6;
                CantidadCartas = 5;
            }
            case "8" -> {
                InfoPartidaArea.setText("Equipos: 2 \nSe repartirán 4 cartas por jugador.");
                cantidadJugadores = 8;
                CantidadCartas = 4;
            }
            default -> {
                InfoPartidaArea.setText("");
                cantidadJugadores = 0;
            }
        }
    }//GEN-LAST:event_JugadoresBoxActionPerformed

    private void BotonFichaAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFichaAzulActionPerformed
        BotonFichaAzul.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        fichaSeleccionada = "Tokens2.png";

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
        fichaSeleccionada = "Tokens4.png";

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
        fichaSeleccionada = "Tokens5.png";

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
        fichaSeleccionada = "Tokens6.png";

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
        fichaSeleccionada = "Tokens7.png";

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
        fichaSeleccionada = "Tokens8.png";

        BotonFichaVerde.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRoja.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAzul.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaAmarilla.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaRosa.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaGris.setBorder(BorderFactory.createEmptyBorder());
        BotonFichaMorada.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_BotonFichaNaranjaActionPerformed

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

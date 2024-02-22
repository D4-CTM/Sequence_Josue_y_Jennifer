/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GameBoard;

import Logic.UI_Elements.JCard;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Tablero extends javax.swing.JFrame implements Runnable {

    private int Min, Sec, MiliSec;
    private Thread TimerTXT;

    public Tablero() {
        initComponents();
        setBoardBTNS();

        StartThread();
    }

    private void StartThread() {
        TimerTXT = new Thread(this);

        TimerTXT.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Tablero = new javax.swing.JPanel();
        Team_1_Panel = new javax.swing.JPanel();
        Player2Team1 = new javax.swing.JLabel();
        Team1Name = new javax.swing.JLabel();
        Player1Team1 = new javax.swing.JLabel();
        LastCardTXT = new javax.swing.JLabel();
        LastCardIcon = new javax.swing.JLabel();
        BarajaDeCartasTXT = new javax.swing.JLabel();
        CardDeckIcon = new javax.swing.JLabel();
        Team_3_Panel = new javax.swing.JPanel();
        Player2Team3 = new javax.swing.JLabel();
        Team3Name1 = new javax.swing.JLabel();
        Player1Team3 = new javax.swing.JLabel();
        Team_4_Panel = new javax.swing.JPanel();
        Player2Team4 = new javax.swing.JLabel();
        Team4Name = new javax.swing.JLabel();
        Player1Team4 = new javax.swing.JLabel();
        Team_2_Panel = new javax.swing.JPanel();
        Player2Team2 = new javax.swing.JLabel();
        Team2Name = new javax.swing.JLabel();
        Player1Team2 = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(0, 0, 0));
        Fondo.setPreferredSize(new java.awt.Dimension(1100, 600));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablero.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        Fondo.add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 700, 500));

        Team_1_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2Team1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2Team1.setText("[Player 2 Icon]");
        Team_1_Panel.add(Player2Team1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 75, 75));

        Team1Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team1Name.setText("Team 1");
        Team_1_Panel.add(Team1Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, -1));

        Player1Team1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1Team1.setText("[Player 1 Icon]");
        Team_1_Panel.add(Player1Team1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 75, 75));

        Fondo.add(Team_1_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 200));

        LastCardTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardTXT.setText("Ultima carta jugada");
        Fondo.add(LastCardTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, -1));

        LastCardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardIcon.setText("[CONO DE LA ULTIMA CARTA]");
        Fondo.add(LastCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 140));

        BarajaDeCartasTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BarajaDeCartasTXT.setText("Baraja de cartas");
        Fondo.add(BarajaDeCartasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 200, -1));

        CardDeckIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CardDeckIcon.setText("[ICONO DEL DECK]");
        Fondo.add(CardDeckIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 200, 140));

        Team_3_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2Team3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2Team3.setText("[Player 2 Icon]");
        Team_3_Panel.add(Player2Team3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 75, 75));

        Team3Name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team3Name1.setText("Team 3");
        Team_3_Panel.add(Team3Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, -1));

        Player1Team3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1Team3.setText("[Player 1 Icon]");
        Team_3_Panel.add(Player1Team3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 75, 75));

        Fondo.add(Team_3_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, 200));

        Team_4_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2Team4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2Team4.setText("[Player 2 Icon]");
        Team_4_Panel.add(Player2Team4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 75, 75));

        Team4Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team4Name.setText("Team 4");
        Team_4_Panel.add(Team4Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, -1));

        Player1Team4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1Team4.setText("[Player 1 Icon]");
        Team_4_Panel.add(Player1Team4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 75, 75));

        Fondo.add(Team_4_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, 200, 200));

        Team_2_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2Team2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2Team2.setText("[Player 2 Icon]");
        Team_2_Panel.add(Player2Team2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 75, 75));

        Team2Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team2Name.setText("Team 2");
        Team_2_Panel.add(Team2Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, -1));

        Player1Team2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1Team2.setText("[Player 1 Icon]");
        Team_2_Panel.add(Player1Team2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 75, 75));

        Fondo.add(Team_2_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 200, 200));

        Timer.setForeground(new java.awt.Color(255, 255, 255));
        Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Timer.setText("Timer");
        Timer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Fondo.add(Timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 10, 350, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Los botones que se observan en en el tablero, si, es un tanto intuitivo solo con el nombre.
    private void setBoardBTNS() {
        CartasDelTablero = new JCard[10][10];
        for (int Fila = 0; Fila < 10; Fila++) {
            for (int Columna = 0; Columna < 10; Columna++) {
                CartasDelTablero[Fila][Columna] = new JCard(Fila, Columna);

                CartasDelTablero[Fila][Columna].addActionListener((ActionEvent Ex) -> {

                });
                CartasDelTablero[Fila][Columna].setBounds(70 * Fila, 50 * Columna, 70, 50);
                Tablero.add(CartasDelTablero[Fila][Columna]);
            }
        }
    }

    public static void main(String args[]) {
        new Tablero().setVisible(true);
    }

    @Override
    public void run() {
        Min = 1;
        Sec = 59;
        MiliSec = 59;
        float LastFrame = 0;
        do {
            if ((System.nanoTime() - LastFrame) >= 1000000000 / 60) {
                LastFrame = System.nanoTime();
                UpdateTimer();
            }
        } while (TimerTXT != null);
    }

    private void UpdateTimer() {
        MiliSec--;
        if (MiliSec < 0) {
            Sec--;
            MiliSec = 59;
        }
        if (Sec < 0) {
            if (Min <= 0) {
                JOptionPane.showMessageDialog(this, "Turno de: ", "Cambio de turno", JOptionPane.INFORMATION_MESSAGE);
            }
            Min = (Min != 0) ? 0 : 1;
            Sec = 59;
        }
        Timer.setText(Min + ":" + Sec + ":" + MiliSec);
    }

    // -- SWING ELEMENTS --
    private JCard[][] CartasDelTablero;
    // -- SWING ELEMENTS --
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarajaDeCartasTXT;
    private javax.swing.JLabel CardDeckIcon;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel LastCardIcon;
    private javax.swing.JLabel LastCardTXT;
    private javax.swing.JLabel Player1Team1;
    private javax.swing.JLabel Player1Team2;
    private javax.swing.JLabel Player1Team3;
    private javax.swing.JLabel Player1Team4;
    private javax.swing.JLabel Player2Team1;
    private javax.swing.JLabel Player2Team2;
    private javax.swing.JLabel Player2Team3;
    private javax.swing.JLabel Player2Team4;
    private javax.swing.JPanel Tablero;
    private javax.swing.JLabel Team1Name;
    private javax.swing.JLabel Team2Name;
    private javax.swing.JLabel Team3Name1;
    private javax.swing.JLabel Team4Name;
    private javax.swing.JPanel Team_1_Panel;
    private javax.swing.JPanel Team_2_Panel;
    private javax.swing.JPanel Team_3_Panel;
    private javax.swing.JPanel Team_4_Panel;
    private javax.swing.JLabel Timer;
    // End of variables declaration//GEN-END:variables

}

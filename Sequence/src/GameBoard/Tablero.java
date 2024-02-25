/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GameBoard;

import Logic.UI_Elements.JCard;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        TeamPanel = new javax.swing.JPanel();
        Player2 = new javax.swing.JLabel();
        Team = new javax.swing.JLabel();
        Player1 = new javax.swing.JLabel();
        LastCardTXT = new javax.swing.JLabel();
        LastCardIcon = new javax.swing.JLabel();
        BarajaDeCartasTXT = new javax.swing.JLabel();
        CardDeckIcon = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Card2 = new javax.swing.JLabel();
        Card1 = new javax.swing.JLabel();
        Card3 = new javax.swing.JLabel();
        Card4 = new javax.swing.JLabel();
        Card5 = new javax.swing.JLabel();
        Card6 = new javax.swing.JLabel();
        Team4 = new javax.swing.JPanel();
        Team4Members1 = new javax.swing.JLabel();
        Team3 = new javax.swing.JPanel();
        Team3Members1 = new javax.swing.JLabel();
        Team2 = new javax.swing.JPanel();
        Team2Members1 = new javax.swing.JLabel();
        Team1 = new javax.swing.JPanel();
        Team1Members1 = new javax.swing.JLabel();
        Team5 = new javax.swing.JPanel();
        Team4Members2 = new javax.swing.JLabel();
        Team6 = new javax.swing.JPanel();
        Team3Members2 = new javax.swing.JLabel();
        Team7 = new javax.swing.JPanel();
        Team2Members2 = new javax.swing.JLabel();
        Team8 = new javax.swing.JPanel();
        Team1Members2 = new javax.swing.JLabel();

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

        Fondo.add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 700, 500));

        TeamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player2.setText("[Player 2 Icon]");
        TeamPanel.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 90, 90));

        Team.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team.setText("Team ");
        TeamPanel.add(Team, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, -1));

        Player1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Player1.setText("[Player 1 Icon]");
        TeamPanel.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 90, 90));

        Fondo.add(TeamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 190));

        LastCardTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardTXT.setText("Ultima carta jugada");
        Fondo.add(LastCardTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 160, -1));

        LastCardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardIcon.setText("[CONO DE LA ULTIMA CARTA]");
        Fondo.add(LastCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, 160, 140));

        BarajaDeCartasTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BarajaDeCartasTXT.setText("Baraja de cartas");
        Fondo.add(BarajaDeCartasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 380, 160, -1));

        CardDeckIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CardDeckIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GameBoard/Icons/Deck.png"))); // NOI18N
        Fondo.add(CardDeckIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, 160, 140));

        Timer.setForeground(new java.awt.Color(255, 255, 255));
        Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Timer.setText("Timer");
        Timer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Fondo.add(Timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 350, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        Fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 160, 140));

        Card2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2.setText("Card2");
        Fondo.add(Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 70, 50));

        Card1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1.setText("Card1");
        Fondo.add(Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 70, 50));

        Card3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3.setText("Card3");
        Fondo.add(Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 70, 50));

        Card4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4.setText("Card4");
        Fondo.add(Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 70, 50));

        Card5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card5.setText("Card5");
        Fondo.add(Card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 70, 50));

        Card6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card6.setText("Card6");
        Fondo.add(Card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 70, 50));

        Team4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team4Members1.setText("Equipo 4: integrante 1");
        Team4.add(Team4Members1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 30));

        Team3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team3Members1.setText("Equipo 3: integrante 1");
        Team3.add(Team3Members1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 30));

        Team2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team2Members1.setText("Equipo 2: integrante 1");
        Team2.add(Team2Members1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, 30));

        Team1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team1Members1.setText("Equipo 1: integrante 1");
        Team1.add(Team1Members1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 30));

        Team5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team4Members2.setText("Equipo 4: integrante 2");
        Team5.add(Team4Members2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 210, 30));

        Team6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team3Members2.setText("Equipo 3: integrante 2");
        Team6.add(Team3Members2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 210, 30));

        Team7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team2Members2.setText("Equipo 2: integrante 2");
        Team7.add(Team2Members2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 210, 30));

        Team8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team1Members2.setText("Equipo 1: integrante 2");
        Team8.add(Team1Members2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(Team8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 210, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Los botones que se observan en en el tablero, si, es un tanto intuitivo solo con el nombre.
    private void setBoardBTNS() {
        try {
            CartasDelTablero = new JCard[10][10];
            InputStream in = getClass().getResourceAsStream("Board");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            for (int Columna = 0; Columna < 10; Columna++) {
                String Line = br.readLine();
                String Num[] = Line.split(" ");
                for (int Fila = 0; Fila < 10; Fila++) {
                    CartasDelTablero[Fila][Columna] = new JCard(Columna, Fila);
                    
                    try {
                        CartasDelTablero[Fila][Columna].setBorder(null);
                        CartasDelTablero[Fila][Columna].setCard(Num[Fila], new javax.swing.ImageIcon(getClass().getResource("Icons\\"+Num[Fila]+".png")));
                    } catch (Exception Ex){}
                    
                    CartasDelTablero[Fila][Columna].addActionListener((ActionEvent Ex) -> {
                        int Row = ((JCard) Ex.getSource()).getFila();
                        int Column = ((JCard) Ex.getSource()).getColumna();
                        Action(Row, Column);
                    });
                    
                    CartasDelTablero[Fila][Columna].setBounds(70 * Fila, 50 * Columna, 70, 50);
                    Tablero.add(CartasDelTablero[Fila][Columna]);
                }
            }
            br.close();
        } catch (IOException e) { 
            System.out.println("Error");
        }
    }
    
    private void Action(int Row, int Column){
        System.out.println("Nice");
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
    private javax.swing.JLabel Card1;
    private javax.swing.JLabel Card2;
    private javax.swing.JLabel Card3;
    private javax.swing.JLabel Card4;
    private javax.swing.JLabel Card5;
    private javax.swing.JLabel Card6;
    private javax.swing.JLabel CardDeckIcon;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel LastCardIcon;
    private javax.swing.JLabel LastCardTXT;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JPanel Tablero;
    private javax.swing.JLabel Team;
    private javax.swing.JPanel Team1;
    private javax.swing.JLabel Team1Members1;
    private javax.swing.JLabel Team1Members2;
    private javax.swing.JPanel Team2;
    private javax.swing.JLabel Team2Members1;
    private javax.swing.JLabel Team2Members2;
    private javax.swing.JPanel Team3;
    private javax.swing.JLabel Team3Members1;
    private javax.swing.JLabel Team3Members2;
    private javax.swing.JPanel Team4;
    private javax.swing.JLabel Team4Members1;
    private javax.swing.JLabel Team4Members2;
    private javax.swing.JPanel Team5;
    private javax.swing.JPanel Team6;
    private javax.swing.JPanel Team7;
    private javax.swing.JPanel Team8;
    private javax.swing.JPanel TeamPanel;
    private javax.swing.JLabel Timer;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

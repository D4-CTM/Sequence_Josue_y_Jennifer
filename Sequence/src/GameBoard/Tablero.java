/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GameBoard;

import Logic.UI_Elements.JCard;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author josue
 */
public class Tablero extends javax.swing.JFrame implements Runnable {
    //Timer elements
    private int Min, Sec, MiliSec;
    private Thread TimerTXT;
    //variables used for changing the turn
    private final String[] Player = new String[8];
    private final int Players;
    private boolean Pause;
    private int Turn;
    //Variables used for taking a card
    private String SelectedCard = "IDK";
    public Tablero(int Players) {
        initComponents();
        setBoardBTNS();
        
        setResizable(false);
        setPlayersinfo(Players);
        StartThread();
        
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Elementos/GameIcon.png")).getImage());

        this.Players = Players;
        Turn = Players - 1;
        Pause = false;
    }

    private void StartThread() {
        TimerTXT = new Thread(this);

        TimerTXT.start();
    }
    
    private void setPlayersinfo(int Players){
        BGPlayer1.setVisible(true);
        BGPlayer2.setVisible(true);
        BGPlayer3.setVisible(Players >= 3);
        BGPlayer4.setVisible(Players >= 4);
        BGPlayer5.setVisible(Players >= 5);
        BGPlayer6.setVisible(Players >= 6);
        BGPlayer7.setVisible(Players >= 8);
        BGPlayer8.setVisible(Players >= 8);
        
        Player[0] = Player1.getText();
        Player[1] = Player2.getText();
        Player[2] = Player3.getText();
        Player[3] = Player4.getText();
        Player[4] = Player5.getText();
        Player[5] = Player6.getText();
        Player[6] = Player7.getText();
        Player[7] = Player8.getText();
        
        Card1.setVisible(true);
        Card2.setVisible(true);
        Card3.setVisible(true);
        Card4.setVisible(true);
        Card5.setVisible(Players == 2 || Players == 3 || Players == 4 || Players == 6);
        Card6.setVisible(Players == 2 || Players == 3 || Players == 4);
        Card7.setVisible(Players == 2 || Players == 4);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Tablero = new javax.swing.JPanel();
        TeamPanel = new javax.swing.JPanel();
        Team = new javax.swing.JLabel();
        PlayerIcon = new javax.swing.JLabel();
        LastCardTXT = new javax.swing.JLabel();
        LastCardIcon = new javax.swing.JLabel();
        BarajaDeCartasTXT = new javax.swing.JLabel();
        CardDeckIcon = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ScrollInfo = new javax.swing.JScrollPane();
        TeamReport = new javax.swing.JTextArea();
        Card2 = new javax.swing.JLabel();
        Card1 = new javax.swing.JLabel();
        Card3 = new javax.swing.JLabel();
        Card4 = new javax.swing.JLabel();
        Card5 = new javax.swing.JLabel();
        Card7 = new javax.swing.JLabel();
        BGPlayer4 = new javax.swing.JPanel();
        Player4 = new javax.swing.JLabel();
        BGPlayer3 = new javax.swing.JPanel();
        Player3 = new javax.swing.JLabel();
        BGPlayer2 = new javax.swing.JPanel();
        Player2 = new javax.swing.JLabel();
        BGPlayer1 = new javax.swing.JPanel();
        Player1 = new javax.swing.JLabel();
        BGPlayer8 = new javax.swing.JPanel();
        Player8 = new javax.swing.JLabel();
        BGPlayer7 = new javax.swing.JPanel();
        Player7 = new javax.swing.JLabel();
        BGPlayer6 = new javax.swing.JPanel();
        Player6 = new javax.swing.JLabel();
        BGPlayer5 = new javax.swing.JPanel();
        Player5 = new javax.swing.JLabel();
        Card6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sequence");
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

        Team.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team.setText("Team ");
        TeamPanel.add(Team, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, -1));

        PlayerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerIcon.setText("[Player 1 Icon]");
        PlayerIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TeamPanel.add(PlayerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, 120));

        Fondo.add(TeamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 190));

        LastCardTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardTXT.setText("Ultima carta jugada");
        Fondo.add(LastCardTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 160, -1));

        LastCardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardIcon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 2, true));
        Fondo.add(LastCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 140, 100));

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TeamReport.setEditable(false);
        TeamReport.setColumns(20);
        TeamReport.setForeground(new java.awt.Color(255, 255, 255));
        TeamReport.setLineWrap(true);
        TeamReport.setRows(5);
        TeamReport.setWrapStyleWord(true);
        ScrollInfo.setViewportView(TeamReport);

        jPanel1.add(ScrollInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 140));

        Fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 160, 140));

        Card2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2.setText("Card2");
        Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card2MouseClicked(evt);
            }
        });
        Fondo.add(Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 70, 50));

        Card1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1.setText("0T");
        Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card1MouseClicked(evt);
            }
        });
        Fondo.add(Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 70, 50));

        Card3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3.setText("Card3");
        Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card3MouseClicked(evt);
            }
        });
        Fondo.add(Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 70, 50));

        Card4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4.setText("Card4");
        Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card4MouseClicked(evt);
            }
        });
        Fondo.add(Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, 70, 50));

        Card5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card5.setText("Card5");
        Card5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card5MouseClicked(evt);
            }
        });
        Fondo.add(Card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 70, 50));

        Card7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card7.setText("Card7");
        Card7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card7MouseClicked(evt);
            }
        });
        Fondo.add(Card7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 70, 50));

        BGPlayer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player4.setText("Jugador 4");
        BGPlayer4.add(Player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 30));

        BGPlayer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player3.setText("Jugador 3");
        BGPlayer3.add(Player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 30));

        BGPlayer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2.setText("Jugador 2");
        BGPlayer2.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, 30));

        BGPlayer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player1.setText("Jugador 1");
        BGPlayer1.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 30));

        BGPlayer8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player8.setText("Jugador 8");
        BGPlayer8.add(Player8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 210, 30));

        BGPlayer7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player7.setText("Jugador 7");
        BGPlayer7.add(Player7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 210, 30));

        BGPlayer6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player6.setText("Jugador 6");
        BGPlayer6.add(Player6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 210, 30));

        BGPlayer5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player5.setText("Jugador 5");
        BGPlayer5.add(Player5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 210, 30));

        Card6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card6.setText("Card6");
        Card6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card6MouseClicked(evt);
            }
        });
        Fondo.add(Card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 70, 50));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card1MouseClicked
        SelectedCard = Card1.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card1MouseClicked

    private void Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card2MouseClicked
        SelectedCard = Card2.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card2MouseClicked

    private void Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card3MouseClicked
        SelectedCard = Card3.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card3MouseClicked

    private void Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card4MouseClicked
        SelectedCard = Card4.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card4MouseClicked

    private void Card5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card5MouseClicked
        SelectedCard = Card5.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card5MouseClicked

    private void Card6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card6MouseClicked
        SelectedCard = Card6.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card6MouseClicked

    private void Card7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card7MouseClicked
        SelectedCard = Card7.getText();
        setBorders(BorderFactory.createLineBorder(Color.yellow, 2), SelectedCard);
    }//GEN-LAST:event_Card7MouseClicked

    //Los botones que se observan en en el tablero, si, es un tanto intuitivo solo con el nombre.
    private void setBoardBTNS() {
        try {
            CartasDelTablero = new JCard[10][10];
            InputStream in = getClass().getResourceAsStream("Board");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            for (int Fila = 0; Fila < 10; Fila++) {
                String Line = br.readLine();
                String Num[] = Line.split(" ");
                for (int Columna = 0; Columna < 10; Columna++) {
                    CartasDelTablero[Fila][Columna] = new JCard(Fila, Columna);
                    CartasDelTablero[Fila][Columna].setBounds((Tablero.getWidth()/10)*Fila, (Tablero.getHeight()/10)*Columna, Tablero.getWidth()/10, Tablero.getHeight()/10);

                    try {
                        CartasDelTablero[Fila][Columna].setBorder(null);
                        CartasDelTablero[Fila][Columna].setCard(Num[Columna], ScaledImage("Icons\\"+Num[Columna]+".png", CartasDelTablero[Fila][Columna].getWidth(), CartasDelTablero[Fila][Columna].getHeight()));
                    } catch (Exception Ex){System.out.print("Fila: "+Fila+"\tColumna: "+Columna+"\n");}

                    CartasDelTablero[Fila][Columna].addActionListener((ActionEvent Ex) -> {
                        int Row = ((JCard) Ex.getSource()).getFila();
                        int Column = ((JCard) Ex.getSource()).getColumna();
                        
                        TakeCard(Row, Column);
                    });
                    
                    Tablero.add(CartasDelTablero[Fila][Columna]);
                }
            }
            br.close();
        } catch (IOException e) { 
            System.out.println("Error");
        }
    }
    
    private ImageIcon ScaledImage(String Url, int Width, int Height){
        ImageIcon neoIcon = new ImageIcon(getClass().getResource(Url));
        Image scaledCard = neoIcon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        neoIcon = new ImageIcon(scaledCard);
        return neoIcon;
    }
    
    private void TakeCard(int Row, int Column){
        if (!SelectedCard.equals("IDK")){
            Pause = true;
            if (!CartasDelTablero[Row][Column].getCard().equals("0F")){
                if (SelectedCard.equals(CartasDelTablero[Row][Column].getCard())){
                    if (!CartasDelTablero[Row][Column].isCardTaken()){
                        if (!CartasDelTablero[Row][Column].isLineComplete()){
                            if (CartasDelTablero[Row][Column].TakeCard(ScaledImage("Icons\\Tokens1.png",CartasDelTablero[Row][Column].getWidth(), CartasDelTablero[Row][Column].getHeight()))){
                                LastCardIcon.setIcon(ScaledImage(CartasDelTablero[Row][Column].getCardUrl(), LastCardIcon.getWidth(), LastCardIcon.getHeight()));
                                SelectedCard = "IDK";
                                ChangeTurn("");
                                setBorders(null, "");
                            } else JOptionPane.showMessageDialog(this, "¡No se ha podido tomar esta carta!", "ERROR", JOptionPane.WARNING_MESSAGE);
                        } else JOptionPane.showMessageDialog(this, "¡Esta ficha conforma una linea!\nIntente tomar otro espacio","Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                    } else JOptionPane.showMessageDialog(this, "¡El espacio que esta intentando tomar ya esta ocupado!","Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                } else JOptionPane.showMessageDialog(this, "¡La carta que esta intentando tomar no coincide con la seleccionada!","Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(this,"¡No puede ocupar este tipo de espacios!","Zona neutra", JOptionPane.INFORMATION_MESSAGE);
            Pause = false;
        }
    }
    
    private void setBorders(Border Borde, String CardSearch){
        for (int Fila = 0; Fila < 10; Fila++) {
            for (int Columna = 0; Columna < 10; Columna++) {
                if (Borde == null && CartasDelTablero[Fila][Columna].getBorder() != null){
                    CartasDelTablero[Fila][Columna].setBorder(Borde);
                } else if (CartasDelTablero[Fila][Columna].getCard().equals(CardSearch) && !CartasDelTablero[Fila][Columna].isCardTaken()){
                    CartasDelTablero[Fila][Columna].setBorder(Borde);
                }
            }
        }
    }
    
    public static void main(String args[]) {
        new Tablero(8).setVisible(true);
    }

    @Override
    public void run() {
        Min = 0;
        Sec = 0;
        MiliSec = 0;
        ChangeTurn("");
        float LastFrame = 0;
        do {
            if (((System.nanoTime() - LastFrame) >= 1000000000 / 60) && !Pause) {
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
                ChangeTurn("¡Se ha quedado sin tiempo!\n");
            } else {
                Min--;
                Sec = 59;
            }
        }
        Timer.setText(Min + ":" + Sec + ":" + MiliSec);
    }
    
    private void ChangeTurn(String ExtraInfo){
        Turn = (Turn + 1 == Players)?0:Turn + 1;
        JOptionPane.showMessageDialog(this, ExtraInfo + "Turno de: " + Player[Turn], "Cambio de turno", JOptionPane.INFORMATION_MESSAGE);
        Min = 1;
        Sec = 59;
        MiliSec = 59;
        Pause = false;
    }
    
    // -- SWING ELEMENTS --
    private JCard[][] CartasDelTablero;
    // -- SWING ELEMENTS --
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPlayer1;
    private javax.swing.JPanel BGPlayer2;
    private javax.swing.JPanel BGPlayer3;
    private javax.swing.JPanel BGPlayer4;
    private javax.swing.JPanel BGPlayer5;
    private javax.swing.JPanel BGPlayer6;
    private javax.swing.JPanel BGPlayer7;
    private javax.swing.JPanel BGPlayer8;
    private javax.swing.JLabel BarajaDeCartasTXT;
    private javax.swing.JLabel Card1;
    private javax.swing.JLabel Card2;
    private javax.swing.JLabel Card3;
    private javax.swing.JLabel Card4;
    private javax.swing.JLabel Card5;
    private javax.swing.JLabel Card6;
    private javax.swing.JLabel Card7;
    private javax.swing.JLabel CardDeckIcon;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel LastCardIcon;
    private javax.swing.JLabel LastCardTXT;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel Player3;
    private javax.swing.JLabel Player4;
    private javax.swing.JLabel Player5;
    private javax.swing.JLabel Player6;
    private javax.swing.JLabel Player7;
    private javax.swing.JLabel Player8;
    private javax.swing.JLabel PlayerIcon;
    private javax.swing.JScrollPane ScrollInfo;
    private javax.swing.JPanel Tablero;
    private javax.swing.JLabel Team;
    private javax.swing.JPanel TeamPanel;
    private javax.swing.JTextArea TeamReport;
    private javax.swing.JLabel Timer;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

package GameBoard;

import Logic.UI_Elements.JCard;
import Logic.Users.GestorUsuarios;
import Logic.Users.Player;
import Sequence.Main_Sequence;
import Sequence.PantallaPrincipal;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private final Player[] Player = new Player[8];
    private final int Players;
    private boolean Pause;
    private int Turn;
    //Variables used for taking a card
    private String SelectedCard = "IDK";
    private int CartaJugada;
    //Variables de Modificadores
    private boolean BlockMode, FreeMode, SelectCard;
    private final boolean[] Tryed = new boolean[8];
    private final Random Randy;
    private int CardsPlayed;
    
    private boolean DebugMode;
    
    public Tablero(ArrayList<Player> Jugadores, int Players) throws IOException, ClassNotFoundException {
        Randy = new Random();
        SelectCard = true;
        BlockMode = false;
        FreeMode = false;
        CardsPlayed = 0;
        
        restartTries();
        
        initComponents();
        setBoardBTNS();
        
        setMiniCardsListeners();
        Deck.EmptyDeck();
        Deck.setDeck();
        Deck.setDeck();

        setTeams(Jugadores);
        setPlayersinfo(Players);
        setResizable(false);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Elementos/GameIcon.png")).getImage());
        TeamReport.setText(ChangeInfoBox(1, ""));
        
        this.Players = Players;
        Pause = false;
        Turn = 0;
        
        StartThread();
    }

    private void setMiniCardsListeners(){
        Card1MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card1MouseClicked(evt);
            }
        });
        Card2MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card2MouseClicked(evt);
            }
        });
        Card3MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card3MouseClicked(evt);
            }
        });
        Card3MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card3MouseClicked(evt);
            }
        });
        Card4MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card4MouseClicked(evt);
            }
        });
        Card5MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card5MouseClicked(evt);
            }
        });
        Card6MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card6MouseClicked(evt);
            }
        });
        Card7MI.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card7MouseClicked(evt);
            }
        });
    }
    
    private void setTeams(ArrayList<Player> Jugadores){
        int Limit = Jugadores.size();
        int JugadoresAgregados = 0;
        int LastTeamPlayer = 3;
        int ActPlayer = 0;

        do {
            
            if (Player[JugadoresAgregados] == null && LastTeamPlayer != Jugadores.get(ActPlayer).getTeam()){
                Player[JugadoresAgregados] = Jugadores.get(ActPlayer);
                LastTeamPlayer = Player[JugadoresAgregados].getTeam();
                
                
                
                Jugadores.remove(ActPlayer);
                JugadoresAgregados++;
            }
            
            ActPlayer = (ActPlayer + 1 >= Jugadores.size())?0:ActPlayer + 1;
        
        } while (JugadoresAgregados < Limit);
        
    }

    private void StartThread() {
        TimerTXT = new Thread(this);

        TimerTXT.start();
    }

    private void setPlayersinfo(int Players) throws IOException, ClassNotFoundException {
        BGPlayer1.setVisible(true);
        BGPlayer2.setVisible(true);
        BGPlayer3.setVisible(Players >= 3);
        BGPlayer4.setVisible(Players >= 4);
        BGPlayer5.setVisible(Players >= 5);
        BGPlayer6.setVisible(Players >= 6);
        BGPlayer7.setVisible(Players >= 8);
        BGPlayer8.setVisible(Players >= 8);

        try {
            Player1.setText(Player[0].getPlayer().getUsername() + " - Equipo #" + Player[0].getTeam());
            Player2.setText(Player[1].getPlayer().getUsername() + " - Equipo #" + Player[1].getTeam());
            Player3.setText(Player[2].getPlayer().getUsername() + " - Equipo #" + Player[2].getTeam());
            Player4.setText(Player[3].getPlayer().getUsername() + " - Equipo #" + Player[3].getTeam());
            Player5.setText(Player[4].getPlayer().getUsername() + " - Equipo #" + Player[4].getTeam());
            Player6.setText(Player[5].getPlayer().getUsername() + " - Equipo #" + Player[5].getTeam());
            Player7.setText(Player[6].getPlayer().getUsername() + " - Equipo #" + Player[6].getTeam());
        } catch (Exception Ex) {}

        Card1.setText(null);
        Card2.setText(null);
        Card3.setText(null);
        Card4.setText(null);
        Card5.setText(null);
        Card6.setText(null);
        Card7.setText(null);

        Card1.setVisible(true);
        Card2.setVisible(true);
        Card3.setVisible(true);
        Card4.setVisible(true);
        Card5.setVisible(Players == 2 || Players == 3 || Players == 4 || Players == 6);
        Card6.setVisible(Players == 2 || Players == 3 || Players == 4);
        Card7.setVisible(Players == 2 || Players == 4);

        Image scaledCard = Player[Turn].getPlayer().getPlayerIcon().getImage().getScaledInstance(PlayerIcon.getWidth() / 2, PlayerIcon.getHeight() / 2, Image.SCALE_SMOOTH);

        PlayerIcon.setIcon(new ImageIcon(scaledCard));
        PlayerIcon.setText(Player1.getText());

        PlayerCards();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Tablero = new javax.swing.JPanel();
        TeamPanel = new javax.swing.JPanel();
        PlayerIcon = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        Card1MI = new javax.swing.JLabel();
        Card5MI = new javax.swing.JLabel();
        Card2MI = new javax.swing.JLabel();
        Card3MI = new javax.swing.JLabel();
        Card4MI = new javax.swing.JLabel();
        Card7MI = new javax.swing.JLabel();
        Card6MI = new javax.swing.JLabel();
        LastCardTXT = new javax.swing.JLabel();
        LastCardIcon = new javax.swing.JLabel();
        BarajaDeCartasTXT = new javax.swing.JLabel();
        CardDeckIcon = new javax.swing.JLabel();
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
        DebugModeBTN = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sequence");
        setMinimumSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(1100, 600));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablero.setBackground(new java.awt.Color(255, 153, 153));
        Tablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        Fondo.add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 700, 500));

        TeamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayerIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerIcon.setText("[Player 1 Icon]");
        PlayerIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PlayerIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TeamPanel.add(PlayerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 160));

        Timer.setForeground(new java.awt.Color(0, 0, 0));
        Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Timer.setText("Timer");
        Timer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TeamPanel.add(Timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));
        TeamPanel.add(Card1MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 60, 40));
        TeamPanel.add(Card5MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 60, 40));
        TeamPanel.add(Card2MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 60, 40));
        TeamPanel.add(Card3MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 60, 40));
        TeamPanel.add(Card4MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 60, 40));
        TeamPanel.add(Card7MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 60, 40));
        TeamPanel.add(Card6MI, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 60, 40));

        Fondo.add(TeamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 190));

        LastCardTXT.setForeground(new java.awt.Color(0, 102, 102));
        LastCardTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardTXT.setText("Ultima carta jugada");
        Fondo.add(LastCardTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 160, -1));

        LastCardIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LastCardIcon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 2, true));
        Fondo.add(LastCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 140, 100));

        BarajaDeCartasTXT.setForeground(new java.awt.Color(0, 102, 102));
        BarajaDeCartasTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BarajaDeCartasTXT.setText("Baraja de cartas");
        Fondo.add(BarajaDeCartasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 380, 160, -1));

        CardDeckIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CardDeckIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logic/UI_Elements/Deck.png"))); // NOI18N
        Fondo.add(CardDeckIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, 160, 140));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TeamReport.setEditable(false);
        TeamReport.setColumns(20);
        TeamReport.setForeground(new java.awt.Color(0, 0, 0));
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
        Card1.setText("Card1");
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

        BGPlayer4.setBackground(new java.awt.Color(102, 0, 102));
        BGPlayer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player4.setForeground(new java.awt.Color(255, 255, 255));
        Player4.setText("Jugador 4");
        BGPlayer4.add(Player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 30));

        BGPlayer3.setBackground(new java.awt.Color(51, 102, 0));
        BGPlayer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player3.setForeground(new java.awt.Color(255, 255, 255));
        Player3.setText("Jugador 3");
        BGPlayer3.add(Player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 30));

        BGPlayer2.setBackground(new java.awt.Color(102, 0, 51));
        BGPlayer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player2.setBackground(new java.awt.Color(255, 255, 255));
        Player2.setForeground(new java.awt.Color(255, 255, 255));
        Player2.setText("Jugador 2");
        BGPlayer2.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 210, 30));

        BGPlayer1.setBackground(new java.awt.Color(0, 0, 102));
        BGPlayer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player1.setBackground(new java.awt.Color(255, 255, 255));
        Player1.setForeground(new java.awt.Color(255, 255, 255));
        Player1.setText("Jugador 1");
        BGPlayer1.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 30));

        BGPlayer8.setBackground(new java.awt.Color(102, 0, 102));
        BGPlayer8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player8.setForeground(new java.awt.Color(255, 255, 255));
        Player8.setText("Jugador 8");
        BGPlayer8.add(Player8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 210, 30));

        BGPlayer7.setBackground(new java.awt.Color(51, 102, 0));
        BGPlayer7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player7.setForeground(new java.awt.Color(255, 255, 255));
        Player7.setText("Jugador 7");
        BGPlayer7.add(Player7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 210, 30));

        BGPlayer6.setBackground(new java.awt.Color(102, 0, 51));
        BGPlayer6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player6.setForeground(new java.awt.Color(255, 255, 255));
        Player6.setText("Jugador 6");
        BGPlayer6.add(Player6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        Fondo.add(BGPlayer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 210, 30));

        BGPlayer5.setBackground(new java.awt.Color(0, 51, 102));
        BGPlayer5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player5.setForeground(new java.awt.Color(255, 255, 255));
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

        DebugModeBTN.setText("Debug mode");
        DebugModeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DebugModeBTNActionPerformed(evt);
            }
        });
        Fondo.add(DebugModeBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Tablero.png"))); // NOI18N
        Fondo.add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1100, 620));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card1MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        CartaJugada = 0;
        SelectedCard = Player[Turn].getCard(CartaJugada);
        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            } else JOptionPane.showMessageDialog(this, "¡Mejor suerte la proxima!", "Ha fallado la oportunidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            setBorders(BorderFactory.createLineBorder(
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);   
        }
    }//GEN-LAST:event_Card1MouseClicked

    private void Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card2MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            } else JOptionPane.showMessageDialog(this, "¡Mejor suerte la proxima!", "Ha fallado la oportunidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            CartaJugada = 1;
            SelectedCard = Player[Turn].getCard(CartaJugada);
            setBorders(BorderFactory.createLineBorder(
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);
}        
    }//GEN-LAST:event_Card2MouseClicked

    private void Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card3MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        CartaJugada = 2;
        SelectedCard = Player[Turn].getCard(CartaJugada);
        
        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            } else JOptionPane.showMessageDialog(this, "¡Mejor suerte la proxima!", "Ha fallado la oportunidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            setBorders(BorderFactory.createLineBorder(
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);
        }
    }//GEN-LAST:event_Card3MouseClicked

    private void Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card4MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        CartaJugada = 3;
        SelectedCard = Player[Turn].getCard(CartaJugada);
        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            } else JOptionPane.showMessageDialog(this, "¡Mejor suerte la proxima!", "Ha fallado la oportunidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            setBorders(BorderFactory.createLineBorder(
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);
        }
    }//GEN-LAST:event_Card4MouseClicked

    private void Card5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card5MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        CartaJugada = 4;
        SelectedCard = Player[Turn].getCard(CartaJugada);
        
        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            } else JOptionPane.showMessageDialog(this, "¡Mejor suerte la proxima!", "Ha fallado la oportunidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            setBorders(BorderFactory.createLineBorder(
            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);
        }
    }//GEN-LAST:event_Card5MouseClicked

    private void Card6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card6MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        CartaJugada = 5;
        SelectedCard = Player[Turn].getCard(CartaJugada);
        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            } else JOptionPane.showMessageDialog(this, "¡Mejor suerte la proxima!", "Ha fallado la oportunidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            setBorders(BorderFactory.createLineBorder(
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);
        }
    }//GEN-LAST:event_Card6MouseClicked

    private void Card7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card7MouseClicked
        if (BlockMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas en el tablero disponibles para bloquear", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (FreeMode) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una de las cartas que desea liberar", "Liberar carta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        CartaJugada = 6;
        SelectedCard = Player[Turn].getCard(CartaJugada);
        
        if (SelectedCard.contains("J")){
            if (CheckEvent(SelectedCard)){
                Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

                SelectedCard = "IDK";
                if (!BlockMode && !FreeMode)
                    ChangeTurn("");
            }
        } else {
            setBorders(BorderFactory.createLineBorder(
            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    Color.RED;
                case "Estilo retro" ->
                    Color.YELLOW;
            },
            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                default ->
                    4;
                case "Estilo retro" ->
                    2;
            }), SelectedCard);
        }
    }//GEN-LAST:event_Card7MouseClicked

    private void DebugModeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DebugModeBTNActionPerformed
        DebugMode = !DebugMode;
        Pause = DebugMode;
        if (DebugMode) JOptionPane.showMessageDialog(this, "Debug mode activated");
    }//GEN-LAST:event_DebugModeBTNActionPerformed

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
                    CartasDelTablero[Fila][Columna].setBounds((Tablero.getWidth() / 10) * Fila, (Tablero.getHeight() / 10) * Columna, Tablero.getWidth() / 10, Tablero.getHeight() / 10);

                    try {
                        File Carta = new File(Main_Sequence.ActualSetting.getCardsUrl() + Num[Columna] + ".png");
                        CartasDelTablero[Fila][Columna].setBorder(null);
                        CartasDelTablero[Fila][Columna].setCard(Num[Columna], Main_Sequence.ActualSetting.getCardsUrl(), ScaledImage(Carta.getAbsolutePath(), CartasDelTablero[Fila][Columna].getWidth(), CartasDelTablero[Fila][Columna].getHeight()));
                    } catch (Exception Ex) {
                        System.out.print("Fila: " + Fila + "\tColumna: " + Columna + "\n");
                    }

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

    private ImageIcon ScaledImage(String Url, int Width, int Height) {
        ImageIcon neoIcon = new ImageIcon(Url);
        Image scaledCard = neoIcon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        neoIcon = new ImageIcon(scaledCard);
        return neoIcon;
    }

    private void TakeCard(int Row, int Column) {
        File CartaPNG = new File(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getPlayer().getFicha());
        ImageIcon neoIcon = ScaledImage(CartaPNG.getAbsolutePath(), CartasDelTablero[Row][Column].getWidth(), CartasDelTablero[Row][Column].getHeight());

        if (DebugMode){
            CartasDelTablero[Row][Column].TakeCard(neoIcon, Player[Turn].getPlayer().getUsername(), Player[Turn].getTeam());
            LastCardIcon.setIcon(ScaledImage(CartasDelTablero[Row][Column].getCardUrl(), LastCardIcon.getWidth(), LastCardIcon.getHeight()));
            setBorders(null, "");

            CheckSequence();
//            CheckEvent(SelectedCard);

            if (!SelectCard) Player[Turn].PlayCard(CartaJugada);
                CardsPlayed++;

            SelectCard = false;
            SelectedCard = "IDK";
            Player[Turn].RemoveCoin(1);

            PlayerCards();
            Image scaledCard = Player[Turn].getPlayer().getPlayerIcon().getImage().getScaledInstance(PlayerIcon.getWidth() / 2, PlayerIcon.getHeight() / 2, Image.SCALE_SMOOTH);

            restartTries();
            try {
                
                TeamReport.setText(ChangeInfoBox(1, ""));

            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }

            PlayerIcon.setIcon(new ImageIcon(scaledCard));
            PlayerIcon.setText(Player[Turn].getPlayer().getUsername());
            Pause = false;

            return ;
        }
        
        Pause = true;
        if (!SelectedCard.equals("IDK") && !BlockMode && !FreeMode) {
            if (!CartasDelTablero[Row][Column].getCard().equals("0F")) {
                if (SelectedCard.equals(CartasDelTablero[Row][Column].getCard())) {
                    if (!CartasDelTablero[Row][Column].isCardTaken()) {
                        if (!CartasDelTablero[Row][Column].isLineComplete()) {

                            if (!BlockMode && CartasDelTablero[Row][Column].TakeCard(neoIcon, Player[Turn].getPlayer().getUsername(), Player[Turn].getTeam())) {
                                LastCardIcon.setIcon(ScaledImage(CartasDelTablero[Row][Column].getCardUrl(), LastCardIcon.getWidth(), LastCardIcon.getHeight()));
                                setBorders(null, "");

                                CheckSequence();
                                CheckEvent(SelectedCard);

                                if (!SelectCard) Player[Turn].PlayCard(CartaJugada);
                                CardsPlayed++;
                                
                                SelectCard = false;
                                SelectedCard = "IDK";
                                if (!BlockMode && !FreeMode) {
                                    ChangeTurn("");
                                }
                                Player[Turn].RemoveCoin(1);
                            } else {
                                JOptionPane.showMessageDialog(this, "¡No se ha podido tomar esta carta!", "ERROR", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "¡Esta ficha conforma una linea!\nIntente tomar otro espacio", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "¡El espacio que esta intentando tomar ya esta ocupado!", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "¡La carta que esta intentando tomar no coincide con la seleccionada!", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "¡No puede ocupar este tipo de espacios!", "Zona neutra", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (BlockMode) {
            if (!CartasDelTablero[Row][Column].getCard().equals("0F")) {
                if (!CartasDelTablero[Row][Column].isCardTaken()) {
                    if (!CartasDelTablero[Row][Column].isLineComplete()) {
                        CartasDelTablero[Row][Column].BlockCard(neoIcon);
                        SelectedCard = "IDK";
                        ChangeTurn("");
                        setBorders(null, "");

                        BlockMode = false;
                    } else {
                        JOptionPane.showMessageDialog(this, "¡Esta ficha conforma una linea!\nIntente tomar otro espacio", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "¡El espacio que esta intentando tomar ya esta ocupado!", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "¡No puede ocupar este tipo de espacios!", "Zona neutra", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (FreeMode) {
            if (!CartasDelTablero[Row][Column].getCard().equals("0F")) {
                if (CartasDelTablero[Row][Column].isCardTaken()) {
                    if (!CartasDelTablero[Row][Column].isLineComplete()) {
                        CartasDelTablero[Row][Column].FreeCard();
                        SelectedCard = "IDK";
                        ChangeTurn("");
                        setBorders(null, "");

                        FreeMode = false;
                        CardsPlayed--;

                    } else {
                        JOptionPane.showMessageDialog(this, "¡Esta ficha conforma una linea!\nIntente tomar otro espacio", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "¡Esta carta no cuenta con una ficha!\nIntente tomar otro espacio", "Tomar espacio", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "¡No puede ocupar este tipo de espacios!", "Zona neutra", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        Pause = false;
    }

    private boolean CheckEvent(String Selected) {        
        if (!Tryed[0] && Selected.contains(Main_Sequence.ActualSetting.getBloquearEspacio()) || BlockMode) {
            
            Tryed[0] = true;
            BlockCard();
            return true;
            
        } else if (!Tryed[1] && Selected.contains(Main_Sequence.ActualSetting.getCambiarCarta())) {
            
            Tryed[1] = true;
            ShuffleCards();
            return true;
            
        } else if (!Tryed[2] && Selected.contains(Main_Sequence.ActualSetting.getCambiarFichas())) {
            
            Tryed[2] = true;
            ChangeTokens();
            return true;
            
        } else if (!Tryed[3] && Selected.contains(Main_Sequence.ActualSetting.getElegirCarta())) {
            
            Tryed[3] = true;
            if (Randy.nextInt(50) == 1){
                SelectCard = true;
                Player[Turn].SelectCard(Main_Sequence.ActualSetting.getCardsUrl(), new ImageIcon(getIconImage()), CartaJugada, CartasDelTablero[0][0].getWidth(), CartasDelTablero[0][0].getHeight());
            }
            return true;
            
        } else if (!Tryed[4] && Selected.contains(Main_Sequence.ActualSetting.getEliminarCarta())) {
            
            Tryed[4] = true;
            if (Randy.nextInt(10) == 1){
                DeleteDeck();
            } else System.out.println("\t Mejor suerte la proxima");
            return true;
            
        } else if (!Tryed[5] && Selected.contains(Main_Sequence.ActualSetting.getEliminarFichas())) {
            
            Tryed[5] = true;
            DeleteTokens();
            return true;
            
        } else if (!Tryed[6] && (Selected.contains(Main_Sequence.ActualSetting.getLiberarEspacio()) || FreeMode) && CardsPlayed > 1) {
            
            Tryed[6] = true;
            FreeCard();
            return true;
            
        } else if (!Tryed[7] && Selected.contains(Main_Sequence.ActualSetting.getOcuparEspacio())) {
            
            Tryed[7] = true;
            TakeRandomCard();
            return true;
            
        } else if (SelectedCard.contains("J")){
            for (boolean Try : Tryed){
                if (Try) return false;
            }
            JOptionPane.showMessageDialog(this, "La carta: "+SelectedCard+" no cuenta con efecto alguno, sera cambiada por una nueva", "Sin efecto", JOptionPane.INFORMATION_MESSAGE);
            Player[Turn].PlayCard(CartaJugada);
            PlayerCards();
        }
        return false;
    }
    
    private void restartTries(){
        for (int i = 0; i < 8; i++){
            Tryed[i] = false;
        }
    }
    
    private void ChangeTokens(){
        if (Randy.nextInt(10) == 5){
            ArrayList<String> Usernames = new ArrayList();
            for (Player Jugadores : Player){
                if (Jugadores != null){
                    Usernames.add(Jugadores.getPlayer().getUsername());
                }
            }

            try {
                Object Selected = JOptionPane.showInputDialog(this, "Por favor seleccione al jugador con el que desea cambiar de fichas: ", "Cambiar fichas", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getIconImage()), Usernames.toArray(), 0);
                if (!Selected.toString().isBlank()){
                    for (Player Jugadores : Player){
                        if (Jugadores.getPlayer().getUsername().equals(Selected)){
                            int temp = Player[Turn].getCoins();
                            Player[Turn].setcoins(Jugadores.getCoins());
                            Jugadores.setcoins(temp);
                            JOptionPane.showMessageDialog(this, "Se han cambiado la cantidad de fichas con " + Selected + " exitosamente!", "Cambiar fichas", JOptionPane.INFORMATION_MESSAGE);
                            return ;
                        }
                    }
                }
            } catch (Exception Ex){}
        }
    }
    
    private void DeleteTokens(){
        int DeleteFrom;
        do {
            DeleteFrom = Randy.nextInt(Player.length);
            if (Player[DeleteFrom] == null) DeleteFrom = Turn;
        } while (Player[Turn].getTeam() == Player[DeleteFrom].getTeam());
        int Delete = Randy.nextInt(5);
        
        
        Player[DeleteFrom].RemoveCoin(Randy.nextInt(Delete));
        JOptionPane.showMessageDialog(this, "¡Se han eliminado " + Delete + " fichas de " + Player[DeleteFrom].getPlayer().getUsername() + "!", "Eliminar fichas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void ShuffleCards(){
        ArrayList<String> Shuffle = new ArrayList();
        for (Player Jugador : Player){
            if (Jugador != null){
                for (int loop = 0; loop < Jugador.getDeckSize(); loop++){
                    Shuffle.add(Jugador.getCard(loop));
                }
                Jugador.ClearDeck();
            }
        }
        
        for (Player Jugador : Player){
            if (Jugador != null){
                for (int loop = 0; loop < Jugador.getDeckSize(); loop++){
                    String CartaSeleccionada = Shuffle.get(Randy.nextInt(Shuffle.size()));
                    Jugador.InsertCard(loop, CartaSeleccionada);
                    Shuffle.remove(CartaSeleccionada);
                }
            }
        }
        
        JOptionPane.showMessageDialog(this, "Se han cambiada las cartas entre todos los jugadores!", "Cambiar cartas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void DeleteDeck(){
        try {
            ArrayList<String> Jugadores = new ArrayList();
            for (Player Jugador : Player){
                if (Jugador != null){
                    Jugadores.add(Jugador.getPlayer().getUsername());
                }
            }
            
            Object Jugador = JOptionPane.showInputDialog(this, 
                    "Eliga el jugador al que desea eliminar la baraja: ", 
                    "Eliminar carta",
                    JOptionPane.QUESTION_MESSAGE, 
                    new ImageIcon(this.getIconImage()),
                    Jugadores.toArray(),
                    0);

            for (Player Gioca : Player){
                if (Gioca.getPlayer().getUsername().equals(Jugador.toString())){
                    Gioca.startDeck();
                }
            }
            
            JOptionPane.showMessageDialog(this, "Se ha reiniciado la baraja de " + Jugador.toString(), "Reiniciar deck", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getIconImage()));
        } catch (Exception Ex){
            Ex.printStackTrace();
        }
    }
    
    private void BlockCard() {
        for (int X = 0; X < 10; X++) {
            for (int Y = 0; Y < 10; Y++) {
                if (!CartasDelTablero[X][Y].isCardTaken() && !CartasDelTablero[X][Y].getCard().equals("0F")) {
                    CartasDelTablero[X][Y].setBorder(BorderFactory.createLineBorder(
                            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                        default ->
                            Color.RED;
                        case "Estilo retro" ->
                            Color.YELLOW;
                    },
                            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                        default ->
                            4;
                        case "Estilo retro" ->
                            2;
                    }));
                }
            }
        }

        BlockMode = true;
        JOptionPane.showMessageDialog(this, "Seleccione la carta que desea bloquear (debera estar libre)", "Bloquear carta", JOptionPane.INFORMATION_MESSAGE);
    }

    private void FreeCard() {
        for (int X = 0; X < 10; X++) {
            for (int Y = 0; Y < 10; Y++) {
                if (CartasDelTablero[X][Y].isCardTaken()) {
                    CartasDelTablero[X][Y].setBorder(BorderFactory.createLineBorder(
                    switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                        default ->
                            Color.RED;
                        case "Estilo retro" ->
                            Color.YELLOW;
                    },
                            switch (Main_Sequence.ActualSetting.getCardsStyle()) {
                        default ->
                            4;
                        case "Estilo retro" ->
                            2;
                    }));
                }
            }
        }

        FreeMode = true;
        JOptionPane.showMessageDialog(this, "Seleccione un espacio que desea liberar", "Liberar espacio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void TakeRandomCard() {
        if (Randy.nextInt(5) == 0) {
            try {
                int[] Row = new int[3];
                int[] Col = new int[3];
                int pos = 0;
                while (pos < Row.length) {
                    Row[pos] = Randy.nextInt(10);
                    Col[pos] = Randy.nextInt(10);

                    if (!CartasDelTablero[Row[pos]][Col[pos]].getCard().equals("0F")) {
                        pos++;
                    }
                }
                int Elegido;
                String[] Selector = {CartasDelTablero[Row[0]][Col[0]].getCard(), CartasDelTablero[Row[1]][Col[1]].getCard(), CartasDelTablero[Row[2]][Col[2]].getCard()};
                ImageIcon Boton1 = ScaledImage(new File(Main_Sequence.ActualSetting.getCardsUrl() + Selector[0] + ".png").getAbsolutePath(), CartasDelTablero[Row[0]][Col[0]].getWidth(), CartasDelTablero[Row[0]][Col[0]].getHeight());
                ImageIcon Boton2 = ScaledImage(new File(Main_Sequence.ActualSetting.getCardsUrl() + Selector[1] + ".png").getAbsolutePath(), CartasDelTablero[Row[1]][Col[1]].getWidth(), CartasDelTablero[Row[1]][Col[1]].getHeight());
                ImageIcon Boton3 = ScaledImage(new File(Main_Sequence.ActualSetting.getCardsUrl() + Selector[2] + ".png").getAbsolutePath(), CartasDelTablero[Row[2]][Col[2]].getWidth(), CartasDelTablero[Row[2]][Col[2]].getHeight());
                Elegido = JOptionPane.showOptionDialog(this,
                        "Seleccione una de las siguientes cartas para reclamarla: ",
                        "Espacio extra",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(getIconImage()),
                        new ImageIcon[]{Boton1, Boton2, Boton3},
                        0);
                File CartaPNG = new File(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getPlayer().getFicha());
                ImageIcon neoIcon = ScaledImage(CartaPNG.getAbsolutePath(), CartasDelTablero[Row[Elegido]][Col[Elegido]].getWidth(), CartasDelTablero[Row[Elegido]][Col[Elegido]].getHeight());

                CartasDelTablero[Row[Elegido]][Col[Elegido]].TakeCard(neoIcon, Player[Turn].getPlayer().getUsername(), Player[Turn].getTeam());
            } catch (Exception Ex) {}
        }
    }

    private void CheckSequence() {
        for (int X = 0; X < 10; X++) {
            
            for (int Y = 0; Y < 10; Y++) {
            
                if (CheckHorizontal(CartasDelTablero[X][Y].getTeamWhoTakeIt(), X, Y)) {
                
                    JOptionPane.showMessageDialog(this, "Se ha formado un sequence");
                    Player[Turn].AddPuntos();
                    
                } else if (CheckVertical(CartasDelTablero[X][Y].getTeamWhoTakeIt(), X, Y)) {
                    
                    JOptionPane.showMessageDialog(this, "Se ha formado un sequence");
                    Player[Turn].AddPuntos();
                
                } else if (CheckDiagonalFront(CartasDelTablero[X][Y].getTeamWhoTakeIt(), X, Y)) {
                
                    JOptionPane.showMessageDialog(this, "Se ha formado un sequence");
                    Player[Turn].AddPuntos();
                
                } else if (CheckDiagonalBack(CartasDelTablero[X][Y].getTeamWhoTakeIt(), X, Y)) {
                
                    JOptionPane.showMessageDialog(this, "Se ha formado un sequence");
                    Player[Turn].AddPuntos();
                
                }

                CartasDelTablero[X][Y].isCardBlock();

            }

        }
    }

    private boolean CheckDiagonalBack(int Team, int X, int Y) {
        try {
            for (int i = 0; i < 5; i++){
                if (!CartasDelTablero[X+i][Y-i].isCardTaken() || CartasDelTablero[X+i][Y-i].getTeamWhoTakeIt() != Team){
                    if (!CartasDelTablero[X+i][Y-i].getCard().equals("0F")){
                        return false;
                    }
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (CartasDelTablero[X+i][Y-i].isLineComplete()){
                    return false;
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (!CartasDelTablero[X+i][Y-i].getCard().equals("0F")){
                    CartasDelTablero[X+i][Y-i].takeLine();
                }
            }
            
        } catch (Exception Ex){
        return false;
        }
        return true;
    }
    
    private boolean CheckDiagonalFront(int Team, int X, int Y) {
        try {
            for (int i = 0; i < 5; i++){
                if (!CartasDelTablero[X+i][Y+i].isCardTaken() || CartasDelTablero[X+i][Y+i].getTeamWhoTakeIt() != Team){
                    if (!CartasDelTablero[X+i][Y+i].getCard().equals("0F")){
                        return false;
                    }
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (CartasDelTablero[X+i][Y+i].isLineComplete()){
                    return false;
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (!CartasDelTablero[X+i][Y+i].getCard().equals("0F")){
                    CartasDelTablero[X+i][Y+i].takeLine();
                }
            }
            
        } catch (Exception Ex){
        return false;
        }
        return true;
    }
    
    private boolean CheckVertical(int Team, int X, int Y) {
        try {
            for (int i = 0; i < 5; i++){
                if (!CartasDelTablero[X][Y+i].isCardTaken() || CartasDelTablero[X][Y+i].getTeamWhoTakeIt() != Team){
                    if (!CartasDelTablero[X][Y+i].getCard().equals("0F")){
                        return false;
                    }
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (CartasDelTablero[X][Y+i].isLineComplete()){
                    return false;
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (!CartasDelTablero[X][Y+i].getCard().equals("0F")){
                    CartasDelTablero[X][Y+i].takeLine();
                }
            }
            
        } catch (Exception Ex){
        return false;
        }
        return true;
    }
    
    private boolean CheckHorizontal(int Team, int X, int Y) {
        try {
            for (int i = 0; i < 5; i++){
                if (!CartasDelTablero[X+i][Y].isCardTaken() || CartasDelTablero[X+i][Y].getTeamWhoTakeIt() != Team){
                    if (!CartasDelTablero[X+i][Y].getCard().equals("0F")){
                        return false;
                    }
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (CartasDelTablero[X+i][Y].isLineComplete()){
                    return false;
                }
            }
            
            for (int i = 0; i < 5; i++) {
                if (!CartasDelTablero[X+i][Y].getCard().equals("0F")){
                    CartasDelTablero[X+i][Y].takeLine();
                }
            }
            
        } catch (Exception Ex){
        return false;
        }
        return true;
    }

    private void setBorders(Border Borde, String CardSearch) {
        boolean Found = false;
        for (int Fila = 0; Fila < 10; Fila++) {
            for (int Columna = 0; Columna < 10; Columna++) {
                CartasDelTablero[Fila][Columna].setBorder(null);
                if (CartasDelTablero[Fila][Columna].getCard().equals(CardSearch) && !CartasDelTablero[Fila][Columna].isCardTaken()) {
                    CartasDelTablero[Fila][Columna].setBorder(Borde);
                    Found = true;
                }
            }
        }
        if (!Found && !CardSearch.isBlank() && !CardSearch.contains("J")){
            try {
                if (JOptionPane.showConfirmDialog(this, "¡No se han encontrado cartas de: " + CardSearch + "!\n¿Desea cambiarla por una nueva?", "Cambio de carta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getIconImage())) == JOptionPane.YES_OPTION){
                    Player[Turn].PlayCard(CartaJugada);
                    PlayerCards();
                }
            } catch (Exception Ex){}
        }
    }
    
    private void PlayerCards() {
        try {
            if (Card1.isVisible()){
                Card1.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(0) + ".png", Card1.getWidth(), Card1.getHeight()));
                Card1MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(0) + ".png", Card1MI.getWidth(), Card1MI.getHeight()));
            }
            if (Card2.isVisible()){
                Card2.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(1) + ".png", Card2.getWidth(), Card2.getHeight()));
                Card2MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(1) + ".png", Card2MI.getWidth(), Card2MI.getHeight()));
            }
            if (Card3.isVisible()){
                Card3.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(2) + ".png", Card3.getWidth(), Card3.getHeight()));
                Card3MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(2) + ".png", Card3MI.getWidth(), Card3MI.getHeight()));
            }
            if (Card4.isVisible()){
                Card4.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(3) + ".png", Card4.getWidth(), Card4.getHeight()));
                Card4MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(3) + ".png", Card4MI.getWidth(), Card4MI.getHeight()));
            }
            if (Card5.isVisible()){
                Card5.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(4) + ".png", Card5.getWidth(), Card5.getHeight()));
                Card5MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(4) + ".png", Card5MI.getWidth(), Card5MI.getHeight()));
            }
            if (Card6.isVisible()){
                Card6.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(5) + ".png", Card6.getWidth(), Card6.getHeight()));
                Card6MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(5) + ".png", Card6MI.getWidth(), Card6MI.getHeight()));
            }
            if (Card7.isVisible()){
                Card7.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(6) + ".png", Card7.getWidth(), Card7.getHeight()));
                Card7MI.setIcon(ScaledImage(Main_Sequence.ActualSetting.getCardsUrl() + Player[Turn].getCard(6) + ".png", Card7MI.getWidth(), Card7MI.getHeight()));
            }
        } catch (Exception Ex) {}
    }

    @Override
    public void run() {
        Min = 1;
        Sec = 59;
        MiliSec = 59;
        float LastFrame = 0;
        do {
            this.requestFocus();
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
                ChangeTurn("¡" + Player[Turn].getPlayer().getUsername() + "se ha quedado sin tiempo!\n");
            } else {
                Min--;
                Sec = 59;
            }
        }
        Timer.setText(Min + ":" + Sec + ":" + MiliSec);
    }

    private void ChangeTurn(String ExtraInfo) {
        Turn = (Turn + 1 >= Players) ? 0 : Turn + 1;
        JOptionPane.showMessageDialog(this, ExtraInfo + "Turno de: " + Player[Turn].getPlayer().getUsername(), "Cambio de turno", JOptionPane.INFORMATION_MESSAGE);
        Min = 1;
        Sec = 59;
        MiliSec = 59;
        PlayerCards();
        Image scaledCard = Player[Turn].getPlayer().getPlayerIcon().getImage().getScaledInstance(PlayerIcon.getWidth() / 2, PlayerIcon.getHeight() / 2, Image.SCALE_SMOOTH);

        restartTries();

        try {
            
            TeamReport.setText(ChangeInfoBox(1, ""));

        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PlayerIcon.setIcon(new ImageIcon(scaledCard));
        PlayerIcon.setText(Player[Turn].getPlayer().getUsername());
        Pause = false;
    }

    private String ChangeInfoBox(int Team, String Data) throws IOException{
        Pause = true;

        int Puntos = 0;
        if (Team <= 
                switch (Main_Sequence.ActualSetting.getPlayersCant()) {
                    case 3 -> 3;
                    case 6 -> 3;
                    default -> 2;
                }
                ){
            for (Player Jugador : Player) {
                if (Jugador != null) {
                    if (Jugador.getTeam() == Team) {
                        Puntos += Jugador.getPuntos();
                    }
                }
            }
            if (Puntos >= 2){
                JOptionPane.showMessageDialog(this, "El equipo #"+Team+" ha ganado la partida", "PARTIDA GANADA", JOptionPane.INFORMATION_MESSAGE);
                SaveMatchData(Team);

                new PantallaPrincipal().setVisible(true);
                dispose();
            }
            Data = Data + "El equipo #" + Team + " cuenta con " + Puntos + " Pts\n";
            return ChangeInfoBox(Team + 1, Data);
        }
        return Data;
    }
    
    private String getWinnerTeam(int Team){
        String Integrantes = "";
        for (Player Jugador : Player){
            if (Jugador != null){
                if (Jugador.getTeam() == Team){
                    Integrantes += Jugador.getPlayer().getUsername() + "\n";
                }
            }
        }
        return Integrantes;
    }
    
    private void SaveMatchData(int Team) throws IOException{
        String WinnerTeam = getWinnerTeam(Team);
        String Fecha = Calendar.getInstance().getTime().toString();
        
        for (Player Jugador : Player){
            if (Jugador != null){
                if (Jugador.getTeam() == Team){
                    Jugador.getPlayer().MatchWon();
                }
                Jugador.getPlayer().AddMatchData("\t" + Fecha + "\nLa partida fue ganada por el equipo #"+ Team +" conformado por : \n" + WinnerTeam);
                Jugador.getPlayer().SaveData(Jugador.getPlayer().getUsername());
            }
        }
        Main_Sequence.gestorUsuarios = new GestorUsuarios();
    }
    
    // -- SWING ELEMENTS --
    private JCard[][] CartasDelTablero;
    // -- SWING ELEMENTS --
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
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
    private javax.swing.JLabel Card1MI;
    private javax.swing.JLabel Card2;
    private javax.swing.JLabel Card2MI;
    private javax.swing.JLabel Card3;
    private javax.swing.JLabel Card3MI;
    private javax.swing.JLabel Card4;
    private javax.swing.JLabel Card4MI;
    private javax.swing.JLabel Card5;
    private javax.swing.JLabel Card5MI;
    private javax.swing.JLabel Card6;
    private javax.swing.JLabel Card6MI;
    private javax.swing.JLabel Card7;
    private javax.swing.JLabel Card7MI;
    private javax.swing.JLabel CardDeckIcon;
    private javax.swing.JButton DebugModeBTN;
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
    private javax.swing.JPanel TeamPanel;
    private javax.swing.JTextArea TeamReport;
    private javax.swing.JLabel Timer;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

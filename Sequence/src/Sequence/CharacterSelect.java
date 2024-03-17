/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sequence;

import GameBoard.Tablero;
import Logic.UI_Elements.Tokens;
import Logic.Users.Player;
import Logic.Users.Settings;
import Logic.Users.User;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class CharacterSelect extends javax.swing.JFrame {
    private final ArrayList<Player> Jugadores;
    private final ArrayList<String> Usernames;
    private final ArrayList<Tokens> Fichas;
    private int PlayersXTeam;
    
    /**
     * Creates new form CharacterSelect
     */
    public CharacterSelect() throws IOException, ClassNotFoundException {
        Usernames = new ArrayList();
        Jugadores = new ArrayList();
        Fichas = new ArrayList();
        
        initComponents();
        
        switch (Main_Sequence.ActualSetting.getPlayersCant()){
            case 2 ->{
                PlayersXTeam = 1;
                ThirdTeam.setVisible(false);
            }
            case 4 -> {
                PlayersXTeam =  2;
                ThirdTeam.setVisible(false);
            }
            case 6 -> {
                PlayersXTeam =  2;
                ThirdTeam.setVisible(true);
            }
            case 8 -> {
                PlayersXTeam = 4;
                ThirdTeam.setVisible(false);
            }
            default -> {
                PlayersXTeam =  1;
                ThirdTeam.setVisible(true);
            }
        }
        
        setLocationRelativeTo(null);
        PlayersXTeamTXT.setText("Jugadores por equipo: " + PlayersXTeam);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Elementos/GameIcon.png")).getImage());
        
        setUsuariosBox();
        setConfigurationBox();
        setFichas();
    }
    
    private void setFichas(){
        for (int i = 0; i <= 8; i++){
            try {
                File CartaPNG = new File(Settings.LoadFile(SettingsBox.getSelectedItem().toString()).getCardsUrl() + "Tokens"+i+".png");
                Fichas.add(new Tokens(CartaPNG.getAbsolutePath(), "Tokens"+i+".png", ScaledImage(CartaPNG.getAbsolutePath(),  20, 20)));
            } catch (Exception Ex){}
        }
        ArrayList<ImageIcon> Ficha = new ArrayList();
        for (Tokens Token : this.Fichas){
            if (!Token.getToken().equals(Main_Sequence.gestorUsuarios.getUserLog().getFicha())){
                Ficha.add(Token.getFicha());
            }
        }
        
        Ficha.remove(0);
        
        FichasEquipo2.setModel(new javax.swing.DefaultComboBoxModel(Ficha.toArray()));
        FichasEquipo3.setModel(new javax.swing.DefaultComboBoxModel(Ficha.toArray()));
    }
    
    private ImageIcon ScaledImage(String Url, int Width, int Height) {
        ImageIcon neoIcon = new ImageIcon(Url);
        Image scaledCard = neoIcon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        neoIcon = new ImageIcon(scaledCard);
        return neoIcon;
    }
    
    private void setUsuariosBox(){
        for (User Usuario : Main_Sequence.gestorUsuarios.getUsuariosLista()){
            if (!Usuario.getUsername().equals(Main_Sequence.gestorUsuarios.getUserLog().getUsername())){
                Usernames.add(Usuario.getUsername());
            } else {
                try {
                    Player Jugador = new Player(User.LoadFile(Usuario.getUsername()),Main_Sequence.ActualSetting.getCardsCant(),1);
                    Jugadores.add(Jugador);
                    Team1Box.setText(Team1Box.getText() + Usuario.getUsername() + "\n");
                } catch (Exception Ex){}
            }
        }
        
        JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));
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
        
        switch (Ajustes.getPlayersCant()){
            case 2 ->{
                PlayersXTeam = 1;
                ThirdTeam.setVisible(false);
            }
            case 4 -> {
                PlayersXTeam =  2;
                ThirdTeam.setVisible(false);
            }
            case 6 -> {
                PlayersXTeam =  2;
                ThirdTeam.setVisible(true);
            }
            case 8 -> {
                PlayersXTeam = 4;
                ThirdTeam.setVisible(false);
            }
            default -> {
                PlayersXTeam =  1;
                ThirdTeam.setVisible(true);
            }
        }
        
        PlayersXTeamTXT.setText("Jugadores por equipo: " + PlayersXTeam);
        
        System.out.println(Data);
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
        jSeparator1 = new javax.swing.JSeparator();
        AddPlayersTXT = new javax.swing.JLabel();
        JugadoresDisponibles = new javax.swing.JComboBox();
        UserSelectTXT = new javax.swing.JLabel();
        Team1TXT = new javax.swing.JLabel();
        Team2TXT = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Team1Box = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Team2Box = new javax.swing.JTextArea();
        RemoveFromT1 = new javax.swing.JButton();
        AddPlayerToT1 = new javax.swing.JButton();
        RemoveFromT2 = new javax.swing.JButton();
        AddPlayerToT2 = new javax.swing.JButton();
        PlayersXTeamTXT = new javax.swing.JLabel();
        ThirdTeam = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Team3Box = new javax.swing.JTextArea();
        Team3TXT = new javax.swing.JLabel();
        RemoveFromT3 = new javax.swing.JButton();
        AddPlayerToT3 = new javax.swing.JButton();
        FichasEquipo3 = new javax.swing.JComboBox();
        FichasEquipo2 = new javax.swing.JComboBox();

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
        SettingsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsBoxActionPerformed(evt);
            }
        });
        jPanel2.add(SettingsBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, -1));

        ConfigTXT.setText("Configuracion deseada:");
        jPanel2.add(ConfigTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 390));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 170, 390));

        AddPlayersTXT.setText("> ¿Como añadir jugadores a equipos?");
        AddPlayersTXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddPlayersTXTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPlayersTXTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPlayersTXTMouseExited(evt);
            }
        });
        jPanel1.add(AddPlayersTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 355, 230, -1));

        JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(JugadoresDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 220, -1));

        UserSelectTXT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UserSelectTXT.setText("Selector de jugadores:");
        jPanel1.add(UserSelectTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 180, 30));

        Team1TXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team1TXT.setText("Equipo #1");
        jPanel1.add(Team1TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, -1));

        Team2TXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team2TXT.setText("Equipo #2");
        jPanel1.add(Team2TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 110, -1));

        Team1Box.setEditable(false);
        Team1Box.setColumns(20);
        Team1Box.setLineWrap(true);
        Team1Box.setRows(5);
        Team1Box.setWrapStyleWord(true);
        Team1Box.setFocusable(false);
        jScrollPane3.setViewportView(Team1Box);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 140));

        Team2Box.setEditable(false);
        Team2Box.setColumns(20);
        Team2Box.setLineWrap(true);
        Team2Box.setRows(5);
        Team2Box.setWrapStyleWord(true);
        Team2Box.setFocusable(false);
        jScrollPane4.setViewportView(Team2Box);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 110, 110));

        RemoveFromT1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        RemoveFromT1.setText("Retirar jugador");
        RemoveFromT1.setFocusable(false);
        RemoveFromT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFromT1ActionPerformed(evt);
            }
        });
        jPanel1.add(RemoveFromT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 40));

        AddPlayerToT1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AddPlayerToT1.setText("Añadir jugador");
        AddPlayerToT1.setFocusable(false);
        AddPlayerToT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPlayerToT1ActionPerformed(evt);
            }
        });
        jPanel1.add(AddPlayerToT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 110, 40));

        RemoveFromT2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        RemoveFromT2.setText("Retirar jugador");
        RemoveFromT2.setFocusable(false);
        RemoveFromT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFromT2ActionPerformed(evt);
            }
        });
        jPanel1.add(RemoveFromT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 110, 40));

        AddPlayerToT2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AddPlayerToT2.setText("Añadir jugador");
        AddPlayerToT2.setFocusable(false);
        AddPlayerToT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPlayerToT2ActionPerformed(evt);
            }
        });
        jPanel1.add(AddPlayerToT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 110, 40));

        PlayersXTeamTXT.setText("Jugadores por equipo: ");
        jPanel1.add(PlayersXTeamTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        ThirdTeam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Team3Box.setEditable(false);
        Team3Box.setColumns(20);
        Team3Box.setLineWrap(true);
        Team3Box.setRows(5);
        Team3Box.setWrapStyleWord(true);
        Team3Box.setFocusable(false);
        jScrollPane2.setViewportView(Team3Box);

        ThirdTeam.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 110));

        Team3TXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Team3TXT.setText("Equipo #3");
        ThirdTeam.add(Team3TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, -1));

        RemoveFromT3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        RemoveFromT3.setText("Retirar jugador");
        RemoveFromT3.setFocusable(false);
        RemoveFromT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFromT3ActionPerformed(evt);
            }
        });
        ThirdTeam.add(RemoveFromT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 40));

        AddPlayerToT3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        AddPlayerToT3.setText("Añadir jugador");
        AddPlayerToT3.setFocusable(false);
        AddPlayerToT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPlayerToT3ActionPerformed(evt);
            }
        });
        ThirdTeam.add(AddPlayerToT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 40));

        ThirdTeam.add(FichasEquipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 25));

        jPanel1.add(ThirdTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 130, 270));

        jPanel1.add(FichasEquipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 110, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarPartidaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarPartidaBTNActionPerformed
        try {
            if (ThirdTeam.isVisible() && FichasEquipo2.getSelectedIndex() == FichasEquipo3.getSelectedIndex()){
                JOptionPane.showMessageDialog(this, "¡Dos equipos no pueden tener la misma ficha!", "Fichas", JOptionPane.WARNING_MESSAGE);
                return ;
            }
            if (Settings.LoadFile(SettingsBox.getSelectedItem().toString()).getPlayersCant() == Jugadores.size()){
                
                setPlayersIcons();
                
                Main_Sequence.ActualSetting = Settings.LoadFile(SettingsBox.getSelectedItem().toString());
                new Tablero(Jugadores, Main_Sequence.ActualSetting.getPlayersCant()).setVisible(true);
                dispose();

            } else JOptionPane.showMessageDialog(this, "¡No puede empezar la partida sin antes llenar los equipos!", "ERROR", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }//GEN-LAST:event_IniciarPartidaBTNActionPerformed
    
    private void setPlayersIcons(){
        String Equipo2 = getToken(2);
        String Equipo3 = getToken(3);
        for (int i = 0; i < Jugadores.size(); i++){
            switch (Jugadores.get(i).getTeam()){
                case 1 -> Jugadores.get(i).getPlayer().setficha(Main_Sequence.gestorUsuarios.getUserLog().getFicha());
                case 2 -> Jugadores.get(i).getPlayer().setficha(Equipo2);
                case 3 -> Jugadores.get(i).getPlayer().setficha(Equipo3);
            }
        }
    }
    
    private String getToken(int Team){
        for (Tokens Ficha : this.Fichas){
            if (Ficha.getFicha() == ((Team == 2)?FichasEquipo2.getSelectedItem():FichasEquipo3.getSelectedItem())){
                return Ficha.getToken();
            }
        }
        return "";
    }
    
    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void AddPlayersTXTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPlayersTXTMouseEntered
        ((javax.swing.JLabel) evt.getSource()).setForeground(Color.RED);
    }//GEN-LAST:event_AddPlayersTXTMouseEntered

    private void AddPlayersTXTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPlayersTXTMouseExited
        ((javax.swing.JLabel) evt.getSource()).setForeground(Color.BLACK);
    }//GEN-LAST:event_AddPlayersTXTMouseExited

    private void AddPlayersTXTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPlayersTXTMouseClicked
        JOptionPane.showMessageDialog(this, "Para añadir jugadores a los equipos debe:\n1. Seleccione el jugador que desea desde el \"SELECTOR DE JUGADORES\".\n2. Presione el boton de \"AÑADIR JUGADOR\" del equipo que desea y este se agregara de forma automatica.\n\nSi desea eliminar a un jugador de un equipo simplemente presione el boton de \"QUITAR JUGADOR\" y\nseleccione el jugador que desea retirar.", "Como añadir jugadores", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AddPlayersTXTMouseClicked

    private void AddPlayerToT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPlayerToT1ActionPerformed
        if (Usernames.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay mas jugadores disponibles", "Sin jugadores", JOptionPane.INFORMATION_MESSAGE);
            return ;
        }
        
        int InTeamPlayers = 0;
        for (Player Players : Jugadores){
            if (Players.getTeam() == 1){
                InTeamPlayers++;
            }
        }
        
        if (InTeamPlayers >= PlayersXTeam){
            JOptionPane.showMessageDialog(this, "¡El equipo #1 no cuenta con mas espacios disponibles!", "Equipo lleno", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        
        Object JugadorSeleccionado = JugadoresDisponibles.getSelectedItem();
        for (int i = 0; i < Usernames.size(); i++){
            if (Usernames.get(i).equals(JugadorSeleccionado.toString())){
                try {
                    Usernames.remove(i);
                    Player Jugador = new Player(User.LoadFile(JugadorSeleccionado.toString()),Main_Sequence.ActualSetting.getCardsCant(),1);
                    if (!Jugador.getPlayer().getUsername().equals(Main_Sequence.gestorUsuarios.getUserLog().getUsername())){
                        
                    }
                    Jugadores.add(Jugador);
                    Team1Box.setText(Team1Box.getText() + JugadorSeleccionado.toString() + "\n");
                } catch (Exception Ex){ 
                    return ;
                }
            }
        }
        
        JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));
    }//GEN-LAST:event_AddPlayerToT1ActionPerformed

    private void RemoveFromT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFromT1ActionPerformed
        ArrayList<String> Usuarios = new ArrayList();
        for (Player Players : Jugadores){
            if (Players.getTeam() == 1){
                Usuarios.add(Players.getPlayer().getUsername());
            }
        }
        if (!Usuarios.isEmpty()){
            try {
                Object Usuario = JOptionPane.showInputDialog(this, "Por favor eliga que jugador desea sacar del equipo: ", "Quitar jugador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getIconImage()), Usuarios.toArray(), 0);
                if (!Usuario.toString().isBlank()){
                    Usernames.add(Usuario.toString());
                    for (Player Players : Jugadores){
                        if (Players.getPlayer().getUsername().equals(Usuario.toString())){
                            Jugadores.remove(Players);
                            break ;
                        }
                    }

                    String Equipo = "";
                    for (String Jugador : Team1Box.getText().split("[\n]")){
                        if (!Jugador.equals(Usuario.toString())){
                            Equipo += Jugador + "\n";
                        }
                    }

                    Team1Box.setText(Equipo);
                    JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));

                }
            } catch (Exception Ex){            }
        }
    }//GEN-LAST:event_RemoveFromT1ActionPerformed

    private void AddPlayerToT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPlayerToT2ActionPerformed
        if (Usernames.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay mas jugadores disponibles", "Sin jugadores", JOptionPane.INFORMATION_MESSAGE);
            return ;
        }
        
        int InTeamPlayers = 0;
        for (Player Players : Jugadores){
            if (Players.getTeam() == 2){
                InTeamPlayers++;
            }
        }
        
        if (InTeamPlayers >= PlayersXTeam){
            JOptionPane.showMessageDialog(this, "¡El equipo #2 no cuenta con mas espacios disponibles!", "Equipo lleno", JOptionPane.WARNING_MESSAGE);
            return ;
        }

        
        Object JugadorSeleccionado = JugadoresDisponibles.getSelectedItem();
        for (int i = 0; i < Usernames.size(); i++){
            if (Usernames.get(i).equals(JugadorSeleccionado.toString())){
                try {
                    Usernames.remove(i);
                    Jugadores.add(new Player(User.LoadFile(JugadorSeleccionado.toString()),Main_Sequence.ActualSetting.getCardsCant(),2));
                    Team2Box.setText(Team2Box.getText() + JugadorSeleccionado.toString() + "\n");
                } catch (Exception Ex){ 
                    System.out.println("Cagaste :V");
                    return ;
                }
            }
        }
        
        JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));
    }//GEN-LAST:event_AddPlayerToT2ActionPerformed

    private void RemoveFromT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFromT2ActionPerformed
        ArrayList<String> Usuarios = new ArrayList();
        for (Player Players : Jugadores){
            if (Players.getTeam() == 2){
                Usuarios.add(Players.getPlayer().getUsername());
            }
        }
        if (!Usuarios.isEmpty()){
            try {
                Object Usuario = JOptionPane.showInputDialog(this, "Por favor eliga que jugador desea sacar del equipo: ", "Quitar jugador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getIconImage()), Usuarios.toArray(), 0);
                if (!Usuario.toString().isBlank()){
                    Usernames.add(Usuario.toString());
                    for (Player Players : Jugadores){
                        if (Players.getPlayer().getUsername().equals(Usuario.toString())){
                            Jugadores.remove(Players);
                            break ;
                        }
                    }

                    String Equipo = "";
                    for (String Jugador : Team2Box.getText().split("[\n]")){
                        if (!Jugador.equals(Usuario.toString())){
                            Equipo += Jugador + "\n";
                        }
                    }

                    Team2Box.setText(Equipo);
                    JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));
                }
            } catch (Exception Ex){
                Ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_RemoveFromT2ActionPerformed

    private void AddPlayerToT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPlayerToT3ActionPerformed
        if (Usernames.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay mas jugadores disponibles", "Sin jugadores", JOptionPane.INFORMATION_MESSAGE);
            return ;
        }
        
        int InTeamPlayers = 0;
        for (Player Players : Jugadores){
            if (Players.getTeam() == 3){
                InTeamPlayers++;
            }
        }
        
        if (InTeamPlayers >= PlayersXTeam){
            JOptionPane.showMessageDialog(this, "¡El equipo #3 no cuenta con mas espacios disponibles!", "Equipo lleno", JOptionPane.WARNING_MESSAGE);
            return ;
        }

        
        Object JugadorSeleccionado = JugadoresDisponibles.getSelectedItem();
        for (int i = 0; i < Usernames.size(); i++){
            if (Usernames.get(i).equals(JugadorSeleccionado.toString())){
                try {
                    Usernames.remove(i);
                    Jugadores.add(new Player(User.LoadFile(JugadorSeleccionado.toString()),Main_Sequence.ActualSetting.getCardsCant(),3));
                    Team3Box.setText(Team3Box.getText() + JugadorSeleccionado.toString() + "\n");
                } catch (Exception Ex){ 
                    System.out.println("Cagaste :V");
                    return ;
                }
            }
        }
        
        JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));
    }//GEN-LAST:event_AddPlayerToT3ActionPerformed

    private void RemoveFromT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFromT3ActionPerformed
        ArrayList<String> Usuarios = new ArrayList();
        for (Player Players : Jugadores){
            if (Players.getTeam() == 3){
                Usuarios.add(Players.getPlayer().getUsername());
            }
        }
        if (!Usuarios.isEmpty()){
            try {
                Object Usuario = JOptionPane.showInputDialog(this, "Por favor eliga que jugador desea sacar del equipo: ", "Quitar jugador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getIconImage()), Usuarios.toArray(), 0);
                if (!Usuario.toString().isBlank()){
                    Usernames.add(Usuario.toString());
                    for (Player Players : Jugadores){
                        if (Players.getPlayer().getUsername().equals(Usuario.toString())){
                            Jugadores.remove(Players);
                            break ;
                        }
                    }

                    String Equipo = "";
                    for (String Jugador : Team3Box.getText().split("[\n]")){
                        if (!Jugador.equals(Usuario.toString())){
                            Equipo += Jugador + "\n";
                        }
                    }

                    Team3Box.setText(Equipo);
                    JugadoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel(Usernames.toArray()));
                }
            } catch (Exception Ex){
                Ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_RemoveFromT3ActionPerformed

    private void SettingsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsBoxActionPerformed
        try {
            SettingsDataBox.setText(DisplaySettings());
            
            setFichas();
        } catch (IOException ex) {
            Logger.getLogger(CharacterSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CharacterSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SettingsBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPlayerToT1;
    private javax.swing.JButton AddPlayerToT2;
    private javax.swing.JButton AddPlayerToT3;
    private javax.swing.JLabel AddPlayersTXT;
    private javax.swing.JLabel ConfigTXT;
    private javax.swing.JComboBox FichasEquipo2;
    private javax.swing.JComboBox FichasEquipo3;
    private javax.swing.JButton IniciarPartidaBTN;
    private javax.swing.JComboBox JugadoresDisponibles;
    private javax.swing.JLabel PlayersXTeamTXT;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton RemoveFromT1;
    private javax.swing.JButton RemoveFromT2;
    private javax.swing.JButton RemoveFromT3;
    private javax.swing.JComboBox SettingsBox;
    private javax.swing.JTextArea SettingsDataBox;
    private javax.swing.JTextArea Team1Box;
    private javax.swing.JLabel Team1TXT;
    private javax.swing.JTextArea Team2Box;
    private javax.swing.JLabel Team2TXT;
    private javax.swing.JTextArea Team3Box;
    private javax.swing.JLabel Team3TXT;
    private javax.swing.JPanel ThirdTeam;
    private javax.swing.JLabel UserSelectTXT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

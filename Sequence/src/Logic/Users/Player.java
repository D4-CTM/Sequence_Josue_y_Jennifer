package Logic.Users;

import GameBoard.Deck;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {
    private final String[] Cards;
    private ImageIcon UserToken;
    private int Fichas, Puntos;
    private final User Jugador;
    private final int Team;
    
    public Player(User Jugador, int Cards, int Team){
        this.Cards = new String[Cards];
        this.Jugador = Jugador;
        this.Team = Team;
        Fichas = 48;
        Puntos = 0;
        startDeck();
    }
    
    public void setUserToken(ImageIcon Token){
        UserToken = Token;
    }
    
    public void AddPuntos(){
        Puntos++;
    }
    
    public int getPuntos(){
        return Puntos;
    }
    
    public ImageIcon getUserToken(){
        return UserToken;
    }
    
    public int getCoins(){
        return Fichas;
    }
    
    public void setcoins(int Coins){
        Fichas = Coins;
    }
    
    public void RemoveCoin(int cant){
        Fichas = Fichas - cant;
    }
    
    public final void ClearDeck(){
        for (int Carta = 0; Carta < Cards.length; Carta++){
            Cards[Carta] = "";
        }
    }
    
    public final void InsertCard(int Card, String Carta){
        Cards[Card] = Carta;
    }
    
    public final void startDeck(){
        for (int Carta = 0; Carta < Cards.length; Carta++){
            Cards[Carta] = "";
        }
        setDeck();
    }
    
    private void setDeck(){
        for (int Carta = 0; Carta < Cards.length; Carta++){
            if (Cards[Carta].isBlank()){
                Cards[Carta] = Deck.DrawCard("");
            }
        }
    }
    
    public int getDeckSize(){
        return Cards.length;
    }
    
    public final String getCard(int Carta){
        return Cards[Carta];
    }
    
    public final void PlayCard(int Carta){
        Cards[Carta] = "";
        Fichas--;
        setDeck();
    }
    
    public final void SelectCard(String CardStyleUrl, ImageIcon Icon, int PlayedCard, int Width, int Height){
        try {
            Cards[PlayedCard] = "";
            ArrayList<String> CartasRandom = new ArrayList();
            Random Randy = new Random();
            int pos = 0;
            while (pos < 3){
                int Drawed = Randy.nextInt(Deck.Deck.size());
                if (!CartasRandom.contains(Deck.Deck.get(Drawed))){
                    CartasRandom.add(Deck.Deck.get(Drawed));
                    pos++;
                }
            }
            for (int Carta = 0; Carta < Cards.length; Carta++){
                if (Cards[Carta].isBlank()){
                    ImageIcon Carta1 = ScaledImage(new File(CardStyleUrl + CartasRandom.get(0) + ".png").getAbsolutePath(), Width, Height);
                    ImageIcon Carta2 = ScaledImage(new File(CardStyleUrl + CartasRandom.get(1) + ".png").getAbsolutePath(), Width, Height);
                    ImageIcon Carta3 = ScaledImage(new File(CardStyleUrl + CartasRandom.get(2) + ".png").getAbsolutePath(), Width, Height);

                    int CartaSeleccionada = JOptionPane.showOptionDialog(null, 
                            "Eliga que carta desea tomar: ", 
                            "Elegir carta", 
                            JOptionPane.YES_NO_CANCEL_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, 
                            Icon, new ImageIcon[] {Carta1, Carta2, Carta3}, 
                            0);
                    System.out.println("Og card: "+Cards[Carta]);
                    Cards[Carta] = CartasRandom.get(CartaSeleccionada);
                    System.out.println("Neo card: "+Cards[Carta]);
                    Deck.Deck.remove(CartasRandom.get(CartaSeleccionada));
                }
            }
        } catch (Exception Ex){
            System.out.println("Cagaste");
        }
    }
    
    private ImageIcon ScaledImage(String Url, int Width, int Height) {
        ImageIcon neoIcon = new ImageIcon(Url);
        Image scaledCard = neoIcon.getImage().getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
        neoIcon = new ImageIcon(scaledCard);
        return neoIcon;
    }
    
    public final User getPlayer(){
        return Jugador;
    } 

    public final int getTeam(){
        return Team;
    }
    
}

package Logic.Users;

import GameBoard.Deck;

public class Player {
    private final String[] Cards;
    private final User Jugador;
    private final int Team;
    
    public Player(User Jugador, int Cards, int Team){
        this.Cards = new String[Cards];
        this.Jugador = Jugador;
        this.Team = Team;
        startDeck();
    }
    
    private void startDeck(){
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
    
    public final String getCard(int Carta){
        return Cards[Carta];
    }
    
    public final void PlayCard(int Carta){
        Cards[Carta] = "";
        setDeck();
    }
    
    public final User getPlayer(){
        return Jugador;
    } 

    public final int getTeam(){
        return Team;
    }
    
}

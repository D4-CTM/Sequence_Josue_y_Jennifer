package GameBoard;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static ArrayList<String> Deck = new ArrayList();
    private final static Random Randy = new Random();
    
    public static void setDeck(){
        for (int Card = 0; Card <= 12; Card++){
            if (Card != 1){
                Deck.add(String.valueOf(Card) + "S");
                Deck.add(String.valueOf(Card) + "C");
                Deck.add(String.valueOf(Card) + "H");
                Deck.add(String.valueOf(Card) + "D");
            }
        }
    }
    
    public static String DrawCard(String Card){
            if (!Deck.isEmpty()){
                Card = Deck.get(Randy.nextInt(Deck.size()));
                Deck.remove(Card);
            } else {
                setDeck();
                setDeck();
                return DrawCard("");
            }
        return Card;
    }
    
    public static void EmptyDeck(){
        Deck.clear();
    }
    
}

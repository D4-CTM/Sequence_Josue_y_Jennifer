package GameBoard;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static ArrayList<String> Deck = new ArrayList();
    private final static Random Randy = new Random();
    
    public static void setDeck(){
        Deck.add("AS");
        Deck.add("AT");
        Deck.add("AH");
        Deck.add("AD");
        Deck.add("J1S");
        Deck.add("J2T");
        Deck.add("J1H");
        Deck.add("J2D");

        for (int Card = 2; Card <= 10; Card++){
            Deck.add(String.valueOf(Card) + "S");
            Deck.add(String.valueOf(Card) + "T");
            Deck.add(String.valueOf(Card) + "H");
            Deck.add(String.valueOf(Card) + "D");
        }
        Deck.add("QS");
        Deck.add("QT");
        Deck.add("QH");
        Deck.add("QD");
        Deck.add("KS");
        Deck.add("KT");
        Deck.add("KH");
        Deck.add("KD");
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
    
    public static int getRemainingCards(){
        return Deck.size();
    }
    
}

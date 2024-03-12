package Logic.UI_Elements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author josue
 */
public class JCard extends javax.swing.JButton{
    private String Card, TakenBy, CardUrl;
    private final int Fila, Columna;
    private boolean Line, Taken;
    private int FromTeam, timer;
    
    public JCard(int Fila, int Columna){
        Ficha = new JLabel();
 
        setBackground(java.awt.Color.WHITE);
        this.Columna = Columna;
        this.Fila = Fila;
        Taken = false;
        Line = false;
        timer = 6;
    }
    
    public void setCard(String Card, String Style, ImageIcon Icon){
        if (Icon != null){
            setIcon(Icon);
            this.CardUrl = Style+Card+".png";
            Ficha.setBounds(getBounds());
            add(Ficha);
        }
        this.Card = Card;
    }
    
    public void takeLine(){
        Line = true;
    }
    
    public boolean TakeCard(ImageIcon Ficha, String TakenBy, int FromTeam){
        try {
            if (!Taken){
                this.Ficha.setIcon(Ficha);
                this.FromTeam = FromTeam;
                this.TakenBy = TakenBy;
                return Taken = true;
            }
        } catch (Exception Ex){}
        return false;
    }
    
    public void BlockCard(ImageIcon Ficha){
        this.Ficha.setVisible(true);
        this.Ficha.setIcon(Ficha);
        FromTeam = 99;
        Taken = true;
        timer--;
    }
    
    public void isCardBlock(){
        if (timer <= 0){
            FreeCard();
        } else if (timer != 6){
            timer--;
            return ;
        }
        timer = 6;
    }
    
    public void FreeCard(){
        Ficha.setVisible(false);
        this.Ficha.setIcon(null);
        Taken = false;
    }
    
    public boolean isLineComplete(){
        return Line;
    }
    
    public boolean isCardTaken(){
        return Taken;
    }
    
    public int getTeamWhoTakeIt(){
        return FromTeam;
    }
    
    public String getCardUrl(){
        return CardUrl;
    }
    
    public String getCard(){
        return Card;
    }
    
    public int getColumna(){
        return Columna;
    }
    
    public int getFila(){
        return Fila;
    }
    
    //-- Swing elements --
    private final JLabel Ficha;
    //-- Swing elements --
}
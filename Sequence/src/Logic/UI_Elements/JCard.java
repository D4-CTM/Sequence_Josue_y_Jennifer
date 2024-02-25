package Logic.UI_Elements;

import javax.swing.ImageIcon;

/**
 *
 * @author josue
 */
public class JCard extends javax.swing.JButton{
    private final int Fila, Columna;
    private boolean Line, Taken;
    private String Card;
    
    public JCard(int Fila, int Columna){
        this.Columna = Columna;
        this.Fila = Fila;
        Taken = false;
        Line = false;
    }
    
    public void setCard(String Card, ImageIcon Icon){
        if (Icon != null){
            setIcon(Icon);
        }
        this.Card = Card;
    }
    
    public void takeLine(){
        Line = true;
    }
    
    public boolean TakeCard(){
        return Taken = true;
    }
    
    public boolean isLineComplete(){
        return Line;
    }
    
    public boolean isCardTaken(){
        return Taken;
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
    
}
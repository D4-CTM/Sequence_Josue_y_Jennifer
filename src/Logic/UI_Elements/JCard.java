package Logic.UI_Elements;

import javax.swing.ImageIcon;

/**
 *
 * @author josue
 */
public class JCard extends javax.swing.JButton{
    private final int Fila, Columna;
    private String Card;
    
    public JCard(int Fila, int Columna){
        this.Columna = Columna;
        this.Fila = Fila;
    }
    
    public void setCard(String Card, ImageIcon Icon){
        if (Card != null){
            setIcon(Icon);
        }
        this.Card = Card;
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

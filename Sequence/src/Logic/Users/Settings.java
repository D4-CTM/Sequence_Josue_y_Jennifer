package Logic.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author josue
 */
public class Settings implements Serializable {
    private boolean CompartirFichas, ModificadoresActivos;
    private String CardsUrl, CardStyle;
    private int CantPlayer, CardsCant;
    private final boolean[] Active;
    private final String[] MCards; 
    private final String Name;
    
    public Settings(String Name) throws IOException{
        Active = new boolean[8];
        MCards = new String[8];
        this.Name = Name;
        CantPlayer = 4;
        setDefault();
    }
    
    private void setDefault() throws IOException{
        if (!new File("Configurations\\Default.SQC").exists()){
            setCardsUrl("Icons\\Estilo clasico\\", "Estilo clasico");
            setElegirCarta("GG", false);
            setBloquearEspacio("J2", true);
            setCambiarCarta("GG", false);
            setCambiarFichas("GG", false);
            setEliminarCarta("GG", false);
            setEliminarFichas("GG", false);
            setLiberarEspacio("J1", true);
            setOcuparEspacio("A", true);
            CantPlayer = 4;
            CardsCant = 8;
            
            setFichasCompartidas(false);
            setModificadores(true);
            SaveData("Default");
        }
    }
    
    public static Settings LoadFile(String nombreArchivo) throws IOException, ClassNotFoundException{
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Configurations\\" + nombreArchivo + ".SQC"))) {
            return (Settings) entrada.readObject();
        }
    }
    
    public void SaveData(String nombreArchivo) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Configurations\\" + nombreArchivo + ".SQC"))) {
            salida.writeObject(this);
            salida.close();
        }
    }
    
    public void setFichasCompartidas(boolean CompartirFichas){
        this.CompartirFichas = CompartirFichas;
    }
    
    public boolean areFichasCompartidas(){
        return this.CompartirFichas;
    }
    
    public void setModificadores(boolean Active){
        this.ModificadoresActivos = Active;
    }
    
    public boolean areModificadoresActivos(){
        return this.ModificadoresActivos;
    }
    
    public void setCardsUrl(String CardsUrl, String CardsStyle){
        this.CardStyle = CardsStyle;
        this.CardsUrl = CardsUrl;
    }
    
    public String getCardsStyle(){
        return this.CardStyle;
    }
    
    public String getCardsUrl(){
        return this.CardsUrl;
    }
    
    public void setBloquearEspacio(String Card, boolean Active){
        this.Active[0] = Active;
        MCards[0] = Card;
    }
    
    public String getBloquearEspacio(){
        if (Active[0]){
            return MCards[0];
        } else return "GG";
    }
    
    public void setLiberarEspacio(String Card, boolean Active){
        this.Active[1] = Active;
        MCards[1] = Card;
    }

    public String getLiberarEspacio(){
        if (Active[1]){
            return MCards[1];
        } else return "GG";
    }
    
    public void setOcuparEspacio(String Card, boolean Active){
        this.Active[2] = Active;
        MCards[2] = Card;
    }
    
    public String getOcuparEspacio(){
        if (Active[2]){
            return MCards[2];
        } else return "GG";
    }

    public void setEliminarCarta(String Card, boolean Active){
        this.Active[3] = Active;
        MCards[3] = Card;
    }

    public String getEliminarCarta(){
        if (Active[3]){
            return MCards[3];
        } else return "GG";
    }

    public void setCambiarCarta(String Card, boolean Active){
        this.Active[4] = Active;
        MCards[4] = Card;
    }

    public String getCambiarCarta(){
        if (Active[4]){
            return MCards[4];
        } else return "GG";
    }

    public void setElegirCarta(String Card, boolean Active){
        this.Active[5] = Active;
        MCards[5] = Card;
    }
    
    public String getElegirCarta(){
        if (Active[5]){
            return MCards[5];
        } else return "GG";
    }
    
    public void setCambiarFichas(String Card, boolean Active){
        this.Active[6] = Active;
        MCards[6] = Card;
    }
    
    public String getCambiarFichas(){
        if (Active[6]){
            return MCards[6];
        } else return "GG";
    }
    
    public void setEliminarFichas(String Card, boolean Active){
        this.Active[7] = Active;
        MCards[7] = Card;
    }
    
    public String getEliminarFichas(){
        if (Active[7]){
            return MCards[7];
        } else return "GG";
    }
    
    public void setCardsCants(int Cards){
        this.CardsCant = Cards;
    }
    
    public int getCardsCant(){
        return this.CardsCant;
    }
    
    public void setPlayerCant(int Players){
        this.CantPlayer = Players;
    }
    
    public int getPlayersCant(){
        return this.CantPlayer;
    }
    
    public String getName(){
        return Name;
    }
    
}

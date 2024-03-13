package Logic.Users;

import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class User implements Serializable{
    private final ArrayList<String> Historial;
    private String Name, Username, Password, Ficha;
    private final Calendar Created;
    private ImageIcon PlayerIcon;
    private int points;
    
    public User(String Name, String Username, String Password, ImageIcon PlayerIcon){
        EditData(Name, Username, Password, PlayerIcon);
        Created = Calendar.getInstance();
        Historial = new ArrayList();
        Ficha = "Tokens1.png";
        points = 0;
    }
    
    public static User LoadFile(String nombreArchivo) throws IOException, ClassNotFoundException{
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Accounts\\" + nombreArchivo + ".SQC"))) {
            return (User) entrada.readObject();
        }
    }
    
    public void SaveData(String nombreArchivo) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Accounts\\" + nombreArchivo + ".SQC"))) {
            salida.writeObject(this);
            salida.close();
        }
    }
    
    public final void EditData(String Name, String Username,String Password, ImageIcon PlayerIcon){
        this.PlayerIcon = PlayerIcon;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
    }
    
    public void AddMatchData(String Data){
        Historial.add(Data);
    }
    
    public ArrayList<String> getHistorial(){
        return Historial;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void MatchWon(){
        points += 3;
    }
    
    public Calendar getCreationDate(){
        return Created;
    }
    
    public void setficha(String Ficha){
        this.Ficha = Ficha;
    }
    
    public ImageIcon getPlayerIcon(){
        return PlayerIcon;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public String getFicha(){
        return Ficha;
    }
    
    public String getName(){
        return Name;
    }
    
}

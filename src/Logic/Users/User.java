package Logic.Users;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class User implements Serializable {
    private ImageIcon PlayerIcon, Ficha;
    private ArrayList<String> Historial;
    private String Name, Username, Password;
    private int Points;
    private Calendar CreationDate;
    
    public User(String Name, String Username, String Password, ImageIcon PlayerIcon){
        EditData(Name, Username, Password, PlayerIcon);
        Historial = new ArrayList<>();
        Points = 0;
        CreationDate = Calendar.getInstance();
    }
    
    public static ArrayList<User> LoadUsers(String nombreArchivo) throws IOException, ClassNotFoundException {
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<User>) entrada.readObject();
        }
    }

    public static void SaveUsers(ArrayList<User> users, String nombreArchivo) throws IOException {
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(file))) {
            salida.writeObject(users);
        }
    }
    
    public final void EditData(String FullName, String Username, String Password, ImageIcon PlayerIcon){
        this.PlayerIcon = PlayerIcon;
        this.Password = Password;
        this.Username = Username;
        this.Name = FullName;
    }
    
    public void AddMatchData(String Data){
        Historial.add(Data);
    }
    
    public void AddPoints(int points){
        this.Points += points;
    }
    
    public ArrayList<String> getHistorial(){
        return Historial;
    }
    
    public ImageIcon getPlayerIcon(){
        return PlayerIcon;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public ImageIcon getFicha(){
        return Ficha;
    }
    
    public String getName(){
        return Name;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public int getPoints(){
        return Points;
    }
    
    public Calendar getCreationDate(){
        return CreationDate;
    }
}
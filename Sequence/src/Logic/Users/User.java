package Logic.Users;

import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class User implements Serializable{
    private final ArrayList<String> Historial;
    private ImageIcon PlayerIcon, Ficha;
    private String Name, Password;
    
    public User(String Name, String Password, ImageIcon PlayerIcon){
        EditData(Name, Password, PlayerIcon);
        Historial = new ArrayList();
    }
    
    public static User LoadFile(String nombreArchivo) throws IOException, ClassNotFoundException{
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Accounts\\Cuentas\\" + nombreArchivo))) {
            return (User) entrada.readObject();
        }
    }
    
    public void SaveData(String nombreArchivo) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Accounts\\Cuentas\\" + nombreArchivo))) {
            salida.writeObject(this);
            salida.close();
        }
    }
    
    public final void EditData(String Name, String Password, ImageIcon PlayerIcon){
        this.PlayerIcon = PlayerIcon;
        this.Password = Password;
        this.Name = Name;
    }
    
    public void AddMatchData(String Data){
        Historial.add(Data);
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
    
}

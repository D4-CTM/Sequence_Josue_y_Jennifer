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
    
    public static User loadFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            return (User) input.readObject();
        }
    }

    public void createUserFolderAndSaveObject(String usuario) {
        String userFolderName = usuario;
        String userListFolder = "./UsuariosLista/Cuentas";

        File cuentasFolder = new File(userListFolder);
        if (!cuentasFolder.exists()) {
            if (cuentasFolder.mkdirs()) {
                System.out.println("Carpeta 'Cuentas' creada en: " + cuentasFolder.getAbsolutePath());
            } else {
                System.err.println("Error al crear la carpeta 'Cuentas'.");
                return;
            }
        }

        File userFile = new File(cuentasFolder, userFolderName);
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(userFile))) {
            salida.writeObject(this);
            System.out.println("Archivo del usuario creado en: " + userFile);
        } catch (IOException e) {
            e.printStackTrace();
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

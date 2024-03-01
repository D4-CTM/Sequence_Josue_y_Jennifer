package Logic.Users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class SettingsManager {
    private ArrayList<Settings> Setting;
    private Settings ActualSettings;
    
    public SettingsManager() throws IOException, ClassNotFoundException{
        Setting = new ArrayList();
        File Ajustes = new File("Configurations");
        if (Ajustes.isDirectory()){
            for (String Usuarios : Ajustes.list()){
                try {
                    String[] Configuraciones = Usuarios.split("[.]");
                    Setting.add(Settings.LoadFile(Configuraciones[0]));
                } catch (Exception Ex){}
            }
        }
        ActualSettings = Settings.LoadFile("Default");
    }
    
    public Settings getActualSettings(){
        return ActualSettings;
    }
    
    public void setActualSettings(String FileName) throws IOException, ClassNotFoundException{
        try {
            ActualSettings = Settings.LoadFile(FileName);
        } catch (Exception Ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error buscando esta configuracion", FileName, 0);
        }
    }
    
    public void AgregarConfiguracion(Settings Setting){
        this.Setting.add(Setting);
    }
    
    public ArrayList<Settings> getSettings(){
        return Setting;
    }
    
}
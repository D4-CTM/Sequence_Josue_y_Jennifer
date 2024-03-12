package Sequence;

import Logic.Users.GestorUsuarios;
import Logic.Users.Settings;
import java.io.IOException;

/**
 *
 * @author jenniferbueso
 */
public class Main_Sequence {
    public static GestorUsuarios gestorUsuarios = new GestorUsuarios();
    public static Settings ActualSetting;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ActualSetting = new Settings();
        
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        ActualSetting = Settings.LoadFile("Default");
        pantallaPrincipal.setVisible(true);
    }
}

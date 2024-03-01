package Sequence;

import Logic.Users.GestorUsuarios;
import Logic.Users.SettingsManager;
import java.io.IOException;

/**
 *
 * @author jenniferbueso
 */
public class Main_Sequence {
    public static GestorUsuarios gestorUsuarios = new GestorUsuarios();
    public static SettingsManager getorConfiguraciones;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        getorConfiguraciones = new SettingsManager();
        pantallaPrincipal.setVisible(true);
    }
}

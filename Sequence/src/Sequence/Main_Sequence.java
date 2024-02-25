package Sequence;

import Logic.Users.GestorUsuarios;

/**
 *
 * @author jenniferbueso
 */
public class Main_Sequence {
    public static GestorUsuarios gestorUsuarios = new GestorUsuarios();
    
    public static void main(String[] args) {
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class GestorUsuarios {
    private final ArrayList<User> usuariosLista;
    private User usarioLog;
    
    public GestorUsuarios() {
        usuariosLista = new ArrayList();
        try {
            File Users = new File("Accounts");
            setDir(new File("Accounts"));
            if (Users.isDirectory()){
                for (String Usuarios : Users.list()){
                    try {
                        String[] UserGet = Usuarios.split("[.]");
                        usuariosLista.add(User.LoadFile(UserGet[0]));
                    } catch (Exception Ex){
                        
                    }
                }
                
            }
        } catch (IOException ex) {            
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDir(File Accounts) throws IOException{
        if (Accounts.mkdir() || Accounts.list().length < 4){
            User Jennifer = new User("Jennifer","Jennifer","Bueso", new ImageIcon(getClass().getResource("/Elementos/Icono2.png")));
            Jennifer.setficha("Tokens1.png");
            Jennifer.SaveData("Jennifer");
            User Josh = new User("Josh","Josh","Delcid", new ImageIcon(getClass().getResource("/Elementos/Icono1.png")));
            Josh.setficha("Tokens2.png");
            Josh.SaveData("Josh");
            User Eleana = new User("Eleana","Eleana","Reyes", new ImageIcon(getClass().getResource("/Elementos/Icono3.png")));
            Eleana.setficha("Tokens3.png");
            Eleana.SaveData("Eleana");
            User Andrea = new User("Andrea","Andrea","Quin", new ImageIcon(getClass().getResource("/Elementos/Icono4.png")));
            Andrea.setficha("Tokens4.png");
            Andrea.SaveData("Andrea");
        }
    }
    
    
    public ArrayList<User> getUsuariosLista() {
        return usuariosLista;
    }

    public User getUserLog() {
        return usarioLog;
    }

    public void setUserLog(User usarioLog) {
        this.usarioLog = usarioLog;
    }
    
    private User buscar(String usuario) {
        return buscarUsuario(usuario, 0);
    }
    
    private User buscarUsuario(String usuario, int index) {
        if (index < usuariosLista.size()) {
            User cuenta = usuariosLista.get(index);
            if (cuenta.getUsername().equals(usuario)) {
                return cuenta;
            }
            return buscarUsuario(usuario, index + 1);
        }
        return null;
    }
    
    public boolean agregarUsuario(String nombre, String usuario, String contra, ImageIcon playerIcon) {
        if (buscar(usuario) == null) {
            usuariosLista.add(new User(nombre, usuario, contra, playerIcon));
            JOptionPane.showMessageDialog(null, "¡Bienvenido a Sequence, " + usuario + "!", "Cuenta Creada", 0, playerIcon);
                try {
                    ((User) usuariosLista.get(usuariosLista.size() - 1)).SaveData(usuario);
                } catch (IOException e) {
                    return false;
                }
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La cuenta de " + usuario + " ya existe.", "Cuenta Existente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean iniciarSesion(String usuario, String contra) {
        return iniciarSesion(usuario, contra, 0);
    }
    
    private boolean iniciarSesion(String usuario, String contra, int index) {
        if (index == usuariosLista.size()) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no existe. Por favor, inténtelo nuevamente.", "Usuario Inexistente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        User cuenta = usuariosLista.get(index);
        if (cuenta!=null && cuenta.getUsername().equals(usuario)) {
            if (cuenta.getPassword().equals(contra)) {
                usarioLog = cuenta;
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta. Por favor, inténtelo nuevamente.", "Contraseña Incorrecta", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return iniciarSesion(usuario, contra, index + 1);
    }

}

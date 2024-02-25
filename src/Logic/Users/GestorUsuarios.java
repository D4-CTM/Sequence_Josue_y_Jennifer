/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Users;

import static Logic.Users.User.SaveUsers;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class GestorUsuarios {
    private ArrayList<User> usuariosLista;
    private User usarioLog;
    
    public GestorUsuarios() {
        try {
            usuariosLista = User.LoadUsers("./UsuariosLista");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            usuariosLista = new ArrayList<>();
        }
    }

    public ArrayList<User> getUsuariosLista() {
        return usuariosLista;
    }

    public void setUsuariosLista(ArrayList<User> usuariosLista) {
        this.usuariosLista = usuariosLista;
    }

    public User getUsarioLog() {
        return usarioLog;
    }

    public void setUsarioLog(User usarioLog) {
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
                    SaveUsers(usuariosLista, "./UsuariosLista");
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La cuenta " + usuario + " ya existe.", "Cuenta Existente", JOptionPane.ERROR_MESSAGE);
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
        
        User cuenta = usuariosLista.get(0);
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

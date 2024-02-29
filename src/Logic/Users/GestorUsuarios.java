/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jenniferbueso
 */
public class GestorUsuarios {
    private ArrayList<User> usuariosLista;
    private User usuarioLog;
    private Configuracion configuracionUsuario;
    
    public GestorUsuarios() {
        String userFolder = "./UsuariosLista/Cuentas";
        usuariosLista = new ArrayList<>();

        File folder = new File(userFolder);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Carpeta de usuarios creada: " + userFolder);
            } else {
                System.err.println("Error al crear la carpeta de usuarios.");
            }
        } else {
            // Cargar los objetos de usuario desde los archivos en la carpeta
            File[] userFiles = folder.listFiles();
            if (userFiles != null) {
                for (File userFile : userFiles) {
                    if (userFile.isFile()) {
                        User loadedUser = loadUserFromFolder(userFile);
                        if (loadedUser != null) {
                            usuariosLista.add(loadedUser);
                        }
                    }
                }
            }
        }

        System.out.println("Cantidad de usuarios cargados: " + usuariosLista.size());
    }

    private User loadUserFromFolder(File userFile) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(userFile))) {
            return (User) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Configuracion getConfiguracionUsuario() {
        return configuracionUsuario;
    }

    public void setConfiguracionUsuario(Configuracion configuracionUsuario) {
        this.configuracionUsuario = configuracionUsuario;
    }
    
    public ArrayList<User> getUsuariosLista() {
        return usuariosLista;
    }

    public void setUsuariosLista(ArrayList<User> usuariosLista) {
        this.usuariosLista = usuariosLista;
    }

    public User getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(User usuarioLog) {
        this.usuarioLog = usuarioLog;
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
        User user = buscar(usuario);
        if (user == null) {
            user = new User(nombre, usuario, contra, playerIcon);
            usuariosLista.add(user);
            user.createUserFolderAndSaveObject(usuario);
            Configuracion configuracionUsuario = new Configuracion(0);
            configuracionUsuario.createConfigFolderAndSaveObject(usuario);
            
            JOptionPane.showMessageDialog(null, "¡Bienvenido(a), " + usuario + "!", "Cuenta Creada", 0, playerIcon);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La cuenta " + usuario + " ya existe.", "Cuenta Existente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private Configuracion cargarConfiguracionUsuario(String usuario) {
        String userListFolder = "./UsuariosLista/Configuracion/" + usuario;

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(userListFolder))) {
            return (Configuracion) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
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
        if (cuenta != null && cuenta.getUsername().equals(usuario)) {
            if (cuenta.getPassword().equals(contra)) {
                usuarioLog = cuenta;
                configuracionUsuario = cargarConfiguracionUsuario(usuario);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta. Por favor, inténtelo nuevamente.", "Contraseña Incorrecta", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return iniciarSesion(usuario, contra, index + 1);
    }
}

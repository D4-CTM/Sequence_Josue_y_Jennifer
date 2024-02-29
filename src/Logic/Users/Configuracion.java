/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Users;

import Sequence.Main_Sequence;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author jenniferbueso
 */
public class Configuracion implements Serializable{
    private int cantidadJugadores;
    private int cantidadEquipos;
    private int cantidadFichas;
    private ImageIcon colorFicha;
    private String usuario;

    public Configuracion(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
        colorFicha = null;
        switch (cantidadJugadores) {
            case 2:
                this.cantidadFichas = 7;
                this.cantidadEquipos = 2;
                break;
            case 3:
                this.cantidadFichas = 6;
                this.cantidadEquipos = 3;
                break;
            case 4:
                this.cantidadFichas = 7;
                this.cantidadEquipos = 2;
                break;
            case 6:
                this.cantidadFichas = 5;
                this.cantidadEquipos = 3;
                break;
            case 8:
                this.cantidadFichas = 4;
                this.cantidadEquipos = 2;
                break;
        }
    }
    
    public void createConfigFolderAndSaveObject(String usuario) {
        String userFolderName = usuario;
        String userListFolder = "./UsuariosLista/Configuracion";

        File cuentasFolder = new File(userListFolder);
        if (!cuentasFolder.exists()) {
            if (cuentasFolder.mkdirs()) {
                System.out.println("Carpeta 'Configuracion' creada en: " + cuentasFolder.getAbsolutePath());
            } else {
                System.err.println("Error al crear la carpeta 'Configuracion'.");
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

    public void saveToFile() {
        String username = Main_Sequence.gestorUsuarios.getUsuarioLog().getUsername();
        String userListFolder = "./UsuariosLista/Configuracion/";

        Configuracion configuracionActual = Main_Sequence.gestorUsuarios.getConfiguracionUsuario();
        if (configuracionActual != null) {
            configuracionActual.setColorFicha(this.colorFicha);
            configuracionActual.setCantidadJugadores(this.cantidadJugadores);

            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(userListFolder + username))) {
                salida.writeObject(configuracionActual);
                System.out.println("Archivo del usuario actualizado: " + userListFolder + username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Error al cargar la configuración actual del usuario.");
        }
    }

    public void setColorFicha(ImageIcon colorFicha) {
        this.colorFicha = colorFicha;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public int getCantidadFichas() {
        return cantidadFichas;
    }

    public ImageIcon getColorFicha() {
        return colorFicha;
    }
}
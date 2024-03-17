/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.UI_Elements;

import javax.swing.ImageIcon;

/**
 *
 * @author josue
 */
public class Tokens{
    private final String Path, Token;
    private final ImageIcon Ficha;
    private boolean Taken;
    
    public Tokens(String Path, String Token, ImageIcon Ficha){
        this.Taken = false;
        this.Ficha = Ficha;
        this.Token = Token;
        this.Path = Path;
    }
    
    public void setTaken(boolean Taken){
        this.Taken = Taken;
    }
    
    public ImageIcon getFicha(){
        return this.Ficha;
    }
    
    public boolean isTaken(){
        return this.Taken;
    }
    
    public String getToken(){
        return this.Token;
    }
    
    public String getPath(){
        return this.Path;
    }
    
}
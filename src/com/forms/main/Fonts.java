package com.forms.main;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Bill Gan
 */
public class Fonts {
    
    private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
    
    private static String fontPath;
    
    public Fonts(String filePath){
        Fonts.fontPath = "./resources/" + filePath;
        registerFont();
    }
    
    private void registerFont(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try{
            ge.registerFont(java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File(fontPath)));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void addFont(Fonts font){
        fontList.add(font);
    }
    
}

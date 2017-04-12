package com.forms.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;
import org.lwjgl.openal.AL;

/**
 *
 * @author Bill Gan
 */
public class Window extends Canvas {
    
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("./resources/missile.png");
        frame.setIconImage(icon);
        
        frame.addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        try {
                            Game.playerdata.store(new FileOutputStream(new File("./data/playerdata.properties")), null);
                        } catch (IOException i){
                            i.printStackTrace();
                        }
                        AL.destroy();
                        System.exit(0);
                    }
                }
        );
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}

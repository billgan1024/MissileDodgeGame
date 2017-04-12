package com.forms.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class Background extends GameObject {
    
    private Handler handler;
    private BufferedImage image;
    
    public Background(int x, int y, ID id, Handler handler, BufferedImage image){
        super(x, y, id);
        this.handler = handler;
        this.image = image;
        
        velX = -1;
        velY = 0;
    }
    
    public Rectangle getBounds(){
        return null;
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
        if(x == -1024)
            x = 1024;
    }
    
    public void render(Graphics g){
        g.drawImage(image, x, y, null);
    }

}

package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class Alert extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    private Color color, flash;
    private int counter = 0;
    
    public Alert(int x, int y, Color color, Color flash, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        this.color = color;
        this.flash = flash;
        
        velX = 0;
        velY = 0;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick(){
        x += velX;
        y += velY;
        
        counter++;
        if(counter >= 80)
            handler.removeObject(this);
    }

    public void render(Graphics g){
        g.setColor(color);
        if(counter >= 50 && counter <= 55)
            g.setColor(flash);
        if(counter >= 60 && counter <= 65)
            g.setColor(flash);
        if(counter >= 70 && counter <= 75)
            g.setColor(flash);
        g.fillOval(x, y, 32, 32);
    }

}
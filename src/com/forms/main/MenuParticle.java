package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class MenuParticle extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    
    private Color color;
    private int dir = r.nextInt(3);
    
    public MenuParticle(int x, int y, ID id, Handler handler, int red, int green, int blue){
        super(x, y, id);
        
        this.handler = handler;
        
        if(dir == 0){
            velX = 7; velY = 7;
        }
        if(dir == 1){
            velX = -7; velY = 7;
        }
        if(dir == 2){
            velX = 7; velY = -7;
        }
        if(dir == 3){
            velX = -7; velY = -7;
        }
        
        color = new Color(red, green, blue);
    }
    
    public Rectangle getBounds(){
        return null;
    }

    public void tick() {
        x += velX;
        y += velY;
        if(y <= 0 || y >= Game.HEIGHT - 80)
            velY *= -1;
        if(x <= -2 || x >= Game.WIDTH - 32)
            velX *= -1;
        
        handler.addObject(new SquareTrail(x, y, ID.SquareTrail, color, 32, 32, 0.025f, handler));
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 32, 32);
    }

}


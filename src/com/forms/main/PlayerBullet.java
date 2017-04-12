package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class PlayerBullet extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    
    public PlayerBullet(int x, int y, ID id, Handler handler, int velX, int velY){
        super(x, y, id);
        
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 24, 24);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        if(y <= -24 || y >= Game.HEIGHT)
            handler.removeObject(this);
        if(x <= -24 || x >= Game.WIDTH)
            handler.removeObject(this);
        checkCollision();
    }

    public void render(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillOval(x, y, 24, 24);
    }
    
    public void checkCollision(){
        
    }

}
package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Bill Gan
 */
public class Seeker extends GameObject{
    
    private Handler handler;
    private GameObject player;
    
    public Seeker(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player)
                player = handler.object.get(i);
        }
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 48, 48);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        float diffX = x - player.getX() - 24;
        float diffY = y - player.getY() - 24;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        
        
        //velX = ((-1/distance) * diffX);
        //velY = ((-1/distance) * diffY);
        
        /*if(y <= 0 || y >= Game.HEIGHT - 80)
            velY *= -1;
        if(x <= -2 || x >= Game.WIDTH - 32)
            velX *= -1;*/
        
    }

    public void render(Graphics g) {
        g.setColor(new Color(51, 255, 51));
        g.fillRect(x, y, 48, 48);
    }

}

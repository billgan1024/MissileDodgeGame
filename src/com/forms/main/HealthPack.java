package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Bill Gan
 */
public class HealthPack extends GameObject {
    
    private Handler handler;
    private int counter;
    private Color color;
    
    public HealthPack(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        velX = 2;
        velY = 2;
        color = new Color(0, 153, 0);
    }
    
    public void tick(){
        x += velX;
        y += velY;
        if(y <= -2 || y >= Game.HEIGHT - 85)
            velY *= -1;
        if(x <= -2 || x >= Game.WIDTH - 38)
            velX *= -1;
        counter++;
        if(counter % 80 == 0){
            color = new Color(0, 153, 0);
        }
        if(counter % 80 == 40){
            color = new Color(0, 222, 0);
        }
        checkCollision();
    }
    
    public void render(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, 36, 36);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 36, 36);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.health += 50;
                    handler.removeObject(this);
                    
                    AudioPlayer.getSound("powerup").play(1f, 0.6f);
                }
            }
        }
    }

}

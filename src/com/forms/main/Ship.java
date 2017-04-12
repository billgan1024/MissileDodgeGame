package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class Ship extends GameObject {
    
    private Handler handler;
    private Random r = new Random();
    private int random;
    private int counter;
    private int life;

    public Ship(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        velX = -2;
        velY = 0;
        
        life = 150;
    }

    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y <= -2 || y >= Game.HEIGHT - 96)
            velY *= -1;
        counter++;
        if(counter % 60 == 0 && x <= Game.WIDTH){
            handler.addObject(new ShooterBullet(x, y + 10, ID.ShooterBullet, handler, -10, 0));
        }
        checkCollision();
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 64, 64);
    }
    
    public void render(Graphics g){
        g.drawImage(Game.ship, x, y, null);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(getBounds().intersects(tempObject.getBounds())){
                    AudioPlayer.getSound("hit").play(1f, 0.5f);
                    handler.removeObject(this);
                    HUD.health -= 100;
                }
            }
            if(tempObject.getId() == ID.PlayerBullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                    life -= handler.damage;
                    AudioPlayer.getSound("hit").play(1f, 0.5f);
                    if(life <= 0){
                        handler.removeObject(this);
                    }
                }
            }
        }
    }

}

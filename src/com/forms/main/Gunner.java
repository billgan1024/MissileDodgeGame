package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class Gunner extends GameObject {
    
    private Handler handler;
    private Random r = new Random();
    private int random;
    private int counter;
    private int life;

    public Gunner(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        velX = -3;
        velY = 0;
        
        life = 150;
    }

    
    public void tick(){
        x += velX;
        y += velY;
        
        if(y <= -2 || y >= Game.HEIGHT - 96)
            velY *= -1;
        counter++;
        if(counter % 10 == 0 && x <= Game.WIDTH){
            random = r.nextInt(8);
            if(random == 0){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -10, 0));
            }
            else if(random == 1){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -9, 2));
            }
            else if(random == 2){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -8, 4));
            }
            else if(random == 3){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -9, -2));
            }
            else if(random == 4){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -8, -4));
            }
            else if(random == 5){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -9, -1));
            }
            else if(random == 6){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -9, -1));
            }
            else if(random == 7){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -8, 3));
            }
            else if(random == 8){
                handler.addObject(new ShooterBullet(x, y, ID.ShooterBullet, handler, -8, -3));
            }
        }
        checkCollision();
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 64, 64);
    }
    
    public void render(Graphics g){
        g.setColor(new Color(0, 128, 255));
        g.fillRect(x, y, 64, 64);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.PlayerBullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(tempObject);
                    life -= handler.damage;
                    if(life <= 0){
                        AudioPlayer.getSound("hit").play(1f, 0.5f);
                        handler.removeObject(this);
                    }
                }
            }
        }
    }
    
}

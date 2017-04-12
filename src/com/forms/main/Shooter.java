package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class Shooter extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    private int dir = r.nextInt(3);
    
    private int time;
    private int timer = 0;
    private int rate;
    
    public Shooter(int x, int y, int time, int rate, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        this.time = time;
        this.rate = rate;
        
        if(dir == 0){
            velX = 5;
            velY = 3;
        }
        if(dir == 1){
            velX = 5;
            velY = -3;
        }
        if(dir == 2){
            velX = -5;
            velY = -3;
        }
        if(dir == 3){
            velX = -5;
            velY = 3;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 64, 64);
    }

    public void tick() {
        x += velX;
        y += velY;
        timer++;
        if(time == 0){
            //on time shooters
            if(timer % rate == 0){
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 0, -10));
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 0, 10));
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, -10, 0));
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 10, 0));
                
                AudioPlayer.getSound("shoot").play(1f, 2f);
            }
        } else if(time == 1){
            //off time shooters
            if(timer % rate == (rate / 2)){
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, 0, -10));
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, 0, 10));
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, -10, 0));
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, 10, 0));
                
                AudioPlayer.getSound("shoot").play(1f, 2f);
            }
        }
        
        if(y <= 0 || y >= Game.HEIGHT - 110)
            velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 64)
            velX *= -1;
        checkCollision();
    }

    public void render(Graphics g) {
        g.setColor(new Color(153, 0, 153));
        g.fillRect(x, y, 64, 64);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.health -= 2;
                }
            }
        }
    }

}

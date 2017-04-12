package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class EliteShooter extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    private int dir = r.nextInt(3);
    
    private int timer = 0;
    private int rate;
    private int phase = 1;
    
    public EliteShooter(int x, int y, int rate, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
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
        if(timer % rate == 0){
            if(phase == 1){
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 0, -12));
                phase++;
            }else if(phase == 2){
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 12, -12));
                phase++;
            }else if(phase == 3){
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 12, 0));
                phase++;
            }else if(phase == 4){
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 12, 12));
                phase++;
            }else if(phase == 5){
                handler.addObject(new ShooterBullet(x + velX + 16, y + velY + 16, ID.ShooterBullet, handler, 0, 12));
                phase++;
            }else if(phase == 6){
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, -12, 12));
                phase++;
            }else if(phase == 7){
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, -12, 0));
                phase++;
            }else if(phase == 8){
                handler.addObject(new ShooterBullet(x + 16, y + 16, ID.ShooterBullet, handler, -12, -12));
                phase = 1;
            }
                AudioPlayer.getSound("click").play(1f, 2f);
        }
        
        if(y <= 0 || y >= Game.HEIGHT - 110)
            velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 64)
            velX *= -1;
        checkCollision();
    }

    public void render(Graphics g) {
        g.setColor(new Color(204, 0, 102));
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

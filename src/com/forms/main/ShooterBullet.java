package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class ShooterBullet extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    
    public ShooterBullet(int x, int y, ID id, Handler handler, int velX, int velY){
        super(x, y, id);
        
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        if(y <= -32 || y >= Game.HEIGHT + 32)
            handler.removeObject(this);
        if(x <= -32 || x >= Game.WIDTH + 32)
            handler.removeObject(this);
        checkCollision();
    }

    public void render(Graphics g) {
        g.setColor(new Color(255, 128, 0));
        g.fillOval(x, y, 32, 32);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    if(!Menu.is2player){
                        if(Game.difficulty == 0){
                            HUD.health -= 20;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 1){
                            HUD.health -= 23;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 2){
                            HUD.health -= 26;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 3){
                            HUD.health -= 32;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == Game.lvl1){
                            HUD.health -= 26;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                    } else {
                        if(Game.difficulty == 0){
                            HUD.health -= 17;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 1){
                            HUD.health -= 20;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 2){
                            HUD.health -= 23;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 3){
                            HUD.health -= 27;
                            AudioPlayer.getSound("hit").play(1f, 0.5f);
                            handler.removeObject(this);
                        }
                    }
                }
            }
        }
    }

}
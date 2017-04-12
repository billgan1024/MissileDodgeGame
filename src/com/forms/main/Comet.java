package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class Comet extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    
    public Comet(int x, int y, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 5;
        velY = 15;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;
        if(y <= 0 || y >= Game.HEIGHT - 80)
            velY *= -1;
        if(x <= -2 || x >= Game.WIDTH - 32)
            velX *= -1;
        
        checkCollision();
        
        handler.addObject(new CircleTrail(x,  y, ID.CircleTrail, new Color(0, 255, 255), 32, 32, 0.18f, handler));
    }

    public void render(Graphics g) {
        g.setColor(new Color(0, 255, 255));
        g.fillOval(x, y, 32, 32);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    if(!Menu.is2player){
                        if(Game.difficulty == 0)
                            HUD.health -= 8;
                        else if(Game.difficulty == 1)
                            HUD.health -= 9;
                        else if(Game.difficulty == 2)
                            HUD.health -= 11;
                        else if(Game.difficulty == 3)
                            HUD.health -= 12;
                    } else {
                        if(Game.difficulty == 0)
                            HUD.health -= 6;
                        else if(Game.difficulty == 1)
                            HUD.health -= 7;
                        else if(Game.difficulty == 2)
                            HUD.health -= 9;
                        else if(Game.difficulty == 3)
                            HUD.health -= 12;
                    }
                }
            }
        }
    }

}

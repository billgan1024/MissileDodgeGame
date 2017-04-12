package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Bill Gan
 */
public class Missile extends GameObject {
    
    private Handler handler;
    private Direction dir;
    private int speed;
    //1 = UP MISSILE(the missile starts at the top)
    //2 - DOWN MISSILE(the missile starts at the bottom)
    //3 = LEFT MISSILE(the missile starts at the left)
    //4 = RIGHT MISSILE(the missile starts at the right)

    public Missile(int x, int y, Direction dir, int speed, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        this.dir = dir;
        this.speed = speed;
        
        if(dir == Direction.UP){
            this.velY = speed;
            this.velX = 0;
        }
        if(dir == Direction.DOWN){
            this.velY = -speed;
            this.velX = 0;
        }
        if(dir == Direction.LEFT){
            this.velX = speed;
            this.velY = 0;
        }
        if(dir == Direction.RIGHT){
            this.velX = -speed;
            this.velY = 0;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        if(dir == Direction.UP){
            if(y >= Game.HEIGHT - 80)
                handler.removeObject(this);
        }
        if(dir == Direction.DOWN){
            if(y <= 0)
                handler.removeObject(this);
        }
        if(dir == Direction.LEFT){
            if(x >= Game.WIDTH - 34)
                handler.removeObject(this);
        }
        if(dir == Direction.RIGHT){
            if(x <= -2){
                handler.removeObject(this);
            }
        }
        
        checkCollision();
        //handler.addObject(new CircleTrail(x, y, ID.CircleTrail, Color.yellow, 32, 32, 0.3f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
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
                            HUD.health -= 30;
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 1){
                            HUD.health -= 33;
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 2){
                            HUD.health -= 37;
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 3){
                            HUD.health -= 40;
                            handler.removeObject(this);
                        }
                    } else {
                        if(Game.difficulty == 0){
                            HUD.health -= 25;
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 1){
                            HUD.health -= 27;
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 2){
                            HUD.health -= 30;
                            handler.removeObject(this);
                        }
                        else if(Game.difficulty == 3){
                            HUD.health -= 33;
                            handler.removeObject(this);
                        }
                    }
                    AudioPlayer.getSound("hit").play(1f, 0.2f);
                }
            }
        }
    }
    
}

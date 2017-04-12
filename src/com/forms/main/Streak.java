package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Bill Gan
 */
public class Streak extends GameObject {
    
    private Handler handler;
    private Direction dir;
    private int speed;
    private Color color;
    //1 = UPLEFT STREAK(the streak is going upleft)
    //2 - UPRIGHT STREAK(the streak is going upright)
    //3 = DOWNLEFT STREAK(the streak is going downleft)
    //4 = DOWNRIGHT STREAK(the streak is going downright)

    public Streak(int x, int y, Direction dir, int speed, Color color, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        this.dir = dir;
        this.speed = speed;
        this.color = color;
        
        if(dir == Direction.UPLEFT){
            this.velX = -speed;
            this.velY = -speed;
        }
        if(dir == Direction.UPRIGHT){
            this.velX = speed;
            this.velY = -speed;
        }
        if(dir == Direction.DOWNLEFT){
            this.velX = -speed;
            this.velY = speed;
        }
        if(dir == Direction.DOWNRIGHT){
            this.velX = speed;
            this.velY = speed;
        }
        if(dir == Direction.UP){
            this.velX = 0;
            this.velY = -speed;
        }
        if(dir == Direction.DOWN){
            this.velX = 0;
            this.velY = speed;
        }
        if(dir == Direction.LEFT){
            this.velX = -speed;
            this.velY = 0;
        }
        if(dir == Direction.RIGHT){
            this.velX = speed;
            this.velY = 0;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 36, 36);
    }

    public void tick() {
        x += velX;
        y += velY;
        
        if(dir == Direction.UPLEFT){
            if(x <= -2 || y <= 0)
                handler.removeObject(this);
        }
        if(dir == Direction.UPRIGHT){
            if(x >= Game.WIDTH - 34 || y <= 0)
                handler.removeObject(this);
        }
        if(dir == Direction.DOWNLEFT){
            if(x <= -2 || y >= Game.HEIGHT + 80)
                handler.removeObject(this);
        }
        if(dir == Direction.DOWNRIGHT){
            if(x >= Game.WIDTH - 34 || y >= Game.HEIGHT + 80)
                handler.removeObject(this);
        }
        
        if(dir == Direction.UP){
            if(y <= 0)
                handler.removeObject(this);
        }
        if(dir == Direction.DOWN){
            if(y >= Game.HEIGHT + 80)
                handler.removeObject(this);
        }
        if(dir == Direction.LEFT){
            if(x <= -2)
                handler.removeObject(this);
        }
        if(dir == Direction.RIGHT){
            if(x >= Game.WIDTH - 34)
                handler.removeObject(this);
        }
        
        checkCollision();
        handler.addObject(new CircleTrail(x, y, ID.CircleTrail, color, 36, 36, 0.06f, handler));
    }

    public void render(Graphics g) {
        g.setColor(new Color(255, 0, 127));
        g.fillOval(x, y, 36, 36);
    }
    
    public void checkCollision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    if(!Menu.is2player){
                        if(Game.difficulty == 0)
                            HUD.health -= 14;
                        else if(Game.difficulty == 1)
                            HUD.health -= 16;
                        else if(Game.difficulty == 2)
                            HUD.health -= 18;
                        else if(Game.difficulty == 3)
                            HUD.health -= 22;
                    } else {
                        if(Game.difficulty == 0)
                            HUD.health -= 12;
                        else if(Game.difficulty == 1)
                            HUD.health -= 14;
                        else if(Game.difficulty == 2)
                            HUD.health -= 16;
                        else if(Game.difficulty == 3)
                            HUD.health -= 19;
                    }
                }
            }
        }
    }
    
}

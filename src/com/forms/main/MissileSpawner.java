package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class MissileSpawner extends GameObject{
    
    private Handler handler;
    private Random r = new Random();
    private int timer = 0;
    private Direction direction;
    private int rate;
    private int speed;
    //0 = STATIONARY SPAWNER
    //1 = UP SPAWNER
    //2 = DOWN SPAWNER
    //3 = LEFT SPAWNER
    //4 = RIGHT SPAWNER
    
    public MissileSpawner(int x, int y, Direction direction, int speed, int rate, ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        this.direction = direction;
        
        this.rate = rate;
        this.speed = speed;
        if(this.direction == Direction.LEFT || this.direction == Direction.RIGHT){
            this.velY = speed;
            this.velX = 0;
        }
        else if(this.direction == Direction.UP || this.direction == Direction.DOWN){
            this.velX = speed;
            this.velY = 0;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;
        timer++;
        
        if(direction == Direction.LEFT || direction == Direction.RIGHT){
            if(y <= 0 || y >= Game.HEIGHT - 80)
                velY *= -1;
        }
        if(direction == Direction.UP || direction == Direction.DOWN){
            if(x <= -2 || x >= Game.WIDTH - 34)
                velX *= -1;
        }
        
        if(direction == Direction.UP){
            if(timer % rate == 0){
                handler.addObject(new Missile(x + 8, y + 8, Direction.UP, 13, ID.Missile, handler));
            }
        }
        if(direction == Direction.DOWN){
            if(timer % rate == 0){
                handler.addObject(new Missile(x + 8, y + 8, Direction.DOWN, 13, ID.Missile, handler));
            }
        }
        if(direction == Direction.LEFT){
            if(timer % rate == 0){
                handler.addObject(new Missile(x + 8, y + 8, Direction.LEFT, 13, ID.Missile, handler));
            }
        }
        if(direction == Direction.RIGHT){
            if(timer % rate == 0){
                handler.addObject(new Missile(x + 8, y + 8, Direction.RIGHT, 13, ID.Missile, handler));
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 32, 32);
    }

}

package com.forms.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class Player extends GameObject {
    
    private Handler handler;
    public static BufferedImage playerimage;
    public static BufferedImage player2image;
    
    public static SpriteSheet spritesheet;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 0;
        
        spritesheet = new SpriteSheet(Game.spritesheet);
        
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 48, 48);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 0, Game.WIDTH - 54);
        y = Game.clamp(y, 2, Game.HEIGHT - 98);
        
        //handler.addObject(new Trail(x, y, ID.Trail, Color.white, 48, 48, 0.06f, handler));
        //checkCollision();
    }

    public void render(Graphics g) {
        playerimage = spritesheet.grabImage(Game.imageColInt, Game.imageRowInt, 48, 48);
        player2image = spritesheet.grabImage(3, 1, 48, 48);
        
        if(id == ID.Player){
            g.drawImage(playerimage, x, y, null);
        }
        else if(id == ID.Player2){
            g.drawImage(player2image, x, y, null);
        }
        
        /*if(Menu.isSinglePlayer){
            g.setColor(new Color(153, 0, 0));
            g.fillRect(x - 14, y - 20, HUD.maxHealth / 4, 10);
            
            g.setColor(new Color(0, 204, 0));
            g.fillRect(x - 14, y - 20, HUD.health / 4, 10);
            
            g.setColor(Color.white);
            g.drawRect(x - 14, y - 20, HUD.maxHealth / 4, 10);
        }*/
    }

}

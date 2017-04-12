package com.forms.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Bill Gan
 */
public class HUD {
    
    public static int health = 300;
    public static int maxHealth = 300;
    public static int regenTime = 65;
    public static int regen = 1;
    
    private int score = 0;
    private int level = 1;
    private int counter = 0;
    
    public void tick(){
        health = Game.clamp(health, 0, maxHealth);
        counter++;
        if(counter % regenTime == 0 && health < maxHealth){
            health += regen;
        }
        score++;
    }
    
    public void render(Graphics g){
        Font font = new Font("Calibri", Font.BOLD, 24);
        
        g.setColor(new Color(153, 0, 0));
        g.fillRect(15, 15, maxHealth, 32);
        
        g.setColor(new Color(0, 204, 0));
        g.fillRect(15, 15, health, 32);
        
        g.setColor(Color.white);
        g.drawRect(15, 15, maxHealth, 32);
        
        g.setFont(font);
        g.drawString("HP: " + health + " / " + maxHealth, 97, 39);
        g.drawString("Score: " + score, 15, 74);
        g.drawString("Level: " + level, 15, 98);
        if(!Menu.isSinglePlayer)
        g.drawString("[SPACE] Shop", 15, 146);
        
        if(Spawner.counter >= 0 && Spawner.counter <= 100){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 1", 440, 200);
        }
        if(Spawner.counter >= 700 && Spawner.counter <= 800){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 2", 440, 200);
        }
        if(Spawner.counter >= 1500 && Spawner.counter <= 1600){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 3", 440, 200);
        }
        if(Spawner.counter >= 2400 && Spawner.counter <= 2500){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 4", 440, 200);
        }
        if(Spawner.counter >= 3400 && Spawner.counter <= 3500){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 5", 440, 200);
        }
        if(Spawner.counter >= 4500 && Spawner.counter <= 4600){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 6", 440, 200);
        }
        if(Spawner.counter >= 5700 && Spawner.counter <= 5800){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 7", 440, 200);
        }
        if(Spawner.counter >= 7000 && Spawner.counter <= 7100){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 8", 440, 200);
        }
        if(Spawner.counter >= 8400 && Spawner.counter <= 8500){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 9", 440, 200);
        }
        if(Spawner.counter >= 9900 && Spawner.counter <= 10000){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 10", 440, 200);
        }
        if(Spawner.counter >= 11500 && Spawner.counter <= 11600){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 11", 430, 200);
        }
        if(Spawner.counter >= 13200 && Spawner.counter <= 13300){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 12", 430, 200);
        }
        if(Spawner.counter >= 15000 && Spawner.counter <= 15100){
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("Level 13", 430, 200);
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

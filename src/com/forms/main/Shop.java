package com.forms.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Bill Gan
 */
public class Shop extends MouseAdapter {
    
    private Handler handler;
    private HUD hud;
    
    public static int speedCost = 1000;
    public static int maxHealthCost = 1000;
    public static int regenCost = 1000;
    public static int refillCost = 1500;
    public static int speedLevel = 1;
    public static int maxHealthLevel = 1;
    public static int regenLevel = 1;
    public static int speedIncrement = 200;
    public static int maxHealthIncrement = 200;
    public static int regenIncrement = 200;
    
    public Shop(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.BOLD,60));
        g.drawString("Upgrade Shop", 360, 100);
        
        //display score
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawString("Score: " + hud.getScore(), 100, 94);
        
        //movement speed upgrades
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawString("Movement Speed", 320, 186);
        g.setColor(new Color(0, 204, 0));
        g.fillRect(201, 201, speedLevel * 100, 49);
        g.setColor(Color.white);
        g.drawRect(200, 200, 100, 50);
        g.drawRect(200, 200, 200, 50);
        g.drawRect(200, 200, 300, 50);
        g.drawRect(200, 200, 400, 50);
        g.drawRect(200, 200, 500, 50);
        g.drawRoundRect(710, 200, 200, 50, 20, 20);
        g.setFont(new Font("Calibri", Font.BOLD, 30));
        if(speedLevel < 5){
            g.setFont(new Font("Calibri", Font.BOLD, 36));
            g.drawString("Upgrade", 746, 237);
            g.setFont(new Font("Calibri", Font.BOLD, 30));
            g.drawString("Cost: " + speedCost, 744, 196);
        } else {
            g.setFont(new Font("Calibri", Font.BOLD, 36));
            g.drawString("Maxed", 760, 237);
        }
        
        //max health upgrades
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawString("Max Health", 367, 290);
        g.setColor(new Color(153, 51, 255));
        g.fillRect(201, 305, maxHealthLevel * 100, 49);
        g.setColor(Color.white);
        g.drawRect(200, 304, 100, 50);
        g.drawRect(200, 304, 200, 50);
        g.drawRect(200, 304, 300, 50);
        g.drawRect(200, 304, 400, 50);
        g.drawRect(200, 304, 500, 50);
        g.drawRoundRect(710, 304, 200, 50, 20, 20);
        if(maxHealthLevel < 5){
            g.setFont(new Font("Calibri", Font.BOLD, 36));
            g.drawString("Upgrade", 746, 341);
            g.setFont(new Font("Calibri", Font.BOLD, 30));
            g.drawString("Cost: " + maxHealthCost, 744, 300);
        } else {
            g.setFont(new Font("Calibri", Font.BOLD, 36));
            g.drawString("Maxed", 760, 341);
        }
        
        //regen upgrades
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawString("Health Regen", 354, 394);
        g.setColor(new Color(255, 0, 127));
        g.fillRect(201, 409, regenLevel * 100, 49);
        g.setColor(Color.white);
        g.drawRect(200, 408, 100, 50);
        g.drawRect(200, 408, 200, 50);
        g.drawRect(200, 408, 300, 50);
        g.drawRect(200, 408, 400, 50);
        g.drawRect(200, 408, 500, 50);
        g.drawRoundRect(710, 408, 200, 50, 20, 20);
        if(regenLevel < 5){
            g.setFont(new Font("Calibri", Font.BOLD, 36));
            g.drawString("Upgrade", 746, 445);
            g.setFont(new Font("Calibri", Font.BOLD, 30));
            g.drawString("Cost: " + regenCost, 744, 404);
        }else {
            g.setFont(new Font("Calibri", Font.BOLD, 36));
            g.drawString("Maxed", 760, 445);
        }
        
        //refill health button
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawRoundRect(400, 540, 280, 50, 20, 20);
        g.drawString("Refill Health", 450, 578);
        g.setFont(new Font("Calibri", Font.BOLD, 30));
        g.drawString("Cost: " + refillCost, 476, 536);
        
        //back button
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawRoundRect(400, 600, 280, 50, 20, 20);
        g.drawString("Back", 505, 637);
    }
    
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        if(Game.gameState == Game.STATE.Shop){
        //upgrade movement speed
        if(mouseOver(mouseX, mouseY, 710, 200, 200, 50)){
            if(speedLevel < 5){
                if(hud.getScore() >= speedCost){
                    hud.setScore(hud.getScore() - speedCost);
                    handler.speed++;
                    speedLevel++;
                    speedCost += speedIncrement;
                    if(speedLevel >= 2){
                    speedIncrement += 400;
                    }
                    else
                        speedIncrement += 200;
                } else {
                    AudioPlayer.getSound("cancel").play(1f, 7f);
                }
            } else
                AudioPlayer.getSound("cancel").play(1f, 7f);
        }
        //upgrade max health
        if(mouseOver(mouseX, mouseY, 710, 304, 200, 50)){
            if(maxHealthLevel < 5){
                if(hud.getScore() >= maxHealthCost){
                    hud.setScore(hud.getScore() - maxHealthCost);
                    hud.maxHealth += 30;
                    hud.health += 30;
                    maxHealthLevel++;
                    maxHealthCost += maxHealthIncrement;
                    if(maxHealthLevel >= 2){
                    maxHealthIncrement += 400;
                    }
                    else
                        maxHealthIncrement += 200;
                } else {
                    AudioPlayer.getSound("cancel").play(1f, 7f);
                }
            } else
                AudioPlayer.getSound("cancel").play(1f, 7f);
        }
        
        //upgrade regen
        if(mouseOver(mouseX, mouseY, 710, 408, 200, 50)){
            if(regenLevel < 5){
                if(hud.getScore() >= regenCost){
                    hud.setScore(hud.getScore() - regenCost);
                    hud.regenTime -= 1;
                    hud.regen++;
                    regenLevel++;
                    regenCost += regenIncrement;
                    if(regenLevel >= 2){
                    regenIncrement += 400;
                    }
                    else
                        regenIncrement += 200;
                } else {
                    AudioPlayer.getSound("cancel").play(1f, 7f);
                }
            } else
                AudioPlayer.getSound("cancel").play(1f, 7f);
        }
        
        //fill health
        if(mouseOver(mouseX, mouseY, 400, 540, 280, 50)){
            if(hud.getScore() >= refillCost){
                hud.setScore(hud.getScore() - refillCost);
                hud.health = hud.maxHealth;
                refillCost += 500;
            } else {
                    AudioPlayer.getSound("cancel").play(1f, 7f);
            }
        }
        
        //back button
        if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
            Game.gameState = Game.STATE.Game;
            }
        }
    }
    
    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if(mouseX > x && mouseX < x + width){
            if(mouseY > y && mouseY < y + height){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

}

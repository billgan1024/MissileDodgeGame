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
public class Skills extends MouseAdapter {
    
    private Handler handler;
    private HUD hud;
    
    public Skills(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void render(Graphics g){
        Font font = new Font("Calibri", Font.BOLD, 60);
        Font font2 = new Font("Foo", Font.PLAIN, 38);
        Font foo = new Font("Foo", Font.PLAIN, 32);
        
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString("Skills", 465, 100);
    }
    
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
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

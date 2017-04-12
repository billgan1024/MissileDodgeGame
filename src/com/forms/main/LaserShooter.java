package com.forms.main;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Bill Gan
 */
public class LaserShooter extends GameObject {

    public LaserShooter(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        
    }

    public void render(Graphics g) {
        
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 64, 64);
    }

}

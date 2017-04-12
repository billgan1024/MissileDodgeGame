package com.forms.main;

import java.awt.image.BufferedImage;

/**
 *
 * @author Bill Gan
 */
public class SpriteSheet {
    
    private BufferedImage sprite;
    
    public SpriteSheet(BufferedImage image){
        this.sprite = image;
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = sprite.getSubimage((col * width) - width, (row * height) - height, width, height);
        return img;
    }

}

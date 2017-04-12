package com.forms.main;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Bill Gan
 */
public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public int speed = 6;
    public int damage = 50;
    
    public void tick(){
        try{
            if(object.size() > 0){
                for(int i = 0; i < object.size(); i++){
                    GameObject tempObject = object.get(i);
            
                    tempObject.tick();
                }
            }
        } catch(Exception e){
            
        }
    }
    
    public void render(Graphics g){
        try{
            if(object.size() > 0){
                for(int i = 0; i < object.size(); i++){
                GameObject tempObject = object.get(i);
            
                tempObject.render(g);
                }
            }
        } catch(Exception e){
            
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    public void clearParticles(){
        for(int i = 0; i < object.size(); i++){
            
            object.removeFirst();
            object.removeLast();
        }
    }
    
    public void clearEnemies(){
        while(!object.isEmpty()){
            GameObject tempObject = object.getLast();
            if(tempObject.getId() != ID.Player && tempObject.getId() != ID.Player2){
                removeObject(tempObject);
            }
            if(object.size() == 2 && object.getFirst().getId() == ID.Player && object.getLast().getId() == ID.Player2)
                break;
            else if(object.size() == 1 && object.getFirst().getId() == ID.Player)
                break;
        }
    }
    
    public void clearEntities(){
        while(!object.isEmpty()){
            object.removeLast();
        }
    }
    
    
    public void clearPlayer1(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            if(tempObject.getId() == ID.Player){
                removeObject(tempObject);
            }
        }
    }
    
    public void clearPlayer2(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            if(tempObject.getId() == ID.Player2){
                removeObject(tempObject);
            }
        }
    }

}

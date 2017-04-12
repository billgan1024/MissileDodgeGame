package com.forms.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Bill Gan
 */
public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    private boolean[] keyDown = new boolean[8];
    private boolean canFire = true;
    
    private Game game;
    
    public KeyInput(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
        keyDown[4] = false;
        keyDown[5] = false;
        keyDown[6] = false;
        keyDown[7] = false;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //System.out.println(key);
        if(handler.object != null){
            for(int i = 0; i < handler.object.size(); i++){
                GameObject tempObject = handler.object.get(i);
            
                if(tempObject.getId() == ID.Player){
                    //key events for player 1
                    if(key == KeyEvent.VK_UP){
                        tempObject.setVelY(-handler.speed);
                        keyDown[0] = true;
                    }
                    if(key == KeyEvent.VK_DOWN){
                        tempObject.setVelY(handler.speed);
                        keyDown[1] = true;
                    }
                    if(key == KeyEvent.VK_LEFT){
                        tempObject.setVelX(-handler.speed);
                        keyDown[2] = true;
                    }
                    if(key == KeyEvent.VK_RIGHT){
                        tempObject.setVelX(handler.speed);
                        keyDown[3] = true;
                    }
                    if(Menu.isSinglePlayer){
                        if(key == KeyEvent.VK_SPACE){
                            if(canFire){
                            handler.addObject(new PlayerBullet(tempObject.getX() + 25, tempObject.getY() + 12, ID.PlayerBullet, handler, 15, 0));
                            AudioPlayer.getSound("click").play(1f, 2f);
                            canFire = false;
                            }
                        }
                    }
                }
            
                if(tempObject.getId() == ID.Player2){
                    //key events for player 2
                    if(key == KeyEvent.VK_W){
                        tempObject.setVelY(-handler.speed);
                        keyDown[4] = true;
                    }
                    if(key == KeyEvent.VK_S){
                        tempObject.setVelY(handler.speed);
                        keyDown[5] = true;
                    }
                    if(key == KeyEvent.VK_A){
                        tempObject.setVelX(-handler.speed);
                        keyDown[6] = true;
                    }
                    if(key == KeyEvent.VK_D){
                        tempObject.setVelX(handler.speed);
                        keyDown[7] = true;
                    }
                }
            }
        }
        
        if(key == KeyEvent.VK_ESCAPE){
            if(game.gameState == Game.STATE.Game){
            if(Game.paused)
                Game.paused = false;
            else
                Game.paused = true;
            }
        }
        
        if(key == KeyEvent.VK_SPACE){
            if(!Menu.isSinglePlayer){
                if(Game.gameState == Game.STATE.Game)
                    Game.gameState = Game.STATE.Shop;
                else if(Game.gameState == Game.STATE.Shop)
                    Game.gameState = Game.STATE.Game;
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for player 1
                if(key == KeyEvent.VK_UP){
                    tempObject.setVelY(0);
                    keyDown[0] = false;
                }
                if(key == KeyEvent.VK_DOWN){
                    tempObject.setVelY(0);
                    keyDown[1] = false;
                }
                if(key == KeyEvent.VK_LEFT){
                    tempObject.setVelX(0);
                    keyDown[2] = false;
                }
                if(key == KeyEvent.VK_RIGHT){
                    tempObject.setVelX(0);
                    keyDown[3] = false;
                }
                if(key == KeyEvent.VK_SPACE){
                    canFire = true;
                }
                //more responsive key controls
                if(keyDown[2] && !keyDown[3])
                    tempObject.setVelX(-handler.speed);
                if(!keyDown[2] && keyDown[3])
                    tempObject.setVelX(handler.speed);
                if(!keyDown[2] && !keyDown[3])
                    tempObject.setVelX(0);
                if(keyDown[0] && !keyDown[1])
                    tempObject.setVelY(-handler.speed);
                if(!keyDown[0] && keyDown[1])
                    tempObject.setVelY(handler.speed);
                if(!keyDown[0] && !keyDown[1])
                    tempObject.setVelY(0);
            }
            
            if(tempObject.getId() == ID.Player2){
                //key events for player 2
                if(key == KeyEvent.VK_W){
                    tempObject.setVelY(0);
                    keyDown[4] = false;
                }
                if(key == KeyEvent.VK_S){
                    tempObject.setVelY(0);
                    keyDown[5] = false;
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(0);
                    keyDown[6] = false;
                }
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(0);
                    keyDown[7] = false;
                }
                //more responsive key controls
                if(keyDown[6] && !keyDown[7])
                    tempObject.setVelX(-handler.speed);
                if(!keyDown[6] && keyDown[7])
                    tempObject.setVelX(handler.speed);
                if(!keyDown[6] && !keyDown[7])
                    tempObject.setVelX(0);
                if(keyDown[4] && !keyDown[5])
                    tempObject.setVelY(-handler.speed);
                if(!keyDown[4] && keyDown[5])
                    tempObject.setVelY(handler.speed);
                if(!keyDown[4] && !keyDown[5])
                    tempObject.setVelY(0);
            }
        }
    }
    
    public void tick(){
        
    }

}

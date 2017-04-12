package com.forms.main;

import com.forms.main.Game.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import org.lwjgl.openal.AL;

/**
 *
 * @author Bill Gan
 */
public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
    private int counter;
    private SpriteSheet spritesheet;
    
    public static BufferedImage playerimage;
    public static BufferedImage white;
    public static BufferedImage red;
    public static BufferedImage blue;
    public static BufferedImage green;
    public static BufferedImage yellow;
    public static BufferedImage orange;
    public static BufferedImage purple;
    public static BufferedImage lightblue;
    public static BufferedImage creeper;
    public static BufferedImage rainbow;
    public static BufferedImage target;
    public static BufferedImage colorpixel;
    public static BufferedImage bluewhite;
    public static boolean is2player = false;
    public static boolean isSinglePlayer = false;
    private boolean hasPlayed = false;
    
    private Random r = new Random();
    
    private Color menuButton1 = Color.white;
    private Color menuButton2 = Color.white;
    private Color menuButton3 = Color.white;
    private Color menuButton4 = Color.white;
    
    private Color selectButton1 = Color.white;
    private Color selectButton2 = Color.white;
    private Color selectButton3 = Color.white;
    private Color selectButton4 = Color.white;
    private Color selectButton5 = Color.white;
    private Color selectButton6 = Color.white;
    
    private Color helpButton1 = Color.white;
    
    private boolean buttonPlayed[] = new boolean[20];
    
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        
        spritesheet = new SpriteSheet(Game.spritesheet);
        buttonPlayed[0] = false;
        buttonPlayed[1] = false;
        buttonPlayed[2] = false;
        buttonPlayed[3] = false;
        buttonPlayed[4] = false;
        buttonPlayed[5] = false;
        buttonPlayed[6] = false;
        buttonPlayed[7] = false;
        buttonPlayed[8] = false;
        buttonPlayed[9] = false;
        buttonPlayed[10] = false;
    }
    
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        //MAIN MENU
        if(game.gameState == STATE.Menu){
            //play button code
            if(mouseOver(mouseX, mouseY, 400, 300, 280, 50)){
                menuButton1 = Color.white;
                menuButton2 = Color.white;
                menuButton3 = Color.white;
                menuButton4 = Color.white;
                game.gameState = STATE.Select;
            
                AudioPlayer.getSound("click3").play(1f, 2f);
                return;
            }
            
            //help button code
            if(mouseOver(mouseX, mouseY, 400, 360, 280, 50)){
                menuButton1 = Color.white;
                menuButton2 = Color.white;
                menuButton3 = Color.white;
                menuButton4 = Color.white;
                game.gameState = STATE.Help;
            
                AudioPlayer.getSound("click3").play(1f, 2f);
                return;
            }
            
            //home base button code
            if(mouseOver(mouseX, mouseY, 400, 420, 280, 50)){
                menuButton1 = Color.white;
                menuButton2 = Color.white;
                menuButton3 = Color.white;
                menuButton4 = Color.white;
                game.gameState = STATE.Base;
            
                AudioPlayer.getSound("click3").play(1f, 2f);
                return;
            }
            
            //quit button code
            if(mouseOver(mouseX, mouseY, 400, 480, 280, 50)){
                try {
                    Game.playerdata.store(new FileOutputStream(new File("./data/playerdata.properties")), null);
                } catch (IOException i){
                    i.printStackTrace();
                }
                AL.destroy();
                System.exit(0);
            }
        }
        //SELECT GAMEMODE MENU
        if(game.gameState == STATE.Select){
            //normal play button code
            if(mouseOver(mouseX, mouseY, 254, 250, 280, 50)){
                game.gameState = STATE.Game;
                handler.clearParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 24, Game.HEIGHT / 2 - 48, ID.Player, handler));
                if(is2player){
                    handler.addObject(new Player(Game.WIDTH / 2 - 128, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                }
                handler.addObject(new MissileSpawner(-100, Game.HEIGHT / 2, Direction.LEFT, 5, 50, ID.MissileSpawner, handler));
                
                game.difficulty = 0;
            
                AudioPlayer.getSound("click").play(1f, 2f);
                return;
            }
            
            //hard play button code
            if(mouseOver(mouseX, mouseY, 546, 250, 280, 50)){
                game.gameState = STATE.Game;
                handler.clearParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 24, Game.HEIGHT / 2 - 48, ID.Player, handler));
                if(is2player){
                    handler.addObject(new Player(Game.WIDTH / 2 - 128, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                }
                handler.addObject(new MissileSpawner(1180, Game.HEIGHT / 2, Direction.RIGHT, -7, r.nextInt(20) + 40, ID.MissileSpawner, handler));
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                game.difficulty = 1;
                
                AudioPlayer.getSound("click").play(1f, 2f);
                return;
            }
            
            //insane play button code
            if(mouseOver(mouseX, mouseY, 254, 310, 280, 50)){
                game.gameState = STATE.Game;
                handler.clearParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 24, Game.HEIGHT / 2 - 48, ID.Player, handler));
                if(is2player){
                    handler.addObject(new Player(Game.WIDTH / 2 - 128, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                }
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                
                game.difficulty = 2;
            
                AudioPlayer.getSound("click").play(1f, 2f);
                return;
            }
            
            //impossible play button code
            if(mouseOver(mouseX, mouseY, 546, 310, 280, 50)){
                game.gameState = STATE.Game;
                handler.clearParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 24, Game.HEIGHT / 2 - 48, ID.Player, handler));
                if(is2player){
                    handler.addObject(new Player(Game.WIDTH / 2 - 128, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                }
                handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, 5, 40, ID.MissileSpawner, handler));
                handler.addObject(new MissileSpawner(1180, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, -6, 50, ID.MissileSpawner, handler));
                
                game.difficulty = 3;
                
                AudioPlayer.getSound("click").play(1f, 2f);
                return;
            }
            
            //2-player button code
            if(mouseOver(mouseX, mouseY, 254, 370, 280, 50)){
                if(!is2player){
                    is2player = true;
                    AudioPlayer.getSound("click4").play(1.05f, 0.5f);
                }
                else
                    is2player = false;
                return;
            }
            
            //spc button mode
            if(mouseOver(mouseX, mouseY, 546, 370, 280, 50)){
                selectButton1 = Color.white;
                selectButton2 = Color.white;
                selectButton3 = Color.white;
                selectButton4 = Color.white;
                selectButton5 = Color.white;
                selectButton6 = Color.white;
                game.gameState = STATE.SPCWorld1;
                isSinglePlayer = true;
                
                AudioPlayer.getSound("click3").play(1f, 2f);
                return;
            }
            
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                selectButton1 = Color.white;
                selectButton2 = Color.white;
                selectButton3 = Color.white;
                selectButton4 = Color.white;
                selectButton5 = Color.white;
                selectButton6 = Color.white;
                game.gameState = STATE.Menu;
                
                AudioPlayer.getSound("click2").play(1f, 2f);
                return;
            }
        }
        
        //HELP MENU
        if(game.gameState == STATE.Help){
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 560, 280, 50)){
                game.gameState = STATE.Menu;
                
                AudioPlayer.getSound("click2").play(1f, 2f);
                return;
            }
        }
        
        //HOME BASE MENU
        if(game.gameState == STATE.Base){
            
            //white button
            if(mouseOver(mouseX, mouseY, 550, 240, 48, 48)){
                Game.imageColInt = 1;
                Game.imageRowInt = 1;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //red button
            if(mouseOver(mouseX, mouseY, 618, 240, 48, 48)){
                Game.imageColInt = 2;
                Game.imageRowInt = 1;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //blue button
            if(mouseOver(mouseX, mouseY, 686, 240, 48, 48)){
                Game.imageColInt = 3;
                Game.imageRowInt = 1;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //green button
            if(mouseOver(mouseX, mouseY, 754, 240, 48, 48)){
                Game.imageColInt = 4;
                Game.imageRowInt = 1;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //yellow button
            if(mouseOver(mouseX, mouseY, 822, 240, 48, 48)){
                Game.imageColInt = 1;
                Game.imageRowInt = 2;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //orange button
            if(mouseOver(mouseX, mouseY, 890, 240, 48, 48)){
                Game.imageColInt = 2;
                Game.imageRowInt = 2;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //purple button
            if(mouseOver(mouseX, mouseY, 958, 240, 48, 48)){
                Game.imageColInt = 3;
                Game.imageRowInt = 2;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //lightblue button
            if(mouseOver(mouseX, mouseY, 550, 308, 48, 48)){
                Game.imageColInt = 4;
                Game.imageRowInt = 2;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //creeper button
            if(mouseOver(mouseX, mouseY, 618, 308, 48, 48)){
                Game.imageColInt = 1;
                Game.imageRowInt = 3;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //rainbow button
            if(mouseOver(mouseX, mouseY, 686, 308, 48, 48)){
                Game.imageColInt = 2;
                Game.imageRowInt = 3;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //target button
            if(mouseOver(mouseX, mouseY, 754, 308, 48, 48)){
                Game.imageColInt = 3;
                Game.imageRowInt = 3;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //colorpixel button
            if(mouseOver(mouseX, mouseY, 822, 308, 48, 48)){
                Game.imageColInt = 4;
                Game.imageRowInt = 3;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //bluewhite button
            if(mouseOver(mouseX, mouseY, 890, 308, 48, 48)){
                Game.imageColInt = 1;
                Game.imageRowInt = 4;
                AudioPlayer.getSound("click4").play(1.05f, 0.5f);
            }
            
            //credits button code
            if(mouseOver(mouseX, mouseY, 760, 100, 280, 50)){
                game.gameState = STATE.Credits;
                AudioPlayer.getSound("click3").play(1f, 2f);
            }
            
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 660, 280, 50)){
                game.gameState = STATE.Menu;
                
                AudioPlayer.getSound("click2").play(1f, 2f);
                return;
            }
            
            //stats button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                game.gameState = STATE.Stats;
                
                AudioPlayer.getSound("click3").play(1f, 2f);
                return;
            }
            
            Game.playerdata.setProperty(Game.imageCol, new Integer(Game.imageColInt).toString());
            Game.playerdata.setProperty(Game.imageRow, new Integer(Game.imageRowInt).toString());
        }
        
        //CREDITS SCREEN
        if(game.gameState == STATE.Credits){
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                game.gameState = STATE.Base;
                
                AudioPlayer.getSound("click2").play(1f, 2f);
                return;
            }
        }
        
        //STATS SCREEN
        if(game.gameState == STATE.Stats){
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                game.gameState = STATE.Base;
                
                AudioPlayer.getSound("click2").play(1f, 2f);
                return;
            }
        }
        
        //SPC WORLD 1 SCREEN
        if(game.gameState == STATE.SPCWorld1){
            //skills code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                game.gameState = STATE.SPCSkills;
                
                AudioPlayer.getSound("click3").play(1f, 2f);
            }
            
            //level 1 code
            if(mouseOver(mouseX, mouseY, 225, 150, 150, 100)){
                game.gameState = STATE.Game;
                handler.clearParticles();
                handler.addObject(new Player(516, 600, ID.Player, handler));
                game.difficulty = Game.lvl1;
                
                AudioPlayer.getSound("click").play(1f, 2f);
            }
            
            //back button
            if(mouseOver(mouseX, mouseY, 400, 660, 280, 50)){
                game.gameState = STATE.Select;
                isSinglePlayer = false;
                
                AudioPlayer.getSound("click2").play(1f, 2f);
                return;
            }
        }
        
        //GAME OVER SCREEN
        if(game.gameState == STATE.End){
            
            //retry button code
            if(mouseOver(mouseX, mouseY, 400, 400, 280, 50)){
                resetGameVariables();
                handler.clearEntities();
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 24, Game.HEIGHT / 2 - 48, ID.Player, handler));
                if(is2player){
                    handler.addObject(new Player(Game.WIDTH / 2 - 128, Game.HEIGHT / 2 - 32, ID.Player2, handler));
                }
                if(game.difficulty == 0){
                    handler.addObject(new MissileSpawner(-100, Game.HEIGHT / 2, Direction.LEFT, 5, 50, ID.MissileSpawner, handler));
                }else if(game.difficulty == 1){
                    handler.addObject(new MissileSpawner(1180, Game.HEIGHT / 2, Direction.RIGHT, -7, r.nextInt(20) + 40, ID.MissileSpawner, handler));
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }else if(game.difficulty == 2){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }else if(game.difficulty == 3){
                    handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, 5, 40, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1180, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, -6, 50, ID.MissileSpawner, handler));
                }
                
                AudioPlayer.getSound("click").play(1f, 2f);
                return;
            }
            
            //main menu code
            if(mouseOver(mouseX, mouseY, 400, 460, 280, 50)){
                resetGameVariables();
                handler.clearEntities();
                game.gameState = STATE.Menu;
                handler.addObject(new MenuParticle(100, 100, ID.MenuParticle, handler, 204, 0, 0));
                handler.addObject(new MenuParticle(300, 100, ID.MenuParticle, handler, 255, 128, 0));
                handler.addObject(new MenuParticle(500, 100, ID.MenuParticle, handler, 255, 255, 0));
                handler.addObject(new MenuParticle(700, 100, ID.MenuParticle, handler, 0, 204, 0));
                handler.addObject(new MenuParticle(900, 100, ID.MenuParticle, handler, 0, 128, 255));
                handler.addObject(new MenuParticle(100, 620, ID.MenuParticle, handler, 0, 0, 153));
                handler.addObject(new MenuParticle(300, 620, ID.MenuParticle, handler, 255, 51, 255));
                handler.addObject(new MenuParticle(500, 620, ID.MenuParticle, handler, 102, 0, 204));
                handler.addObject(new MenuParticle(700, 620, ID.MenuParticle, handler, 255, 0, 127));
                handler.addObject(new MenuParticle(900, 620, ID.MenuParticle, handler, 51, 255, 153));
                
                AudioPlayer.getSound("click").play(1f, 2f);
                return;
            }
        }
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public void mouseMoved(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        //MAIN MENU
        if(game.gameState == STATE.Menu){
            //play button code
            if(mouseOver(mouseX, mouseY, 400, 300, 280, 50)){
                menuButton1 = Color.orange;
                if(!buttonPlayed[0]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[0] = true;
                }
            } else {
                menuButton1 = Color.white;
                if(buttonPlayed[0]){
                    buttonPlayed[0] = false;
                }
            }
            
            //help button code
            if(mouseOver(mouseX, mouseY, 400, 360, 280, 50)){
                menuButton2 = Color.orange;
                if(!buttonPlayed[1]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[1] = true;
                }
            } else {
                menuButton2 = Color.white;
                if(buttonPlayed[1]){
                    buttonPlayed[1] = false;
                }
            }
            
            //home base button code
            if(mouseOver(mouseX, mouseY, 400, 420, 280, 50)){
                menuButton3 = Color.orange;
                if(!buttonPlayed[2]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[2] = true;
                }
            } else {
                menuButton3 = Color.white;
                if(buttonPlayed[2]){
                    buttonPlayed[2] = false;
                }
            }
            
            //quit button code
            if(mouseOver(mouseX, mouseY, 400, 480, 280, 50)){
                menuButton4 = Color.orange;
                if(!buttonPlayed[3]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[3] = true;
                }
            } else {
                menuButton4 = Color.white;
                if(buttonPlayed[3]){
                    buttonPlayed[3] = false;
                }
            }
        }
        //SELECT GAMEMODE MENU
        if(game.gameState == STATE.Select){
            //normal play button code
            if(mouseOver(mouseX, mouseY, 254, 250, 280, 50)){
                selectButton1 = Color.orange;
                if(!buttonPlayed[4]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[4] = true;
                }
            } else {
                selectButton1 = Color.white;
                if(buttonPlayed[4]){
                    buttonPlayed[4] = false;
                }
            }
            
            //hard play button code
            if(mouseOver(mouseX, mouseY, 546, 250, 280, 50)){
                selectButton2 = Color.orange;
                if(!buttonPlayed[5]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[5] = true;
                }
            } else {
                selectButton2 = Color.white;
                if(buttonPlayed[5]){
                    buttonPlayed[5] = false;
                }
            }
            
            //insane play button code
            if(mouseOver(mouseX, mouseY, 254, 310, 280, 50)){
                selectButton3 = Color.orange;
                if(!buttonPlayed[6]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[6] = true;
                }
            } else {
                selectButton3 = Color.white;
                if(buttonPlayed[6]){
                    buttonPlayed[6] = false;
                }
            }
            
            //impossible play button code
            if(mouseOver(mouseX, mouseY, 546, 310, 280, 50)){
                selectButton4 = Color.orange;
                if(!buttonPlayed[7]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[7] = true;
                }
            } else {
                selectButton4 = Color.white;
                if(buttonPlayed[7]){
                    buttonPlayed[7] = false;
                }
            }
            
            //2-player button code
            if(mouseOver(mouseX, mouseY, 254, 370, 280, 50)){
                return;
            }
            
            //spc button mode
            if(mouseOver(mouseX, mouseY, 546, 370, 280, 50)){
                selectButton5 = Color.orange;
                if(!buttonPlayed[8]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[8] = true;
                }
            } else {
                selectButton5 = Color.white;
                if(buttonPlayed[8]){
                    buttonPlayed[8] = false;
                }
            }
            
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                selectButton6 = Color.orange;
                if(!buttonPlayed[9]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[9] = true;
                }
            } else {
                selectButton6 = Color.white;
                if(buttonPlayed[9]){
                    buttonPlayed[9] = false;
                }
            }
        }
        
        //HELP MENU
        if(game.gameState == STATE.Help){
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 560, 280, 50)){
                helpButton1 = Color.orange;
                if(!buttonPlayed[10]){
                    AudioPlayer.getSound("hover").play(1f, 1.2f);
                    buttonPlayed[10] = true;
                }
            } else {
                helpButton1 = Color.white;
                if(buttonPlayed[10]){
                    buttonPlayed[10] = false;
                }
            }
        }
        
        //HOME BASE MENU
        if(game.gameState == STATE.Base){
            
            //white button
            if(mouseOver(mouseX, mouseY, 550, 240, 48, 48)){
                
            }
            
            //red button
            if(mouseOver(mouseX, mouseY, 618, 240, 48, 48)){
                
            }
            
            //blue button
            if(mouseOver(mouseX, mouseY, 686, 240, 48, 48)){
                
            }
            
            //green button
            if(mouseOver(mouseX, mouseY, 754, 240, 48, 48)){
                
            }
            
            //yellow button
            if(mouseOver(mouseX, mouseY, 822, 240, 48, 48)){
                
            }
            
            //orange button
            if(mouseOver(mouseX, mouseY, 890, 240, 48, 48)){
                
            }
            
            //purple button
            if(mouseOver(mouseX, mouseY, 958, 240, 48, 48)){
                
            }
            
            //lightblue button
            if(mouseOver(mouseX, mouseY, 550, 308, 48, 48)){
                
            }
            
            //creeper button
            if(mouseOver(mouseX, mouseY, 618, 308, 48, 48)){
                
            }
            
            //rainbow button
            if(mouseOver(mouseX, mouseY, 686, 308, 48, 48)){
                
            }
            
            //target button
            if(mouseOver(mouseX, mouseY, 754, 308, 48, 48)){
                
            }
            
            //colorpixel button
            if(mouseOver(mouseX, mouseY, 822, 308, 48, 48)){
                
            }
            
            //bluewhite button
            if(mouseOver(mouseX, mouseY, 890, 308, 48, 48)){
                
            }
            
            //credits button code
            if(mouseOver(mouseX, mouseY, 760, 100, 280, 50)){
                return;
            }
            
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 660, 280, 50)){
                
                return;
            }
            
            //stats button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                
                return;
            }
            
            Game.playerdata.setProperty(Game.imageCol, new Integer(Game.imageColInt).toString());
            Game.playerdata.setProperty(Game.imageRow, new Integer(Game.imageRowInt).toString());
        }
        
        //CREDITS SCREEN
        if(game.gameState == STATE.Credits){
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                
                return;
            }
        }
        
        //STATS SCREEN
        if(game.gameState == STATE.Stats){
            //back button code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                
                return;
            }
        }
        
        //SPC WORLD 1 SCREEN
        if(game.gameState == STATE.SPCWorld1){
            //skills code
            if(mouseOver(mouseX, mouseY, 400, 600, 280, 50)){
                return;
            }
            
            //level 1 code
            if(mouseOver(mouseX, mouseY, 225, 150, 150, 100)){
                return;
            }
            
            //back button
            if(mouseOver(mouseX, mouseY, 400, 660, 280, 50)){
                
                return;
            }
        }
        
        //GAME OVER SCREEN
        if(game.gameState == STATE.End){
            
            //retry button code
            if(mouseOver(mouseX, mouseY, 400, 400, 280, 50)){
                
                return;
            }
            
            //main menu code
            if(mouseOver(mouseX, mouseY, 400, 460, 280, 50)){
                
                return;
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
    
    public void tick(){
        counter++;
    }
    
    public void render(Graphics g){
        if(game.gameState == STATE.Menu){
            Font font = new Font("Calibri", Font.BOLD, 60);
            Font font2 = new Font("Calibri", Font.BOLD, 36);
            Font font3 = new Font("Calibri", Font.BOLD, 28);
            Font foo = new Font("Foo", Font.PLAIN, 32);
            
            //animating the title(sort of)
            if(counter % 350 >= 0 && counter % 350 <= 49)
                g.drawImage(Game.title, 204, 120, null);
            else if(counter % 350 >= 50 && counter % 350 <= 99)
                g.drawImage(Game.title2, 204, 120, null);
            else if(counter % 350 >= 100 && counter % 350 <= 149)
                g.drawImage(Game.title3, 204, 120, null);
            else if(counter % 350 >= 150 && counter % 350 <= 199)
                g.drawImage(Game.title4, 204, 120, null);
            else if(counter % 350 >= 200 && counter % 350 <= 249)
                g.drawImage(Game.title5, 204, 120, null);
            else if(counter % 350 >= 250 && counter % 350 <= 299)
                g.drawImage(Game.title6, 204, 120, null);
            else if(counter % 350 >= 300 && counter % 350 <= 349)
                g.drawImage(Game.title7, 204, 120, null);
        
            //play button
            g.setFont(foo);
            g.setColor(menuButton1);
            g.drawRoundRect(400, 300, 280, 50, 20, 20);
            g.drawString("Play" , 503, 337);
            g.setColor(Color.white);
        
            //help button
            g.setColor(menuButton2);
            g.drawRoundRect(400, 360, 280, 50, 20, 20);
            g.drawString("Help", 503, 397);
            g.setColor(Color.white);
        
            //home base button
            g.setColor(menuButton3);
            g.drawRoundRect(400, 420, 280, 50, 20, 20);
            g.drawString("Home Base", 458, 457);
            g.setColor(Color.white);
        
            //quit button
            g.setColor(menuButton4);
            g.drawRoundRect(400, 480, 280, 50, 20, 20);
            g.drawString("Quit", 503, 517);
            g.setColor(Color.white);
            
            //version
            g.setFont(font3);
            g.drawString("Missile Dodge v1.2", 5, 752);
            //company name
            g.drawString("Forms Game Studios Inc. ", 784, 752);
        }else if(game.gameState == STATE.Help){
            Font font = new Font("Calibri", Font.BOLD, 60);
            Font font2 = new Font("Calibri", Font.BOLD, 36);
            Font font3 = new Font("Calibri", Font.BOLD, 32);
            Font foo = new Font("Foo", Font.PLAIN, 32);
            
            g.drawImage(Game.howtoplay, 249, 120, null);
            
            g.setFont(font3);
            g.setColor(Color.white);
            g.drawString("Use the arrow keys to move around the screen and dodge enemies.", 90, 270);
            g.drawString("Your objective is to survive with the highest score possible!", 138, 310);
            g.drawString("You can upgrade your player via the shop in-game with your score.", 95, 350);
            g.drawString("Good luck and have fun! :)", 365, 390);
            
            //back button
            g.setFont(foo);
            g.setColor(helpButton1);
            g.drawRoundRect(400, 560, 280, 50, 20, 20);
            g.drawString("Back", 501, 597);
        }else if(game.gameState == STATE.End){
            Font font = new Font("Calibri", Font.BOLD, 60);
            Font font2 = new Font("Calibri", Font.BOLD, 36);
            
            g.setColor(Color.white);
            g.drawImage(Game.gameover, 270, 120, null);
            
            g.setFont(font2);
            g.drawString("You died!", 473, 260);
            
            g.setFont(font2);
            g.drawString("Score: " + hud.getScore(), 455, 300);
            
            //back button
            g.setFont(font2);
            g.drawRoundRect(400, 400, 280, 50, 20, 20);
            g.drawString("Play Again", 466, 436);
            
            //main menu button
            g.setFont(font2);
            g.drawRoundRect(400, 460, 280, 50, 20, 20);
            g.drawString("Main Menu", 457, 496);
        }else if(game.gameState == STATE.Select){
            Font font = new Font("Calibri", Font.BOLD, 60);
            Font font2 = new Font("Calibri", Font.BOLD, 36);
            Font foo = new Font("Foo", Font.PLAIN, 32);
        
            //title
            g.drawImage(Game.select, 111, 120, null);
        
            //normal button
            g.setFont(foo);
            g.setColor(selectButton1);
            g.drawRoundRect(254, 250, 280, 50, 20, 20);
            g.drawString("Normal", 338, 288);
            g.setColor(Color.white);
        
            //hard button
            g.setColor(selectButton2);
            g.drawRoundRect(546, 250, 280, 50, 20, 20);
            g.drawString("Hard", 649, 288);
            g.setColor(Color.white);
        
            //insane button
            g.setColor(selectButton3);
            g.drawRoundRect(254, 310, 280, 50, 20, 20);
            g.drawString("Insane", 347, 348);
            g.setColor(Color.white);
        
            //impossible button
            g.setColor(selectButton4);
            g.drawRoundRect(546, 310, 280, 50, 20, 20);
            g.drawString("Impossible", 606, 348);
            g.setColor(Color.white);
            
            //2player button
            if(is2player)
                g.setColor(Color.orange);
            else
                g.setColor(Color.white);
            g.drawRoundRect(254, 370, 280, 50, 20, 20);
            g.drawString("2-Player", 318, 408);
            
            //singleplayer button
            g.setColor(selectButton5);
            g.drawRoundRect(546, 370, 280, 50, 20, 20);
            g.drawString("Singleplayer", 584, 408);
            g.setColor(Color.white);
            
            //back button
            g.setColor(selectButton6);
            g.drawRoundRect(400, 600, 280, 50, 20, 20);
            g.drawString("Back", 501, 637);
            g.setColor(Color.white);
        }else if(game.gameState == STATE.Base){
            Font font = new Font("Calibri", Font.BOLD, 60);
            Font font2 = new Font("Foo", Font.PLAIN, 38);
            Font foo = new Font("Foo", Font.PLAIN, 32);
            
            g.drawImage(Game.base, 418, 60, null);
            
            //highscores
            g.setColor(Color.white);
            g.setFont(font2);
            g.drawRoundRect(15, 100, 300, 500, 20, 20);
            g.drawString("Highscores", 56, 145);
            
            //statistics
            g.setColor(Color.white);
            g.setFont(foo);
            g.drawRoundRect(400, 600, 280, 50, 20, 20);
            g.drawString("Stats", 499, 637);
            
            //customize player
            g.setFont(font2);
            g.drawString("Customize Player", 528, 210);
            g.drawRoundRect(330, 220, 730, 300, 20, 20);
            
            //player
            playerimage = spritesheet.grabImage(Game.imageColInt, Game.imageRowInt, 48, 48);
            g.drawImage(playerimage, 420, 340, null);
            
            //all the buttons
            white = spritesheet.grabImage(1, 1, 48, 48);
            g.drawImage(white, 550, 240, null);
            red = spritesheet.grabImage(2, 1, 48, 48);
            g.drawImage(red, 618, 240, null);
            blue = spritesheet.grabImage(3, 1, 48, 48);
            g.drawImage(blue, 686, 240, null);
            green = spritesheet.grabImage(4, 1, 48, 48);
            g.drawImage(green, 754, 240, null);
            yellow = spritesheet.grabImage(1, 2, 48, 48);
            g.drawImage(yellow, 822, 240, null);
            orange = spritesheet.grabImage(2, 2, 48, 48);
            g.drawImage(orange, 890, 240, null);
            purple = spritesheet.grabImage(3, 2, 48, 48);
            g.drawImage(purple, 958, 240, null);
            lightblue = spritesheet.grabImage(4, 2, 48, 48);
            g.drawImage(lightblue, 550, 308, null);
            creeper = spritesheet.grabImage(1, 3, 48, 48);
            g.drawImage(creeper, 618, 308, null);
            rainbow = spritesheet.grabImage(2, 3, 48, 48);
            g.drawImage(rainbow, 686, 308, null);
            target = spritesheet.grabImage(3, 3, 48, 48);
            g.drawImage(target, 754, 308, null);
            colorpixel = spritesheet.grabImage(4, 3, 48, 48);
            g.drawImage(colorpixel, 822, 308, null);
            bluewhite = spritesheet.grabImage(1, 4, 48, 48);
            g.drawImage(bluewhite, 890, 308, null);
            
            //credits button
            g.setFont(foo);
            g.drawRoundRect(760, 100, 280, 50, 20, 20);
            g.drawString("Credits", 840, 137);
            
            //back button
            g.setFont(foo);
            g.setColor(Color.white);
            g.drawRoundRect(400, 660, 280, 50, 20, 20);
            g.drawString("Back", 501, 697);
        }else if(game.gameState == STATE.Credits){
            Font foo = new Font("Foo", Font.PLAIN, 32);
            Font font = new Font("Calibri", Font.BOLD, 36);
            
            //credits image
            g.drawImage(Game.credits, 350, 60, null);
            
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("Coded by: Bill Gan (pblpbl)", 342, 230);
            g.drawString("© 2016 Forms Game Studios Inc. All rights reserved.", 156, 295);
            
            //back button
            g.setFont(foo);
            g.setColor(Color.white);
            g.drawRoundRect(400, 600, 280, 50, 20, 20);
            g.drawString("Back", 501, 637);
        }else if(game.gameState == STATE.Stats){
            Font foo = new Font("Foo", Font.PLAIN, 32);
            Font font = new Font("Calibri", Font.BOLD, 36);
            
            //stats image
            g.drawImage(Game.stats, 320, 60, null);
            
            //games played
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("Total Games Played: " + Game.gamesPlayedInt, 374, 220);
            
            //back button
            g.setFont(foo);
            g.setColor(Color.white);
            g.drawRoundRect(400, 600, 280, 50, 20, 20);
            g.drawString("Back", 501, 637);
        }else if(game.gameState == STATE.SPCWorld1){
            Font foo = new Font("Foo", Font.PLAIN, 32);
            Font font = new Font("Calibri", Font.BOLD, 48);
            
            //world 1
            g.drawImage(Game.world1, 355, 20, null);
            
            //all the level buttons
            //lvl1
            g.setColor(Color.white);
            g.setFont(font);
            g.drawRoundRect(225, 150, 150, 100, 20, 20);
            g.drawString("1", 288, 214);
            //lvl2
            g.setColor(Color.white);
            g.setFont(font);
            g.drawRoundRect(385, 150, 150, 100, 20, 20);
            g.drawString("2", 448, 214);
            //lvl3
            g.setColor(Color.white);
            g.setFont(font);
            g.drawRoundRect(545, 150, 150, 100, 20, 20);
            g.drawString("3", 608, 214);
            //lvl4
            g.setColor(Color.white);
            g.setFont(font);
            g.drawRoundRect(705, 150, 150, 100, 20, 20);
            g.drawString("4", 768, 214);
            
            //skills button
            g.setFont(foo);
            g.setColor(Color.white);
            g.drawRoundRect(400, 600, 280, 50, 20, 20);
            g.drawString("Skills", 495, 637);
            
            //back button
            g.setFont(foo);
            g.setColor(Color.white);
            g.drawRoundRect(400, 660, 280, 50, 20, 20);
            g.drawString("Back", 501, 697);
        }
    }
    
    public void resetGameVariables(){
        hud.setLevel(1);
        hud.setScore(0);
        Spawner.scoreKeep = 0;
        Spawner.scoreGoal = 700;
        Spawner.counter = 0;
        Shop.maxHealthCost = 1000;
        Shop.regenCost = 1000;
        Shop.speedCost = 1000;
        Shop.speedLevel = 1;
        Shop.maxHealthLevel = 1;
        Shop.regenLevel = 1;
        Shop.speedIncrement = 200;
        Shop.maxHealthIncrement = 200;
        Shop.regenIncrement = 200;
        Shop.refillCost = 1500;
        hud.maxHealth = 300;
        hud.regenTime = 65;
        hud.regen = 1;
        handler.speed = 6;
    }

}

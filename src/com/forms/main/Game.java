package com.forms.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;



/**
 *
 * @author Bill Gan
 */
public class Game extends Canvas implements Runnable {
    
    public static final int WIDTH = 1080, HEIGHT = WIDTH / 4 * 3;
    
    private Thread thread;
    private boolean running = false;
    private Random r;
    public static Properties playerdata = new Properties();
    public static final String imageCol = "imageCol";
    public static final String imageRow = "imageRow";
    public static final String gamesPlayed = "gamesPlayed";
    public static int imageColInt;
    public static int imageRowInt;
    public static int gamesPlayedInt;
    
    static {
        try {
            playerdata.load(new FileInputStream(new File("./data/playerdata.properties")));
            imageColInt = Integer.parseInt(playerdata.getProperty(imageCol));
            imageRowInt = Integer.parseInt(playerdata.getProperty(imageRow));
            gamesPlayedInt = Integer.parseInt(playerdata.getProperty(gamesPlayed));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static boolean paused = false;
    public static int difficulty = 0;
    //0 = normal, 1 = hard, 2 = insane, 3 = impossible
    public static int lvl1 = 4, lvl2 = 5, lvl3 = 6;
    
    public static int Level1 = 0;
    public static int Level2 = 700;
    public static int Level3 = 1500;
    public static int Level4 = 2400;
    public static int Level5 = 3400;
    public static int Level6 = 4500;
    public static int Level7 = 5700;
    public static int Level8 = 7000;
    public static int Level9 = 8400;
    public static int Level10 = 9900;
    public static int Level11 = 11500;
    public static int Level12 = 13200;
    public static int Level13 = 15000;
    
    private Handler handler;
    private Handler backgroundHandler;
    private HUD hud;
    private KeyInput keyInput;
    private Spawner spawner;
    private Menu menu;
    private Shop shop;
    private Skills skills;
    
    public enum STATE {
        Menu,
        Select,
        Help,
        Base,
        Credits,
        Stats,
        SPCWorld1,
        SPCSkills,
        Shop,
        Game,
        End;
    }
    
    public static STATE gameState = STATE.Menu;
    public static BufferedImage spritesheet;
    public static BufferedImage title;
    public static BufferedImage title2;
    public static BufferedImage title3;
    public static BufferedImage title4;
    public static BufferedImage title5;
    public static BufferedImage title6;
    public static BufferedImage title7;
    public static BufferedImage background;
    public static BufferedImage howtoplay;
    public static BufferedImage select;
    public static BufferedImage base;
    public static BufferedImage credits;
    public static BufferedImage gameover;
    public static BufferedImage stats;
    public static BufferedImage world1;
    public static BufferedImage playerlaser;
    public static BufferedImage ship;
    
    public Game(){
        Fonts.addFont(new Fonts("FOO.ttf"));
        BufferedImageLoader loader = new BufferedImageLoader();
        spritesheet = loader.loadImage("resources/spritesheet.png");
        title = loader.loadImage("resources/title.png");
        title2 = loader.loadImage("resources/title2.png");
        title3 = loader.loadImage("resources/title3.png");
        title4 = loader.loadImage("resources/title4.png");
        title5 = loader.loadImage("resources/title5.png");
        title6 = loader.loadImage("resources/title6.png");
        title7 = loader.loadImage("resources/title7.png");
        background = loader.loadImage("resources/background.png");
        howtoplay = loader.loadImage("resources/howtoplay.png");
        select = loader.loadImage("resources/select.png");
        base = loader.loadImage("resources/base.png");
        credits = loader.loadImage("resources/credits.png");
        gameover = loader.loadImage("resources/gameover.png");
        stats = loader.loadImage("resources/statistics.png");
        world1 = loader.loadImage("resources/world1.png");
        playerlaser = loader.loadImage("resources/playerlaser.png");
        ship = loader.loadImage("./resources/enemyship.png");
        
        handler = new Handler();
        backgroundHandler = new Handler();
        hud = new HUD();
        keyInput = new KeyInput(handler, this);
        shop = new Shop(handler, hud);
        menu = new Menu(this, handler, hud);
        skills = new Skills(handler, hud);
        
        this.addKeyListener(keyInput);
        this.addMouseListener(menu);
        this.addMouseMotionListener(menu);
        this.addMouseListener(shop);
        
        AudioPlayer.load();
        AudioPlayer.getMusic("backgroundmusic").loop(1f, 0.1f);
        
        new Window(WIDTH, HEIGHT, "Missile Dodge", this);
        
        spawner = new Spawner(handler,hud, this);
        r = new Random();
        
        if(gameState == STATE.Game){
        handler.addObject(new Player(WIDTH / 2 - 64, HEIGHT / 2 - 64, ID.Player, handler));
        
        handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
        } else if(gameState == STATE.Menu){
            backgroundHandler.addObject(new Background(0, 0, ID.Background, backgroundHandler, Game.background));
            backgroundHandler.addObject(new Background(1024, 0, ID.Background, backgroundHandler, Game.background));
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
        }
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        backgroundHandler.tick();
        
        if(gameState == STATE.Game){
            if(!paused){
                handler.tick();
                hud.tick();
                spawner.tick();
                keyInput.tick();
            
                if(HUD.health <= 0){
                    HUD.health = 300;
                    gameState = STATE.End;
                    handler.clearPlayer1();
                    handler.clearPlayer2();
                    gamesPlayedInt++;
                    Game.playerdata.setProperty(Game.gamesPlayed, new Integer(Game.gamesPlayedInt).toString());
                    AudioPlayer.getSound("fail").play(1f, 0.08f);
                }
            }
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
            menu.tick();
            handler.tick();
        }else if(gameState == STATE.Base || gameState == STATE.Credits || gameState == STATE.SPCWorld1 || gameState == STATE.Stats){
            menu.tick();
        }
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        g.setColor(new Color(0, 0, 12));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        backgroundHandler.render(g);
        
        if(gameState == STATE.Game){
            if(paused){
                g.setFont(font);
                g.setColor(Color.white);
                g.drawString("Paused", 15, 122);
            } else {
                g.setFont(font);
                g.setColor(Color.white);
                g.drawString("[ESC] Pause", 15, 122);
            }
        }
        
        if(gameState == STATE.Game){
            hud.render(g);
            handler.render(g);
        }else if(gameState == STATE.Shop){
            shop.render(g);
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
            handler.render(g);
            menu.render(g);
        }else if(gameState == STATE.Base || gameState == STATE.Credits || gameState == STATE.SPCWorld1 || gameState == STATE.Stats){
            menu.render(g);
        }else if(gameState == STATE.SPCSkills){
            skills.render(g);
        }
        
        g.dispose();
        bs.show();
    }
    
    public static int clamp(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;
    }
    
    public static void main(String[] args) {
        new Game();
    }

}

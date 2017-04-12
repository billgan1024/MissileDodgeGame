package com.forms.main;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Bill Gan
 */
public class Spawner {
    
    private Handler handler;
    private HUD hud;
    private Game game;
    
    public static int scoreKeep = 0;
    public static int scoreGoal = 700;
    public static int counter = 0;
    private Random r = new Random();
    
    public Spawner(Handler handler, HUD hud, Game game){
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }
    
    public void tick(){
        scoreKeep++;
        counter++;
        
        //timed events
        if(game.difficulty == 0){
            if(counter == 7220){
                //VORTEX ALERT
                handler.addObject(new Alert(640, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(440, 6, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 260, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(7, 460, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
            }
            if(counter == 7300)//7300
                createVortex(new Color(0, 204, 0), new Color(255, 51, 51), new Color(0, 128, 255), new Color(255, 255, 51));
            if(counter == 7310){
                //HORIZONTAL ALERT
                handler.addObject(new Alert(1036, 15, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 245, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 475, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 705, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(7, 130, new Color(204, 102, 0), new Color(255, 153, 51), ID.Alert, handler));
                handler.addObject(new Alert(7, 360, new Color(204, 102, 0), new Color(255, 153, 51), ID.Alert, handler));
                handler.addObject(new Alert(7, 590, new Color(204, 102, 0), new Color(255, 153, 51), ID.Alert, handler));
            }
            if(counter == 7390)//7350
                createHorizontalFormation(Color.red, new Color(255, 128, 0));
            if(counter == 8500)
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
            if(counter == 8550)
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
            if(counter == 8600)
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
            if(counter == 8650)
                handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
            if(counter == 8900)
                handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 60, ID.Shooter, handler));
        }else if(game.difficulty == 1){
            if(counter == 6120){
                //VORTEX ALERT
                handler.addObject(new Alert(640, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(440, 6, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 260, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(7, 460, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
            }
            if(counter == 6200)
                createVortex(new Color(0, 204, 0), new Color(255, 51, 51), new Color(0, 128, 255), new Color(255, 255, 51));
            if(counter == 6210){
                //HORIZONTAL ALERT
                handler.addObject(new Alert(1036, 15, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 245, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 475, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 705, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(7, 130, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
                handler.addObject(new Alert(7, 360, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
                handler.addObject(new Alert(7, 590, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
            }
            if(counter == 6290)
                createHorizontalFormation(new Color(255, 0, 127), new Color(0, 255, 128));
            if(counter == 6300){
                //VERTICAL ALERT
                handler.addObject(new Alert(180, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(480, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(780, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(30, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
                handler.addObject(new Alert(330, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
                handler.addObject(new Alert(630, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
                handler.addObject(new Alert(930, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
            }
            if(counter == 6380)
                createVerticalFormation(new Color(255, 255, 51), new Color(0, 128, 255));
        }else if(game.difficulty == 2){
            if(counter == 6120){
                handler.addObject(new Alert(1036, 15, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 245, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 475, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 705, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(7, 130, new Color(204, 102, 0), new Color(255, 153, 51), ID.Alert, handler));
                handler.addObject(new Alert(7, 360, new Color(204, 102, 0), new Color(255, 153, 51), ID.Alert, handler));
                handler.addObject(new Alert(7, 590, new Color(204, 102, 0), new Color(255, 153, 51), ID.Alert, handler));
            }
            if(counter == 6200)
                createHorizontalFormation(Color.red, new Color(255, 128, 0));
            if(counter == 6200){
                handler.addObject(new Alert(180, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(480, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(780, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(30, 6, new Color(153, 0, 153), new Color(255, 0, 255), ID.Alert, handler));
                handler.addObject(new Alert(330, 6, new Color(153, 0, 153), new Color(255, 0, 255), ID.Alert, handler));
                handler.addObject(new Alert(630, 6, new Color(153, 0, 153), new Color(255, 0, 255), ID.Alert, handler));
                handler.addObject(new Alert(930, 6, new Color(153, 0, 153), new Color(255, 0, 255), ID.Alert, handler));
            }
            if(counter == 6280)
                createVerticalFormation(new Color(255, 255, 51), new Color(255, 0, 255));
            if(counter == 6720){
                handler.addObject(new Alert(640, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(440, 6, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 260, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(7, 460, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
            }
            if(counter == 6800)
                createVortex(new Color(0, 204, 0), new Color(255, 51, 51), new Color(0, 128, 255), new Color(255, 255, 51));
        }else if(game.difficulty == 3){
            if(counter == 7800){
                handler.clearEnemies();
                handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 42, ID.Shooter, handler));
                handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, r.nextInt(2) + 3, 40, ID.MissileSpawner, handler));
                handler.addObject(new MissileSpawner(1220, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, r.nextInt(2) + 4 * -1, 50, ID.MissileSpawner, handler));
            }
            //VORTEX ALERT
            if(counter == 7920){
                handler.addObject(new Alert(640, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(440, 6, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 260, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(7, 460, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
            }
            if(counter == 8000){
                createVortex(new Color(0, 204, 0), new Color(255, 51, 51), new Color(0, 128, 255), new Color(255, 255, 51));
            }
            if(counter == 8000){
                //HORIZONTAL ALERT
                handler.addObject(new Alert(1036, 15, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 245, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 475, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 705, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(7, 130, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
                handler.addObject(new Alert(7, 360, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
                handler.addObject(new Alert(7, 590, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
            }
            if(counter == 8080){
                createHorizontalFormation(new Color(255, 0, 127), new Color(0, 255, 128));
            }
            if(counter == 8080){
                //VERTICAL ALERT
                handler.addObject(new Alert(180, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(480, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(780, 720, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
                handler.addObject(new Alert(30, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
                handler.addObject(new Alert(330, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
                handler.addObject(new Alert(630, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
                handler.addObject(new Alert(930, 6, new Color(0, 76, 153), new Color(0, 128, 155), ID.Alert, handler));
            }
            if(counter == 8160)
                createVerticalFormation(new Color(255, 255, 51), new Color(0, 128, 255));
            if(counter == 8160){
                //HORIZONTAL ALERT
                handler.addObject(new Alert(1036, 15, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 245, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 475, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(1036, 705, new Color(204, 0, 102), new Color(255, 51, 153), ID.Alert, handler));
                handler.addObject(new Alert(7, 130, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
                handler.addObject(new Alert(7, 360, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
                handler.addObject(new Alert(7, 590, new Color(0, 153, 76), new Color(0, 255, 128), ID.Alert, handler));
            }
            if(counter == 8240){
                createHorizontalFormation(new Color(255, 0, 127), new Color(0, 255, 128));
            }
            if(counter == 8240){
                handler.addObject(new Alert(640, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(440, 6, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 260, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(7, 460, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
            }
            if(counter == 8320){
                createVortex(new Color(0, 204, 0), new Color(255, 51, 51), new Color(0, 128, 255), new Color(255, 255, 51));
            }
            if(counter == 8320){
                //VERTICAL ALERT
                handler.addObject(new Alert(180, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(480, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(780, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(30, 6, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(330, 6, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(630, 6, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(930, 6, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
            }
            if(counter == 8400)
                createVerticalFormation(new Color(0, 255, 0), new Color(51, 153, 255));
            //VORTEX ALERT
            if(counter == 8400){
                handler.addObject(new Alert(640, 720, new Color(0, 153, 0), new Color(0, 255, 0), ID.Alert, handler));
                handler.addObject(new Alert(440, 6, new Color(153, 0, 0), new Color(255, 51, 51), ID.Alert, handler));
                handler.addObject(new Alert(1036, 260, new Color(0, 76, 153), new Color(51, 153, 255), ID.Alert, handler));
                handler.addObject(new Alert(7, 460, new Color(204, 204, 0), new Color(255, 255, 51), ID.Alert, handler));
            }
            if(counter == 8480){
                createVortex(new Color(0, 204, 0), new Color(255, 51, 51), new Color(0, 128, 255), new Color(255, 255, 51));
            }
        }else if(game.difficulty == Game.lvl1){
            if(counter == 200){
                handler.addObject(new Ship(1080, r.nextInt(700) + 50, ID.Ship, handler));
            }
            if(counter == 400){
                handler.addObject(new Ship(1080, r.nextInt(700) + 50, ID.Ship, handler));
            }
            if(counter == 600){
                handler.addObject(new Ship(1080, r.nextInt(700) + 50, ID.Ship, handler));
            }
            if(counter == 800){
                handler.addObject(new Ship(1080, r.nextInt(700) + 50, ID.Ship, handler));
            }
            if(counter == 1000){
                handler.addObject(new Ship(1080, r.nextInt(700) + 50, ID.Ship, handler));
            }
        }
        
        if(scoreKeep >= scoreGoal){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            scoreGoal += 100;
            
            //normal difficulty spawns
            if(game.difficulty == 0){
                if(hud.getLevel() == 2){
                    handler.addObject(new MissileSpawner(1180, Game.HEIGHT / 2, Direction.RIGHT, -7, 50, ID.MissileSpawner, handler));
                }
                if(hud.getLevel() == 3){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }
                if(hud.getLevel() == 4){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }
                if(hud.getLevel() == 5){
                    handler.clearEnemies();
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 50, ID.Shooter, handler));
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }
                if(hud.getLevel() == 6){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }if(hud.getLevel() == 7){
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 50, ID.Shooter, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }if(hud.getLevel() == 8){
                    handler.clearEnemies();
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, -100, Direction.UP, r.nextInt(2) + 5, 50, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, 820, Direction.DOWN, r.nextInt(2) + 5 * -1, 40, ID.MissileSpawner, handler));
                }if(hud.getLevel() == 9){
                    handler.addObject(new MissileSpawner(-100, Game.HEIGHT / 2, Direction.LEFT, 6, 60, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1180, Game.HEIGHT / 2, Direction.RIGHT, -5, 50, ID.MissileSpawner, handler));
                }if(hud.getLevel() == 9){
                    handler.clearEnemies();
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }if(hud.getLevel() == 10){
                    handler.clearEnemies();
                    handler.addObject(new EliteShooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 10, ID.EliteShooter, handler));
                    handler.addObject(new EliteShooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 10, ID.EliteShooter, handler));
                }//hard difficulty spawns
            } else if(game.difficulty == 1){
                if(hud.getLevel() == 2){
                    handler.addObject(new MissileSpawner(-100, Game.HEIGHT / 2, Direction.LEFT, 5, r.nextInt(20) + 40, ID.MissileSpawner, handler));
                }
                if(hud.getLevel() == 3){
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                }
                if(hud.getLevel() == 4){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }
                if(hud.getLevel() == 5){
                    handler.clearEnemies();
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, -100, Direction.UP, r.nextInt(2) + 5, 40, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, 820, Direction.DOWN, r.nextInt(2) + 5 * -1, 54, ID.MissileSpawner, handler));
                }
                if(hud.getLevel() == 6){
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 60, ID.Shooter, handler));
                }if(hud.getLevel() == 7){
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                }if(hud.getLevel() == 8){
                    handler.clearEnemies();
                    handler.addObject(new MissileSpawner(-100, Game.HEIGHT / 2, Direction.LEFT, 6, 60, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1180, Game.HEIGHT / 2, Direction.RIGHT, -5, 50, ID.MissileSpawner, handler));
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 60, ID.Shooter, handler));
                }if(hud.getLevel() == 9){
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 60, ID.Shooter, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }//insane difficulty spawns
            } else if(game.difficulty == 2){
                if(hud.getLevel() == 2){
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, -100, Direction.UP, r.nextInt(2) + 5, 50, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, 820, Direction.DOWN, r.nextInt(2) + 5 * -1, 40, ID.MissileSpawner, handler));
                }
                if(hud.getLevel() == 3){
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                }
                if(hud.getLevel() == 4){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }
                if(hud.getLevel() == 5){
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                }
                if(hud.getLevel() == 6){
                    handler.clearEnemies();
                    handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, r.nextInt(2) + 4, r.nextInt(10) + 45, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1180, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, r.nextInt(2) + 5 * -1, r.nextInt(20) + 50, ID.MissileSpawner, handler));
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 50, ID.Shooter, handler));
                }
                if(hud.getLevel() == 7){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }//impossible difficulty spawns
            } else if(game.difficulty == 3){
                if(hud.getLevel() == 2){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }
                if(hud.getLevel() == 3){
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                }
                if(hud.getLevel() == 4){
                    handler.clearEnemies();
                    //AudioPlayer.getSound("beep").play(1f, 0.7f);
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, -100, Direction.UP, r.nextInt(2) + 5, 50, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(r.nextInt(Game.WIDTH - 200) + 100, 820, Direction.DOWN, r.nextInt(2) + 5 * -1, 40, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, r.nextInt(2) + 4, 40, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1180, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, r.nextInt(2) + 5 * -1, 50, ID.MissileSpawner, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }
                if(hud.getLevel() == 5){
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                }
                if(hud.getLevel() == 6){
                   handler.clearEnemies();
                   handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 60, ID.Shooter, handler));
                   handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 1, 50, ID.Shooter, handler));
                   handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }
                if(hud.getLevel() == 7){
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                }
                if(hud.getLevel() == 8){
                    handler.clearEnemies();
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                    handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, r.nextInt(2) + 3, 40, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1220, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, r.nextInt(2) + 4 * -1, 50, ID.MissileSpawner, handler));
                }
                if(hud.getLevel() == 9){
                    handler.clearEnemies();
                    handler.addObject(new HealthPack(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.HealthPack, handler));
                    handler.addObject(new Shooter(r.nextInt(705)+ 125, r.nextInt(435) + 125, 0, 50, ID.Shooter, handler));
                    handler.addObject(new MissileSpawner(-100, r.nextInt(Game.HEIGHT - 200) + 100, Direction.LEFT, r.nextInt(2) + 5, 40, ID.MissileSpawner, handler));
                    handler.addObject(new MissileSpawner(1190, r.nextInt(Game.HEIGHT - 200) + 100, Direction.RIGHT, r.nextInt(2) + 4 * -1, 50, ID.MissileSpawner, handler));
                }
                if(hud.getLevel() == 10){
                    handler.addObject(new Comet(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Comet, handler));
                    //NEW LASER ENEMY
                }
                if(hud.getLevel() == 11){
                    handler.clearEnemies();
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                    handler.addObject(new Asteroid(r.nextInt(705)+ 125, r.nextInt(435) + 125, ID.Asteroid, handler));
                }
            }
        }
    }
    
    //STREAK FORMATIONS
    public void createVortex(Color up, Color down, Color left, Color right){
        handler.addObject(new Streak(640, 820, Direction.UP, 23, up, ID.Streak, handler));
        handler.addObject(new Streak(440, -100, Direction.DOWN, 23, down, ID.Streak, handler));
        handler.addObject(new Streak(1180, 260, Direction.LEFT, 28, left, ID.Streak, handler));
        handler.addObject(new Streak(-100, 460, Direction.RIGHT, 28, right, ID.Streak, handler));
    }
    
    public void createHorizontalFormation(Color left, Color right){
        handler.addObject(new Streak(1180, 15, Direction.LEFT, 24, left, ID.Streak, handler));
        handler.addObject(new Streak(1180, 245, Direction.LEFT, 24, left, ID.Streak, handler));
        handler.addObject(new Streak(1180, 475, Direction.LEFT, 24, left, ID.Streak, handler));
        handler.addObject(new Streak(1180, 705, Direction.LEFT, 24, left, ID.Streak, handler));
        handler.addObject(new Streak(-100, 130, Direction.RIGHT, 24, right, ID.Streak, handler));
        handler.addObject(new Streak(-100, 360, Direction.RIGHT, 24, right, ID.Streak, handler));
        handler.addObject(new Streak(-100, 590, Direction.RIGHT, 24, right, ID.Streak, handler));
    }
    
    public void createVerticalFormation(Color up, Color down){
        handler.addObject(new Streak(180, 820, Direction.UP, 20, up, ID.Streak, handler));
        handler.addObject(new Streak(480, 820, Direction.UP, 20, up, ID.Streak, handler));
        handler.addObject(new Streak(780, 820, Direction.UP, 20, up, ID.Streak, handler));
        handler.addObject(new Streak(30, -100, Direction.DOWN, 20, down, ID.Streak, handler));
        handler.addObject(new Streak(330, -100, Direction.DOWN, 20, down, ID.Streak, handler));
        handler.addObject(new Streak(630, -100, Direction.DOWN, 20, down, ID.Streak, handler));
        handler.addObject(new Streak(930, -100, Direction.DOWN, 20, down, ID.Streak, handler));
    }

}

package com.forms.main;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author Bill Gan
 */
public class AudioPlayer {
    
    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String, Music> musicMap = new HashMap<String, Music>();
    
    public static void load(){
        try{
            soundMap.put("click", new Sound("./resources/click.ogg"));
            soundMap.put("click2", new Sound("./resources/highDown.ogg"));
            soundMap.put("click3", new Sound("./resources/highUp.ogg"));
            soundMap.put("shoot", new Sound("./resources/shooter.ogg"));
            soundMap.put("beep", new Sound("./resources/beep.ogg"));
            soundMap.put("powerup", new Sound("./resources/powerup.ogg"));
            soundMap.put("cancel", new Sound("./resources/cancel.ogg"));
            soundMap.put("click4", new Sound("./resources/phaserUp6.ogg"));
            soundMap.put("laser2", new Sound("./resources/laser2.ogg"));
            soundMap.put("fail", new Sound("./resources/fail.ogg"));
            soundMap.put("shoot", new Sound("./resources/laser5.ogg"));
            soundMap.put("hit", new Sound("./resources/hit.ogg"));
            soundMap.put("hover", new Sound("./resources/hover.ogg"));
            
            musicMap.put("backgroundmusic", new Music("./resources/backgroundmusic.ogg"));
        } catch (SlickException e){
            e.printStackTrace();
        }
    }
    
    public static Music getMusic(String key){
        return musicMap.get(key);
    }
    
    public static Sound getSound(String key){
        return soundMap.get(key);
    }

}

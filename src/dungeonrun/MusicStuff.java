/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonrun;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Mathias
 */
public class MusicStuff {

    private Clip clip;
    private Clip StopMusic;

    void playMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void stopMusic() {
        clip.stop();
       
        
    }
    void  PlayRain(){
        
        try {
            File musicPath = new File("rainthunder.wav");

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            StopMusic = AudioSystem.getClip();
            StopMusic.open(audioInput);
            StopMusic.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
    void StopRain(){
        StopMusic.stop();
    }

}

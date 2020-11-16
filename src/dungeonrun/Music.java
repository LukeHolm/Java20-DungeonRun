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
 * @author erico
 */
public class Music {
    private Clip Mstop;

    void playMusic(String Location) {

        try {
            File musicPath = new File(Location);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Mstop = AudioSystem.getClip();
            Mstop.open(audioInput);
            Mstop.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void stopMusic() {
        Mstop.stop();
       
        
    }
}

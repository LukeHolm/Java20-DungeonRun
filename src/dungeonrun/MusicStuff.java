/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonrun;

import static dungeonrun.Main.music;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Mathias
 */
public class MusicStuff {

    private Clip clip;
    private Clip StopRain;
    private Clip StopBattle;
    private Clip StopDungeonmusic;
    static String sound;

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

    void PlayRain() {

        try {
            File musicPath = new File("rainthunder.wav");

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            StopRain = AudioSystem.getClip();
            StopRain.open(audioInput);
            StopRain.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void StopRain() {
        StopRain.stop();
    }

    void PlayBattleMusic() {
        try {
            File musicPath = new File("battlemusic.wav");

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            StopBattle = AudioSystem.getClip();
            StopBattle.open(audioInput);
            StopBattle.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void StopBattle() {
        StopBattle.stop();

    }

    void playDungeonmusic() {
        try {

            File musicPath = new File("dungeonmusic.wav");

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            StopDungeonmusic = AudioSystem.getClip();
            StopDungeonmusic.open(audioInput);
            StopDungeonmusic.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void StopDungeonmusic() {
        try {
            StopDungeonmusic.stop();
        } catch (Exception e) {
            return;
        }

    }

    void Random() {
        Random rand = new Random();
        int hitsound = 1 + rand.nextInt(100);
        if (hitsound <= 33) {
            sound = "hit1.wav";

        } else if (hitsound > 33 && hitsound < 66) {

            sound = "hit2.wav";
        } else if (hitsound >= 66 && hitsound < 100) {
            sound = "hit3.wav";
        } else if (hitsound == 100) {
            sound = "easteregghit.wav";
        }
        try {

            File musicPath = new File(sound);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonrun;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Mathias
 */
public class PlayMusic {
        public static void playMusic(String filepath){
        InputStream music;
        try{
            music = new FileInputStream(new File(filepath));
            AudioStream a = new AudioStream(music);
            AudioPlayer.player.start(a);
            
        }
        catch(Exception e){
            System.out.print("Error");
        }
    }
}

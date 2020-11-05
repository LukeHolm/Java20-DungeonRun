package dungeonrun;

import dungeonrun.Monsters.*;

import java.lang.Math;
import java.util.ArrayList;

public class Room {

    protected ArrayList<Monster> monsters = new ArrayList<>();
    // TODO:  protected ArrayList<Treasure> treasures = new ArrayList<>();

    public Room() {

        GiantSpider spiderObj = new GiantSpider();
        int freqPercent = 30; // TODO remove & replace with the code line below
        
        // TODO: use int freqPe3rcent = monsterObj.getFrequencyPercent();
        if (Math.random() < freqPercent / 100.0) { 
            // add a monster to the list
            monsters.add(spiderObj);
        }

        Skeleton monsterObj = new Skeleton();
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() < freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(monsterObj);
        }
        
        Orc orcObj = new Orc();
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() < freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(orcObj);
        }
        
        Troll trollObj = new Troll();
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() < freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(trollObj);
        }
    }

    /*
    public <any> getTreasures() {
        return treasures;
    }
     */
    
    
    public Monster getNextMonster() {
        return monsters.get(0);
    }
    
    // Will be removed 
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

}

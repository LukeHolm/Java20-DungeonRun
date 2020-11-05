package dungeonrun;

import dungeonrun.Monsters.*;

import java.lang.Math;
import java.util.ArrayList;

public class Room {

    protected ArrayList<Monsters> monsters = new ArrayList<>();
    //  protected ArrayList<Treasure> treasures = new ArrayList<>();

    public Room() {

        double d = Math.random();

        GiantSpider spiderObj = new GiantSpider();
        int freqPercent = 20; // TODO replace with the code line below
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() > freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(spiderObj);
        }

        Skeleton monsterObj = new Skeleton();
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() > freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(monsterObj);
        }
        Orc orcObj = new Orc();;
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() > freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(orcObj);
        }
        Troll trollObj = new Troll();
        // TODO: use int freqPercent = monsterObj.getFrequencyPercent();
        if (Math.random() > freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(trollObj);
        }
    }
    /*
    public <any> getMonsters() {
        return monsters;
    }

    public <any> getTreasures() {
        return treasures;
    }
     */
}


package dungeonrun;

import dungeonrun.Monsters.Monsters;

import java.lang.Math;

public class Room {

    protected ArrayList<Monsters> monsters = new ArrayList<>();
    protected ArrayList<Treasure> treasures = new ArrayList<>();

    public Room() {

        double d = Math.random();

        GiantSpider monsterObj = new GiantSpider;
        if (Math.random() > giantSpider.getFrequencyPercent() / 100.0) {
            // add a monster to the list
            monsters.add(monsterObj);
        }

        Skeleton monsterObj = new Skeleton;
        if (Math.random() > monsterObj.getFrequencyPercent() / 100.0) {
            // add a monster to the list
            monsters.add(monsterObj);
        }

        Orc monsterObj = new Orc;
        if (Math.random() > monsterObj.getFrequencyPercent() / 100.0) {
            // add a monster to the list
            monsters.add(monsterObj);
        }
        Troll monsterObj = new Troll;
        if (Math.random() > monsterObj.getFrequencyPercent() / 100.0) {
            // add a monster to the list
            monsters.add(monsterObj);
        }

    }

    public <any> getMonsters() {
        return monsters;
    }

    public <any> getTreasures() {
        return treasures;
    }

}

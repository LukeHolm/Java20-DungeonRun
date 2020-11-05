package dungeonrun;

import dungeonrun.Monsters.*;

import java.lang.Math;
import java.util.ArrayList;

public class Room {

    protected ArrayList<Monster> monsters = new ArrayList<>();
    protected int currentMonsterIndex = 0; // Monsters with lower index are defeated

    // TODO:  protected ArrayList<Treasure> treasures = new ArrayList<>();
    public Room() {

        GiantSpider spiderObj = new GiantSpider();
        int freqPercent = 30; // TODO remove & replace with the code line below

        //  freqPercent = 3
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
        freqPercent = 20;
        if (Math.random() < freqPercent / 100.0) {
            // add a monster to the list
            monsters.add(orcObj);
        }

        Troll trollObj = new Troll();
        freqPercent = 100;
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
 /* Calling getNextMonster several times implies that the earlier monsters are defeated, adn
    *  the next monster is returned.
    *  Returns null when there are no more monsters.
     */
    public Monster getNextMonster() {
        Monster monsterObj;

        if (currentMonsterIndex < monsters.size()) {
            monsterObj = monsters.get(currentMonsterIndex++);
        } else {
            monsterObj = null;
        }
        return monsterObj;
    }

    public void defeatedMonster(Monster deadMonster) {
        
        for (Monster monster : monsters) {
            if (monster.equals(deadMonster)) {
                monsters.remove(deadMonster);
                break;
            }
        }
    }

    // Will be removed 
    public ArrayList<Monster> getMonsters() {

        return monsters;
    }

}

package dungeonrun;

import dungeonrun.Monsters.*;

import java.lang.Math;
import java.util.ArrayList;

public class Room {

    public ArrayList<Monster> monsters = new ArrayList<>();
    // protected int currentMonsterIndex = 0; // Monsters with lower index are defeated

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
    public <any> getNextTreasure() {
        return treasures;
    }
     */
    
    /* Calling getNextMonster several times, returns the next monster, until there are no more and null is returned.
     */
    public Monster getNextMonster() {
        Monster monsterObj;
        if ( monsters.size() > 0) {
            monsterObj = monsters.get(0);
        } else {
            monsterObj = null;
        }
        return monsterObj;
    }
    
      Monster monsterObj = getNextMonster();

    public void defeatedMonster(Monster deadMonster) {
        if (deadMonster == null) {
            System.out.println("defeatedMonster called with null referense");
            System.exit(0);
        }
        for (Monster monster : monsters) {
            if (monster.equals(deadMonster)) {
                monsters.remove(monster);
                break;
            }
        }
    }
    

    // Will be removed 
    public ArrayList<Monster> getMonsters() {

        return monsters;
    }

}

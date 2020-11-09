package dungeonrun;

import dungeonrun.Monsters.*;

import java.lang.Math;
import java.util.ArrayList;

public class Room {

    public ArrayList<Monster> monsters = new ArrayList<>();
    // protected int currentMonsterIndex = 0; // Monsters with lower index are defeated
    // TODO:  public ArrayList<Treasure> treasures = new ArrayList<>();
    
    protected boolean visited; // True when the player has visited this room

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public Room() {

        visited = false;
        
        GiantSpider spider = new GiantSpider();

        if (Math.random() < spider.frequency) {
            // add a monster to the list
            monsters.add(spider);
        }

        Skeleton monster = new Skeleton();
       
        if (Math.random() < monster.frequency) {
            // add a monster to the list
            monsters.add(monster);
        }

        Orc orc = new Orc();
       
        if (Math.random() < orc.frequency) {
            // add a monster to the list
            monsters.add(orc);
        }

        Troll troll = new Troll();
    
        if (Math.random() < troll.frequency) {
            // add the monster to the list
            monsters.add(troll);
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
        Monster firstAliveMonster = null;
        
        for (Monster monster : monsters) {
            if (monster.alive) {
                firstAliveMonster = monster;
                break;
            }
        }
        return firstAliveMonster;
    }
    
    public void defeatedMonster(Monster deadMonster) {
        if (deadMonster == null) {
            System.out.println("defeatedMonster called with null referense");
            System.exit(0);
        } else {
            deadMonster.alive = false;
        }
    } 

    public void draw() {
        
        
        
        
    }
    // Will be removed 
    public ArrayList<Monster> getMonsters() {

        return monsters;
    }
    
    

}

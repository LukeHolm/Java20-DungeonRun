package dungeonrun;

import dungeonrun.Monsters.*;

import java.lang.Math;
import java.util.ArrayList;

public class Room {

    public ArrayList<Monster> monsters = new ArrayList<>();
    public ArrayList<Treasure> treasures = new ArrayList<>();

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
        //Treasure.treasureRoll();

        // TODO: Do this propoperly...
        if (Math.random() < 0.4) {
            treasures.add(new Treasure(2, "Loose coins"));
        }
        if (Math.random() < 0.2) {
            treasures.add(new Treasure(6, "Money Pouch"));
        }
        if (Math.random() < 0.15) {
            treasures.add(new Treasure(10, "Gold Jewelry"));
        }
        if (Math.random() < 0.1) {
            treasures.add(new Treasure(14, "Gemstone"));
        }
        if (Math.random() < 0.05) {
            treasures.add(new Treasure(20, "Small Chest"));
        }
    }

    // Will be getNextMonster will be removed...
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
    // defeatedMonster will be removed...
    public void defeatedMonster(Monster deadMonster) {
        if (deadMonster == null) {
            System.out.println("defeatedMonster called with null referense");
            System.exit(0);
        } else {
            deadMonster.alive = false;
        }
    }

    public void draw() {
        // Handled within Map.draw() now. ASCII-art varinat with a buffer parameter may be coming...
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public ArrayList<Monster> getMonsters() {

        return monsters;
    }
}

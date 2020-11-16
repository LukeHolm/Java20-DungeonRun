package dungeonrun;

import dungeonrun.Characters.Heroes;
import dungeonrun.Monsters.*;
import dungeonrun.Treasures.*;

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

        LooseCoins looseCoins = new LooseCoins();
        if (Math.random() < looseCoins.frequency) {
            treasures.add(looseCoins);
        }
        
        MoneyPouch moneyPouch = new MoneyPouch();
        if (Math.random() < moneyPouch.frequency) {
            treasures.add(moneyPouch);
        }
        
        Jewlery jewlery = new Jewlery();
        if (Math.random() < jewlery.frequency) {
            treasures.add(jewlery);
        }
        
        Gemstone gemstone = new Gemstone();
        if (Math.random() < gemstone.frequency) {
            treasures.add(gemstone);
        }
        
        Chest chest = new Chest();
        if (Math.random() < chest.frequency) {
            treasures.add(chest);
        }
    }

   public void draw(Heroes hero) {

        String spaceAfterHero = "    ";

        // Print the creatures row by row, side by side
        for (int row = 0; row < 21; row++) {

            // Print the hero
            System.out.print(GameLoop.BR_GREEN + hero.displayStrings()[row] + spaceAfterHero); // Print the hero

            // Continue tp print the monsters in the room, on the same row
            for (Monster monster : monsters) {
                System.out.print(GameLoop.BR_RED + monster.displayStrings()[row]);
            }

            // Print all the treasures in the room
            int treasureRow = row - (21 - 10); // Adjust for lower height of the Treasur display
            if (treasureRow >= 0) {
                for (Treasure treasure : treasures) {
                    System.out.print(GameLoop.BR_YELLOW + treasure.displayStrings()[treasureRow] + " ");
                }
            }
            System.out.println("");
        }

        // Print name & info under all of them
        System.out.print(GameLoop.BR_GREEN);  // Green hero
        String underfigure = hero.getClass().getSimpleName() + " " + hero.playersName;
        System.out.printf("%-28s" + spaceAfterHero, underfigure);

        // The monsters in red
        System.out.print(GameLoop.BR_RED);
        for (Monster monster : monsters) {
            underfigure = "      " + monster.getClass().getSimpleName();  // 
            System.out.printf("%-28s", underfigure);
        }

        // The Treasures in yellow
        System.out.print(GameLoop.BR_YELLOW);
        for (Treasure treasure : treasures) {
            underfigure = treasure.name + " " + treasure.value + "$";
            System.out.printf("%-18s ", underfigure);
        }
        System.out.println("");
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public ArrayList<Monster> getMonsters() {

        return monsters;
    }
}

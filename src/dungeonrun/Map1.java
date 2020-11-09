package dungeonrun;

import dungeonrun.Monsters.GiantSpider;
import dungeonrun.Monsters.Monster;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Map1 extends MapStart {

    // Some codes for changing color of the console text
    public static final String RESET = "\033[0;30m";  // RESET the text color
    public static final String RED = "\033[0;31m";          // RED
    public static final String GREEN = "\033[0;32m";        // GREEN
    public static final String YELLOW = "\033[0;33m";       // YELLOW
    public static final String BLUE = "\033[0;34m";         // BLUE
    public static final String PURPLE = "\033[0;35m";       // PURPLE
    public static final String CYAN = "\033[0;36m";         // CYAN
    public static final String WHITE = "\033[0;37m";        // WHITE
    public static final String BR_BLACK = "\u001B[90m";     // BRIGHT BLACK
    public static final String BR_RED = "\u001B[91m";
    public static final String BR_GREEN = "\u001B[92m";
    public static final String BR_YELLOW = "\u001B[93m";
    public static final String BR_BLUE = "\u001B[94m";
    public static final String BR_PURPLE = "\u001B[95m";
    public static final String BR_CYAN = "\u001B[96m";
    public static final String BR_WHITE = "\u001B[97m";
    Scanner input = new Scanner(System.in);
    Room[][] map;

    public Map1(int sizeX, int sizeY) {

        map = new Room[sizeX][sizeY];

        for (int k = 0; k < map.length; k++) {
            for (int l = 0; l < map[k].length; l++) {
                map[k][l] = new Room();
            }
        }
    }

    public void draw() {
        Room currentRoom;
        ArrayList<Monster> monsters;
        boolean firstRoom = true;
        String monsterStr;

        System.out.println("The map with " + RED + "G" + RESET + " = Giant Spider, " + RED + "S" + RESET + " = Skeleton, " + RED + "O" + RESET + " = Orc, " + RED + "T" + RESET + " = Troll:");

        for (int x = 0; x < map.length; x++) {

            // Row 1:
            for (int y = 0; y < map[x].length; y++) {
                System.out.print("+------");
            }
            System.out.println("+");

            // Row 2:
            for (int y = 0; y < map[x].length; y++) {
                // TODO: Handle choosen start corner, now upper left
                if (firstRoom == true) {
                    System.out.print("¦" + GREEN + "Knight" + RESET); // TODO: change
                    firstRoom = false;
                } else {
                    System.out.print("¦      ");
                }

            }
            System.out.println("¦");

            // Row 3:
            for (int y = 0; y < map[x].length; y++) {

                currentRoom = map[x][y];

                monsters = currentRoom.getMonsters();
                monsterStr = "";
                for (Monster monster : monsters) {
                    if (monster.getClass() == dungeonrun.Monsters.GiantSpider.class) {
                        monsterStr += "G";
                    }
                    if (monster.getClass() == dungeonrun.Monsters.Skeleton.class) {
                        monsterStr += "S";
                    }
                    if (monster.getClass() == dungeonrun.Monsters.Orc.class) {
                        monsterStr += "O";
                    }
                    if (monster.getClass() == dungeonrun.Monsters.Troll.class) {
                        monsterStr += "T";
                    }
                }
                System.out.printf("¦ %s%-5s%s", RED, monsterStr, RESET);

            }
            System.out.println("¦");
        } // for x
        // Final row            
        for (int y = 0; y < map[0].length; y++) {
            System.out.print("+------");
        }
        System.out.println("+");
    }
}

// Every room consists of three characters in hight, and 6 characters´wide on the console
// e------+------+------|
// |Knight|Wizard| S    |      |
// | GSOT | S    =      |
// | CMJGS|      |      |
// +--d---+--d---+------|


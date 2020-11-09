package dungeonrun;

import dungeonrun.Monsters.GiantSpider;
import dungeonrun.Monsters.Monster;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Map1 extends MapStart {

    // Some codes for changing color of the console text
    /*   public static final String RESET = "\033[0;30m";  // RESET the text color
    
    public static final String RED = "\033[0;31m";          // RED
    public static final String GREEN = "\033[0;32m";        // GREEN
    public static final String YELLOW = "\033[0;33m";       // YELLOW
    public static final String BLUE = "\033[0;34m";         // BLUE
    public static final String PURPLE = "\033[0;35m";       // PURPLE
    public static final String CYAN = "\033[0;36m";         // CYAN
    public static final String WHITE = "\033[0;37m";        // WHITE
    
    public static final String BG_BLACK = "\u001b[30;1m";     // BRIGHT BLACK
    public static final String BG_RED = "\u001b[31;1m";
    public static final String BG_GREEN = "\u001B[92m";
    public static final String BG_YELLOW = "\u001B[93m";
    public static final String BG_BLUE = "\u001B[94m";
    public static final String BG_PURPLE = "\u001B[95m";
    public static final String BG_CYAN = "\u001B[96m";
    public static final String BG_WHITE = "\u001B[97m";
     */
    public static final String HIGH_INTENSITY = "\u001B[1m";
    public static final String LOW_INTENSITY = "\u001B[2m";

    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLINK = "\u001B[5m";
    public static final String RAPID_BLINK = "\u001B[6m";
    public static final String REVERSE_VIDEO = "\u001B[7m";
    public static final String INVISIBLE_TEXT = "\u001B[8m";

    public static final String BLACK = "\u001b[30m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String MAGENTA = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";
    public static final String WHITE = "\u001b[37m";
    // Bright versions:
    public static final String BR_BLACK = "\u001b[30;1m";
    public static final String BR_RED = "\u001b[31;1m";
    public static final String BR_GREEN = "\u001b[32;1m";
    public static final String BR_YELLOW = "\u001b[33;1m";
    public static final String BR_BLUE = "\u001b[34;1m";
    public static final String BR_MAGENTA = "\u001b[35;1m";
    public static final String BR_CYAN = "\u001b[36;1m";
    public static final String BR_WHITE = "\u001b[37;1m";
    // Background
    public static final String BG_BLACK = "\u001b[40m";
    public static final String BG_RED = "\u001b[41m";
    public static final String BG_GREEN = "\u001b[42m";
    public static final String BG_YELLOW = "\u001b[43m";
    public static final String BG_BLUE = "\u001b[44m";
    public static final String BG_MAGENTA = "\u001b[45m";
    public static final String BG_CYAN = "\u001b[46m";
    public static final String BG_WHITE = "\u001b[47m";
    public static final String RESET = "\u001b[0m";
    public static final String UNDERLINED = "\u001b[4m";

    Scanner input = new Scanner(System.in);
    Room[][] map;

    public Map1() {
    }

    public Map1(int sizeX, int sizeY) {

        map = new Room[sizeX][sizeY];

        for (int k = 0; k < map.length; k++) {
            for (int l = 0; l < map[k].length; l++) {
                map[k][l] = new Room();
            }
        }
    }

    //  public void draw(Character character) {
    public void draw() {
        Room currentRoom;
        ArrayList<Monster> monsters;
        boolean firstRoom = true;
        String monsterStr, treasureStr;
        int alsoCheckX, alsoCheckY;

        System.out.println("The map with " + BR_RED + "G" + RESET + " = Giant Spider, " + BR_RED + "S" + RESET + " = Skeleton, " + BR_RED + "O" + RESET + " = Orc, " + BR_RED + "T" + RESET + " = Troll:");
        System.out.println("Treasures: " + BR_YELLOW + "L" + RESET + " = Loose coins, " + BR_YELLOW + "M" + RESET + " = Money pouch, " + BR_YELLOW
                + "J" + RESET + " = Gold Jewlry, " + BR_YELLOW + "G" + RESET + " = Gemstone, " + BR_YELLOW + "C" + RESET + " = Small Chest:");

        for (int y = 0; y < map[0].length; y++) {
            for (int x = 0; x < map.length; x++) {

                // Row 1:
                if (y > 0) {
                    alsoCheckY = (y - 1);
                } else {
                    alsoCheckY = 0;
                }

                if (map[x][y].isVisited() || map[x][alsoCheckY].isVisited()) {
                    System.out.print("+······");
                } else {
                    System.out.print("+······");
                }
            }
            System.out.println("+");

            // Row 2:
            for (int x = 0; x < map.length; x++) {
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
            for (int x = 0; x < map.length; x++) {

                currentRoom = map[x][y];

                monsters = currentRoom.getMonsters();
                monsterStr = "";
                for (Monster monster : monsters) {

                    monsterStr += (monster.getClass() == dungeonrun.Monsters.GiantSpider.class) ? "G" : "";
                    monsterStr += (monster.getClass() == dungeonrun.Monsters.Skeleton.class) ? "S" : "";
                    monsterStr += (monster.getClass() == dungeonrun.Monsters.Orc.class) ? "O" : "";
                    monsterStr += (monster.getClass() == dungeonrun.Monsters.Troll.class) ? "T" : "";
                }
                System.out.printf("¦%s%.3s%s", BR_RED, monsterStr, RESET);
                
                treasureStr = "";
                // TODO: repalce these fake treasures below with real ones, like The Monsters above
                treasureStr += (Math.random() < 0.4) ? "L" : "";
                treasureStr += (Math.random() < 0.2) ? "M" : "";
                treasureStr += (Math.random() < 0.15) ? "J" : "";
                treasureStr += (Math.random() < 0.1) ? "G" : "";
                treasureStr += (Math.random() < 0.05) ? "C" : "";

                String format = BR_YELLOW + " %" + (5 - monsterStr.length()) + "." + (5 - monsterStr.length()) + "s" + RESET;
                System.out.printf(format,  treasureStr);
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

package dungeonrun;

import dungeonrun.Monsters.GiantSpider;
import dungeonrun.Characters.Heroes;
import dungeonrun.Monsters.Monster;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Map {

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
    public static final String RESET = "\u001b[0m";
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

    Scanner input = new Scanner(System.in);
    public Room[][] rooms;

    public Map(int sizeX, int sizeY, Heroes hero) {

        rooms = new Room[sizeX][sizeY];

        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                rooms[x][y] = new Room();

                // If the hero is standing in tis room -> remove the Monsters & Treasures
                if (x == hero.mapPosX && y == hero.mapPosY) {
                    rooms[x][y].visited = true;
                    rooms[x][y].monsters.clear();   // Remove all monsters
                    rooms[x][y].treasures.clear();  // Remove all treasuress
                }
            }
        }
    }

    //  public void draw(Character character) {
    public void draw(Heroes hero) {
        Room currentRoom;
        ArrayList<Monster> monsters;
        ArrayList<Treasure> treasures;
        String monsterStr, treasureStr;
        int alsoCheckX, alsoCheckY;

        System.out.println("The map with " + BR_RED + "G" + RESET + " = Giant Spider, " + BR_RED + "S" + RESET + " = Skeleton, " + BR_RED + "O" + RESET + " = Orc, " + BR_RED + "T" + RESET + " = Troll:");
        System.out.println("Treasures: " + BR_YELLOW + "L" + RESET + " = Loose coins, " + BR_YELLOW + "M" + RESET + " = Money pouch, " + BR_YELLOW
                + "J" + RESET + " = Gold Jewlry, " + BR_YELLOW + "G" + RESET + " = Gemstone, " + BR_YELLOW + "C" + RESET + " = Small Chest:");

        for (int y = 0; y < rooms[0].length; y++) {

            for (int x = 0; x < rooms.length; x++) {

                // Row 1:
                // Corner +
                System.out.print((rooms[x][y].isVisited() || rooms[x][alsoCheckY(y - 1, rooms)].isVisited()) ? "+------" : CYAN + "+······" + RESET);
            }
            System.out.println((rooms[rooms.length - 1][y].isVisited()) ? "+" : CYAN + "+" + RESET);

            // Row 2:
            for (int x = 0; x < rooms.length; x++) {

                System.out.print((rooms[x][y].isVisited() || rooms[alsoCheckX(x - 1, rooms)][y].isVisited()) ? "|" : CYAN + ":" + RESET);

                if (x == hero.mapPosX && y == hero.mapPosY) {
                    System.out.printf("%s%-6.6s%s", BR_GREEN, hero.getClass().getSimpleName(), RESET);

                } else {
                    monsters = rooms[x][y].getMonsters();
                    monsterStr = "";
                    for (Monster monster : monsters) {

                        monsterStr += (monster.getClass() == dungeonrun.Monsters.GiantSpider.class) ? "G" : "";
                        monsterStr += (monster.getClass() == dungeonrun.Monsters.Skeleton.class) ? "S" : "";
                        monsterStr += (monster.getClass() == dungeonrun.Monsters.Orc.class) ? "O" : "";
                        monsterStr += (monster.getClass() == dungeonrun.Monsters.Troll.class) ? "T" : "";
                    }
                    System.out.printf("%s %-5.5s%s", BR_RED, monsterStr, RESET);
                }
            }
            System.out.println(rooms[rooms.length - 1][y].isVisited() ? "|" : CYAN + ":" + RESET);

            // Row 3:
            for (int x = 0; x < rooms.length; x++) {

                System.out.print((rooms[x][y].isVisited() || rooms[alsoCheckX(x - 1, rooms)][y].isVisited()) ? "|" : CYAN + ":" + RESET);

                if (x == hero.mapPosX && y == hero.mapPosY) {
                    System.out.printf("%s%-6.6s%s", BR_GREEN, hero.playersName, RESET);

                } else {

                    treasures = rooms[x][y].treasures;
                    treasureStr = "";
                    for (Treasure treasure : treasures) {
                        treasureStr += treasure.name.contains("oins") ? "L" : "";
                        treasureStr += treasure.name.contains("oney") ? "M" : "";
                        treasureStr += treasure.name.contains("ewel") ? "J" : "";
                        treasureStr += treasure.name.contains("ston") ? "G" : "";
                        treasureStr += treasure.name.contains("hest") ? "C" : "";
                    }
                    System.out.printf("%s %-5.5s%s", BR_YELLOW, treasureStr, RESET);
                }
            }
            System.out.println(rooms[rooms.length - 1][y].isVisited() ? "|" : CYAN + ":" + RESET);
        } // for x

        // Final row, underneith    
        for (int y = 0; y < rooms[0].length; y++) {
            if (rooms[rooms.length - 1][y].isVisited()) {
                System.out.print("+------");
            } else {
                System.out.print(CYAN + "+······" + RESET);
            }
        }
        System.out.println((rooms[rooms.length - 1][rooms[0].length - 1].isVisited()) ? "+" : CYAN + "+" + RESET);
    }

    int alsoCheckX(int index, Room[][] map) {

        if (index == -1) {
            return 0;
        } else if (index == map.length) {
            return map.length - 1;
        } else {
            return index;
        }
    }

    int alsoCheckY(int index, Room[][] map) {

        if (index == -1) {
            return 0;
        } else if (index == map[0].length) {
            return map[0].length - 1;
        } else {
            return index;
        }
    }

}

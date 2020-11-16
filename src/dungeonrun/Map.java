package dungeonrun;
import dungeonrun.Characters.Heroes;
import dungeonrun.Monsters.Monster;
import dungeonrun.Treasures.Treasure;
import java.util.ArrayList;
public class Map {

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
    public static final String GREY = BR_BLACK;
    public static final String BR_RED = "\u001b[31;1m";
    public static final String BR_GREEN = "\u001b[32;1m";
    public static final String BR_YELLOW = "\u001b[33;1m";
    public static final String BR_BLUE = "\u001b[34;1m";
    public static final String BR_MAGENTA = "\u001b[35;1m";
    public static final String BR_CYAN = "\u001b[36;1m";
    public static final String BR_WHITE = "\u001b[37;1m";
    // Dark versions:
    public static final String D_BLACK = "\u001b[30;2m";
    public static final String D_RED = "\u001b[31;2m";
    public static final String D_GREEN = "\u001b[32;2m";
    public static final String D_YELLOW = "\u001b[33;2m";
    public static final String D_BLUE = "\u001b[34;2m";
    public static final String D_MAGENTA = "\u001b[35;2m";
    public static final String D_CYAN = "\u001b[36;2m";
    public static final String D_WHITE = "\u001b[37;2m";
    // Extra dark(?) version
    public static final String DD_BLACK = "\u001b[30;3m";
    public static final String DD_RED = "\u001b[31;3m";
    public static final String DD_GREEN = "\u001b[32;3m";
    public static final String DD_YELLOW = "\u001b[33;3m";
    public static final String DD_BLUE = "\u001b[34;3m";
    public static final String DD_MAGENTA = "\u001b[35;3m";
    public static final String DD_CYAN = "\u001b[36;3m";
    public static final String DD_WHITE = "\u001b[37;3m";

    // Mapping lower case letters to color code strings, index with "(int)(char - 'a')"
    public static final String[] colorLookup = {
        D_BLUE/*a*/, BR_BLUE/*b*/, BR_CYAN/*c*/, D_CYAN/*d*/,
        BR_BLACK/*e = grey*/, D_WHITE/*f*/, BR_GREEN/*g*/, D_GREEN/*h*/,
        BLINK/*i*/, ""/*j*/, BR_BLACK/*k*/, ""/*l*/,
        BR_MAGENTA/*m*/, D_MAGENTA/*n*/, ""/*o*/, ""/*p*/,
        RESET/*q*/, BR_RED/*r*/, D_RED /*s*/, REVERSE_VIDEO/*t*/,
        UNDERLINE/*u*/, BR_WHITE/*v*/, RESET/*w = white*/, DD_WHITE/*x*/,
        BR_YELLOW/*y*/, D_YELLOW/*z*/};


    public Room[][] rooms;
    public boolean seeAllRooms;

    public Map(int sizeX, int sizeY, Heroes hero) {

        rooms = new Room[sizeX][sizeY];

        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                rooms[x][y] = new Room();

                // Remove Monsters T& Treasures if it's a corner room
                if (isCornerRoom(x, y)) {
                    rooms[x][y].monsters.clear();   // Remove all monsters
                    rooms[x][y].treasures.clear();  // Remove all treasuress
                }
            }
        }
    }

    public boolean hasWestWall(int x, int y) {
        return (x == 0);
    }

    public boolean hasEastWall(int x, int y) {
        return (x == (rooms.length - 1));
    }

    public boolean hasNorthWall(int x, int y) {
        return (y == 0);
    }

    public boolean hasSouthWall(int x, int y) {
        return (y == (rooms[0].length - 1));
    }

    public boolean isCornerRoom(int x, int y) {
        return ((hasWestWall(x, y) && hasNorthWall(x, y)) || (hasNorthWall(x, y) && hasEastWall(x, y))
                || (hasEastWall(x, y) && hasSouthWall(x, y)) || (hasSouthWall(x, y) && hasWestWall(x, y)));
    }

    public void draw(Heroes hero) {

        ArrayList<Monster> monsters;
        ArrayList<Treasure> treasures;
        String monsterStr, treasureStr;
        int x, y;

        System.out.println("The map with " + BR_RED + "G" + RESET + " = Giant Spider, " + BR_RED + "S" + RESET + " = Skeleton, " + BR_RED + "O" + RESET + " = Orc, " + BR_RED + "T" + RESET + " = Troll:");
        System.out.println("Treasures: " + BR_YELLOW + "L" + RESET + " = Loose coins, " + BR_YELLOW + "M" + RESET + " = Money pouch, " + BR_YELLOW
                + "J" + RESET + " = Gold Jewlry, " + BR_YELLOW + "G" + RESET + " = Gemstone, " + BR_YELLOW + "C" + RESET + " = Small Chest:");

        for (y = 0; y < rooms[0].length; y++) {

            // Row 1: Example: +-Exit-+······+······+·Exit·+ 
            for (x = 0; x < rooms.length; x++) {

                System.out.print((rooms[x][y].isVisited() || rooms[x][alsoCheckY(y - 1, rooms)].isVisited() || rooms[alsoCheckX(x - 1, rooms)][y].isVisited()
                        || rooms[alsoCheckX(x - 1, rooms)][alsoCheckY(y - 1, rooms)].isVisited()) ? "+" : BLUE + "+" + RESET);

                if (isCornerRoom(x, y) && hasNorthWall(x, y)) {
                    System.out.print((rooms[x][y].isVisited() || rooms[x][alsoCheckY(y - 1, rooms)].isVisited()) ? "-Exit-" : BLUE + "·Exit·" + RESET);

                } else {
                    System.out.print((rooms[x][y].isVisited() || rooms[x][alsoCheckY(y - 1, rooms)].isVisited()) ? "------" : BLUE + "······" + RESET);
                }
            }
            System.out.println((rooms[x - 1][y].isVisited() || rooms[x - 1][alsoCheckY(y - 1, rooms)].isVisited() || rooms[alsoCheckX(x, rooms)][y].isVisited()
                    || rooms[alsoCheckX(x, rooms)][alsoCheckY(y - 1, rooms)].isVisited()) ? "+" : BLUE + "+" + RESET);

            // Row 2: Example: |Knight|      : S    :      :
            for (x = 0; x < rooms.length; x++) {

                System.out.print((rooms[x][y].isVisited() || rooms[alsoCheckX(x - 1, rooms)][y].isVisited()) ? "|" : BLUE + ":" + RESET);

                if (x == hero.mapPosX && y == hero.mapPosY) {
                    System.out.printf("%s%-6.6s%s", BR_GREEN, hero.getClass().getSimpleName(), RESET);

                } else {
                    monsterStr = "";
                    if (rooms[x][y].isVisited() || seeAllRooms) {
                        monsters = rooms[x][y].monsters;
                        for (Monster monster : monsters) {

                            monsterStr += (monster.getClass() == dungeonrun.Monsters.GiantSpider.class) ? "G" : "";
                            monsterStr += (monster.getClass() == dungeonrun.Monsters.Skeleton.class) ? "S" : "";
                            monsterStr += (monster.getClass() == dungeonrun.Monsters.Orc.class) ? "O" : "";
                            monsterStr += (monster.getClass() == dungeonrun.Monsters.Troll.class) ? "T" : "";
                        }
                    }
                    System.out.printf("%s %-5.5s%s", BR_RED, monsterStr, RESET);
                }
            }
            System.out.println(rooms[rooms.length - 1][y].isVisited() ? "|" : BLUE + ":" + RESET);

            // Row 3:
            for (x = 0; x < rooms.length; x++) {

                System.out.print((rooms[x][y].isVisited() || rooms[alsoCheckX(x - 1, rooms)][y].isVisited()) ? "|" : BLUE + ":" + RESET);

                if (x == hero.mapPosX && y == hero.mapPosY) {
                    System.out.printf("%s%-6.6s%s", BR_GREEN, hero.playersName, RESET);

                } else {
                    treasureStr = "";
                    if (rooms[x][y].isVisited() || seeAllRooms) {
                        treasures = rooms[x][y].treasures;

                        for (Treasure treasure : treasures) {
                            treasureStr += treasure.getClass() == dungeonrun.Treasures.LooseCoins.class ? "L" : "";
                            treasureStr += treasure.getClass() == dungeonrun.Treasures.MoneyPouch.class ? "M" : "";
                            treasureStr += treasure.getClass() == dungeonrun.Treasures.Jewlery.class ? "J" : "";
                            treasureStr += treasure.getClass() == dungeonrun.Treasures.Gemstone.class ? "G" : "";
                            treasureStr += treasure.getClass() == dungeonrun.Treasures.Chest.class ? "C" : "";
                        }
                    }
                    System.out.printf("%s %-5.5s%s", BR_YELLOW, treasureStr, RESET);
                }
            }
            System.out.println(rooms[rooms.length - 1][y].isVisited() ? "|" : BLUE + ":" + RESET);
        } // for x

        // Final row, underneith, example: Example: +-Exit-+······+······+·Exit·+     
        for (x = 0; x < rooms.length; x++) {
            if (isCornerRoom(x, rooms[0].length - 1)) {
                System.out.print((rooms[x][rooms[0].length - 1].isVisited()) ? "+-Exit-" : BLUE + "+·Exit·" + RESET);

            } else {
                System.out.print((rooms[x][rooms[0].length - 1].isVisited()) ? "+------" : BLUE + "+······" + RESET);
            }
        }
        System.out.println((rooms[rooms.length - 1][rooms[0].length - 1].isVisited()) ? "+" : BLUE + "+" + RESET);
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

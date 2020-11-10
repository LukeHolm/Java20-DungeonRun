package dungeonrun;

import dungeonrun.Characters.Heroes;
import dungeonrun.Monsters.Monster;

import java.awt.MenuItem;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameLoop {

    public static final String RESET = "\u001b[0m";
    public static final String BR_BLACK = "\u001b[30;1m";
    public static final String BR_RED = "\u001b[31;1m";
    public static final String BR_GREEN = "\u001b[32;1m";
    public static final String BR_YELLOW = "\u001b[33;1m";
    public static final String BR_BLUE = "\u001b[34;1m";
    public static final String BR_MAGENTA = "\u001b[35;1m";
    public static final String BR_CYAN = "\u001b[36;1m";

    private final static Scanner SCANNER = new Scanner(System.in);

    public enum NavigMenuItem {
        NAVIG_MENU_NORTH('n', "Go north"),
        NAVIG_MENU_EAST('e', "Go east"),
        NAVIG_MENU_SOUTH('s', "Go south"),
        NAVIG_MENU_WEST('w', "Go west"),
        NAVIG_MENU_BACK('b', "Go back"),
        NAVIG_MENU_EXIT('x', "Exit game loop");

        private String menyText;
        private char menyChar;

        NavigMenuItem(char menuCh, String menuChoiceText) {
            this.menyChar = menuCh;
            this.menyText = menuChoiceText;
        }

        public char getMenyChoiceChar() {
            return menyChar;
        }

        public String getMenuChoiceText() {
            return menyText;
        }

        public NavigMenuItem getNavigMenuItem(char menuCh) {
            NavigMenuItem menuItem = null;
            for (int i = 0; i < NavigMenuItem.values().length; i++) {

                if (menuCh == NavigMenuItem.values()[i].getMenyChoiceChar()) {
                    menuItem = NavigMenuItem.values()[i];
                    return menuItem;
                }

            }
            return menuItem;
        }
    }

    public static void playTheGame(Map map, Heroes hero) {
        NavigMenuItem navigMenuChoice = null;

        String str;
        boolean found;

        System.out.println("Playing the game...");

        do {
            map.draw(hero);

            navigMenuChoice = getNavigMenuChoice("What do you want to do: ");
            found = false;

            switch (navigMenuChoice) {
                case NAVIG_MENU_NORTH:

                    // System.out.println("hero.mapPosX = " + hero.mapPosX + "hero.mapPosY = " + hero.mapPosY + "map.rooms.length" + map.rooms.length);
                    if (hero.mapPosY > 0) {
                        // Go north
                        hero.mapPosY--;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;

                case NAVIG_MENU_SOUTH:
                    if (hero.mapPosY < map.rooms.length - 1) {
                        hero.mapPosY++;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;
                case NAVIG_MENU_WEST:
                    if (hero.mapPosX > 0) {
                        // Go east
                        hero.mapPosX--;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;
                case NAVIG_MENU_EAST:
                    if (hero.mapPosX < map.rooms[0].length - 1) {
                        // Go east
                        hero.mapPosX++;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;

                case NAVIG_MENU_BACK:
                    if (hero.mapPosY < map.rooms.length - 1) {
                        hero.mapPosY++;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;

                case NAVIG_MENU_EXIT:
                    // handled below
                    break;
                default: {
                    System.out.println(BR_RED + "Unexpected error, should never end up here after the shape checks, missing case in switch?" + RESET);
                }
            }

            if (navigMenuChoice != NavigMenuItem.NAVIG_MENU_EXIT) {

                enteringRoom(map, hero);

                System.out.println("You have a total of " + hero.highScore + " value points");
                getStringFromUser(BR_GREEN + "Press <enter> to continue" + RESET);
            }
            System.out.println("");

        } while (navigMenuChoice != NavigMenuItem.NAVIG_MENU_EXIT);
    }

    private static void enteringRoom(Map map, Heroes hero) {

        String monsterStr = "";
        String treasureStr = "";
        
        Strid strid = new Strid();

        map.rooms[hero.mapPosX][hero.mapPosY].setVisited(true);

        for (Monster monster : map.rooms[hero.mapPosX][hero.mapPosY].monsters) {
            monsterStr += "one " + monster.getClass().getSimpleName() + ", ";
        }
        monsterStr = monsterStr.length() > 2 ? monsterStr.substring(0, monsterStr.length() - 2) : monsterStr; //Remove last comma.

        for (Treasure treasure : map.rooms[hero.mapPosX][hero.mapPosY].treasures) {
            treasureStr += treasure.name + ", ";
        }
        treasureStr = treasureStr.length() > 2 ? treasureStr.substring(0, treasureStr.length() - 2) : treasureStr; //Remove last comma.

        if (monsterStr.length() == 0 && treasureStr.length() == 0) {
            System.out.println("You have entered an empty room");
            // getStringFromUser(BR_GREEN + "Press <enter> to continue" + RESET);

        } else if (monsterStr.length() != 0) {
            System.out.println("Auch, when you enter the room you see: " + monsterStr);
            if (treasureStr.length() != 0) {
                System.out.println("Behind the monster(s) you see: " + treasureStr);
            }
            hero.fightMonsters(map);
            
            strid.stridDice(map, hero);

        } else {
            System.out.println("Excellent, you see: " + treasureStr);
        }

        if (treasureStr.length() >= 0) {
            // Picking up the Treasures
            for (Treasure treasure : map.rooms[hero.mapPosX][hero.mapPosY].treasures) {

                System.out.println("Picking up the " + treasure.name + " worth " + treasure.valuePoints + " value points");
                hero.highScore += treasure.valuePoints;
            }
            map.rooms[hero.mapPosX][hero.mapPosY].treasures.clear(); // Removing all the Treasures
        }
    }

    private static NavigMenuItem getNavigMenuChoice(String prompt) {
        String choiceStr;
        NavigMenuItem goMenuChoice = null;

        System.out.println("Navigation menu:");

        // Loop over all meny choices from choice 1, and print all meny choice texts
        for (int i = 1; i < NavigMenuItem.values().length; i++) {

            System.out.println(NavigMenuItem.values()[i].getMenyChoiceChar() + ": " + NavigMenuItem.values()[i].getMenuChoiceText());
        }

        do {  // loop until a valid choice has been read
            // Add choice 0 last, if not "Unused"

            System.out.print(prompt);

            // Try to read an meny choice integer from the console
            choiceStr = SCANNER.nextLine();

            goMenuChoice = (choiceStr.length() > 0) ? NavigMenuItem.values()[0].getNavigMenuItem(choiceStr.charAt(0)) : null;

            if (goMenuChoice == null) {
                System.out.println("Not a valid choice. " + "Try again!");

            }

        } while (goMenuChoice == null); // Loop as long as we haven't got a valid choice

        System.out.println("");
        return goMenuChoice;
    }

    private static String getStringFromUser(String promptText) {

        System.out.print(promptText);

        String userInputString = SCANNER.nextLine();

        return userInputString;
    }
}

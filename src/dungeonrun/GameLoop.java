package dungeonrun;

import dungeonrun.Characters.Heroes;
import static dungeonrun.Main.music;
import dungeonrun.Monsters.Monster;
import dungeonrun.Treasures.Treasure;

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
        NAVIG_MENU_NORTH('n', "Go north", true), // parameters menuChar, menyChoiceText, enabledMenyChoice 
        NAVIG_MENU_EAST('e', "Go east", true),
        NAVIG_MENU_SOUTH('s', "Go south", true),
        NAVIG_MENU_WEST('w', "Go west", true),
        // NAVIG_MENU_BACK('b', "Go back", true),  // Removed, only exists in the fight-choice when entereing a room, a different menu
        NAVIG_MENU_EXIT('x', "Exit map", false);

        private String menyText;
        private char menyChar;
        private boolean enabledMenyChoice;

        NavigMenuItem(char menuCh, String menuChoiceText, boolean enabledMenyChoice) {
            this.menyChar = menuCh;
            this.menyText = menuChoiceText;
            this.enabledMenyChoice = enabledMenyChoice;
        }

        public char getMenyChoiceChar() {
            return menyChar;
        }

        public String getMenuChoiceText() {
            return menyText;
        }

        public void setEnabledMenyChoice(boolean enabledMenyChoice) {
            this.enabledMenyChoice = enabledMenyChoice;
        }

        public boolean isEnabledMenyChoice() {
            return enabledMenyChoice;
        }

        // Resets the manu choices for a normal room away from walls
        public void resetMenyChoices() {
            for (NavigMenuItem value : NavigMenuItem.values()) {
                // Enable all menu choices except the EXIT one
                value.setEnabledMenyChoice(value != NAVIG_MENU_EXIT);
            }
        }

        public NavigMenuItem getNavigMenuItem(char menuCh) {
            NavigMenuItem menuItem = null;

            // Loop over all the meny choises, and return the right (first) item that is enabled and has the matching character
            for (NavigMenuItem value : NavigMenuItem.values()) {
                if (value.isEnabledMenyChoice() && menuCh == value.getMenyChoiceChar()) {
                    menuItem = value;
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

        //System.out.println("Playing the game...");
        System.out.println("");

        do {
            map.draw(hero);

            navigMenuChoice = getNavigMenuChoice("What do you want to do: ", map, hero);
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

                case NAVIG_MENU_EXIT:
                    // handled below
                    break;
                default: {
                    System.out.println(BR_RED + "Unexpected error, should never end up here after the shape checks, missing case in switch?" + RESET);
                }
            }

            if (navigMenuChoice != NavigMenuItem.NAVIG_MENU_EXIT) {

                enteringRoom(map, hero);

                //Unnecessary step, removed by Lucas to add flow to game. 
                //getStringFromUser(BR_GREEN + "Press <enter> to continue" + RESET);
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
            treasureStr += treasure.treasureDescription + ", ";
        }
        treasureStr = treasureStr.length() > 2 ? treasureStr.substring(0, treasureStr.length() - 2) : treasureStr; //Remove last comma.

        if (monsterStr.length() == 0 && treasureStr.length() == 0) {
            System.out.println("You have entered an empty room");
            // getStringFromUser(BR_GREEN + "Press <enter> to continue" + RESET);

        } else if (monsterStr.length() != 0) {
            System.out.println("OH MY GOD, when you enter the room you see: " + monsterStr);
            if (treasureStr.length() != 0) {
                System.out.println("Behind the monster(s) you see " + treasureStr);
            }
            strid.stridDice(map, hero);


        } else {
            System.out.println("In the room you find " + treasureStr);
        }
        if(Strid.tryLoot) {
            // Picking up the Treasures
            for (Treasure treasure : map.rooms[hero.mapPosX][hero.mapPosY].treasures) {

                System.out.println("You pick up the " + treasure.name + ". It's worth " + treasure.value + " gold");
                hero.totalGold += treasure.value;

            }
            map.rooms[hero.mapPosX][hero.mapPosY].treasures.clear();
        }
        else{
            System.out.println("The monsters keep the treasures in this room...");
        }
      Strid.tryLoot=true;
             // Removing all the Treasures
            System.out.println("You have a total of " + hero.totalGold + " gold");

    }

    private static NavigMenuItem getNavigMenuChoice(String prompt, Map map, Heroes hero) {
        String choiceStr;
        NavigMenuItem goMenuChoice = null;

        System.out.println("Navigation menu:" + BR_YELLOW);

        // Enable EXIT menu choice when it's a Corner room
        NavigMenuItem.NAVIG_MENU_EXIT.setEnabledMenyChoice(map.isCornerRoom(hero.mapPosX, hero.mapPosY));

        // Disable navigation choice when there is a wall in that direction
        NavigMenuItem.NAVIG_MENU_NORTH.setEnabledMenyChoice(!map.hasNorthWall(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_SOUTH.setEnabledMenyChoice(!map.hasSouthWall(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_WEST.setEnabledMenyChoice(!map.hasWestWall(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_EAST.setEnabledMenyChoice(!map.hasEastWall(hero.mapPosX, hero.mapPosY));

        // Loop over all meny choices in the enum, and print the "meny choice texts" for the enabled ones
        for (NavigMenuItem value : NavigMenuItem.values()) {
            if (value.isEnabledMenyChoice()) {
                System.out.println(BR_YELLOW + value.getMenyChoiceChar() + ": " + value.getMenuChoiceText());
            }
        }

        do {  // loop until a valid choice has been read

            System.out.print(RESET + prompt);

            // Try to read an meny choice integer from the console
            choiceStr = SCANNER.nextLine();
            // Using the first character as the user input
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

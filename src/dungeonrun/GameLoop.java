package dungeonrun;
import dungeonrun.Characters.Heroes;
import static dungeonrun.Main.music;
import dungeonrun.Monsters.Monster;
import dungeonrun.Treasures.Treasure;
import java.util.Scanner;
public class GameLoop {

    static String footstep = "footdoor.wav";
    static String win = "Victory.wav";
    public static final String RESET = "\u001b[0m";
    public static final String BR_RED = "\u001b[31;1m";
    public static final String BR_GREEN = "\u001b[32;1m";
    public static final String BR_YELLOW = "\u001b[33;1m";
    private final static Scanner SCANNER = new Scanner(System.in);
    public static final String GREEN = "\u001b[32m";
    public enum NavigMenuItem {
        NAVIG_MENU_NORTH('W', "Go north", true, false), // parameters menuChar, menyChoiceText, enabledMenyChoice, hiddenMenyChoice
        NAVIG_MENU_WEST('A', "Go west", true, false),
        NAVIG_MENU_SOUTH('S', "Go south", true, false),
        NAVIG_MENU_EAST('D', "Go east", true, false),
        NAVIG_MENU_SEE_ROOMS_TOGGLE('T', "Toggle 'See all rooms'", true, false),
        NAVIG_MENU_EXIT('X', "Exit map", false, false);

        private String menyText;
        private char menyChar;
        private boolean enabledMenyChoice;
        private boolean hiddenMenyChoice;

        NavigMenuItem(char menuCh, String menuChoiceText, boolean enabledMenyChoice, boolean hiddenMenyChoice) {
            this.menyChar = menuCh;
            this.menyText = menuChoiceText;
            this.enabledMenyChoice = enabledMenyChoice;
            this.hiddenMenyChoice = hiddenMenyChoice;
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

        public void setHiddenMenyChoice(boolean hiddenMenyChoice) {
            this.hiddenMenyChoice = hiddenMenyChoice;
        }

        public boolean isEnabledMenyChoice() {
            return enabledMenyChoice;
        }

        public boolean ishiddenMenyChoice() {
            return hiddenMenyChoice;
        }

        public NavigMenuItem getNavigMenuItem(char menuCh) {
            NavigMenuItem menuItem = null;

            // Loop over all the meny choises, and return the right (first) item that is enabled and has the matching character
            for (NavigMenuItem value : NavigMenuItem.values()) {
                if (value.isEnabledMenyChoice() && (menuCh == value.getMenyChoiceChar()) || Character.toLowerCase(menuCh) == Character.toLowerCase(value.getMenyChoiceChar())) {
                    menuItem = value;
                    return menuItem;
                }
            }
            return menuItem;
        }
    }

    public static void playTheGame(Map map, Heroes hero) {
        NavigMenuItem navigMenuChoice;

        //System.out.println("Playing the game...");
        System.out.println("");

        do {
            map.draw(hero);

            navigMenuChoice = getNavigMenuChoice("What do you want to do: ", map, hero);

            hero.lastPosY = hero.mapPosY;
            hero.lastPosX = hero.mapPosX;
            switch (navigMenuChoice) {
                case NAVIG_MENU_NORTH:
                     music.playMusic(footstep);

                    // System.out.println("hero.mapPosX = " + hero.mapPosX + "hero.mapPosY = " + hero.mapPosY + "map.rooms.length" + map.rooms.length);
                    if (hero.mapPosY > 0) {
                        // Go north
                        hero.mapPosY--;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;

                case NAVIG_MENU_SOUTH:
                      music.playMusic(footstep);
                    if (hero.mapPosY < map.rooms.length - 1) {
                        hero.mapPosY++;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;
                case NAVIG_MENU_WEST:
                     music.playMusic(footstep);
                    if (hero.mapPosX > 0) {
                        // Go east
                        hero.mapPosX--;
                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;
                case NAVIG_MENU_EAST:
                     music.playMusic(footstep);
                    if (hero.mapPosX < map.rooms[0].length - 1) {
                        // Go east
                        hero.mapPosX++;

                    } else {
                        System.out.println("There's no door in that direction, you are staying put");
                    }
                    break;
                    
                case NAVIG_MENU_SEE_ROOMS_TOGGLE:
                    map.seeAllRooms = !map.seeAllRooms; // Toggle seeAllRooms
                    navigMenuChoice.setHiddenMenyChoice(!map.seeAllRooms);  // If we can see all rooms, it should not be hidden how to turn it off             
                    break;

                case NAVIG_MENU_EXIT:
                    // handled below
                      music.StopDungeonmusic();
                     music.playMusic(win);
                    System.out.println("--------------EXITING--------------");
                    System.out.println("    You have survived this time...");
                    System.out.println("--------------EXITING--------------");
                    break;
                default: {
                    System.out.println(BR_RED + "Unexpected error, should never end up here after the shape checks, missing case in switch?" + RESET);
                }
            }

            if (navigMenuChoice != NavigMenuItem.NAVIG_MENU_EXIT) {
                enteringRoom(map, hero);
                
            }
            System.out.println("");

        } while (navigMenuChoice != NavigMenuItem.NAVIG_MENU_EXIT);
    }

    private static void enteringRoom(Map map, Heroes hero) {

        String monsterStr = "";
        String treasureStr = "";

        Strid strid = new Strid();
        map.rooms[hero.mapPosX][hero.mapPosY].draw(hero);
        
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

        } else if (monsterStr.length() != 0) {
            System.out.println(RESET + "OH MY GOD, when you enter the room you see: " + monsterStr);
            if (treasureStr.length() != 0) {
                System.out.println("Behind the monster(s) you see " + treasureStr);
            }
            strid.stridDice(map, hero);

        } else {
            System.out.println("In the room you find " + treasureStr);
        }
        if (Strid.tryLoot) {
            // Picking up the Treasures
            for (Treasure treasure : map.rooms[hero.mapPosX][hero.mapPosY].treasures) {

                System.out.println("You pick up the " + treasure.name + ". It's worth " + treasure.value + " gold");
                hero.totalGold += treasure.value;

            }
            map.rooms[hero.mapPosX][hero.mapPosY].treasures.clear();
        } else {
            System.out.println("The monsters keep the treasures in this room...");
            hero.mapPosX = hero.lastPosX;
            hero.mapPosY = hero.lastPosY;

        }
        System.out.println(GREEN + "Leaving room..." + RESET);
        Strid.tryLoot = true;

        System.out.println("You have a total of " + hero.totalGold + " gold");

    }

    private static NavigMenuItem getNavigMenuChoice(String prompt, Map map, Heroes hero) {
        String choiceStr;
        NavigMenuItem goMenuChoice;

        System.out.println("Navigation menu:" + BR_YELLOW);

        // Enable EXIT menu choice when it's a Corner room, always enable the function of 'See all rooms"-toggle
        NavigMenuItem.NAVIG_MENU_EXIT.setEnabledMenyChoice(map.isCornerRoom(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_SEE_ROOMS_TOGGLE.setEnabledMenyChoice(true);

        // Hide 'See all rooms"-toggle if seeAllRooms is not on
        NavigMenuItem.NAVIG_MENU_SEE_ROOMS_TOGGLE.setHiddenMenyChoice(!map.seeAllRooms);

        // Disable navigation choice when there is a wall in that direction
        NavigMenuItem.NAVIG_MENU_NORTH.setEnabledMenyChoice(!map.hasNorthWall(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_SOUTH.setEnabledMenyChoice(!map.hasSouthWall(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_WEST.setEnabledMenyChoice(!map.hasWestWall(hero.mapPosX, hero.mapPosY));
        NavigMenuItem.NAVIG_MENU_EAST.setEnabledMenyChoice(!map.hasEastWall(hero.mapPosX, hero.mapPosY));

        // Loop over all meny choices in the enum, and print the "meny choice texts" for the enabled & non-hidden ones
        for (NavigMenuItem value : NavigMenuItem.values()) {
            if (value.isEnabledMenyChoice() && !value.ishiddenMenyChoice()) {
                System.out.println(BR_YELLOW + value.getMenyChoiceChar() + ": " + value.getMenuChoiceText());
            }
        }

        do {  // loop until a valid choice has been read

            System.out.print(RESET + prompt);

            // Try to read an menu choice integer from the console
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

}

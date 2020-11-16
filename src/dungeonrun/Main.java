package dungeonrun;

import dungeonrun.Characters.Heroes;
import dungeonrun.Characters.Knight;
import dungeonrun.Characters.Thief;
import dungeonrun.Characters.Wizard;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Main {
    //Menu
    static String dungeonmusic = "dungeonmusic.wav";
    static String beepmenu = "beep.wav";
    //Characters
    static String knightpicked = "Knightpicked.wav";
    static String wizardpicked = "Wizardpicked.wav";
    static String thiefpicked = "thiefpicked.wav";
    static MusicStuff music = new MusicStuff();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       //// // music.PlayRain();// Spelar upp regn 
       
        Drawings.drawCastle();
        while (true) {
            mainGame();
        }
    }

    public static void mainGame() {

        Heroes theHero;
        Heroes oldHero;
        Map theMap;
        int choice;

        try {

            System.out.println("\n *** Welcome to Dungeon Run! *** \n");
            System.out.println("1. New game");
            System.out.println("2. Continue with existing hero");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ////  music.playMusic(beepmenu);
                    theHero = getPlayer();
                    theMap = chooseMap(theHero);
                    chooseStart(theMap.rooms.length, theMap.rooms[0].length, theHero);
                    theMap.rooms[theHero.mapPosX][theHero.mapPosY].visited = true;

                    GameLoop.playTheGame(theMap, theHero);
                    break;

                case 2:
                    //////   music.playMusic(beepmenu);
                    /*              for (Heroes character : players) {
                    System.out.println(character);
                }*/
                    System.out.println("TODO: Load character... ");
                    oldHero = listHeroes();
                    if (oldHero != null) {
                        theMap = chooseMap(oldHero);

                        GameLoop.playTheGame(theMap, oldHero);
                    }
                    break;

                case 3:

                    System.out.println("Thank you for playing Dungeon Run!\nGoodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
            }
        } catch (InputMismatchException e) {
            //Any corrupted or invalid input results in a exception. Inform user that the input is invalid
            System.out.print("Invalid input. Must be integers...\n");

            scanner.next();

        }
    }

    public static Map chooseMap(Heroes hero) {
        Scanner input = new Scanner(System.in);
        boolean runtime = true;
        Map theMap = null;
        while (runtime) {
            try {
                System.out.println("\nChoose mapsize\n1: Small\n2: Medium\n3: Big");
                int size = input.nextInt();

                switch (size) {
                    case 1:

                        /// //  music.playMusic(beepmenu);
                        theMap = new Map(4, 4, hero);
                        runtime = false;
                        break;

                    case 2:
                        ///  //  music.playMusic(beepmenu);
                        theMap = new Map(5, 5, hero);
                        runtime = false;
                        break;

                    case 3:
                        ///// //   music.playMusic(beepmenu);
                        theMap = new Map(8, 8, hero);
                        runtime = false;
                        break;

                    default:
                        System.out.println("Option not available");
                        break;

                }

            } catch (InputMismatchException s) {
                System.out.println("incorrect input");
                input.next();

            }

        }
        // System.out.println("The created map looks like this:");
        // theMap.draw(hero);
        // System.out.println("Time to start your adventure!");
        return theMap;
    }

    public static Heroes getPlayer() {

        Heroes hero = null;
        String characterName;
        boolean validInput = false;

        System.out.println("\nCharacters to choose from:");
        System.out.println("");

        // Draw the characters (Hero types) to choose fraom, including attribute values
        drawCharacters();

        do {
            System.out.print("Your choice > ");

            try {

                int menuChoice = scanner.nextInt();
                scanner.nextLine();

                switch (menuChoice) {

                    case 1:
                        ///  //  music.playMusic(beepmenu);
                        /// // music.playMusic(dungeonmusic);
                        System.out.println("What is your knights name?");
                        characterName = newHero();


                        //////////// music.playMusic(knightpicked);
                        hero = new Knight(characterName);
                        // players.add(hero);  From the spec.: "Dungeon Run är ett textbaserat äventyrsspel för en spelare"

                        saveHero(characterName, hero);
                        System.out.println("\nYou have chosen " + characterName + " the brave knight.");
                        validInput = true;
                        break;
                    case 2:
                        ///  //  music.playMusic(beepmenu);
                        /// // music.playMusic(dungeonmusic);
                        System.out.println("\nWhat is your wizards name?");
                        characterName = newHero();


                        /////////// music.playMusic(wizardpicked);
                        hero = new Wizard(characterName);
                        saveHero(characterName, hero);
                        System.out.println("\nYou have chosen " + characterName + " the intelligent wizard.");
                        validInput = true;
                        break;
                    case 3:
                        ///  //  music.playMusic(beepmenu);
                        /// // music.playMusic(dungeonmusic);

                        System.out.println("What is your thiefs name?");
                        characterName = newHero();
                        //music.playMusic(thiefpicked);
                        hero = new Thief(characterName);
                        saveHero(characterName, hero);
                        System.out.println("\nYou have chosen " + characterName + " the cunning thief.");
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid input, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input");
                scanner.next();
            }

        } while (!validInput);

        return hero;
    }

    public static void chooseStart(int sizeX, int sizeY, Heroes hero) {
        Scanner input = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Where do you want to enter the dungeon?\n1.Upper left\n2.Upper right\n3.Lower left\n4.Lower right");
                int intFromUser = input.nextInt();
                if (intFromUser >= 1 && intFromUser <= 4) {
                    validInput = true;
                }
                switch (intFromUser) {
                    case 1:
                        ///  //  music.playMusic(beepmenu);
                        System.out.println("You chose the upper left corner.");
                        hero.mapPosX = 0;
                        hero.mapPosY = 0;

                        break;

                    case 2:
                        ////  //  music.playMusic(beepmenu);
                        System.out.println("You chose the upper right corner.");
                        hero.mapPosX = sizeX - 1;
                        hero.mapPosY = 0;

                        break;

                    case 3:
                        ///  //  music.playMusic(beepmenu);
                        System.out.println("You chose the lower left corner.");
                        hero.mapPosX = 0;
                        hero.mapPosY = sizeY - 1;
                        break;

                    case 4:
                        ///  //  music.playMusic(beepmenu);
                        System.out.println("You chose the lower right corner.");
                        hero.mapPosX = sizeX - 1;
                        hero.mapPosY = sizeY - 1;
                        break;

                    default:
                        System.out.println("Invalid number");
                        break;
                }
            } catch (InputMismatchException s) {
                System.out.println("Incorrect input");
                input.next();
            }
        } // while
    }

    public static String newHero() {
        String characterName = null;
        boolean done = false;
        while (!done) {

            try {
                File folder = new File("Characters");
                folder.mkdir();
                characterName = scanner.nextLine();
                String fileName = characterName;
                File newHero = new File("Characters\\" + fileName);

                if (newHero.createNewFile()) {
                    done = true;
                } else {
                    System.out.println("A hero with that name already exists, please choose a different name.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred during hero creation.");
            }
        }
        return characterName;
    }

    public static void saveHero(String fileName, Heroes hero) {
        try {
            FileWriter myWriter = new FileWriter("Characters\\" + fileName);
            myWriter.write(hero.creatureIsA + "\n");
            myWriter.write(Integer.toString(hero.initiative) + "\n");
            myWriter.write(Integer.toString(hero.toughness) + "\n");
            myWriter.write(Integer.toString(hero.attack) + "\n");
            myWriter.write(Integer.toString(hero.agility) + "\n");
            myWriter.write(hero.playersName + "\n");
            myWriter.write(Integer.toString(hero.highScore) + "\n");
            myWriter.write(Integer.toString(hero.playedGames) + "\n");
            myWriter.write(Integer.toString(hero.totalGold + 53) + "\n");
            myWriter.write(Integer.toString(hero.giantSpidersKilled) + "\n");
            myWriter.write(Integer.toString(hero.skeletonsKilled) + "\n");
            myWriter.write(Integer.toString(hero.orcsKilled) + "\n");
            myWriter.write(Integer.toString(hero.trollsKilled) + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Could not save hero properly.");
        }
    }

    public static Heroes listHeroes() {

        String[] heroesOfOld;
        File f = new File("Characters\\");
        heroesOfOld = f.list();
        Heroes oldHero = null;

        if (heroesOfOld.length != 0) {
            System.out.println("\nThese are the heroes of past:\n");
            // For each pathname in the pathnames array
            for (String pathname : heroesOfOld) {
                // Print the names of files and directories
                System.out.println(pathname + " the " + getHeroStats(pathname));
            }
            oldHero = loadHero();

        } else {
            System.out.println("\nThere are no heroes of old.");
            System.out.println("Perhaps you will be a hero of legends?");
        }
        return oldHero;
    }

    public static String getHeroStats(String name) {
        {

            String heroType = null;
            String initiative = null;
            String toughness = null;
            String attack = null;
            String agility = null;
            String treasure = null;
            try {
                heroType = Files.readAllLines(Paths.get("Characters\\" + name)).get(0);
                initiative = Files.readAllLines(Paths.get("Characters\\" + name)).get(1);
                toughness = Files.readAllLines(Paths.get("Characters\\" + name)).get(2);
                attack = Files.readAllLines(Paths.get("Characters\\" + name)).get(3);
                agility = Files.readAllLines(Paths.get("Characters\\" + name)).get(4);
                treasure = Files.readAllLines(Paths.get("Characters\\" + name)).get(8);
            } catch (IOException e) {
                System.out.println("Oops");
            }
            String hero = heroType + "\n"
                    + "Initiative : " + initiative + "\n"
                    + "Toughness: " + toughness + "\n"
                    + "Attack: " + attack + "\n"
                    + "Agility: " + agility + "\n"
                    + "Treasures: " + treasure + " golds worth\n";

            return hero;
        }

    }

    public static Heroes loadHero() {
        Heroes oldHero = null;
        boolean choice = false;

        //Enter name for hero you want to load
        while (!choice) {
            System.out.println("Please enter the name the hero you want to revisit:");
            System.out.println("Or type 'Back' to go back to the menu");
            String heroChoice = scanner.nextLine();
            if (heroChoice.equalsIgnoreCase("back")) {
                break;
            }
            System.out.println("\n" + heroChoice + " the " + getHeroStats(heroChoice) + "\nAre you sure? y/n");
            String sure = scanner.nextLine();
            if (sure.equalsIgnoreCase("y")) {
                System.out.println("And so the story of " + heroChoice + " continues..\n");
                choice = true;
            } else {
                System.out.println("The heroes will await your return.");
                break;
            }

            //Setting class to loaded hero
            String heroType = null;
            try {
                heroType = (Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(0));

            } catch (IOException ex) {
                Logger.getLogger(Main.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (heroType.equals("Knight")) {
                oldHero = new Knight(heroChoice);
            } else if (heroType.equals("Thief")) {
                oldHero = new Thief(heroChoice);
            } else if (heroType.equals("Wizard")) {
                oldHero = new Wizard(heroChoice);
            }

            //Transferring stats from file into game:
            try {
                oldHero.creatureIsA = (Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(0));
                oldHero.initiative = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(1)));
                oldHero.toughness = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(2)));
                oldHero.attack = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(3)));
                oldHero.agility = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(4)));
                oldHero.playersName = (Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(5));
                oldHero.highScore = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(6)));
                oldHero.playedGames = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(7)));
                oldHero.totalGold = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(8)));
                oldHero.giantSpidersKilled = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(9)));
                oldHero.skeletonsKilled = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(10)));
                oldHero.orcsKilled = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(11)));
                oldHero.trollsKilled = (Integer.parseInt(Files.readAllLines(Paths.get("Characters\\" + heroChoice)).get(12)));
            } catch (IOException e) {
                System.out.println("There was a problem loading the hero.");
            }
        }
        return oldHero;
    }

    public static void drawCharacters() {
        ArrayList<Heroes> heroes = new ArrayList<>();

        Knight knight = new Knight("");
        heroes.add(knight);

        Heroes wizard = new Wizard("");
        heroes.add(wizard);

        Heroes thief = new Thief("");
        heroes.add(thief);

        // Want to print the number of rows in the tallest figure
        int noOfRows = Integer.max(knight.displayHeight(knight), Integer.max(wizard.displayHeight(wizard), thief.displayHeight(thief)));
        //System.out.println("noOfRows " + noOfRows);

        String lineStr = new String(new char[30]).replace("\0", "-"); // 30 underline chars
        System.out.printf(":%.30s:%s:%s:\n", lineStr, lineStr, lineStr); // Top border

        // Print the first row, with tha class name overlayed in the upper left*
        System.out.print(GameLoop.RESET + ": ");
        for (Heroes hero : heroes) {
            String firstRow = hero.displayStrings()[0];
            String heroClassName = hero.getClass().getSimpleName();
            firstRow = heroClassName + firstRow.substring(heroClassName.length());
            System.out.print(GameLoop.BR_GREEN + firstRow + GameLoop.RESET + " : ");
        }
        System.out.println("");

        // Print all the rows, assuming all characters have the same number of display rows
        for (int row = 1; row < noOfRows; row++) {
            System.out.print(GameLoop.RESET + ": ");
            for (Heroes hero : heroes) {
                System.out.print(GameLoop.BR_GREEN + hero.displayStrings()[row] + GameLoop.RESET + " : ");
            }
            System.out.println("");
        }

        // Now list theair attribute values underneith
        System.out.printf(":%.30s:%s:%s:\n", lineStr, lineStr, lineStr);
        // TODO: Use color "\033[0;1m" that was previously used?
        System.out.printf(": 1. %-25s : 2. %-25s : 3. %-25s :\n", knight.getClass().getSimpleName(), wizard.getClass().getSimpleName(), thief.getClass().getSimpleName());
        System.out.printf(":    %-25s :    %-25s :    %-25s :\n", "Initiative: " + knight.initiative, "Initiative: " + wizard.initiative, "Initiative: " + thief.initiative);
        System.out.printf(":    %-25s :    %-25s :    %-25s :\n", "Toughness: " + knight.toughness, "Toughness: " + wizard.toughness, "Toughness: " + thief.toughness);
        System.out.printf(":    %-25s :    %-25s :    %-25s :\n", "Attack: " + knight.attack, "Attack: " + wizard.attack, "Attack: " + thief.attack);
        System.out.printf(":    %-25s :    %-25s :    %-25s :\n", "Agility: " + knight.agility, "Agility: " + wizard.agility, "Agility: " + thief.agility);
        System.out.printf(":%.30s:%s:%s:\n", lineStr, lineStr, lineStr);
    }

}

package dungeonrun;

import dungeonrun.Characters.Heroes;
import dungeonrun.Characters.Knight;
import dungeonrun.Characters.Thief;
import dungeonrun.Characters.Wizard;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static String gamemenumusic = "rainthunder.wav";
    static String dungeonmusic = "dungeonmusic.wav";
    static String beepmenu = "beep.wav";
    static String knightpicked = "Knightpicked.wav";
    static String wizardpicked = "Wizardpicked.wav";
    static MusicStuff music = new MusicStuff();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // music.playMusic(gamemenumusic); // gamemenumusic
        music.playMusic(gamemenumusic);

        while (true) {

            mainGame();

        }
    }

    public static void mainGame() {
        ArrayList<Heroes> players = new ArrayList<>();
        Heroes theHero = null;
        Map theMap = null;
        int i;
        int choice;
        int test;
        String characterName;
        int Hero;
        try {
            System.out.println("\n *** Welcome to Dungeon Run! *** \n");
            System.out.println("1. New game");
            System.out.println("2. Load existing character");
            System.out.println("3. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    music.playMusic(beepmenu);

                    theHero = getPlayer();
                    theMap = chooseMap(theHero);
                    // TODO: choose starting point
                    // Start the main gaming loop:
                    GameLoop.playTheGame(theMap, theHero);
                    break;
                case 2:
                    music.playMusic(beepmenu);
                    /*              for (Heroes character : players) {
                    System.out.println(character);
                }*/
                    System.out.println("TODO: Load character... ");
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

                        music.playMusic(beepmenu);
                        theMap = new Map(4, 4, hero);
                        runtime = false;
                        break;

                    case 2:
                        music.playMusic(beepmenu);
                        theMap = new Map(5, 5, hero);
                        runtime = false;
                        break;

                    case 3:
                        music.playMusic(beepmenu);
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
        System.out.println("The created map looks like this:");
        theMap.draw(hero);

        System.out.println("Time to start your adventure!");
        return theMap;
    }

    public static Heroes getPlayer() {

        Heroes hero = null;
        String characterName;

        System.out.println("\nPlease choose a character\n");
        System.out.println("-----------------------------------\n ");
        Drawings.drawKnight();
        System.out.println("\033[0;1m 1. Knight\033[0m\n Initiativ: 5\n Tålighet: 9\n Attack 6\n Smidighet: 4\n ");
        System.out.println("-----------------------------------\n");
        Drawings.drawWizard();
        System.out.println("\033[0;1m 2. Wizard\033[0m\n Initiativ: 6\n Tålighet: 4\n Attack 9\n Smidighet: 5\n");
        System.out.println("-----------------------------------\n");
        Drawings.drawThief();
        System.out.println("\033[0;1m 3. Thief\033[0m\n Initiativ: 7\n Tålighet: 5\n Attack 5\n Smidighet: 7\n");
        System.out.println("-----------------------------------\n");

        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        switch (menuChoice) {
            case 1:
                // music.stopMusic(); // Stop gamemenumusic
                // music.playMusic(dungeonmusic); // play dungeomusic
                // music.playMusic(gamemenumusic); // play gamemenumusic

                music.playMusic(beepmenu);
                System.out.println("Enter the name of your character");
                characterName = scanner.nextLine();

                System.out.println("\nYou have chosen the brave knight" + " " + characterName);
                music.playMusic(knightpicked);
                hero = new Knight(characterName);
                // players.add(hero);  From the spec.: "Dungeon Run är ett textbaserat äventyrsspel för en spelare"

                break;
            case 2:
                // music.stopMusic(); // Stop gamemenumusic
                // music.playMusic(dungeonmusic); // play dungeomusic
                // music.playMusic(gamemenumusic); // play gamemenumusic

                music.playMusic(beepmenu);
                System.out.println("\nEnter the name of your character");
                characterName = scanner.nextLine();
                System.out.println("\nYou have chosen the intelligent wizard" + " " + characterName);
                music.playMusic(wizardpicked);
                hero = new Wizard(characterName);
                // players.add(hero);  From the spec.: "Dungeon Run är ett textbaserat äventyrsspel för en spelare"

                break;
            case 3:
                music.playMusic(beepmenu);
                // music.stopMusic(); // Stop gamemenumusic
                // music.playMusic(dungeonmusic); // play dungeomusic
                // music.playMusic(gamemenumusic); // play gamemenumusic
                System.out.println("Enter the name of your character");
                characterName = scanner.nextLine();

                System.out.println("\nYou have chosen the cunning thief" + " " + characterName);
                hero = new Thief(characterName);
                // players.add(hero);  From the spec.: "Dungeon Run är ett textbaserat äventyrsspel för en spelare"

                break;
            default:
                System.out.println("Invalid input, please try again.");
        }

        return hero;
    }

    public int chooseStart(int ul, int ur, Heroes hero) {
        Scanner input = new Scanner(System.in);
        boolean runtime = true;
        while (runtime) {
            try {
                System.out.println("Choose corner as starting point\n1.Upper left\n2.Upper right\n3.Lower left\n4.Lower right");
                int dir = input.nextInt();
                switch (dir) {
                    case 1:

                        System.out.println("You chose the upper left corner.");
                        hero.mapPosX = 0;
                        hero.mapPosY = 0;
                        break;

                    case 2:
                        System.out.println("You chose the upper right corner.");
                        hero.mapPosX = 0;
                        hero.mapPosY = 0;

                        break;

                    case 3:
                        System.out.println("You chose the lower left corner.");
                        hero.mapPosX = 0;
                        hero.mapPosY = 0;
                        break;

                    case 4:
                        System.out.println("You chose the lower right corner.");
                        break;

                    default:
                        System.out.println("Invalid number");
                        break;
                }
            } catch (InputMismatchException s) {
                System.out.println("Incorrect input");
                input.next();
            }
            runtime = false;
        }
        return 0;
    }
}

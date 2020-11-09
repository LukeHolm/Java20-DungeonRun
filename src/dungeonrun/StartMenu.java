package dungeonrun;

import dungeonrun.Characters.Heroes;
import dungeonrun.Characters.Knight;
import dungeonrun.Characters.Thief;
import dungeonrun.Characters.Wizard;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {

    ArrayList<Heroes> player = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static int test;
    static String characterName;
    static int Hero;
    MapMenu play = new MapMenu();

    Map startMenuMap = null;

    public void main() {
        System.out.println("\n *** Welcome to Dungeon Run! *** \n");
        System.out.println("1. New game");
        System.out.println("2. Load existing character");
        System.out.println("3. Exit");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Player();
                startMenuMap = play.chooseMap();
                break;
            case 2:
                System.out.println("This function is still in development");
                break;

            case 3:
                System.out.println("Thank you for playing Dungeon Run!\nGoodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input, please try again.");
        }
    }

    public void Player() {

        System.out.println("\nPlease choose a character\n");
        System.out.println("-----------------------------------\n ");
        System.out.println("\033[0;1m 1. Knight\033[0m\n Initiativ: 5\n Tålighet: 9\n Attack 6\n Smidighet: 4\n ");
        System.out.println("-----------------------------------\n");
        System.out.println("\033[0;1m 2. Wizard\033[0m\n Initiativ: 6\n Tålighet: 4\n Attack 9\n Smidighet: 5\n");
        System.out.println("-----------------------------------\n");
        System.out.println("\033[0;1m 3. Thief\033[0m\n Initiativ: 7\n Tålighet: 5\n Attack 5\n Smidighet: 7\n");
        System.out.println("-----------------------------------\n");
        Hero = scanner.nextInt();
        scanner.nextLine();
        switch (Hero) {
            case 1:
                System.out.println("Enter the name of your character");
                characterName = scanner.nextLine();

                System.out.println("\nYou have chosen the brave knight" + " " + characterName);
                Heroes playerHero = new Knight(characterName);
                player.add(playerHero);
                break;
            case 2:
                System.out.println("\nEnter the name of your character");
                characterName = scanner.nextLine();

                System.out.println("\nYou have chosen the intelligent wizard" + " " + characterName);
                Heroes playerHeroWizard = new Wizard(characterName);
                player.add(playerHeroWizard);
                break;
            case 3:
                System.out.println("Enter the name of your character");
                characterName = scanner.nextLine();

                System.out.println("\nYou have chosen the cunning thief" + " " + characterName);
                Heroes playerHeroThief = new Thief(characterName);
                player.add(playerHeroThief);
                break;
            default:
                System.out.println("Invalid input, please try again.");

        }

    }
}

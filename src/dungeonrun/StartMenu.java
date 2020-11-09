package dungeonrun;

import java.util.Scanner;

public class StartMenu {

   Scanner scanner = new Scanner(System.in);
    static int choice;
    static int test;

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
                characters();
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
     public void characters() {
        System.out.println("\nPlease choose a character\n");
        System.out.println("1. Knight");
        System.out.println("2. Wizard");
        System.out.println("3. Thief");
        test = scanner.nextInt();
        switch (test) {
            case 1:
                System.out.println("You have chosen the brave knight\n");
                break;
            case 2:
                System.out.println("You have chosen the intelligent wizard\n");
                break;
            case 3:
                System.out.println("You have chosen the cunning thief\n");
                break;
            default:
                System.out.println("Invalid input, please try again.");

        }

    }
}
package DungeonRun;


import java.util.InputMismatchException;
import java.util.Scanner;


public class MapStart{
    public int chooseStart(int ul, int ur, int ll, int lr){
        Scanner input = new Scanner(System.in);
        boolean runtime = true;
        while (runtime) {
            try {
                System.out.println("Choose corner as starting point\n1.Upper left\n2.Upper right\n3.Lower left\n4.Lower right");
                int dir = input.nextInt();
                switch (dir) {
                    case 1:
                        System.out.println("You chose the upper left corner.");
                        return ul;

                    case 2:
                        System.out.println("You chose the upper right corner.");
                        return ur;

                    case 3:
                        System.out.println("You chose the lower left corner.");
                        return ll;

                    case 4:
                        System.out.println("You chose the lower right corner.");
                        return lr;

                    default:
                        System.out.println("Invalid number");
                        break;
                }
            } catch (InputMismatchException s) {
                System.out.println("Incorrect input");
                input.next();
            }
        }
        return 0;
    }
}
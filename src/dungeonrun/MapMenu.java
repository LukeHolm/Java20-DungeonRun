
import java.util.InputMismatchException;
import java.util.Scanner;


public class MapMenu {
    public void chooseMap() {
        Scanner input = new Scanner(System.in);
        boolean runtime = true;
        while (runtime) {
            try {
                System.out.println("Choose mapsize\n1: 4x4\n2: 5x5\n3: 8x8");
                int size = input.nextInt();
                Map1 c = new Map1();
                switch (size) {
                    case 1:
                        c.choice1();
                        runtime = false;
                        break;

                    case 2:
                        c.choice2();
                        runtime = false;
                        break;

                    case 3:
                        c.choice3();
                        runtime = false;
                        break;

                    default:
                        System.out.println("Option not available");

                }

            } catch (InputMismatchException s) {
                System.out.println("incorrect input");
                input.next();

            }

        }
        System.out.println("\nTime to start your adventure!");
    }
}

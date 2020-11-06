package dungeonrun;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MapMenu {
    public Map1 chooseMap() {
        Scanner input = new Scanner(System.in);
        boolean runtime = true;
        Map1 theMap = null;
        while (runtime) {
            try {
                System.out.println("Choose mapsize\n1: Small\n2: Medium\n3: Big");
                int size = input.nextInt();
         
                switch (size) {
                    case 1:
                        theMap = new Map1(4,4);
                        runtime = false;
                        break;

                    case 2:
                        theMap = new Map1(5,5);
                        runtime = false;
                        break;

                    case 3:
                        theMap = new Map1(8,8);
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
        System.out.println("Time to start your adventure!");
        return theMap;
    }
}

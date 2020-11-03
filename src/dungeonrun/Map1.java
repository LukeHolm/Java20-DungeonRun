

import java.util.Scanner;
import java.util.InputMismatchException;

public class Map1 extends MapStart {
    int value = 1;
    int i;
    int j;
    Scanner input = new Scanner(System.in);


    public void choice1() {
        int[][] map1 = new int[4][4];
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {

                map1[i][j] = value;
                value++;
                System.out.print("[X]" + " ");


            }
            System.out.println();

        }
        int o = chooseStart(1, 4, 13, 16);
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {

                if (map1[i][j] == o) {
                    map1[i][j] = value;
                    value++;
                    System.out.print("[O]" + " ");

                } else {
                    map1[i][j] = value;
                    value++;
                    System.out.print("[X]" + " ");
                }


            }
            System.out.println();

        }

    }


    public void choice2() {
        int[][] map2 = new int[5][5];
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {

                map2[i][j] = value;
                value++;
                System.out.print("[X]" + " ");

            }
            System.out.println();

        }
        int o = chooseStart(1, 5, 21, 25);
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {

                if (map2[i][j] == o) {
                    map2[i][j] = value;
                    value++;
                    System.out.print("[O]" + " ");

                } else {
                    map2[i][j] = value;
                    value++;
                    System.out.print("[X]" + " ");
                }


            }
            System.out.println();

        }
    }

    public void choice3() {
        int[][] map3 = new int[8][8];
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {

                map3[i][j] = value;
                value++;
                System.out.print("[X]" + " ");

            }
            System.out.println();

        }
        int o = chooseStart(1, 8, 57, 64);
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {

                if (map3[i][j] == o) {
                    map3[i][j] = value;
                    value++;
                    System.out.print("[O]" + " ");

                } else {
                    map3[i][j] = value;
                    value++;
                    System.out.print("[X]" + " ");
                }


            }
            System.out.println();

        }
    }
}

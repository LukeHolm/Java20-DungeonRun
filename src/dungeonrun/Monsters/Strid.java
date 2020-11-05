package dungeonrun.Monsters;

import java.util.InputMismatchException;

import java.util.ArrayList;
import java.util.Scanner;

public class Strid {
    public void stridDice() {
        boolean programRunner = true;
        System.out.println("\nNamn: Simon Anveden, Datum: 5/30/2020 \n");
        Scanner input = new Scanner(System.in);
        while (programRunner) {

            try {
                //Main input of program, dictates programRunner
                System.out.print("\nSkriv 1 för att kasta, Skriv 0 för att avsluta: ");
                int mainInput = input.nextInt();

                //if input == 1, proceed with dice
                if (mainInput == 1) {
                    ArrayList<Integer> dice = new ArrayList<>();

                    System.out.print("Välj antal tärningskast mellan 1 och 5: ");
                    int diceRolls = input.nextInt();

                    if (diceRolls > 5 || diceRolls < 1) {
                        throw new Exception("Välj mellan 1 och 5 tärningskast, du valde: " + diceRolls);
                    }
                    int sum = 0;
                    System.out.println();
                    int totalRolls = diceRolls;
                    for (int i = 1; i < totalRolls + 1; i++) {
                        int roll = rollthedice();
                        while (roll == 6) {
                            System.out.println("Resultat Tärning nummer " + i + " är 6, kastar 2 nya tärningar ...");
                            totalRolls += 2;
                            i++;
                            roll = rollthedice();
                        }
                        dice.add(roll);
                        sum += roll;
                        System.out.println("Resultat Tärning nummer " + i + ": " + roll + ", Summa: " + sum);
                    }

                    System.out.println("\nSumma alla tärningar: " + sum);
                    System.out.print("Totalt antal tärningskast: " + totalRolls + "\n");


                } else if (mainInput == 0) {
                    //if input == 0, exit program
                    programRunner = false;
                }

                //if input is neither 1 or 0, inform user of invalid format
                else {
                    System.out.print("Ogiltig inmatning, skriv 1 eller 0. Du skrev: " + mainInput + "\n");
                }

            } catch (Exception e) {
                //Any corrupted or invalid input results in a exception. Inform user that the input is invalid
                System.out.print("Ogiltig inmatning, Försök igen (Måste vara ett heltal)  ...\n");
                System.out.println(e.getMessage() != null ? e.getMessage() : "");
                programRunner = true;
            }
        }

    }
        public static int rollthedice () {
            return (int) (Math.random() * 6) + 1;
        }

}

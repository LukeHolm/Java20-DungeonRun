package dungeonrun;
import dungeonrun.Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Strid extends Creatures{
    ArrayList<Integer> dice = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Room randomMonster = new Room();
    public void stridDice() {
        boolean programRunner = true;


        while (programRunner) {

            try {
                //Main input of program, dictates programRunner
                System.out.print("\nInput '1' to throw dice or '0' to exit: ");
                int mainInput = input.nextInt();





                //if input == 1, proceed with dice
                if (mainInput == 1) {
                    System.out.println(randomMonster.getNextMonster().creatureIsA);
                    int monsterAttack = randomMonster.getNextMonster().attack;
                    System.out.println("Attack: " + monsterAttack);
                    System.out.println(diceRoll(monsterAttack));



//felhantering och exit

                } else if (mainInput == 0) {
                    //if input == 0, exit program
                    programRunner = false;
                }

                //if input is neither 1 or 0, inform user of invalid format
                else {
                    System.out.print("Incorrect input, enter '1' or '0'. You wrote: " + mainInput + "\n");
                }

            } catch (Exception e) {
                //Any corrupted or invalid input results in a exception. Inform user that the input is invalid
                System.out.print("Invalid input. Must be integers...\n");
                System.out.println(e.getMessage() != null ? e.getMessage() : "");
                input.next();
                programRunner = true;
            }
        }

    }

    public static int rollthedice() {
        return (int) (Math.random() * 6) + 1;
    }
    public int diceRoll(int diceRolls){
        System.out.print("Throwing dice!");
        int sum = 0;
        System.out.println();
        for (int i = 1; i < diceRolls + 1; i++) {
            int roll = rollthedice();

            dice.add(roll);
            sum += roll;
            System.out.println("Result of dice number " + i + ": " + roll + ", Sum: " + sum);
        }

        System.out.println("Sum of all dice: " + sum);
        System.out.println("Total amount of throws: " + diceRolls + "\n");
        return sum;

    }

}

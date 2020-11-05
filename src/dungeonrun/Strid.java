package dungeonrun;

import dungeonrun.Characters.Knight;
import dungeonrun.Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Strid {
    ArrayList<Integer> dice = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Room randomRoom = new Room();
    Monster monsterObj = randomRoom.getNextMonster();
    //temp adventurer
    Knight simon = new Knight();


    public void stridDice() {
        boolean programRunner = true;


        while (programRunner) {

            try {
                //Main input of program, dictates programRunner
                System.out.print("\nTo attack press '1' to to run away press '0': ");
                int mainInput = input.nextInt();


                //if input == 1, proceed with dice
                if (mainInput == 1) {
                    System.out.println("You encounter a vicious " + monsterObj.creatureIsA + "!");
                    boolean fight = true;
                    while (fight) {
                        int monsterAtk = diceRoll(monsterObj.attack);
                        int simonDef = diceRoll(simon.agility);


                        System.out.println("The " + monsterObj.creatureIsA + " attacks you for " + monsterAtk + " damage!");
                        System.out.println("You defend yourself for " + simonDef);
                        if (monsterAtk > simonDef) {

                            System.out.println("You took damage! You had " + simon.toughness + " toughness");
                            simon.toughness--;
                            System.out.println("But now you have " + simon.toughness);

                        }
                        if (monsterAtk < simonDef) {
                            System.out.println("You defended yourself from the attack!");
                        } else if (monsterAtk == simonDef) {
                            System.out.println("Draw!");
                        }
                        if (simon.toughness == 0 ) {
                            System.out.println("----------------------------");
                            System.out.println("Simon the brave knight died!");
                            System.out.println("----------------------------");
                            fight = false;
                        }
                        monsterObj.initiative--;
                        if (monsterObj.initiative==0){
                            System.out.println("------------");
                            System.out.println("You made it!");
                            System.out.println("------------");
                            fight = false;
                        }

                    }

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

    public int diceRoll(int diceRolls) {
        //System.out.print("Throwing dice!");
        int sum = 0;
        System.out.println();
        for (int i = 1; i < diceRolls + 1; i++) {
            int roll = rollthedice();

            dice.add(roll);
            sum += roll;
            //System.out.println("Result of dice number " + i + ": " + roll + ", Sum: " + sum);
        }

        //System.out.println("Sum of all dice: " + sum);
        //System.out.println("Total amount of throws: " + diceRolls + "\n");
        return sum;

    }

}

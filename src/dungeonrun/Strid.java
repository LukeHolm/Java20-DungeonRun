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
                System.out.print("\nTo attack press '1' or to run away press '0': ");
                int mainInput = input.nextInt();

                //if input == 1, the player attacks, proceed with dice
                if (mainInput == 1) {
                    System.out.println("You encounter a vicious " + monsterObj.creatureIsA + " and you attack it!");
                    boolean fight = true;
                    while (fight) {
                        int simonAtk = diceRoll(simon.attack);
                        int monsterDef = diceRoll(monsterObj.agility);

                        System.out.println("You attack for " + simonAtk + " damage!");
                        System.out.println("The " + monsterObj.creatureIsA + " defends for " + monsterDef);

                        if (simonAtk > monsterDef) {
                            System.out.println("The monster tooks damage! The monster had " + monsterObj.toughness + " toughness");
                            monsterObj.toughness--;
                            System.out.println("But now the monster has " + monsterObj.toughness);
                        } else if (simonAtk < monsterDef) {
                            System.out.println("The monster defended from the attack!");
                        } else if (simonAtk == monsterDef) {
                            System.out.println("Draw!");
                        }

                        if (monsterObj.toughness == 0) {
                            System.out.println("----------------------------");
                            System.out.println("The monster has been killed!");
                            System.out.println("----------------------------");
                            fight = false;
                            break;
                        }

                        simon.initiative--;
                        if (simon.initiative == 0) {
                            System.out.println("------------");
                            System.out.println("Simon the brave knight died!");
                            System.out.println("------------");
                            fight = false;
                        }
                    }

//felhantering och exit

                } else if (mainInput == 0) {
                    //if input == 0, exit program only when player's chance of escape ... 
                    double chanceEscape = simon.agility * 0.1;
                    double escChance = Math.random();

                    // what to do with chanceEscape? compare it with what? when the player escapes?
                    if (chanceEscape>escChance) {
                        System.out.println("You escaped!");
                        programRunner = false;
                    } else {
                        // monster attacks
                        System.out.println("You faild to escape. The " + monsterObj.creatureIsA + " attacks!");
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

                            } else if (monsterAtk < simonDef) {
                                System.out.println("You defended yourself from the attack!");
                            } else if (monsterAtk == simonDef) {
                                System.out.println("Draw!");
                            }
                            if (simon.toughness == 0) {
                                System.out.println("----------------------------");
                                System.out.println("Simon the brave knight died!");
                                System.out.println("----------------------------");
                                fight = false;
                                break;
                            }

                            monsterObj.initiative--;
                            if (monsterObj.initiative == 0) {
                                System.out.println("------------");
                                System.out.println("You made it!");
                                System.out.println("------------");
                                fight = false;
                            }

                        }
                    }

                    //if input is neither 1 or 0, inform user of invalid format

                }
                else{
                    System.out.print("Incorrect input, enter '1' or '0'. You wrote: " + mainInput + "\n");
                }
                } catch(Exception e){
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

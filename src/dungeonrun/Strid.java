package dungeonrun;

import dungeonrun.Characters.Heroes;
import dungeonrun.Characters.Knight;
import dungeonrun.Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;

public class Strid {
    ArrayList<Integer> dice = new ArrayList<>();
    ArrayList<Monster> monsterList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    Monster monsterObj;

    boolean insideRoom = true;
    //temp adventurer
    Knight simon = new Knight("simon");


    public void stridDice(Map map, Heroes hero) {
        System.out.println("Running stridDice");
    }
/*
        int i = (int) (Math.random() * 4) + 1;
        
        System.out.println("You encounter " + i + " monsters!");


        //temp random list of monsters
        for (int m = 0; m < i; m++) {
            do {
                Room randomRoom = new Room();
                monsterObj = randomRoom.getNextMonster();


            } while (monsterObj == null);
            monsterList.add(monsterObj);
        }
        //END temp random list of monsters


        while (insideRoom) {


            try {

                monsterObj = monsterList.get(monsterList.size() - 1);
                System.out.println("Monsters left in room: " + monsterList.toString());
                System.out.println("\nYou encounter a vicious " + monsterObj.creatureIsA);

                System.out.print("\nTo attack press '1' or to run away press '0': ");
                int mainInput = input.nextInt();

                if (mainInput == 1) {

                    playerAtk();

                    System.out.println("----------------------------");
                    System.out.println("The monster has been killed!");
                    System.out.println("----------------------------");


                    monsterList.remove(monsterList.size() - 1);

                    System.out.println("|||||||||||||||||||||||");
                    System.out.println(monsterList.size() + " monsters left");
                    System.out.println("|||||||||||||||||||||||");
                    if (monsterList.size() == 0) {
                        Treasure.treasureRoll();
                        System.out.println("All monsters are defeated. Leaving room...");
                        break;
                    }
                    System.out.println("Your current toughness: " + simon.toughness);


                } else if (mainInput == 0) {

                    insideRoom = tryEscape();


                    //FELHANTERING
                } else {
                    System.out.print("Incorrect input, enter '1' or '0'. You wrote: " + mainInput + "\n");
                }


            } catch (Exception e) {
                //Any corrupted or invalid input results in a exception. Inform user that the input is invalid
                System.out.print("Invalid input. Must be integers...\n");

                input.next();

            }
            //SLUT FELHANTERING


        }
//outside room

    } */

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

    public void monsterAtk() {
        int monsterAtk = diceRoll(monsterObj.attack);
        int simonDef = diceRoll(simon.agility);
        System.out.println("..............");
        System.out.println("Monster attack");
        System.out.println("..............");
        System.out.println("The " + monsterObj.creatureIsA + " attacks you for " + monsterAtk + " damage!");
        System.out.println("You defend yourself for " + simonDef);
        if (monsterAtk > simonDef) {

            System.out.println("You took damage! You had " + simon.toughness + " toughness");
            simon.toughness--;
            System.out.println("But now you have " + simon.toughness);

        } else if (monsterAtk < simonDef) {
            System.out.println("You defended yourself from the attack!");
        } else {
            System.out.println("Draw!");
        }
        if (simon.toughness == 0) {
            System.out.println("----------------------------");
            System.out.println("Simon the brave knight died!");
            System.out.println("----------------------------");
            System.exit(0);

        }


    }

    public void playerAtk() {

        while (monsterObj.toughness > 0) {
            int playerAtk = diceRoll(simon.attack);
            int monsterDef = diceRoll(monsterObj.agility);
            System.out.println("..............");
            System.out.println("Player attack");
            System.out.println("..............");
            System.out.println("You attack for " + playerAtk + " damage!");
            System.out.println("The " + monsterObj.creatureIsA + " defends for " + monsterDef);

            if (playerAtk > monsterDef) {
                System.out.println("The monster took damage! The monster had " + monsterObj.toughness + " toughness");
                monsterObj.toughness--;
                System.out.println("The monster now has " + monsterObj.toughness);
            } else if (playerAtk < monsterDef) {
                System.out.println("The monster avoided the attack!");
            } else {
                System.out.println("Draw!");
            }
            if (monsterObj.toughness > 0) {
                monsterAtk();
            }
        }

    }

    public boolean tryEscape() {

        double chanceEscape = simon.agility * 0.1;
        double escChance = Math.random();


        if (chanceEscape > escChance) {
            System.out.println("You escaped!");
            //TODO return amount of monsters left in room

            return false;

        }
        if (chanceEscape <= escChance) {
            System.out.println("You failed to escape!");
            monsterAtk();
        }
        return true;
    }

}



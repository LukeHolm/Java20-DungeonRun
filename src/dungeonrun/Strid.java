package dungeonrun;

import dungeonrun.Characters.Knight;
import dungeonrun.Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Strid {
    ArrayList<Integer> dice = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int y = 0;
    Monster monsterObj;
    Room randomRoom;
    boolean insideRoom = true;
    //temp adventurer
    Knight simon = new Knight("simon");


    public void stridDice(/*Map map, Character character*/) {

        int i = (int) (Math.random() * 5) + 1;
        System.out.println("You encounter " + i + " monsters!");
        Map map = new Map(4, 4);
        GiantSpider spider = new GiantSpider();
        Orc orc = new Orc();
        //randomRoom.monsters.add(spider);
        //randomRoom.monsters.add(orc);


        while (insideRoom) {
            while (i>y) {
            do {
                Room randomRoom = new Room();
                monsterObj = randomRoom.getNextMonster();


            } while (monsterObj == null);

                try {
                    System.out.println("\nYou encounter a vicious " + monsterObj.creatureIsA);

                    System.out.print("\nTo attack press '1' or to run away press '0': ");
                    int mainInput = input.nextInt();

                    if (mainInput == 1) {

                        playerAtk();

                        System.out.println("----------------------------");
                        System.out.println("The monster has been killed!");
                        System.out.println("----------------------------");
                        //randomRoom.defeatedMonster(monsterObj);
                        y++;
                        System.out.println("|||||||||||||||||||||||");
                        System.out.println((i - y) + " monsters left");
                        System.out.println("|||||||||||||||||||||||");
                        System.out.println("Your current toughness: " + simon.toughness);


                    } else if (mainInput == 0) {
                        tryEscape();


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
            System.out.println("You defeated all the monsters in this room!");
            insideRoom=false;

        }
//outside room

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

    public void tryEscape() {

        double chanceEscape = simon.agility * 0.1;
        double escChance = Math.random();


        if (chanceEscape > escChance) {
            System.out.println("You escaped!");
            System.exit(0);
            insideRoom=false;


        }
        if (chanceEscape <= escChance) {
            System.out.println("You failed to escape!");
            monsterAtk();
        }

    }

}



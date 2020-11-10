package dungeonrun;

import dungeonrun.Characters.Knight;
import dungeonrun.Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Strid {
    ArrayList<Integer> dice = new ArrayList<>();
    // monsterList contains the remaining number of monster existed in the rum, when player is killed
    ArrayList<Monster> monsterList = new ArrayList<>(); 
    Scanner input = new Scanner(System.in);
    int noMonsters = 0;
    
    Monster monsterObj;

    boolean insideRoom = true;
    //temp adventurer
    Knight simon = new Knight("simon");

    public void stridDice(/*Map map, Character character*/) {

        noMonsters = (int) (Math.random() * 4) + 1;
        System.out.println("You encounter " + noMonsters + " monsters!");

        //temp random list of monsters
        for (int m = 0; m < noMonsters; m++) {
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

                    //the player attacks; if wins then monster is deleted from the list, else exit 
                	if ( playerAtk() == true ) {
	                    System.out.println("----------------------------");
	                    System.out.println("The monster has been killed!");
	                    System.out.println("----------------------------");
	
	                    deleteMonster();
	
	                    System.out.println("|||||||||||||||||||||||");
	                    System.out.println(monsterList.size() + " monsters left");
	                    System.out.println("|||||||||||||||||||||||");
	                    if (monsterList.size() == 0) {
	                        Treasure.treasureRoll();
	                        System.out.println("All monsters are defeated. Leaving room...");
	                        break;
	                    }
	                    System.out.println("Your current toughness: " + simon.toughness);
                    } else {
                    	//if player is defeated, then exit
                    	System.exit(0);
                    }

                } else if (mainInput == 0) {
                    insideRoom = !tryEscape();
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

    }

    // returns list of monsters that contains the remaining monsters after the fight 
    public ArrayList<Monster> noMonstersList() {
    	return monsterList;
    }
    
    // remove a monster from a list, when the monster was defeated
    private void deleteMonster()
    {
    	monsterList.remove(monsterList.size() - 1);
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

    public boolean monsterAtk() {
    	// if monster defeats the player, then return true; return false in the opposite case
    	boolean defeatPlayer = false;
        int monsterAtk = diceRoll(monsterObj.attack);
        int simonDef = diceRoll(simon.agility);
        
        System.out.println("..............");
        System.out.println("Monster attacks");
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

        // if player defended the attack, it's his turn to attack
        if(simon.toughness > 0) {
        	// it takes the opposite value of the playerAtk()
        	defeatPlayer = !playerAtk();
        } else {
            System.out.println("----------------------------");
            System.out.println("Simon the brave knight died!");
            System.out.println("----------------------------");
            defeatPlayer = true;
        }
        
        return defeatPlayer;
    }

    public boolean playerAtk() {
    	// if player defeats the monster, then return true; return false in the opposite case
    	boolean defeatMonster = false;

            int playerAtk = diceRoll(simon.attack);
            int monsterDef = diceRoll(monsterObj.agility);
            System.out.println("..............");
            System.out.println("Player attacks");
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
            
            // if monster defended the attack, it's his turn to attack
            if (monsterObj.toughness > 0) {
            	// it takes the opposite value of the monsterAtk()
                defeatMonster = !monsterAtk();
            } else {
            	System.out.println("You defeated the monster!");
            	defeatMonster = true;
            }
        return defeatMonster;
    }

    // returns true if the player escapes; otherwise (when the monster defeats the player) returns false
    public boolean tryEscape() {

        double chancePlayerEscape = simon.agility * 0.1;
        double escChanceRandom = Math.random();
        boolean escape = false;

        if (chancePlayerEscape > escChanceRandom) {
            System.out.println("You escaped!");
            escape = true;
        }else {
            System.out.println("You failed to escape!");
            
            // the player cannot escape and the monster attacks
            // if the player wins, then he escapes the room
            // if the player is defeated by the monster, return false
            if ( monsterAtk() == false ) {
            	escape = true;
            	deleteMonster();
            } else {
            	escape = false;
            }          
        }
        return escape;
    }

}



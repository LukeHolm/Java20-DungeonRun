package dungeonrun;
import dungeonrun.Characters.Heroes;
import dungeonrun.Monsters.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Strid {
    public static final String BR_RED = "\u001b[31;1m";
    public static final String RESET = "\u001b[0m";
    public static final String BR_GREEN = "\u001b[32;1m";
    public static final String GREEN = "\u001b[32m";
    ArrayList<Integer> dice = new ArrayList<>();
    ArrayList<Monster> monsterList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Heroes hero;
    Monster monsterObj;
    Map map;
    boolean insideRoom = true;

    public void stridDice(Map map, Heroes hero) {
        this.hero = hero;
        this.map = map;
        monsterList.addAll(map.rooms[hero.mapPosX][hero.mapPosY].monsters);

        int x = 0;
        int heroTurn = diceRoll(hero.initiative);
        ArrayList<Monster> iniList = new ArrayList<>();
        ArrayList<Integer> orderList = new ArrayList<>();
        for (Monster monster : monsterList) {
            monsterObj = monster;

            int y = diceRoll(monsterObj.initiative);
            if (y > x) {
                iniList.add(0, monsterObj);
                orderList.add(0, y);
            } else {
                iniList.add(monsterObj);
                orderList.add(y);
            }
            x = y;
        }

        while (insideRoom) {

            try {
                monsterObj = iniList.get(0);
                System.out.println("Monsters left in room: " + iniList.toString());
                System.out.println("\nEncounter against " + monsterObj.creatureIsA + " started");
                if (heroTurn < orderList.get(0)) {
                    System.out.println("The monster threw " + orderList.get(0) + " while you threw " + heroTurn + ". The monster attacks first!");
                    monsterAtk();
                    orderList.set(0,0);
                }

                System.out.print("\nTo attack press '1' or to run away press '0': ");
                int mainInput = input.nextInt();

                if (mainInput == 1) {

                    playerAtk();
                    if (monsterObj.toughness == 0) {
                        System.out.println("----------------------------");
                        System.out.println("The monster has been killed!");
                        System.out.println("----------------------------");

                        iniList.remove(iniList.get(0));
                        System.out.println("|||||||||||||||||||||||");
                        System.out.println(iniList.size() + " monsters left");
                        System.out.println("|||||||||||||||||||||||");
                    }
                    if (iniList.size() == 0) {

                        System.out.println(GREEN + "Leaving room..." + RESET);
                        break;
                    }
                    System.out.println("Your current toughness: " + hero.toughness);


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
        map.rooms[hero.mapPosX][hero.mapPosY].monsters.clear();
        map.rooms[hero.mapPosX][hero.mapPosY].monsters.addAll(iniList);
    }


    public static int rollthedice() {
        return (int) (Math.random() * 6) + 1;
    }

    public int diceRoll(int diceRolls) {

        int sum = 0;
        System.out.println();
        for (int i = 1; i < diceRolls + 1; i++) {
            int roll = rollthedice();
            dice.add(roll);
            sum += roll;
        }
        return sum;
    }

    public void monsterAtk() {
        int monsterAtk = diceRoll(monsterObj.attack);
        int simonDef = diceRoll(hero.agility);
        System.out.println("..............");
        System.out.println("Monster attack");
        System.out.println("..............");
        System.out.println("The " + monsterObj.creatureIsA + " attacks you for " + monsterAtk + " damage!");
        System.out.println("You defend yourself for " + simonDef);
        if (monsterAtk > simonDef) {

            System.out.println(BR_RED + "You took damage! You had " + hero.toughness + " toughness");
            hero.toughness--;
            System.out.println("But now you have " + hero.toughness + RESET);

        } else if (monsterAtk < simonDef) {
            System.out.println("You defended yourself from the attack!");
        } else {
            System.out.println("Draw!");
        }
        if (hero.toughness == 0) {
            System.out.println("----------------------------");
            System.out.println("You died!");
            System.out.println("----------------------------");
            System.exit(0);

        }


    }

    public void playerAtk() {


        int playerAtk = diceRoll(hero.attack);
        int monsterDef = diceRoll(monsterObj.agility);
        System.out.println("..............");
        System.out.println("Player attack");
        System.out.println("..............");
        System.out.println("You attack for " + playerAtk + " damage!");
        System.out.println("The " + monsterObj.creatureIsA + " defends for " + monsterDef);

        if (playerAtk > monsterDef) {
            System.out.println(BR_GREEN + "The monster took damage! The monster had " + monsterObj.toughness + " toughness");
            monsterObj.toughness--;
            System.out.println("The monster now has " + monsterObj.toughness + RESET);
        } else if (playerAtk < monsterDef) {
            System.out.println("The monster avoided the attack!");
        } else {
            System.out.println("Draw!");
        }
        if (monsterObj.toughness > 0) {
            monsterAtk();
        }


    }

    public boolean tryEscape() {

        double chanceEscape = hero.agility * 0.1;
        double escChance = Math.random();


        if (chanceEscape > escChance) {
            System.out.println("You escaped!");


            return false;

        }
        if (chanceEscape <= escChance) {
            System.out.println("You failed to escape!");
            monsterAtk();
        }
        return true;
    }

}



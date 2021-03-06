package dungeonrun;

import dungeonrun.Characters.Heroes;
import static dungeonrun.Main.music;
import dungeonrun.Monsters.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Strid {

    static String wizardspecial = "WizardSpecial.wav";
    static String thiefspecial = "ThiefSpecial.wav";
    static String knightspecial = "KnightSpecial.wav";
    static String humandeath = "humandeath.wav";
    static String gameover = "gameover.wav";
    static String spiderdead = "spiderdeath.wav";
    static String skeletondead = "skeletondeath.wav";
    static String trolldead = "trolldeath.wav";
    static String orcdead = "orcdeath.wav";
    static String knightAttack = "KnightAttack1.wav";
    static String thiefAttack = "ThiefAttack1.wav";
    static String wizardAttack = "WizardAttack1.wav";
    static String blocked = "knightblocked.wav";
    public static final String BR_RED = "\u001b[31;1m";
    public static final String RESET = "\u001b[0m";
    public static final String BR_GREEN = "\u001b[32;1m";
    public static final String GREEN = "\u001b[32m";
    public static final String BR_BLUE = "\u001b[34;1m";
    public static boolean tryLoot = true;
    ArrayList<Integer> dice = new ArrayList<>();
    ArrayList<Monster> monsterList = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Heroes hero;
    Monster monsterObj;
    Map map;
    boolean insideRoom = true;
    int knightBlock;

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
        System.out.println("Monsters turn order throws: " + orderList.toString());
        System.out.println("Hero turn order throw: " + heroTurn);
        music.StopDungeonmusic();
        music.PlayBattleMusic();
        while (insideRoom) {

            try {
                monsterObj = iniList.get(0);

                System.out.println("\nEncounter against " + monsterObj.creatureIsA + " started\n");
                if (heroTurn < orderList.get(0)) {
                    System.out.println("The monster threw " + orderList.get(0) + " while you threw " + heroTurn + ". The monster attacks first!");
                    monsterAtk();
                    orderList.set(0, 0);
                }

                System.out.print("\nTo attack press '1' or to run away press '0': ");
                int mainInput = input.nextInt();

                if (mainInput == 1) {

                    playerAtk();
                    if (monsterObj.toughness <= 0) {
                        if (monsterObj.attack == 2) {
                            music.playMusic(spiderdead);
                        }
                        if(monsterObj.attack == 3){
                            music.playMusic(skeletondead);
                        }
                        if(monsterObj.attack == 4){
                            music.playMusic(orcdead);
                        }
                        if(monsterObj.attack == 7){
                            music.playMusic(trolldead);
                        }
                        System.out.println("         />_________________________________\n"
                                + "[########[]_________________________________>\n"
                                + "         \\>");
                        System.out.println("           The monster has been killed!");
                        System.out.println("         />_________________________________\n"
                                + "[########[]_________________________________>\n"
                                + "         \\>");

                        orderList.remove(0);

                        iniList.remove(iniList.get(0));
                        System.out.println("|||||||||||||||||||||||");
                        System.out.println(iniList.size() + " monsters left");
                        System.out.println("|||||||||||||||||||||||");
                    }
                    if (iniList.size() == 0) {
                        knightBlock = 0;

                        System.out.println("Press \"ENTER\" to pick up treasures and continue your adventure...");
                        Scanner scanner = new Scanner(System.in);
                        scanner.nextLine();
                        music.StopBattle();
                        music.playDungeonmusic();
                        break;
                    }

                    System.out.println("\nMonsters left in room: " + iniList.toString());
                } else if (mainInput == 0) {

                    tryLoot = tryEscape();
                    insideRoom = tryLoot;

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
        knightBlock++;
        int monsterAtk = diceRoll(monsterObj.attack);
        int simonDef = diceRoll(hero.agility);
        System.out.println("..............");
        System.out.println("Monster attack ");
        System.out.println("..............");
        if (knightBlock == 1 && hero.creatureIsA.equals("Knight")) {
            System.out.println("|`-._/\\_.-`|");
            System.out.println("|    ||    |");
            System.out.println("|___o()o___|");
            System.out.println("|__((<>))__|");
            System.out.println("\\   o\\/o   /");
            System.out.println(" \\   ||   /");
            System.out.println("  \\  ||  /");
            System.out.println("   '.||.'");
            System.out.println("     ``");
            System.out.println("..............");
            System.out.println("  SHIELD UP");
            System.out.println("..............");
            System.out.println("\n" + BR_BLUE + hero.playersName + " the Knight blocks the first attack of the fight!\n" + RESET);
            music.playMusic(knightspecial);

        } else {
            System.out.println("The " + monsterObj.creatureIsA + " attacks you for " + monsterAtk + " damage!");
            System.out.println("You defend yourself for " + simonDef);
            if (monsterAtk > simonDef) {
                System.out.println(BR_RED + "You took damage! You had " + hero.toughness + " toughness");
                hero.toughness--;
                 music.Random();
                System.out.println("But now you have " + hero.toughness + RESET + "\n");
            } else if (monsterAtk < simonDef) {
                System.out.println("You defended yourself from the attack!");
                music.playMusic(blocked);
            } else {
                System.out.println("Draw!");
            }
            if (hero.toughness == 0) {
                try {
                    System.out.println("----------------------------");
                    System.out.println("You died!");
                    System.out.println("----------------------------");
                    music.StopBattle();
                    music.playMusic(gameover);
                    music.playMusic(humandeath);
                    TimeUnit.SECONDS.sleep(4);
                    System.exit(0);
                } catch (InterruptedException ex) {

                }

            }
        }
    }

    public void playerAtk() {
        boolean thiefSpecial = false;

        int playerAtk = diceRoll(hero.attack);
        int monsterDef = diceRoll(monsterObj.agility);
        System.out.println("..............");
        System.out.println("Player attack");
        System.out.println("..............");
        attackSound();
        System.out.println("You attack for " + playerAtk + " damage!");
        System.out.println("The " + monsterObj.creatureIsA + " defends for " + monsterDef);

        if (playerAtk > monsterDef) {
            if (hero.creatureIsA.equals("Thief")) {
                double specialAttack = 0.25;
                double specialChance = Math.random();
                if (specialAttack >= specialChance) {

                    System.out.println("___   ___  ___  ");
                    System.out.println("\\  \\ /  / |__ \\");
                    System.out.println(" \\  V  /     ) | ");
                    System.out.println("  >   <     / / ");
                    System.out.println(" /  .  \\   / /_ ");
                    System.out.println("/__/ \\__\\ |____|");
                    System.out.println(BR_BLUE + "\nCritical Hit! " + hero.playersName + " hits extra hard with the crowbar and the monster takes double damage!\n" + RESET);
                    music.playMusic(thiefspecial);
                    thiefSpecial = true;

                } else {
                    thiefSpecial = false;
                }
            }
            System.out.println(BR_GREEN + "The monster took damage! The monster had " + monsterObj.toughness + " toughness");
            if (thiefSpecial) {
                monsterObj.toughness--;
                monsterObj.toughness--;
            } else {
                monsterObj.toughness--;
            }

            System.out.println("The monster now has " + monsterObj.toughness + RESET + "\n");
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
        if (hero.creatureIsA.equals("Wizard")) {
            chanceEscape = hero.agility * 0.16;
            System.out.println("  .   . ?? '  ,  ,");
            System.out.println("       \\  |  //");
            System.out.println("     \\   _^_     /");
            System.out.println(" ??  __  ( ?? )  __");
            System.out.println("    ,    |/|    ??");
            System.out.println("   /     |??|    \\ ");
            System.out.println("??    ??   |^|      ?? ");
            System.out.println("         |<|");
            System.out.println("         |>| ");
            System.out.println(hero.playersName + BR_BLUE + " The Wizard raises the Staff of Light and fires a big glowing orb towards the enemies to blind them, giving it a higher chance to escape!" + RESET);
            music.playMusic(wizardspecial);

        }

        if (chanceEscape > escChance) {
            System.out.println(GREEN + "You escaped!" + RESET);
            knightBlock = 0;
            music.StopBattle();
            music.playDungeonmusic();

            return false;

        }
        if (chanceEscape <= escChance) {
            System.out.println(BR_RED + "You failed to escape!" + RESET);
            monsterAtk();
            return true;
        } else {
            return false;
        }
    }

    public void attackSound() {
        if (hero.creatureIsA.equalsIgnoreCase("Wizard")) {
            music.playMusic(wizardAttack);
        } else if (hero.creatureIsA.equalsIgnoreCase("Knight")) {
            music.playMusic(knightAttack);
        } else {
            music.playMusic(thiefAttack);
        }
    }

}

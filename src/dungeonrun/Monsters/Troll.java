package dungeonrun.Monsters;

import dungeonrun.Monsters.Monster;

public class Troll extends Monster {
    
    public Troll (){
        creatureIsA = "Troll";

        initiative = 2;
        toughness = 4;
        attack = 7;
        agility = 2;
        frequency = 0.05;         //frequency = 5%
    }

    @Override
    public String toString() {
        return "Troll";
    }
    
    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
        		"                            ",
        		"           .                ",
        		"          ..                ",
        		"        .:::.               ",
        		"       .:\\:/:.             ",//row5
        		"     .:\\:\\:/:/:.          ",
        		"    :.:\\:\\:/:/:.:         ",
        		"   :=.' -   - '.=:          ",
        		"   '=(\\ 9   9 /)='         ",
        		"      (  (_)  )             ",//row10
        		"      /`-vvv-'\\            ",
        		"     /         \\           ",
        		"    / /|,,,,,|\\ \\         ",
        		"   /_//  /^\\  \\\\_\\      ",
        		"   WW(  (   )  )WW          ",//row15
        		"      \\,,\\ /,,/           ",
        		"      ||  |||  |            ",
        		"    __||  |||  |__          ",
        		"   (_______Y______)         ",
        		"                            ",//row20
        		"                            "};
            //   1234567890123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}

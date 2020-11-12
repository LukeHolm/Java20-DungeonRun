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

        String[] ascii = {
        		"                   ",
        		"     .:£:/:.       ",
        		"   .:£:£:/:/:.     ",
        		"  :.:£:£:/:/:.:    ",
        		" :=.' -   - '.=:   ",
        		" '=(£ 9   9 /)='   ",
        		"    (  (_)  )      ",
        		"    /`-vvv-'£      ",
        		"   /         £     ",
        		"  / /|,,,,,|£ £    ",
        		" /_//  /^£  ££_£   ",
        		" WW(  (   )  )WW   ",
        		"  __£,,£ /,,/__    ",
        		" (______Y______)   ",
        		"                   "};
        
        String[] fixedAscii = ascii;

        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }

        return fixedAscii;
    }
}

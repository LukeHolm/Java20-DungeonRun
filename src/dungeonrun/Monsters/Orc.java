package dungeonrun.Monsters;

import dungeonrun.Monsters.Monster;

public class Orc extends Monster {
    
    public Orc() {
        creatureIsA = "Orc";

        initiative = 6;
        toughness = 3;
        attack = 4;
        agility = 4;
        frequency = 0.1;         //frequency = 10%

    }

    @Override
    public String toString() {
        return "Orc";
    }
    
    @Override
    public String[] displayStrings() {

        String[] ascii = {
        		 "            ,      ,         ", 
        		 "           /(.-''-.)£        ",
        		 "       |£  £/      £/  /|    ",
        		 "       | £ / =.  .= £ / |    ",
        		 "       £( £   o£/o   / )/    ",
        		 "        \\_, '-/  £-' ,_/    ",
        		 "          /   £__/   £       ",
        		 "          £,___/£___,/       ",
        		 "        ___£ £|uu|/ /___     ",
        		 "      /`    £ .--. /    `£   ",
        		 "     /       '----'       £  "};
        
        return ascii;
    }
}

package dungeonrun.Monsters;

import dungeonrun.Monsters.Monster;

public class GiantSpider extends Monster {
    
    public GiantSpider(){
        creatureIsA = "Giant Spider";

        initiative = 7;
        toughness = 1;
        attack = 2;
        agility = 3;
        frequency = 0.2;        //frequency = 20%
    }

    @Override
    public String toString() {
        return "GiantSpider";
    }
    
    @Override
    public String[] displayStrings() {
    	
        String[] ascii = {
        "                     ",
        "                     ",
        "       |    |        ",		
	    "      /      £       ",   
	    "   £  £  ,,  /  /    ",
	    "    '-.`£()/`.-'     ",
	    "   .--_'(  )'_--. 	  ",
	    "  / /` /`''`£ `£ £   ",
	    "   |  |  ><  |  |    ",
	    "   £  £      /  /    ",
	    "       '.__.'        ",
	    "                     ",
	    "  "};
        
        String[] fixedAscii = ascii;

        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }

        return fixedAscii;
    }
}
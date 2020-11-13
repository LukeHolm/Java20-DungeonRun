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
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
        		   "                            ",
        		   "  /|                        ",
        		   "  ||                        ",
        		   "  ||        |       |       ",                           
        		   "  ||        |       |       ",//row 5
        		   "  ||      ,/  _____  £.     ",    
        		   "  ||      ||_/     £_||     ",        
        		   "  ||       £_| . . |_/      ",        
        		   "  ||         |  L  |        ",        
        		   " ,||         |`==='|        ", //row 10        
        		   " |>|      ___`>  -<'___     ",        
        		   " |>|£    /             £    ",        
        		   " £>| £  /  ,    .    .  |   ",        
        		   "  ||  £/  /| .  |  . |  |   ",        
        		   "  ||£  ` / | ___|___ |  |   ",       
        		   "  || `--'  | _______ |  |   ",//row 15   
        		   "  || (  )£ | - --- - | -| ( ", 
        		   "  || ))/ ( | -- - -- |  | ))", 
        		   "()||((( ())|         |  |( (", 
        		   "                            ",
        		   "                            ",//row 20
        		   "                            "};
               //   1234567890123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}

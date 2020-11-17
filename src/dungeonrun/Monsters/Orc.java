package dungeonrun.Monsters;

import dungeonrun.Map;

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
        // Here you can use "£"instead of "\\"so the rows lines up, and it will be replaced with "\"in the code below 
        String[] ascii = {
            "                            ",  
            " /|                         ",  
            " ||        |       |        ",  
            " ||        |       |        ",  
            " ||      ,/  _____  £.      ", //row 5
            " ||      ||_/     £_||      ",  
            " ||       £_| . . |_/       ",  
            " ||         |  L  |         ",  
            " ||         | -o- |         ",  
            " ||,     ___`>  -<'___      ", //row 10
            " B|3    /             £     ",  
            " || £  /  ,    .    .  |    ",
            " ||£ £/  /| .  :  . |  |    ",
            " |||  ` / | ___:___ |  |    ",
            " || `--'  | -- - -- |(  £   ", //row 15 
            " ||       /         £ `£ £  ",
            " ||      /    /^£    £  £ £ ",
            " ||     (    /   £    )  WW ",
            " ||      £   £   /   /      ",  
            " ||   ,n__£   £ /   /__n.   ", //row 20
            " ||   `-______) (______-´   "};

        String[] colors = {
            "                            ",  
            " m|                         ",  
            " m|        m       |        ",  
            " m|        m       |        ",  
            " m|      m/  h____  m.      ", //row 5
            " m|      m|mh     £rm|      ",  
            " m|       m_h y . hm/       ",  
            " m|         h  L  h         ",  
            " m|         h s=- h         ",  
            " m|h     r__hh  -<'r__      ", //row 10
            " hmh    r             £     ",  
            " m| r  /  ,    .    .  |    ",
            " m|r £/  /| .  :  . |  |    ",
            " m|r  ` / | ___:___ |  |    ",
            " m| r--'  | -- - -- |(  £   ", //row 15 
            " m|       r         £ `£ £  ",
            " m|      r    /^£    £  £ £ ",
            " m|     r    /   £    )  hW ",
            " m|      r   £   /   /      ",  
            " m|   r*__£   £ /   /__*.   ", //row 20
            " m|   r-______) (______-´   "};
        
        String str;
        String[] coloredAscii = new String[ascii.length];
        char chr;
        for (int row = 0; row < ascii.length; row++) {
            // Replace '£' with '\' and replace '§' with '"'
            ascii[row] = ascii[row].replace("£", "\\");
            ascii[row] = ascii[row].replace("§", "\"");

            str = "";
            for (int x = 0; x < ascii[row].length(); x++) {

                // Get the corresponding location in the color strings, and check if it's lower case letter
                chr = colors[row].charAt(x);

                if (Character.isLowerCase(chr)) {
                    //  Lookup the corresponding color code, and add it to the output string
                    str += Map.colorLookup[(int) (chr - 'a')];
                }
                // Always add the chracter from the ascii strings
                str += ascii[row].charAt(x);
            }
            coloredAscii[row] = str;
        }
        return coloredAscii;
    }
}

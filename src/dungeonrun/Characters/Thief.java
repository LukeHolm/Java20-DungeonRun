package dungeonrun.Characters;

;

import dungeonrun.Map;

public class Thief extends Heroes {

    public Thief(String playersName) {
        super(playersName);
        creatureIsA = "Thief";
        initiative = 7;
        toughness = 5;
        attack = 5;
        agility = 7;
    }

    public void specialAbility() {
        //"Critical hit". Theif has 25% chance to do double damage every time Thief attacks.
    }

    @Override
    public String toString() {
        return "Thief name is " + playersName + "\n";
    }

    @Override
    public String[] displayStrings() {
        // Characters like '\' and '" 'messes upp the line lengths, since you need to write \\ and \" to get them in a string. 
        // Kan use '£' for '\' and '§' for '"' here, because of the replacement code below.
        String[] ascii = {
            "                            ",
            "      ___                   ",
            "         /      .--._       ",
            "        |      '---._)      ",
            "        |,      Q,Q,)       ",
            "        B3      £- /        ", // Row 5
            "        | |_.---;-'---,._   ",
            "        |£  '  o-----o   )  ",
            "        | £   /H  ___H£  /  ",
            "        |  '-' £§§)£__/  |  ", // Row 10
            "        £     _|__='-)__/   ",
            "         £   /  '.    £     ",
            "            /         /     ",
            "           |         /      ",
            "           |___/£|   |      ", // Row 15
            "            |_|  |   |      ",
            "           /  )  £   £      ",
            "          (__/    £___£     ",
            "                    £_£     ",
            "                    /  )    ", // Row 20
            "                   (__/     "};
        //   1234567890123456789012345678 

        String[] color = {
            "                            ",
            "      e__                   ",
            "         e      g--._       ",
            "        e      g---._)      ",
            "        eg      dgdg)       ",
            "        gg      £r g        ", // Row 5
            "        e g_.---;-'---,._   ",
            "        eg  '  o-----o   )  ",
            "        e g   /H  ___H£  /  ",
            "        e  g-' £§§)£__/  |  ", // Row 10
            "        e     g|__='-)__/   ",
            "         e   g  '.    £     ",
            "            /         /     ",
            "           |         /      ",
            "           |___/£|   |      ", // Row 15
            "            |eg  |   |      ",
            "           e  )  g   £      ",
            "          e__/    g___£     ",
            "                    geg     ",
            "                    e  )    ", // Row 20
            "                   e__/     "};
        //   1234567890123456789012345678 

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
                chr = color[row].charAt(x);

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

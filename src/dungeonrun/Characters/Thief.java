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
            "  ___                       ",
            "     /      .--._           ",
            "    |      '---._)          ",
            "    |       Q,Q,)           ",
            "    |,      £- /  ___       ", // Row 5
            "    B3. .---;-'-/,._  £     ",
            "    |£ £'       B3  £   £   ",
            "    | £   /     £ £  £   £  ",
            "    |  '-'£      £ ` |    £ ", // Row 10
            "    £     _|--8--|'-'     | ",
            "     £   /   ,    )       / ",
            "       (     .    /£_____/  ",
            "       |     /   /          ",
            "       |___/ |   |          ", // Row 15
            "        |_| (    |          ",
            "       /  )  £   £          ",
            "      (__/    £___£         ",
            "                £_£         ",
            "                /  )        ", // Row 20
            "               (__/         "};
        //   1234567890123456789012345678 

        String[] color = {
            "                            ",
            "  m__                       ",
            "     m      g--._           ",
            "    m      g---._)          ",
            "    m      ddzdzz           ", // Row 5
            "    mz      £r z  b__       ", 
            "    z3. g---;-zgb,.g b£     ",
            "    mg£'        z3. g   b   ",
            "    m g   /     £  | |   b  ",
            "    m  g-' £     £   |    b ", // Row 10
            "    m     g|--8--|'-'     b ",
            "     m   g   ´    g       b ",
            "       (          /b_____/  ",
            "       |     /   /          ",
            "       |___/ |   |          ", // Row 15
            "        zmz g    |          ",
            "       m  )  g   £          ",
            "      m__/    g___£         ",
            "                zmz         ",
            "                m  )        ", // Row 20
            "               m__/         "};
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

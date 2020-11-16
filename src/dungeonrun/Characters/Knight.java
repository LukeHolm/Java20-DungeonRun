package dungeonrun.Characters;

import dungeonrun.Map;

public class Knight extends Heroes {

    public Knight(String playersName) {
        super(playersName);
        creatureIsA = "Knight";
        initiative = 5;
        toughness = 9;
        attack = 6;
        agility = 4;
    }

    public void specialAbility() {
        //"Shield block". Blocks first attack of every encounter
    }

    @Override
    public String toString() {
        return "Knight name is " + playersName + "\n";
    }

    @Override
    public String[] displayStrings() {
        // Characters like '\' and '" 'messes upp the line lengths, since you need to write \\ and \" to get them in a string. 
        // Kan use '£' for '\' and '§' for '"' here, because of the replacement code below.
        String[] ascii = {
            "                            ",
            "|£                          ",
            " ££             //          ",
            "  ££           _!_          ", // Row 5
            "   ££         /___£         ",
            "    ££        [+++]         ",
            "     ££    _ _£^^^/_ _      ",
            "      ££_ (    '-'  (  )    ",
            "     /( £ | |  _|_  || |    ", // Row 10
            "       £ £` |   |   /£ £    ",
            "        £  / £  |  / _> )   ",
            "         ^`  >::::;-'`^^'-. ",
            "             /:::/         £",
            "            /    |   { }   |", // Row 215
            "           /   /|£         /",
            "          /   / | '-.___.-' ",
            "         (   /  (   |       ",
            "         /  /    £  £       ",
            "        /  /      £  £      ",
            "     __/  /       _£  £     ", // Row 20
            "    /_____|      /_____|    "};
        //   1234567890123456789012345678

        String[] color = {
            "                            ",
            "m£                          ",
            " m£             ww          ",
            "  m£           gwg          ", // Row 5
            "   m£         g___£         ",
            "    m£        ge++g         ",
            "     m£    g _£e^^g_ _      ",
            "      m£_ g    '-'  (  )    ",
            "     mg £ / |  r__  g| |    ", // Row 10
            "       £ £/ |   r   g£ £    ",
            "        £  / £  r  g _> )   ",
            "         ^`  >::::;m'`^^'-. ",
            "             /:::m         £",
            "            /    m   b }   m", // Row 215
            "           /   /|m         /",
            "          /   / | m-.___.-' ",
            "         (   /  (   |       ",
            "         /  /    £  £       ",
            "        /  /      £  £      ",
            "     __/  /       _£  £     ", // Row 20
            "    /_____|      /_____|    "};
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

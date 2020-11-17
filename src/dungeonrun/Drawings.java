package dungeonrun;

public class Drawings {

    public static void drawCastle() {

        String[] ascii = {
            "         |>>>                                                      |>>>             ",
            "         |                     |>>>          |>>>                  |                ",
            "         *                     |             |                     *                ",
            "        / £                    *             *                    / £               ",
            "       /___£                 _/ £           / £_                 /___£              ",
            "       [   ]                |/   £_________/   £|                [   ]              ",
            "       [ I ]                /     £       /     £                [ I ]              ",
            "       [   ]_ _ _          /       £     /       £          _ _ _[   ]              ",
            "       [   ] U U |        {#########}   {#########}        | U U [   ]              ",
            "       [   ]====/          £=======/     £=======/          £====[   ]              ",
            "       [   ]    |           |   I |_ _ _ _| I   |           |    [   ]              ",
            "       [___]    |_ _ _ _ _ _|     | U U U |     |_ _ _ _ _ _|    [___]              ",
            "       £===/  I | U U U U U |     |=======|     | U U U U U | I  £===/              ",
            "        £=/     |===========| I   | + W + |   I |===========|     £=/               ",
            "         |  I   |           |     |_______|     |           |   I  |                ",
            "         |      |           |     |||||||||     |           |      |                ",
            "         |      |           |   I ||vvvvv|| I   |           |      |                ",
            " _-_-_-_-|______|-----------|_____||     ||_____|-----------|______|-_-_-_-_        ",
            "~    ~  /________£         /______||     ||______£         /________£      ~        ",
            "  ~    |__________|-------|________£_____/________|-------|__________|  ~     ~     ",
            "     ~      ~      ~      ~      ~      ~      ~      ~      ~      ~      ~        "};

        String[] colors = {
            "y        ycrgy                                                     ycrgy            ",
            "y        |                     ycrgy         ycrgy                 |                ",
            "y        *                     |             |                     *                ",
            "y       / £                    *             *                    / £               ",
            "y      /___£                 _/ £           / £_                 /___£              ",
            "y      [   ]                |/   £_________/   £|                [   ]              ",
            "y      [ I ]                /     £       /     £                [ I ]              ",
            "y      [   ]_ _ _          /       £     /       £          _ _ _[   ]              ",
            "y      [   ] U U |        {#########}   {#########}        | U U [   ]              ",
            "y      [   ]====/          £=======/     £=======/          £====[   ]              ",
            "y      [   ]    |           |   I |_ _ _ _| I   |           |    [   ]              ",
            "y      [___]    |_ _ _ _ _ _|     | U U U |     |_ _ _ _ _ _|    [___]              ",
            "y      £===/  I | U U U U U |     |=======|     | U U U U U | I  £===/              ",
            "y       £=/     |===========| I   | + W + |   I |===========|     £=/               ",
            "y        |  I   |           |     |_______|     |           |   I  |                ",
            "y        |      |           |     |||||||||     |           |      |                ",
            "y        |      |           |   I |rrrrrrry I   |           |      |                ",
            "y_-_-_-_-|______|-----------|_____|r     |y_____|-----------|______|-_-_-_-_        ",
            "c   ~   y________£         /______|r     |y______£         /________£c              ",
            "c      yc_________yc------yc_______yc____yc_______yc------yc_________yc             ",
            "c                                                                                   "};

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
            System.out.println(str);
        }
    }
}

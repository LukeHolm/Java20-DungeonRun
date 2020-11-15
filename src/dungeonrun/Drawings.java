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
            "     _-_-|______|-----------|_____||     ||_____|-----------|______|-_-_            ",
            "        /________£         /______||     ||______£         /________£               ",
            "       |__________|-------|________£_____/________|-------|__________|              "};

        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        for (int row = 0; row < 20; row++) {
            System.out.print(" : " + ascii[row]);
            System.out.println("");
        }
    }

    public static void drawKnight() {
        System.out.println("");
        System.out.println("|\\             //");
        System.out.println(" \\\\           _!_");
        System.out.println("  \\\\         /___\\");
        System.out.println("   \\\\        [+++]");
        System.out.println("    \\\\    _ _\\^^^/_ _");
        System.out.println("     \\\\/ (    '-'  ( )");
        System.out.println("     /( \\/ | {K}   /\\ \\");
        System.out.println("       \\  / \\     / _> )");
        System.out.println("        \"`   >:::;-'`\"\"'-.");
        System.out.println("            /:::/         \\");
        System.out.println("           /  /||   { }   |");
        System.out.println("          (  / (\\         /");
        System.out.println("          / /   \\'-.___.-'");
        System.out.println("        _/ /     \\ \\");
        System.out.println("       /___|    /___|");
        System.out.println("");
    }

    public static void drawWizard() {
        System.out.println("");
        System.out.println("                    ____ ");
        System.out.println("                  .'* *.'");
        System.out.println("               __/_*_*(_");
        System.out.println("              / _______ \\");
        System.out.println("             _\\_)/___\\(_/_ ");
        System.out.println("            / _((\\- -/))_ \\");
        System.out.println("            \\ \\())(-)(()/ /");
        System.out.println("             ' \\(((()))/ '");
        System.out.println("            / ' \\)).))/ ' \\");
        System.out.println("           / _ \\ - | - /_  \\");
        System.out.println("          (   ( .;''';. .'  )");
        System.out.println("          _\\\"__ /    )\\ __\"/_");
        System.out.println("            \\/  \\   ' /  \\/");
        System.out.println("             .'  '...' ' )");
        System.out.println("              / /  |  \\ \\");
        System.out.println("             / .   .   . \\");
        System.out.println("            /   .     .   \\");
        System.out.println("           /   /   |   \\   \\");
        System.out.println("         .'   /    b    '.  '.");
        System.out.println("     _.-'    /     Bb     '-. '-._ ");
        System.out.println(" _.-'       |      BBb       '-.  '-. ");
        System.out.println("(________mrf\\____.dBBBb.________)____)");
        System.out.println("");
    }

    public static void drawThief() {
        System.out.println("");
        System.out.println("        .--._");
        System.out.println("  __   '---._)");
        System.out.println(" \"\")\\   Q Q )");
        System.out.println("  =_/   c  /");
        System.out.println("  | \\_.-;-'-,._");
        System.out.println("  |  '  o---o   )");
        System.out.println("   \\   /H __H\\  /");
        System.out.println("    '-' \\\"\")\\/  |");
        System.out.println("      _ |_='-)_/");
        System.out.println("     /  '.    )");
        System.out.println("    /         /");
        System.out.println("   |___/\\|   /");
        System.out.println("    |_|  |   |");
        System.out.println("   /  )  \\   \\");
        System.out.println("  (__/    \\___\\");
        System.out.println("            \\_\\");
        System.out.println("            /  )");
        System.out.println("           (__/");
        System.out.println("");
    }

}

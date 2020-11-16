package dungeonrun.Characters;

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
            "      ££/ (    '-'  (  )    ",
            "      /( £/ |  _|_  || |    ", // Row 10
            "       £ £/ |   |   /£ £    ",
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
            "    /_____|      /_____|     "};
        //   1234567890123456789012345678

        // Replace '£' with '\' and replace '§' with '"'
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
            ascii[i] = ascii[i].replace("§", "\"");
        }
        return ascii;
    }
}

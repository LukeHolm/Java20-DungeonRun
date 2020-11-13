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
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "                            ",
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
            "            /  /||   { }   |", // Row 215
            "           /  / |£         /",
            "          (  /  ( '-.___.-' ",
            "          / /    £ £        ",
            "         / /      £ £       ",
            "       _/ /        £ £      ", // Row 20
            "      /___|       /___|     "};
        //   1234567890123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}


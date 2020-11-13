package dungeonrun.Characters;;

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
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "                             ",
            "       ___                   ",
            "          /      .--._       ",
            "         |_     '---._)      ",
            "        \"\")£     Q Q )       ", // Two extra chars for "\"
            "         =_/     c  /        ", // Row 5
            "         | £_.---;-'---,._   ",
            "         |£  '  o-----o   )  ",
            "         | £   /H  ___H£  /  ",
            "         |  '-' £\"\")£__/  |  ", // Row 10, Two extra chars for "\"
            "         £     _|__='-)__/   ",
            "              /  '.    £     ",
            "             /         /     ",
            "            |         /      ",
            "            |___/£|   |      ", // Row 15
            "             |_|  |   |      ",
            "            /  )  £   £      ",
            "           (__/    £___£     ",
            "                     £_£     ",
            "                     /  )    ", // Row 20
            "                    (__/     "};
        //   1234567890123456789012345678 
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}

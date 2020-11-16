package dungeonrun.Characters;
public class Thief extends Heroes {

    public Thief(String playersName) {
        super(playersName);
        creatureIsA = "Thief";
        initiative = 7;
        toughness = 5;
        attack = 5;
        agility = 7;
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
                "        |,     Q,Q ,)       ",
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

        // Replace '£' with '\' and replace '§' with '"'
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
            ascii[i] = ascii[i].replace("§", "\"");
        }
        return ascii;
    }
}

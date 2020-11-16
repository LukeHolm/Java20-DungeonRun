package dungeonrun.Monsters;
public class Creatures {
    public String creatureIsA;

    public int initiative;
    public int toughness;
    public int attack;
    public int agility;

    // Returning a String array, so monsters can be written row for row, with other figures further away on each row.
    public String[] displayStrings() {
        String[] ascii = {
                "         _______            ",
                "        /       \\           ",
                "       /         \\          ",
                "       |  O    O  |         ",
                "       \\         /          ",
                "        \\       /           ",
                "       /         \\          ",
                "      /   Just    \\         ",
                "     /  a silly    \\        ",
                "    / figure for    \\       ",
                "   /  test purposes, \\      ",
                "  | will be overridden|     ",
                "   |      ______     |      ",
                "  __|     |    |    |__     ",
                " (_________)  (________)    "};

        String[] fixedAscii = ascii;
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }
        return fixedAscii;
    }

    public int displayHeight(Creatures creature) {
        return creature.displayStrings().length;
    }
}
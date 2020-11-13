package dungeonrun.Monsters;

 
public class Creatures {

    public String creatureIsA;

    public int initiative;
    public int toughness;
    public int attack;
    public int agility;

    // Returning a String array of the heros looks, so characgters can be written row for row, with other figures further away on each row.
    public String[] displayStrings() {
        // Very annoying that backslash "\" must be written twice (it's the escape character)
        // This messes up the rows since they get the wrong length, and doesn't line up with other lines above/under.
        // Here you can use "£" instead so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "         ________     ",
            "        /        £     ",
            "       /          £    ",
            "      |       O  O|    ",
            "      £    E      >     ",
            "       £       d-/     ",
            "       /         <     ",
            "      /   Just    £    ",
            "     /  a silly    £    ",
            "    / figure for    £   ",
            "   / test purposes,  £   ",
            "  | will be overridden|   ",
            "  | in Knight, Wizard |   ",
            "  | Thief.java and    |   ",
            "  | all Monster types |   ",
            "   £      _____      /   ",
            "  __E3   <     >   3E__   ",
            " (________]   [________)   "};

 
        String[] fixedAscii = ascii;

        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }

        return fixedAscii;
    }

    private String[] replaceWithBackslash(Creatures creature) {
        String[] ascii = creature.displayStrings();
        String[] fixedAscii = ascii;

        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }
        return fixedAscii;
    }

    // Mirror the ASCII art for the creature
    public String[] mirroredDisplayStrings(Creatures creature) {

        String[] ascii = creature.displayStrings();
        String[] fixedAscii = ascii.clone();

        for (int row = 0; row < ascii.length; row++) {

            fixedAscii[row] = "";
            char[] chars = ascii[row].toCharArray();
 
            for (int x = displayWidth(creature) - 1; x >= 0; x--) { 

                if (x >= ascii[row].length()) {
                    fixedAscii[row] += " "; // padding with space

                } else {
                    // Translate character

                    switch (chars[x]) {
                        case '(':
                            fixedAscii[row] += ")";
                            break;
                        case ')':
                            fixedAscii[row] += "(";
                            break;
                        case '>':
                            fixedAscii[row] += "<";
                            break;
                        case '<':
                            fixedAscii[row] += ">";
                            break;
                        case 'd':
                            fixedAscii[row] += "b";
                            break;
                        case 'b':
                            fixedAscii[row] += "d";
                            break;
                        case 'E':
                            fixedAscii[row] += "3";
                            break;
                        case '3':
                            fixedAscii[row] += "E";
                            break;
                        case '[':
                            fixedAscii[row] += "]";
                            break;
                        case ']':
                            fixedAscii[row] += "[";
                            break;
                        case '/':
                            fixedAscii[row] += "\\";
                            break;
                        case '\\':
                            fixedAscii[row] += "/";
                            break;
                        default:
                            fixedAscii[row] += chars[x];
                    } // switch
                } // if else
            } // for x
            // Debug: System.out.println("Row " + row + " : " + fixedAscii[row]);
        } // for row

        return fixedAscii;
    }
 

    public int displayWidth(Creatures creature) {

        String[] ascii = creature.displayStrings();
        int maxWidth = 0;

        for (int i = 0; i < ascii.length; i++) {

            if (ascii[i].length() > maxWidth) {
                maxWidth = ascii[i].length();
            }
        }
        return maxWidth;
    }
 

    public int displayHeight(Creatures creature) {

        return creature.displayStrings().length;
    }
}
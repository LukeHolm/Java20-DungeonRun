package dungeonrun.Characters;

import dungeonrun.Map;

public class Wizard extends Heroes {

    public Wizard(String playersName) {
        super(playersName);
        creatureIsA = "Wizard";
        initiative = 6;
        toughness = 4;
        attack = 9;
        agility = 5;
    }

    public void specialAbility() {
        //"Ljussken". Wizard blinds monsters, therefore Wizard always has 80% chance to escape
    }

    @Override
    public String toString() {
        return "Wizard name is " + playersName + "\n";
    }

    @Override
    public String[] displayStrings() {
        // Characters like '\' and '" 'messes upp the line lengths, since you need to write \\ and \" to get them in a string. 
        // Kan use '£' for '\' and '§' for '"' here, because of the replacement code below.
        String[] ascii = {
            "               _----_       ",
            "             .'* *.-.£      ",
            "           _/ * *(   ££     ",
            "          /*_*_*_*£   O     ",
            "        _|_//___££_|_       ", // Row 5
            "       / _((£- -/))_ £      ",
            "       £ £())(-)(()/ /      ",
            "        ' £(((()))/ '       ",
            "       / ' £)).))/ ' £      ",
            "      / _ £ - | - /_  £     ", // Row 10
            "     (   ( .;''';. .'  )    ",
            "     _£§__ /    )£ __§/_    ",
            "       £/  £   ' /  £/      ",
            "        .'  '...' ' )       ",
            "         /  / | £  £        ", // Row 15
            "        /  .  .  .  £       ",
            "       /   .     .   £      ",
            "      /   /   |   £   £     ",
            "    .'   /    b    '.  '.   ",
            " _.'   /     db     '.  '._ ", // Row 20
            "(___rf£____.dBBb._____)____)"};
        //   1234567890123456789012345678
        String[] color = {
            "               m____        ",
            "             m'y *m-mm      ",
            "           mm_ymym_  ££     ",
            "          mymymymym£  m     ",
            "        _m_)z___£m_/g       ", // Row 5
            "       / _w(zy yzw)g £      ",
            "       £ £w))(sw(()g /      ",
            "        ' £w((()))g '       ",
            "       / ' £w).))g ' £      ",
            "      / _ £ - | - /_  £     ", // Row 10
            "     (   ( m;''';. g'  )    ",
            "     _£§__ m    )£ g_§/_    ",
            "       £/  m   ' /  g/      ",
            "        .'  m...' g )       ",
            "         /  / | £  £        ", // Row 15
            "        /  .  .  .  £       ",
            "       /   .     .   £      ",
            "      /   /   |   £   £     ",
            "    .'   /    h  g '.  '.   ",
            " _.'   /     hB  g '.   '._ ", // Row 20
            "(___RF£____.hBBBg_____)____)"};
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

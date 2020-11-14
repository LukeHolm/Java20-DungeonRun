package dungeonrun.Characters;

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
            "               _____        ",
            "             .'* *.=o.      ",
            "          __/_*_*(_  ££     ",
            "         / _______ £  O     ",
            "        _£_)/___£(_/_       ", // Row 5
            "       / _((£- -/))_ £      ",
            "       £ £())(=)(()/ /      ",
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

        // Replace '£' with '\' and replace '§' with '"'
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
            ascii[i] = ascii[i].replace("§", "\"");
        }
        return ascii;
    }
}

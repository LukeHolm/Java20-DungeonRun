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
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
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
            "      / _ £ - | - /_  £     ",  // Row 10
            "     (   ( .;''';. .'  )    ",
            "     _£\"__ /    )£ __\"/_    ", // Two extra chats due to '\'
            "       £/  £   ' /  £/      ",
            "        .'  '...' ' )       ",
            "         /  / | £  £        ",  // Row 15
            "        /  .  .  .  £       ",
            "       /   .     .   £      ",
            "      /   /   |   £   £     ",
            "    .'   /    b    '.  '.   ",
            " _.'   /     db     '.  '._ ",  // Row 20
            "(___rf£____.dBBb._____)____)"};

        //   1234567890123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}

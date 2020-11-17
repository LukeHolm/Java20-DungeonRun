package dungeonrun.Monsters;

import dungeonrun.Map;

public class Skeleton extends Monster {

    public Skeleton() {
        creatureIsA = "Skeleton";

        initiative = 4;
        toughness = 2;
        attack = 3;
        agility = 3;
        frequency = 0.15;         //frequency = 15%
    }

    @Override
    public String toString() {
        return "Skeleton";
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "                            ",
            "           ___              ",
            "         /     £            ",
            "         { O,O }            ",
            "          |`m´|             ", //row 5
            "          `-.-´             ",
            "         ___|___            ",
            "       / .==|==. £          ",
            "      /  .==|==.  £         ",
            "     8   .==|==.   8        ", //row 10
            "     |   .==|==.   |        ",
            "     |    __|__    |        ",
            "     #   ( ___ )   #        ",
            "     M   o££_//o   M        ",
            "         £     /   ______   ", //row 15
            "         |     |  /      £  ",
            "         |     | |        | ",
            "         8     8 | R.I.#  | ",
            "         |     | | MCMXLV | ",
            "         |     | |        | ",//row 20
            "       ==='   '===§§§§§§§§§ "};
        //   1234567890123456789012345678

        String[] color = {
            "                            ",
            "           ___              ",
            "         /     £            ",
            "         { yry r            ",
            "          |`*´|             ", //row 5
            "          `-.-´             ",
            "         ___|___            ",
            "       / .==|==. £          ",
            "      /  .==|==.  £         ",
            "     8   .==|==.   8        ", //row 10
            "     |   .==|==.   |        ",
            "     |    __|__    |        ",
            "     #   ( ___ )   #        ",
            "     M   *££_//*   M        ",
            "         £     /   m_____   ", //row 15
            "         |     |  m      £  ",
            "         |     | m        | ",
            "         8     8 m R.I.e  m ",
            "         |     | m MCMXLV | ",
            "         |     | m        | ",//row 20
            "       ==='   '===h§§§§§§§§ "};
        //   1234567890123456789012345678
        
        // Replace "£" with "\"
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

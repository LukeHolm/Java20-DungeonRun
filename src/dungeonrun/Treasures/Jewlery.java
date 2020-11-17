package dungeonrun.Treasures;

import dungeonrun.Map;

public class Jewlery extends Treasure {

    public Jewlery() {
        treasureDescription = "some golden jewlery";
        name = "jewlery";
        value = 10;
        frequency = 0.15;
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "     £  |  /      ",
            "   £  _____  /    ", // 2
            "      £/ £/       ", 
            "     __£_/__      ", // 4
            "    /.-----.£     ",
            "  //         ££   ", // 6
            " ||           ||  ",
            "  ££         //   ", // 7
            "   ££_______//    ",
            "    `-------´     "};// 10
        //   123456789012345678
        
         String[] colors = {
            "     w  |  /      ",
            "   w  c____  w    ", // 2
            "      c/ £/       ", 
            "     __cycy_      ", // 4
            "    /.-----.£     ",
            "  //         ££   ", // 6
            " ||           ||  ",
            "  ££         //   ", // 7
            "   ££_______//    ",
            "    `-------´     "};// 10
        //   123456789012345678
        
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
                chr = colors[row].charAt(x);

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
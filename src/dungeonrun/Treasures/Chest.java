package dungeonrun.Treasures;

import dungeonrun.Map;

public class Chest extends Treasure {

    public Chest() {
        treasureDescription = "a small treasure chest";
        name = "small treasure chest";
        value = 20;
        frequency = 0.02;        //frequency = 20%
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "                  ",
            "                  ", // 2
            "  ,------------,  ",
            " /______d_____/ £ ", // 4
            " £    £   /   £  )",
            "  £_£___db___/_£.'", // 6
            " ,----/888£----,| ",
            "|=='==8==='==|' | ", // 8
            "|    (d)     |  | ",
            "|            | _' ",
            "|------------|'   "}; // 10
        //   123456789012345678

        String[] colors = {
             "                  ",
            "                  ", // 2
            "  ,------------,  ",
            " /______ry____/ £ ", // 4
            " £    w   /   y  )",
            "  £_wy__yb___wyy.'", // 6
            " ,----/888£----,| ",
            "|=='==8==='==|' | ", // 8
            "|    rrr     y  | ",
            "|            | _' ",
            "|------------|'   "}; // 10
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


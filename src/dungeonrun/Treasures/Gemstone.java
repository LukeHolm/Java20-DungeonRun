/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonrun.Treasures;

import dungeonrun.Map;

/**
 *
 * @author lucas
 */
public class Gemstone extends Treasure {

    public Gemstone() {
        treasureDescription = "a shiny gemstone";
        name = "gemstone";
        value = 14;
        frequency = 0.1;
    }
    // Returning a String array of the treaasiures looks, so characters can be written row for row, with other things further away on each row.

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "                  ",
            "                  ", // 2           
            "   £  |  |  |  /  ",
            "£  ____________  /", // 4
            "  /£  /£  /£  /£  ",
            " / .£/..£/..£/ .£ ", // 6
            "  £  £ |  | /  /  ",
            "    £ £ || / /    ", // 8
            "      ££||//      ",
            "        £/        "}; // 10
        //   123456789012345678      
        
        String[] colors = {
            "                  ",
            "                  ", // 2           
            "   w  |  |  |  /  ",
            "w  y___________  w", // 4
            "  /£  /£  /£  /£  ",
            " / .£/..£/..£/ .£ ", // 6
            "  £  £ |  | /  /  ",
            "    £ £ || / /    ", // 8
            "      ££||//      ",
            "        £/        "}; // 10
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
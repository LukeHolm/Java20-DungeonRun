/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonrun.Treasures;

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
            " £ ____________  /", // 4
            "  /£  /£  /£  /£  ",
            " / .£/..£/..£/ .£ ", // 6
            "  £  £ |  | /  /  ",
            "    £ £ || / /    ", // 8
            "      ££||//      ",
            "        £/        "}; // 10
        //   123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}

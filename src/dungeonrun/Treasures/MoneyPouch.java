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
public class MoneyPouch extends Treasure {

    public MoneyPouch() {
        treasureDescription = "a small money pouch";
        name = "money pouch";
        value = 6;
        frequency = 0.2;
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "      £----/      ",
            "      _)==(_      ", // 2
            "     /      £     ",
            "   /   _|_    £   ", // 4
            "  /   (_|_     £  ",
            " /    ._|_)     £ ", // 6
            "|       |        |",
            " £______________/ "};// 8
        //   123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}

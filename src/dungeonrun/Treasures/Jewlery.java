package dungeonrun.Treasures;

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
            "   ____           ",
            "   £  /      __   ", // 2
            "  __£/__     £/   ",
            " //----££  //==££ ", // 4
            "||      ||||    ||",
            "||      ||||    ||", // 6
            " ££____//  ££__// ",
            "   ----      --   "};// 8
        //   123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }

}
